<%@ page contentType="text/html; charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/share/tagLibs.jsp" %>
 
<html>
<head>
    <title>发起拼团</title>
    <link rel="stylesheet" href="/resource/css/jquery/jquery-ui.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="/resource/css/personalTable.css">
    <script src="/resource/js/jquery/jquery-2.1.1.js"> </script>
    <script src="/resource/js/jquery/jquery-ui.js"> </script>
    <script src="/resource/js/chineseDatepicker.js"></script>
</head>
<style>

.tourOwnerPhoto{
	width: 60px;
    height: 60px;
    border-radius:50%;
}
.content>div{
border: 1px solid #eee;
border-radius: 10px;
padding:20px 20px 30px 20px;
margin:10px;
background: #eee;
}
.tourImg{
width:80%;
margin:10px;
border-radius:10px;
}
.info{
padding-top:30px;
}
</style>
<script>
$(function(){
	$("body").css('cursor', 'pointer'); 
	$("#nodes").accordion({
		collapsible : true,
		active : false,
		heightStyle: 'content'
		});	
})
</script>
<body >	
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8">
		<div class="content">
			<div class="row info text-center">
				<div><h2>${vo.name} ｜ ${vo.nodes.size()}天</h2></div>
				<div><img class="tourOwnerPhoto" src="${vo.hotel.headImageUrl }"></div>
				<div>由 ${vo.hotel.hostelname } 发起</div>
				<div class="row">
					<div class="col-md-12 "><img src="${vo.themeImageUrl }" class="tourImg"/></div>
				</div>
			</div>
			<div class="row text-center">
				<div><h3>路线详情</h3></div>
				<div class="col-lg-1"></div>
				<c:choose>
					<c:when test="${vo.nodes.size() == 1}">
					<div class="col-lg-10">
						<h3>第1天 | ${vo.nodes[0].name}</h3>
						<div class="nodelist">
							<h3>${vo.nodes[0].keywords}</h3>
							<img src="${vo.nodes[0].ipath }" class="tourImg">
							<h4>${vo.nodes[0].description}</h4>
							<h4>${vo.nodes[0].accommodation}</h4>
						</div>
					</div>
					</c:when>
					<c:otherwise>
						<div id="nodes" class="col-lg-10">					
							<c:forEach begin="1" end="${vo.nodes.size()}" varStatus="status">
								<h3>第${status.index}天 | ${vo.nodes[status.index-1].name}</h3>
								<div class="nodelist">
									<h3>${vo.nodes[status.index-1].keywords}</h3>
									<img src="${vo.nodes[status.index-1].ipath }" class="tourImg">
									<h4>${vo.nodes[status.index-1].description}</h4>
									<h4>${vo.nodes[status.index-1].accommodation}</h4>
								</div>
							</c:forEach>
						</div>
					</c:otherwise>
				</c:choose>				
				<div class="col-lg-1"></div>
			</div>
			<div class="row text-center">
				<div><h3>路线说明</h3><div class="form-label">${vo.des}</div></div>
				<div class="">
					<a href="/order/makeOrder?routeid=${vo.routeid}" class="button button-primary button-pill dianji">点击预订</a>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">评论</div>
				<div class="col-md-6 text-right">N条</div>
				<div class="input-group">
					<input type="text" class="form-control" id="" placeholder="输入评论内容">
					<div class="input-group-addon submit">评论</div>
			    </div>
			</div>
		</div>
		</div>
		<div class="col-md-2"></div>
	</div>
</body>
</html>