<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>客户录入页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/add" method="post">
    客户名称：<input type="text" name="name"/><br/>
    客户来源：<input type="text" name="source"/><br/>
    客户级别：<input type="text" name="level"/><br/>
    客户行业：<input type="text" name="industry"/><br/>
    客户电话：<input type="text" name="phone"/><br/>
    <input type="submit" value="保存"/><br/>
</form>
</body>
</html>
