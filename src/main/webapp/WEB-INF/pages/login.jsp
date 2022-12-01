
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
.
<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 20.11.2019
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Вход</title>
    <link href="<c:url value="/res/log.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<div >
    <header>
        <div class = "title">
        </div>
    </header>
</div>
<div align="center">
    <img  src="/res/image.png" border="0" width="209" height="160" alt=""/>
</div>
<div class="sales1">
    <h2>Выберите пользователя</h2>
        <c:forEach items="${userList}" var="user">
            <tr>
                <div><td><a href="/password?id=${user.id}">Войти как ${user.r}</a></td></div>
            </tr>
        </c:forEach>
</div>
</body>
</html>