<%--
  Created by IntelliJ IDEA.
  User: mnazarenka
  Date: 2019-08-31
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login page</title>
</head>
<body>
<p>Login</p>
<br>

<form action="${pageContext.request.contextPath}/login" method="post">
    Login:<input type="text" name="username">
    Password:<input type="text" name="password">
    <input type="submit" value="Submit">
</form>
</body>
</html>
