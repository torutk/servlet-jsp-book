<%--
  Created by IntelliJ IDEA.
  User: TTakahashi
  Date: 2024/05/23
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.html" %>

<%@ page import="book.bean.Product" %>

<% Product p = (Product) request.getAttribute("product"); %>

<%= p.getId() %>:<%= p.getName() %>:<%= p.getPrice() %><br>

<%@ include file="../footer.html"%>
