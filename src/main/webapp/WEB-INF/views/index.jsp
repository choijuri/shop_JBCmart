<%--
  Created by IntelliJ IDEA.
  User: Jeong
  Date: 2019-01-28
  Time: 오후 5:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:th="http://www.thymeleaf.org">
<html>
<head>
    <title>test</title>
</head>
<body>
<h1>test</h1>
<img src="/github.gif">
<br><br data-tomark-pass>s

<c:forEach items="${users}" var="user">
    name : ${user.name}, email : ${user.email}<br data-tomark-pass>
</c:forEach>
</body>
</html>
