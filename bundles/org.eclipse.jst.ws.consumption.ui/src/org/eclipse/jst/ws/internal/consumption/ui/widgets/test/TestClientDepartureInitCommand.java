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
/*
 * Created on Mar 25, 2004
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.eclipse.jst.ws.internal.consumption.ui.widgets.test;

import org.eclipse.wst.command.internal.provisional.env.core.AbstractDataModelOperation;

/**
 * @author gilberta
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class TestClientDepartureInitCommand extends AbstractDataModelOperation 
{
  
  private boolean forceBuild;	
	
  public TestClientDepartureInitCommand()
  {
  	forceBuild = true;
  }

  public boolean getForceBuild()
  {
  	return forceBuild;
  }
  
}
