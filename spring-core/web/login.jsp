<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="include/common.jsp"%>
<html>
<head>
    <title></title>
</head>
<body>
<form action="${ctx}/admin/login" method="post">
    用户名：<input type="text" name="name"/><br>
    密  码：<input type="passwrd" name="password"><br>
    <button type="submit" >提交</button>
</form>
</body>
</html>
