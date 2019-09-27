<j
<%--
  Created by IntelliJ IDEA.
  User: mnazarenka
  Date: 2019-09-02
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
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

        <legend>Результаты поиска</legend>
        <table>
            <tr>
                <td>Артикул</td>
                <td>Название</td>
            </tr>

            <c:forEach items="${books}" var="book">
                <tr>
                    <td>${book.id}</td>
                    <td><a href="${pageContext.request.contextPath}/book?bookId=${book.id}">${book.name}</a></td>
                </tr>
            </c:forEach>

        </table>
        <br>
        <c:forEach begin="0" end="${totalPagesCount-1 }" varStatus="loop">
            <a href="${pageContext.request.contextPath}/users-pagination?page=${loop.index}&name=${name}&size=${itemsPerPage}&library=${library}&genre=${genre}"> ${loop.index + 1}</a>
        </c:forEach>

    </fieldset>
</center>

</body>
</html>
