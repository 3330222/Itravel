<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/share/tagLibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<link href="/resource/css/bootstrap.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="/resource/css/button.css" rel="stylesheet" type="text/css"
	media="all" />
<script src="/resource/js/jquery/jquery-2.1.1.js"></script>
<script src="/resource/js/jquery/jquery.validate.min.js"></script>
<script src="/resource/js/bootstrap.min.js"></script>
<link href="/resource/css/frank.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="/resource/css/hostel/circle.css" rel="stylesheet"
	type="text/css" media="all" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body style="background-color: white;">
	<div class="row title">
		<div class=" col-md-1"></div>
		<div class="col-md-10 col-sm-12 col-xs-12">




			<nav class="navbar navbar-default">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a href="/"><img class="nav_icon"
							src="/resource/image/qimaero_logo.png" alt="" /></a>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav navbar-left">

							<li><a href="/">主页</a></li>
							<li><a href="/route_list">畅游天下</a></li>
							<li><a href="/dingzhi">私人定制</a></li>
							<li><a href="/contact_us">关于我们</a></li>

						</ul>
						<ul class="nav navbar-nav navbar-right">
							<li class="log"><c:if test="${empty CurrentUserAccount}">
									<button type="button"
										class="button button-primary button-pill button-small"
										data-toggle="modal" data-target="#myModal">登陆</button>
								</c:if> <c:if test="${not empty CurrentUserAccount}">
									<%-- 	${CurrentUserAccount} --%>
									<script>
										loadUserInfo();
									</script>
									<form method="POST" action="/j_spring_security_logout"
										id="mylogout">
										<%-- 	${CurrentUserAccount}	 --%>
										<!-- <input type="submit" value="退出登录"
											class="button button-primary button-pill button-small"> -->
										<div class="btn-group">
											<img class="icon-circle dropdown-toggle headimage"
												data-toggle="dropdown" src="" alt="No image">
											<!-- 	</button> -->
											<div class="dropdown-menu menu_btns">
												用户:${CurrentUserAccount} 
												<%--  <input type="hidden"
													value="${CurrentUserId}" id="uid" /> --%>
												<br> <br> <a href="#"><img
													class="Bigicon-circle headimage" src="" alt="No image"></a>
												<c:choose>
													<c:when test="${CurrentUserTypeCd=='2'}">
														<div class="row">
															<br>
															<li class="col-md-4"><a href="/backend/route/homepage">客栈主页</a></li>
															<li class="col-md-4"><a href="/personal/personSetting">个人设置</a></li>
															<li class="col-md-4"><a href="/backend/hostel/applyverify">实名认证</a></li>
														</div>
														<div class="row postlogin">
															<li class="col-md-4"><a href="/order/viewOrders">查看订单</a></li>
															<li class="col-md-4"><a
																href="/backend/route/newroute">发布路线</a></li>
															<li class="col-md-4"><a
																href="/backend/route/displaylist">路线管理</a></li>
														</div>
													</c:when>
													<c:otherwise>
														<div class="row">
															<br>
															<li class="col-md-6"><a href="/personal/info">个人主页</a></li>
															<li class="col-md-6"><a href="/personal/order">我的订单</a></li>
															<li class="col-md-6"><a href="/personal/myPartner">我的约伴</a></li>
															<li class="col-md-6"><a href="/personal/findPartner">发起约伴</a></li>

														</div>
													</c:otherwise>
												</c:choose>
												<li role="separator" class="divider"></li>
												<li role="separator" class="divider"></li> <a href="#"
													onclick="userlogout()"
													class="button button-primary button-pill button-small">退出登录</a>
											</div>
										</div>
									</form>
								</c:if></li>
						</ul>
					</div>
					<!-- /.navbar-collapse -->
				</div>
				<!-- /.container-fluid -->
			</nav>

			<div class="col-md-2">
				<div style="">

					<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title" id="myModalLabel"
										style="text-align: center;">登陆</h4>
								</div>
								<div class="modal-body">
									<form method="POST" action="/j_spring_security_check">
										<div class="row container">
											<div class="row commen_line">
												<div class="col-md-1"></div>
												<div class="col-md-1">帐号:</div>
												<div class="col-md-2">
													<input type="text" class="form-control"
														id="exampleInputEmail1" name="j_username" />
												</div>
												<div class="col-md-2"></div>
											</div>
											<div class="row commen_line">
												<div class="col-md-1"></div>
												<div class="col-md-1">密码:</div>
												<div class="col-md-2">
													<input type="password" class="form-control"
														id="exampleInputPassword1" name="j_password" />
												</div>
												<div class="col-md-2"></div>
											</div>
											<div class="row commen_line">
												<div class="col-md-1"></div>
												<div class="col-md-1"></div>
												<div class="col-md-2">
													<input type="checkbox" name="_spring_security_remember_me"
														value="1" />记住我
												</div>
												<div class="col-md-2"></div>
											</div>
											<div class="row commen_line">
												<div class="col-md-1"></div>
												<div class="col-md-8">
													没有帐号?注册: <a href="/user/toregister/traveller"
														style="color: blue;">旅客</a>| <a
														href="/user/toregister/hostel" style="color: orange;">客栈</a>
												</div>
												<div class="col-md-2"></div>
											</div>
											<div class="row commen_line">
												<div class="col-md-2"></div>

												<div class="col-md-2">
													<input type="submit" class="btn btn-default" value="登录" />
													<input type="reset" class="btn btn-default" value="重置" />
												</div>
												<div class="col-md-2"></div>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>

				</div>

			</div>

		</div>
	</div>
	</div>
	</div>
	<script>
		$(function() {
			console.log("xxxxxxx");
			$(".postlogin").hide();
			$.ajax({
				method : "POST",
				url : "/personal/userinfo",
				dataType : "json",
			}).done(function(data) {
				var img = data.headPhoto;
				$(".headimage").prop("src", img);
				var code = data.hosteluserStatus;
				if (code == 3) {
					$(".postlogin").show();
				}
			});
		});
		function userlogout() {
			$("#mylogout").submit();
		}
	</script>
	<script>
		window._bd_share_config = {
			"common" : {
				"bdSnsKey" : {},
				"bdText" : "",
				"bdMini" : "2",
				"bdMiniList" : false,
				"bdPic" : "",
				"bdStyle" : "1",
				"bdSize" : "16"
			},
			"share" : {},
			"image" : {
				"tag" : "share",
				"viewList" : [ "qzone", "tsina", "tqq", "renren", "weixin" ],
				viewColor : 'black',
				"viewText" : "分享到：",
				"viewSize" : "16"
			},
			"selectShare" : {
				"bdContainerClass" : null,
				"bdSelectMiniList" : [ "qzone", "tsina", "tqq", "renren",
						"weixin" ]
			}
		};
		with (document)
			0[(getElementsByTagName('head')[0] || body)
					.appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='
					+ ~(-new Date() / 36e5)];
	</script>

</body>
</html>
