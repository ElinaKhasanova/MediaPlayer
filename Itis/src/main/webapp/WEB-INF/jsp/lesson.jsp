<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tagHomework" prefix="t"%>
<t:header title="Расписание"></t:header>

<ul>
    <c:forEach items="lessons" var="lesson">
        <li>${lesson.name}, ${lesson.date}, ${lesson.time} ${lesson.trainer}</li>
            <button type="button" onclick="apply(${lesson.id});">Записаться</button>
    </c:forEach>
</ul>
<div id="message"></div>
</body>

<script>
 function apply(lessonId){
     $.ajax({
         type: 'post',
         url: "<c:url value="/timetable"/>",
         data: {
             lessonId: lessonId
         }
     }).done(function (data) {
         document.getElementById("message").innerHTML =
             "<div class=\"alert alert-success alert-dismissible fade show\" role=\"alert\">\n" +
             "Вы записаны на занятие." +
             "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\n" +
             "    <span aria-hidden=\"true\">&times;</span>\n" +
             "  </button>\n" +
             "</div>";
     }).fail(function () {
         alert("Произошла ошибка.");
     });
 }
</script>
</html>
