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

        .input {
            float: right;
            background: burlywood;
            required: "true";
        }
    </style>
</head>
<body>
<center><h1>Добро пожаловать!</h1></center>
<center><p>У нас вы можете забронировать книги и забрать их влюбое удобное для вас время</p></center>
<center>
    <fieldset class="fieldset">
        <legend>ВХОД</legend>

        <form:form method="POST" modelAttribute="user">
            <form:label path="name" cssClass="right">Email</form:label>
            <form:input path="name" required="true" cssClass="input"/>
            <br>
            <br>
            <form:label path="password" cssClass="right">Password</form:label>
            <form:input path="password" required="true" maxlength="4" minlength="4" type="password" cssClass="input"/>
            <br>
            <br>
            <br>
            <input class="input" type="submit" value=" Войти ">
        </form:form>
    </fieldset>
</center>
<br>
<center><p>Если вы уже зарегистрированы, то пройдите по ссылке для
    <a href="${pageContext.request.contextPath}/registration-page"> РЕГИСТРАЦИИ .</a></p></center>
</body>
</html>