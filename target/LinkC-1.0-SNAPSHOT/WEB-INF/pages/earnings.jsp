<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 23.11.2019
  Time: 15:40
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
    <title>Транспортные накладные </title>
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
    <a href="/bySort4">Отсортировать по дате</a>
    <h2>Транспортные накладные</h2>
    <c:if test="${!empty earningsList}">
        <table>
            <tr>
                <th>ID</th>
                <th>Id товара</th>
                <th>Дата</th>
                <th>Количество</th>
                <th colspan="2">Action</th>

            </tr>
            <c:forEach items="${earningsList}" var="earnings">
                <tr>
                    <td>${earnings.id}</td>
                    <td>${earnings.productId.id}</td>
                    <td>${earnings.date}</td>
                    <td>${earnings.quantity}</td>
                    <td> <button onclick="location.href='/deleteEarnings?id=${earnings.id}'">delete</button></td>
                    <td> <button onclick="location.href='/editEarnings?id=${earnings.id}'">edit</button></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <p></p>
    <a href="/addEarnings">Добавить</a>
</div>
</body>
</html>