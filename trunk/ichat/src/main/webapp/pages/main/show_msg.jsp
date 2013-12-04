<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<script type='text/javascript' src='/ichat/dwr/interface/ChatManager.js'></script>
<script type='text/javascript' src='/ichat/dwr/engine.js'></script>
<script type='text/javascript' src='/ichat/dwr/util.js'></script>
</head>
<script language="javascript"> 
		
	//页面初始化
	function init() {
		dwr.engine.setActiveReverseAjax(true); // 激活反转 重要
	}
	function callBack(data){
            DWRUtil.addRows("tbodyId", data, cellFunctions,{escapeHtml:false}); 
        }
    var cellFunctions = [
        function(item) { 
           return item.text;
        }
    ];
</script>
<body onload="init();">
	<table>
		<tbody id="tbodyId">
		</tbody>
	</table>
</body>
</html>