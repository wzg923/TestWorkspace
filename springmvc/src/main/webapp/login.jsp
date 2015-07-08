<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>System Login</title>  
</head>  
<body>  
<form action="${dynamicURL}/login.do" method="post">  
<table>  
      <tr>         
        <td>       
          姓名: <input name="user.name">                   
         </td>  
      </tr>  
      <tr>         
        <td>  
   
           密码: <input name="user.password">        
        </td>   
      </tr>  
     
      <tr>  
        <td align="right">  
         <input type="submit" vlaue="保存"/>  
        </td>  
      </tr>  
    </table>  
</form>  
 
<%-- <a href="${pageContext.request.contextPath}/index.jsp">返回主页</a><br>  
<a href="${pageContext.request.contextPath}/user/userList.do">返回显示</a>  --%> 
</body>  

</html>
