<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/share/tagLibs.jsp" %>
<div class="row user-register">
 <div class="col-md-1"></div>
  <div class="col-md-6"style="padding-right:2em;">
     <div class="user_content">
         <form:form id="form" method="post" action="/user/register/hostel"  commandName="vo" >
           
            <table style="border-collapse: separate; border-spacing: 0 2em;">
            
                <tr>
                    <td width="90">帐号 </td>
                    <td width="100">
                        <form:input id="account" path="account" 
	                        maxlength="10" />
                    </td>
                    <td>
                      
                      <label id="accountMessage"  class="check">
	                                 <form:errors path="account"></form:errors>
	                   </label>
	                   
                    </td>
                </tr>
                <tr>
                    <td width="90">密码 </td>
                    <td width="100"><form:input type="password" id="password" path="password" maxlength="16" required="required"/>
                    <td><label id="passwordMessage" class="check">
                        <form:errors path="password"></form:errors>
                    </label></td>
                </tr>
                
                <tr>
                    <td width="90">确认 </td>
                    <td width="100"><form:input type="password" id="confirmPassword" path="confirmedPassword" maxlength="16"  />
                     <td><label id="confirmMessage" class="check">
                         <form:errors path="confirmedPassword"></form:errors>
                         </label>
                     </td>
                </tr>
                
                <tr>
                    <td width="90">工商注册号 </td>
                    <td width="100"><form:input  id="registerNum" path="registerNum" maxlength="30" />
                     <td><label id="registerNumMessage" class="check">
                         <form:errors path="registerNum"></form:errors>
                        </label>
                     </td>
                </tr>
                
                <tr>
                    <td width="90">邮箱 </td>
                    <td width="100">
                        <form:input id="email" path="email" type="email" maxlength="50"  placeholder="address@travel.com"/>
                    </td>
                    <td><label id="emailMessage" class="check">
                        <form:errors path="email"></form:errors>
                    </label></td>
                </tr>
               
                <tr>
                    <td colspan="2" align="center"> 
                        <input id="submit" type="submit"  onclick="return validateForm();"
                        class="button button-rounded button-raised button-primary" value="注册" />
                    </td>
                </tr>
            </table>
        </form:form>
        </div>
    </div>
    <div class="col-md-3"></div>
 </div>
       

<script type="text/javascript">
<!--
$(function(){
	var $submit =  $("#submit");
	//验证帐号
	$("#account").on("focusout",function(){
		validateAccount();
	});
	
	$("#account").on("focus",function(){
	    $("#accountMessage").text("");
	});
	
	//验证密码
	$("#password").on("focusout",function(){
		validatePassword();
	});
	
	$("#password").on("focus",function(){
		$("#passwordMessage").text("");
	});
	
	
	$("#confirmPassword").on("focusout",function(){
		console.log("1111");
		validateConfirmedPassword();
	});
	
	$("#confirmPassword").on("focus",function(){
		$("#confirmMessage").text("");
	});
	
	$("#email").on("focusout",function(){
		validateEmail();
	});
	
	$("#email").on("focus",function(){
		$("#emailMessage").text("");
	});
	
	$("#registerNum").on("focusout",function(){
		validateRegisterNum();
	});
	
	$("#registerNum").on("focus",function(){
		$("#registerNumMessage").text("");
	});
});

function validatePassword(){
	return validateConfirmedPassword();
}

function validateConfirmedPassword(){
	$passwordText = $("#password").val();
	var $confirmMessage = $("#confirmMessage");
	$confirmedPasswordText =  $("#confirmPassword").val();
	
	
	if($passwordText == null){
		$("#passwordMessage").text("密码不能为空");
		return false;
	}else if($passwordText.length<6){
		$("#passwordMessage").text("密码不能少于6位");
		return false
	}else if($passwordText != $confirmedPasswordText){
		$confirmMessage.text("密码不一致");
		return false;
	}else if($passwordText == $confirmedPasswordText){
		
	}
	return true;
}


function validateEmail(){
	if($("#email").val()==null || $("#email").val().trim().length == 0){
		$("#emailMessage").text("邮箱不能为空");
    	return false;
	}
	
	var re = /^(([^<>()[\]\.,;:\s@\"]+(\.[^<>()[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;
    if(!re.test($("#email").val())){
    	
    	$("#emailMessage").text("邮箱无效");
    	return false;
    }
    return true;
}

var result = false;
function validateAccount(){
	
	var $accountText =  $("#account").val();
	if($accountText == null || $accountText.trim()==""){
		$("#accountMessage").text("帐号不能为空");
		return false;
	}
	$.when(aynchQueryAccount())
	        .done(function() {
	     });
	
	return result;
}

function aynchQueryAccount(){
	var $accountText =  $("#account").val();
	if($accountText.length > 0){
		var promise = $.getJSON("/user/rest/query/"+$accountText);
		promise.done(function(data) {
			$("#accountMessage").text("帐号可用");
			result = true;
		});
		promise.fail(function(data) {
			result = false;
			$("#accountMessage").text("帐号不可用");
		});
    }
	return result;
}

function validateRegisterNum(){
	$registerNumText = $("#registerNum").val();
	if($registerNumText == null || $registerNumText.trim().length == 0){
		$("#registerNumMessage").text("工商注册号不能为空");
		return false;
	}
	return true;
}

function validateForm(){
	return validateAccount()&&validateConfirmedPassword()&&validateEmail()&&validateRegisterNum();
}
//-->
</script>

