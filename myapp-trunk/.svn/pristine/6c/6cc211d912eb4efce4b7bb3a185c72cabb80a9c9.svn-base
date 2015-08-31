<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/share/tagLibs.jsp" %>
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
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
	<div class="row">
		<div class="title">		 		    
			<div class="row">
				<div class="col-md-2"></div>				
				<div class="col-md-8">				   
			<ul class="nav nav-pills">
			    <li>
			     <a href="/"><img class="nav_icon" src="" alt="" /></a>
			    </li>
				<li><a  href="/" >主页</a></li>
				<li><a  href="/route_list">畅游天下</a></li>
				<li><a  href="/dingzhi">私人定制</a></li>	
				<li><a  href="/contact_us">关于我们</a></li>							
				<li>
				  	   
				</li>	
														  				
			</ul>	
				</div>	
			<div class="col-md-2">	
			     <div style="">
				   	<c:if test="${empty CurrentUserAccount}">
					<button type="button" class="button button-primary button-pill button-small" data-toggle="modal" data-target="#myModal">登陆</button>
				</c:if>					
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                      <div class="modal-dialog" role="document">
                           <div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title" id="myModalLabel" style="text-align:center;">登陆</h4>
								</div>
								<div class="modal-body">
									<form method="POST" action="/j_spring_security_check">
									  <div class="row container">
									   
									    
									      <div class="row commen_line">
									      <div class="col-md-1"></div>
									      <div class="col-md-1">
									                                 帐号:
									      </div>
									      <div class="col-md-2">
									          <input type="text" class="form-control" id="exampleInputEmail1" name="j_username" />
									      </div>
									      <div class="col-md-2"></div>
									      </div>
									    <div class="row commen_line">
									        <div class="col-md-1"></div>
									        <div class="col-md-1">
									                                 密码:
									        </div>
									        <div class="col-md-2">
									          <input type="password" class="form-control" id="exampleInputPassword1" name="j_password"  />
									        </div>
									        <div class="col-md-2"></div>
									    </div>
									    <div class="row commen_line">
									        <div class="col-md-1"></div>
									        <div class="col-md-1">
									                                 
									        </div>
									        <div class="col-md-2">
									          <input type="checkbox" name="_spring_security_remember_me" value="1" />记住我
									           </div>
									        <div class="col-md-2"></div>
									    </div>
									    <div class="row commen_line">
									        <div class="col-md-1"></div>
									        <div class="col-md-8">
									                没有帐号?注册:
												    <a href="/user/toregister/traveller" style="color:blue;">旅客</a>|
												    <a href="/user/toregister/hostel" style="color:orange;">客栈</a>                    
									        </div>									        
									        <div class="col-md-2"></div>
									    </div>
									    <div class="row commen_line">
									        <div class="col-md-2"></div>
									       
									        <div class="col-md-2">
									                  <input type="submit" class="btn btn-default" value="登录" /> 
									                  <input type="reset"  class="btn btn-default" value="重置" />               
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
	
</body>
</html>
