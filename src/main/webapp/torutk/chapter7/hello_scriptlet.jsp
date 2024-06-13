<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.html" %>

<p>Hello!</p>
<p>こんにちは！</p>

<p><% out.println(java.time.ZonedDateTime.now()); %></p>

<%@ include file="../footer.html" %>
