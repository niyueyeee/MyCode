<%--
  Created by IntelliJ IDEA.
  User: wwy23
  Date: 2019/4/10
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>json数据交互案例</title>
    <title>json数据交互案例</title>
    <%--
      外部引入  jquery文件
    --%>
    <script src="js/jquery.min.js" type="text/javascript"></script>

    <script type="text/javascript">

        function sub() {
            // 发送ajax请求
            $.ajax({
                //请求路径
                url: "${pageContext.request.contextPath}/json/sendJsonStr.action",
                //请求类型
                type: "post",
                //传输数据
                data: '{"id":1,"name":"毕滢","address":"北京"}',
                contentType: "application/json;charset=utf-8",
                //期望返回类型
                dataType: "json",
                //成功回调函数
                success: function (data) {
                    //将数据打印到 浏览器控制台
                    console.log(data);
                }

            })
        }

    </script>
</head>
<body>
<fieldset>
    <h2>一个关于json数据交互的案例</h2>
    <input type="button" value="提交ajax请求" onclick="sub()">
</fieldset>
</body>
</html>
