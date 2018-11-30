<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
    <%--<style>--%>
        <%--#form{--%>
            <%--overflow: hidden;--%>
        <%--}--%>

    <%--</style>--%>
</head>
<body>
<form method="post" action="" id="form">
    <div>
        <label for="email" value="${email}">E-mail ${email_error}</label>
        <input type="text" name="email" id="email"><br><br>

        <label for="password">Пароль ${pass_error}</label>
        <input type="password" name="password" id="password"><br><br>

        <label for="password_rep">Повтор пароля ${pass_rep_error}</label>
        <input type="password" name="password_rep" id="password_rep"><br><br>

        <label for="country">Страна</label>
        <select name="country" id="country">
            <option value="Russia">Россия</option>
            <option value="Italy">Италия</option>
            <option value="Spain">Испания</option>
        </select><br><br>

        <label>Пол
            <input type="radio" name="gender" id="male" value="male">
            <label for="male">Мужской</label>
            <input type="radio" name="gender" id="female" value="female">
            <label for="female">Женский</label>
        </label><br><br>

        <label for="date">Дата рождения</label>
        <input type="date" name="date" id="date" value="${date_birth}"><br><br>

        <label for="subscribe">Подписка на новости </label>
        <input type="checkbox" name="subscribe" id="subscribe" value="${subscribe}"><br><br>

        <label for="consent">Согласие с правилами сайта ${consent_error}</label>
        <input type="checkbox" name="consent" id="consent" value="${consent}"><br><br>

        <input type="submit" name="Отправить">

    </div>
</form>

</body>
</html>