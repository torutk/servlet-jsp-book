<%--
  Created by IntelliJ IDEA.
  User: toru
  Date: 2024/05/30
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.html"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:forEach var="p" items="${list}">
    ${p.id}:${p.name}:${p.price}<br>
</c:forEach>

<%@ include file="../footer.html"%>
