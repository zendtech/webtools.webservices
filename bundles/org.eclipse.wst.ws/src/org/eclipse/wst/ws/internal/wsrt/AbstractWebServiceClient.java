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

package org.eclipse.wst.ws.internal.wsrt;

import org.eclipse.wst.command.internal.env.core.ICommandFactory;
import org.eclipse.wst.common.environment.IEnvironment;


public abstract class AbstractWebServiceClient implements IWebServiceClient {
	
	private WebServiceClientInfo info;

	public AbstractWebServiceClient(WebServiceClientInfo info) {
		this.info = info;
	}
	

	public WebServiceClientInfo getWebServiceClientInfo() {
		return info;
	}

	public abstract ICommandFactory assemble(IEnvironment env, IContext ctx, ISelection sel,
      String project, String earProject);
	

	public abstract ICommandFactory deploy(IEnvironment env, IContext ctx, ISelection sel,
      String project, String earProject);
	

	public abstract ICommandFactory develop(IEnvironment env, IContext ctx, ISelection sel,
      String project, String earProject);
		

	public abstract ICommandFactory install(IEnvironment env, IContext ctx, ISelection sel,
      String project, String earProject);
	

	public abstract ICommandFactory run(IEnvironment env, IContext ctx, ISelection sel,
      String project, String earProject);
}

