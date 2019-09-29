<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<body>
<h2>
    <fmt:message key="label.welcome" />
</h2>
<div>
    <span><fmt:message key="label.content" /></span>
</div>
<div>
    <fmt:message key="label.changeLang" />
</div>
<ul>
    <li><a href="?lang=en_US"><fmt:message key="label.lang.en" /></a></li>
    <li><a href="?lang=ru_RU"><fmt:message key="label.lang.ru" /></a></li>
</ul>
</body>
</html>
