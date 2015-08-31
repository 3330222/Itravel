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
	
	$("#allRequest").click(function(){
		document.location.href='/admin/userAudition';
	});
	
	$("#validatedRequest").click(function(){
		document.location.href='/admin/userAuditionWithPara?display=1';
	});
	
	$("#invalidatedRequest").click(function(){
		document.location.href='/admin/userAuditionWithPara?display=2';
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
<div class="tab" id="allRequest">全部认证请求</div>
<div class="tab" id="validatedRequest">已认证请求</div>
<div class="tab" id="invalidatedRequest">未认证请求</div>
</div>
</body>
</html>