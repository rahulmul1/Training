<%@include file="/libs/foundation/global.jsp"%>
<cq:includeClientLib categories="jquerysamples" />
<html>
<head>
<meta charset="UTF-8">
<title>Adobe Experience Manager Sling Model Page</title>
<style>
body {background-color:lightgray}
h1   {color:red}
p    {color:green}
</style>
</style>
<script>

$(document).ready(function() {
  
    $('body').hide().fadeIn(5000);
         
$('#submit').click(function() {
    var failure = function(err) {
             alert("Unable to retrive data "+err);
   };
  

    //Use JQuery AJAX to perform a GET to the AEM Sling Servlet that uses Sling Models
    $.ajax({
         type: 'GET',    
         url:'/bin/slingmodel',
         success: function(msg){
             $('#json').val(msg);   
         }
     });
  });
     
}); // end ready
</script>
</head>
    
<title>Adobe Experience Manager Sling Model Page</title>
    
<body>
      
           
<h1>Adobe Experience Manager Sling Model </h1>
          
</div>
          
<form method="#">
            
 <table border="1" align="left">
  

 <tr>
 <td></td>
  
  <td>
<textarea id="json" rows="15" cols="50">
</textarea>
 </td>
  
 </tr> 
  
 <tr>
 <td></td>
 <td>
<input type="button" value="Get Sling Model Data"  name="submit" id="submit">

 </td>
  
 </tr> 
  
 </table>
 
</form>
    
            
 
  
</body>
  
</html>