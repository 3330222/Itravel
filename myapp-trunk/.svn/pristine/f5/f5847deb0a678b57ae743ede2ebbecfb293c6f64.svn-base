<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/share/tagLibs.jsp"%>

<html>
<head>
<title>个人订单浏览</title>

<script src="/resource/js/jquery/jquery-2.1.1.js"></script>
<script src="/resource/js/jquery/jquery-ui.js"></script>
<link rel="stylesheet" href="/resource/css/CssForLena.css">
<link rel="stylesheet" href="/resource/css/bootstrap.css">
<link rel="stylesheet" href="/resource/css/hostel/tabs.css">
<link rel="stylesheet" href="/resource/css/hostel/tabstyles.css">
<link rel="stylesheet" href="/resource/css/jquery-ui.css">
</head>
<script>
var path = ''
	$(function(){
		
		var selectedTabId = sessionStorage.getItem("selectedTab");
	    selectedTabId = selectedTabId === null ? 0 : selectedTabId; //your default being 0
	    $("#tabs").tabs({
	        active: selectedTabId,
	        activate : function( event, ui ) {
	            selectedTabId = $(this).tabs("option", "active");
	            sessionStorage.setItem("selectedTab", selectedTabId);
	        }
	    });
	    
		$("#dialog,#dialog1,#dialog2").dialog({
			autoOpen : false,
			width : 700,
			height : 500,
			draggable : false,
			resizable : false,
			modal : true,
		})
		
	});
	function pay(x) {
		var orderid = $("#ordId"+x).val();
		document.location.href=path+'/personal/pay?orderid='+orderid;
	};
	function refundApply(x) {
		$("#dialog1").dialog("open");
		$("#ordId").val($("#ordId2"+x).val());
		$("#Price").val($("#price2"+x).val());
	};
	function choose(x) {
		$("#dialog").dialog("open");
		$("#date").text($("#date"+x).val());
		$("#car").text($("#car"+x).val());
		$("#person").text($("#person"+x).val());
		$("#adult").text($("#adult"+x).val());
		$("#child").text($("#child"+x).val());
		$("#phone").text($("#phone"+x).val());
		$("#email").text($("#email"+x).val());
	};
	
	function choose2(x) {
		$("#dialog").dialog("open");
		$("#date").text($("#date2"+x).val());
		$("#car").text($("#car2"+x).val());
		$("#person").text($("#person2"+x).val());
		$("#adult").text($("#adult2"+x).val());
		$("#child").text($("#child2"+x).val());
		$("#phone").text($("#phone2"+x).val());
		$("#email").text($("#email2"+x).val());
	};
	
	function choose3(x) {
		$("#dialog").dialog("open");
		$("#date").text($("#date3"+x).val());
		$("#car").text($("#car3"+x).val());
		$("#person").text($("#person3"+x).val());
		$("#adult").text($("#adult3"+x).val());
		$("#child").text($("#child3"+x).val());
		$("#phone").text($("#phone3"+x).val());
		$("#email").text($("#email3"+x).val());
	};
	
	function initStopwatch(){
		var myTime=new Date();
		var timeNow=myTime.getTime();
		var timeDiff=clockStart-timeNow;//获取间隔时间
		this.diffSecs=timeDiff/1000; //时间以毫秒为单位
		return(this.diffSecs);
	}
	function getSecs(){
		var mySecs=initStopwatch();
		var mySecs1=""+mySecs;
		var time = parseInt(mySecs1);

		var d = time/(3600*24);
		var d2 = parseInt(d+"");
		
		var h = ((time-d2*3600*24)/3600); 
		var h2 = parseInt(""+h);

		var m = ((time-d2*3600*24-3600*h2)/60);
		var m2 = parseInt(""+m);

		var s = (time-d2*3600*24-3600*h2-60*m2);
		var s2 = parseInt(""+s);

		var t = d2+"天"+h2+"时"+m2+"分"+s2+"秒";
		$("#RemainTime").text(t);
		window.setTimeout('getSecs()',1000);
	}
	function check(x){
		$("#dialog2").dialog("open");
		$("#ordID").text($("#ordIdre"+x).val());
		$.getJSON("/personal/getRefundCT",{orderid:$("#ordIdre"+x).val()})
		.done(function(data){
			console.info(data)
			clockStart=data;
			window.setTimeout('getSecs()',1);
		})
		
	};
