<%@ page language="java" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = path+"/";
%>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>主页</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath %>static/core/ext4.2.1/resources/css/ext-all.css" />
	<script type="text/javascript" src="<%=basePath %>static/core/ext4.2.1/ext-all.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=basePath %>static/css/bms.css" />
	<script type="text/javascript" src="<%=basePath%>static/core/js/base.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/js/framework/homepage/index.js"></script>
  </head>
  <body>
  	<div id="welcome" style="visibility: hidden;">
  		<img src="<%=basePath%>static/images/bg.jpg"/>
  	</div>
  </body>
</html>