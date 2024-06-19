<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.html" %>

<p>追加する商品を入力してくださいl。</p>
<form action="transaction" method="post">
    <label>商品名<input type="text" name="name"></label>
    <label>価格<input type="text" name="price"></label>
    <input class="button" type="submit" value="追加">
</form>

<%@ include file="../footer.html" %>
