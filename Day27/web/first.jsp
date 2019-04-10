<%--
  Created by IntelliJ IDEA.
  User1: youcai
  Date: 2018/12/17
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
    <%request.setAttribute("time" , System.currentTimeMillis());%>

    <%=request.getAttribute("time")%>

    <%
     for(int j = 0 ; j < 5 ; j++){%>
       <%="helloworld<br/>"%>
    <%}  %>
</body>
</html>
