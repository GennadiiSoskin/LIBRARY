<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration page</title>
    <style type="text/css">
        body {
            margin: 0;
            background: #deb887 url(../img/wifi_PNG62230.png);
        }
        input {
            background: #deb887;
        }
    </style>
</head>
<body>
<center><h1>Добро пожаловать!</h1></center>
<center><p>У нас вы можете забронировать книги и забрать их влюбое удобное для вас время</p></center>
<form method="post" action="/registration-page" >
    <fieldset>
        <legend>РЕГИСТРАЦИЯ</legend>
        <label>Логин<input type="text" required placeholder="Заполните это поле"></label>
        <label>Пароль<input type="text" required placeholder="Заполните это поле"></label>
    </fieldset>

    <fieldset>
        <legend>Информация о пользователе</legend>
        <label>Номер пасспорта<input type="text" required placeholder="Заполните это поле"></label>
        <fieldset>
            <legend>Адрес</legend>
            <label>Улица<input type="text" required placeholder="Заполните это поле"></label>
            <label>Номер дома<input type="text" required placeholder="Заполните это поле"></label>
        </fieldset>
    </fieldset>

</form>

</body>
</html>