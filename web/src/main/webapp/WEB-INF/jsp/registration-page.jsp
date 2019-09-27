<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--    <link rel="stylesheet" type="text/css" href="WEB-INF/css/style.css">--%>
    <meta charset="UTF-8">
    <title>Registration page</title>
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
        }
    </style>
</head>
<body>
<center><h1>Добро пожаловать!</h1></center>
<center><p>У нас вы можете забронировать книги и забрать их влюбое удобное для вас время</p></center>
<center>
    <fieldset class="fieldset">
        <legend>РЕГИСТРАЦИЯ</legend>
        <p>${mistake}</p>

        <form:form method="POST" modelAttribute="user" title="Регистрация">
            <form:label path="name" cssClass="right">Email</form:label>
            <form:input path="name" required="true" cssClass="input"/>
            <br>
            <form:label path="password" cssClass="right">Password</form:label>
            <form:input path="password" required="true" maxlength="4" minlength="4" type="password" cssClass="input"/>
            <br>
            <form:label path="address.street" cssClass="right"> Улица </form:label>
            <form:input path="address.street" required="true" cssClass="input"/>
            <br>
            <form:label path="address.houseNumber" cssClass="right"> Номер дома </form:label>
            <form:input path="address.houseNumber" required="true" cssClass="input"/>
            <%--   TODO         <form:label path="passportData" cssClass="right">Email</form:label>--%>
            <%--            <form:input path="passportData" cssClass="input"/>--%>
            <br>
            <br>
            <input class="input" type="submit" value=" Зарегистрироваться ">
        </form:form>
    </fieldset>
</center>
<br>
<center><p>Если вы уже зарегистрированы, то пройдите по ссылке для
    <a href="${pageContext.request.contextPath}/login-page"> ВХОДА .</a></p></center>
</body>
</html>