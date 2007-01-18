<%
/*******************************************************************************
 * Copyright (c) 2001, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
%>
<%@ page contentType="text/html; charset=UTF-8" import="org.eclipse.wst.ws.internal.explorer.platform.uddi.constants.*,
                                                        org.eclipse.wst.ws.internal.explorer.platform.constants.*,
                                                        org.eclipse.wst.ws.internal.explorer.platform.actions.ShowPerspectiveAction,
                                                        org.eclipse.wst.ws.internal.explorer.platform.uddi.actions.UDDIAddToWSDLPerspectiveAction"%>


<jsp:include page="/uddi/scripts/uddipanes.jsp" flush="true"/>
<jsp:useBean id="controller" class="org.eclipse.wst.ws.internal.explorer.platform.perspective.Controller" scope="session"/>
<%
// Prepare the action.
UDDIAddToWSDLPerspectiveAction action = new UDDIAddToWSDLPerspectiveAction(controller);

// Load the parameters for the action from the servlet request.
boolean paramValid = action.populatePropertyTable(request);

if (paramValid) {
  // Run the action and obtain the return code (fail/success).
  boolean actionResult = action.execute();
  if (actionResult) {
%>
    <script language="javascript">
      perspectiveWorkArea.location = "<%=response.encodeURL(controller.getPathWithContext(ShowPerspectiveAction.getActionLink(ActionInputs.PERSPECTIVE_WSDL,false)))%>";
    </script>
<%
  }
  else {
%>
    <script language="javascript">
      propertiesContent.location = "<%=response.encodeURL(controller.getPathWithContext("uddi/properties_content.jsp"))%>";
      statusContent.location = "<%=response.encodeURL(controller.getPathWithContext("uddi/status_content.jsp"))%>";
    </script>
<%
  }
}
%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body dir="<%=org.eclipse.wst.ws.internal.explorer.platform.util.DirUtils.getDir()%>">
</body>
</html>