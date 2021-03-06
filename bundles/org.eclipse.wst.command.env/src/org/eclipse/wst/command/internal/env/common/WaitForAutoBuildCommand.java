/*******************************************************************************
 * Copyright (c) 2004, 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.wst.command.internal.env.common;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.wst.common.frameworks.datamodel.AbstractDataModelOperation;

/**
 * @deprecated We should not depend on the auto build to build projects, since auto build might be off.
 * Try using BuildBeanCommand or BuildProjectCommand to build the project instead. Also, the join() call 
 * can lead to deadlock in some situations.
 * @see org.eclipse.jst.ws.internal.consumption.command.common.BuildBeanCommand
 * @see org.eclipse.jst.ws.internal.consumption.command.common.BuildProjectCommand
*/ 
public class WaitForAutoBuildCommand extends AbstractDataModelOperation
{
  public IStatus execute( IProgressMonitor montitor, IAdaptable adaptable ) 
  {
  	IStatus status = Status.OK_STATUS;
  	
	try 
	{
	  Platform.getJobManager().join(ResourcesPlugin.FAMILY_AUTO_BUILD, null);
	} 
	catch( InterruptedException exc ) 
	{
	  // UISynchronizer.syncExec seems to interrupt the UI tread when the autobuilder is done.  Not sure, why.
	  // I'm assuming here that the autobuilder has actually completed its stuff.	
	}
		
	return status;
  }
}
