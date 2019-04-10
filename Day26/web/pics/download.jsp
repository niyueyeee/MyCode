<%--
  Created by IntelliJ IDEA.
  User1: youcai
  Date: 2018/12/14
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <style>
        a:link {
            color: black
        }

        a:visited {
            color: black
        }
    </style>
</head>
<body>
<!--
    超链接,实现文件下载
    连接的地址,写服务器端需要下载文件的路径
-->
<a href="/web09/download/a.flv">a.flv</a><br>
<a href="/web09/download/a.jpg">a.jpg</a><br>
<a href="/web09/download/a.mp3">a.mp3</a><br>
<a href="/web09/download/a.mp4">a.mp4</a><br>
<a href="/web09/download/a.txt">a.txt</a><br>
<a href="/web09/download/a.zip">a.zip</a><br>
<a href="/web09/download/a.pdf">a.pdf</a><br>

<hr>
<!-- 超链接,连接地址不是文件,Servlet中-->
<a href="/web09/download?filename=a.jpg">a.jpg</a> <br>
<a href="/web09/download?filename=a.mp4">a.mp4</a> <br>
<a href="/web09/download2?filename=美女.jpg">美女.jpg</a> <br>


</body>
</html>