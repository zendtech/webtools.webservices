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
package org.eclipse.wst.wsi.internal.profile.validator;

import org.eclipse.wst.wsi.internal.WSIException;
import org.eclipse.wst.wsi.internal.analyzer.AnalyzerContext;
import org.eclipse.wst.wsi.internal.profile.ProfileArtifact;
import org.eclipse.wst.wsi.internal.report.ReportArtifact;
import org.eclipse.wst.wsi.internal.report.Reporter;
import org.eclipse.wst.wsi.internal.wsdl.WSDLDocument;

/**
 * Interface definition for envelope validation test procedure.
 *
 * @version 1.0
 */
public interface EnvelopeValidator extends BaseValidator
{

  /**
   * Initiailize validation test procedure.
   * @param analyzerContext the analyzerContext.
   * @param artifact        an profile artifact.
   * @param reportArtifact  the report artifact.
   * @param wsdlDocument the Web service definition
   * @param reporter the reporter which is used to add errors to the conformance report
   * @throws WSIException if message validator could not be initialized.
   */
  public void init(
    AnalyzerContext analyzerContext,
    ProfileArtifact artifact,
    ReportArtifact reportArtifact,
    WSDLDocument wsdlDocument,
    Reporter reporter)
    throws WSIException;

  /**
   * Validate the envelope located by the log entry. 
   * @param entryContext a log entry locating an envelope.
   * @throws WSIException if an unexpected error occurred while
   *         processing the log entry.
   */
  public void validate(EntryContext entryContext) throws WSIException;
}