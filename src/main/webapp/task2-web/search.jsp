<%--
  Created by IntelliJ IDEA.
  User: azatkali
  Date: 04/01/2021
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search page</title>
</head>
<body>
    <form method="post" action="<%=request.getContextPath()%>/search">
        <input type="text" name="textToSearch" placeholder="Input text...">
        <input type="submit" value="Search">
    </form>
</body>
</html>
