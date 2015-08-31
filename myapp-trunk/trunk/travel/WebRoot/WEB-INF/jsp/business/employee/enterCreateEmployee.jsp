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
	
	<link rel="stylesheet" type="text/css" href="/laps/css/styles.css">
	<link rel="stylesheet" type="text/css" href="/laps/css/jquery-ui.css">
	<link rel="stylesheet" type="text/css" href="/laps/css/laps.css">
	
    <script src="/laps/js/jquery/jquery-2.1.1.js"> </script>
    <script src="/laps/js/jquery/jquery-ui.js"> </script>
    <script src="/laps/js/init.js"></script>
    <script src="/laps/js/validate.js"></script>
    

  </head>
  
  <body class="content">
     <div>
        <form:form method="post" action="business/employee/createEmployee"  commandName="vo" >
           
            <table class="content">
                <tr>
                    <td width="110">
                        <div>
                            <form:label path="employeeName" cssErrorClass="error">
                                 <spring:message code="employee.employeeName"/>
                            </form:label>
                        </div>
                    </td>
                    <td width="100">
                        <form:input path="employeeName" maxlength="50"/>
                    </td>
                    <td width="200">
				        <form:errors path="employeeName"/> 
                    </td>
                </tr>
                
                <tr>
                    <td width="110">
                        <div>
                            <form:label path="employeeNum" cssErrorClass="error">
                                 Employee Num
                            </form:label>
                        </div>
                    </td>
                    <td width="100">
                        <form:input path="employeeNum" maxlength="10"/>
                    </td>
                    <td width="200">
				        <form:errors path="employeeNum"/> 
                    </td>
                </tr>
                
                 
                <tr>
                    <td width="110">
                        <form:label path="birthDay" cssErrorClass="error">
                            <spring:message code="employee.birthDay"/>
                        </form:label>                        
                    </td>
                    <td width="100" colspan="2">
                        <form:input id="datepicker" cssClass="datepicker" path="birthDay" maxlength="10" readonly="true"/>
                    </td>
                    <td width="200">
                         <form:errors path="birthDay" /> 
                    </td>
                </tr>
                
                 <tr>
                    <td width="110">
                        <form:label path="gender" cssErrorClass="error">
                            <spring:message code="employee.gender"/>
                        </form:label>                        
                    </td>
                    <td width="100">
                      
                      <form:select items="${CODES['GenderCd']}"  
                          itemLabel="codeName" itemValue="codeValue" path="gender" />
                        
                    </td>
                    <td width="200">
                         <form:errors path="gender" /> 
                    </td>
                </tr>
                
                 <tr>
                    <td width="110">
                        <form:label path="idNum" cssErrorClass="error">
                            Identity Num
                        </form:label>                        
                    </td>
                    <td width="100">
                      
                      <form:input path="idNum" maxlength="15"/>
                        
                    </td>
                    <td width="200">
                         <form:errors path="idNum" /> 
                    </td>
                </tr>
                
                 <tr>
                    <td width="110">
                        <form:label path="passportNum" cssErrorClass="error">
                            Passport Num
                        </form:label>                        
                    </td>
                    <td width="100">
                      
                      <form:input path="passportNum" maxlength="20"/>
                        
                    </td>
                    <td width="200">
                         <form:errors path="passportNum" /> 
                    </td>
                </tr>
                
                 <tr>
                    <td width="110">
                        <form:label path="email" cssErrorClass="error">
                            <spring:message code="employee.email"/>
                        </form:label>                        
                    </td>
                    <td width="100">
                      
                      <form:input path="email" maxlength="30"/>
                        
                    </td>
                    <td width="200">
                         <form:errors path="email" /> 
                    </td>
                </tr>
                
                <tr>
                    <td width="110">
                        <form:label path="address" cssErrorClass="error">
                            Address
                        </form:label>                        
                    </td>
                    <td width="100">
                      
                      <form:input path="address" maxlength="100"/>
                        
                    </td>
                    <td width="200">
                         <form:errors path="address" /> 
                    </td>
                </tr>
                
                <tr>
                    <td width="110">
                        <form:label path="mobile"  cssErrorClass="error">
                            Mobile
                        </form:label>                        
                    </td>
                    <td width="100">
                      
                      <form:input path="mobile" maxlength="10" cssClass="digit" />
                        
                    </td>
                    <td width="200">
                         <form:errors path="mobile" /> 
                    </td>
                </tr>
                
                <tr>
                    <td width="110">
                        <form:label path="telephoneNum" cssErrorClass="error">
                            Telephone Num
                        </form:label>                        
                    </td>
                    <td width="100">
                      
                      <form:input path="telephoneNum" maxlength="10" cssClass="digit" />
                        
                    </td>
                    <td width="200">
                         <form:errors path="telephoneNum" /> 
                    </td>
                </tr>
                
                <tr>
                    <td width="110">
                        <form:label path="password" cssErrorClass="error">
                            Password
                        </form:label>                        
                    </td>
                    <td width="100">
                      
                      <form:input path="password" maxlength="16" size="16"/>
                        
                    </td>
                    <td width="200">
                         <form:errors path="password" /> 
                    </td>
                </tr>
                
                <tr>
                    <td width="110">
                        <form:label path="status" cssErrorClass="error">
                             Status
                        </form:label>                        
                    </td>
                   
                      
                      <td width="100">
                          <form:select items="${CODES['EmployeeStatusCd']}"  
                          itemLabel="codeName" itemValue="codeValue" path="status" />
                    </td>
                    
                     <td width="100">
                            <form:errors path="Status" /> 
                    </td>
                    
                </tr>
                <!--  
                <tr>
                    <td width="110">
                        <form:label path="employeeType" cssErrorClass="error">
                            Employee Type
                        </form:label>                        
                    </td>
                    <td width="100">
                      
                      <form:select items="${CODES['EmployeeTypeCd']}"  id="employeeType"
                          itemLabel="codeName" itemValue="codeValue" path="employeeType" />
                        
                    </td>
                    <td width="200">
                         <form:errors path="employeeType" /> 
                    </td>
                </tr>-->
                
                <tr>
                    <td width="110">
                        <form:label path="employeeType" cssErrorClass="error">
                            Employee Type
                        </form:label>                        
                    </td>
                    <td width="100">
                      
                      <form:select id="employeeType" onchange="queryManagers()" path="employeeType">
                          <form:option value="-" label="Choose"/>
                          <form:option value="1" label="Staff"/>
                          <form:option value="2" label="Managers"/>
                          <form:option value="3" label="Admin"/>
                         <option />
                      </form:select>
                      
                     
                    </td>
                    <td width="200">
                         <form:errors path="employeeType" /> 
                    </td>
                </tr>
                
                
                 <tr id="managerRow">
                    <td width="110">
                        <form:label path="managerId" cssErrorClass="error">
                             Superior
                        </form:label>                        
                    </td>
                    
                    <td width="100">
                        <form:select   id="managerId" path="managerId"></form:select>
                           
                    </td>
                    <td width="200" id="message">
                         
                    </td>
                </tr>
                
                <tr>
                    <td colspan="2">
                            <input type="submit" value="add" class="frm_btn" onclick="return validateManager()"/>
                            <input type="button" value="back to list" class="frm_btn" onclick="toPage('<c:url value="/business/employee/displayEmployeeList"/>')"/>
                            
                    </td>
                </tr>
            </table>
        </form:form>
    </div>

    <DIV><B>${message}</B></DIV>
    
  </body>
  <script language=javascript>
     function validateManager(){
        var employeeTypeCd = document.getElementById("employeeTypeCd").value;
        alert(employeeTypeCd + "sdf");
        if(employeeTypeCd == '1'){//1-staff
        	 var managerId = document.getElementById("managerId").value;
             if(managerId == null || managerId == ''){
            	 alert("staff should choose manager");
            	 return false;
             }
        }
        return true;
     }
