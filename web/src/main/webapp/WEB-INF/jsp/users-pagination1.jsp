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
</head>
<body>
currentPage = ${currentPage}
<br>
totalPagesCount = ${totalPagesCount}
<br>
itemsPerPage = ${itemsPerPage}
<br>
<table>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.login}</td>
        </tr>
    </c:forEach>

</table>
<br>
<c:forEach begin="0" end="${totalPagesCount - 1}" varStatus="loop">
    <a href="${pageContext.request.contextPath}/users?page=${loop.index}&size=${itemsPerPage}" >${loop.index + 1}</a>
</c:forEach>
</body>
</html>
