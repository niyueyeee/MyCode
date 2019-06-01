<%--
  Created by IntelliJ IDEA.
  User: wwy23
  Date: 2019/4/7
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>获取简单的请求参数</h2>

<fieldset>
    <h4>测试用例USE_CASE 1：springMVC中获取参数数据之对原生ServletAPI的支持</h4>
    <a href="${pageContext.request.contextPath}/user/sendSimpleParams.action?name=zhangsan">开始测试</a><br>
</fieldset>

<fieldset>
    <h4>测试用例USE_CASE 2：springMVC中接收简单的参数</h4>
    <a href="${pageContext.request.contextPath}/user/sendSimpleParamsByMVC.action?name=zhangsan&id=10">开始测试</a><br>
</fieldset>

<fieldset>
    <h4>测试用例USE_CASE 3：springMVC中绑定pojo对象类型</h4>
    <a href="${pageContext.request.contextPath}/user/sendPojo.action?name=zhangsan&id=10">开始测试</a><br>
</fieldset>

<fieldset>
    <h4>测试用例USE_CASE 4：springMVC中绑定pojo包装对象类型</h4>
    <a href="${pageContext.request.contextPath}/user/sendPojoPackage.action?vid=10086&user.name=zhangsan&user.id=10">开始测试</a><br>
</fieldset>

<fieldset>
    <p>测试用例USE_CASE5 :SpringMVC接收集合（List）类型参数</p>
    <form method="post" action="${pageContext.request.contextPath}/user/sendList.action">
        <table>
            <tr>
                <td>主键</td>
                <td>用户名</td>
            </tr>
            <tr>
                <%--
                  要的结果类型是 UserVo对象
                    需要将用户封装到  userList中
                      userList集合
                          User  userList.get(0)
                            每个User
                              id
                              name
                --%>
                <td><input type="text" name="userList[0].id"/></td>
                <td><input type="text" name="userList[0].name"/></td>
            </tr>
            <tr>
                <td><input type="text" name="userList[1].id"/></td>
                <td><input type="text" name="userList[1].name"/></td>
            </tr>
            <tr>
                <td><input type="text" name="userList[2].id"/></td>
                <td><input type="text" name="userList[2].name"/></td>
            </tr>

        </table>
        <input type="submit" value="批量提交">
    </form>
</fieldset>

<fieldset>
    <p>测试用例USE_CASE11:SpringMVC接收集合（Map）类型参数</p>
    <form method="post" action="${pageContext.request.contextPath}/user/sendMap.action">
        <table>
            <tr>
                <td>主键</td>
                <td>用户名</td>
            </tr>
            <tr>
                <%--
                   UserVo
                      userMap
                         找到user  userMap.get(键名)
                          User
                           id
                           name
                --%>
                <td><input type="text" name="userMap['user01'].id"/></td>
                <td><input type="text" name="userMap['user01'].name"/></td>
            </tr>
            <tr>
                <td><input type="text" name="userMap['user02'].id"/></td>
                <td><input type="text" name="userMap['user02'].name"/></td>
            </tr>
            <tr>
                <td><input type="text" name="userMap['user03'].id"/></td>
                <td><input type="text" name="userMap['user03'].name"/></td>
            </tr>
        </table>
        <input type="submit" value="批量提交">
    </form>
</fieldset>

</body>
</html>
