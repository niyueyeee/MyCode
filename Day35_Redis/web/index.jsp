<%--
  Created by IntelliJ IDEA.
  User: wwy23
  Date: 2019/3/10
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script type="text/javascript" src="jquery-3.3.1.js"></script>
</head>
<body>
<input type="button" value="登录" id="reset">
<div id="ap"></div>
<a href="${pageContext.request.contextPath}/s?method=reg">注册</a>
</body>
<script type="text/javascript">
    $("#reset").click(function () {
        $.get("/Day35/s",
            "method=login",
            function (date) {
                alert(date);
                $("#ap").html(date);
                $("#ap").show();
            }, "json")
    });
</script>
</html>
