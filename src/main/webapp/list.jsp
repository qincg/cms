<%@ page import="java.util.List" %>
<%@ page import="bean.User" %>
<%@ page import="bean.PageBean" %><%--
  Created by IntelliJ IDEA.
  User: qcg
  Date: 2018/10/12
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="content-type" charset="UTF-8" content="text/html">
    <title>列表</title>
</head>
<body>
<%@include file="index.jsp"%>

<%
    PageBean<User> pageBean = (PageBean<User>)request.getAttribute("pageBean");
    //List<User> userList = (List<User>)request.getAttribute("userList");
    List<User> userList = pageBean.getList();

%>
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
        <%
            for (User user : userList){
        %>
        <tr>
            <td><%=user.getId()%></td>
            <td><%=user.getUserName()%></td>
            <td><%=user.getGender()%></td>
            <td><%=user.getGj()%></td>
            <td>
                <a href="${pageContext.request.contextPath}/userShow?id=<%=user.getId()%>">查看</a>
                <a href="${pageContext.request.contextPath}/userShow?id=<%=user.getId()%>&op=edit">编辑</a>
                <a href="#">删除</a>
            </td>
        </tr>
        <%}
        %>
    </tbody>

</table>
<div style="float: right;margin-right: 20px;">
    <div>
        总记录数：<%=pageBean.getTotalSize()%>；总页数：<%=pageBean.getTotalPage()%>；当前页数：<%=pageBean.getCurrentPage()%>
    </div>
    <ul class="pagination pagination-lg">
        <li><a href="userList">&laquo;</a></li>
        <%
            int start = pageBean.getStart();
            int end = pageBean.getEnd();
            for (int i = start;i <= end ; i++){
        %>
        <li><a href="${pageContext.request.contextPath}/userList?currentPage=<%=i%>"><%=i%></a></li>
        <%    }
        %>
        <li><a href="userList?currentPage=<%=pageBean.getTotalPage()%>">&raquo;</a></li>
    </ul>
</div>


</body>
</html>
