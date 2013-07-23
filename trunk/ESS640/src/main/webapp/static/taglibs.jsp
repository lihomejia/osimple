<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String path = request.getContextPath();
String basePath = path+"/";
%>
<!DOCTYPE HTML>
<script type="text/javascript">
	window.basePath = '<%=basePath%>';
</script>