<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/share/tagLibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>laps-team7</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="/laps/css/laps.css">
	<link rel="stylesheet" type="text/css" href="/laps/css/styles.css">
	<link rel="stylesheet" type="text/css" href="/laps/css/jquery-ui.css">
	
    <script src="/laps/js/jquery/jquery-2.1.1.js"> </script>
    <script src="/laps/js/jquery/jquery-ui.js"> </script>
    <script src="/laps/js/init.js"></script>
    

  </head>
  
  <body class="content">
     <div>
        <form:form method="post" action="business/employee/enterViewEmployee"  commandName="vo" >
            <table class="content">
                <tr>
                    <td width="110">
                        <div>
                           Employee Name
                        </div>
                    </td>
                    <td width="100">
                        ${vo.tbCsmEmployeeBO.employeeName}
                    </td>
                </tr>
                
                <tr>
                    <td width="110">
                        <div>
                            Employee Num
                        </div>
                    </td>
                    <td width="100">
                         ${vo.tbCsmEmployeeBO.employeeNum}
                    </td>
                </tr>
                
                 
                <tr>
                    <td width="110">
                       
                            Birth Day                       
                    </td>
                    <td width="100" colspan="2">
                         ${vo.tbCsmEmployeeBO.birthDay}
                    </td>
                </tr>
                
                <tr>
                    <td width="110">
                           Gender       
                    </td>
                    <td width="100" colspan="2">
                        <laps:codetable codeTypeCd="GenderCd" codeValue="${vo.tbCsmEmployeeBO.gender}"/>
                    </td>
                </tr>
                
                  <tr>
                    <td width="110">
                           Identity Num       
                    </td>
                    <td width="100" colspan="2">
                         ${vo.tbCsmEmployeeBO.idNum}
                    </td>
                </tr>
                
                <tr>
                    <td width="110">
                           Passport Num       
                    </td>
                    <td width="100" colspan="2">
                         ${vo.tbCsmEmployeeBO.passportNum}
                    </td>
                </tr>
                
                
                 <tr>
                    <td width="110">
                           Employee Type       
                    </td>
                    <td width="100" colspan="2">
                         <laps:codetable codeTypeCd="EmployeeTypeCd" codeValue="${vo.tbCsmEmployeeBO.employeeType}"/>
                    </td>
                </tr>
                
                 
                 <tr>
                    <td width="110">
                           Email     
                    </td>
                    <td width="100" colspan="2">
                         ${vo.tbCsmEmployeeBO.email}
                    </td>
                </tr>
                
                <tr>
                    <td width="110">
                           Address     
                    </td>
                    <td width="100" colspan="2">
                         ${vo.tbCsmEmployeeBO.address}
                    </td>
                </tr>
                
                <tr>
                    <td width="110">
                           Mobile     
                    </td>
                    <td width="100" colspan="2">
                         ${vo.tbCsmEmployeeBO.mobile}
                    </td>
                </tr>
                
                <tr>
                    <td width="110">
                           Telephone Num     
                    </td>
                    <td width="100" colspan="2">
                         ${vo.tbCsmEmployeeBO.telephoneNum}
                    </td>
                </tr>
                
                
                
               <tr>
                    <td width="110">
                           Status     
                    </td>
                    <td width="100" colspan="2">
                         <laps:codetable codeTypeCd="EmployeeStatusCd" codeValue="${vo.tbCsmEmployeeBO.status}"/>
                    </td>
                </tr>
                
                <tr>
                    <td colspan="2">
                             <input type="button" class="frm_btn" value="back" onclick="history.back()"/>
                             
                    </td>
                </tr>
            </table>
        </form:form>
    </div>

    <DIV><B></B></DIV>
    
  </body>
</html>
