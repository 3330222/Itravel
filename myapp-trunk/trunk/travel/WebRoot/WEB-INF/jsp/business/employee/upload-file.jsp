<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/share/tagLibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<title>Upload a file please</title>
</head>
<body>
<h1>Please upload a file</h1>
    <form:form method="post" action="/employee/form" enctype="multipart/form-data" commandName="vo">
        <input type="text" name="fileName"/>
        <input type="file" name="file"/>
        <input type="submit"/>
    </form:form>
</body>
</html>