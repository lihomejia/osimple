<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<script type="text/javascript" src="<%=request.getContextPath() %>/fckeditor/fckeditor.js"></script>
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
	var msg = getEditorHTMLContents('edt1'); // 获得消息内容
	ChatManager.send(sender, msg); // 发送消息
	SetEditorContents('edt1','');//清空编辑器中发送的消息
}
//获取编辑器中HTML内容
function getEditorHTMLContents(EditorName)
{ 
    var oEditor = FCKeditorAPI.GetInstance(EditorName);
    return oEditor.GetXHTML(true); 
}
//设置编辑器中内容
function SetEditorContents(EditorName, ContentStr)
{ 
    var oEditor = FCKeditorAPI.GetInstance(EditorName) ; 
    oEditor.SetHTML(ContentStr) ; 
}

</script>
</head>
<body style="margin: 0px;">
<form method="post" name="frm1">
    <script type="text/javascript">
        var oFCKeditor = new FCKeditor("edt1");
        oFCKeditor.BasePath = "<%=request.getContextPath() %>/fckeditor/";
        oFCKeditor.ToolbarSet="ichat";
        oFCKeditor.Height='160';
        oFCKeditor.Value="";
        oFCKeditor.Create();
    </script>
    <input type="button" value="发  送" onclick="send();">
</form>
</body>
</html>