/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package org.eclipse.jst.ws.internal.creation.ui.extension;

import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jem.util.emf.workbench.ProjectUtilities;
import org.eclipse.jst.j2ee.internal.J2EEVersionConstants;
import org.eclipse.jst.ws.internal.common.J2EEUtils;
import org.eclipse.jst.ws.internal.consumption.command.common.CreateFacetedProjectCommand;
import org.eclipse.jst.ws.internal.consumption.command.common.CreateModuleCommand;
import org.eclipse.jst.ws.internal.consumption.common.FacetMatcher;
import org.eclipse.jst.ws.internal.consumption.common.FacetUtils;
import org.eclipse.jst.ws.internal.consumption.common.RequiredFacetVersion;
import org.eclipse.jst.ws.internal.consumption.ui.wsrt.WebServiceRuntimeExtensionUtils2;
import org.eclipse.jst.ws.internal.data.TypeRuntimeServer;
import org.eclipse.wst.command.internal.env.core.context.ResourceContext;
import org.eclipse.wst.common.componentcore.internal.util.IModuleConstants;
import org.eclipse.wst.common.environment.IEnvironment;
import org.eclipse.wst.common.frameworks.datamodel.AbstractDataModelOperation;
import org.eclipse.wst.ws.internal.wsrt.IContext;
import org.eclipse.wst.ws.internal.wsrt.ISelection;
import org.eclipse.wst.ws.internal.wsrt.IWebService;
import org.eclipse.wst.ws.internal.wsrt.IWebServiceRuntime;
import org.eclipse.wst.ws.internal.wsrt.SimpleContext;
import org.eclipse.wst.ws.internal.wsrt.WebServiceInfo;
import org.eclipse.wst.ws.internal.wsrt.WebServiceScenario;
import org.eclipse.wst.ws.internal.wsrt.WebServiceState;

public class PreServiceDevelopCommand extends AbstractDataModelOperation 
{
  private TypeRuntimeServer typeRuntimeServer_;
  private String            serviceRuntimeId_;
  private IContext          context_;
  private ISelection        selection_;
	private String						project_;
  private String            module_;
  private String			      moduleType_;
	private String						earProject_;
  private String            ear_;
	
  private IWebService       webService_;
  private String            j2eeLevel_;
  private ResourceContext   resourceContext_;
  
  private boolean run_;
  private boolean client_;
  private boolean test_;
  private boolean publish_;
  

  public IStatus execute( IProgressMonitor monitor, IAdaptable adaptable )
  {
    IEnvironment environment = getEnvironment();
	  
    // Split up the project and module
    int index = module_.indexOf("/");
    if (index!=-1){
      project_ = module_.substring(0,index);
      module_ = module_.substring(index+1);
    }

    if (ear_!=null && ear_.length()>0)
    {
      int earIndex = ear_.indexOf("/");
      if (earIndex!=-1) {
        earProject_ = ear_.substring(0,earIndex);
        ear_ = ear_.substring(earIndex+1);
      }
    }
    
    
	  IWebServiceRuntime wsrt   = WebServiceRuntimeExtensionUtils2.getServiceRuntime( serviceRuntimeId_ );
	  WebServiceInfo     wsInfo = new WebServiceInfo();

	  System.out.println( "In Pre service develop command." );
	
	  wsInfo.setServerFactoryId( typeRuntimeServer_.getServerId() );
      wsInfo.setServerInstanceId( typeRuntimeServer_.getServerInstanceId());
	  wsInfo.setState( WebServiceState.UNKNOWN_LITERAL );
	  wsInfo.setWebServiceRuntimeId( typeRuntimeServer_.getRuntimeId() );
    
		webService_  = wsrt.getWebService( wsInfo );
	
		//Set up the IContext
		WebServiceScenario scenario = null;
    int scenarioInt = WebServiceRuntimeExtensionUtils2.getScenarioFromTypeId(typeRuntimeServer_.getTypeId());
    if (scenarioInt == WebServiceScenario.BOTTOMUP)
		{
			scenario = WebServiceScenario.BOTTOMUP_LITERAL;
      String impl = (String)(selection_.getSelection())[0];
      wsInfo.setImplURL(impl);
		}
    else if (scenarioInt == WebServiceScenario.TOPDOWN)
		{
		  scenario = WebServiceScenario.TOPDOWN_LITERAL;
      String wsdlURL = (String)(selection_.getSelection())[0];
      wsInfo.setWsdlURL(wsdlURL);      
		}
	
		context_     = new SimpleContext(true, true, true, true, run_, client_, test_, publish_, 
																		scenario, 
																		resourceContext_.isOverwriteFilesEnabled(),
																		resourceContext_.isCreateFoldersEnabled(),
																		resourceContext_.isCheckoutFilesEnabled());

        IStatus status = Status.OK_STATUS;

        // Create the service module if needed.
        IProject project = ProjectUtilities.getProject(project_);
        if (!project.exists())
        {
          RequiredFacetVersion[] rfv = WebServiceRuntimeExtensionUtils2.getServiceRuntimeDescriptorById(serviceRuntimeId_).getRequiredFacetVersions();
          Set facetVersions = FacetUtils.getInitialFacetVersionsFromTemplate(moduleType_);
          FacetMatcher fm = FacetUtils.match(rfv, facetVersions);
          if (fm.isMatch())
          {  
            CreateFacetedProjectCommand command = new CreateFacetedProjectCommand();
            command.setProjectName(project_);
            command.setTemplateId(moduleType_);
            command.setRequiredFacetVersions(rfv);
            command.setServerFactoryId(typeRuntimeServer_.getServerId());
            command.setServerInstanceId(typeRuntimeServer_.getServerInstanceId());
            //command.setFacetMatcher(fm);
            status = command.execute( monitor, adaptable );
            if (status.getSeverity() == Status.ERROR)
            {
              environment.getStatusHandler().reportError( status );
            }        
          }            
        }
        else
        {
          //TODO add the necessary facets
        }        
        
        //Create the service module
		//rsk todo -- pick the correct module type based on the Web service type, it's hard coded to WEB for now.
/*        
		int intModuleType = convertModuleType(moduleType_);
		

	      CreateModuleCommand command = new CreateModuleCommand();
		  command.setProjectName(project_);
		  command.setModuleName(module_);			
		  command.setModuleType(intModuleType);
		  command.setServerFactoryId(typeRuntimeServer_.getServerId());
		  command.setServerInstanceId(typeRuntimeServer_.getServerInstanceId());
		  command.setJ2eeLevel(j2eeLevel_);
      command.setEnvironment(environment);
		  IStatus status = command.execute( monitor, null);
*/
	  return status;				
  }
  
