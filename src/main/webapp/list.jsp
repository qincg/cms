<%@ page import="java.util.List" %>
<%@ page import="bean.User" %>
<%@ page import="bean.PageBean" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: qcg
  Date: 2018/10/12
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="content-type" charset="UTF-8" content="text/html">
    <title>列表</title>
</head>
<body>
<%@include file="index.jsp"%>

<table class="table table-hover table-striped table-bordered" id="userList">
    <caption>用户列表</caption>
    <thead>
        <tr>
            <th>ID</th>
            <th>姓名</th>
            <th>性别</th>
            <th>国籍</th>
            <th>操作</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.pageBean.list}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.userName}</td>
            <td>${user.gender}</td>
            <td>${user.gj}</td>
            <td>
                <a class="btn btn-default" href="${pageContext.request.contextPath}/userShow?id=${user.id}">查看</a>
                <a class="btn btn-info" href="${pageContext.request.contextPath}/userShow?id=${user.id}&op=edit">编辑</a>
                <a class="btn btn-danger" href="${pageContext.request.contextPath}/userDel?id=${user.id}">删除</a>
            </td>
        </tr>

        </c:forEach>

    </tbody>

</table>
<div style="float: right;margin-right: 20px;">
    <div>
        总记录数：${requestScope.pageBean.totalSize}；总页数：${requestScope.pageBean.totalPage}；当前页数：${requestScope.pageBean.currentPage}
    </div>
    <ul class="pagination pagination-lg">
        <li><a href="userList">&laquo;</a></li>

        <c:forEach var="page" begin="${requestScope.pageBean.start}" end="${requestScope.pageBean.end}">
            <li><a href="${pageContext.request.contextPath}/userList?currentPage=${page}">${page}</a></li>
        </c:forEach>

        <li><a href="userList?currentPage=${requestScope.pageBean.totalPage}">&raquo;</a></li>
    </ul>
</div>
</body>
</html>
