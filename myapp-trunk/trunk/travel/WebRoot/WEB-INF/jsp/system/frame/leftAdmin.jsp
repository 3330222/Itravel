<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/jsp/share/tagLibs.jsp" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base target="mainframe">
<script src="/laps/js/leftMenu.js"></script>

</head>
<body leftmargin="0" topmargin="0" bgcolor="#F1F1F1"><br>
<!-------------------------START------------------------------->
<table border=0 width="98%" align="center" cellspacing="0" cellpadding="0">
  <tr> 
    <td colspan="3" language="JavaScript" onMouseUp="turnit('work')" style="CURSOR: hand"> 
      
        <font face=""><b>System Management</b></font> 
    </td>
  </tr>
</table>
<table id="menu_work" border=0 width="98%" align="center" cellspacing="0" cellpadding="0" style="display:none">
  <tr>
    <td width="50"></td>
    <td width="123"> <a href="/laps/business/employee/displayEmployeeList">Employee</a></td>
  </tr>
  
  <tr>
    <td width="50"></td>
    <td width="123"> <a href="/laps/business/leavetype/displayList">Leave Type</a></td>
  </tr>
  
  <tr>
    <td width="50"></td>
    <td width="123"> <a href="/laps/business/holiday/displayHolidayList">Holiday</a></td>
  </tr>
  
  <tr>
    <td width="50"></td>
    <td width="123"> <a href="/laps/business/entitlement/displayList">Entitlement</a></td>
  </tr>
</table>
<!-------------------------END ------------------------------->

</body>
</html>
