/*******************************************************************************
 * Copyright (c) 2001, 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package org.eclipse.wst.ws.internal.explorer.platform.perspective;

import org.eclipse.wst.ws.internal.explorer.platform.constants.ToolTypes;

public abstract class ActionTool extends Tool
{
  public ActionTool(ToolManager toolManager,String enabledImageLink,String highlightedImageLink,String alt)
  {
    super(toolManager,enabledImageLink,highlightedImageLink,alt,ToolTypes.ACTION);
  }

  public String getFormLink()
  {
    return null;
  }
}
