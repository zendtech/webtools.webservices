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
package org.eclipse.wst.wsi.internal.document.impl;

import org.eclipse.wst.wsi.internal.analyzer.config.AnalyzerConfig;
import org.eclipse.wst.wsi.internal.analyzer.config.AnalyzerConfigReader;
import org.eclipse.wst.wsi.internal.analyzer.config.impl.AnalyzerConfigImpl;
import org.eclipse.wst.wsi.internal.analyzer.config.impl.AnalyzerConfigReaderImpl;
import org.eclipse.wst.wsi.internal.document.DocumentFactory;
import org.eclipse.wst.wsi.internal.log.Log;
import org.eclipse.wst.wsi.internal.log.LogReader;
import org.eclipse.wst.wsi.internal.log.LogWriter;
import org.eclipse.wst.wsi.internal.log.impl.LogImpl;
import org.eclipse.wst.wsi.internal.log.impl.LogReaderImpl;
import org.eclipse.wst.wsi.internal.log.impl.LogWriterImpl;
import org.eclipse.wst.wsi.internal.profile.ProfileAssertions;
import org.eclipse.wst.wsi.internal.profile.ProfileAssertionsReader;
import org.eclipse.wst.wsi.internal.profile.impl.ProfileAssertionsImpl;
import org.eclipse.wst.wsi.internal.profile.impl.ProfileAssertionsReaderImpl;
import org.eclipse.wst.wsi.internal.report.Report;
import org.eclipse.wst.wsi.internal.report.ReportWriter;
import org.eclipse.wst.wsi.internal.report.impl.ReportImpl;
import org.eclipse.wst.wsi.internal.report.impl.ReportWriterImpl;
import org.eclipse.wst.wsi.internal.util.WSIProperties;
import org.eclipse.wst.wsi.internal.monitor.config.MonitorConfig;
import org.eclipse.wst.wsi.internal.monitor.config.MonitorConfigReader;
import org.eclipse.wst.wsi.internal.monitor.config.impl.MonitorConfigImpl;
import org.eclipse.wst.wsi.internal.monitor.config.impl.MonitorConfigReaderImpl;

/**
 * This is the implementation of the Conformance document factory which provides access to
 * implementations of the documents, readers and writers. 
 * 
 * @version 1.0.1
 * @author Peter Brittenham (peterbr@us.ibm.com)
 */
public class DocumentFactoryImpl extends DocumentFactory
{
  /**
   * Document factory implementation.
   */
  public DocumentFactoryImpl()
  {
  }

  /**
   * Create log file.
   */
  public Log newLog()
  {
    return new LogImpl();
  }

  /**
   * Create monitor config.
   */
  public MonitorConfig newMonitorConfig()
  {
    return new MonitorConfigImpl();
  }

  /**
   * Create analyzer config.
   */
  public AnalyzerConfig newAnalyzerConfig()
  {
    return new AnalyzerConfigImpl();
  }

  /**
   * Create profile assertions.
   */
  public ProfileAssertions newProfileAssertions()
  {
    return new ProfileAssertionsImpl();
  }

  /**
   * Create report.
   */
  public Report newReport()
  {
    return new ReportImpl();
  }

  /**
   * Create monitor config reader.
   */
  public MonitorConfigReader newMonitorConfigReader()
  {
    return new MonitorConfigReaderImpl();
  }

  /**
   * Create analyzer config reader.
   */
  public AnalyzerConfigReader newAnalyzerConfigReader()
  {
    return new AnalyzerConfigReaderImpl();
  }

  /**
   * Create profile assertions reader.
   */
  public ProfileAssertionsReader newProfileAssertionsReader()
  {
    // Return implementation
    return new ProfileAssertionsReaderImpl();
  }

  /**
   * Create log reader.
   */
  public LogReader newLogReader()
  {
    // Return implementation
    return new LogReaderImpl();
  }

  // WRITERS

  /**
   * Create log writer.
   */
  public LogWriter newLogWriter()
  {
    return new LogWriterImpl();
  }

  /**
   * Create a new instance of a DocumentReader.
   */
  public ReportWriter newReportWriter()
  {
    // Return implementation
    return new ReportWriterImpl();
  }

  /**
   * Find the factory class name which can be specified as a Java property.
   */
  private static String getFactoryClassName()
  {
    // Get property value
    return WSIProperties.getProperty(
      WSIProperties.PROP_DOCUMENT_FACTORY,
      WSIProperties.DEF_DOCUMENT_FACTORY);
  }
}
