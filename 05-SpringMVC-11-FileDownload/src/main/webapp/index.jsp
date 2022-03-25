<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>文件下载页</title>
</head>
<body>
    <img src="http://localhost:8081/upload/${img}">
    <form method="post" action="/file/download2?filename=${img}">
        <input type="submit" value="下载">
    </form>
</body>
</html>
