/**
 * 
 */
var chooseurl;
$(function() {
	var i=1;
	$(".col-md-2").find(".Bigicon-circle").each(function(){
		$(this)
		.css({"background":
				"#dda994 url('/resource/image/headSamplephoto/sample"+i+".jpg') no-repeat center center",
				"background-size": "contain"});
		i++;
    });
	choose();
	$("#myhead").hide();
	var dlg=$("#myhead").dialog({
		autoOpen : false,
		model : true,
		resizable : false,
		draggable: false,
		width : 800,
		height : 600,
		buttons : {
			"确定" : function() {
				if(chooseurl.length>2){
				$("#choosing_image").prop("src",chooseurl);
				$("#imgurl").val("");
				}else{
					$("#choosing_image").prop("src","/resource/image/headSamplephoto/sample"+chooseurl+".jpg");
					$("#imgurl").val("/resource/image/headSamplephoto/sample"+chooseurl+".jpg");
				}
				$(this).dialog("close");
			},
			"取消" : function() {
				$(this).dialog("close");
			},
		},
	}); 
	dlg.parent().appendTo($("#myform"));
});
function chooseimage() {
	$("#myhead").show();
	$("#myhead").dialog("open");
}
function choose()
{ 
	$(".col-md-2").find(".Bigicon-circle").each(function(index){
		$(this).click(function(){
			removechoose();
			chooseurl=index+1;
			$(this).toggleClass("choose");
		});
	})
}

function removechoose(){
	$(".col-md-2").find(".Bigicon-circle").each(function(){
			$(this).removeClass("choose");
	})
}
function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $('#uploadimage')
                .css({"background":
    				"#dda994 url("+e.target.result+") no-repeat center center",
    				"background-size": "contain"});
            chooseurl=e.target.result;
        };
        reader.readAsDataURL(input.files[0]);
    }
}

