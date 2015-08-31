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
<link rel="stylesheet" href="/resource/css/bootstrap.css">
<link rel="stylesheet" href="/resource/css/hostel/tabs.css">
<link rel="stylesheet" href="/resource/css/hostel/tabstyles.css">
<script src="/resource/js/hostel/displayRoute.js"></script>
<link rel="stylesheet" href="/resource/css/button.css">
<link rel="stylesheet" href="/resource/css/jquery-ui.css">
<link rel="stylesheet" href="/resource/css/hostel/gallery.css">
<link rel="stylesheet" href="/resource/css/hostel/zoom.css">
<script src="/resource/js/hostel/datepicker-zh-CN.js"></script>
<link rel="stylesheet" href="/resource/css/hostel/font.css">
<title>Insert title here</title>
</head>
<body>
	<div id="images"></div>
	<form action="/backend/route/search" method="post">
		<input type="text" name="search"> <input type="submit"
			value="搜索"
			class="button button-glow button-rounded button-raised button-primary">
	</form>
	<hr>
	<div class="tabs tabs-style-linetriangle">
		<nav>
		<ul>
			<li><a href="#tabs-1">审核中路线</a>
			<li><a href="#tabs-2">货架路线</a>
			<li><a href="#tabs-3">仓库</a>
			<li><a href="#tabs-4">未通过路线</a>
			<li><a href="#tabs-5">草稿箱</a>
		</ul>
		</nav>
		<div class="content-wrap">
			<section id="tabs-1" class="content-current">
			<table class="table table-striped table-hover">
				<thead>
					<tr class="info">
						<th>路线名</th>
						<th>日程数</th>
						<th>申请时间</th>
						<th></th>
					</tr>
				</thead>
				<c:forEach items="${result1}" var="vo" varStatus="status">
					<tr class="success">
						<td>${vo.name }</td>
						<td>${vo.nodes.size()}</td>
						<td>${vo.cTime.toString()}</td>
						<td><a href="javascript:void(0)"
							onclick="viewRoute(1,${status.index})"
							class="button button-glow button-rounded button-raised button-primary">查看</a>
							<input type="hidden" id="result1${status.index}"
							value="${vo.routeid}"></td>
					</tr>
				</c:forEach>
			</table>
			</section>
			<section id="tabs-2">
			<table class="table table-striped table-hover">
				<thead>
					<tr class="info">
						<th>路线名</th>
						<th>上架时间</th>
						<th>下架时间</th>
						<!-- <th>目前订单</th> -->
						<th></th>
						<th></th>
					</tr>
				</thead>
				<c:forEach items="${result2}" var="vo" varStatus="status">
					<tr class="warning">
						<td>${vo.name }</td>
						<td>${vo.cTime.toString()}</td>
						<td>${vo.eTime.toString()}</td>
						<!-- <td>目前订单数</td> -->
						<td><a href="javascript:void(0)"
							onclick="viewRoute(2,${status.index})"
							class="button button-glow button-rounded button-raised button-primary">查看</a>
							<input type="hidden" id="result2${status.index}"
							value="${vo.routeid}"></td>
						<td><a
							href="/backend/route/updateroute?rid=${vo.routeid}&status=3"
							class="button button-glow button-rounded button-raised button-primary">下架</a></td>
					</tr>
				</c:forEach>
			</table>
			</section>
			<section id="tabs-3">
			<table class="table table-striped table-hover">
				<thead>
					<tr class="info">
						<th>路线名</th>
						<th>日程数</th>
						<th>申请时间</th>
						<th></th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<c:forEach items="${result3}" var="vo" varStatus="status">
					<tr class="success">
						<td>${vo.name }</td>
						<td>${vo.nodes.size()}</td>
						<td>${vo.cTime.toString() }</td>
						<td><a href="javascript:void(0)"
							onclick="viewRoute(6,${status.index})"
							class="button button-glow button-rounded button-raised button-primary">上架</a>
							<input type="hidden" id="result6${status.index}"
							value="${vo.routeid}"></td>
						<td><a href="javascript:void(0)"
							onclick="viewRoute(3,${status.index})"
							class="button button-glow button-rounded button-raised button-primary">查看</a>
							<input type="hidden" id="result3${status.index}"
							value="${vo.routeid}"></td>
						<td><a
							href="/backend/route/updateroute?rid=${vo.routeid}&status=6"
							class="button button-glow button-rounded button-raised button-primary">删除</a></td>
					</tr>
				</c:forEach>
			</table>
			</section>
			<section id="tabs-4">
			<table class="table table-striped table-hover">
				<thead>
					<tr class="info">
						<th>路线名</th>
						<th>申请时间</th>
						<th>失败原因</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<c:forEach items="${result4}" var="vo" varStatus="status">
					<tr class="danger">
						<td>${vo.name }</td>
						<td>${vo.cTime.toString() }</td>
						<td>${vo.failReason}</td>
						<td><a href="javascript:void(0)"
							onclick="viewRoute(4,${status.index})"
							class="button button-glow button-rounded button-raised button-primary">查看</a>
							<input type="hidden" id="result4${status.index}"
							value="${vo.routeid}">
						<td><form id="deleteform" action="/backend/route/delete"
								method="post">
								<input type="hidden" name="deleteid" value="${vo.routeid}">
								<a
									class="button button-glow button-rounded button-raised button-primary"
									href="#" onclick="deleterecord()">删除</a>
							</form></td>
					</tr>
				</c:forEach>
			</table>
			</section>
			<section id="tabs-5">
			<table class="table table-striped table-hover">
				<thead>
					<tr class="info">
						<th>路线名</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<c:forEach items="${result5}" var="vo" varStatus="status">
					<tr class="success">
						<td>${vo.name }</td>
						<td><a href="javascript:void(0)"
							onclick="viewRoute(5,${status.index})"
							class="button button-glow button-rounded button-raised button-primary">查看</a>
							<input type="hidden" id="result5${status.index}"
							value="${vo.routeid}"></td>
						<td><form id="deleteform2" action="/backend/route/delete"
								method="post">
								<input type="hidden" name="deleteid" value="${vo.routeid}">
								<a
									class="button button-glow button-rounded button-raised button-primary"
									href="#" onclick="deletedraft()">删除</a>
							</form></td>
					</tr>
				</c:forEach>
			</table>
			</section>
		</div>
	</div>
	<div id="dialog" title="路线详情">
		<div class="row">
			<div id="name"></div>
		</div>
		<hr>
		<div class="row">
			<div id="files">
			<ul class="gallery" id="gallery">
			<c:forEach begin="0" end="16">
			<li><a href="#"><img src="#"></a></li>
			</c:forEach>
			</ul>
			</div>
			<script src="/resource/js/hostel/zoom.min.js"></script> 
		</div>
		<hr>
		<div class="row">
		  <div class="col-md-2"> 行程安排:</div>
			<div id="nodes" class="col-md-10"></div>
		</div>
		<hr>
		<div class="row">
		 <div class="col-md-2"> 车型:</div>
			<div id="cars" class="col-md-7"></div>
		</div>
		<hr>
		<div class="row">
			<label  class="col-md-2">发团时间：</label> <label
				id="days"></label>
		</div>
		<hr>
		<form action="/backend/route/displaylist" method="post">
			<div class="form-group">
				<input type="hidden" name="routeid" id="passid">
				<div class="col-lg-6 control-label">
					<input type="submit" value="编辑" id="sub"
						class="button button-glow button-rounded button-raised button-primary" />
				</div>
			</div>
		</form>
	</div>
	<div id="updialog" title="上架确认" class="form-horizontal">
		<form action="/backend/route/updateroute" method="post">
			<div class="form-group">
				<input type="hidden" name="uprouteid" id="uprouteid">
				<div class="col-lg-5 control-label">
					<label for="from">上架时间</label><input type="text" id="from" readonly="readonly"
						name="stime" tabindex="-1">
				</div>
				<div class="col-lg-5 control-label">
					<label for="to">下架时间</label><input type="text" id="to" name="etime" readonly="readonly"
						tabindex="-1">
				</div>
			</div>
			<br>
			<br>
			<input type="submit" value="确定"
				class="button button-glow button-rounded button-raised button-primary"
				id="subtime" />
		</form>
	</div>
	<script src="/resource/js/cbpFWTabs.js"></script>
	<script>
			(function() {
				[].slice.call( document.querySelectorAll( '.tabs' ) ).forEach( function( el ) {
					new CBPFWTabs( el );
				});
			})();
		</script>
</body>
</html>