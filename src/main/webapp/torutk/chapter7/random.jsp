<%@ page import="java.util.concurrent.ThreadLocalRandom" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.html" %>

<p><% out.println(ThreadLocalRandom.current().nextDouble()); %></p>

<p><%= ThreadLocalRandom.current().nextDouble() %></p>

<%@ include file="../footer.html" %>
