<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User page</title>
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

        table {
            width: 340px; /* Ширина таблицы */
            border-collapse: collapse; /* Убираем двойные линии между ячейками */
        }

        td, th {
            padding: 3px; /* Поля вокруг содержимого таблицы */
            border: 1px solid black; /* Параметры рамки */
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
        <legend>${user.name}</legend>
        <table>
            <tr>
                <td>Id</td>
                <td>${user.id}</td>
            </tr>
            <tr>
                <td>Login</td>
                <td>${user.name}</td>
            </tr>
            <tr>
                <td>Address</td>
                <td>${user.address.street}, ${user.address.houseNumber} </td>
            </tr>
            <tr>
                <div>
                    <table>
                        <p>Список книг</p>
                        <c:forEach items="${bookList}" var="book">
                            <tr>
                                <td>${book.id} </td>
                                <td>${book.name} </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/replace?userName=${user.name}&bookId=${book.id}">Принять</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </tr>
<tr>
    <td><a href="${pageContext.request.contextPath}/users">Вернуться к списку пользователей </a></td>
</tr>
        </table>

</center>
</body>
</html>