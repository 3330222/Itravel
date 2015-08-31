<%@ page contentType="text/html; charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/share/tagLibs.jsp" %>
 
<html>
<head>
    <title>jquery test</title>
    <link rel="stylesheet" href="/resource/css/jquery/jquery-ui.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
    <script src="/resource/js/jquery/jquery-2.1.1.js"> </script>
    <script src="/resource/js/jquery/jquery-ui.js"> </script>
    <script src="/resource/js/chineseDatepicker.js"></script>
</head>
<style>
.main{
background: #eee;
padding: 10px 10px 30px 30px;
border-radius: 10px;
}
.warnMsg{
background-color:#f2dede;
color:#b94a48;
padding:10px;
margin:10px;
}
.page-header{
border-bottom: 1px solid;
}
td{
padding:10px;
}
</style>
<script>
var path = ''
	$(function(){
		$(".spinner").spinner({
			min : 1,
			step : 1,
			numberFormat : "n"
		});

		
		//10 will change dynamically given value by ${limitNumber}
		var left = parseInt("${leftSpace}")+1;
		for(var i=0; i<left;i++){
			$("#numOfAdult").append(
					$("<option></option>").attr("value", i).text(i));
			$("#numOfChild").append(
					$("<option></option>").attr("value", i).text(i));
		}
		var names = [];
		 $(".names").each(function(){
			 names.push($(this).val());	
			});
		 var prices = [];
			 $(".prices").each(function(){
				 prices.push($(this).val());		
				});
			 var numbers = [];
		 $(".numbers").each(function(){
			 numbers.push($(this).val());		
			});
		$("#numOfAdult").change(function(){
			var adultN = $("#numOfAdult").val();
			$("#numOfChild").empty();
			var leftN = parseInt("${leftSpace}");
	 		for(var j=0;j<leftN-adultN+1;j++)
				 $("#numOfChild").append($("<option></option>").attr("value", j).text(j));

			var sepPrice = parseInt("${SepPrice}");
			$("#price").val(adultN*sepPrice);  		 
			
		})
		$("#numOfChild").change(function(){
			var talNum = parseInt($("#numOfAdult").val())+parseInt($("#numOfChild").val());
			var sepPrice = parseInt("${SepPrice}");
			$("#price").val(talNum*sepPrice);  		 			
		})
	});
</script>
<body>
	
    <div class="row">  
    <c:forEach items="${route.details }" var="detail">
	    <input type="hidden" value="${detail.vehiclename}" class="names"/>
	    <input type="hidden" value="${detail.price}" class="prices"/>
	    <input type="hidden" value="${detail.number}" class="numbers"/>
    </c:forEach>
				<div class="col-lg-1"></div>
				<div class="col-lg-8">
				<div class="warnMsg">这趟旅行只会要求付完定金。当收到您的定金后，我们会在1-3内帮您确认订单。<br/>
我们建议您，在获得确认通知前，先不要购买机票或其他不能退订的旅游安排。</div>
<div class="warnMsg"><strong>${vo.travelDate }</strong>当天的拼团即将售完，只剩下<strong>${leftSpace}</strong>个空余。</div>
	<h1 class="page-header">订单信息</h1>
	
	<div class="main">

	<form:form action="/order/createOrder" method="post" commandName="vo">
	<table>
		<tr>
			<td>出发日期:</td>
			<td><form:input type="text" path="travelDate" value="${vo.travelDate }"
					readonly="true" class="form-control"/></td>
		</tr>
		<tr>
			<td>预定人数:</td>
			<td><label><form:select type="text" path="numOfAdult" value="" required="required"  class="form-control"/></label>成人<label> 
			<form:select type="text" path="numOfChild" value="" required="required"  class="form-control"/></label>儿童(12岁以下)(先选成人数量)</td>
		</tr>
		<tr>
			<td>总金额:</td>
			<td><form:input type="text" path="price" value=""
					readonly="true" required="required"  class="form-control"/></td>
		</tr>
		
		<tr>
			<td>联系人姓名:</td>
			<td><form:input type="text" path="contactName" required="required"  class="form-control"/> 
			<form:radiobutton
					path="contactGender" value="1" />男 <form:radiobutton
					path="contactGender" value="2" />女 <form:radiobutton
					path="contactGender" value="3" checked="checked" />未知</td>
		</tr>
		<tr>
			<td>联系电话:</td>
			<td><form:input type="text" path="contactNumber" required="required"  class="form-control"/></td>
		</tr>
		<tr>
			<td>邮箱:</td>
			<td><form:input type="text" path="contactEmail"  class="form-control"/></td>
		</tr>
		<tr>
			<td>特殊要求:</td>
			<td><form:input type="text" path="remarks"  class="form-control"/></td>
		</tr>
	</table>
	<form:hidden path="routeid" value="${vo.routeid }" />
	<form:hidden path="userId" value="${vo.userId}" />
	<form:hidden path="vehicleName" value="${vo.vehicleName}" />
	<form:hidden path="tourNumber" value="${vo.tourNumber}" />
	<form:hidden path="type" value="2" />
	<div class="text-left"><button type="submit" id="sub" class="btn btn-primary ">Submit</button></div>
</form:form>
</div>
</div>
<div class="col-lg-3"></div>
    </div>
	
   
</body>
</html>