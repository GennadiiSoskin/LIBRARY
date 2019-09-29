<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users</title>
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


        input {
            float: right;
            background: burlywood;
        }

        table {
            width: 340px; /* Ширина таблицы */
            border-collapse: collapse; /* Убираем двойные линии между ячейками */
        }

        td, th {
            padding: 3px; /* Поля вокруг содержимого таблицы */
            border: 1px solid black; /* Параметры рамки */
        }

        .right {
            clear: both;
            text-align: right;
        }
    </style>
</head>
<body>
<p class="right">Пользователь: ${userName}</p>
<p class="right"><a href="${pageContext.request.contextPath}/admin-page"> Личный кабинет </a></p>
<p class="right"><a href="${pageContext.request.contextPath}/login-page"> Выйти </a></p>
<br>
<center>
    <fieldset class="fieldset">
        <legend>Результаты поиска</legend>
        <table>
            <tr>
                <td>id</td>
                <td>login</td>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td><a href="${pageContext.request.contextPath}/user?userName=${user.name}">${user.name}</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <c:forEach begin="0" end="${totalPagesCount-1 }" varStatus="loop">
            <a href="${pageContext.request.contextPath}/users?page=${loop.index}"> ${loop.index + 1}</a>
        </c:forEach>
    </fieldset>
</center>
</body>
</html>
