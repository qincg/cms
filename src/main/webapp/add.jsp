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

<form action="addAndEdit" method="post">
<label for="userName">姓名:</label>
<input type="text" id="userName" name="userName"/><br>
性别:
<input type="radio" id="man" name="gender" value="男"/>
<label for="man">男</label>
<input type="radio" id="woman" name="gender" value="女"/>
<label for="woman">女</label><br>
<label for="gj">国籍:</label>
<input type="text" id="gj" name="gj"/><br>
<input type="submit" value="添加">
<input type="reset" value="重置">
</form>
</body>
</html>
