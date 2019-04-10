<%--
  Created by IntelliJ IDEA.
  User1: wwy23
  Date: 2/25/0025
  Time: 上午 09:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<form action="/Day25/log" method="post">
  <input type="text" name="name" placeholder="用户名" >
  <br/>
  <input type="password" name="password" placeholder="密码" >
  <input type="submit" value="登录">
</form>
<hr/>
<form action="/Day25/reg" method="post">
  <input type="text" name="name" placeholder="用户名" >
  <br/>
  <input type="password" name="password" placeholder="密码" >
  <input type="submit" value="注册">
</form>
</body>
</html>
