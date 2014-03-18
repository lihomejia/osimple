<%@ page language="java" pageEncoding="UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登陆</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
  
  <div style="color:red;"> ${loginErr}</div>
	<form action="LoginServlet" method="post" >
	<table>
		<tr>
		<td>用户名：</td>
		<td><input type="text" name="username"/></td></tr>
		<tr><td>密码：</td>
		<td><input type="password" name="password"/></td></tr>
		<tr><td></td><td ><input type="submit" value="登陆"/></td></tr>
	</table>
	</form>
	<br/>
	测试用户:aa/aa &nbsp; bb/bb &nbsp; cc/cc &nbsp; dd/dd &nbsp; ee/ee
  </body>
</html>
