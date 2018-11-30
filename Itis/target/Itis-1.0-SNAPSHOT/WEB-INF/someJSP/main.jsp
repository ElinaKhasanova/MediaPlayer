<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href='style.css' rel='stylesheet' type='text/css'>
</head>
<body>
<header>
    <div class="header-left"><img src="logo.png" alt="Logo" height="100px" width="120px"></div>
    <div class="header-center">
        <ul>
            <li><a href="#">О сайте</a></li>
            <li><a href="#">Возможности</a></li>
            <li><a href="#">Помощь</a></li>
        </ul>
    </div>
    <div class="header-right">
        <form action="registration.jsp">
            <button>Регистрация</button>
        </form>
        <form action="autorization.jsp">
            <button>Вход</button>
        </form>
    </div>
</header>

</body>
</html>
