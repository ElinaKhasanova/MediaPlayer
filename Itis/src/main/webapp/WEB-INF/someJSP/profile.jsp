<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>HttpSession</h1>

<form method="post" action="/logout">
    <input type="submit" name="sign_out" value="SIGN OUT">
</form>
<%--<a href="/WEB-INF/welcome.jsp">LOG OUT</a>--%>
<%--<a href="/profile">PROFILE</a>--%>
<h1>Hello, ${login_aut}</h1><br>

</body>
</html>
