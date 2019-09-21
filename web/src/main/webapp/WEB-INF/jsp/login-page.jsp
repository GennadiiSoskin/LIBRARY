<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login page</title>
    <style type="text/css">
        body {
            margin: 0;
            background: #deb887;
        }

        label {
            float: left;
        }

        .fieldset {
            width: 350px;
        }

        .right {
            clear: both;
            text-align: right;
        }

        input {
            float: right;
            background: burlywood;

        }
    </style>
</head>
<body>
<center><h1>Добро пожаловать!</h1></center>
<center><p>У нас вы можете забронировать книги и забрать их влюбое удобное для вас время</p></center>
<center>
    <fieldset class="fieldset">
        <legend>ВХОД</legend>

        <form action="${pageContext.request.contextPath}/login-page" method="post">
            <label>Login:</label><input type="text" required name="username">
            <br>
            <label>Password:</label><input type="text" required minlength="4" maxlength="4" name="password">
            <br>
            <br>
            <br>
            <input type="submit" value="ВОЙТИ">
        </form>
    </fieldset>
</center>
<br>
<center><p>Если вы уже зарегистрированы, то пройдите по ссылке для
    <a href="${pageContext.request.contextPath}/registration-page"> РЕГИСТРАЦИИ .</a></p></center>
</body>
</html>