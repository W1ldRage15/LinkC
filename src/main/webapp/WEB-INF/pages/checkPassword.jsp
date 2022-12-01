<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 20.11.2019
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<div align="center">
    <h2>Введите пароль</h2>
    <form:form action="/checkPassword" method="post" modelAttribute="user">
        <table>
            <tr>
                <td>Имя:</td>
                <td>${user.username}
                    <form:hidden path="username"/>
                </td>
            </tr>
            <tr>
                <td>Пароль: </td>
                <td><form:input type="password" path="password"/></td>
            <tr>
                <td colspan="2"><input type="submit" value="Войти"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>