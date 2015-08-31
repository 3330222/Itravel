<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/share/tagLibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <title>Personal Info Right</title>
    <link rel="stylesheet" href="/resource/css/jquery/jquery-ui.css">
    <link rel="stylesheet" href="/resource/css/CssForLena.css">
    <script src="/resource/js/jquery/jquery-2.1.1.js"> </script>
    <script src="/resource/js/jquery/jquery-ui.js"> </script>
    <script src="/resource/js/jquery/jquery.bpopup.js"> </script>
 	<script src="/resource/js/core/syscore-1.0.js"> </script>
 	<script src="/resource/js/validateID.js"> </script>
 	<script src="/resource/js/chineseDatepicker.js"></script>
 	<script src="/resource/js/area.js" type="text/javascript"></script>
	<style>
    .tab{
	text-align: center;
	background-color: #eee;
	color: #333;
	width:140px;
	margin: 10px;
	border-radius: 5px;
	padding: 5px;
	}
	.tab2{
	text-align: center;
	color: #333;
	width:180px;
	margin: 10px;
	padding-top:5px;
	}
	.tab3{
	width:850px;
	margin: 10px;
	padding-top:5px;
	}
	.tab4{
	padding-left: 15px;
	}
	.tab:hover, .active{
	background-color: #d5d5d5;
	color: #fff;
	}
	.verti{
	margin-top:30px;
	}
	</style>
   	<script>
   	var path = ''
   	$(function(){
		var section = location.pathname.split("/");
		var cur =  section[2];
		$("#"+cur).addClass("active");
   		
   		$("#birthday").datepicker(); 
		
   		    var $radios = $('input:radio[name=gender]');
   		    if($radios.is(':checked') === false) {
   		        $radios.filter('[value="${vo.gender}"]').prop('checked', true);
   		    }  
   		 
   		$('#occupation option[value="${vo.occupation}"]').attr("selected",true);
   		
   		$('#headPhoto').change(function () {
			 var tmppath = URL.createObjectURL(event.target.files[0]);
			 var filePath=$('#headPhoto').val();
			 console.log(filePath);
			 if(filePath != null || filePath != ""){
				 $("#uploadHeadImg").fadeIn("fast").attr('src',tmppath);
			 }			  
		});
   		
   	  	if("${vo.headPhotoPath}" != null || "${vo.headPhotoPath}" != ""){
   			$("#uploadHeadImg").attr('src',"${vo.headPhotoPath}" );   			
   		}
   	  	
   	 if("${vo.realPhotoPath}" != null || "${vo.realPhotoPath}" != ""){
			$("#uploadImg").attr('src',"${vo.realPhotoPath}" );   			
		}
   		
		/* var data = "${vo.destFuture}";
		if(data != null ){
			for (var i in splitArr(data)){
	        	$("#tags").append(createLi(splitArr(data)[i]));
	        }
		}
		
		var data1 = "${vo.destHistory}";
		if(data != null){
	        for (var i in splitArr(data1)){
	        	$("#tags2").append(createLi(splitArr(data1)[i]));
	        }
		}
		
		 $("#AddTag").click(function(){			   
		    	var tag=$.trim($("#tagValue").val());
		    	if(tag != ""){
		    		if(ifContains("tags",tag) == 0){

			    		$("#tags").append(createLi(tag));
			    		tag = "f"+tag;
			    		$.getJSON(path+"/personal/saveTag", {tag: tag, userid:"${vo.userId}"});
			    		
		    		}
		    		else{
		    			alert("你输入了相同信息");
		    		}
		    		$("#tagValue").val("");
		    	}	    	
		    })
		 
		 $("#AddTag2").click(function(){			   
		    	var tag2=$.trim($("#tagValue2").val());
		    	if(tag2 != ""){
		    		if(ifContains("tags2",tag2) == 0){
				    	$("#tags2").append(createLi(tag2));
				    	tag2 = "h"+tag2;
				    	$.getJSON(path+"/personal/saveTag", {tag: tag2, userid:"${vo.userId}"});
		    		}
		    		else{
		    			alert("你输入了相同信息");
		    		}
		    		$("#tagValue2").val("");
		    	}	    	
		    }) */
		    
		 function ifContains(val, tag){
			 var count = 0;
			 $("#"+val).find("li").each(function( index ) {

				 if($(this).find("span:last-child").text() == tag){
					 count++;
				 }	
			});
			 return count;
		 }   
		    
		 $("#tags").on('click', '.item', function(){
			 	var val = $(this).find("span:last-child").text();
			    $(this).remove();
			    $.getJSON(path+"/personal/removeTag", {tag: "df"+val, userid:"${vo.userId}"});
		 });
		 
		 $("#tags2").on('click', '.item', function(){
			    var val = $(this).find("span:last-child").text();
			    $(this).remove();
			    $.getJSON(path+"/personal/removeTag", {tag: "dh"+val, userid:"${vo.userId}"});
		 });

		 if("${vo.realInfoStatus}" == 1){
			 $("#apply").click(function(){
				 $("#light").css("display", "block");
				 $("#fade").css("display", "block");
			 })	
		 }else if("${vo.realInfoStatus}" == 2){
			 $("#apply").text("认证审核中");
		 }else if("${vo.realInfoStatus}" == 3){
			 $("#apply").text("实名认证失败");
			 $("#failReason").text("实名认证失败");
			 $("#apply").click(function(){
				 $("#light").css("display", "block");
				 $("#fade").css("display", "block");	 
			 })
		 }else if("${vo.realInfoStatus}" == 4){
			 $("#apply").text("实名认证成功");
		 }
		 	 
		 
		 $('#realPhoto').change(function () {
			 var tmppath = URL.createObjectURL(event.target.files[0]);
			 var filePath=$('#realPhoto').val(); 
			 if(filePath != null || filePath != ""){
				 $("#uploadImg").fadeIn("fast").attr('src',tmppath);
			 }
		});
		 
		 $('#address1').val("${vo.province}"+ "-" +"${vo.city}"+ "-"+ "${vo.country}")
		 
		 $("#s_county").change(function(){
				$('#address1').val($('#s_province').val() + "-" + $('#s_city').val() + "-"+ $('#s_county').val())
		})
		 
		 $('#s_province option[value="${vo.province}"]').attr("selected",true);
		 $("#s_city").append($("<option></option>").attr("value","${vo.city}").text("${vo.city}"));
		 $('#s_city option[value="${vo.city}"]').attr("selected",true);
		 $("#s_county").append($("<option></option>").attr("value","${vo.country}").text("${vo.country}"));
		 $('#s_county option[value="${vo.country}"]').attr("selected",true);
		 
		/*  function createLi(tag){
				var img = $("<img>").attr("src","/resource/image/delete.png");
		    	var span = $("<span>").append(img);
		    	var span2 = $("<span>").text(tag);
		    	var li = $("<li>").append(span).append(span2).addClass("item");
		    	return li;
			}
		 
		function splitArr(data){
			var arr = data.split(",");
			for(var i in arr){
				if(arr[i] == "" ||arr[i] == null){
		            arr.splice(i,1);
		        }
			}
			return arr;
		} */
		function validateName(name){
			if(/[^\u4E00-\u9FA5]{2,4}/.test(name))
				return true;
			else{
				return false;
			}
		}
		function validateReal(){
			var flag1 = validateID($("#Account"));
			var flag2 = validateName($("#RealName"));
			var flag3 = false;
			if($("#realPhoto") != null)
				flag3 = true;
			console.info(flag1+"...."+flag2+"...."+flag3);
		}
		$("#s_county").change(function(){
			$('#address1').val($('#s_province').val() + "-" + $('#s_city').val() + "-"+ $('#s_county').val())
		})
		
   	});
   	</script>
