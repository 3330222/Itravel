<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/share/tagLibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>jquery test</title>
    <script src="/resource/js/jquery/jquery-2.1.1.js"> </script>
    <script src="/resource/js/jquery/jquery-ui.js"> </script>
    <script> 
    $(function(){
    	console.info("page initialized");
    	var $employeeType =  $("#link");
		var promise = $.getJSON("http://localhost:9090/employee/queryRestJson");
		
		promise.done(function(data) {
			for(var pro in data){
				console.info(pro);
			}
			console.info(data["employeeName"]);
			
			$employeeType.prop("text",data["employeeName"]);
			
			var i = 1;
			while(i < 4){
				i++;
				$("<a>").prop("href","http://google.com")
				        .prop("text",data["employeeName"]).appendTo($("#jsonModule"));
				$("<br>").appendTo($("#jsonModule"));
			}
			i = 1;
			while(i < 13){
				i++;
				$("<p>").text(data["employeeName"]).appendTo($("#jsonModule"));
				
			}
		});
		
		var $button = $("#buttonnew");
		$button.on("click",function(){
			console.info("button clicked");
			var promise2 = $.getJSON("http://localhost:9090/employee/createEmployee");
			promise2.done(function(data) {
			    console.info("employeeCreated");
			});
			promise2.fail(function(data) {
			    console.info("emplyee creation fails");
			});
		});
		
		var $button4 = $("#button4");
		$button4.on("click",function(){
			console.info("button 4 clicked");
			allUsers();
		});
		
		function allUsers(){
	    	
	    	var promise4 = $.getJSON("/user/list");
			promise4.done(function(data) {
			    console.info("usres queries...");
			});
	    }
		
    });
    
    </script>
    <style>
    .QQ{
    display:block;
    text-align:center;
    }
    </style>
</head>
 
<body>
    <h1>QQ Test</h1>
    <div class=QQ>
    <a target="_blank" href="http://wpa.qq.com/msgrd?V=1&uin=123456789&exe=qq&Site=qq&menu=yes">
   <img border="0" src="/resource/image/menu_img.jpg" alt="QQAPI" title="QQAPI"><span class=QQ>QQ</span>
   </a>
    </div>
    <div id="jsonModule" > </div>
    <br>

   <br>
    <input type="button" id="buttonnew" value="new emp"/>
    
      <input type="button" id="button4" value="all users"/>
   
</body>
</html>