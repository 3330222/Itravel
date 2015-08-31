<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Login</title>
</head>
<body>
	<form method="POST" action="<c:url value="/j_spring_security_check" />">
		<table>
			<tr>
				<td align="right">帐号</td>
				<td><input type="text" name="j_username" /></td>
			</tr>
			<tr>
				<td align="right">密码</td>
				<td><input type="password" name="j_password" /></td>
			</tr>
			<tr>
				<td align="right">记住我</td>
				<td><input type="checkbox" name="_spring_security_remember_me"
					value="yes" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
				    <input type="submit" value="登录" />
					<input type="reset" value="重置" />
			    </td>
			</tr>
		</table>
	</form>
</body>
</html>