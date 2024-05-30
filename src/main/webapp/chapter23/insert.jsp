<%--
  Created by IntelliJ IDEA.
  User: toru
  Date: 2024/05/30
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.html"%>

<p>追加する商品を入力してください。</p>
<form action="Insert.action" method="post">
    商品名<input type="text" name="name">
    価格<input type="text" name="price">
    <input type="submit" value="追加">
</form>

<%@ include file="../footer.html"%>
