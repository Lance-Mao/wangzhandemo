<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 17-5-13
  Time: 下午1:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<%
    String mes = (String) request.getAttribute("info");
    out.print(mes);
%>
<form style="align-content: center" action="${pageContext.request.contextPath}/login" method="post">
    username:<input type="text" name="username" style="align-content: center">
    password<input type="password" name="pwd" style="align-content: center">
    <input type="submit" value="登录" style="align-content: center">
</form>
</body>
</html>
