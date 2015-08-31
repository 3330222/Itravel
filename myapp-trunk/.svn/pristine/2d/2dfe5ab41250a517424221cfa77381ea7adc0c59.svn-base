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
</head>
<style>

img{
  width: 100%;
}
.clear{
  text-align: left;
}
span {
	padding-left: 20px;
}
</style>
<body>
	<nav class="navbar-default navbar-static-side" role="navigation">
	<div class="sidebar-collapse">
		<ul class="nav" id="side-menu">
			<li class="nav-header">
				<div class="dropdown profile-element">
					<span> <img alt="image" class="img-circle"
						src="/resource/image/headSamplephoto/admin.jpeg">
					</span> <a data-toggle="dropdown" class="dropdown-toggle"
						href="#"> <span
						class="clear"> <span class="block m-t-xs"> <strong
								class="font-bold">管理员</strong>
						</span>
					</span>
					</a>
				</div>
			<!-- 	<div class="logo-element">xx</div> -->
			</li>
			<li class="titles"><a href="/admin/info"><i class="glyphicon glyphicon-home"></i> <span
					class="nav-label">主页</span></a></li>
			<li class="titles"><a ><i class="glyphicon glyphicon-check"></i> <span
					class="nav-label">认证审核</span><span class="glyphicon glyphicon-chevron-down"></span></a>
				<ul class="nav nav-second-level collapse" aria-expanded="false"
					style="height: 0px;">
					<li><a href="/admin/userAudition?usertype=2">客栈实名认证</a></li>
					<li><a href="/admin/userAudition?usertype=1">游客实名认证</a></li>
				</ul></li>
			<li class="titles"><a><i class="glyphicon glyphicon-edit"></i> <span
					class="nav-label">路线审核</span><span class="glyphicon glyphicon-chevron-down"></span></a>
				<ul class="nav nav-second-level collapse" aria-expanded="false"
					style="height: 0px;">
					<li><a href="/admin/applicationList">待审核路线</a></li>
					<li><a href="/admin/routeList">已通过路线</a></li>
				</ul></li>
			<li class="titles"><a><i class="glyphicon glyphicon-film"></i> <span
					class="nav-label">后台管理</span><span class="glyphicon glyphicon-chevron-down"></span></a>
				<ul class="nav nav-second-level collapse" aria-expanded="false"
					style="height: 0px;">
					<li><a href="/admin/updateImage">幻灯片</a></li>
					<li><a href="/admin/updateEpicRoute">精品路线</a></li>
				</ul></li>
			<li class="titles"><a><i class="glyphicon glyphicon-stats"></i> <span
					class="nav-label">查看报表</span><span class="glyphicon glyphicon-chevron-down"></span></a>
				<ul class="nav nav-second-level collapse">
				<!-- 	<li><a href="#">Charts</a></li>
					<li><a href="#">Charts</a></li>
					<li><a href="#">Charts</a></li> -->
				</ul></li>
		</ul>
	</div>
	</nav>
</body>
</html>