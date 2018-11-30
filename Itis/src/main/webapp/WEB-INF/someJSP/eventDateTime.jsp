<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <title>Time</title>
</head>
<body>
<form method="POST">
    <input type="text" name="date" value="${dt}">
    <input type="submit" name="send">
</form>
<t:report date="${date_input}"></t:report>
</body>
</html>
