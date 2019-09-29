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
            width: 500px;
        }

        input {
            float: right;
            background: burlywood;
        }

        .right {
            clear: both;
            text-align: right;
        }

        table {
            width: 480px;
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
    <fieldset class="fieldset">
        <legend>Результаты поиска</legend>
        <table>
            <tr>
                <td>Артикул</td>
                <td>Название</td>
                <td>Наличие</td>
            </tr>
            <c:forEach items="${books}" var="book">
                <tr>
                    <td>${book.id}</td>
                    <td><a href="${pageContext.request.contextPath}/book?bookId=${book.id}">
                            ${book.name}</a></td>
                    <td>
                        <c:if test="${book.user!=null}">
                            <p> Нет в наличии </p>
                        </c:if>
                        <c:if test="${book.user==null}">
                            <p> В наличии</p>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <c:forEach begin="0" end="${totalPagesCount-1 }" varStatus="loop">
            <a href="${pageContext.request.contextPath}/books?page=${loop.index}&name=${name}&size=${itemsPerPage}">
                    ${loop.index + 1}</a>
        </c:forEach>
    </fieldset>
</center>
</body>
</html>
