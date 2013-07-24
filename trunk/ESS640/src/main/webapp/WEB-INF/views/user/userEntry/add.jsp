<%@ page language="java" pageEncoding="UTF-8"%>
<%@include  file="/core/taglibs.jsp"%>

<html>
  <head>
    <base href="<%=basePath%>">
    <title>添加界面</title>
  </head>
  
  <body>
  	<form id="form1" name="form1" action="<%=basePath%>user/userEntry/add" method="post">
	    <table>
	    	<tr>
	    		<td>用户ID：<input type="text" name="ssuserUserid"/></td>
	    	</tr>
	    	<tr>
	    		<td>用户名：<input type="text" name="ssuserUsername"/></td>
	    	</tr>
	    	<tr>
	    		<td>密&nbsp;码：<input type="text" name="ssuserPwd"/></td>
	    	</tr>
	    	<tr>
	    		<td><input type="submit" value="提交"/></td>
	    	</tr>
	    </table>
    </form>
  </body>
</html>
