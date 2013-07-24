<%@ page language="java" pageEncoding="UTF-8"%>
<%@include  file="/core/taglibs.jsp"%>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>文件上传</title>
  </head>
  <body>
   <form method="post" action="<%=basePath%>test/upload/uploadFile" enctype="multipart/form-data">
		<input type="file" name="file" />
		<input type="submit"  value="upload"/>
		
		
		<br/>
		<c:if test="${fileName != null}">
			上传的文件为：${fileName}
		</c:if>
	</form>
   
  </body>
</html>
