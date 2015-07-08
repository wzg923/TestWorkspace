<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/asserts/jquery-easyui-1.3.3/jquery.easyui.min.js?v=20140429"></script>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/asserts/jquery-easyui-1.3.3/jquery.min.js"></script>
</head>
<body>
test page

<form name="form1" method="post" action="/rest/welcome">

<a href="javascript:void(0)" 
	class="easyui-linkbutton" 
	data-options="iconCls:'icon-back'" 
	onclick="doSubmit()">提交</a>

</form>
	
<script type="text/javascript">
function doSubmit(){
	var form = document.getElementById("form1");
	//form.action="${dynamicURL}/security/"+action+".action";
	form.submit();
}
</script>
</body>
</html>