/*******************************************************************************
 * Copyright (c) 2002, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.wst.ws.internal.explorer.platform.wsdl.fragment;

import java.util.Hashtable;
import org.eclipse.xsd.XSDTypeDefinition;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Document;


public interface IXSDFragment extends IFragment {
  public void setXSDToFragmentConfiguration(XSDToFragmentConfiguration config);
  public XSDToFragmentConfiguration getXSDToFragmentConfiguration();

  public void setXSDTypeDefinition(XSDTypeDefinition typeDef);
  public XSDTypeDefinition getXSDTypeDefinition();
  public Element setAttributesOnInstanceDocuments(Element instanceDocument,String name);
  public boolean setAttributeParamsFromInstanceDocuments (Node attribute);
  public boolean setParameterValuesFromInstanceDocuments(Element[] instanceDocuments);
  public Element[] genInstanceDocumentsFromParameterValues(boolean genXSIType, Hashtable namespaceTable, Document doc);

  public String genID();
}
