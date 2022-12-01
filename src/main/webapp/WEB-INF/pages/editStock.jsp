<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 22.11.2019
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Изменить журнал состояния склада</title>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<div align="center">
    <h2>Изменить</h2>
    <form:form method="post" action="/saveStock" modelAttribute="stock">
        <table >
            <tr>
                <td>ID:</td>
                <td>${stock.id}
                    <form:hidden path="id"/>
                </td>
            </tr>
            <tr>
                <td>Дата:</td>
                <td><form:input path="date"/></td>
            </tr>
            <tr>
                <td>Количество товаров на складе:</td>
                <td><form:input path="quantity"/></td>
            </tr>
            <tr>
                <td colspan="3"><input type="submit" value="Сохранить"></td>
            </tr>
        </table>
    </form:form></div>
</body>
</html>