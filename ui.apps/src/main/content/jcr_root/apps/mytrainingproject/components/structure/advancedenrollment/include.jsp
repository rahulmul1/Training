<!-- global initialization is done in guidesglobal.jsp -->
<%@include file="/libs/fd/af/components/guidesglobal.jsp"%>
<!-- include advanceenrollment theme provided OOTB -->
<cq:includeClientLib categories="guide.theme.advancedenrollment"/>
<!-- import the include.jsp of the base page (contentpage) to get the styles of the page -->
<cq:include script="/apps/mytrainingproject/components/structure/contentpage/include.jsp"/>

<script>
     var somFName = "guide[0].guide1[0].guideRootPanel[0].applicantInfo[0].fName[0]";
     var somLName = "guide[0].guide1[0].guideRootPanel[0].applicantInfo[0].lName[0]";
     var somPhone = "guide[0].guide1[0].guideRootPanel[0].applicantInfo[0].phoneNum[0]";

     window.addEventListener("bridgeInitializeStart", function(evnt) {
     console.log("##### guideBridge started ##########");
     var gb = evnt.detail.guideBridge;
     gb.connect(function (){
     var url = "/bin/dev/advanceenrollment.json";
	 $.ajax
	 ({
		type:'GET',
		url:url,
 		dataType:"text",
       	success:function(data)
         {
     console.log("##### data  ##########"+ data);
           var userInfo = data;
           gb.setProperty([somFName],"value",[userInfo.givenName]);
           gb.setProperty([somLName],"value",[userInfo.familyName]);
           gb.setProperty([somPhone],"value",[userInfo.phoneNumber]);}
          });
       });
     });
</script>