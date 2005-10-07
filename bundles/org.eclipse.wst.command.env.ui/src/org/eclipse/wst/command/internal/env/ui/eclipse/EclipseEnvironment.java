/*******************************************************************************
 * Copyright (c) 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.wst.command.internal.env.ui.eclipse;

import org.eclipse.wst.command.internal.env.eclipse.BaseEclipseEnvironment;
import org.eclipse.wst.command.internal.provisional.env.core.CommandManager;
import org.eclipse.wst.command.internal.provisional.env.core.context.ResourceContext;
import org.eclipse.wst.common.environment.EnvironmentService;
import org.eclipse.wst.common.environment.Log;
import org.eclipse.wst.common.environment.StatusHandler;
import org.eclipse.wst.common.environment.uri.SimpleURIFactory;
import org.eclipse.wst.common.environment.uri.URIFactory;
import org.eclipse.wst.common.environment.uri.URIScheme;


/**
 * This class implements an Environment class for the Eclipse Environment.
 * This Environment currently supports the "platform" protocol and the "file"
 * protocol.
 *
 */
public class EclipseEnvironment implements BaseEclipseEnvironment
{
  private CommandManager   commandManager_  = null;
  private SimpleURIFactory uriFactory_      = null;
  private ResourceContext  resourceContext_ = null;
  private StatusHandler    statusHandler_   = null;
  private Log              logger_          = null;
  
  public EclipseEnvironment( CommandManager  commandManager, 
 		                         ResourceContext resourceContext,
						                 StatusHandler   statusHandler )
  {
    URIScheme eclipseScheme = EnvironmentService.getEclipseScheme( this );
    URIScheme fileScheme    = EnvironmentService.getFileScheme();
    
    commandManager_  = commandManager;
    resourceContext_ = resourceContext;
    uriFactory_      = new SimpleURIFactory();
    statusHandler_   = statusHandler;
    
    uriFactory_.registerScheme( "platform", eclipseScheme );
    uriFactory_.registerScheme( "file", fileScheme );
  }
  
  /**
   * @see org.eclipse.wst.command.internal.provisional.env.core.common.Environment#getCommandManager()
   */
  public CommandManager getCommandManager()
  {
    return commandManager_;
  }

  /**
   * @see org.eclipse.wst.command.internal.provisional.env.core.common.Environment#getLog()
   */
  public Log getLog()
  {
	  if( logger_ == null )
    {  
      logger_ = EnvironmentService.getEclipseLog(); 
    };
	
    return logger_;
  }

  /**
   * 
   * @param logger the new logger for this environment.
   */
  public void setLog( Log logger )
  {
	logger_ = logger;  
  }
   
  /**
   * @see org.eclipse.wst.command.internal.provisional.env.core.common.Environment#getStatusHandler()
   */
  public StatusHandler getStatusHandler()
  {
    return statusHandler_;
  }

  /** (non-Javadoc)
   * @see org.eclipse.wst.command.internal.provisional.env.core.common.Environment#getURIFactory()
   */
  public URIFactory getURIFactory()
  {
    return uriFactory_;
  }

  /**
   * @return returns a ResourceContext for this Environment.
   */
  public ResourceContext getResourceContext()
  {
    return resourceContext_;
  }
  
  public void setCommandManager( CommandManager manager )
  {
	commandManager_ = manager;  
  }
}
