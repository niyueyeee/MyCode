<%--
  Created by IntelliJ IDEA.
  User: wwy23
  Date: 2019/4/10
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>处理器Handler方法的返回值问题</title>
</head>
<body>

<fieldset>

    <a href="${pageContext.request.contextPath}/hr/returnVoidWrite.action">输出内容到页面</a><br>
</fieldset>
<fieldset>
    <h2>测试4：处理器Handler方法返回值是String完成重定向与请求转发</h2>
    <a href="${pageContext.request.contextPath}/hr/returnStringDispatcher.action">请求转发</a><br>
    <a href="${pageContext.request.contextPath}/hr/returnStringSendRedirect.action">重定向</a><br>
</fieldset>
</body>
</html>
