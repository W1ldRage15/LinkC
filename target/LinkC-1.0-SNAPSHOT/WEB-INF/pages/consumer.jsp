<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 19.11.2019
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Потребители </title>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<div >
    <header>
        <div class = "title">
            <div class="right"><a href="/" >Выйти</a></div>
            <div class="left"><a href="/managerPage">Главная страница</a></div>
        </div>
    </header>
</div>

<div align="center">
    <a href="/bySort2">Отсортировать по имени</a>
    <h2>Потребители</h2>
    <c:if test="${!empty consumerList}">
        <table>
            <tr>
                <th>ID</th>
                <th>ФИО</th>
                <th>Номер телефона</th>
                <th>Адрес</th>
                <th colspan="2">Action</th>

            </tr>
            <c:forEach items="${consumerList}" var="consumer">
                <tr>
                    <td>${consumer.id}</td>
                    <td>${consumer.name}</td>
                    <td>${consumer.phone}</td>
                    <td>${consumer.address}</td>
                    <td> <button onclick="location.href='/deleteConsumer?id=${consumer.id}'">delete</button></td>
                    <td> <button onclick="location.href='/editConsumer?id=${consumer.id}'">edit</button></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <p></p>
    <a href="/addConsumer">Добавить</a>
</div>
</body>
</html>