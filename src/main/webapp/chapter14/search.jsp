<%--
  Created by IntelliJ IDEA.
  User: toru
  Date: 2024/05/29
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.html" %>

<p>検索キーワードを入力してください。</p>
<form action="search" method="post">
    <input type="text" name="keyword">
    <input type="submit" name="検索">
</form>

<%@ include file="../footer.html" %>
