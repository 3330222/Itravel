<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="/resource/js/jquery/jquery-2.1.1.js"></script>
<script src="/resource/js/jquery/jquery-ui.js"></script>
<link rel="stylesheet" href="/resource/css/bootstrap.css">
<link rel="stylesheet" href="/resource/css/hostel/default.css">
<link rel="stylesheet" href="/resource/css/hostel/fileinput.css">
<script src="/resource/js/hostel/chooseday.js"></script>
<script src="/resource/js/hostel/numeric.js"></script>
<link rel="stylesheet" href="/resource/css/button.css">
<link rel="stylesheet" href="/resource/css/jquery-ui.css"> 
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css"
	rel="stylesheet">
<script src="/resource/js/fileinput.js" type="text/javascript"></script>
<script src="/resource/js/fileinput_locale_zh.js" type="text/javascript"></script>
<style>
textarea {
	resize: none;
}
.menu_btns{
	width:300px;
  	text-align: center;
}

#accordion-resizer {
	/* width: 500px;
	height: 400px; */
	resize: none;
}

.error {
	color: #ff0000;
	font-style: italic;
}
</style>
<script>
	$(function() {
		$(".numeric").numeric();
		$("#car").accordion({
			collapsible : true,
			active : false,
			heightStyle : "content"
		});
		$(".spinner").spinner({
			min : 1,
			step : 1,
			numberFormat : "n"
		});
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
		$("#preview").click(function() {
			var name = $("#route-name").val();
			var x = $("#select").val();
			if (isNaN(x) || x == "") {
				alert("请选择正确的天数");
				e.preventDefault();
			} else if (name == "") {
				alert("请输入路线名");
				e.preventDefault();
			} else {
				$("#myform").attr('action', '/backend/route/preview');
				$("#myform").attr('method', 'post');
				$("#myform").attr('target', '_blank');
				$("#myform").submit();
			}
		})
		$("#cancel").click(function() {
			var name = $("#route-name").val();
			var x = $("#select").val();
			if (isNaN(x) || x == "") {
				alert("请选择正确的天数");
				e.preventDefault();
			} else if (name == "") {
				alert("请输入路线名");
				e.preventDefault();
			} else {
				$("#myform").attr('action', '/backend/route/cancel');
				$("#myform").submit();
			}
		})
		$("#allday").click(function() {
			$(".lday").each(function() {
				$(this).prop("checked", true);
			})
		});
	});
