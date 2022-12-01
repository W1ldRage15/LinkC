<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 20.11.2019
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Новый производитель</title>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<div align="center">
    <h2>Добавить</h2>
    <form:form method="post" action="/saveProducer" modelAttribute="producer">
        <table >
            <tr>
                <td>Название:</td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td>Номер телефона :</td>
                <td><form:input path="phone"/></td>
            </tr>
            <tr>
                <td>Адрес :</td>
                <td><form:input path="address"/></td>
            </tr>
            <tr>
                <td colspan="3"><input type="submit" value="Сохранить"></td>
            </tr>
        </table>
    </form:form></div>
</body>
</html>