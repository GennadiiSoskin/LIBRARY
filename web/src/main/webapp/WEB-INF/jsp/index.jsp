
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello page</title>
    <style type="text/css">
        body {
            margin: 0;
            background: #deb887 url(../img/book.jpg);
        }
    </style>
</head>
<body>
<center><h1>Добро пожаловать!</h1></center>
<center><p>У нас вы можете забронировать книги и забрать их влюбое удобное для вас время</p></center>
<center><p>Для продолжения работы вам необходимо
    <a href="${pageContext.request.contextPath}/registration-page">зарегистрироваться</a> или
    <a href="${pageContext.request.contextPath}/login-page">войти</a></p></center>

</body>
</html>
