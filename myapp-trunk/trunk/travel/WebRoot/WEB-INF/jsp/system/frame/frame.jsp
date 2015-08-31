<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/jsp/share/tagLibs.jsp"%> 

<html>
<head>
<title>LAPS-TEAM7</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
        
<frameset framespacing="0" border="0" rows="60,*,15" frameborder="0">
  <frame name="banner" scrolling="no" noresize target="contents" src="/laps/top" marginwidth="0" marginheight="0">
  <frameset cols="200,*">
    <frame name="menuframe" target="mainframe" src="http://localhost:8080/laps/left" scrolling="no" marginwidth="0" marginheight="0">
    <frame name="mainframe" scrolling="auto" noresize src="http://localhost:8080/laps/right" marginwidth="0" marginheight="0">
  </frameset> 
  <frame name="menuframe" target="mainframe" src="http://localhost:8080/laps/top" scrolling="no" marginwidth="0" marginheight="0">
</frameset><noframes></noframes>
</html>