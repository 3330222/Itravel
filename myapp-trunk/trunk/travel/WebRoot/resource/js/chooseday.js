/**
 * 
 */
var d = "第";
var y = "天";
var a = 1;
var day = d + a + y;
var cars = [ "轿车", "商务车", "大巴", "自行车" ];
$(function() {
	$("#format").buttonset();
	$(".cartitle").hide();
	$(".forcar").each(function() {
		choosecar($(this));
	});
	$("#accordion").accordion();
	$("#sub").click(function(e) {
		var x = $("#select").val();
		if (isNaN(x) || x == "") {
			alert("请选择正确的天数");
			e.preventDefault();
		} else {
			$("#flag").val("true");
			$("#myform").attr('action','/backend/route/newroute')
			$("#myform").submit();
		}
	})
	$("#select").on("spinchange", function(event, ui) {
		var x = $(this).val();
		if (isNaN(x) || x == "") {
			alert("请选择正确的日程数");
		} else {
			showaccordion();
		}
	});
});
function choosecar(x) {
	var c = $(x).val();
	var thecar = "#car" + c;
	var detail = "#detail" + c;
	var price = "#price" + c;
	var limit = "#limit" + c;
	if ($(x).is(':checked')) {
		$(thecar).text(cars[c - 1]);
		$(thecar).show();
	} else {
		$(thecar).hide();
		$(detail).hide();
		$(price).val("");
		$(limit).val("0");
	}
	;
}
function showaccordion() {
	$("#flag").val("false");
	$("#myform").attr('action','/backend/route/newroute')
	$("#myform").submit();
}
