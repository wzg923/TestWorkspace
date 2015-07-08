<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 

String dynUrl=(String)application.getAttribute("dynamicURL");
if(dynUrl == null)
	application.setAttribute("dynamicURL", request.getContextPath());
String staUrl=(String)application.getAttribute("staticURL");
if(staUrl == null)
	application.setAttribute("staticURL", request.getContextPath()+"/assets");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to index!</title>
</head>
<script type="text/javascript">
	window.location.href='${dynamicURL}/login.jsp';
	/**$(document).ready(function(){
	   	newWin = window.open("${dynamicURL}/security/loginInit.action","_blank","scrollbars=1,titlebar=0,screenX=0,screenY=0,resizable=1,outerHeight=0,outerWidth=0,status=0,left=0,top=0,width="+(screen.availWidth)+",height="+(screen.availHeight));
	   	if(newWin != null)
	   	{
	   		newWin.moveTo(-2,-2);
	   		newWin.resizeTo(screen.width,screen.height);
		   	window.opener = null;
		   	window.open('','_top');
		   	//关闭父窗口
		   	window.top.close();
	   	}	
	});**/
</script>
<body>
</body>
</html>