</head>
<body>
	<div id="light" class="white_content">
   	   <a href = "javascript:void(0)" onclick = "document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'" style="float:right">Close</a>				    
		    <p style="text-align:center">实名认证</p>
		    <form:form method="post" action="/personal/saveRealInfo" enctype="multipart/form-data" modelAttribute="userInfo">
		    	<div >
				    <div style="width:60%; float:left; margin-left:10%; margin-top:20px;">
				         <div>真实姓名</div>
				         <div><form:input type="text" path="realName" required="required" id="RealName" value="${vo.userName }"/></div>
				         <div>身份证号</div>
				         <div><form:input type="text" path="idNum" required="required" id="idNum" value="${vo.idNum }"/></div>
				    </div>
				    <div style="width:30%; float:left;" >
				    	 <div class="imgcontain">
				         	<input type="file" id="realPhoto" name="realPhoto" class="upload"/>
				         	<img id="uploadImg" src="/resource/image/title.png" class="imgupload"/>            				 
				         </div>
				         <div style="z-index:6">点击上传图片</div>
				         <form:hidden path="userId" value="${vo.userId}"/>
				    </div>
			    </div>
			    <p id="failReason" class="bg-warning text-center"></p>
		    	<div style="text-align:center;padding-top:40px;"><input type="submit" value="提交审核" class="save" id="Btn" onclick="validateReal();"></div>
		    </form:form>
	    </div>
	    <div id="fade" class="black_overlay"></div>
