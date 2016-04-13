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
%><%@include file="/libs/foundation/global.jsp" %>
<div class="page-content">
<div id="main">
    <div class="top_image">
            <cq:include path="image" resourceType="foundation/components/image"/>
    </div>
    <div class="top_container container">
            <cq:include path="parsys" resourceType="foundation/components/parsys"/>
    </div>
    <div class="bottom_container container">
        <div class="col-lg12 col-md-12 col-sm-12 col-xs-12 nopad">
            <div class="col-lg6 col-md-6 col-sm-6 col-xs-12 nopad">
               <div class="col-lg10 col-md-10 col-sm-10 col-xs-12 nopad">
                	<cq:include path="parsys_left" resourceType="foundation/components/parsys"/>
               </div>
            </div>    
            <div class="col-lg6 col-md-6 col-sm-6 col-xs-12 nopad">
                <div class="col-lg10 col-md-10 col-sm-10 col-xs-12 nopad">
                	<cq:include path="parsys_right" resourceType="foundation/components/parsys"/>
                </div>
            </div>
        </div>   

    </div>
    <div class="clear"></div>

</div>
</div>    


