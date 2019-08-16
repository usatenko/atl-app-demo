<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<c:choose><c:when test="${!empty users}">
    <ul>
        <c:forEach var="user" items="${users}">
            <li>id: ${user.id}, name: ${user.name}</li>
        </c:forEach>
    </ul>
</c:when><c:otherwise>
    No users
</c:otherwise></c:choose>


</body>
</html>
