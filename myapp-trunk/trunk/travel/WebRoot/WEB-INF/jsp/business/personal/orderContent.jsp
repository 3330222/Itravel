<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/jsp/share/tagLibs.jsp" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base target="mainframe">
    <link rel="stylesheet" href="/resource/css/jquery/jquery-ui.css">
    <script src="/resource/js/chineseDatepicker.js"> </script>
    <script src="/resource/js/jquery/jquery-2.1.1.js"> </script>
    <script src="/resource/js/jquery/jquery-ui.js"> </script>
    <script src="/resource/js/chineseDatepicker.js"></script>
<!--  	<script src="/resource/js/core/syscore-1.0.js"> </script> -->
<style>
.main{
position:absolute;
width: 100%;
}
.left{
float:left;
margin-left:10%;
width:60%;
font-size:2.5em;
}
.right{
float:left;
width: 30%;
}
.right div{
margin-bottom:10px;
}
span{
padding-left:20px;
}
.menu{
position:relative;
left: 10%;
padding-top:70px;
padding-bottom: 20px;
}
.rowList>div{
padding:5px;
}

#dateList{padding-top:10px}

#photoTabs { width:80%;}
.warnMsg{
background-color:#f2dede;
color:#b94a48;
padding:10px;
margin:10px;
}
td{
padding:10px;
}
</style>
<script>
var path = ''
$(function(){
	$("body").css('cursor', 'pointer'); 
	$( "#dateList" ).accordion({
		collapsible : true,
		active : false,
		heightStyle: 'content'
		});	
	 
	 var list = [];
	 var leftCars = {};
	 $(".days").each(function(){
			list.push($(this).val());			
		});
/* 		$.datepicker.regional["zh-CN"] = { 
				closeText: "关闭", prevText: "&#x3c;上月", nextText: "下月&#x3e;", currentText: "今天", 
				monthNames: ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"],
				monthNamesShort: ["一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"],
				dayNames: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"], 
				dayNamesShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六"], 
				dayNamesMin: ["日", "一", "二", "三", "四", "五", "六"], weekHeader: "周", 
				dateFormat: "yy-MM-dd", 
				firstDay: 1, 
				isRTL: !1, showMonthAfterYear: !0,
				yearSuffix: "年",
				changeMonth: true,  //可以选择月份
				changeYear: true,   //可以选择年份 
				}	

		$.datepicker.setDefaults($.datepicker.regional["zh-CN"]); */
		$("#travelDate").datepicker({
		  beforeShowDay: function(date){ 
			  var day = date.getDay();  
	 	      return [day ==list[0]||day==list[1]||day==list[2]||day==list[3]||day==list[4]||day==list[5]||day==list[6],""];
			},
			 minDate: 0,
			 maxDate: "${route.eTime}",
			 onSelect: function(dateStr) {				 
				 var date = $('#travelDate').datepicker("getDate");
			      $.getJSON(path+"/order/checkAvali",{date:$.datepicker.formatDate("yy-MM-dd", date),routeid:"${route.routeid}"}) 
			      .done(function(data){			    	
			    	  for(var i in data){
			    	  	 leftCars[i] = data[i];
			    	  	 if(data[i] == 0){			    	  		
			    	  		var $radios = $('input:radio[name=vehicleName]');
				    	  	$radios.filter('[value='+i+']').prop('disabled', true);
				    	  	$radios.filter('[value='+i+']').prop('checked', false);
				    	  	$("#price").val("");
				    	  	$("#"+i).text(" 满团 ").css("color","red");
			    	  	 }
			    	  	 else{
			    	  		$("#"+i).text("")
			    	  		var $radios = $('input:radio[name=vehicleName]');
			    	  		$radios.filter('[value='+i+']').prop('disabled', false);
			    	  		$radios.filter('[value='+i+']').prop('checked', false);
			    	  	 }
			    	  }
			    	  
			      })
			 } 
		 });
	var selectedTabId = sessionStorage.getItem("selectedTab");
    selectedTabId = selectedTabId === null ? 0 : selectedTabId; //your default being 0
    $("#photoTabs").tabs({
        active: selectedTabId,
        activate : function( event, ui ) {
            selectedTabId = $(this).tabs("option", "active");
            sessionStorage.setItem("selectedTab", selectedTabId);
        }
    });
	
	var end = "${route.eTime}";
	$.getJSON(path+"/order/getMonth",{endD:end})
		.done(function(data){
			for(var i in data){
				var dates = data[i].split("-");
				$("#selectPeriod").append($("<option></option>").attr("value",data[i]).text(dates[0]+"年"+dates[1]+"月")); 
				var period = $("#selectPeriod").val();
				getTuan(period);
			}
		})
	
		var names = [];
		 $(".names").each(function(){
			 names.push($(this).val());	
			});
		 var prices = [];
			 $(".prices").each(function(){
				 prices.push($(this).val());		
				});
		 var limits = [];
		 $(".limits").each(function(){
			 limits.push($(this).val());		
			});
		 var numbers = [];
		 $(".numbers").each(function(){
			 numbers.push($(this).val());		
			});
		 $( "input[type=radio][name=vehicleName]" ).change(function() {
			 var vehicleName = $(this).val();
			 	for(var i in names){
			 		if(names[i] == vehicleName){
			 			$("#price").val(prices[i]);
			 			$("#"+vehicleName).text("建议"+numbers[i]+"人").css("color","red");
			 			$.each(leftCars, function (k, v) {
				 			if(k == vehicleName){
				 				var num = parseInt(limits[i])-parseInt(v)+1;
				 				$("#tourNumber").val(vehicleName+"-"+num);
				 			}
					 	})
					 	$("#numOfAdult").empty();
			 			$("#numOfChild").empty();
					 	var places = parseInt(numbers[i])+1;
						for(var i=0; i<places;i++){
							$("#numOfAdult").append(
									$("<option></option>").attr("value", i).text(i));
							$("#numOfChild").append(
									$("<option></option>").attr("value", i).text(i));
						}
			 		}else{
			 			$("#"+names[i]).text("");
			 		}
			 	}
		 	
			}); 
		 
		 $("#numOfAdult").change(function(){
			 var adultN = $("#numOfAdult").val();
			 var type = $("input:radio[name=vehicleName]:checked").val();
			 $("#numOfChild").empty();
			 for(var i in names){
				 if(names[i] == type){
					 for(var j=0;j<numbers[i]-adultN+1;j++)
						 $("#numOfChild").append(
									$("<option></option>").attr("value", j).text(j));
					 var talNum = parseInt($("#numOfAdult").val())+parseInt($("#numOfChild").val());
				 }
			 }
		 })
		 
		 $("#selectPeriod").change(function(){
			 var period = $("#selectPeriod").val();
			 getTuan(period);
			 
		 });
		 
		 function getTuan(period){
			 $.getJSON(path+"/order/getAvalibleRoute",{period:period, routeid:"${route.routeid}"})
			 	.done(function(data){
			 		$("#dateList").empty();
			 		$.each(data, function (k, value) {
						var row = $("<div>").addClass("rowList");
						var emp = 0;
						$.each(value, function (innerKey, innerValue) {
							var l = $("<div>").addClass("row col-lg-12");
							var l1 = $("<div>").addClass("col-lg-4");
							$("<label>").text(innerKey).appendTo(l1);
							if(innerValue[0] != 0)
								$("<label>").text("剩余"+innerValue[0]+"个座位").appendTo(l1).addClass("control-label");
							else{
								$("<label>").text("已订完").appendTo(l1).addClass("control-label");
							}
							$("<label>").text(innerValue[1]+"元/人").appendTo(l1).addClass("control-label");
							
							var l2 = $("<div>").addClass("col-lg-8");
							var btn = $("<button>").text("预定").attr("value",innerKey).attr("id",innerKey).addClass("btn btn-default");
							btn.click(function(){
								document.location.href=path+'/order/orderDetail?tourNumber='+btn.val()+'&routeid='+"${route.routeid}"+'&date='+k+'&leftSpace='+innerValue[0]+'&price='+innerValue[1];
							})
							if(innerValue[0] == 0){
								emp++;
								btn.attr("disabled",true);
							}
							btn.appendTo(l2);
							l.append(l1).append(l2)
							l.appendTo(row);
						});
						var title = $("<h3>").html(k);
						if(emp != 3){
							$("#dateList").append(title).append(row);
						}else{
							var emptyRow = $("<div>").addClass("row");
							var msg = $("<label>").addClass("control-label").text("当日所有的团已经订完，我们可以为您安排私人定制业务");
							var d1 = $("<div>").addClass("col-lg-12").append(msg);
							var btn = $("<button>").text("私人定制").addClass("btn btn-default");
							btn.click(function(){
								document.location.href=path+'/dingzhi';
							})
							var d2 = $("<div>").addClass("col-lg-12").append(btn);
							emptyRow.append(d1).append(d2); 
							$("#dateList").append(title).append(emptyRow);
						}
						
						$("#dateList").accordion("refresh");
					}); 	
		 	});
		 }
		 
		 
		 
    });
