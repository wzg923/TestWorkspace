<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<% 
	response.setHeader("Pragma","No-cache");    
	response.setHeader("Cache-Control","no-cache");    
	response.setDateHeader("Expires", -10);
	response.setHeader( "Cache-Control","max-age=5"); 
	response.setHeader( "Cache-Control","Public"); 
	response.setHeader( "Pragma","no-cache"); 
	response.setDateHeader( "Expires",0); 
	String path = request.getContextPath()+"/";
	pageContext.setAttribute("path",path);	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看用户</title>
</head>
<body>
<form action="${path}/sysManage/user/updateUser.do" method="post">
<table>
	<tr>
		<td>用户ID：</td>
		<td><input type="text" name="id" value="${user.id }" readonly="readonly"></td>
	</tr>
	<tr>
		<td>姓名：</td>
		<td><input type="text" name="name" value="${user.name }"></td>
	</tr>
	<tr>
		<td>用户名：</td>
		<td><input type="text" name="loginName" value="${user.loginName }"></td>
	</tr>
	<tr>
		<td>密码：</td>
		<td><input type="text" name="password" value="${user.password }"></td>
	</tr>
	<tr>
		<td><input type="submit" value="确定"/></td>
	</tr>
</table>
</form>
</body>
</html>