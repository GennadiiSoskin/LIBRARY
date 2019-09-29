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
            width: 340px;
            border-collapse: collapse;
        }

        td, th {
            padding: 3px;
            border: 1px solid black;
        }
    </style>
</head>
<body>
<p class="right">Пользователь: ${userName}</p>
<p class="right"><a href="${pageContext.request.contextPath}/user-page"> Личный кабинет </a></p>
<p class="right"><a href="${pageContext.request.contextPath}/login-page"> Выйти </a></p>
<center><h1>Добро пожаловать!</h1></center>
<center><p>У нас вы можете забронировать книги и забрать их влюбое удобное для вас время</p></center>
<br>
<center>
    <form action="${pageContext.request.contextPath}/book?bookId=${book.id}&path=${path}" method="post">
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
            <c:if test="${message!=null}">
                <input type="submit" value=${message.toString()}>

            </c:if>

            <c:if test="${message==null}">
                <p> Нет в наличии</p>
            </c:if>
        </fieldset>
    </form>

</center>
</body>
</html>