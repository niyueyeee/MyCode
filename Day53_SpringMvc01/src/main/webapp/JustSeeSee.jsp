<%--
  Created by IntelliJ IDEA.
  User: wwy23
  Date: 2019/4/8
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>前后端参数名不匹配问题</h2>

<fieldset>
    <h4>测试用例USE_CASE 1：springMVC中前端参数名与后端接收的参数名不一致</h4>
    <a href="${pageContext.request.contextPath}/other/paramsNoMatch.action?uid=10">开始测试</a><br>
</fieldset>

<h2>关于请求头信息的获取</h2>

<fieldset>
    <h4>测试用例USE_CASE 2：springMVC支持获取请求头信息</h4>
    <a href="${pageContext.request.contextPath}/other/sendRequestHeader.action">开始测试</a><br>
</fieldset>

<h2>关于Cookie信息的获取</h2>

<fieldset>
    <h4>测试用例USE_CASE 3：springMVC支持获取Cookie信息</h4>
    <a href="${pageContext.request.contextPath}/other/sendCookie.action">开始测试</a><br>
</fieldset>

</body>
</html>
