<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form method="post" action="/user/getNestedBean">
    <table align="center">
        <caption><h1>注册</h1></caption>

        <tr>
            <td>账户</td>
            <td><input type="text" name="username"></td>
        </tr>

        <tr>
            <td>密码</td>
            <td><input type="text" name="password"></td>
        </tr>

        <tr>
            <td>姓名</td>
            <td><input type="text" name="user.name"></td>
        </tr>

        <tr>
            <td>年龄</td>
            <td><input type="text" name="user.age"></td>
        </tr>

        <tr>
            <td>性别</td>
            <td>
                男 <input type="radio" name="user.gender" value="男">
                女 <input checked type="radio" name="user.gender" value="女">
            </td>
        </tr>

        <tr>
            <td>生日</td>
            <td><input type="date" name="user.birthday"></td>
        </tr>

        <tr>
            <td>信息</td>
            <td><input type="text" name="user.info"></td>
        </tr>

        <tr>
            <td align="center" colspan="2">
                <input type="reset" value="重置">
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>
</form>
</body>
</html>