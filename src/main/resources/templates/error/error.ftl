<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8"/>
    <title>统一异常处理</title>
</head>
<body>
<h1>Error Handler</h1>
<div th:text="${url}">请求url：${url}</div>
<div th:text="${exception.message}">异常信息：${exception.message}</div>
</body>
</html>