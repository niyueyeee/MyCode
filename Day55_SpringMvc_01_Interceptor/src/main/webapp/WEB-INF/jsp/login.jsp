<%--
  Created by IntelliJ IDEA.
  User: wwy23
  Date: 2019/4/11
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>
    <style type="text/css">
        div {
            width: 300px;
            height: 100px;
            position: absolute;
            top: 50%;
            left: 50%;
            margin-top: -50px;
            margin-left: -150px;
        }
    </style>
</head>
<body>
<div>
    <form method="post" action="${pageContext.request.contextPath}/user/login.action">
        <table>
            <tr>
                <td>用户名:</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="登陆"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
