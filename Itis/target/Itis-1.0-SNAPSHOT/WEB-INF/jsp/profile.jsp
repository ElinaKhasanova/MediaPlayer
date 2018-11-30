<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tagHomework" prefix="t"%>
<t:header title="Личный кабинет"></t:header>

<form method="post">
    <input type="text" name="first_name" placeholder="Имя">
    <input type="text" name="last_name" placeholder="Фамилия">
    <input type="text" name="login" placeholder="Почта">
    <input type="password" name="password" placeholder="Пароль">
    <input type="text" name="date" id="date" placeholder="Дата рождения" onfocus="(this.type='date')">
    <button type="submit" class="btn btn-primary btn-block btn-large">Изменить</button>
</form>

</body>
</html>