<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>编辑消息内容</title>
</head>
<script type="text/javascript" src="<%=request.getContextPath() %>/fckeditor/fckeditor.js"></script>
<script type="text/javascript">
	//获取编辑器中HTML内容
	function getEditorHTMLContents(EditorName)
	{ 
	    var oEditor = FCKeditorAPI.GetInstance(EditorName); 
		//alert("--"+oEditor.GetXHTML(true));
	    var fckValue=document.getElementById("FckValue_DIV").innerHTML=oEditor.GetXHTML(true);
	    return ""; 
	}
</script>
  <body>
    <form method="post" name="frm1">
    <script type="text/javascript">
        var oFCKeditor = new FCKeditor("edt1");
        oFCKeditor.BasePath = "<%=request.getContextPath() %>/fckeditor/";
        oFCKeditor.ToolbarSet="";
        oFCKeditor.Height='400';
        oFCKeditor.Value="";
        oFCKeditor.Create();
    </script>
    <input type="button" value="提交" onclick="getEditorHTMLContents('edt1');">
    </form>
    <hr>
    <div id='FckValue_DIV'>
    </div>
  </body>
</html>