  private String getJ2EELevelFromExistingProject()
  {
    IProject project = ProjectUtilities.getProject(project_);
    if (project != null && project.exists())
    {
          //If the project has the "jst.web", "jst.ejb", or "jst.appclient" facet, deduce a J2EE version.
          int j2eeLevelInt = J2EEUtils.getJ2EEVersion(project);
          if (j2eeLevelInt != -1)
          {
            return String.valueOf(j2eeLevelInt);                    
          }
    }
    
    //TODO Figure out the J2EE version from the facets to add to a project.
    return String.valueOf(J2EEVersionConstants.J2EE_1_4_ID); //for now, just return something
  }
  
  private int convertModuleType(String type)
  {
	  if (type.equals(IModuleConstants.JST_WEB_MODULE))
	  {
		  return CreateModuleCommand.WEB;
	  }
	  else if (type.equals(IModuleConstants.JST_EJB_MODULE))
	  {
		  return CreateModuleCommand.EJB;
	  }
	  else if (type.equals(IModuleConstants.JST_APPCLIENT_MODULE))
	  {
		  return CreateModuleCommand.APPCLIENT;
	  }
	  else if (type.equals(IModuleConstants.JST_EAR_MODULE))
	  {
		  return CreateModuleCommand.EAR;
	  }	  
	  else
	  {
		  return -1;
	  }
  }
  
  public void setServiceTypeRuntimeServer( TypeRuntimeServer typeRuntimeServer )
  {
	  typeRuntimeServer_ = typeRuntimeServer;  
  }
  
  public void setServiceRuntimeId(String id)
  {
    serviceRuntimeId_ = id;
  }
	  
  public void setServiceJ2EEVersion( String j2eeLevel )
  {
	j2eeLevel_ = j2eeLevel;  
  }
  
  public String getJ2eeLevel()
  {
	  return j2eeLevel_;  
  }
	
  public IWebService getWebService()
  {
	return webService_;  
  }
  
  public IContext getContext()
  {
    return context_;
  }
  
  public void setResourceContext( ResourceContext resourceContext )
  {
    resourceContext_ = resourceContext;	  
  }
  
  public ISelection getSelection()
  {
    return selection_;	  
  }
  
  public void setSelection( ISelection selection )
  {
	selection_ = selection;  
  }
  
  public String getProject()
  {
    return project_;	  
  }
	 
  public String getModule()
  {
    return module_;	  
  }
	
  public void setModule( String module )
  {
	  module_ = module;
  }
  
  public void setModuleType(String type)
  {
	  moduleType_ = type;
  }
	
  public String getEarProject()
  {
    return earProject_;	  
  }
	
  public String getEar()
  {
	  return ear_;  
  }
  
  public void setEar( String ear )
  {
	  ear_ = ear;  
  }
  
	public void setStartService(boolean startService)
	{
		run_ = startService;
	}
	
	public void setTestService(boolean testService)
	{
		test_ = testService;
	}	
	
  public void setPublishService(boolean publishService)
  {
    publish_ = publishService;
  }
	
  public void setGenerateProxy(boolean genProxy)
  {
    client_ = genProxy;  
  }	
	

}
