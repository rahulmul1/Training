<%@page session="false"%><%--
  ADOBE CONFIDENTIAL
  __________________

   Copyright 2014 Adobe Systems Incorporated
   All Rights Reserved.

  NOTICE:  All information contained herein is, and remains
  the property of Adobe Systems Incorporated and its suppliers,
  if any.  The intellectual and technical concepts contained
  herein are proprietary to Adobe Systems Incorporated and its
  suppliers and are protected by trade secret or copyright law.
  Dissemination of this information or reproduction of this material
  is strictly forbidden unless prior written permission is obtained
  from Adobe Systems Incorporated.
--%><%
%><%@include file="/libs/foundation/global.jsp"%><%
%><%@ page import="com.day.cq.commons.Doctype,
        com.day.cq.wcm.api.PageFilter,
        com.day.cq.wcm.foundation.Navigation,
        com.day.text.Text" %><%

    Page homePage = currentPage.getAbsoluteParent(2);
   //Fix for AF Template Rendition. These templates are not having parent page, so creating current page as home page
	if(homePage==null){

        homePage=currentPage;
    }
    String home = homePage != null ? homePage.getPath() : Text.getAbsoluteParent(currentPage.getPath(), 2);
    int absParent = currentStyle.get("absParent", 2);

	//Fix for Naviagtion of adaptive form
if(!home.contains("/content/mytrainingprojecct/en-mycompany"))
    {

        home="/content/mytrainingprojecct/en-mycompany";
        }    
    currentPage = resourceResolver.resolve(home).adaptTo(Page.class);

    PageFilter filter = new PageFilter(request);
    Navigation nav = new Navigation(currentPage, absParent, filter, 3);
    String xs = Doctype.isXHTML(request) ? "/" : "";

    // help linkchecker to increase performance
    String linkCheckerHint = filter.isIncludeInvalid() ? "" : "x-cq-linkchecker=\"valid\"";

%><div class="topnav">

        <ul id="topnav" class="nav navbar-nav navbar-left">
          <li class="home"><a href="<%= xssAPI.getValidHref(home) %>.html">Home<%=xs%></a></li>
            <%
                for (Navigation.Element e: nav) {
        			out.println("path -- " + e.getPath());
                    switch (e.getType()) {
                       case NODE_OPEN:
                            %><ul><%
                            break;
                        case ITEM_BEGIN:
                            %><li <%= e.hasChildren() ? "class=\"noleaf\"" : "" %>><a href="<%= xssAPI.getValidHref(e.getPath()) %>.html" <%= linkCheckerHint %>><%= xssAPI.encodeForHTML(e.getTitle()) %></a><%
                            break;
                        case ITEM_END:
                            %></li><%
                            break;
                        case NODE_CLOSE:
                            %></ul><%
                            break;
                    }
                }
            %>
            
        </ul>
      </div>

