<%--
  Created by IntelliJ IDEA.
  User: toru
  Date: 2024/05/30
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.html"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

抽選結果：
<c:if test="${Math.random() < 0.5}">
    あたり！
</c:if>

<%@ include file="../footer.html"%>
