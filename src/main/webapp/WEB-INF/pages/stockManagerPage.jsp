
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 22.11.2019
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Менеджер склада</title>
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
<div><a href="/product">Товары</a></div>
<div><a href="/incoming">Приходные накладные</a></div>
<div><a href="/stock">Журналы состояния склада</a></div>
</div>
</body>
</html>