
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 23.11.2019
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Менеджер</title>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<div>
    <header>
        <div class="title">
            <div class="right"><a href="/">Выйти</a></div>
        </div>
    </header>
</div>
<div align="center">
    <img  src="/res/image.png" border="0" width="209" height="160" alt=""/>
</div>
<div class="sales1">
    <div><a href="/earnings">Транспортные наладные</a></div>
    <div><a href="/bill">Счета</a></div>
    <div><a href="/transport">Отчеты о прибыли</a></div>
</div>
</body>
</html>