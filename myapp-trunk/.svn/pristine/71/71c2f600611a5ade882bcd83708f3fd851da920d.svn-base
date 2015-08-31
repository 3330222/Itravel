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
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<link rel="stylesheet" href="/resource/css/bootstrap.css">
<link rel="stylesheet" href="/resource/css/hostel/preview_styles.css">
</head>
<body>
	<div class="part">
		<h2>${vo.name}</h2>
		<br> <img src="${vo.themeImageUrl }" />
	</div>
	<br>
	<br>
	<div class="scene">
		<c:forEach begin="1" end="${vo.nodes.size()}" varStatus="status">
			<div class="page page-${status.index}">
				<div class="half left">
					<img src="${vo.nodes[status.index-1].ipath }">
				</div>
				<div class="half right">
					<div>
						<h1>第${status.index}天</h1>
						<br>
						<h5>${vo.nodes[status.index-1].name}</h5>
						<br>
						<h5>${vo.nodes[status.index-1].keywords}</h5>
						<br>
						<h5>${vo.nodes[status.index-1].description}</h5>
						<br>
						<h5>${vo.nodes[status.index-1].accommodation}</h5>
						<br>
					</div>
				</div>
			</div>
		</c:forEach>
		<div class="nav-panel">
			<div class="scroll-btn up"></div>
			<div class="scroll-btn down"></div>
			<%-- <nav>
		<ul>
			<c:forEach begin="1" end="${vo.nodes.size()}" var="num">
				<li data-target="num" class="nav-btn nav-page${num}"></li>
			</c:forEach>
		</ul> --%>
			</nav>
		</div>
	</div>
	<br>
	<br>
	<div class="description">
		<h3>路线说明:</h3>
		<h3>${vo.des}</h3>
	</div>
	<c:choose>
		<c:when test="${flag!='preview' }">
			<br>
			<hr>
			<div class="row">
				<a href="/order/makeOrder?routeid=${vo.routeid}" class="button button-primary button-pill dianji">点击预订</a>
			</div>
		</c:when>
	</c:choose>
	<br>
	<br>
	<script src='/resource/js/stopExecutionOnTimeout.js'></script>
	<script>
		$(document)
				.ready(
						function() {
							var pages = $('.page').length, scrolling = false, curPage = 1;
							function pagination(page, movingUp) {
								scrolling = true;
								var diff = curPage - page, oldPage = curPage;
								curPage = page;
								$('.page').removeClass('active small previous');
								$('.page-' + page).addClass('active');
								$('.nav-btn').removeClass('active');
								$('.nav-page' + page).addClass('active');
								if (page > 1) {
									$('.page-' + (page - 1)).addClass(
											'previous');
									if (movingUp) {
										$('.page-' + (page - 1)).hide();
										var hackPage = page;
										setTimeout(
												function() {
													$('.page-' + (hackPage - 1))
															.show();
												}, 600);
									}
									while (--page) {
										if (window.CP.shouldStopExecution(1)) {
											break;
										}
										$('.page-' + page).addClass('small');
									}
									window.CP.exitedLoop(1);
								}
								//console.log(diff);
								if (diff > 1) {
									for (var j = page + 1; j < oldPage; j++) {
										if (window.CP.shouldStopExecution(2)) {
											break;
										}
										$('.page-' + j + ' .half').css(
												'transition',
												'transform .7s ease-out');
									}
									window.CP.exitedLoop(2);
								}
								setTimeout(function() {
									scrolling = false;
									$('.page .half').attr('style', '');
									$('.page');
								}, 700);
							}
							function navigateUp() {
								if (curPage > 1) {
									curPage--;
									pagination(curPage, true);
								}
							}
							function navigateDown() {
								if (curPage < pages) {
									curPage++;
									pagination(curPage);
								}
							}
							$(document)
									.on(
											'mousewheel DOMMouseScroll',
											function(e) {
												if (!scrolling) {
													if (e.originalEvent.wheelDelta > 0
															|| e.originalEvent.detail < 0) {
														navigateUp();
													} else {
														navigateDown();
													}
												}
											});
							$(document).on('click', '.scroll-btn', function() {
								if (scrolling)
									return;
								if ($(this).hasClass('up')) {
									navigateUp();
								} else {
									navigateDown();
								}
							});
							$(document).on('keydown', function(e) {
								if (scrolling)
									return;
								if (e.which === 38) {
									navigateUp();
								} else if (e.which === 40) {
									navigateDown();
								}
							});
							$(document)
									.on(
											'click',
											'.nav-btn:not(.active)',
											function() {
												if (scrolling)
													return;
												pagination(+$(this).attr(
														'data-target'));
											});
						});
	</script>
</body>
</html>