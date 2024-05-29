<%--
  Created by IntelliJ IDEA.
  User: TTakahashi
  Date: 2024/05/30
  Time: 8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.html"%>

${param.price} 円×
${param.count} 個=
${param.price * param.count} 円

<%@ include file="../footer.html"%>
