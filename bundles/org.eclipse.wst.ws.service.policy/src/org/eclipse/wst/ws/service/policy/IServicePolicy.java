/*******************************************************************************
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * IBM Corporation - initial API and implementation
 * yyyymmdd bug      Email and other contact information
 * -------- -------- -----------------------------------------------------------
 * 20071024   196997 pmoogk@ca.ibm.com - Peter Moogk
 *******************************************************************************/
package org.eclipse.wst.ws.service.policy;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.wst.ws.service.policy.listeners.IPolicyChildChangeListener;
import org.eclipse.wst.ws.service.policy.listeners.IStatusChangeListener;

public interface IServicePolicy
{ 
  /**
   * 
   * @return returns true if this Service policy is defined in plugin.xml 
   * meta data.  Otherwise, false is returned.
   */
  public boolean getPredefined();
  
  /**
   * 
   * @return returns the unique ID for this service policy.
   */
  public String getId();
  /**
   * 
   * @return returns the descriptor for this service policy.
   */
  public Descriptor getDescriptor();
  
  /**
   * 
   * @return returns a list of relationships to other IServicePolicy objects.  
   *  
   */
  public List<IPolicyRelationship> getRelationships();

  /**
   * Sets the relationships for this service policy.
   * 
   * @param relationships
   */
  public void setRelationships( List<IPolicyRelationship> relationships );
  
  /**
   * 
   * @return returns the policy state for this service policy.
   */
  public IPolicyState getPolicyState();
  
  /**
   * 
   * @param project the project.
   * @return The IPolicyState for a particular project.
   */
  public IPolicyState getPolicyState( IProject project );
  
  public IPolicyStateEnum getPolicyStateEnum();
  
  public IPolicyStateEnum getPolicyStateEnum( IProject project );
  
  /**
   * 
   * @return returns the parent policy for this service policy.  If this
   * service policy has no parent then null is returned.
   */
  public IServicePolicy getParentPolicy();
  
  /**
   * 
   * @return returns the child service policies for this service policy.  Changes
   * made to the returned list do not change the underlying number of children
   * for this service policy.
   */
  public List<IServicePolicy> getChildren();
  
  /**
   * Removes a child service policy from this service policy.  If the policy specified
   * is null or is not a child of this service policy this method will have no effect.
   * Also, if this service policy is predefined calling this method will have
   * no effect.
   * @param policy
   */
  public void removeChild( IServicePolicy policy );
  
  /**
   * Adds a child listener to this service policy.
   * 
   * @param listener the listener
   */
  public void addPolicyChildChangeListener( IPolicyChildChangeListener listener );
  
  /**
   * Removes a child listener from this service policy.
   * @param listener
   */
  public void removePolicyChildChangeListener( IPolicyChildChangeListener listener );
  
  public void addStatusChangeListener( IStatusChangeListener listener );
  
  public void removeStatusChangeListener( IStatusChangeListener listener );
  
  public IStatus getStatus();
  
  public void setStatus( IStatus status );
}