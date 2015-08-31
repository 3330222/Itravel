/**
 * 
 */
$(function() {
	$("#dialog").dialog({
		autoOpen : false,
		width : 700,
		height : 500,
		draggable : false,
		resizable : false,
		modal : true,
	});
	$("#agree").click(function() {
		$("#status").val("4");
		$("#refundstatus").val("1");
		$("#myform").submit();
	});
	$("#reject").click(function() {
		$("#status").val("2");
		$("#refundstatus").val("2");
		$("#myform").submit();
	});
})
function choose(index, x) {
	$("#orderid").val($("#id" + x).val());
	if (index == 1) {
		$("#myform").hide();
	}else
	{
		$("#myform").show();
	}
	$("#dialog").dialog("open");
	$("#date").text($("#date" + index + x).val());
	$("#car").text($("#car" + index + x).val());
	$("#person").text($("#person" + index + x).val());
	$("#adult").text($("#adult" + index + x).val());
	$("#child").text($("#child" + index + x).val());
	$("#phone").text($("#phone" + index + x).val());
	$("#email").text($("#email" + index + x).val());
};