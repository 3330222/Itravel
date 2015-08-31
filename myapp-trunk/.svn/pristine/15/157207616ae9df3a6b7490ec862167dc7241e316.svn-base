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
<body>
	<div class="row">
		<div class="col-lg-4">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<span class="label label-success pull-right">月</span>
					<h5>当前收入 &nbsp; 10000</h5>
				</div>
				<div class="ibox-content">
					<h1 class="no-margins">50,200</h1>
				</div>
			</div>
		</div>
		<div class="col-lg-4">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<span class="label label-info pull-right">月</span>
					<h5>当前订单 &nbsp;&nbsp; 200</h5>
				</div>
				<div class="ibox-content">
					<h1 class="no-margins">275,800</h1>
				</div>
			</div>
		</div>
		<div class="col-lg-4">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<span class="label label-danger pull-right">最近一个月</span>
					<h5>活跃用户 &nbsp;&nbsp;&nbsp;&nbsp;1000</h5>
				</div>
				<div class="ibox-content">
					<h1 class="no-margins">80,600</h1>
				</div>
			</div>
		</div>

		<div class="col-lg-4">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<span class="label label-primary pull-right"></span>
					<h5>实名认证客栈</h5>
				</div>
				<div class="ibox-content">
					<h1 class="no-margins"></h1>
				</div>
			</div>
		</div>
		<div class="col-lg-4">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<span class="label label-primary pull-right"></span>
					<h5>实名认证游客</h5>
				</div>
				<div class="ibox-content">
					<h1 class="no-margins">${usernum}</h1>
				</div>
			</div>
		</div>

		<div class="col-lg-4">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<span class="label label-primary pull-right"></span>
					<h5>已通过路线</h5>
				</div>
				<div class="ibox-content">
					<h1 class="no-margins">${ routebumber}</h1>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12">
			<div class="row">
				<div class="col-lg-6">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<h5>待审核认证列表</h5>
							<div class="ibox-tools">
								<a class="collapse-link"><span class="label label-danger pull-right">${result1.size()}</span> <i
									class="glyphicon glyphicon-chevron-down"></i>
								</a>
							</div>
						</div>
						<div class="ibox-content">
							<table class="table table-hover no-margins">
								<thead>
									<tr>
										<th>用户</th>
										<th>地址</th>
										<th>邮箱</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${result1}" var="map">
										<tr>
											<td>${map.value.account}</td>
											<td>${map.value.address}</td>
											<td>${map.value.email}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<h5>待审核路线列表</h5>
							<div class="ibox-tools">
								<a class="collapse-link"><span class="label label-danger pull-right">${result2.size()}</span> <i
									class="glyphicon glyphicon-chevron-down"></i>
								</a>
							</div>
							<div class="ibox-content">
								<table class="table table-hover no-margins">
									<tbody>
										<c:forEach items="${result2}" var="map">
											<tr>
												<td>${map.value.name}</td>
												<td>${map.value.cTime.toString()}</td>
												<td>${map.value.eTime}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<h5>Top</h5>
							<div class="ibox-tools">
								<a class="collapse-link"> <i
									class="glyphicon glyphicon-chevron-down"></i>
								</a>
							</div>
						</div>
						<div class="ibox-content">
							<table class="table table-hover margin bottom">
								<thead>
									<tr>
										<th style="width: 10%" class="text-center">序号</th>
										<th>交易</th>
										<th class="text-center">交易金额</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td class="text-center">1</td>
										<td> 
										</td>

										<td class="text-center"><span class="label label-primary">&yen;58300</span></td>

									</tr>
									<tr>
										<td class="text-center">2</td>
										<td></td>

										<td class="text-center"><span class="label label-primary">&yen;32700</span></td>

									</tr>
									<tr>
										<td class="text-center">3</td>
										<td></td>

										<td class="text-center"><span class="label label-warning">&yen;31400</span></td>

									</tr>
									<tr>
										<td class="text-center">4</td>
										<td></td>

										<td class="text-center"><span class="label label-primary">&yen;24400</span></td>
									</tr>
									<tr>
										<td class="text-center">5</td>
										<td></td>
										<td class="text-center"><span class="label label-primary">&yen;23500</span></td>
									</tr>
									<tr>
										<td class="text-center">6</td>
										<td></td>

										<td class="text-center"><span class="label label-primary">&yen;10000</span></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>