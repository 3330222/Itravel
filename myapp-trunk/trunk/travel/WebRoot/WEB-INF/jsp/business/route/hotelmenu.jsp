<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/share/tagLibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/resource/js/modernizr.js"></script>
<link rel="stylesheet" href="/resource/css/hostel/circle.css">
<script type="text/javascript"
	src="/resource/js/hostel/modernizr.custom.72835.js"></script>
</head>
<style>
.menu_ui {
	width: 200px;
}

.menu_ui li {
	padding: 5px 40px;
	color: white;
	letter-spacing: 0.02em;
	text-align: right;
}
</style>
<body>
	<div class="normal-trigger-area">
		<a href="#" class="ec-circle" id="headphoto">
		</a>
	</div>
	<script>
		$(function() {
			$(".postlogin").hide();
			$("#hostel").hide();
			$("#person").hide();
			$.ajax({
				method : "POST",
				url : "/personal/userinfo",
				dataType : "json",
			}).done(
					function(data) {
						var img = data.headPhoto;
						$("#headphoto").css(
								{
									"background" : "#dda994 url('" + img
											+ "') no-repeat center center",
									"background-size" : "contain"
								});
						var code = data.hosteluserStatus;
						var status=data.userTypeCd;
						if(status==2){
							$("#hostel").show();
							$("#headphoto").prop('href','/backend/route/homepage');
						}else if(status==1){
							$("#person").show();
							$("#headphoto").prop('href','#');
						}	
						if (code == 3) {
							$(".postlogin").show();
						}
					});
		});
	</script>
	<div id="hostel">
		<nav>
		<ul class="menu_ui" id="hostel">
			<li><a href="/backend/hostel/applyverify"
				class="btn btn-success">客栈认证</a>
			<li class="postlogin"><a href="/backend/route/newroute"
				class="btn btn-success">新的路线</a>
			<li class="postlogin"><a href="/backend/route/displaylist"
				class="btn btn-success">路线管理</a>
			<li class="postlogin"><a href="/order/viewOrders"
				class="btn btn-success">查看订单</a>
			<li><a href="/personal/personSetting" class="btn btn-success">个人设置</a>
		</ul>
		</nav>
		</div>
		<div id="person">
		<nav>
		<ul class="menu_ui">
			<li><a href="/personal/info"
				class="btn btn-success">个人主页</a>
			<li><a href="/personal/order"
				class="btn btn-success">我的订单</a>
			<li><a href="/personal/myPartner"
				class="btn btn-success">我的约伴</a>
			<li><a href="/personal/findPartner"
				class="btn btn-success">发起约伴</a>
		</ul>
	</nav>
	</div>
</body>
</html>