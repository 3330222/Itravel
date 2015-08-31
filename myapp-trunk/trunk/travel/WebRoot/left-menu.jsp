<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/share/tagLibs.jsp" %>
 
<html>
<head>
    <title>jquery test</title>
    <script src="/resource/js/jquery/jquery-2.1.1.js"> </script>
    <script src="/resource/js/jquery/jquery-ui.js"> </script>
    <script> 
    $(function(){
    	loadMenu();
		
		var $button3 = $("#button3");
		$button3.on("click",function(){
			console.info("button 3 clicked");
			loadMenu();
		});
		
    });
    
    function loadMenu(){
    	
		var promise3 = $.getJSON("/employee/queryAllEmployees");
		promise3.done(function(data) {
		    console.info("result returned...");
		   
		   // if($.isArray(data)){
				//$.each(data, function (index, value) {
			      //  $("<p>").text( value.employeeName + ", " + value.address)
			                    // .appendTo($("#content"));
			   // });
			//}
		});
		promise3.fail(function(data) {
		    console.info("emplyee creation fails");
		});
    }
    
    </script>

</head>
 
<body>
    
    <div id="jsonModule" > </div>
    <div class="menu">
	    <ul>
	        <li>
	            <a>
	                 <span>
	                     <span></span>
	                     <span>四川</span>
	                 </span>
	            </a>
	        <li>
	        <li>
	            <a>云南</a>
	        <li>
	    </ul>
     </div>
    <a href="http://baidu.com" id="link"> </a>
    
    <input type="button" id="button3" value="new emp"/>
   
</body>
</html>