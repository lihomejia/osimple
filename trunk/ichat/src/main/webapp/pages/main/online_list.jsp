<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK" import="com.ccic.chat.OnlineCounter" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Insert title here</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" href="<%=request.getContextPath()%>/include/css/dtree.css" type="text/css">
<script src="<%=request.getContextPath()%>/include/js/dtree.js"></script>
<script type='text/javascript' src='/ichat/dwr/interface/ChatManager.js'></script>
<script type='text/javascript' src='/ichat/dwr/engine.js'></script>
<script type='text/javascript' src='/ichat/dwr/util.js'></script>
</head>
<script language="javascript">
	function register() {
		//把我输入的用户名注册到服务器
		ChatManager.updateUsersList();
	}
		
	//页面初始化
	function init() {
		dwr.engine.setActiveReverseAjax(true); // 激活反转 重要
		register();
	}
	//回调函数
	//function cBack_list(data){
		//document.getElementById("online_list").insertAdjacentHTML("afterBegin","");
		//var str="aa"+data+">";
		//document.getElementById("online_list").insertAdjacentHTML("afterBegin",str);
    //}
	
</script>
<body onload="init();">
	在线用户列表(当前<%=OnlineCounter.getOnline() %>人):
		<ul id="users">
		</ul>
		<!--<div id="online_list">
			
		</div>
		-->
</body>
</html>