</script>
<body>
	<div class="row" style="padding-top: 30px;">
		<div class="col-lg-11 col-lg-offset-1">
			<div id="tabs" class="tabs tabs-style-linetriangle">
			<nav>
				<ul>
					<li><a href="#unpaid">待付款订单</a></li>
					<li><a href="#paid">已付款订单</a></li>
					<li><a href="#refund">退款中订单</a></li>
					<li><a href="#closed">已关闭订单</a></li>
					<li><a href="#success">已成功订单</a></li>
				</ul>
				</nav>
				<div id="unpaid">
					<table class="table table-striped table-hover">
						<thead>
							<tr class="info">
								<th></th>
								<th>待付款订单名</th>
								<th>启程时间</th>
								<th>总价</th>
								<th>车型</th>
								<th>订单生成时间</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<c:forEach items="${unpaid}" var="vo" varStatus="status">
							<tr class="info">

								<td>${status.index+1}</td>
								<td>${vo.detail.info.name }</td>
								<fmt:parseDate value="${vo.travelDate}" var="theDate"
									pattern="yyyy-MM-dd HH:mm:ss.S" />
								<td><fmt:formatDate value="${theDate}" pattern="yyyy-MM-dd"
										var="str" />${str}</td>
								<td>${vo.price }</td>
								<td>${vo.detail.vehiclename }</td>
								<td>${vo.cTime }</td>
								<td><input type="button" value="查看"
									onclick="choose(${status.index})"></td>
								<td><input type="button" value="付款"
									onclick="pay(${status.index})"></td>
							</tr>
							<input type="hidden" value="${vo.orderid }"
								id="ordId${status.index}">
							<input type="hidden" value="${vo.travelDate }"
								id="date${status.index}">
							<input type="hidden" value="${vo.detail.vehiclename}"
								id="car${status.index}">
							<input type="hidden" value="${vo.contactName }"
								id="person${status.index}">
							<input type="hidden" value="${vo.numOfAdult }"
								id="adult${status.index}">
							<input type="hidden" value="${vo.numOfChild }"
								id="child${status.index}">
							<input type="hidden" value="${vo.contactNumber}"
								id="phone${status.index}">
							<input type="hidden" value="${vo.contactEmail}"
								id="email${status.index}">
						</c:forEach>
					</table>
				</div>
				<div id="paid">
					<table class="table table-striped table-hover">
						<thead>
							<tr class="info">
								<th></th>
								<th>已付款订单名</th>
								<th>启程时间</th>
								<th>总价</th>
								<th>车型</th>
								<th>订单生成时间</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<c:forEach items="${paid}" var="vo" varStatus="status">
							<tr class="info">
								<td>${status.index+1}</td>
								<td>${vo.detail.info.name }</td>
								<fmt:parseDate value="${vo.travelDate}" var="theDate"
									pattern="yyyy-MM-dd HH:mm:ss.S" />
								<td><fmt:formatDate value="${theDate}" pattern="yyyy-MM-dd"
										var="str" />${str}</td>
								<td>${vo.price }</td>
								<td>${vo.detail.vehiclename }</td>
								<td>${vo.cTime }</td>
								<td><input type="button" value="申请退款"
									onclick="refundApply(${status.index})"></td>
								<td><input type="button" value="查看"
									onclick="choose2(${status.index})"></td>
							</tr>
							<input type="hidden" value="${vo.orderid }"
								id="ordId2${status.index}">
							<input type="hidden" value="${vo.price }"
								id="price2${status.index}">
							<input type="hidden" value="${vo.travelDate }"
								id="date2${status.index}">
							<input type="hidden" value="${vo.detail.vehiclename}"
								id="car2${status.index}">
							<input type="hidden" value="${vo.contactName }"
								id="person2${status.index}">
							<input type="hidden" value="${vo.numOfAdult }"
								id="adult2${status.index}">
							<input type="hidden" value="${vo.numOfChild }"
								id="child2${status.index}">
							<input type="hidden" value="${vo.contactNumber}"
								id="phone2${status.index}">
							<input type="hidden" value="${vo.contactEmail}"
								id="email2${status.index}">
						</c:forEach>
					</table>
				</div>
				<div id="refund">
					<table class="table table-striped table-hover">
						<thead>
							<tr class="info">
								<th></th>
								<th>退款中订单名</th>
								<th>启程时间</th>
								<th>总价</th>
								<th>车型</th>
								<th>订单生成时间</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<c:forEach items="${refund}" var="vo" varStatus="status">
							<tr class="info">
								<td>${status.index+1}</td>
								<td>${vo.detail.info.name }</td>
								<fmt:parseDate value="${vo.travelDate}" var="theDate"
									pattern="yyyy-MM-dd HH:mm:ss.S" />
								<td><fmt:formatDate value="${theDate}" pattern="yyyy-MM-dd"
										var="str" />${str}</td>
								<td>${vo.price }</td>
								<td>${vo.detail.vehiclename }</td>
								<td>${vo.cTime }</td>
								<td></td>
								<td><input type="button" value="查看退款进程"
									onclick="check(${status.index})"></td>

							</tr>
							<input type="hidden" value="${vo.orderid }"
								id="ordIdre${status.index}">
						</c:forEach>
					</table>
				</div>
				<div id="closed">
					<table class="table table-striped table-hover">
						<thead>
							<tr class="info">
								<th></th>
								<th>已关闭订单名</th>
								<th>启程时间</th>
								<th>总价</th>
								<th>车型</th>
								<th>订单生成时间</th>
								<th>关闭原因</th>
							</tr>
						</thead>
						<c:forEach items="${closed}" var="vo" varStatus="status">
							<tr class="info">
								<td>${status.index+1}</td>
								<td>${vo.detail.info.name }</td>
								<fmt:parseDate value="${vo.travelDate}" var="theDate"
									pattern="yyyy-MM-dd HH:mm:ss.S" />
								<td><fmt:formatDate value="${theDate}" pattern="yyyy-MM-dd"
										var="str" />${str}</td>
								<td>${vo.price }</td>
								<td>${vo.detail.vehiclename }</td>
								<td>${vo.cTime }</td>
								<td><c:choose><c:when test="${vo.paymentExist}">申请退款成功</c:when><c:otherwise>订单超时关闭</c:otherwise></c:choose></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div id="success">
					<table class="table table-striped table-hover">
						<thead>
							<tr class="info">
								<th></th>
								<th>已成功订单名</th>
								<th>启程时间</th>
								<th>总价</th>
								<th>车型</th>
								<th>订单生成时间</th>

								<th></th>
							</tr>
						</thead>
						<c:forEach items="${success}" var="vo" varStatus="status">
							<tr class="info">
								<td>${status.index+1}</td>
								<td>${vo.detail.info.name }</td>
								<fmt:parseDate value="${vo.travelDate}" var="theDate"
									pattern="yyyy-MM-dd HH:mm:ss.S" />
								<td><fmt:formatDate value="${theDate}" pattern="yyyy-MM-dd"
										var="str" />${str}</td>
								<td>${vo.price }</td>
								<td>${vo.detail.vehiclename }</td>
								<td>${vo.cTime }</td>

								<td><input type="button" value="查看"
									onclick="choose3(${status.index})"></td>
							</tr>
							<input type="hidden" value="${vo.travelDate }"
								id="date3${status.index}">
							<input type="hidden" value="${vo.detail.vehiclename}"
								id="car3${status.index}">
							<input type="hidden" value="${vo.contactName }"
								id="person3${status.index}">
							<input type="hidden" value="${vo.numOfAdult }"
								id="adult3${status.index}">
							<input type="hidden" value="${vo.numOfChild }"
								id="child3${status.index}">
							<input type="hidden" value="${vo.contactNumber}"
								id="phone3${status.index}">
							<input type="hidden" value="${vo.contactEmail}"
								id="email3${status.index}">
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
		<div class="col-lg-1"></div>
	</div>
	<div id="dialog" title="联系人" class="form-horizontal">
		出发时间：<label id="date"></label>
		<hr>
		车型： <label id="car"></label>
		<hr>
		联系人： <label id="person"></label>
		<hr>
		大人数：<label id="adult"></label>
		<hr>
		小孩数： <label id="child"></label>
		<hr>
		联系电话： <label id="phone"></label>
		<hr>
		联系邮箱：<label id="email"></label>
		<hr>
		<input type="button" class="btn btn-default text-center" value="打印" />
	</div>

	<div id="dialog1" title="申请退款" class="form-horizontal">
		<form:form action="/personal/refundApply" method="post"
			commandName="refundVO">
				退款订单号：<form:input path="orderId" id="ordId" readOnly="true"
				class="form-control" />
			<hr>
				退款金额：<form:input path="refundAmount" id="Price" readOnly="true"
				class="form-control" />
			<hr>
				退款理由：<form:input type="text" path="refundReason"
				placeholder="请填写退款理由" class="form-control" required="required" />
			<hr>
			<form:hidden path="cTime" value="<%=new java.util.Date()%>" />
			<form:hidden path="refundStatus" value="1" />
			<button type="submit" class="text-center">提交退款申请</button>
		</form:form>
	</div>

	<div id="dialog2" title="申请退款" class="form-horizontal">
		退款订单号：<label id="ordID" class="form-control"></label>
		<hr>
		退款要求：<label>客栈同意退款或在五天内未操作，系统通知支付宝退款给旅客</label>
		<hr>
		退款倒计时： <label id="RemainTime"></label>
		<hr>
	</div>
</body>
</html>