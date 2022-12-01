<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 24.11.2019
  Time: 21:40
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
    <title>Отчет о прибыли</title>
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
    <h2>Общая прибыль:${total}</h2>
    <a href="/bySort7">Отсортировать по дате</a>
    <h3>Отчет о прибыли</h3>
    <c:if test="${!empty transportList}">
        <table>
            <tr>
                <th>ID</th>
                <th>Дата</th>
                <th>Сумма</th>
                <th>Сумма с НДС</th>
                <th colspan="2">Action</th>

            </tr>
            <c:forEach items="${transportList}" var="transport">
                <tr>
                    <td>${transport.id}</td>
                    <td>${transport.date}</td>
                    <td>${transport.total}</td>
                    <td>${transport.totalNDS}</td>
                    <td> <button onclick="location.href='/deleteTransport?id=${transport.id}'">delete</button></td>
                    <td> <button onclick="location.href='/editTransport?id=${transport.id}'">edit</button></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <p></p>
    <a href="/addTransport">Добавить</a>
</div>
</body>
</html>