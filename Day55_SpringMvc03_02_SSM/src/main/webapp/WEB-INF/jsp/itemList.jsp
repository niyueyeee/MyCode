<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wwy23
  Date: 2019/4/11
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示商品信息列表</title>
</head>
<body>
<table border="1" width="80%" style="text-align: center">
    <tr>
        <th>序号</th>
        <th>商品名称</th>
        <th>商品价格</th>
        <th>商品详情</th>
    </tr>
    <c:forEach items="${itemList}" var="item" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${item.name}</td>
            <td>${item.price}</td>
            <td>${item.detail}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
