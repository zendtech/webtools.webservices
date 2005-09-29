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
package org.eclipse.wst.command.internal.env.eclipse;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.wst.command.internal.env.core.uri.file.FileScheme;
import org.eclipse.wst.command.internal.provisional.env.core.CommandManager;
import org.eclipse.wst.command.internal.provisional.env.core.common.Log;
import org.eclipse.wst.command.internal.provisional.env.core.common.NullStatusHandler;
import org.eclipse.wst.command.internal.provisional.env.core.common.StatusHandler;
import org.eclipse.wst.command.internal.provisional.env.core.context.ResourceContext;
import org.eclipse.wst.command.internal.provisional.env.core.uri.SimpleURIFactory;
import org.eclipse.wst.command.internal.provisional.env.core.uri.URIFactory;


/**
 *  This class is intended for use in a headless Eclipse environment.  
 */
public class ConsoleEclipseEnvironment implements BaseEclipseEnvironment
{
	private CommandManager    commandManager_  = null;
	private SimpleURIFactory  uriFactory_      = null;
	private ResourceContext   resourceContext_ = null;
	private StatusHandler     statusHandler_   = null;
	  
	public ConsoleEclipseEnvironment( ResourceContext resourceContext )
	{
	  this( null, resourceContext, new NullStatusHandler() );	
	}
	
	public ConsoleEclipseEnvironment( CommandManager  commandManager, 
	                                  ResourceContext resourceContext,
					                          StatusHandler   statusHandler )
	{
	  commandManager_  = commandManager;
	  resourceContext_ = resourceContext;
	  uriFactory_      = new SimpleURIFactory();
	  statusHandler_   = statusHandler;
	    
	  uriFactory_.registerScheme( "platform", new EclipseScheme( this, new NullProgressMonitor() ) );
	  uriFactory_.registerScheme( "file", new FileScheme() );
	}

	/* (non-Javadoc)
	 * @see org.eclipse.wst.command.internal.env.eclipse.BaseEclipseEnvironment#getResourceContext()
	 */
	public ResourceContext getResourceContext() 
	{
		return resourceContext_;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.wst.command.internal.provisional.env.core.common.Environment#getCommandManager()
	 */
	public CommandManager getCommandManager() 
	{
		return commandManager_;
	}
		
	/* (non-Javadoc)
	 * @see org.eclipse.wst.command.internal.provisional.env.core.common.Environment#getLog()
	 */
	public Log getLog() 
	{
		return new EclipseLog();
	}
		
	/* (non-Javadoc)
	 * @see org.eclipse.wst.command.internal.provisional.env.core.common.Environment#getStatusHandler()
	 */
	public StatusHandler getStatusHandler() 
	{
		return statusHandler_;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.wst.command.internal.provisional.env.core.common.Environment#getURIFactory()
	 */
	public URIFactory getURIFactory() 
	{
		return uriFactory_;
	}
}
