<%@ page language="java" pageEncoding="UTF-8"%>
<%@include  file="/static/taglibs.jsp"%>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    This is my Homepage page. <br>
    
    <a href="<%=basePath%>user/userList/findList">User Demo</a><br/>
    <a href="<%=basePath%>user/userList/findList2">Ajax Request Demo</a><br/>
    <a href="<%=basePath%>test/upload">File UpLoad Demo</a><br/>
	<br/>
	<a href="<%=basePath%>framework/logout">Logout</a><br/>
	
	
	
	
  </body>
</html>
