<%--
  Created by IntelliJ IDEA.
  User: qcg
  Date: 2018/10/12
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="content-type" charset="UTF-8" content="text/html">
    <title>添加客户</title>
</head>
<body>
<%--
    <jsp:include> 是把文件编译后引入，引入的是文件编译后的结果
    <%@ include> 是把文件加入进来一起编译
--%>
<%--<jsp:include page="index.jsp"/>--%>
<%@include file="index.jsp"%>
<form class="form-horizontal" action="addAndEdit" method="post">
    <div class="form-group col-md-12">
        <label class="col-md-2 control-label" for="userName">姓名:</label>
        <div class="col-md-8">
            <input class="form-control" type="text" id="userName" name="userName" placeholder="请输入姓名"/>
        </div>
    </div>
    <div class="form-group col-md-12">
        <label class="col-md-2 control-label">性别:</label>
        <div class="col-md-8">
            <label class="radio-inline">
                <input type="radio" id="man" name="gender" value="男"/>男
            </label>
            <label class="radio-inline">
                <input type="radio" id="woman" name="gender" value="女"/>女
            </label>
        </div>
    </div>
    <div class="form-group col-md-12">
        <label class="col-md-2 control-label" for="gj">国籍:</label>
        <div class="col-md-8">
            <input class="form-control" type="text" id="gj" name="gj" placeholder="请输入国籍"/><br>
        </div>
    </div>
    <div style="display: none">
        <input type="text" id="op" name="op" value="add">
    </div>
    <div class="form-group col-md-12">
        <div class="col-md-offset-2 col-md-8">
            <input class="btn btn-info" type="submit" value="添加">
            <input class="btn btn-danger" type="reset" value="重置">
        </div>
    </div>
</form>
</body>
</html>
