<%--
  Created by IntelliJ IDEA.
  User: toru
  Date: 2024/05/30
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.html"%>
<%@ include file="menu.jsp" %>

<form action="Login.action" method="post">
    <p>ログイン名<input type="text" name="login"></p>
    <p>パスワード<input type="text" name="password"></p>
    <p><input type="submit" value="ログイン"></p>
</form>

<%@ include file="../footer.html"%>
