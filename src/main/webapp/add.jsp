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

<form action="/addAndEdit" method="post">
<label for="userName">姓名:</label>
<input type="text" id="userName" name="userName"/>
<label for="gender">性别:</label>
<input type="radio" id="gender" name="gender"/>
<label for="gender">国籍:</label>
<input type="text" id="gj" name="gj"/>
<input type="submit" value="添加"><br/>
<input type="reset" value="重置">
</form>
</body>
</html>
