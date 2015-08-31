<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/share/tagLibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="/resource/css/jquery/jquery-ui.css">
  
    

<script src="/resource/js/jquery/jquery-2.1.1.js"> </script>
 <script src="/resource/js/jquery/jquery.bpopup.js"> </script>
 <style>
	
	
</style>

<script>

	$(function() {
		console.info('llllllllllllllll');
		 $('#popupwindow').click(function(){
		        console.info('22222222222222');
		    	$('#WindowFrame').bPopup();
		    	
		    });
	});

	
	


</script>

<title>Upload a file please</title>
</head>
<body>


<button id="popupwindow">popup window</button>
<div id="WindowFrame" title="popupwindow" style="display:none"> Content of popup</div>

</body>
</html>
