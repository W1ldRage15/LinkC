<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 23.11.2019
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Счета </title>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<div >
    <header>
        <div class = "title">
            <div class="right"><a href="/" >Выйти</a></div>
            <div class="left"><a href="/accountantPage">Главная страница</a></div>
        </div>
    </header>
</div>

<div align="center">
    <a href="/bySort3">Отсортировать по дате</a>
    <h2>Счета</h2>
    <c:if test="${!empty billList}">
        <table>
            <tr>
                <th>ID</th>
                <th>Id Товара</th>
                <th>Id Потребителя</th>
                <th>Дата</th>
                <th>Количество</th>
                <th>Сумма</th>
                <th>Сумма с ндс</th>
                <th colspan="2">Action</th>

            </tr>
            <c:forEach items="${billList}" var="bill">
                <tr>
                    <td>${bill.id}</td>
                    <td>${bill.productId.id}</td>
                    <td>${bill.consumerId.id}</td>
                    <td>${bill.date}</td>
                    <td>${bill.quantity}</td>
                    <td>${bill.total}</td>
                    <td>${bill.totalNDS}</td>
                    <td> <button onclick="location.href='/deleteBill?id=${bill.id}'">delete</button></td>
                    <td> <button onclick="location.href='/editBill?id=${bill.id}'">edit</button></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <p></p>
    <a href="/addBill">Добавить</a>
</div>
</body>
</html>