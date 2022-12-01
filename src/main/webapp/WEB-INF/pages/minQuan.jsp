<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 25.11.2019
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Товар</title>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<div align="center">
    <h2>Меньше всего на складе</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Id производителя</th>
            <th>Название</th>
            <th>Количество</th>
            <th>Цена</th>
            <th>Цена с НДС</th>
        </tr>
        <tr>
            <td>${product.id}</td>
            <td>${product.producerId.id}</td>
            <td>${product.name}</td>
            <td>${product.quantity}</td>
            <td>${product.price}</td>
            <td>${product.priceNDS}</td>
        </tr>
    </table>
    <a href="/stock">Вернуться к журналу</a>
</div>
</body>
</html>