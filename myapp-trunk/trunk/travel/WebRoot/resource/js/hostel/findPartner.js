/**
 * 
 */
$(function() {
	$("#radio1").buttonset();
	$("#radio2").buttonset();
	$("#radio3").buttonset();
	$("#from").datepicker({
		defaultDate : "+1w",
		changeMonth : true,
		numberOfMonths : 1,
		minDate : 0,
		onClose : function(selectedDate) {
			$("#to").datepicker("option", "minDate", selectedDate);
		}
	});
	$("#to").datepicker({
		defaultDate : "+1w",
		changeMonth : true,
		numberOfMonths : 1,
		minDate : 1,
		onClose : function(selectedDate) {
			$("#from").datepicker("option", "maxDate", selectedDate);
		}
	});
});
function readURL(input,x) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			var image="#uploadimage"+x;
			$(image).css(
					{
						"background" : "#dda994 url(" + e.target.result
								+ ") no-repeat center center",
						"background-size" : "contain"
					});
			chooseurl = e.target.result;
		};
		reader.readAsDataURL(input.files[0]);
	}
}