<%--
  Created by IntelliJ IDEA.
  User: wwy23
  Date: 2019/4/10
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>基本测试</h4>
<a href="${pageContext.request.contextPath}/ic/gotoResult.action">点击测试</a>
<h2>完成用户登陆操作</h2>
<%--发送一个请求  找action处理  --%>
<a href="${pageContext.request.contextPath}/user/toLogin.action">跳转到登陆界面</a>
</body>
</html>
