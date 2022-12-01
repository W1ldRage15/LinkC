<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 20.11.2019
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Производители </title>
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
    <a href="/bySort1">Отсортировать по имени</a>
    <h2>Производители</h2>
    <c:if test="${!empty producerList}">
        <table>
            <tr>
                <th>ID</th>
                <th>ФИО</th>
                <th>Номер телефона</th>
                <th>Адрес</th>
                <th colspan="2">Action</th>

            </tr>
            <c:forEach items="${producerList}" var="producer">
                <tr>
                    <td>${producer.id}</td>
                    <td>${producer.name}</td>
                    <td>${producer.phone}</td>
                    <td>${producer.address}</td>
                    <td> <button onclick="location.href='/deleteProducer?id=${producer.id}'">delete</button></td>
                    <td> <button onclick="location.href='/editProducer?id=${producer.id}'">edit</button></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <p></p>
    <a href="/addProducer">Добавить</a>
</div>
</body>
</html>