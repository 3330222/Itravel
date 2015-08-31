<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/share/tagLibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!-- <script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script> -->
<script src="/resource/js/jquery/jquery-2.1.1.js"></script>
<script src="/resource/js/jquery/jquery-ui.js"></script>
<link rel="stylesheet" href="/resource/css/hostel/fileinput.css">
<link rel="stylesheet" href="/resource/css/bootstrap.css">
<link rel="stylesheet" href="/resource/css/button.css">
<script src="/resource/js/hostel/numeric.js"></script>
<script src="/resource/js/hostel/fileinput.js" type="text/javascript"></script>
<script src="/resource/js/hostel/fileinput_locale_zh.js"
	type="text/javascript"></script>
<script src="/resource/js/area.js" type="text/javascript"></script>
<link rel="stylesheet" href="/resource/css/select.css">
<link rel="stylesheet" href="/resource/css/jquery-ui.css">
 
<style>
textarea {
	resize: none;
}

.error {
	color: #ff0000;
	font-style: italic;
}
#myform{
   margin-left: 200px;
}
</style>
<script>
	$(function() {	
		checckStatus();
		$(".numeric").numeric();
		var dlg = $("#dialog").dialog({
			closeOnEscape : false,
			open : function(event, ui) {
				$(".ui-dialog-titlebar-close").hide();
			},
			autoOpen : false,
			width : 800,
			height : 600,
			model : true,
			draggable : false,
			resizable : false,
			dialogClass : 'no-close',
			buttons : {
				"确定文件" : function() {
					var flag = true
					$(".file-2").each(function() {
						if ($(this).val() == "") {
							flag = false;
						}
					});
					if (flag) {
						$(this).dialog('close');
					} else {
						$("#err").show();
					}
				}
			}
		});

		dlg.parent().appendTo($("#imagepanel"));

		$("#choose").click(function() {
			$("#dialog").dialog("open");
			$("#err").hide();
		});

		$(".file-2").fileinput({
			showUpload : false,
			showCaption : false,
			allowedFileExtensions : [ 'jpg', 'png', 'gif', 'jpeg' ],
			browseClass : "btn btn-primary",
		});

		$("#sub").click(function() {

			var s = $('#show').text() + $('#detailaddress').val()
			$('#address').val(s);
		})

		$("#s_county").attr('onchange', 'showArea()');

	});

	function showArea() {
		$('#show').text(
				$('#s_province').val() + " - " + $('#s_city').val() + " - "
						+ $('#s_county').val() + " - ")
	}
	function checckStatus() {
		$("#2").hide();
		$("#3").hide();
		if("${edit}"== 3 ){
			$('#myform').find("input").each(function(){
				$(this).attr('readonly', 'readonly');
				$("#sub").hide();
				$("#choose").hide();
				$(".info").hide();
				$("#3").show();
				
			})
		}else if("${edit}"== 2){
			$('#myform').find("input").each(function(){
				$(this).attr('readonly', 'readonly');
				$("#sub").hide();
				$("#choose").hide();
				$(".info").hide();
				$("#2").show();
			})
		}
	}
