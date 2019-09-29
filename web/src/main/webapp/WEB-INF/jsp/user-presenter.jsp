<%--
  Created by IntelliJ IDEA.
  test.User: mnazarenka
  Date: 2019-07-13
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<jsp:useBean id="users" type="java.util.ArrayList<test.User>" scope="request"/>
<jsp:useBean id="user" class="test.User" scope="request"/>--%>
<%@ page isELIgnored="false" %>


<html>
<head>
    <title>User presenter</title>
</head>
<body>
<p>
<%--    <%= users.get(0).getFirstName()%>
    <%jsp:getProperty name="user" property="firstName" />--%>
</p>
<br>
<p>
  <%-- <%= user.getSecondName()%>--%>
</p>
<br>
<p>
    ${users[0].firstName}
</p>
<br>
<p>
    ${user.secondName}
</p>
<ul>
    <c:forEach var="user" items="${users}">
        <p>${user.firstName} ${user.secondName}</p>
    </c:forEach>
</ul>
</body>
</body>
</body>
</html>
