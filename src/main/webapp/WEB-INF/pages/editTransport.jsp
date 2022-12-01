<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 24.11.2019
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Отчет о прибыли</title>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<div align="center">
    <h2>Добавить</h2>
    <form:form method="post" action="/saveTransport" modelAttribute="transport">
        <table >
            <tr>
                <td>ID:</td>
                <td>${transport.id}
                    <form:hidden path="id"/>
                </td>
            </tr>
            <tr>
                <td>Дата:</td>
                <td><form:input path="date"/></td>
            </tr>
            <tr>
                <td>Прибыль:</td>
                <td><form:input path="total"/></td>
            </tr>
            <tr>
                <td colspan="3"><input type="submit" value="Сохранить"></td>
            </tr>
        </table>
    </form:form></div>
</body>
</html>