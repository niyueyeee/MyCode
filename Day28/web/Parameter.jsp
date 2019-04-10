<%--
  Created by IntelliJ IDEA.
  User1: youcai
  Date: 2018/12/15
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/web10/para" method="POST">
    用户名：<input type="text" name="username"><br>
    密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password">
    <br>
    爱好：
    <input type="checkbox" name="hobby" value="sing">唱歌
    <input type="checkbox" name="hobby" value="dance">跳舞
    <input type="checkbox" name="hobby" value="football">足球<br>
    <input type="submit" value="提交">
</form>


</body>
</html>
