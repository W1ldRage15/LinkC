<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 21.11.2019
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Товары </title>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<div >
    <header>
        <div class = "title">
            <div class="right"><a href="/" >Выйти</a></div>
            <div class="left"><a href="/stockManagerPage">Главная страница</a></div>
        </div>
    </header>
</div>

<div align="center">
    <a href="/bySort">Отсортировать по цене</a>
    <h2>Товары</h2>
    <c:if test="${!empty productList}">
        <table>
            <tr>
                <th>ID</th>
                <th>Id производителя</th>
                <th>Название</th>
                <th>Количество</th>
                <th>Цена</th>
                <th>Цена с НДС</th>
                <th colspan="2">Action</th>

            </tr>
            <c:forEach items="${productList}" var="product">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.producerId.id}</td>
                    <td>${product.name}</td>
                    <td>${product.quantity}</td>
                    <td>${product.price}</td>
                    <td>${product.priceNDS}</td>
                    <td> <button onclick="location.href='/deleteProduct?id=${product.id}'">delete</button></td>
                    <td> <button onclick="location.href='/editProduct?id=${product.id}'">edit</button></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <p></p>
    <a href="/addProduct">Добавить</a>
</div>
</body>
</html>