<%@ page import="bean.User" %><%--
  Created by IntelliJ IDEA.
  User: qcg
  Date: 18-10-28
  Time: 下午4:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户详情</title>
</head>
<body>
<%@include file="index.jsp"%>
<form class="form-horizontal" action="" method="post">
    <div class="form-group col-md-12">
        <label class="control-label col-md-2" for="userName">姓名</label>
        <div class="col-md-10">
            <input class="form-control" type="text" id="userName" name="userName" value="${requestScope.user.userName}" disabled>
        </div>
    </div>
    <div class="form-group col-md-12">
        <label class="control-label col-md-2">性别</label>
        <div class="col-md-10">
            <label class="radio-inline" for="man">
                <input type="radio" id="man" name="gender" value="男" checked="${requestScope.user.gender eq "男" ? "checked" : ""}" disabled>男
            </label>
            <label class="radio-inline" for="woman">
                <input type="radio" id="woman" name="gender" value="女" checked="${requestScope.user.gender eq "女" ? "checked" : ""}" disabled>女
            </label>
        </div>
    </div>
    <div class="form-group col-md-12">
        <label class="control-label col-md-2" for="gj">国别</label>
        <div class="col-md-10">
            <input class="form-control" type="text" id="gj" name="gj" value="${requestScope.user.gj}" disabled>
        </div>
    </div>
    <div class="form-group col-md-12">
        <div class="col-md-offset-2 col-md-8">
            <a class="btn btn-info" href="${pageContext.request.contextPath}/userShow?op=edit&id=${requestScope.user.id}">编辑</a>
            <a class="btn btn-default" href="${pageContext.request.contextPath}/userList">返回</a>
        </div>
    </div>
</form>
</body>
</html>
