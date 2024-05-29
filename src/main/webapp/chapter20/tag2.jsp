<%--
  Created by IntelliJ IDEA.
  User: toru
  Date: 2024/05/30
  Time: 7:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.html"%>

<jsp:useBean id="product" class="book.bean.Product" />

<jsp:setProperty name="product" property="id" value="2" />
<jsp:setProperty name="product" property="name" value="サーモン" />

