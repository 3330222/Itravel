<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/jsp/share/tagLibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>路线列表</title>
<style>
.col-1{
width:30%;
height:250px;
float:left;
margin:15px;
padding:10px 10px 0px 10px;
border: #C1C1C1 solid 1px;
background-color: #FFFFFF; 
border-radius:5px;
}
.warnMsg{
background-color:#f2dede;
color:#b94a48;
padding:10px;
margin:10px;
display:none;
}
</style>
<script>
$(function() {
	var click = 0;
	
	$(window).scroll(function(){
        if  ($(document).height() <= $(window).scrollTop() + $(window).height()){    
            showMore();
        }
	});
	
	function showMore() {
		click++;
		$.getJSON("/showMoreAll", {})
			.done(function(data) {
				var len = data.length;
				if(len - click*6<0){
					$("#msg").text("已显示全部的精品路线").css("display","block");
				}else {
					for (var i =0;i<6;i++) {
						var route = data[click*6+i];
						if(route != null){
							var d = $("<div>").addClass("col-1");
							var a = $("<a>").attr("href","/order/viewRoute?routeid="+route[3]);
							$("<img>").addClass("list_img").attr("src",route[0]).appendTo(a);
							var p1 = $("<p>").css("text-align","center").text(route[1]);
							d.append(a).append(p1).append(p2);
							$("#more").append(d);
							
						}
					}
					init();
				}
			})
	}
	
})
</script>
</head>
<%-- <body>

<div class="common_body" >
</div> 



<div class="blog">
	<div class="container">
	
	<!-- <div class="blog-top">
        <div class ="col-md-3"></div>
		<div class="col-md-6 ">
			<div class="wow bounceInLeft" style ="text-align:left ;">
		        <a href="journeyDetails.html" ><img src="/resource/image/p4.jpg" alt="image" class="img-responsive travellist_img"></a>
		     	<h3 class="wow bounceInRight" style ="font-family: 微软雅黑,Microsoft YaHei;color: rgb(0, 176, 240);">
		     	    <a href="journeyDetails.html">老板说这里有个title</a>
		     	</h3>
		     	<div class=" wow bounceInLeft">
		  		   <p>发布：<a href="journeyDetails.html">客栈名</a> </p>
		  		</div>
		     	<p class ="wow bounceInRight">老板还要求这里加一段description简介</p>
		        <a class="hvr-shutter-out-vertical wow bounceInLeft " href="journeyDetails.html">Read More</a>
			</div>
		</div>	
		</div>
		<div class ="col-md-3"></div>
			<div class="clearfix"> </div> -->
		 <c:forEach items="${list}" var="route" begin="0" end="5" step="2" varStatus="status">
		<div class="row firstlist">
			<div class="col-md-2"></div>
			<div class="col-md-4 col-sm-12">
			<c:url value="/order/viewRoute" var="myURL">
			   <c:param name="routeid" value="${route.routeid }" ></c:param>
			</c:url>
				<a href="${myURL}" ><img class="list_img" src=${route.themeImageUrl } alt="" /></a>
				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-3">
						<a href="#"> <img class="media-object list_subimg"
							src="/resource/image/title.png" alt="...">
						</a>
					</div>
					<div class="col-md-8">
						<div class="list_subtitle">
							<p>
								<span>${route.name}</span>
							</p>
							<p>
								<span class="list_subtitle2">老板说这有个副标题，谢谢老板！</span> <br />
							</p>
						</div>
					</div>
				</div>
			</div>
			
			<div class="col-md-4 col-sm-12">
			<c:url value="/order/viewRoute" var="myURL1">
			   <c:param name="routeid" value="${list[status.index+1].routeid }" ></c:param>
			</c:url>
				<a href="${myURL1 }"><img class="list_img" src=${list[status.index+1].themeImageUrl } alt="" /></a>
				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-3">
						<a href="#"> <img class="media-object list_subimg"
							src="/resource/image/title.png" alt="...">
						</a>
					</div>
					<div class="col-md-8">
						<div class="list_subtitle">
							<p>
								<span>${list[status.index+1].name }</span>
							</p>
							<p>
								<span class="list_subtitle2">老板说这有个副标题，谢谢老板！</span> <br />
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>		 
</div>
</body> --%>
	<body >
	<!-- <div class="common_body" >
</div>--> 
		<div style="margin-left:10%;margin-right:10%;">
		
		<c:forEach items="${list}" var="route" end="5" varStatus="status">
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
		
		<table width = "100%" height = "100%" >
		<tr width = "100%" height = "100%">
		<td width = "10%">
		<div></div>
		</td>
		<td>
		<div style="text-align: center;">
		<span id="msg" class="warnMsg"></span>
		</div>
		</td>
		<td width = "10%">
		<div></div>
		</td>
		</tr>
		</table>
	</body>
</html>