<form:form action="/personal/saveInfo" enctype="multipart/form-data" modelAttribute="userInfo" style="padding-top:20px;">
	<div class="row">
		<div class="col-lg-1">			
			<!-- <div class="input-group tab2">
			   <input id="tagValue" type="text" class="form-control" placeholder="想去的地方">
			   <div class="input-group-addon submit" id="AddTag">添加</div>
		   </div>
		   <ul id="tags"></ul>
		   <div class="input-group tab2">
			   <input id="tagValue2" type="text" class="form-control" placeholder="去过的的地方">
			   <div class="input-group-addon submit" id="AddTag2">添加</div>
		   </div>
		   <ul id="tags2"></ul> -->
		</div>
		<div class="col-lg-10 col-lg-offset-1">
			
			<div class="row tab3">
				<div class="col-lg-2">
					<div class="imgcontain">
			         	<input type="file" id="headPhoto" name="headPhoto" class="upload"/>
			         	<img id="uploadHeadImg" src="/resource/image/title.png" class="imgupload"/> 			         	         				 
			         </div>
				</div>
				<div class="col-lg-2"><div class="verti"><label>点击上传头像</label></div></div>
				<div class="tab col-lg-8 verti" id="apply">申请实名认证</div>
			</div>
			<div class="row tab3">
				<div class="col-lg-6 tab4">
					<div >昵称</div>
					<form:input type="text" path="nickName" value="${vo.nickName}" class="form-control"/>	
				</div>
				<div class="col-lg-6 tab4">
					<div >性别</div>
					<div>
						<form:radiobutton path="gender" value="1" />男
		   				<form:radiobutton path="gender" value="2" />女 
		   				<form:radiobutton path="gender" value="3" />未知 
		   			</div>
				</div>
			</div>
			<div class="row tab3">
				<div class="col-lg-6 tab4">
					<div>生日</div>
					<form:input type="text" class="form-control" placeholder="请输入日期" id="birthday" path="birthday" value="${vo.birthday}" readonly="true"/>
				</div>
				<div class="col-lg-6 tab4">
					<div>常在地(如果想保存地址，请选择完整的省，城市，县)</div>
					<div>
						<%-- <form:select class="form-control" path="address">
				       		<form:options items="${addressList}" />
			    		</form:select> --%>
			    			<label> <select id="s_province" name="s_province" class="form-control"class=""
								required></select></label>&nbsp;&nbsp; <label><select
								id="s_city" name="s_city" required width="200" class="form-control"></select>
							</label>&nbsp;&nbsp;<label><select id="s_county" name="s_county" required
								width="200" class="form-control"></select></label>
							<script type="text/javascript">
							 _init_area();
							</script>
							<form:hidden path="address" id="address1" value=""/>
					</div>
				</div>
			</div>
			<div class="row tab3" >
				<div class="col-lg-6 tab4">
					<div>职业</div>
					<div>
					    <form:select class="form-control" path="occupation">
				        	<form:options items="${occupationList}" />
		    			</form:select>
					</div>
				</div>
				<div class="col-lg-6"></div>
			</div>
			<div class="row tab3 tab4">
				<div>旅游宣言</div>
				<form:textarea class="form-control" rows="5" path="tourDeclaration" placeholder="${vo.tourDeclaration}" autocomplete="off" />
			</div>
				<form:hidden path="userId" value="${vo.userId}"/>				    
		    <div class="row tab3 text-center">
				<input type="Submit" value="保存" class="save" id="saveBtn"/>
			</div>
		</div>
	</div>
</form:form>
		       
</body>
</html>