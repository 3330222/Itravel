<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/share/tagLibs.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客栈登陆</title>
<!-- <link rel="stylesheet" href="/resource/css/base.css" type="text/css"
	media="screen, projection"></link> -->
<link rel="stylesheet" href="/resource/css/Hostel_styles.css"
	type="text/css"></link> 
</head>
<body>
	<div class="baseContainer">
		<!-- Header -->
		<div id="header-wrapper">
			<tiles:insertAttribute name="header" />
		</div>
		<div class="mainContent">
			<div class="hostelmenu">
				<tiles:insertAttribute name="menu" />
			</div>
			<div class="openNav">
				<div class="icon"></div>
			</div>
			<div class="wrapper">
				<tiles:insertAttribute name="content" />
			</div>
		</div>
		<div class="footer">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
	 <script  src="/resource/js/hostel/autoBackgroundScroll.js"></script> 
	<script>
		$(function() {
			/* $(".wrapper").autoBackgroundScroll({
				speed : 0,
				direction1 : 'bottom',
				direction2 : 'left',
			}); */
		});
		$('.openNav').click(function() {
			$('body').toggleClass('navOpen');
			$('nav').toggleClass('open');
			$('.wrapper').toggleClass('open');
			$('.hostelmenu').toggleClass('open');
			$(this).toggleClass('open');
		});
	</script>
</body>
</html>