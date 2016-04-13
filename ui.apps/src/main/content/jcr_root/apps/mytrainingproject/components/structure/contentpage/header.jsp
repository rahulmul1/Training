<%--
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
%><%@include file="/libs/foundation/global.jsp" %>

<div class="header-upper clearfix">
    <div id="mob-userinfo" class="nopad-left pull-right">
        <div class="nav navbar-nav navbar-right visible-xs">
            <button type="button" class="glyphicon glyphicon-user menu-item-toggle visible-xs pull-right user" data-toggle="collapse" data-target="">
            </button>
        </div>
        <div class="nav navbar-nav navbar-right visible-sm visible-md visible-lg clearfix">

           <cq:include path="userinfo" resourceType="geometrixx-gov/components/userinfo"/>
        </div>
    </div>
</div>
<div class="navbar navbar-default bg-white" data-guide-position-class="guide-element-position-absolute" role="navigation">
    <div class="container navbar-container">
        <div id="logo-section" class="nopad iphone-pad logoimage pull-left">	
			<div class="company-logo">
            	<cq:include path="logo" resourceType="foundation/components/logo"/>
            </div>
            <div class="company-tagline">
                Company Tagline
            </div>
        </div>
        <div class="pull-right menu-section">
            <button type="button" class="glyphicon glyphicon-align-justify navbar-toggle" data-toggle="collapse" id="menu_click" data-target=".navbar-collapse">                
            </button>
            <div id= "mobile-navbar" class="navbar-collapse collapse">
                <div class="nav navbar-nav navbar-left">
                    <cq:include path="topnav" resourceType="/apps/mytrainingproject/components/content/topnav"/>
                </div>
            </div><!--/.nav-collapse -->
        </div>
    </div>
</div>
<div class="container">
    <div class="col-xs-2 pull-right text-left hidden">&nbsp;</div>
</div>
<div class="hidden user-info-text">
    <div class="pop-content">
        <cq:include path="userinfo_mobile" resourceType="geometrixx-gov/components/userinfo"/>
    </div>
</div>



