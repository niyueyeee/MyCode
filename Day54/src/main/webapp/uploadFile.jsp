<%--
  Created by IntelliJ IDEA.
  User: wwy23
  Date: 2019/4/10
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset>
    <h2>用例1:上传到本地服务器</h2>
    <form method="post" enctype="multipart/form-data"
          action="${pageContext.request.contextPath}/upload/uploadFile.action">
        上传头像:<input type="file" name="uploadFile">
        <input type="submit" value="提交文件">
    </form>
</fieldset>
<fieldset>
    <h2>用例2:上传到网络服务器</h2>
    <form method="post" enctype="multipart/form-data"
          action="${pageContext.request.contextPath}/upload/uploadFile2.action">
        上传头像:<input type="file" name="uploadFile">
        <input type="submit" value="提交文件">
    </form>
</fieldset>
</body>
</html>