$("#managerRow").css("display","none");

$(function() {
	var $employeeType =  $("#employeeType");
	
	if($employeeType.length > 0){
		//alert("xxxxxxxxxxxxx");
		$employeeType.on( "change",function(){ //register the change callback function
			if($(this).val() == "1"){
				$("#managerRow").css("display",""); //display the managerRow
				var promise = $.getJSON("http://localhost:8080/laps/business/employee/queryManagers",{"xxx":"ohshit"});
				
				promise.done(function(data) {
					for(var property in data){
						console.info("property-->" + property +" , type->" + (typeof data[property]));
						var field = data[property];
						if($.isArray(field)){
							$.each(field, function (index, value) {
						        $("<option>").prop("value",value.employeeId)
						                     .prop("text",value.employeeName)
						                     .appendTo($("#managerId"));
						    });
						}
					}
				});
				
				
				promise.fail(function(data) {
					var responseJson = data.responseJSON;
					for(var p in responseJson){
						console.info("p--->" + p + ", value-->" + responseJson[p]);
						if(p == "message"){
							$("#message").text(responseJson[p]);
							break;
						}
					}
				});
				
				promise.always(function(data) {
					console.info("request finished");
				});
				
			}else{
				$("#managerId").empty();
				$("#managerRow").css("display","none");
			}
			
      });
	}
});    
     function queryManagers(){
    	
     }
   </script>
</html>

