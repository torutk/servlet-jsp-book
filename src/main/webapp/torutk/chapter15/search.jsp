<%--
  Created by IntelliJ IDEA.
  User: TTakahashi
  Date: 2024/04/23
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.html" %>

<p>検索キーワードを入力してください。</p>
<form action="search" method="post">
    <input type="text" name="keyword">
    <input type="submit" value="検索">
</form>

<p><%=request.getContentType()%></p>
<%@ include file="../footer.html" %>
