<%--
  Created by IntelliJ IDEA.
  User: toru
  Date: 2024/05/30
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.html"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:set var="message" value="Hello" />
<p>message : ${message}</p>

<c:set var="message2">Welcome</c:set>
<p>message2 : ${message2}</p>

<c:set var="result" value="${1 + 2}" />
<p>result : ${result}</p>

<jsp:useBean id="product" class="book.bean.Product" />
<c:set target="${product}" property="name" value="さんま" />
<p>product.name : ${product.name}</p>

<jsp:useBean id="map" class="java.util.HashMap" />
<c:set target="${map}" property="apple" value="りんご"/>
<p>map.apple : ${map.apple}</p>

<%@ include file="../footer.html"%>
