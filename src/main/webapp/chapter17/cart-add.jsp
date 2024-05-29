<%--
  Created by IntelliJ IDEA.
  User: TTakahashi
  Date: 2024/05/25
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.html"%>

<p>カートに追加する商品を入力</p>
<form action="cart-add" method="post">
    商品名<input type="text" name="name">
    価格<input type="text" name="price">
    <input type="submit" value="追加">
</form>

<%@ include file="../footer.html" %>
