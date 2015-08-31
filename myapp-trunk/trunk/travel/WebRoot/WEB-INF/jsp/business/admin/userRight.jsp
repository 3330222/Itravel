<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/share/tagLibs.jsp"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base target="mainframe">
<link rel="stylesheet" href="/resource/css/jquery/jquery-ui.css">
<script src="/resource/js/jquery/jquery-2.1.1.js">
	
</script>
<script src="/resource/js/jquery/jquery-ui.js">
	
</script>
<script src="/resource/js/jquery/jquery.bpopup.js">
	
</script>
<script src="/resource/js/core/syscore-1.0.js">
	
</script>
<style>
.tab:hover, .active {
	background-color: #ccc;
	color: #ffe100;
}

.main {
	position: absolute;
	width: 100%;
}

.left {
	float: left;
	margin-left: 10%;
	color: #ff0000;
	width: 60%;
	font-size: 2.5em;
}

.right {
	float: left;
	width: 30%;
}

.right div {
	margin-bottom: 10px;
}

span {
	padding-left: 20px;
}

.viewDate {
	padding-top: 20px;
	width: 80%;
	margin-left: 10%;
}

.rowList {
	position: relative;
	border: 1px solid #eee;
}

table {
	border-collapse: collapse;
}

tr {
	border-bottom: 1px solid #eee;
}

tr.routeTitle {
	border-bottom: 1px solid #333333;
}

.rowList>div {
	float: left;
	padding: 5px;
}

.col-1, .col-2, .col-3 {
	width: 28%;
	z-index: 10;
}

.col-4 {
	width: 16%;
	z-index: 10;
}

#dateList {
	padding-top: 100px;
	z-index: 8
}

.selector {
	padding: 5;
	width: 150px;
	border-radius: 5px;
	border: 2px solid orange;
	z-index: 1000
}

.ulTest ul {
	display: none;
	list-style-type: none;
	margin: 0;
	padding: 9px;
	border: 1px solid yellow;
	border-radius: 5px;
	position: absolute;
	top: 50px;
	left: 20%;
	background: white;
	z-index: 1000
}

.ulTest li {
	width: 125px;
	padding: 5px;
	z-index: 1000
}

.ulTest a {
	width: 125px;
	z-index: 1000
}

.ulTest:hover>ul>li:hover {
	background: #e9e9e9;
	z-index: 1000
}

.ulTest:hover>ul>li:hover>a {
	color: red;
	z-index: 1000
}

p img {
	width: 30%;
}
</style>

<script type="text/javascript">
	$(function() {
		$("td[colspan=5]").find("p").hide();
		$("button").click(function(event) {
			event.stopPropagation();
			var $target = $(event.target);
			if ($target.closest("td").attr("colspan") > 1) {
				$target.slideUp();
			} else {
				$target.closest("tr").next().find("p").slideToggle();
			}
		});
	});
	function agree(){
		$("#status").val("3");
	};
	function rejecthostel(){
		$("#status").val("1");
	};
</script>
</head>
<body>
	<div class="viewDate row">
		<div class="col-lg-12">
		<h1>实名认证</h1>
		<table style="width: 100%;">
			<tr class="routeTitle">
				<td>用户名</td>
				<td>地址</td>
				<td>邮箱</td>
			</tr>
			<c:forEach items="${result1}" var="map">
				<tr class="routeElement">
					<td>${map.value.account}</td>
					<td>${map.value.address}</td>
					<td>${map.value.email}</td>
					<td style="text-align: right;"><button type="button" class="btn btn-primary">查看信息</button></td>
				</tr>
				<tr>
					<c:choose>
						<c:when test="${map.value.userTypeCd == '1'}">
							<td colspan="5">
								<p>
									<b>真实姓名:&nbsp;&nbsp; ${map.value.realName}</b>
								</p>
								<p>
									<b>性别:&nbsp;&nbsp; <c:choose>
											<c:when test="${map.value.gender==1}">男生</c:when>
											<c:otherwise>女生</c:otherwise>
										</c:choose>
									</b>
								</p>
								<p>
									<span class="img_part"> <img
										src="${map.value.realPhoto}" alt="无照片">
									</span>
								</p>
								<p>
									<b>手机号码:&nbsp;&nbsp;${map.value.mobileNum}</b>
								</p>
								<p>
									<b>证件号:&nbsp;&nbsp; ${map.value.licenseNum}</b>
								</p>
								<p>
									<b>注册时间:</b>
								</p>
								<p>
									<fmt:formatDate pattern="yyyy-MM-dd" value="${map.value.cTime}" />
								</p>
								<p>
									<b>用户信息更新时间:</b>
								</p>
								<p>
									<fmt:formatDate pattern="yyyy-MM-dd" value="${map.value.uTime}" />
								</p> <form:form id="myform" class="form-horizontal"
									action="/admin/auditUser" method="post"
									enctype="multipart/form-data" commandName="vo">
									<p>
										<input type="hidden" name="userid" value="${map.value.userId}" />
										<input type="hidden" name="typeid"
											value="${map.value.userTypeCd}" /> <input type="submit" class="btn btn-primary"
											name="approve" value="同意" /> <input type="submit" class="btn btn-primary"
											name="reject" value="拒绝" />
									</p>
								</form:form>
							</td>
						</c:when>

						<c:otherwise>
							<td colspan="5">
								<p>
									<b>客栈名:&nbsp;&nbsp;
										${result2.get(map.value.userId).hostelname}</b>
								</p>
								<p>
									<b>负责人:&nbsp;&nbsp;
										${result2.get(map.value.userId).managername} </b>
								</p>
								<p>
									<b>身份证件号:&nbsp;&nbsp;
										${result2.get(map.value.userId).manageridentitynum}</b>
								</p>
								<p class="row">
									<img src="${result2.get(map.value.userId).idImageUrl}"
										alt="无照片"> <img
										src="${result2.get(map.value.userId).idbackImageUrl}"
										alt="无照片">
								</p>
								<p>
									<b> 组织结构代码:&nbsp;&nbsp;
										${result2.get(map.value.userId).registernum}</b>
								</p>
								<p>
									<b>工商号:&nbsp;&nbsp;
										${result2.get(map.value.userId).licensenum}</b>
								</p>
								<p>
									<img src="${result2.get(map.value.userId).licenseImageUrl}"
										alt="无照片">
								</p>
								<p>
									<fmt:formatDate pattern="yyyy-MM-dd" value="${map.value.uTime}" />
								</p> <form:form id="myform" class="form-horizontal"
									action="/admin/auditHostel" method="post"
									enctype="multipart/form-data" commandName="vo">
									<p>
										<input type="hidden" name="userid" value="${map.value.userId}" />
										<input type="hidden" name="typeid"
											value="${map.value.userTypeCd}" /> <input type="hidden"
											name="status" id="status"/> <input type="submit" name="approve" class="btn btn-primary"
											value="同意" onclick="agree()" /> <input type="submit" class="btn btn-primary"
											name="reject" value="拒绝" onclick="rejecthostel()" />
									</p>
								</form:form>
							</td>
						</c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>
		</table>
	</div>
	</div>
</body>
</html>
