<%--
  Created by IntelliJ IDEA.
  User: wwy23
  Date: 2019/4/10
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset>
    <h2>入门案例</h2>
    <a href="${pageContext.request.contextPath}/user/queryById.action?id=10">传统形式的URL风格</a>
    <a href="${pageContext.request.contextPath}/user/10.action">Restful风格的URL</a>
</fieldset>
<fieldset>
    <h2>Restful风格玩CRUD(Url请求风格发生改变！)</h2>
    <a href="${pageContext.request.contextPath}/user/10.action">查询操作GET请求</a>
    <form method="post" action="${pageContext.request.contextPath}/user.action">
        id:<input type="text" name="id">
        name:<input type="text" name="name">
        address:<input type="text" name="address">
        <br>
        <input type="submit" value="POST请求">
    </form>
    <form method="post" action="${pageContext.request.contextPath}/user.action">
        <input type="hidden" name="_method" value="PUT">
        id:<input type="text" name="id">
        name:<input type="text" name="name">
        address:<input type="text" name="address">
        <br>
        <input type="submit" value="PUT请求">
    </form>
    <form method="post" action="${pageContext.request.contextPath}/user/100.action">
        <input type="hidden" name="_method" value="DELETE">
        <input type="submit" value="DELETE请求">
    </form>
</fieldset>
</body>
</html>
