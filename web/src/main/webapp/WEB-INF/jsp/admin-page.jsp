<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin page</title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <style type="text/css">
        body {

            margin: 0;
            background: #deb887;
        }

        label {
            float: left;
        }

        .right {
            clear: both;
            text-align: right;
        }

        input {
            float: right;
            background: burlywood;
        }

        .hide + label ~ div {
            display: none;
        }

        .hide + label {
            padding: 0;
            color: black;
            cursor: pointer;
            display: inline-block;
        }

        .hide:checked + label {
            color: black;
            border-bottom: 0;
        }

        .hide:checked + label + div {
            display: block;
            background: burlywood;
            padding: 10px;
        }
    </style>
</head>
<body>
<p class="right">Пользователь: ${userName}</p>
<p class="right"><a href="${pageContext.request.contextPath}/login-page"> Выйти </a></p>
<center><h1>Добро пожаловать ${userName}!</h1>
    <table>
        <tr>
            <td><a href="${pageContext.request.contextPath}/users">Показать всех Пользователей </a></td>
        </tr>
        <tr>
            <td><a href="${pageContext.request.contextPath}/user-page"> Взять книгу </a></td>
        </tr>
        <tr>
            <td><a href="${pageContext.request.contextPath}/login-page"> Выйти </a></td>
        </tr>

    </table>
</center>
</body>
</html>