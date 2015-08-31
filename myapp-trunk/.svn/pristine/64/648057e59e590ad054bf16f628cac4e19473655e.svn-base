<%@ page contentType="text/html; charset=utf-8"  pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/share/tagLibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
    <title>jquery test</title>
    <script src="/resource/js/jquery/jquery-2.1.1.js"> </script>
    <script src="/resource/js/jquery/jquery-ui.js"> </script>
    <script> 
    $(function(){
    	console.info("content page");
		var promise3 = $.getJSON("/admin/queryAllApplication");
		promise3.done(function(data) {
		    console.info("result returned...");
		   
		    if($.isArray(data)){
				$.each(data, function (index, value) {
					
			        $("<p>").text(value.userName)
			                     .appendTo($("#content"));
			    });
			}
		});
		promise3.fail(function(data) {
		    console.info("emplyee creation fails");
		});
    });
    
    </script>

</head>
 
<body>
    <h1>Content 内容区</h1>
    <div id="content" class="table-div"> </div>
   
</body>
</html>