<%--
  Created by IntelliJ IDEA.
  User: wwy23
  Date: 2019/4/10
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试主页</title>
</head>
<body>

<fieldset>
    <h2>day01_02handler中使用Date类型接收String参数</h2>
    <a href="${pageContext.request.contextPath}/one/strToDate.action?birthday=2019-04-09">点击测试</a>
</fieldset>

<fieldset>
    <h2>day02_01_处理器Handler方法的返回值问题</h2>
    <a href="HandlerReturn.jsp">点击测试</a>
    <h2>day02_02两个注解 @ModelAttribute和@SeesionAttributes</h2>
    <a href="AnnotationDemo.jsp">点击测试</a>
</fieldset>

<fieldset>
    <h2>day02_03_json与对象的相互转换</h2>
    <a href="JsonToObject.jsp">点击测试</a>
    <h2>day02_04_玩文件上传</h2>
    <a href="uploadFile.jsp">点击测试</a>
    <h2>day02_05_SpringMVC对Restful风格URL的支持</h2>
    <a href="RestfulStyle.jsp">点击测试</a>
</fieldset>

</body>
</html>
