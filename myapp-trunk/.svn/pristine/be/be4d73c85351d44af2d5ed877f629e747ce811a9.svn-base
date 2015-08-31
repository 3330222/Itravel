<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/share/tagLibs.jsp" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'hello.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<link rel="stylesheet" href="/laps/css/laps.css" type="text/css">
	<script src="/laps/js/jquery/jquery-2.1.1.js"> </script>
    <script src="/laps/js/pagination.js"></script> 	
    <script src="/laps/js/validate.js"></script>


  </head>
  
  <body>
    <form:form action="business/employee/displayEmployeeList" method="post" modelAttribute="vo">
    <form:hidden path="page" />
    <form:hidden path="requestEntryId" id="requestEntryId" />
    
    <table>
	    <tr >
	        <td colspan="7" bgcolor="#6495ED" align="right">
	    	    <%@ include file="/WEB-INF/jsp/share/pagination.jsp" %>
	       </td>
	    </tr>
	    <tr>
	      <td width="2%" bgcolor="6f8ac4"> <div align="center"><font color="black"><b>Select</b></font></div></td>
	      <td width="10%" bgcolor="6f8ac4"> <div align="center"><font color="black"><b>Name</b></font></div></td>
	      <td width="10%" nowrap bgcolor="6f8ac4"> <div align="center"><font color="black"><b>Num</b></font></div></td>
	      <td width="10%" bgcolor="6f8ac4"> <div align="center"><font color="black"><b>Type</b></font></div></td>
	    </tr>
	    
	    <!---------------------------LOOP START------------------------------>
	   <c:forEach items="${vo.pageView.records}" var="entry">
	    <tr>
	      <td bgcolor="#F1F1F1" width="2%" > <div align="center"><input onclick="setRequestEntryId('${entry.employeeId}');"  type="radio" name="requestTypeId"  value="${entry.employeeId}"/></div></td>
	      <td bgcolor="#F1F1F1" width="10%"> <div align="center">${entry.employeeName}</div></td>
	      <td bgcolor="#F1F1F1" width="10%"> <div align="center">${entry.employeeNum}</div></td>
	      <td bgcolor="#F1F1F1" width="10%"> <div align="center"><laps:codetable codeTypeCd="EmployeeTypeCd" codeValue="${entry.employeeType}" /></div></td>          
		</tr>
	    </c:forEach>
	    <!----------------------LOOP END------------------------------->
	    <tr >
	       <td colspan="6">
	          <input size="8" name="add" type="button" class="frm_btn" id="add" onclick="showDialog(this,'/laps/business/employee/enterCreateEmployee')" value="add"> &nbsp;&nbsp;
              <input size="8" name="view" type="button" class="frm_btn" id="view" onclick="validateToPage('/laps/business/employee/enterViewEmployee')" value="view"> &nbsp;&nbsp;
              <input size="8" name="edit" type="button" class="frm_btn" id="edit" onclick="validateToPage('/laps/business/employee/enterEditEmployee')" value="edit"> &nbsp;&nbsp;
              <input size="8" name="del"  type="button" class="frm_btn" id="del" onclick="validateDelRadioButton('/laps/business/employee/deleteEmployee')" value="del"> &nbsp;&nbsp;
            </td>
	    </tr>
    </table>
    </form:form>
  </body>
</html>
