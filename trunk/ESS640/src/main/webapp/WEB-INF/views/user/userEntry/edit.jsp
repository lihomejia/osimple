<%@ page language="java" pageEncoding="UTF-8"%>
<%@include  file="/static/taglibs.jsp"%>

<!DOCTYPE HTML5>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>编辑页面</title>
  </head>
  
  <body>
  	<form id="form1" name="form1" action="user/userEntry/edit" method="post">
  		<input type="hidden" name="asuserUserid" value="${user.ssuserUserid}"/>
	    <table>
	    	<tr>
	    		<td>用户名：<input type="text" name="ssuserUsername" value="${user.ssuserUsername }"/></td>
	    	</tr>
	    	<tr>
	    		<td>密&nbsp;码：<input type="text" name="ssuserPwd" value="${user.ssuserPwd }"/></td>
	    	</tr>
	    	<tr>
	    		<td><input type="submit" value="提交"/></td>
	    	</tr>
	    </table>
    </form>
  </body>
</html>
