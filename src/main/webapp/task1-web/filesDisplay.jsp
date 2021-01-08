<%--
  Created by IntelliJ IDEA.
  User: azatkali
  Date: 04/01/2021
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Display page</title>
</head>
<body>
    <div>
        <h1>Files list:</h1>
        <c:forEach var="file" items="${files}">
            <p><c:out value="${file.getName()}" /></p>
        </c:forEach>
        <a href="<%=request.getContextPath()%>/rename">Rename</a>
    </div>
</body>
</html>
