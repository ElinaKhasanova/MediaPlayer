<%@ tag description="Header Tag" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="title" required="true" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <link href="<c:url value="/css/main.css"/>" rel="stylesheet">
</head>
<body>

<header>
    <div id="head">
        <img src="/images/png.jpg" alt="Logo" width="80" height="60">
        <c:if test="${empty user}">
            <div id="buttons">
                <a href="/login">Вход</a>
                <a href="/registration">Регистрация</a>
            </div>
        </c:if>
        <c:if test="${not empty user}">
            <div id="buttons">
                <a href="/private">Личный кабинет</a>
                <a href="/logout">Выход</a>
            </div>
        </c:if>
    </div>
    <div id="nav">
        <ul class="menu">
            <li><a href="/main">Главная</a></li>
            <li><a href="/clubs">Клубы</a></li>
            <li><a href="/discount">Акции</a></li>
            <li><a href="/tickets">Абонемент</a></li>
            <li><a href="/services">Услуги</a></li>
            <li><a href="/timetable">Расписание</a></li>
        </ul>
    </div>
</header>