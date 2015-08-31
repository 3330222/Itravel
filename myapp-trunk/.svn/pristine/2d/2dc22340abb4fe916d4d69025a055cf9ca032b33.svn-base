<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/jsp/share/tagLibs.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base target="mainframe">
<Script language="javaScript">
function getTablesByStart(name){
	var inputs = document.getElementsByTagName("table");
	var files = new Array();
	var y = 0;
	for (var i=0; i<inputs.length; i++) {		
	  if (inputs[i].id !=null && inputs[i].id.length>name.length && inputs[i].id.substring(0, name.length)==name){
		 files[y] = inputs[i];
		 y++;
	  }
	}
	return files;
}

function HideAll(){
	var tables = getTablesByStart("menu_");
    for (var i=0; i<tables.length; i++) {
		tables[i].style.display = "none";
		var id = tables[i].id.substring("menu_".length);
		var imgId = document.getElementById("Img"+ id);
		var imgId2 = document.getElementById("Img"+ id + "_0");
		if(imgId) imgId.src="/laps/images/midclosedfolder.gif";
		if(imgId2) imgId2.src="/laps/images/clsfld.gif";
	}
}

function turnit(id) {
	var menu = document.getElementById("menu_"+ id);
	var imgId = document.getElementById("Img"+ id);
	var imgId2 = document.getElementById("Img"+ id + "_0");
	if (menu.style.display=="none"){
		HideAll();
		menu.style.display = "";
		if(imgId) imgId.src="/laps/images/midopenedfolder.gif";
		if(imgId2) imgId2.src="/laps/images/openfld.gif";
	}else{
		menu.style.display = "none";
		if(imgId) imgId.src="/laps/images/midclosedfolder.gif";
		if(imgId2) imgId2.src="/laps/images/clsfld.gif";
	}
}
</Script>
<style type="text/css">
<!--
td {  font-size: 13px; color:#000000; font-weight: none}
a:active {  color:#FF6600; text-decoration: none}
a:hover {  color:#FF6600; text-decoration: none}
a:link {  color: #FF6600; text-decoration: none}
a:visited {  color:#FF6600; text-decoration: none}
-->
</style>
</head>
<body leftmargin="0" topmargin="0" bgcolor="#F1F1F1"><br>
<!-------------------------START------------------------------->
<table border=0 width="98%" align="center" cellspacing="0" cellpadding="0">
  <tr> 
    <td colspan="3" language="JavaScript" onMouseUp="turnit('Product')" style="CURSOR: hand"> 
      
        <font face=""><b>title-1</b></font> 
    </td>
  </tr>
</table>
<table id="menu_Product" border=0 width="98%" align="center" cellspacing="0" cellpadding="0" style="display:none">
  <tr> 
    <td width="50"></td>
    <td width="123"> <a href="/laps/business">sub-title-1</a></td>
  </tr>
  <tr> 
    <td width="50"></td>
    <td width="123"> <a href="/control/brand/list.action">subtitle-2</a> </td>
  </tr>
  <tr> 
    <td width="50"></td>
    <td width="123"> <a href="/control/product/list.action">subtitle-3</a> </td>
  </tr>
</table>

<!-------------------------START------------------------------->
<table border=0 width="98%" align="center" cellspacing="0" cellpadding="0">
  <tr> 
    <td colspan="3" language="JavaScript" onMouseUp="turnit('file')" style="CURSOR: hand"> 
      
        <b>title-2</b>
    </td>
  </tr>
</table>
<table id="menu_file" border=0 width="98%" align="center" cellspacing="0" cellpadding="0" style="display:none">
  <tr> 
    <td width="50"></td>
    <td width="123"> <a href="/control/uploadfile/list.action">subtitle-2-1</a> </td>
  </tr>
</table>
<!------------------------- ------------------------------->

<!------------------------- ------------------------------->
<table border=0 width="98%" align="center" cellspacing="0" cellpadding="0">
  <tr> 
    <td colspan="3" language="JavaScript" onMouseUp="turnit('user')" style="CURSOR: hand"> 
      
        <b>title-3</b>
    </td>
  </tr>
</table>
<table id="menu_user" border=0 width="98%" align="center" cellspacing="0" cellpadding="0" style="display:none">
  <tr> 
    <td width="50"></td>
    <td width="123"> <a href="/control/buyer/list.action">sub-title-3-1</a> </td>
  </tr>
  <tr> 
    <td width="50"></td>
    <td width="123"><a href="/control/buyer/query.action">sub-title-3-2</a> </td>
  </tr>
</table>

</body>
</html>