</script>
<body>

	<form:form id="myform" class="form-horizontal"
		action="/backend/hostel/applyverify" method="post"
		enctype="multipart/form-data" commandName="svo">
		<fieldset>
			<h2 id = "2"><span class="label label-warning">骑马儿团队正在审核中,请耐心等待</span></h2>
	<h2 id = "3"><span class="label label-success" >恭喜您，客栈认证通过,可以发布路线</span></h2>
			<div class="form-group">
				<div class="col-lg-6">
					<form:input path="hostelname" cssClass="form-control"
						placeholder="客栈名称" autocomplete="off" required="required"
						type="text" value="${svo.hostelname}"/>
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-6">
					<div class="info">
						<div>
							<label> <select id="s_province" name="s_province"
								required></select></label>&nbsp;&nbsp; <label><select
								id="s_city" name="s_city" required width="200"></select>&nbsp;&nbsp;
							</label> <label><select id="s_county" name="s_county" required
								width="200"></select></label>
							<script type="text/javascript">
								_init_area();
							</script>
						</div>
						<div id="show" style="display: none;"></div>
					</div>
					<br> <input placeholder="客栈具体地址" required type="text"
						id="detailaddress" value="${svo.address}" class="form-control"/>
					<form:input path="address" cssClass="form-control"
						placeholder="客栈总地址" autocomplete="off" type="hidden" id="address" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-6">
					<form:input path="hosteltelephonenum" placeholder="客栈电话"
						autocomplete="off" required="required" value="${svo.hosteltelephonenum}"
						cssClass="numeric form-control" />

				</div>
			</div>
			<div class="form-group">

				<div class="col-lg-6">
					<form:input path="wechataccount" cssClass="form-control"
						placeholder="客栈微信*(选填)" value="${svo.wechataccount}" autocomplete="off"  />

				</div>
			</div>
			<div class="form-group">

				<div class="col-lg-6">
					<form:input path="registernum" required="required"
						placeholder="组织结构代码" autocomplete="off" type="text" value="${svo.registernum}"
						cssClass="numeric form-control" />

				</div>
			</div>
			<div class="form-group">

				<div class="col-lg-6">
					<form:input path="licensenum" required="required"
						placeholder="工商注册号" autocomplete="off" type="text" value="${svo.licensenum}"
						cssClass="numeric form-control" />

				</div>
			</div>
			<div class="form-group">

				<div class="col-lg-6">
					<form:input path="managername" required="required"
						cssClass="form-control" placeholder="法人姓名" autocomplete="off"  value="${svo.managername}"
						type="text" />

				</div>
			</div>
			<div class="form-group">

				<div class="col-lg-6">
					<form:input path="managerphone" required="required"
						placeholder="法人电话" autocomplete="off" value="${svo.managerphone}"
						cssClass="numeric form-control" />

				</div>
			</div>

			<div class="form-group">

				<div class="col-lg-6">
					<form:input path="manageridentitynum" required="required"
						placeholder="法人身份证号码" autocomplete="off" value="${svo.manageridentitynum}"
						cssClass="numeric form-control" />

				</div>
			</div>
			<div class="form-group">

				<div class="col-lg-6">
					<form:input path="alipayaccount" required="required"
						cssClass="form-control" placeholder="支付宝账户*（重要）" value="${svo.alipayaccount}"
						autocomplete="off" />
					<!--<form:errors path="alipayaccount" cssClass="error" />-->
				</div>
			</div>

			<div class="form-group">
				
				<div class="col-lg-10 col-lg-offset-2">
					<input type="button" id="choose" value="上传照片"
						class="button button-glow button-rounded button-raised button-primary">
				</div>
			</div>


			<br>

			<div class="form-group">
				<div class="col-lg-10 col-lg-offset-2">

					<button type="submit" id="sub"
						class="button button-glow button-rounded button-raised button-primary">申请认证</button>
				</div>
			</div>
			<div id="imagepanel">
				<div id="dialog" title="选择照片">
					<div class="form-group">
						<p>营业执照</p>
						<input type="file" class="file-2" name="licensefile" required="required" />
						<imgage value="${svo.licenseImageUrl}" > </imgage>
					</div>
					<div class="form-group">
						<p>手持身份证</p>
						<input type="file" class="file-2" name="idfile" required="required"/>
						<imgage value="${svo.idImageUrl}" > </imgage>
					</div>
					<div class="form-group">
						<p>身份证（背）</p>
						<input type="file" class="file-2" name="idfileback" required="required" />
						<imgage value="${svo.idbackImageUrl}" > </imgage>
					</div>
					<p id="err" class="error">请选择上传文件</p>
					<hr>
					<div class="ui-form-item">
						<p>照片示例</p>
						<img src="/resource/image/营业执照.jpg" height="100" width="140">
						<img src="/resource/image/身份证证明.jpg" height="100" width="140">
						<img src="/resource/image/身份证背面马赛克.jpg" height="100" width="140">
					</div>
				</div>
			</div>
		</fieldset>
	</form:form>
</body>