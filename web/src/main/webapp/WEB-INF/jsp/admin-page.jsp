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

        .fieldset {
            width: 400px;
        }

        .right {
            clear: both;
            text-align: right;
        }

        input {
            float: right;
            background: burlywood;
        }

        .hide {
            display: none;
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
<center><h1>Добро пожаловать ${userName}!</h1>
    <table>
        <tr>
            <td><a href="${pageContext.request.contextPath}/users">Показать всех Пользователей </a></td>

        </tr>
        <tr>
            <td><a href="${pageContext.request.contextPath}/addbook">Добавить книгу в библиотеку </a></td>

        </tr>
    </table>


</center>
</body>
</html>