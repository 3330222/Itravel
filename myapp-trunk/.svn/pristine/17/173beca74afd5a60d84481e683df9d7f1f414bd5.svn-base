<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>jquery test</title>
    <script src="/resource/js/jquery/jquery-2.1.1.js"> </script>
    <script src="/resource/js/jquery/jquery-ui.js"> </script>
   
<script>
 $(function(){
	
	$("#allRoutes").click(function(){
		document.location.href='/admin/applicationList';
	});
	
	$("#invalidatedRoutes").click(function(){
		document.location.href='/admin/applicationListWithPara?display=0';
	});
	
	$("#validatedRoutes").click(function(){
		document.location.href='/admin/applicationListWithPara?display=12';
	});

	$("#successRoutes").click(function(){
		document.location.href='/admin/applicationListWithPara?display=2';
	});
	
	$("#failRoutes").click(function(){
		document.location.href='/admin/applicationListWithPara?display=1';
	});
});
  </script>
  <style>
  .frame > div{
background: #ffe100;
border-bottom: 1px solid #efcd02;
color: #cb9f07;
padding: 15px;
margin-bottom: 10px;
border-radius: 3px;
width:100%;
}
  </style>
</head>
 
<body>
<div class="frame">
<div class="tab" id="allRoutes">全部路线</div>
<div class="tab" id="invalidatedRoutes">待审核路线</div>
<div class="tab" id="validatedRoutes">已审核路线</div>
<div class="tab" id="successRoutes">已审核成功路线</div>
<div class="tab" id="failRoutes">已审核失败路线</div>
</div>
</body>
</html>