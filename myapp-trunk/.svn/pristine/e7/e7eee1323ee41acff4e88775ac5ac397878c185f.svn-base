<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/share/tagLibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="/resource/css/hostel/font.css"> -->
<!-- <link rel="stylesheet" href="/resource/css/homepage_style.css" -->
<link rel="stylesheet" href="/resource/css/hostel/menudemo.css">
<script src="/resource/js/modernizr.js"></script>
</head>
<body>
	<div class="menusection">
		<br>
		<section class="p10"> <a href="/backend/hostel/applyverify">实名认证</a></section>
		<br> <br>
<%-- 		<c:choose> --%>
	    <c:if test="${status==3}">
		<section class="p11"> <a href="/backend/route/newroute">
			新的路线 </a> </section>
		<br> <br>
		<section class="p14"> <a href="/backend/route/displaylist">
			路线管理 </a> </section>
		<br> <br>
		<section class="p17"> <a href="/order/viewOrders">查看订单</a> </section>
		<br> <br>
		</c:if>
<%-- 		</c:choose> --%>
		<section class="p18"> <a href="/personal/personSetting">个人设置</a></section>
		<br> <br>
	</div>
</body>
</html>