<%--
  Created by IntelliJ IDEA.
  User: wwy23
  Date: 2019/4/7
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>基本的请求路径的配置@ReuqestMapping</h2>

<fieldset>
    <h4>测试用例USE_CASE 1：SpringMVC入门案例</h4>
    <a href="${pageContext.request.contextPath}/ok/gotoResult.action">开始测试</a>
</fieldset>

<fieldset>
    <h4>测试用例USE_CASE 2：@ReuqestMapping之多个URL路径映射到同一个Handler</h4>
    <a href="${pageContext.request.contextPath}/ok/gotoResultMultiUrl1.action">测试路径1</a>
    <a href="${pageContext.request.contextPath}/ok/gotoResultMultiUrl2.action">测试路径2</a>
</fieldset>

<fieldset>
    <h4>测试用例USE_CASE 3：@ReuqestMapping之同一路径请求方式不同访问不同的Handler</h4>

    <a href="${pageContext.request.contextPath}/ok/gotoSameUrl.action">get请求</a>

    <form action="${pageContext.request.contextPath}/ok/gotoSameUrl.action" method="post">
        <input type="submit" value="post请求提交">
    </form>
</fieldset>

<fieldset>
    <h4>测试用例USE_CASE 4：@ReuqestMapping之 url相同，请求方式相同，请求参数不同进入不同hanlder方法处理</h4>
    <a href="${pageContext.request.contextPath}/ok/login.action?state=1&isAdmin=0&type=user">普通用户登录</a><br>
    <a href="${pageContext.request.contextPath}/ok/login.action?state=1&isAdmin=1&type=admin">管理员登录</a><br>
    <a href="${pageContext.request.contextPath}/ok/login.action?state=1&isAdmin=0&type=vip">VIP用户登录</a><br>
</fieldset>
</body>
</html>
