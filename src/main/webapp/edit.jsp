<%@ page import="bean.User" %><%--
  Created by IntelliJ IDEA.
  User: qcg
  Date: 18-10-28
  Time: 下午5:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<%@include file="index.jsp"%>
<form class="form-horizontal" action="${pageContext.request.contextPath}/addAndEdit" method="post">
    <div class="form-group col-md-12">
        <label class="control-label col-md-2" for="userName">姓名</label>
        <div class="col-md-10">
            <input class="form-control" type="text" id="userName" name="userName" value="${requestScope.user.userName}" >
        </div>
    </div>
    <div class="form-group col-md-12">
        <label class="control-label col-md-2">性别</label>
        <div class="col-md-10">
            <label class="radio-inline" for="man">
                <input type="radio" id="man" name="gender" value="男" checked="${"男" eq requestScope.user.gender ? "checked":""}">男
            </label>
            <label class="radio-inline" for="woman">
                <input type="radio" id="woman" name="gender" value="女" checked="${"女" eq requestScope.user.gender ? "checked":""}">女
            </label>
        </div>
    </div>
    <div class="form-group col-md-12">
        <label class="control-label col-md-2" for="gj">国别</label>
        <div class="col-md-10">
            <input class="form-control" type="text" id="gj" name="gj" value="${requestScope.user.gj}" >
        </div>
    </div>
    <div style="display: none">
        <input type="text" id="op" name="op" value="edit">
        <input type="text" id="id" name="id" value="${requestScope.user.id}">
    </div>
    <div class="form-group col-md-12">
        <div class="col-md-offset-2 col-md-8">
            <input class="btn btn-info" type="submit" value="确定">
            <input class="btn btn-default" type="button" value="返回" onclick="window.location.href='${pageContext.request.contextPath}/userList'">
        </div>
    </div>
</form>
</body>
</html>
