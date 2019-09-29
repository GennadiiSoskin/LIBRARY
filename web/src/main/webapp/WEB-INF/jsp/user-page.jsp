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
<p class="right"><a href="${pageContext.request.contextPath}/login-page"> Выйти </a></p>
<center><h1>Добро пожаловать!</h1></center>
<center><p>У нас вы можете забронировать книги и забрать их влюбое удобное для вас время</p></center>
<center>
    <fieldset class="fieldset">
        <center><p>Чтобы найти необходимую книгу , воспользуйтесь поиском </p></center>
        <legend>ПОИСК</legend>
        <form action="${pageContext.request.contextPath}/books" method="Get">
            <label>Название</label><input type="text" name="name">
            <br>
            <p><label>Количество книг на странице</label><select name="size" datatype="text">
                <option selected value="5">5</option>
                <option value="10">10</option>
                <option value="15">15</option>
            </select></p>
            <br>
            <input type="submit" value="НАЙТИ">
        </form>
        <input type="checkbox" id="box" class="hide"/>
        <label for="box"> Мои книги </label>
        <div>
            <table>
                <c:forEach items="${bookList}" var="book">
                    <tr>
                        <td>${book.id}</td>
                        <td>${book.name}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </fieldset>
</center>
</body>
</html>