<%--
  Created by IntelliJ IDEA.
  User1: youcai
  Date: 2018/12/17
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<!-- 使用两个域对象 存储 键值对 pageContext.setAttribute("aa","BB");-->

<%
    request.setAttribute("aa", "AAAAAA");

%>
<body>
<!-- 查找键值对数据 -->
<%=  request.getAttribute("aa")%>
</body>
</html>
