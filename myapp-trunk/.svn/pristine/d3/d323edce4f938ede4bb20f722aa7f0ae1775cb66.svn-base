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
<!-- <link rel="stylesheet" href="/resource/css/bootstrap.css">
<link rel="stylesheet" href="/resource/css/bootstrap.min.css"> -->
<script src="/resource/js/jquery/jquery.min.js"></script>
<script src="/resource/js/bootstrap.min.js"></script>
<script src="/resource/js/jquery/jquery-2.1.1.js"></script>
<script src="/resource/js/jquery/jquery-ui.js"></script>
<script src="/resource/js/jquery/jquery.bpopup.js"></script>
<script src="/resource/js/core/syscore-1.0.js"></script>

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
</style>

<script type="text/javascript">
	$(function() {
		var x = "${flag}";
		if (x == "true") {
			$(".deal").hide();
		}
		$("td[colspan=4]").find("p").hide();
		$(".detail").click(function(event) {
			event.stopPropagation();
			var $target = $(event.target);
			if ($target.closest("td").attr("colspan") > 1) {
				$target.slideUp();
			} else {
				$target.closest("tr").next().find("p").slideToggle();
			}
		});
	});
 	function approveRoute()
	{
 		$("#myform").attr('action','/admin/approveRoute');
		$("#myform").submit();
	} 
	function rejectRoute()
	{
		$("#myform").attr('action','/admin/rejectRoute');
		$("#myform").submit();
	}
	
	$(function() {
		$('#exampleModal').on('show.bs.modal', function(event) {
			var button = $(event.relatedTarget);
			var recipient = button.data('id');
			var modal = $(this);
			modal.find('.modal-title').text("拒绝这条路线！");
			modal.find('.modal-body input').val(recipient);
		});
	});
</script>

</head>
<body>
	<div class="viewDate row">
		<div class="col-lg-12">
			<h1 id="title">
				<c:choose>
					<c:when test="${flag!='true' }">路线审核</c:when>
					<c:otherwise>已通过路线</c:otherwise>
				</c:choose>
			</h1>
			<table style="width: 100%;">
				<tr class="routeTitle">
					<td>路线名</td>
					<td>创建日期</td>
					<td>结束日期</td>
				</tr>
				<c:forEach items="${result1}" var="map">
					<tr class="routeElement">
						<td>${map.value.name}</td>
						<td>${map.value.cTime.toString()}</td>
						<td>${map.value.eTime}</td>
						<td style="text-align: right;"><button type="button"
								class="detail btn btn-primary">查看</button></td>
					</tr>
					<tr>
						<td colspan="4">
							<p>
								<b>线路描述:</b>
							</p>

							<p>${map.value.des}</p>
							<p>
								<img src="${map.value.themeImageUrl}" alt="Smiley face"
									width="342" height="342">
							</p> <br>

							<p>
								<b>价格:</b>
							</p>

							<p>${details.getPrice()}</p> <br>

							<p>
								<b>路线周期:</b>
							</p>

							<p>
								<fmt:formatDate pattern="yyyy-MM-dd"
									value="${details.getsTimes()}" />
								---
								<fmt:formatDate pattern="yyyy-MM-dd"
									value="${details.geteTimes()}" />
							</p> <br>

							<p>
								<b>旅店信息:</b>
							</p>

							<p>旅店老板: ${map.value.hotel.managername}</p>
							<p>旅店联系方式: ${map.value.hotel.managerphone}</p>
							 <form:form
								id="myform" class="form-horizontal" 
								method="post" enctype="multipart/form-data" commandName="vo">
								<input type="hidden" name="routeid" value="${map.value.routeid}" />
								<p>
									<input type="button"  value="通过"
										class="btn btn-primary deal"  onclick="approveRoute()"/>
									<button type="button" class="btn btn-primary deal"
										data-toggle="modal" data-target="#exampleModal"
										data-id="@test1">拒绝</button>
								<div class="modal fade" id="exampleModal" tabindex="-1"
									role="dialog" aria-labelledby="exampleModalLabel"
									aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
												<h4 class="modal-title" id="exampleModalLabel">失败原因</h4>
											</div>
											<div class="modal-body">
												<form>
													<div class="form-group">
														<textarea class="form-control" name="failReason"
															id="message-text"></textarea>
													</div>
												</form>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default"
													data-dismiss="modal">返回</button>
												<input type="button" class="btn btn-primary" 
													value="拒绝"  onclick="rejectRoute()"/>
											</div>
										</div>
									</div>
									</p>
							</form:form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
