<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 17-5-13
  Time: 下午1:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String info = (String) request.getAttribute("info");
    out.print(info);
%>
<form style="align-content: center" action="/RegServlet" method="post">
    username:<input type="text" name="username" style="align-content: center">
    password<input type="password" name="pwd" style="align-content: center">
    <input type="submit" value="注册" style="align-content: center">
</form>
</body>
</html>
