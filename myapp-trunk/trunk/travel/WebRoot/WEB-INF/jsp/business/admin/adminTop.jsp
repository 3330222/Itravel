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
		
		$("#spread").click(function(){
			document.location.href='/admin/userAudition';
		});
		
		$("#backend").click(function(){
			document.location.href='/admin/updateImage';
		});
		
		$("#route").click(function(){
			document.location.href='/admin/applicationList';
		});
		
		$("#reportRorm").click(function(){
			document.location.href='/personal/notification';
		});
	});
</script>
<body>

    <h1>Destinations</h1>
	<div id="header">
		<form name = "form1" method = "get" action = "#">
			<label for = "search" > Search:</label>
			<input type = "search" name = "search" id = "search">
			<input type = "submit" name = "go" id = "go" value = "Go">
	    </form>
	</div>
    <div class="menu">
    	<div class="tab" id="spread">认证管理</div>
    	<div class="tab" id="backend">后台管理</div>
    	<div class="tab" id="route">路线审核</div>
    	<div class="tab" id="reportRorm">报表查看</div>
    </div>	
</body>
</html>