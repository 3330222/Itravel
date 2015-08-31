<%@ page contentType="text/html; charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/share/tagLibs.jsp" %>
 
<html>
<head>
    <title>jquery test</title>
    <script src="/resource/js/jquery/jquery-2.1.1.js"> </script>
    <script src="/resource/js/jquery/jquery-ui.js"> </script>
</head>
<style>
.tab{
float:left;
text-align: center;
width: 24%;
background-color: #eee;
color: #333;
margin: 5px;
border-radius: 5px;
padding: 5px;
}
.tab:hover, .active{
background-color: #d5d5d5;
color: #fff;
}
.menu{
margin-left: 3%;
margin-right: 3%;
margin-bottom: 50px;
}
</style>
<script>
	$(function(){
		var section = location.pathname.split("/");
		var cur =  section[2];
		$("#"+cur).addClass("active");
		
		$("#info").click(function(){
			document.location.href='/personal/info';
		});
		
		$("#order").click(function(){
			document.location.href='/personal/order';
		});
		
		$("#tourDIY").click(function(){
			document.location.href='/personal/tourDIY';
		});
		
		$("#notification").click(function(){
			document.location.href='/personal/notification';
		});
	});
</script>
<body>

    <h1>Destinations</h1>
    <div class="menu">
    	<div class="tab" id="info">个人信息</div>
    	<div class="tab" id="order">我的订单</div>
    	<div class="tab" id="tourDIY">我的拼团</div>
    	<div class="tab" id="notification">我的通知</div>
    </div>
</body>
</html>