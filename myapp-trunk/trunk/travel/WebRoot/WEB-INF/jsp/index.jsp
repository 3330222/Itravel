   <%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- <link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="/resource/css/hostel/material-cards.css">
<link rel="stylesheet" href="/resource/css/personalTable.css">
<link rel="stylesheet" href="/resource/css/button.css">
<link rel="stylesheet" href="/resource/css/bootstrap.css">
<script src="/resource/js/jquery/jquery.min.js" type="text/javascript"></script> -->

<div class="row first-slider" >
	<div class="col-md-12">
		<div id="carousel-example-generic" class="carousel slide slider"
			data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#carousel-example-generic" data-slide-to="0"
					class="active"></li>
				<li data-target="#carousel-example-generic" data-slide-to="1"></li>
				<li data-target="#carousel-example-generic" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<a href="#"><img src="/resource/image/5.jpg" alt="..."></a>
					<div class="carousel-caption"></div>
				</div>
				<div class="item">
					<a href="#"><img src="/resource/image/4.jpg" alt="..."></a>
					<div class="carousel-caption"></div>
				</div>
				<c:forEach items="${list2}" var="route" varStatus="status">
				<div class="item">
					<a href="#"><img src=${route.themeImageUrl } alt="..."></a>
					<div class="carousel-caption"></div>
				</div>
				</c:forEach>
			</div>
          
		</div>
	</div>
</div>
	 <body style="background-color: #EFEFEF;">
		<div class="text-center col-lg-12 verti" ><h3>热门旅游路线</h3></div>
		<div class="row" style="margin-left:10%;margin-right:10%;">
		
		  <div class="col-sm-12 col-xs-12">
			<c:forEach items="${result}" var="route" varStatus="status">
			<div class="col-1">
				<c:url value="/order/viewRoute" var="myURL">
				   <c:param name="routeid" value="${route.routeid }" ></c:param>
				</c:url>
				<a href="${myURL }" ><img class="list_img" src=${route.themeImageUrl } alt="" /></a>
					<p style="text-align: center;">${route.name}</p>
			</div>
			</c:forEach>
			<div id="more"></div>	
		</div>
		</div>
		<div class="row" style="margin-left:10%;margin-right:10%;">
		<div class="text-center col-md-12" style="margin-top:50px;"><h3>寻找约伴</h3></div>
			<div class="DIYTour">
				<div class="row">
					<div class="col-md-3">
					<img src="/images/2015-08-01/dada/ffc1a4bd56cc41f181955fc71adbd69f.jpg" class="tourOwnerPhoto"></div>
					<div class="col-md-9"><div class="verti">Anne大叔</div></div>
				</div>	
				<div>
				<c:url value="/personal/tourDIY" var="myURL"></c:url>
				<a href="${myURL }" >
					<p>8月21日 昆明～攀枝花～泸沽湖(1,2)～虎跳峡镇(3)～虎跳峡徒步(4,5)～德钦飞来寺(6)～雨崩徒步(7,8,9)</p>
					<img class="list_img2" src="/images/2015-08-02/jerry111/895b5369239e466aa0eb550546e474b7.jpg" alt="" />
				</a>
				</div>
			</div>
			
			<div class="DIYTour">
				<div class="row">
					<div class="col-md-3">
					<img src="/images/2015-08-02/jerry111/895b5369239e466aa0eb550546e474b7.jpg" class="tourOwnerPhoto"></div>
					<div class="col-md-9"><div class="verti">Anne大叔</div></div>
				</div>	
				<div>
				<c:url value="/personal/tourDIY" var="myURL"></c:url>
				<a href="${myURL }" >
					<p>8月21日 昆明～攀枝花～泸沽湖(1,2)～虎跳峡镇(3)～虎跳峡徒步(4,5)～德钦飞来寺(6)～雨崩徒步(7,8,9)</p>
					<img class="list_img2" src="/images/2015-08-02/jerry111/895b5369239e466aa0eb550546e474b7.jpg" alt="" />
				</a>
				</div>
			</div>
			
			<div class="DIYTour">
				<div class="row">
					<div class="col-md-3">
					<img src="/images/2015-08-02/jerry111/895b5369239e466aa0eb550546e474b7.jpg" class="tourOwnerPhoto"></div>
					<div class="col-md-9"><div class="verti">Anne大叔</div></div>
				</div>	
				<div>
				<c:url value="/personal/tourDIY" var="myURL"></c:url>
				<a href="${myURL }" >
					<p>8月21日 昆明～攀枝花～泸沽湖(1,2)～虎跳峡镇(3)～虎跳峡徒步(4,5)～德钦飞来寺(6)～雨崩徒步(7,8,9)</p>
					<img class="list_img2" src="/images/2015-08-02/jerry111/895b5369239e466aa0eb550546e474b7.jpg" alt="" />
				</a>
				</div>
			</div>
			</div>		
	</body>








