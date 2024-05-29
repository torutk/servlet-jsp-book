<%--
  Created by IntelliJ IDEA.
  User: TTakahashi
  Date: 2024/05/23
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.html" %>

<p>検索ワードを入力してください。</p>
<form action="search" method="post">
    <input type="text" name="keyword">
    <input type="submit" value="検索">
</form>

<%@ include file="../footer.html" %>
