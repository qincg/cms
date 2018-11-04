<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="IE=edge" >
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <%--bootstrap--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <link href="${pageContext.request.contextPath}/css/bootstrap-table.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <%--<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>--%>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap-table.js"></script>
    <script src="${pageContext.request.contextPath}/js/locale/bootstrap-table-zh-CN.js"></script>

    <title>首页</title>
</head>
<body>
<h1 class="text-center"><b>CMS</b></h1>
<div >
    <ul class="nav nav-pills">
        <li><a href="index.jsp">首页</a></li>
        <li><a href="${pageContext.request.contextPath}/add.jsp">添加</a></li>
        <li><a href="${pageContext.request.contextPath}/userList">列表</a></li>
    </ul>
</div>

</body>
</html>
