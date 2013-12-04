<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html> 
<head> 
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
 <title>Insert title here</title> 
</head> 
<h1>Java Chat</h1>
<body onload="dwr.engine.setActiveReverseAjax(true);">
<script type='text/javascript' src='dwr/interface/DWRHelper.js'></script>
<script type='text/javascript' src='dwr/engine.js'></script>
<script type='text/javascript' src='dwr/util.js'></script>
<p>This is a very simple chat demo that uses reverse ajax to collect messages and server-side browser manipulation to update the pages with the results.</p>
<p>Your Name:<input id="username" type="text"/></p>
<p>Your Message: <input id="text" onkeypress="dwr.util.onReturn(event, sendMessage)" />
 <input type="button" value="Send" onclick="sendMessage()" />
</p>
<script type="text/javascript">
    function sendMessage() {
      //alert(dwr.util.getValue("text"));
      DWRHelper.addMessage(dwr.util.getValue("text"),document.getElementById("username").value);
    }
</script>
<hr />
<ul id="chatlog" style="list-style-type:none;">
</ul>
</body>
</html>
