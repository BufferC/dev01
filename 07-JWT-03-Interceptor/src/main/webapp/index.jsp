<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>主页</title>
    <script src="js/jquery-1.8.3.min.js"></script>
</head>
<body>
<h1 align="center" style="color: yellowgreen"><span id="username"></span>登录成功</h1>
</body>
<script type="application/javascript">
    // 页面渲染时就会执行
    $(function () {
        // 从本地存储中获取token
        var token = localStorage.getItem("token");

        if (token === null) {
            alert("token不存在，请重新登录");
            $(location).attr('href', "/login.html");
        } else {
            $.ajax({
                type: "post",
                url: "/user/verifyToken",
                headers: {"token": token},
                success: function (resp) {
                    if (resp.success) {
                        alert(resp.message)
                        $("#username").text(resp.data.username);
                    } else {
                        alert(resp.message);

                        $(location).attr('href', "/login.html");
                    }
                }
            })
        }
    })
</script>
</html>