</script>
</head>
<body >
	<div class="main">
		<div class="left">${route.name }</div>
	    <div class="right">
	    	<div><span>旅行长度</span><span>${route.nodes.size()}天</span></div>
	    	<div><span>路线价格</span><span>${leastPrice}元起</span></div>
	    </div>
	</div>
	
	<div class="ui-widget menu" >
		<div id="photoTabs">
			<ul>
			<li><a href="#fullTab">开启整团出游</a></li>
			<li><a href="#seperateTab">自由参与拼团</a></li>
			</ul>
			<div id="fullTab">
			<form:form action="/order/createOrder" method="post"  commandName="vo">
			<c:forEach items="${route.dayofweek }" var="aday"><input type="hidden" value="${aday}" class="days"/></c:forEach>
			<c:forEach items="${route.details }" var="detail"><input type="hidden" value="${detail.vehiclename}" class="names"/>
			
			<input type="hidden" value="${detail.price}" class="prices"/><input type="hidden" value="${detail.limit}" class="limits"/>
			<input type="hidden" value="${detail.number}" class="numbers"/></c:forEach>
				<table>
					<tr><td>出发日期:</td><td><form:input type="text" path="travelDate" readonly="true" required="required" class="form-control"/></td></tr>
					<tr><td>选定车型:</td><td>
					<c:forEach begin="0" var="detail" items="${route.details}" varStatus="ctr">
					<form:radiobutton path="vehicleName" value="${detail.vehiclename}" required="required"/>${detail.vehiclename}<span id="${detail.vehiclename}"></span></c:forEach></td></tr>					
					<tr><td>总金额: </td><td> <form:input type="text" path="price" value="" readonly="true" required="required" class="form-control"/>(此金额为整团价格)</td></tr>

					<tr><td>预定人数:</td><td><label><form:select type="text" path="numOfAdult" value="" required="required" class="form-control"/></label>成人
							<label><form:select type="text" path="numOfChild" value="" required="required" class="form-control"/></label>儿童(12岁以下)(先选成人数量)</td></tr>
					<tr>
						<td>联系人姓名:</td>
						<td><form:input type="text" path="contactName"  class="form-control"/>
						<form:radiobutton path="contactGender" value="1" />男
   						<form:radiobutton path="contactGender" value="2" />女 
   						<form:radiobutton path="contactGender" value="3" checked="checked"/>未知 </td>
					</tr>
					<tr>
						<td>联系电话:</td>
						<td><form:input type="text" path="contactNumber" required="required" class="form-control"/></td>
					</tr>
					<tr>
						<td>邮箱:</td>
						<td><form:input type="text" path="contactEmail" class="form-control"/></td>
					</tr>
					<tr>
						<td>特殊要求: </td>
						<td><form:input type="text" path="remarks" class="form-control"/></td>
					</tr>
				</table>
				<form:hidden path="routeid" value="${vo.routeid }" />
				<form:hidden path="userId" value="${vo.userId}" />
				<form:hidden path="tourNumber" value="" />
				<form:hidden path="type" value="1" />
				<button type="submit" id="sub" class="btn btn-primary">Submit</button>
    		</form:form>
			</div>
			<div id="seperateTab">
				<div class="warnMsg">这趟旅行只会要求付完定金。当收到您的定金后，我们会在1-3内帮您确认订单。<br/>
				我们建议您，在获得确认通知前，先不要购买机票或其他不能退订的旅游安排。</div>
		    	<label><select id="selectPeriod" width="150px" class="form-control"></select></label>
		    	<div id="dateList">

				</div>
			</div>
		</div>
	</div>


</body>
</html>
