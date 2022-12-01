<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 22.11.2019
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Приходные накладные </title>
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
    <a href="/bySort5">Отсортировать по дате</a>
    <h2>Приходные накладные</h2>
    <c:if test="${!empty incomingList}">
        <table>
            <tr>
                <th>ID</th>
                <th>Id товара</th>
                <th>Дата</th>
                <th>Количество</th>
                <th colspan="2">Action</th>

            </tr>
            <c:forEach items="${incomingList}" var="incoming">
                <tr>
                    <td>${incoming.id}</td>
                    <td>${incoming.productId.id}</td>
                    <td>${incoming.date}</td>
                    <td>${incoming.quantity}</td>
                    <td><a href="/deleteIncoming?id=${incoming.id}">delete</a></td>
                    <td><a href="/editIncoming?id=${incoming.id}">edit</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <p></p>
    <a href="/addIncoming">Добавить</a>
</div>
</body>
</html>