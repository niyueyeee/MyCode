<%--
  Created by IntelliJ IDEA.
  User: wwy23
  Date: 2019/4/10
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>两个注解 @ModelAttribute和@SessionAttributes</title>
</head>
<body>
<fieldset>

    <h2>练习一个@ModelAttribute注解的使用(理解一下应用场景)</h2>
    <a href="${pageContext.request.contextPath}/ac/updateUserById.action?id=1&address=东北">更新用户信息</a>
</fieldset>
<fieldset>

    <h2>练习@SessionAttributes注解的使用</h2>
    <a href="${pageContext.request.contextPath}/ac/setSessionValue.action">将钱存入session中</a>
    <a href="${pageContext.request.contextPath}/ac/getSessionValue.action">将钱从session中取出</a>
    <a href="${pageContext.request.contextPath}/ac/removeSessionValue.action">清空session数据</a>
</fieldset>
</body>
</html>
