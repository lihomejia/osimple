<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<title>编辑消息内容</title>
</head>
<script type="text/javascript">
	function getEditorHTMLContents() {
		document.getElementById("FckValue_DIV").innerHTML = document.getElementById("msg").value;
	}
</script>
<body>
	<form method="post" name="frm1">
		&nbsp;<textarea rows="5" style="width:95%" id="msg"></textarea>
   		<br/>
		&nbsp;<input type="button" value="提交" onclick="getEditorHTMLContents();">
	</form>
	<hr>
	<div id='FckValue_DIV'></div>
</body>
</html>