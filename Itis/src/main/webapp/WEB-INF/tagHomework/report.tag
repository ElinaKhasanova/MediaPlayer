<%@ tag import="java.text.SimpleDateFormat" %>
<%@ tag import="dateTime.Time" %>
<%@ tag description="Date and time tag" pageEncoding="UTF-8"%>
<%@attribute name="date" required="true" rtexprvalue="true" %>

<%
    Time time2 = new Time("5/11/2018 12:00");
    time2.calculatePastTime();
    out.write(time2.pastTimeToString());
%>
<h1>${answer}</h1>

<