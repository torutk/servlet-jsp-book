<%--
  Created by IntelliJ IDEA.
  User: toru
  Date: 2024/05/30
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.html"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<p>購入数を選択してください。</p>
<form action="/book/chapter6/select" method="post">
    <select name="count">
        <c:forEach var="i" begin="1" end="9">
            <option value="${i}">${i}</option>
        </c:forEach>
    </select>
    <p><input type="submit" value="確定"></p>
</form>

<%@ include file="../footer.html"%>
