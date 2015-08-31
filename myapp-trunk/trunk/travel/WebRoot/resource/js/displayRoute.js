/**
 * 
 */
var weeks = [ "周一", "周二", "周三", "周四", "周五", "周六", "周日" ];
$(function() {
	$('#nodes').accordion();
	$("#tabs").tabs();
	$("#from").datepicker({
		defaultDate : "+1w",
		changeMonth : true,
		numberOfMonths : 2,
		minDate : 0,
		onClose : function(selectedDate) {
			$("#to").datepicker("option", "minDate", selectedDate);
		}
	});
	$("#to").datepicker({
		defaultDate : "+1w",
		changeMonth : true,
		numberOfMonths : 2,
		onClose : function(selectedDate) {
			$("#from").datepicker("option", "maxDate", selectedDate);
		}
	});
	$("#dialog").dialog({
		autoOpen : false,
		width : 800,
		height : 600,
		draggable : false,
		resizable : false,
		modal : true,
	})
	$("#updialog").dialog({
		autoOpen : false,
		width : 500,
		height : 300,
		draggable : false,
		resizable : false,
		modal : true,
	})
	$("#sub").hide();
	$('#gallery').find('li').each(function() {
		$(this).hide();
	});
});

function clearImage() {
	$('#gallery').find('li').each(function() {
		$(this).find('a').attr('href', '');
		$(this).find('img').attr('src', '');
	});
}

function viewRoute(x, y) {
	if (x != 6) {
		clear();
		var id = "#result" + x + y;
		var urlid = $(id).val();
		$('#passid').val(urlid);
		jQuery.ajax({
			type : 'GET',
			contentType : 'application/json',
			url : '/backend/route/routeinfo/' + urlid,
			dataType : 'json',
			success : function(data) {
				var files = [];
				var img = data.themeImageUrl;
				files.push(img);
				$("#name").text(data.name);
				$.each(data.dayofweek, function(i, item) {
					$('#days').append(
							'<label class="label label-success">' + weeks[item - 1]
									+ '</label> &nbsp &nbsp');
				});
				$.each(data.nodes, function(i, item) {
					var day = "第" + (i + 1) + "天";
					$('#nodes').append(
							'<h3>' + day + '</h3><div> <br><li> 主题名: '
									+ item.name + '</li><br> 关键字 :<div> '
									+ item.keywords + '<br></div> 简述: <div> '
									+ item.description
									+ '</div><br> 当天住宿: <div>'
									+ item.accommodation + '<br>'
									+ '</div></div>');
					files.push(item.ipath);
				});
				$('#nodes').accordion("destroy").accordion({
					collapsible : true,
					active : false,
					heightStyle : "content"
				});
				$('#gallery').find('li').each(function(index) {
					if (index < files.length) {
						$(this).find('a').attr('href', files[index]);
						$(this).find('img').attr('src', files[index]);
						$(this).show();
						console.log(index);
					} else {
						$(this).hide();
					}
				});
				$.each(data.details, function(i, item) {
					$('#cars').append(
							'<div class="alert alert-dismissible alert-success">车型:'
									+ item.vehiclename + '<br/> 价格: '
									+ item.price + ' <br/> 最大团数: ' + item.limit
									+ '<br/></div>');
				});
				if (x == 3 || x == 4 || x == 5) {
					$("#sub").show();
				} else {
					$("#sub").hide();
				}
			},
			error : function() {
				alert("error")
			}
		});
		$("#dialog").dialog("open");
	} else {
		var id = "#result" + x + y;
		var urlid = $(id).val();
		$('#uprouteid').val(urlid);
		$("#updialog").dialog("open");
	}
}
function clear() {
	$('#days').empty();
	$('#nodes').empty();
	$('#cars').empty();
	$('#nodes').empty();
	clearImage();
}

function deleterecord() {
	$("#deleteform").submit();
}
function deletedraft() {
	$("#deleteform2").submit();
}
