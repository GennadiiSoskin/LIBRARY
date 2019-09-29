
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="POST" action="user" modelAttribute="userDto">
    <form:label path="firstName">First Name</form:label>
    <form:input path="firstName"/>
    <form:label path="secondName">Second Name</form:label>
    <form:input path="secondName"/>
    <form:label path="age">Age</form:label>
    <form:input path="age"/>
    <form:label path="number">Number</form:label>
    <form:input path="number"/>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
