<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Регистрация</title>
    <link href="<c:url value="/css/authStyle.css"/>" rel="stylesheet"></head>
<body>
<div class="login">
    <h1>Регистрация</h1>
    <div class="message">${message}</div>
    <form method="post">
        <input type="text" name="first_name" placeholder="Имя">
        <input type="text" name="last_name" placeholder="Фамилия">
        <input type="text" name="login" placeholder="Почта">
        <input type="password" name="password" placeholder="Пароль">
        <input type="password" name="pas_check" placeholder="Повтор пароля">
        <input type="text" name="date" id="date" placeholder="Дата рождения" onfocus="(this.type='date')">
        <button type="submit" class="btn btn-primary btn-block btn-large">Зарегестрироваться</button>
    </form>
</div>
</body>
</html>

