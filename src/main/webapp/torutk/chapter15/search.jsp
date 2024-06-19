<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.html" %>

<label for="keyword"><p>検索キーワードを入力してください。</p></label>
<form action="search" method="post">
    <input type="text" name="keyword" id="keyword">
    <input class="button" type="submit" value="検索">
</form>

<%@ include file="../footer.html" %>
