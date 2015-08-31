<%@ page contentType="text/html; charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/share/tagLibs.jsp" %>
 
<html>
<head>
    <title>jquery test</title>
    <script src="/resource/js/jquery/jquery-2.1.1.js"> </script>
    <script src="/resource/js/jquery/jquery-ui.js"> </script>
</head>
 
<body>

    <h1>Destinations</h1>
	<div id="header">
		<form name = "form1" method = "get" action = "#">
			<label for = "search" > Search:</label>
			<input type = "search" name = "search" id = "search">
			<input type = "submit" name = "go" id = "go" value = "Go">
	    </form>
	</div>
   
</body>
</html>