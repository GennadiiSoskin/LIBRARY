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
<center><h1>Добро пожаловать!</h1></center>
<center><p>У нас вы можете забронировать книги и забрать их влюбое удобное для вас время</p></center>
<center>
    <fieldset class="fieldset">
        <center><p>Чтобы найти необходимую книгу , воспользуйтесь поиском </p></center>
        <legend>ПОИСК</legend>
        <form action="${pageContext.request.contextPath}/users-pagination" method="Get">

            <label>Название</label><input type="text" name="name">
            <br>
            <br>
            <br>
            <p><label>Количество книг на странице</label><select name="size" datatype="text">
                <option selected value="5">5</option>
                <option value="10">10</option>
                <option value="15">15</option>
            </select></p>
            <input type="checkbox" id="box" class="hide"/>
            <label for="box"> Расширенный поиск </label>
            <div>
                <p><label>Жанр</label><select name="genre" >
                    <option selected value="">--</option>
                    <option value="5">История</option>
                    <option value="3">Для детей</option>
                    <option value="2">Детектив</option>
                    <option value="1">Фантастика</option>
                    <option value="4">Классика</option>
                </select></p>
                <p><label>Библиотека</label><select name="library">
                    <option selected value="">--</option>
                    <option value="1"> № 1</option>
                    <option value="2"> № 2</option>
                    <option value="3"> № 3</option>
                </select></p>
            </div>

            <br>
            <br>
            <input type="submit" value="НАЙТИ">
        </form>
    </fieldset>
</center>
</body>
</html>