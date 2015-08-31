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
<script src="/resource/js/jquery/jquery-2.1.1.js"></script>
<script src="/resource/js/jquery/jquery-ui.js"></script>
<link rel="stylesheet" href="/resource/css/jquery-ui.css">
<link href="/resource/css/bootstrap.css" rel="stylesheet">
<script src="/resource/js/hostel/personsetting.js"></script>
<style>
#realPhoto {
	font-size: 100px;
	opacity: 0;
	filter: alpha(opacity = 0);
}
#myform{
   margin-left: 200px;
}
</style>
</head>
<body>
	<form:form id="myform" class="form-horizontal"
		action="/personal/personSetting" method="post"
		enctype="multipart/form-data" commandName="user">
		<form:hidden path="userId" value="${userId}"></form:hidden>
		<div class="form-group">
			<label for="inputName" class="col-lg-2 control-label">昵称:</label>
			<div class="col-md-2 control-label">
				<form:input path="nickname" value="${nickname}"></form:input>
			</div>
		</div>
		<input type="hidden"  value="${user.headPhoto}" name="previousHead">
		<div class="form-group">
			<label for="inputName" class="col-lg-2 control-label">头像:</label>
						<div class="col-md-2 control-label"> <img
				src="${user.headPhoto}" class="ec-circle" alt="无头像"
				onclick="chooseimage()" id="choosing_image" /></div>
		</div>
		<br>
		<div class="form-group">
			<label for="inputName" class="col-lg-2 control-label">邮箱:</label>
			<div class="col-md-2 control-label">
				<form:input id="email" type="email" maxlength="50" path="email"
					value="${email}" />
			</div>
		</div>
		<br>
		<div class="form-group">
			<label for="inputName" class="col-lg-2 control-label">电话:</label>
			<div class="col-md-2 control-label">
				<form:input maxlength="50" path="mobileNum" value="${mobileNum}" />
			</div>
		</div>
		<br>
		<div class="form-group">
			<label for="inputName" class="col-lg-2 control-label">修改密码:</label>
			<div class="col-md-2 control-label">
				<a href="#" class="button button-primary button-pill button-small">修改密码</a>
			</div>
		</div>
		<div id="myhead" title="选择头像">
			<div>
				<c:forEach begin="1" end="3" var="ro">
					<div class="row">
						<c:forEach begin="1" end="5" var="col">
							<div class="col-md-2">
								<div class="Bigicon-circle"></div>
							</div>
						</c:forEach>
					</div>
					<br>
				</c:forEach>
				<div class="row">
					<div class="col-md-2">
						<div class="Bigicon-circle" id="uploadimage">
							<input type="file" id="realPhoto" name="headPhotofile"
								onchange="readURL(this)" />
						</div>
					</div>
				</div>
			</div>
		</div>
		<br>
		<br>
		<br>
		<input type="hidden" name="imgurl" id="imgurl">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-2">
				<input type="submit" value="完成"
					class="button button-glow button-rounded button-raised button-primary">
			</div>
		</div>
	</form:form>
</body>
</html>