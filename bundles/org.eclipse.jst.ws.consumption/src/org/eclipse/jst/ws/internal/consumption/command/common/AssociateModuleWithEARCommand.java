package org.eclipse.jst.ws.internal.consumption.command.common;

import org.eclipse.core.resources.IProject;
import org.eclipse.jem.util.emf.workbench.ProjectUtilities;
import org.eclipse.jst.ws.internal.common.J2EEUtils;
import org.eclipse.jst.ws.internal.consumption.plugin.WebServiceConsumptionPlugin;
import org.eclipse.wst.command.internal.provisional.env.core.SimpleCommand;
import org.eclipse.wst.command.internal.provisional.env.core.common.Environment;
import org.eclipse.wst.command.internal.provisional.env.core.common.MessageUtils;
import org.eclipse.wst.command.internal.provisional.env.core.common.SimpleStatus;
import org.eclipse.wst.command.internal.provisional.env.core.common.Status;

public class AssociateModuleWithEARCommand extends SimpleCommand
{
	private String project_;
	private String module_;
	private String earProject_;
	private String ear_;
	
	private MessageUtils msgUtils_;
  
  public AssociateModuleWithEARCommand(){
	    msgUtils_ = new MessageUtils(WebServiceConsumptionPlugin.ID + ".plugin", this);
  }
  
	public Status execute(Environment env)
	{
		Status status = new SimpleStatus("");
		IProject moduleProject = null;
		IProject earProject = null;

		// get projects
		if (project_!=null)
			moduleProject = ProjectUtilities.getProject(project_);
		if (earProject_!=null)
			earProject = ProjectUtilities.getProject(earProject_);
		
		// associate modules if not already associated
		if (moduleProject!=null && earProject!=null) {
			if (!J2EEUtils.isComponentAssociated(earProject, ear_, moduleProject, module_))
				J2EEUtils.associateComponentToEAR(moduleProject, module_, earProject, ear_);
		}
		
		// ensure modules are associated otherwise report error
		if (!J2EEUtils.isComponentAssociated(earProject, ear_, moduleProject, module_)){
			status = new SimpleStatus("", msgUtils_.getMessage("MSG_ERROR_UNABLE_TO_ASSOCIATE", new String[]{module_, ear_}), Status.ERROR);
			if (env!=null)
				env.getStatusHandler().reportError(status);
		    return status; 
		}
		
		return status;
	}
	
  public void setProject( String project )
  {
	  project_ = project;
  }
	  
  public void setModule( String module )
  {
	  module_ = module;
  }	
	
  public void setEARProject( String earProject )
  {
	  earProject_ = earProject;
  }
  
  public void setEar( String ear )
  {
	  ear_ = ear;  
  }	
}
