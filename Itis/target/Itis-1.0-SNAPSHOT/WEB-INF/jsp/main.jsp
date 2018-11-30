<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Главная страница</title>
    <link href="<c:url value="/css/main.css"/>" rel="stylesheet">
</head>
<body>

<header>
    <div id="head">
        <img src="/images/png.jpg" alt="Logo" class="img1">
        <c:if test="${empty user}">
            <div id="buttons">
                <a href="/login">Вход</a>
                <a href="/registration">Регистрация</a>
            </div>
        </c:if>
        <c:if test="${not empty user}">
            <div id="buttons">
                <a href="/private">Личный кабинет</a>
                <a href="/logout">Выйти</a>
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

    <div class="block"><h2>Уникальный тренажерный зал</h2>
        <p><img src="images/photo.jpg" class="img2" alt="Image" align="right" hspace="20">
            <br><br><br><br>Огромные тренажерные залы, наполненные премиальным оборудованием от ведущего производителя Life Fitness
            и Hammer Strength Select.<br><br><br><br>

            В наших тренажерных залах легко разобраться, даже если ты первый раз в клубе: у нас удобная навигация
            и зонирование пространства по группам мышц.</p>

        <div id="buttonMore">
            <a href="/clubs">Подробнее</a>
        </div>
    </div>
</header>

</body>
</html>
