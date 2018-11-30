<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tagHomework" prefix="t"%>
<t:header title="Услуги"></t:header>

<ul>
    <c:forEach items="services" var="service">
        <li>${service.name}, ${service.description}, ${service.price}</li>
    </c:forEach>
</ul>

</body>
</html>
