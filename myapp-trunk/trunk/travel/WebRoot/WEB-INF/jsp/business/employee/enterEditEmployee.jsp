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
    <script src="/laps/js/validate.js"></script>
    <script src="/laps/js/popup.js"></script>
    

  </head>
  
  <body class="content">
     <div>
        <form:form method="post" action="business/employee/editEmployee"  commandName="vo" >
             <form:hidden path="requestEntryId"/>
            <table class="content">
                <tr>
                    <td width="110">
                        <div>
                            <form:label path="tbCsmEmployeeBO.employeeName" cssErrorClass="error">
                                 <spring:message code="employee.employeeName"/>
                            </form:label>
                        </div>
                    </td>
                    <td width="100">
                        <form:input path="tbCsmEmployeeBO.employeeName" maxlength="50"/>
                    </td>
                    <td width="200">
				        <form:errors path="tbCsmEmployeeBO.employeeName"/> 
                    </td>
                </tr>
                
                <tr>
                    <td width="110">
                        <div>
                            <form:label path="tbCsmEmployeeBO.employeeNum" cssErrorClass="error">
                                 Employee Num
                            </form:label>
                        </div>
                    </td>
                    <td width="100">
                        <form:input path="tbCsmEmployeeBO.employeeNum" maxlength="10"/>
                    </td>
                    <td width="200">
				        <form:errors path="tbCsmEmployeeBO.employeeNum"/> 
                    </td>
                </tr>
                
                 
                <tr>
                    <td width="110">
                        <form:label path="tbCsmEmployeeBO.birthDay" cssErrorClass="error">
                            <spring:message code="employee.birthDay"/>
                        </form:label>                        
                    </td>
                    <td width="100" colspan="2">
                        <form:input id="datepicker" cssClass="datepicker"
                            path="tbCsmEmployeeBO.birthDay" maxlength="10" readonly="true"/>
                    </td>
                    <td width="200">
                         <form:errors path="tbCsmEmployeeBO.birthDay" /> 
                    </td>
                </tr>
                
                 <tr>
                    <td width="110">
                        <form:label path="tbCsmEmployeeBO.gender" cssErrorClass="error">
                            <spring:message code="employee.gender"/>
                        </form:label>                        
                    </td>
                    <td width="100">
                      
                      <form:select items="${CODES['GenderCd']}"  
                          itemLabel="codeName" itemValue="codeValue" path="tbCsmEmployeeBO.gender" />
                        
                    </td>
                    <td width="200">
                         <form:errors path="tbCsmEmployeeBO.gender" /> 
                    </td>
                </tr>
                
                 <tr>
                    <td width="110">
                        <form:label path="tbCsmEmployeeBO.idNum" cssErrorClass="error">
                            Identity Num
                        </form:label>                        
                    </td>
                    <td width="100">
                      
                      <form:input path="tbCsmEmployeeBO.idNum" maxlength="15"/>
                        
                    </td>
                    <td width="200">
                         <form:errors path="tbCsmEmployeeBO.idNum" /> 
                    </td>
                </tr>
                
                 <tr>
                    <td width="110">
                        <form:label path="tbCsmEmployeeBO.passportNum" cssErrorClass="error">
                            Passport Num
                        </form:label>                        
                    </td>
                    <td width="100">
                      
                      <form:input path="tbCsmEmployeeBO.passportNum" maxlength="20"/>
                        
                    </td>
                    <td width="200">
                         <form:errors path="tbCsmEmployeeBO.passportNum" /> 
                    </td>
                </tr>
                
               
                
                
                 <tr>
                    <td width="110">
                        <form:label path="tbCsmEmployeeBO.employeeType" cssErrorClass="error">
                            Employee Type
                        </form:label>                        
                    </td>
                    <td width="100">
                      
                      <form:select items="${CODES['EmployeeTypeCd']}"  
                          itemLabel="codeName" itemValue="codeValue" path="tbCsmEmployeeBO.employeeType" />
                        
                    </td>
                    <td width="200">
                         <form:errors path="tbCsmEmployeeBO.employeeType" /> 
                    </td>
                </tr>
                
                 <tr>
                    <td width="110">
                        <form:label path="managerId" cssErrorClass="error">
                             Superior
                        </form:label>                        
                    </td>
                    
                    <td width="100">
                        <form:select items="${vo.managerList }" 
                          itemLabel="employeeName" itemValue="employeeId" path="tbCsmEmployeeBO.managerId" />
                    </td>
                    <td width="200">
                         <form:errors path="managerId" /> 
                    </td>
                </tr>
                
                 <tr>
                    <td width="110">
                        <form:label path="tbCsmEmployeeBO.email" cssErrorClass="error">
                            <spring:message code="employee.email"/>
                        </form:label>                        
                    </td>
                    <td width="100">
                      
                      <form:input path="tbCsmEmployeeBO.email" maxlength="30"/>
                        
                    </td>
                    <td width="200">
                         <form:errors path="tbCsmEmployeeBO.email" /> 
                    </td>
                </tr>
                
                <tr>
                    <td width="110">
                        <form:label path="tbCsmEmployeeBO.address" cssErrorClass="error">
                            Address
                        </form:label>                        
                    </td>
                    <td width="100">
                      
                      <form:input path="tbCsmEmployeeBO.address" maxlength="100"/>
                        
                    </td>
                    <td width="200">
                         <form:errors path="tbCsmEmployeeBO.address" /> 
                    </td>
                </tr>
                
                <tr>
                    <td width="110">
                        <form:label path="tbCsmEmployeeBO.mobile"  cssErrorClass="error">
                            Mobile
                        </form:label>                        
                    </td>
                    <td width="100">
                      
                      <form:input path="tbCsmEmployeeBO.mobile" maxlength="10" cssClass="digit"/>
                        
                    </td>
                    <td width="200">
                         <form:errors path="tbCsmEmployeeBO.mobile" /> 
                    </td>
                </tr>
                
                <tr>
                    <td width="110">
                        <form:label path="tbCsmEmployeeBO.telephoneNum" cssErrorClass="error">
                            Telephone Num
                        </form:label>                        
                    </td>
                    <td width="100">
                      
                      <form:input path="tbCsmEmployeeBO.telephoneNum" maxlength="10" cssClass="digit"/>
                        
                    </td>
                    <td width="200">
                         <form:errors path="tbCsmEmployeeBO.telephoneNum" /> 
                    </td>
                </tr>
                
                <!--  
                <tr>
                    <td width="110">
                        <form:label path="tbCsmEmployeeBO.password" cssErrorClass="error">
                            Password
                        </form:label>                        
                    </td>
                    <td width="100">
                      
                      <form:input path="tbCsmEmployeeBO.password" maxlength="16" size="16"/>
                        
                    </td>
                    <td width="200">
                         <form:errors path="tbCsmEmployeeBO.password" /> 
                    </td>
                </tr>
                -->
                
                <tr>
                    <td width="110">
                        <form:label path="tbCsmEmployeeBO.status" cssErrorClass="error">
                             Status
                        </form:label>                        
                    </td>
                   
                      
                      <td width="100">
                          <form:select items="${CODES['EmployeeStatusCd']}"  
                          itemLabel="codeName" itemValue="codeValue" path="tbCsmEmployeeBO.status" />
                    </td>
                    
                     <td width="100">
                            <form:errors path="tbCsmEmployeeBO.Status" /> 
                    </td>
                    
                </tr>
                
                <tr>
                    <td colspan="2">
                            <input type="submit" value="update" class="frm_btn" onclick="return validateManager()"/>
                            <input type="button" value="back to list" class="frm_btn" onclick="toPage('<c:url value="/business/employee/displayEmployeeList"/>')"/>
                    </td>
                </tr>
            </table>
        </form:form>
    </div>

    <DIV><B>${message}</B></DIV>
    
  </body>
</html>
