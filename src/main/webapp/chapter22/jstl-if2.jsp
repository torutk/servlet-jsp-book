<%--
  Created by IntelliJ IDEA.
  User: toru
  Date: 2024/05/30
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.html"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:forEach var="i" begin="101" end="200">
    <c:choose>
        <c:when test="${i % 10 == 1}">(${i},</c:when>
        <c:when test="${i % 10 == 0}">${i})<br></c:when>
        <c:otherwise>${i},</c:otherwise>
    </c:choose>
</c:forEach>

<%@ include file="../footer.html"%>
