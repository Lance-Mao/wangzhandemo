<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 17-5-13
  Time: 下午1:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息显示</title>
</head>
<body>
<%
    String info = (String) request.getAttribute("info");
    out.print(info);
%>
</body>
</html>
