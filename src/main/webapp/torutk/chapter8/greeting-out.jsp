<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.html" %>

<% request.setCharacterEncoding("UTF-8"); %>
<p>こんにちは、<%= request.getParameter("user") %>さん！</p>

<%@ include file="../footer.html" %>
