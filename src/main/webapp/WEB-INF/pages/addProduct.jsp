<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 21.10.2019
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Новый клиент</title>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<div align="center">
    <h2>Добавить</h2>
    <form:form method="post" action="/saveProduct" modelAttribute="product">
        <table >
            <tr>
                <td>Id производителя:</td>
                <td><form:select path="producerId.id">
                    <option value=-1>Выберите производителя</option>
                    <c:forEach items="${producers}" var="producer">
                        <option value="${producer.id}">${producer.name}</option>
                    </c:forEach>
                </form:select></td>
            </tr>
            <tr>
                <td>Название:</td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td>Количество:</td>
                <td><form:input path="quantity"/></td>
            </tr>
            <tr>
                <td>Цена:</td>
                <td><form:input path="price"/></td>
            </tr>
            <tr>
                <td colspan="3"><input type="submit" value="Сохранить"></td>
            </tr>
        </table>
    </form:form></div>
</body>
</html>