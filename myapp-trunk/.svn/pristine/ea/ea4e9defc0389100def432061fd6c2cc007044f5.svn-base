<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Random"%>
<%@page import="java.util.Date"%>
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
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="/resource/css/hostel/material-cards.css">
<link rel="stylesheet" href="/resource/css/personalTable.css">
<link rel="stylesheet" href="/resource/css/button.css">
<link rel="stylesheet" href="/resource/css/bootstrap.css">
<script src="/resource/js/jquery/jquery.min.js" type="text/javascript"></script>
<link href="/resource/css/hostel/circle.css" rel="stylesheet"
	type="text/css" media="all" />
</head>
<style>
.
</style>
<body>
	<div class="partner_type">
		<h1 >我发起的约伴</h1>
	</div>
	<div class="row">
	<c:forEach begin="1" end="4" var="index">
		<div class="col-md-4">
			<article class="material-card Blue" id="own${index}">
			<h2>
				<span></span> <strong> 2015年8月10日 &nbsp; &nbsp; &nbsp;
					&nbsp; 天数:<%=new Random().nextInt(10)%>
				</strong>
			</h2>
			<div class="mc-content">
				<div class="img-container">
					<img class="img-responsive"
						src="/resource/image/headSamplephoto/sample10.jpg">
				</div>
				<div class="mc-description">
					<center>泰山</center>
					<p>岱宗夫如何？齐鲁青未了。 造化钟神秀，阴阳割昏晓。 荡胸生层云，决眦入归鸟。 会当凌绝顶，一览众山小。</p>
				</div>
			</div>
			<a class="mc-btn-action"> <i class="glyphicon glyphicon-th-list"></i>
			</a>
			<div class="mc-footer">

				<span>已参与人数: <%=new Random().nextInt(10)%>/10
				</span> <input type="button"
					class="button button-raised button-primary button-pill button-small"
					value="查看"> <input type="button"
					class="button button-raised button-primary button-pill button-small"
					value="解散" onclick="quit1(${index})">
			</div>
			</article>
		</div>
	</c:forEach>
	 </div>
  
	<div class="partner_type">
		<h1 >我加入的约伴</h1>
	</div>
	
	<div class="row">
	<c:forEach begin="1" end="6" var="index">
			<div class="col-sm-4">
				<article class="material-card Red" id="other${index}">
				<h2>
					<span>用户${index}</span> <strong> 2015年8月10日 &nbsp; &nbsp;
						&nbsp; &nbsp; 天数:<%=new Random().nextInt(10)%>
					</strong>
				</h2>
				<div class="mc-content">
					<div class="img-container">
						<img class="img-responsive"
							src="/resource/image/headSamplephoto/sample${index}.jpg">
					</div>
					<div class="mc-description">
						<center>长江</center>
						<p>滚滚长江东逝水，浪花淘尽英雄。 是非成败转头空。 青山依旧在，几度夕阳红。 白发渔樵江渚上，惯看秋月春风。
							一壶浊酒喜相逢。 古今多少事，都付笑谈中。</p>
					</div>
				</div>
				<a class="mc-btn-action"> <i class="glyphicon glyphicon-th-list"></i>
				</a>
				<div class="mc-footer">
					<div>
						<span>已参与人数:<%=new Random().nextInt(10)%>/10
						</span> <input type="button"
							class="button button-raised button-primary button-pill button-small"
							value="查看"> <input type="button"
							class="button button-raised button-primary button-pill button-small"
							value="退出" onclick="quit2(${index})">
					</div>
				</div>
				</article>
			</div>
		</c:forEach>
		</div>
	<script>
		$(function() {
			$('.material-card > .mc-btn-action').click(function() {
				var card = $(this).parent('.material-card');
				var icon = $(this).children('i');
				card.toggleClass('mc-active');
			});
		
		});
	</script>
</body>
</html>