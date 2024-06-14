<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.html" %>

<form action="total-out.jsp" method="post">
  <label><input type="text" name="price">円×</label>
  <label><input type="text" name="count">個=</label>
  <p><input class="button" type="submit" value="計算"></p>
</form>

<%@ include file="../footer.html" %>
