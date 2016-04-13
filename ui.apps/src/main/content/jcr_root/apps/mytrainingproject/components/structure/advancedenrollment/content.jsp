<!-- global initialization is done in guidesglobal.jsp -->
<%@include file="/libs/fd/af/components/guidesglobal.jsp"%>
<!-- render the parsys component where the author can add non Form Components -->
<div class="page-content">
	<div class="container">    
		<cq:include path="par" resourceType="foundation/components/parsys" />
	</div>    
</div> 
<!-- finally render the Adaptive Form -->
<div class="guideBody">
    <guide:includeGuideContainer/>
</div>