</script>
<body>
	<form:form id="myform" class="form-horizontal"
		action="/backend/route/newroute" method="post"
		enctype="multipart/form-data" commandName="vo">
		<input type="hidden" id="flag" name="flag" value="true" />
		<c:forEach items="${vo.dayofweek}" var="aday">
			<input type="hidden" value="${aday}" class="daynum">
		</c:forEach>
		<fieldset>
			<div class="form-group">
				<label for="inputName" class="col-lg-2 control-label">路线名字</label>
				<div class="col-lg-6">
					<form:input path="name" cssClass="form-control" placeholder="路线名称"
						value="${vo.name}" autocomplete="off" maxlength="30"
						id="route-name" />
					<form:errors path="name" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="textArea" class="col-lg-2 control-label">发团时间</label>
				<div class="col-lg-9">
					<form:checkbox path="dayofweek" value="1" class="lday" />
					周一
					<form:checkbox path="dayofweek" value="2" class="lday" />
					周二
					<form:checkbox path="dayofweek" value="3" class="lday" />
					周三
					<form:checkbox path="dayofweek" value="4" class="lday" />
					周四
					<form:checkbox path="dayofweek" value="5" class="lday" />
					周五
					<form:checkbox path="dayofweek" value="6" class="lday" />
					周六
					<form:checkbox path="dayofweek" value="7" class="lday" />
					周日 <input type="button" id="allday" value="全选"
						class="button button-glow button-rounded button-raised button-primary" />
					<form:errors path="dayofweek" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="inputName" class="col-lg-2 control-label">行程天数</label>
				<div class="col-lg-3">
					<input id="select" class="spinner" name="nodesnum"
						value="${vo.nodes.size()}" />
				</div>
			</div>
			<div class="form-group">
				<label for="inputName" class="col-lg-2 control-label">每日行程</label>
				<div class="col-lg-9">
					<div id="panel">
						<div id="accordion">
							<c:forEach begin="1" end="${vo.nodes.size()}" varStatus="status">
								<p>第${status.index}天</p>
								<div>
									<div class="form-group">
										<label for="inputName" class="col-lg-2 control-label">今日游</label>
										<form:input path="nodes[${status.index-1}].name"
											class="form-control" placeholder="今日游主题名" autocomplete="off"
											maxlength="20" />
										<form:errors path="nodes[${status.index-1}].name"
											cssClass="error" />
									</div>
									<div class="form-group">
										<label for="inputName" class="col-lg-2 control-label">关键字</label>
										<form:input path="nodes[${ status.index-1}].keywords"
											class="form-control" placeholder="关键字" autocomplete="off"
											maxlength="20" />
									</div>
									<div class="form-group">
										<label for="inputName" class="col-lg-2 control-label">描述</label>
										<form:textarea path="nodes[${ status.index-1}].description"
											class="form-control" rows="3" placeholder="今日简述"
											autocomplete="off" maxlength="100" />
										<form:errors path="nodes[${status.index-1}].description"
											cssClass="error" />
									</div>
									<div class="form-group">
										<label for="inputName" class="col-lg-2 control-label">住宿</label>
										<form:input path="nodes[${ status.index-1}].accommodation"
											class="form-control" placeholder="今日住宿" autocomplete="off"
											maxlength="20" />
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="textArea" class="col-lg-2 control-label">车型</label>
				<div class="col-lg-6">
					<div id="accordion-resizer">
						<div id="format"></div>
						<form:checkbox path="cars" value="1" onclick="choosecar(this)"
							class="forcar" />
						轿车
						<form:checkbox path="cars" value="2" onclick="choosecar(this)"
							class="forcar" />
						商务车
						<form:checkbox path="cars" value="3" onclick="choosecar(this)"
							class="forcar" />
						大巴
						<form:checkbox path="cars" value="4" onclick="choosecar(this)"
							class="forcar" />
						自行车
						<form:errors path="cars" cssClass="error" />
						<div id="car">
							<c:forEach begin="0" end="3" varStatus="ctype">
								<p id="car${ctype.index+1}" class="cartitle"></p>
								<div id="detail${ctype.index+1 }">
									<form:hidden path="details[${ctype.index}].vehiclename"
										id="carname${ctype.index}" value="${cars[ctype.index]}" />
									价格
									<form:input path="details[${ctype.index}].price"
										id="price${ctype.index+1}"
										value="${details[ctype.index].price}"
										cssClass="numeric form-control" autocomplete="off" />
									<br /> <br /> 发团次数
									<form:input path="details[${ctype.index}].limit"
										id="limit${limit.index+1}"
										value="${details[ctype.index].limit}"
										cssClass="numeric form-control" autocomplete="off" />
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="textArea" class="col-lg-2 control-label">注意事项</label>
				<div class="col-lg-6">
					<form:textarea class="form-control" rows="3" placeholder="注意事项"
						path="des" value="${vo.des}" />
				</div>
			</div>
			<div class="form-group">
				<label for="inputName" class="col-lg-2 control-label">上传照片</label>
				<div class="col-lg-6">
					<input type="button" id="choose" value="选择图片"
						class="button button-glow button-rounded button-raised button-primary">
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-10 col-lg-offset-2">
					<button type="button"
						class="button button-glow button-rounded button-raised"
						id="cancel">取消</button>
					<button type="button"
						class="button button-glow button-rounded button-raised"
						id="preview">预览</button>
					<button type="button" id="sub"
						class="button button-glow button-rounded button-raised button-primary">新建</button>
				</div>
			</div>
			<div id="imagepanel">
				<div id="dialog" title="选择照片">
					<div class="form-group">
						<label>主题照片</label> <input type="file" name="file" class="file-2" />
					</div>
					<c:forEach begin="1" end="${vo.nodes.size()}" varStatus="status">
						<br>
						<div class="form-group">
							<label>第${status.index}天</label> <input type="file"
								name="nodes[${status.index-1}].image" class="file-2" />
						</div>
					</c:forEach>
					<label id="err" class="error">请选择上传文件</label>
					<hr>
					<%-- <div class="form-group">
						<input id="file-1" type="file" name="file"
							data-overwrite-initial="false"
							data-min-file-count="${vo.nodes.size()}"
							data-max-file-count="${vo.nodes.size()+1}" multiple>
					</div> --%>
				</div>
			</div>
		</fieldset>

		<script>
			/* upload  */
			$(".file-2").fileinput({
				showUpload : false,
				showCaption : false,
				allowedFileExtensions : [ 'jpg', 'png', 'gif', 'jpeg' ],
				browseClass : "btn btn-primary",
			});
			/* $("#file-1").fileinput({
				uploadUrl : '/backend/route/saveimage',
				overwriteInitial : false,
				showUpload : true,
				showCaption : false,
				allowedFileExtensions : [ 'jpg', 'png', 'gif', 'jpeg' ],
				overwriteInitial : false,
				//allowedFileTypes: ['image', 'video', 'flash'],
				slugCallback : function(filename) {
					return filename.replace('(', '_').replace(']', '_');
				}
			}); */
		</script>
	</form:form>
</body>
</html>