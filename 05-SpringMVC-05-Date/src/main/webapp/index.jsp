<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>测试日期格式</title>
</head>
<body>
    <form action="/user/getDate">
        <table align="center">
            <tr>
                <td>生日</td>
                <td><input type="date" name="date"></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="提交">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>