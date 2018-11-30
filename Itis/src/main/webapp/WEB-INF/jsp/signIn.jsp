<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" >

<head>
    <meta charset="UTF-8">
    <title>Вход в личный кабинет</title>
    <link href="<c:url value="/css/authStyle.css"/>" rel="stylesheet">
</head>

<body>

<div class="login">
    <h1>Вход в личный кабинет</h1>
    <form method="post">
        <input id="login" type="text" name="u" placeholder="Логин">
        <input id="password" type="password" name="p" placeholder="Пароль">
        <button type="submit" class="btn btn-primary btn-block btn-large">Войти</button>
    </form>
</div>

</body>

</html>


