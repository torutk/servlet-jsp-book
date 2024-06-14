<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.html" %>

<label for="user"><p>お名前を入力してください。</p></label>
<form action="greeting-out.jsp" method="post">
  <input type="text" name="user" id="user">
  <input class="button" type="submit" name="確定">
</form>

<%@ include file="../footer.html" %>
