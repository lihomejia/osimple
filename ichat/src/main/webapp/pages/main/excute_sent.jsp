<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Insert title here</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<script type='text/javascript' src='/ichat/dwr/interface/ChatManager.js'></script>
<script type='text/javascript' src='/ichat/dwr/engine.js'></script>
<script type='text/javascript' src='/ichat/dwr/util.js'></script>
<script language="javascript">
	/**
 * 发送消息
 */
function send() {
	var sender = '<%=request.getSession().getAttribute("uname").toString() %>'; // 获得发送者名字
	//var receiver = dwr.util.getValue('receiver'); // 获得接受者id
	var msg = getEditorHTMLContents(); // 获得消息内容
	ChatManager.send(sender, msg); // 发送消息
	SetEditorContents('');//清空编辑器中发送的消息
}
//获取编辑器中HTML内容
function getEditorHTMLContents()
{ 
    return document.getElementById('msg').value;
}
//设置编辑器中内容
function SetEditorContents(ContentStr)
{ 
	document.getElementById('msg').value = ContentStr;
}

</script>
</head>
<body style="margin: 0px;">
<form method="post" name="frm1">
   	&nbsp;<textarea rows="5" style="width:95%" id="msg"></textarea>
   	<br/>
    &nbsp;<input type="button" value="发  送" onclick="send();">
</form>
</body>
</html>