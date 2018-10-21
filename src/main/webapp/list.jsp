<%@ page import="java.util.List" %>
<%@ page import="bean.User" %><%--
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
<%
    List<User> userList = (List<User>)request.getAttribute("userList");

%>
<table id="userList">
    <tr>
        <th>姓名</th>
        <th>性别</th>
        <th>国籍</th>
    </tr>
<%
    for (User user : userList){
%>
    <tr>
        <td><%=user.getUserName()%></td>
        <td><%=user.getGender()%></td>
        <td><%=user.getGj()%></td>
    </tr>
    <%}
%>
</table>
</body>
</html>
