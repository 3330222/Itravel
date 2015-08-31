<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>jquery test</title>
<script src="/resource/js/jquery/jquery-2.1.1.js">
	
</script>
<script src="/resource/js/jquery/jquery-ui.js">
	
</script>

<script>
$(function(){
	
	$("#pptMgr").click(function(){
		document.location.href='/admin/updateImage';
	});
	
	$("#routeMgr").click(function(){
		document.location.href='/admin/updateEpicRoute';
	});
});
</script>
<style>
.frame>div {
	background: #ffe100;
	border-bottom: 1px solid #efcd02;
	color: #cb9f07;
	padding: 15px;
	margin-bottom: 10px;
	border-radius: 3px;
}

.frame .tab{
     width:100%;
}
</style>
</head>

<body>
	<div class="frame">
	    <div class="tab" id="pptMgr">主页幻灯片管理</div>
    	<div class="tab" id="routeMgr">主页精品路线管理</div>
	</div>
</body>
</html>