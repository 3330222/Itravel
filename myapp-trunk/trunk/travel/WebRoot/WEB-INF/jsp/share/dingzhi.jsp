<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/share/tagLibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/resource/css/select.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="/resource/js/hostel/datepicker-zh-CN.js"></script>
<link rel="stylesheet" href="/resource/css/jquery-ui.css">
</head>
<style>
textarea {
	resize: none;
}

select {
	width: 50px;
}
</style>
<script>
	$(function() {
		$("#datepicker").datepicker({
			minDate : 0,
			maxDate : "+9M +10D",
		});
	});
</script>
<body>
	<form:form id="myform" class="form-horizontal" action="/personplan"
		method="post" commandName="plan">
		<form:hidden path="destination" id="destination" />
		<div class="dingzhi_body">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<div class="sub_content">
						<div class="row">
							<div class="col-md-7">
								<div class="dingzhi-content" id="dingzhi_01">
									<div class="dingzhi_title">
										<p>1、您计划什么时候出行呢？想玩几天( 从国内出发至回到国内的总天数）</p>
									</div>
									<div class="row">
										<div class="tianshu">
											请选择出发时间：<input type="text" id="datepicker"
												readonly="readonly" name="travelDate">
												<!-- <label id="tyear">
												<select>
												<option>2015下半年</option>
												<option>2016上半年</option>
												<option>2016下半年</option>
												</select>
												</label> -->
										</div>
										
									</div>
									<p class="beizhu">
										<img src="/resource/image/dingzhi01.png"></img>注：若不确定出行日期，可选择月份/日期不确定。
									</p>
									旅行天数：
									<div class="btn-group">
										<label> <form:select id="days" path="traveldays">
												<option selected="selected">1</option>
												<c:forEach begin="2" end="30" var="number">
													<option>${number}</option>
												</c:forEach>
											</form:select>
										</label>
									</div>
									<div class="tianshu">
										<p class="beizhu">可根据行程安排增减1-2天</p>
										<p class="beizhu">天数确定，不能更改</p>
									</div>
									<p>
										<img src="/resource/image/dingzhi02.png"></img>补充说明我的需求
									</p>

									<form:textarea class="area" rows="3" path="daysupplement"></form:textarea>
									<a onclick="showtwo(1)"
										class="button button-glow button-rounded button-raised button-primary dingzhi_button">确定，进入下一题</a>
								</div>
								<div class="dingzhi-content dingzhi02" id="dingzhi_02">
									<div class="dingzhi_title">
										<p>2、您想去什么地方玩?</p>
									</div>
									<div class="dingzhi-layout">
										<div class="row">
											<div class="col-md-9 dingzhi001">
												<p class="dingzhi-p">四川、西藏、新疆</p>
											</div>
											<div class="col-md-3 dingzhi002">
												<p class="dingzhi-p">北京</p>
											</div>
										</div>
										<div class="row">
											<div class="col-md-4 dingzhi003">
												<p class="dingzhi-p">云南、湖南、重庆、贵州、广西</p>
											</div>
											<div class="col-md-4 dingzhi004">
												<p class="dingzhi-p">泰国、柬埔寨、马来西亚</p>
											</div>
											<div class="col-md-4 dingzhi005">
												<p class="dingzhi-p">韩国</p>
											</div>
										</div>
										<div class="row">
											<div class="col-md-12 dingzhi006">
												<p class="dingzhi-p">不确定，请骑马儿推荐</p>
											</div>

										</div>
										<a onclick="showone()">上一题</a> <a
											class="button button-glow button-rounded button-raised button-primary dingzhi_button"
											onclick="showthree()">确定，进入下一题</a>
									</div>
								</div>
								<div class="dingzhi-content dingzhi02" id="dingzhi_03">
									<div class="dingzhi_title">
										<p>3、有多少人一起出行？有没有老人和孩子？</p>
									</div>
									<br> 成人：<label><form:select path="adult">
											<option selected="selected">1</option>
											<c:forEach begin="2" end="10" var="number">
												<option>${number}</option>
											</c:forEach>
										</form:select> </label> <br> <br> 儿童：<label> <form:select
											path="child">
											<option selected="selected">0</option>
											<c:forEach begin="1" end="10" var="number">
												<option>${number}</option>
											</c:forEach>
										</form:select></label> <br> <br>
									<p>
										<img src="/resource/image/dingzhi02.png"></img>补充说明我的需求
									</p>
									<form:textarea class="area" path="personsupplement" rows="3"></form:textarea>
									<a onclick="showtwo(2)">上一题</a> <a
										class="button button-glow button-rounded button-raised button-primary dingzhi_button"
										onclick="subplan()">完成定制</a>
								</div>
							</div>
							<div class="col-md-5">
								<div class="dingzhi-img">
									<img src="/resource/image/dingzhi03.png"></img>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-2"></div>
			</div>
		</div>
		<script>
			$(function() {
				$(".dingzhi-layout").find(".row").find("div").each(function() {
					$(this).click(function(index) {
						vis();
						$(this).toggleClass("choose", 50, "easeOutSine");
						$(this).toggleClass("unchoose");
					});
					var des = $(this).find("p").text();
					$("#destination").val(des);
				});
			});
			function vis() {
				$(".dingzhi-layout").find(".row").find("div").each(function() {
					$(this).toggleClass("unchoose");
				});
			}
			function showone() {
				$("#dingzhi_01").fadeIn();
				$("#dingzhi_02").fadeOut();
			}
			function showtwo(x) {
				if (x == 1) {
					var date=$("#datepicker").val();
					if(date!=""){
					$("#dingzhi_01").fadeOut();
					$("#dingzhi_02").fadeIn();
					$("#datepicker").removeClass("error");
					}
					else{
					$("#datepicker").toggleClass("error");
					}
				} else {
					$("#dingzhi_03").fadeOut();
					$("#dingzhi_02").fadeIn();
				}
			}
			function showthree() {
				$("#dingzhi_02").fadeOut();
				$("#dingzhi_03").fadeIn();
			}
			function subplan() {
				$("#myform").submit();
			}
		</script>
	</form:form>

</body>
</html>