<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.html" %>

<%@ page import="java.time.ZonedDateTime" %>

<p>Hello!</p>
<p>こんにちは！</p>

<p><%= ZonedDateTime.now() %></p>

<%@ include file="../footer.html" %>
