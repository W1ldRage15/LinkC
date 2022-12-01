<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 22.11.2019
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Журналы состояния склада </title>
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
    <h2>Количество товаров на складе:${sum}</h2>
    <div><a href="/bySort6">Отсортировать по дате</a></div>
    <a href="/maxQuan">Больше всего на складе</a>
    <a href="/minQuan">Меньше всего на складе</a>
    <h3>Журналы состояния склада</h3>
    <c:if test="${!empty stockList}">
        <table>
            <tr>
                <th>ID</th>
                <th>Дата</th>
                <th>Количество товаров на складе</th>
                <th colspan="2">Action</th>

            </tr>
            <c:forEach items="${stockList}" var="stock">
                <tr>
                    <td>${stock.id}</td>
                    <td>${stock.date}</td>
                    <td>${stock.quantity}</td>
                    <td> <button onclick="location.href='/deleteStock?id=${stock.id}'">delete</button></td>
                    <td> <button onclick="location.href='/editStock?id=${stock.id}'">edit</button></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <p></p>
    <a href="/addStock">Добавить</a>
</div>
</body>
</html>