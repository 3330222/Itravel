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
<title>管理员登陆</title>
</head>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/resource/css/admin/style.css" rel="stylesheet">
<body class="fixed-navigation  pace-done">
	<div id="wrapper">
		<div>
			<tiles:insertAttribute name="menu" />
		</div>
		<div id="page-wrapper" class="gray-bg">
			<div class="row border-bottom">
				<nav class="navbar navbar-static-top" role="navigation"
					style="margin-bottom: 0">
				<div class="navbar-header">
					<a class="navbar-minimalize minimalize-styl-2 btn btn-primary"
						><i class="glyphicon glyphicon-th-large"></i> </a>
					    <form role="search" class="navbar-form-custom" method="post">
						<div class="form-group">
							<input type="text" placeholder="请输入您需要查找的内容 …"
								class="form-control" name="top-search" id="top-search">
						</div>
					</form>
				</div>
				</nav>
			</div>
			<div class="wrapper wrapper-content">
				<tiles:insertAttribute name="content" />
			</div>
		</div>
	</div>
	<!-- Mainly scripts -->
	<script src="/resource/js/admin/jquery-2.1.1.min.js""></script>
	<script src="/resource/js/admin/bootstrap.min.js"></script>
	<script src="/resource/js/admin/jquery.metisMenu.js"></script>
	<script src="/resource/js/admin/jquery.slimscroll.min.js"></script>

	<!-- Custom and plugin javascript -->
    <script src="/resource/js/admin/hplus.js"></script>

</body>
</html>