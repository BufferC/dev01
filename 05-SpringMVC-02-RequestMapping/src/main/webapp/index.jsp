<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>测试@RequestMapping注解</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<form action="/user/getParam">
    用户名：<input type="text" name="username">
    密码：<input type="password" name="password">
    提交<input type="submit">
</form>
</body>
</html>