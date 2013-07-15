<%@ page language="java" pageEncoding="UTF-8"%>

<%@ include file="/static/core/jsp/base.jsp" %>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>主页</title>
	<%@ include file="/static/core/jsp/ext.jsp" %>
	<link rel="stylesheet" type="text/css" href="<%=basePath %>static/css/bms.css" />
	<script type="text/javascript" src="<%=basePath%>static/js/framework/homepage/index.js"></script>
  </head>
  <body>
  	<div id="welcome" style="visibility: hidden;">
  		<img src="<%=basePath%>static/images/bg.jpg"/>
  	</div>
  </body>
</html>