<%--
  Created by IntelliJ IDEA.
  User: azatkali
  Date: 04/01/2021
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Result page</title>
</head>
<body>
    <h1>Result: </h1>
    <h1>Searched word: <c:out value="${searchedWord}" /></h1>
    <p>File 1 count: <c:out value="${file1}" /></p>
    <p>File 2 count: <c:out value="${file2}" /></p>
    <p>File 3 count: <c:out value="${file3}" /></p>
</body>
</html>
