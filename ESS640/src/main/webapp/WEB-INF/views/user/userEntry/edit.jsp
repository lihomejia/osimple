<%@ page language="java" pageEncoding="UTF-8"%>
<%@include  file="/core/taglibs.jsp"%>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>编辑页面</title>
  </head>
  
  <body>
  	<form id="form1" name="form1" action="<%=basePath%>user/userEntry/edit" method="post">
  		<input type="hidden" name="ssuserUserid" value="${user.ssuserUserid}"/>
  		<input type="hidden" name="ssuserUserid" value="111111"/>
  		<input type="hidden" name="ssuserUserid" value="22222"/>
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
