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
.headPhoto{
	width: 100px;
    height: 100px;
    border-radius:50%;
    margin-bottom:20px;
}
.tourOwnerPhoto{
	width: 60px;
    height: 60px;
    border-radius:50%;
}
.warnMsg{
background-color:#f2dede;
color:#b94a48;
padding:10px;
margin:10px;
}
.tab{
text-align: center;
background-color: #eee;
color: #333;
width:120px;
margin: 10px;
border-radius: 5px;
padding: 5px;
}
.tab:hover, .active{
background-color: #d5d5d5;
color: #fff;
}
.DIYTour{
padding:10px;
margin:10px;
border: 1px solid #eee;
border-radius: 5px;
}
.DIYTour:hover{
background: #eee;
opacity: 0.8;  
}
</style>
<script>
$(function(){
	$("body").css('cursor', 'pointer'); 
	var path="";
	var section = location.pathname.split("/");
	var cur =  section[2];
	$("#"+cur).addClass("active");
	
	$("#info").click(function(){
		document.location.href=path+'/personal/info';
	});
	
	$("#order").click(function(){
		document.location.href=path+'/personal/order';
	});
	
	$("#tourDIY").click(function(){
		document.location.href=path+'/personal/tourDIY';
	});
	
	$("#getTourDIY").click(function(){
		document.location.href=path+'/personal/getTourDIY';
	});
	$("#myPartner").click(function(){
		document.location.href=path+'/personal/myPartner';
	});
	$("#findPartner").click(function(){
		document.location.href=path+'/personal/findPartner';
	});
	$("#notification").click(function(){
		document.location.href=path+'/personal/notification';
	});
	
	if("${headPath}" != null || "${headPath}" != ""){
		$("#uploadHeadImg").attr('src',"${headPath}" );			
	}
	
	$(".listTour").click(function(){
		document.location.href=path+'/personal/info';
	})
})
</script>
<body>
	
	<div class="row" style="padding-top:30px;">
		<div class="col-lg-1 col-lg-offset-2">
			<img id="uploadHeadImg" class="headPhoto">
	    	<div class="tab" id="info">个人主页</div>
	    	<div class="tab" id="order">我的订单</div>
	    	<!-- <div class="tab" id="tourDIY">发起拼团</div> -->
	    	<div class="tab" id="getTourDIY">我的拼团</div>
	    	<div class="tab" id="myPartner">我的寻伴</div>
	      <div class="tab" id="findPartner">发起寻伴</div>
		</div>
		<div class="col-lg-9">
			<div class="row">
				<div class="col-lg-1"></div>
				<%-- <c:forEach></c:forEach> 这里应该有个循环--%>
				<div class="col-lg-7 ">
					<div class="DIYTour ">
						<div class="row listTour">
							<div class="col-lg-4"><img id="OwnerImg" class="tourOwnerPhoto" src="/images/2015-08-01/dada/354a501c91db49cc9a3e06920fcedf7c.jpg"><span>远行的花儿</span></div>
							<div class="col-lg-4"></div>
							<div class="col-lg-4 text-right"><div style="margin-top:15px;">评论：N</div></div>
						</div>
					    <div style="margin-top:15px;">10 | 2015-08-21</div>
						<div>大娃出去玩</div>
						<div style="border-top: 1px solid;">参与者 1/10</div>
						<div><button>编辑</button><button>删除</button></div>
					</div>
					<div class="DIYTour">
						<div class="row listTour">
							<div class="col-lg-4"><img class="tourOwnerPhoto" src="/images/2015-08-01/dada/786012edd6a2463b89f9f087ad78d4f5.jpg"><span>远行的草儿</span></div>
							<div class="col-lg-4"></div>
							<div class="col-lg-4 text-right"><div style="margin-top:15px;">评论：N</div></div>
						</div>
					    <div style="margin-top:15px;">10 | 2015-07-21</div>
						<div>Jerry出去玩</div>
						<div style="border-top: 1px solid;">参与者 1/10</div>
						<div><button>编辑</button><button>删除</button></div>
					</div>
				</div>
				<div class="col-lg-4"></div>
			</div>
		</div>
	</div>
</body>
</html>