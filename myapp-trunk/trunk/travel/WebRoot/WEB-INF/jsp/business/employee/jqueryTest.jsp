<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/share/tagLibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="/resource/css/jquery/jquery-ui.css">
 <script src="/resource/js/jquery/jquery-2.1.1.js"> </script>
 <script src="/resource/js/jquery/jquery-ui.js"> </script>
 <script src="/resource/js/jquery/jquery.bpopup.js"> </script>
 <script src="/resource/js/core/syscore-1.0.js"> </script>
 
 <style>
	.ui-progressbar { position: relative; background: lightyellow; }
	
	#processingLabel { position: absolute;left: 20%; top: 2px; }
	
	#photoTabs { width: 800px;}
	
	.ui-menu { width: 150px; }
	
	#departmentNames { width: 200px; border:3px double green; background-color: lightyellow; }
    #dropArea {height: 150px; width: 240px; border:3px double green; background-color: lightcyan; }
    
   
    #departmentNames .ui-selecting { background: lightgreen; }
    #departmentNames .ui-selected { background: green; color: white; }
	
</style>

<script>
$(function() {
	$("#btnSubmitPayment").button();
	$("#btnSubmitPayment").click(function () {
		registerPopUp("#dialogProcessingStatus",onCommit, onCancel);
     });
	
	 $("#popupwindow").button().click(function(){
	    	//alert("xxxxxxx");
	    	//$("#WindowFrame").bPopup();
	    	$("WindowFrame").bPopup();
	    	
	    });
	    
	
	
	var timer = setInterval( updateProcessCompletion, 100 );
	var processCompletion = 0;
	$("#paymentProcessingStatus").progressbar({
	change: function() {
		$( "#processingLabel" ).text( $("#paymentProcessingStatus").progressbar
		( "value" ) + "%" );
	},
	complete: function() {
		clearInterval(timer);
		$( "#processingLabel" ).text( "Completed." );
	}
	});

	function updateProcessCompletion() {
		$("#paymentProcessingStatus").progressbar( "value", processCompletion++);
	}
	
	//tabs
	$("#photoTabs").tabs();
	
	
	//accordian
	$( "#album" ).accordion({
		active: 2,
		icons: {
		header: "ui-icon-triangle-1-e",
		activeHeader: "ui-icon-triangle-1-s"
		}
		});
	
	//menu
	$("#appMenu").menu();
	$("#help").click(function (){
	alert("Help is clicked.");
	// Get the help content and display in dialog widget.
	});
	
	
	
	//draggable and droppable
	$("#departmentNames li").draggable({
		revert: "invalid"
		});
		$("#dropArea").droppable({
		accept: "li",
		drop: function( event, ui ) {
		$("#message").append(ui.draggable.text() + "<br>");
		}
		});
	
    $("#departmentNames").selectable();
    
    
   
		
});

function onCommit(){
	alert("You need to do sth in this on commit method");
}

function onCancel(){
	alert("Good bye bye");
}


</script>

<title>Upload a file please</title>
</head>
<body>

<div class="ui-widget">
<button id="btnSubmitPayment">popup</button>


<div id="dialogProcessingStatus" title="Processing Status" style="display:none">
    <p>Payment processing is completed. If you have any questions,
        please contact us at (877)-555-5555.
    </p>
</div>

</div>

<button id="popupwindow">popup window</button>
<div id="WindowFrame" title="popupwindow" style="display:none">
   
</div>

<div class="ui-widget">
	<div id="paymentProcessingStatus" style="width:150px; height:30px; background-color:lightyellow">
		<div id="processingLabel">
		Started...
		</div>
	</div>
</div>

<div class="ui-widget">
<div id="photoTabs">
<ul>
<li><a href="#animalsTab">Animals</a></li>
<li><a href="#birdsTab">Birds</a></li>
<li><a href="#insectsTab">Insects</a></li>
<li><a href="#seaAnimalsTab">Sea Animals</a></li>
</ul>
<div id="animalsTab">
<img src="images/Cat.png"/>
<img src="images/Dog.png"/>
<img src="images/Elephant.png"/>
<img src="images/Hippopotamus.png"/>
<img src="images/Panda.png"/>
</div>
<div id="birdsTab">
<img src="images/Bird1.png"/>
<img src="images/Bird2.png"/>
<img src="images/Owl.png"/>
<img src="images/Penguin1.png"/>
<img src="images/Penguin2.png"/>
</div>
<div id="insectsTab">
<img src="images/Butterfly1.png"/>
<img src="images/Butterfly2.png"/>
<img src="images/Butterfly3.png"/>
<img src="images/Grasshopper.png"/>
<img src="images/LadyBug.png"/>
</div>
<div id="seaAnimalsTab">
<img src="images/Fish2.png"/>
<img src="images/Dolphin.png"/>
<img src="images/Fish1.png"/>
<img src="images/JellyFish.png"/>
<img src="images/WireShark.png"/>
</div>
</div>



<div id="album">
<h3>Animals</h3>
<div>
<img src="images/Cat.png"/>
<img src="images/Dog.png"/>
<img src="images/Elephant.png"/>
<img src="images/Hippopotamus.png"/>
<img src="images/Panda.png"/>
</div>
<h3>Birds</h3>
<div>
<img src="images/Bird1.png"/>
<img src="images/Bird2.png"/>
<img src="images/Owl.png"/>
<img src="images/Penguin1.png"/>
<img src="images/Penguin2.png"/>
</div>
<h3>Insects</h3>
<div>
<img src="images/Butterfly1.png"/>
<img src="images/Butterfly2.png"/>
<img src="images/Butterfly3.png"/>
<img src="images/Grasshopper.png"/>
<img src="images/LadyBug.png"/>
</div>
<h3>Sea Animals</h3>
<div>
<img src="images/Fish2.png"/>
<img src="images/Dolphin.png"/>
<img src="images/Fish1.png"/>
<img src="images/JellyFish.png"/>
<img src="images/WireShark.png"/>
</div>
</div>


<div class="ui-widget">
Employee Records Management System
<br><br>
<ul id="appMenu">
<li><a href="#"><span class="ui-icon ui-icon-person"></span>New</a></li>
<li><a href="#"><span class="ui-icon ui-icon-pencil"></span>Edit</a></li>
<li><a href="#"><span class="ui-icon ui-icon-search"></span>Search</a></li>
<li class="ui-state-disabled"><a href="#"><span class="ui-icon ui-icon-gear">
</span>Settings</a></li>
<li>
<a href="#">Reports</a>
<ul>
<li><a href="#"><span class="ui-icon ui-icon-document"></span>Monthly</a></li>
<li><a href="#"><span class="ui-icon ui-icon-document"></span>Daily</a></li>
</ul>
</li>
<li><a id="help" href="#"><span class="ui-icon ui-icon-info"></span>Help</a></li>
</ul>
</div>


Departments:
<ul id="departmentNames">
<li>Marketing</li>
<li>Sales</li>
<li>Development</li>
<li>Implementation</li>
<li>Production Support</li>
<li>Customer Support</li>
</ul>
<div id="dropArea" style="height"></div>
<div id="message"><strong>Items Dragged and Dropped:</strong><br></div>

</div>
</body>
</html>
