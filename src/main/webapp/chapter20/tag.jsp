<%--
  Created by IntelliJ IDEA.
  User: toru
  Date: 2024/05/30
  Time: 7:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.html" %>

<jsp:useBean id="product" class="book.bean.Product" scope="request" />

<p>
    <jsp:getProperty name="product" property="id" />
    <jsp:getProperty name="product" property="name" />
    <jsp:getProperty name="product" property="price" />
</p>

<%@ include file="../footer.html" %>