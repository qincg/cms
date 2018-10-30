<%--
  Created by IntelliJ IDEA.
  User: qcg
  Date: 2018/10/12
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="content-type" charset="UTF-8" content="text/html">
    <title>Message</title>
</head>
<body>
<%@include file="index.jsp"%>
    <c:out value="${requestScope.msg}"/>
</body>
</html>
