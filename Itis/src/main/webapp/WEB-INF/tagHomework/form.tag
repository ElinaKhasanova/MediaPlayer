<%@tag description="Form Tag" pageEncoding="UTF-8"%>

<%@attribute name="email" required="false" %>
<%@attribute name="email_error" required="false" %>
<%@attribute name="pass_error" required="false" %>
<%@attribute name="pass_rep_error" required="false" %>
<%@attribute name="select_value1" required="true" %>
<%@attribute name="select_value2" required="true" %>
<%@attribute name="select_value3" required="true" %>
<%@attribute name="select_country1" required="true" %>
<%@attribute name="select_country2" required="true" %>
<%@attribute name="select_country3" required="true" %>
<%@attribute name="date_birth" required="false" %>
<%@attribute name="subscribe" required="false" %>
<%@attribute name="consent" required="false" %>
<%@attribute name="consent_error" required="false" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>RegistrationTag</title>
</head>
<body>
<form method="post" action="" id="form_tag">
    <div>
        <label for="email">E-mail *${email_error}</label>
        <input type="text" name="email" id="email"><br><br>

        <label for="password">Пароль ${pass_error}</label>
        <input type="password" name="password" id="password"><br><br>

        <label for="password_rep">Повтор пароля ${pass_rep_error}</label>
        <input type="password" name="password_rep" id="password_rep"><br><br>

        <label for="country">Страна</label>
        <select name="country" id="country">
            <option value="${select_value1}">${select_country1}</option>
            <option value="${select_value2}">${select_country2}</option>
            <option value="${select_value3}">${select_country3}</option>
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