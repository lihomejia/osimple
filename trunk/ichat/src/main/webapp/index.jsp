<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<title>Insert title here</title>
<script language="javascript" type="text/javascript"> 
	function subm(){
		var uname=document.form1.username.value;
		var pwd=document.form1.password.value;
		if (uname == "") {
			alert("ÇëÊäÈëÓÃ»§ID");
			return;
		}
		
		window.location="<%=request.getContextPath() %>/pages/frames/ShowModel_Frames.jsp?uname="+uname+"&pwd="+pwd;  
	}
</script>
</head>

<body>
<form id="ff" name="form1">
<fieldset>
<legend>µÇÂ¼</legend>
	<table align="center">
		<tr>
			<td>username:</td>
			<td><input type="text" name="username"></td>
		</tr>
		<tr>
			<td>password:</td>
			<td><input type="text" name="password"></td>
		</tr>
		<tr align="center">
			<td colspan="2"><input type="button" name="sub" value="µÇÂ¼" onclick="subm();"><input type="reset" name="res" value="ÖØÖÃ"></td>
		</tr>
	</table>
</fieldset>
</form>
</body>
</html>