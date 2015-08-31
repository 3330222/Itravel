<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/share/tagLibs.jsp"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base target="mainframe">
<link rel="stylesheet" href="/resource/css/jquery/jquery-ui.css">
<script src="/resource/js/jquery/jquery-2.1.1.js">
	
</script>
<script src="/resource/js/jquery/jquery-ui.js">
	
</script>
<script src="/resource/js/jquery/jquery.bpopup.js">
	
</script>
<script src="/resource/js/core/syscore-1.0.js">
	
</script>
<style>
.tab:hover, .active {
	background-color: #ccc;
	color: #ffe100;
}

.main {
	position: absolute;
	width: 100%;
}

.left {
	float: left;
	margin-left: 10%;
	color: #ff0000;
	width: 60%;
	font-size: 2.5em;
}

.right {
	float: left;
	width: 30%;
}

.right div {
	margin-bottom: 10px;
}

span {
	padding-left: 20px;
}

.viewDate {
	padding-top: 20px;
	width: 80%;
	margin-left: 10%;
}

.rowList {
	position: relative;
	border: 1px solid #eee;
}

table {
	border-collapse: collapse;
}

tr {
	border-bottom: 1px solid #eee;
}

tr.routeTitle {
	border-bottom: 1px solid #333333;
}

.rowList>div {
	float: left;
	padding: 5px;
}

.col-1, .col-2, .col-3 {
	width: 28%;
	z-index: 10;
}

.col-4 {
	width: 16%;
	z-index: 10;
}

#dateList {
	padding-top: 100px;
	z-index: 8
}

.selector {
	padding: 5;
	width: 150px;
	border-radius: 5px;
	border: 2px solid orange;
	z-index: 1000
}

.ulTest ul {
	display: none;
	list-style-type: none;
	margin: 0;
	padding: 9px;
	border: 1px solid yellow;
	border-radius: 5px;
	position: absolute;
	top: 50px;
	left: 20%;
	background: white;
	z-index: 1000
}

.ulTest li {
	width: 125px;
	padding: 5px;
	z-index: 1000
}

.ulTest a {
	width: 125px;
	z-index: 1000
}

.ulTest:hover>ul>li:hover {
	background: #e9e9e9;
	z-index: 1000
}

.ulTest:hover>ul>li:hover>a {
	color: red;
	z-index: 1000
}
</style>

<script type="text/javascript">
	$(function() {
		$("td[colspan=5]").find("p").hide();
		$("button").click(function(event) {
			event.stopPropagation();
			var $target = $(event.target);
			if ($target.closest("td").attr("colspan") > 1) {
				$target.slideUp();
			} else {
				$target.closest("tr").next().find("p").slideToggle();
			}
		});
		/* var items = $("table tbody tr");
		var itemN = Object.keys("${map.value.size()}").length;
		console.info(itemN)
		var perPage = 3;
		items.slice(perPage).hide();
		$('.pagination-page').pagination({
	        items: itemN,
	        itemsOnPage: perPage,
	        cssStyle: 'light-theme',
	        onPageClick: function(pageNumber) { // this is where the magic happens
	            // someone changed page, lets hide/show trs appropriately
	            var showFrom = perPage * (pageNumber - 1);
	            var showTo = showFrom + perPage;

	            items.hide() // first hide everything, then show for the new page
	                 .slice(showFrom, showTo).show();
	        }
	    });
		
		var checkFragment = function() {
	        var hash = window.location.hash || "#page-1";
	        hash = hash.match(/^#page-(\d+)$/);

	        if(hash)
	            $("#pagination").pagination("selectPage", parseInt(hash[1]));
	    };
	    $(window).bind("popstate", checkFragment);
	    checkFragment(); */
	    
	    $('input:checkbox[name=indexs]').each(function(){
	    	if($(this).val().indexOf("1001") >= 0)
	    		$(this).prop("checked",true);
	    })
	});
</script>


</head>
<body>
	<div class="viewDate">
		<h1>主页精品路线管理</h1>
		<form:form action="/admin/updateRouteType" method="post">
		<div class="pagination-page">
		<table style="width: 100%;">
			<thead>
			<tr class="routeTitle">
				<td>路线名</td>
				<td>创建日期</td>
				<td>结束日期</td>
				<td>是否幻灯片路线</td>
				<td>是否主页精品</td>
			</tr>
			</thead>
			</tbody>
			<c:forEach items="${result1}" var="route" varStatus="Ind">
				
						<tr class="routeElement">
							<td>${route.name}</td>
							<td>${route.cTime.toString()}</td>
							<td>${route.eTime}</td>
							<c:choose>
								<c:when test="${route.routetype == '1003'}">
									<td>是</td>
								</c:when>
								<c:otherwise>
									<td>否</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${route.routetype == '1001'}">
									<td>是</td>
								</c:when>
								<c:otherwise>
									<td>否</td>
								</c:otherwise>
							</c:choose>
							<td><input type="checkbox" value="${route.routetype}-${route.routeid}" name="indexs"/></td>
							
							<td style="text-align: right;"><button type="button">detail</button></td>
						</tr>

						<tr>
							<c:forEach items="${route.details}" var="details">
								<td colspan="5">
									<p>
										<b>线路描述:</b>
									</p>

									<p>${route.des}</p>
									<p>
										<img src="${route.themeImageUrl}" alt="Smiley face"
											width="342" height="342">
									</p> <br>

									<p>
										<b>价格:</b>
									</p>

									<p>${details.getPrice()}</p> <br>

									<p>
										<b>路线周期:</b>
									</p>

									<p>
										<fmt:formatDate pattern="yyyy-MM-dd"
											value="${details.getsTimes()}" />
										---
										<fmt:formatDate pattern="yyyy-MM-dd"
											value="${details.geteTimes()}" />
									</p> <br>

									<p>
										<b>旅店信息:</b>
									</p>

									<p>旅店老板: ${route.hotel.managername}</p>
									<p>旅店联系方式: ${route.hotel.managerphone}</p>
								</td>
							</c:forEach>
						</tr>

			</c:forEach>
			</tbody>
		</table>
		</div>
		<div style="text-align:center;margin-top:20px;">
			<input type="submit" value="状态改为精品路线" id="submitBtn"/>
		</div>
		</form:form>



	</div>



</body>
</html>
