<%--
  Created by IntelliJ IDEA.
  User: TTakahashi
  Date: 2024/05/23
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.html" %>

<%@ page import="book.bean.Product, java.util.List" %>

<% List<Product> list = (List<Product>) request.getAttribute("list"); %>

<% for (Product p : list) { %>
    <%= p.getId() %>:<%= p.getName() %>:<%= p.getPrice() %><br>
<% } %>

<%@ include file="../footer.html" %>
