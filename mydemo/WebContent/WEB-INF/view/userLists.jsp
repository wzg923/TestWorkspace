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
<title>用户列表</title>
</head>
<body>

<table>
	<c:forEach var="user" varStatus="status" items="${userList}">
					<tr  align="center"
						valign="middle">
						<td>${user.loginName }</td>
						<td>${user.password }</td>
						<td>${user.name }</td>
						<td><a	href="${path}/sysManage/user/findUserById.do?id=${user.id}">编辑</a>
						&nbsp;&nbsp;<a href="${path}/sysManage/user/deleteuser.do?id=${user.id }">删除</a></td>
					</tr>
	</c:forEach>
</table>				
</body>
</html>