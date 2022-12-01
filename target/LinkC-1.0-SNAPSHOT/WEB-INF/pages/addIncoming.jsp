<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 22.11.2019
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Новая приходная накладная</title>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<div align="center">
    <h2>Добавить</h2>
    <form:form method="post" action="/saveIncoming" modelAttribute="incoming">
        <table >
            <td>Товар:</td>
            <td><form:select path="productId.id">
                <option value=-1>Выберите товар</option>
                <c:forEach items="${products}" var="product">
                    <option value="${product.id}">${product.name}</option>
                </c:forEach>
            </form:select></td>
            </tr>
            <tr>
                <td>Дата:</td>
                <td><form:input path="date"/></td>
            </tr>

            <tr>
                <td colspan="3"><input type="submit" value="Сохранить"></td>
            </tr>
        </table>
    </form:form></div>
</body>
</html>