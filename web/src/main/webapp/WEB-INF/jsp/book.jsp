<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <%--    <link href="../css/style.css" rel="stylesheet">--%>
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
<center><h1>Добро пожаловать!</h1></center>
<center><p>У нас вы можете забронировать книги и забрать их влюбое удобное для вас время</p></center>
<br>
<center>
    <fieldset class="fieldset">
        <legend>${book.name}</legend>
        <table>
            <tr>
                <td>Артикул</td>
                <td>${book.id}</td>
            </tr>
            <tr>
                <td>Название</td>
                <td>${book.name}</td>
            </tr>
            <tr>
                <td>Количество страниц</td>
                <td>${book.volume}</td>
            </tr>
            <tr>
                <td>Жанр</td>
                <td>${genre.name}</td>
            </tr>
            <tr>
                <td>Библиотека</td>
                <td> № ${library.name} ${library.address.street} ${library.address.houseNumber}</td>

            </tr>
        </table>
    </fieldset>
</center>
</body>
</html>