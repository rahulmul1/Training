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
%><%@ page import="com.day.cq.i18n.I18n, java.util.Calendar" %>
<%@include file="/libs/foundation/global.jsp" %><%
    I18n i18n = new I18n(slingRequest);
    int year = Calendar.getInstance().get(Calendar.YEAR);
%>
<div id="footer" class="bg-dk-grey">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h3> Contact Us </h3>
                <ul class="list-unstyled">
                    <li><i class="glyphicon glyphicon-earphone"></i><span>+91931414141</span></li>
                    <li><i class="glyphicon glyphicon-envelope"></i><span>contact@mycomany.com</span></li>
                    <li><i class="glyphicon glyphicon-home"></i><span>lorem ipsum</span></li>
                </ul>
            </div>
            <div class="col-md-6">
                <h3> Subscribe </h3>
                <div class="input-group">
                  <input type="text" class="form-control" placeholder="Enter your email id to subscribe">
                  <span class="input-group-btn">
                    <button class="btn btn-success" type="button">Go!</button>
                  </span>
    			</div>
            </div>
        </div>
        <p class="text-muted text-center text-white"><%= i18n.get("&copy; {0} Geometrixx.Gov | All Rights Reserved", null, String.valueOf(year)) %></p>
    </div>
</div>
<script>
    Granite.$(".bg-white").clingify({
        breakpoint:1024,
        locked: function() {
			$(".bg-white").addClass("bg-white-transparent");
        },
        detached: function() {
			$(".bg-white").removeClass("bg-white-transparent");
        }
    });
</script>