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
<script src="/resource/js/jquery/jquery-2.1.1.js"></script>
<script src="/resource/js/jquery/jquery-ui.js"></script>
<link rel="stylesheet" href="/resource/css/jquery-ui.css">
<script src="/resource/js/hostel/datepicker-zh-CN.js"></script>
<link rel="stylesheet" href="/resource/css/button.css">
 <link rel="stylesheet" href="/resource/css/hostel/findpartner.css">
<script src="/resource/js/hostel/findPartner.js"></script>
<title>吾谁与归</title>
</head>
<body>
		 <div class="row">
			<div class="content">
				<form class="horizontal">
					<fieldset>
						<div class="row">
							<div class="col-md-3">出发地</div>
							<div class="col-md-9">
								<input type="text" class="form-control" placeholder="出发地">
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-md-3">目的地</div>
							<div class="col-md-9">
								<input type="text" class="form-control" placeholder="想去的地方">
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-md-3">起止日期</div>
							<div class="col-md-3">
								<input type="text" id="from" readonly="readonly"
									class="form-control" placeholder="出发时间" />
							</div>
							<div class="col-md-3" style="font-size: 20px"></div>
							<div class="col-md-3">
								<input type="text" id="to" readonly="readonly"
									class="form-control" placeholder="结束时间" />
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-md-3">约伴人数</div>
							<div class="col-md-9">
								<select class="form-control"><c:forEach begin="1"
										end="20" var="number">
										<option>${number }</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-md-3">约伴简介</div>
							<div class="col-md-9">
								<textarea rows="5" class="form-control" style="resize: none"
									placeholder="说说这次旅行"></textarea>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-md-3">照片</div>
							<div class="col-md-3">
								<div class="upload" id="uploadimage1">
									<input type="file" class="upimage" onchange="readURL(this,1)">
								</div>
							</div>
							<div class="col-md-3">
								<div class="upload" id="uploadimage2">
									<input type="file" class="upimage" onchange="readURL(this,2)">
								</div>
							</div>
							<div class="col-md-3">
								<div class="upload" id="uploadimage3">
									<input type="file" class="upimage" onchange="readURL(this,3)">
								</div>
							</div>
						</div>
						<br>
						<br>
						<div class="row">
							<div class="col-md-3">权限设置</div>
							<div class="col-md-9">
								<div class="row">
									<div class="col-md-4">加入者实名认证</div>
									<div class="col-md-8">
										<div id="radio1">
											<input type="radio" name="group1" value="1" id="name1"><label
												for="name1">需要</label> <input type="radio" name="group1"
												value="2" checked id="name2"><label for="name2">不需要</label>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-4">加入者性别设置</div>
									<div class="col-md-8">
										<div id="radio2">
											<input type="radio" name="group2" value="1" id="gender1">
											<label for="gender1">男生</label> <input type="radio"
												name="group2" value="2" checked id="gender2"><label
												for="gender2">女生</label> <input type="radio" name="group2"
												value="2" checked id="gender3"><label for="gender3">不需要</label>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-4">加入者用户记录</div>
									<div class="col-md-8">
										<div id="radio3">
											<input type="radio" name="group3" value="1" id="record1">
											<label for="record1">需要</label> <input type="radio"
												name="group3" value="2" checked id="record2"><label
												for="record2">不需要</label>
										</div>
									</div>
								</div>
							</div>
						</div>
						<br>
						<div class="subpart">
							<a href="/personal/myPartner"
								class="button button-glow  button-primary" id="sub">出发</a>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
</body>
</html>