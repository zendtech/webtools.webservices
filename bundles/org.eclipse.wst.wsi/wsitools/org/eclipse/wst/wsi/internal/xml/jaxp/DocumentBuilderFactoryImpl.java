/*******************************************************************************
 * Copyright (c) 2002-2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *******************************************************************************/
package org.eclipse.wst.wsi.internal.xml.jaxp;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.util.Hashtable;

/**
 * This class defines a factory API that enables us to obtain a parser
 * that produces DOM object trees from XML documents. Note this class 
 * specializes javax.xml.parsers.DocumentBuilderFactory.
 * 
 * @author Peter  Brittenham (peterbr@us.ibm.com)
 * @version 1.0.1
 */
public class DocumentBuilderFactoryImpl extends DocumentBuilderFactory
{

  protected Hashtable attributes = new Hashtable();

  /**
   * Creates a new instance of a DocumentBuilder using the currently 
   * configured parameters.
   * 
   * @return a new instance of a DocumentBuilder. 
   * @throws ParserConfigurationException if a DocumentBuilder cannot
   *         be created which satisfies the configuration requested.
   */
  public DocumentBuilder newDocumentBuilder()
    throws ParserConfigurationException
  {
    DocumentBuilder documentBuilder = null;

    try
    {
      documentBuilder = new DocumentBuilderImpl(this, attributes);
    }

    catch (Exception e)
    {
      throw new ParserConfigurationException(e.getMessage());
    }

    return documentBuilder;
  }

  /**
   * Allows the user to retrieve specific attributes on the underlying 
   * implementation.
   * 
   * @param name  the name of the attribute.
   * @return the value of the attribute. 
   * @throws IllegalArgumentException f the underlying implementation 
   *         doesn't recognize the attribute.
   */
  public Object getAttribute(String name) throws IllegalArgumentException
  {
    return attributes.get(name);
  }

  /**
   * Allows the user to set specific attributes on the underlying 
   * implementation. 
   * 
   * @param name   the name of the attribute.
   * @param value  the value of the attribute.
   * @throws IllegalArgumentException if the underlying implementation 
   *         doesn't recognize the attribute.
   */
  public void setAttribute(String name, Object value)
    throws IllegalArgumentException
  {
    attributes.put(name, value);
  }
}
