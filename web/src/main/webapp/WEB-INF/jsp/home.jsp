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
    <title>Hello page</title>
</head>
<body>
<p>Hello page</p>
<a href="${pageContext.request.contextPath}/registration">registration</a>
<br>
<a href="${pageContext.request.contextPath}/login">login</a>
<br>
<a href="${pageContext.request.contextPath}/admin/page">admin page</a>
<br>
<a href="${pageContext.request.contextPath}/user/page">user page</a>
</body>
</html>
