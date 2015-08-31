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
<script src="/resource/js/viewinfo.js"></script>
<link rel="stylesheet" href="/resource/css/bootstrap.css">
<link rel="stylesheet" href="/resource/css/hostel/tabs.css">
<link rel="stylesheet" href="/resource/css/hostel/tabstyles.css">
<link rel="stylesheet" href="/resource/css/button.css">
 <link rel="stylesheet" href="/resource/css/jquery-ui.css">
  <link rel="stylesheet" href="/resource/css/hostel/font.css">
</head>
<body>

	<form action="/order/search" method="post">
		<input type="text" name="search" autocomplete="off"> <input
			type="submit" value="搜索" class="button button-glow button-rounded button-raised button-primary">
	</form>
	<hr>
	<div class="tabs tabs-style-linetriangle">
		<nav>
		<ul>
			<li><a href="#tabs-1">当前订单</a>
			<li><a href="#tabs-2">退款中订单</a>
			<li><a href="#tabs-3">订单历史</a>
		</ul>
		</nav>
		<div class="content-wrap">
			<section id="tabs-1" class="content-current">
			<table class="table table-striped table-hover">
				<thead>
					<tr class="info">
						<th></th>
						<th>路线名</th>
						<th>订单时间</th>
						<th>总价</th>
						<th>联系人</th>
					</tr>
				</thead>
				<c:forEach items="${suc}" var="vo" varStatus="status">
					<tr class="info">
						<td>${status.index+1}</td>
						<td>${vo.detail.info.name }</td>
						<td>${vo.cTime}</td>
						<td>${vo.price }</td>
						<td><input type="button" value="查看"
							onclick="choose(1,${status.index})"></td>
					</tr>
					<input type="hidden" value="${vo.travelDate }"
						id="date1${status.index}">
					<input type="hidden" value="${vo.detail.vehiclename}"
						id="car1${status.index}">
					<input type="hidden" value="${vo.contactName }"
						id="person1${status.index}">
					<input type="hidden" value="${vo.numOfAdult }"
						id="adult1${status.index}">
					<input type="hidden" value="${vo.numOfChild }"
						id="child1${status.index}">
					<input type="hidden" value="${vo.contactNumber}"
						id="phone1${status.index}">
					<input type="hidden" value="${vo.contactEmail}"
						id="email1${status.index}">
				</c:forEach>
			</table>
			</section>
			<section id="tabs-2">
			<table class="table table-striped table-hover">
				<thead>
					<tr class="info">
						<th></th>
						<th>路线名</th>
						<th>订单时间</th>
						<th>总价</th>
						<th>原因</th>
						<th></th>
					</tr>
				</thead>
				<c:forEach items="${fail}" var="vo" varStatus="status">
					<tr class="info">
						<td>${status.index+1}</td>
						<td>${vo.detail.info.name }</td>
						<td>${vo.cTime}</td>
						<td>${vo.price }</td>
						<td>${vo.remarks }</td>
						<td><input type="button" value="查看"
							onclick="choose(2,${status.index})"></td>
					</tr>
					<input type="hidden" value="${vo.orderid }" id="id${status.index}">
					<input type="hidden" value="${vo.travelDate }"
						id="date2${status.index}">
					<input type="hidden" value="${vo.detail.vehiclename}"
						id="car2${status.index}">
					<input type="hidden" value="${vo.contactName }"
						id="person2${status.index}">
					<input type="hidden" value="${vo.numOfAdult }"
						id="adult2${status.index}">
					<input type="hidden" value="${vo.numOfChild }"
						id="child2${status.index}">
					<input type="hidden" value="${vo.contactNumber}"
						id="phone2${status.index}">
					<input type="hidden" value="${vo.contactEmail}"
						id="email2${status.index}">
				</c:forEach>
			</table>
			</section>
			<section id="tabs-3">
			<table class="table table-striped table-hover">
				<thead>
					<tr class="info">
						<th></th>
						<th>路线名</th>
						<th>订单时间</th>
						<th>状态</th>
						<th>联系人</th>
					</tr>
				</thead>
				<c:forEach items="${history}" var="vo" varStatus="status">
					<tr class="info">
						<td>${status.index+1}</td>
						<td>${vo.detail.info.name }</td>
						<td>${vo.cTime}</td>
						<c:choose>
							<c:when test="${vo.status==2}">
								<td>付款</td>
							</c:when>
							<c:otherwise>
								<td>退款</td>
							</c:otherwise>
						</c:choose>
						<td>${vo.contactName}</td>
					</tr>
				</c:forEach>
			</table>
			</section>
		</div>
	</div>
	<script src="/resource/js/cbpFWTabs.js"></script>
	<script>
			(function() {
				[].slice.call( document.querySelectorAll( '.tabs' ) ).forEach( function( el ) {
					new CBPFWTabs( el );
				});
			})();
		</script>
	<div id="dialog" title="用户信息" class="form-horizontal">
		出发时间：<label id="date"></label>
		<hr>
		车型： <label id="car"></label>
		<hr>
		联系人： <label id="person"></label>
		<hr>
		大人数：<label id="adult"></label>
		<hr>
		小孩数： <label id="child"></label>
		<hr>
		联系电话： <label id="phone"></label>
		<hr>
		联系邮箱：<label id="email"></label>
		<hr>
		<input type="button" value="通知游客">
		<form action="/order/updaterefund" method="post" id="myform">
			<input type="hidden" name="orderid" id="orderid">
			<input type="hidden" name="refundstatus" id="refundstatus">  <input
				type="hidden" name="status" id="status">
			<textarea class="form-control" rows="3"  name="rejectreason"    placeholder="拒绝原因"
				autocomplete="off" maxlength="100" ></textarea>
			<input type="button" value="同意" id="agree"> <input
				type="button" value="拒绝" id="reject">
		</form>
	</div>
</body>
</html>