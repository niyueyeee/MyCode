<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/css/1.css">
</head>
<body>

<center>
    <table border="1px" width="80%" cellspacing="0px" align="center">
        <thead>
        <tr>
            <th>id</th>
            <th>用户名</th>
            <th>密码</th>
            <th>年龄</th>
        </tr>
        </thead>
        <tbody>
        <#--
            <c:foreach items="${users}" var='user'>


        -->
        <#list users as user>
            <tr>
                <th>${user.id}</th>
                <th>${user.username}</th>
                <th>${user.password}</th>
                <th>${user.age}</th>
            </tr>
        </#list>
        </tbody>
    </table>
</center>

<div>
    <img src="/img/1.jpg">
</div>

</body>
</html>