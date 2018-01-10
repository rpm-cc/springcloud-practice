<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>统一异常处理页面</title>
</head>
<body>



<#if exception??>
<div><label> url : </label>${url}</div>
<div><label> exception :  </label>${exception.message}</div>

<#else >
Something went wrong: ${status!} ${error!}
</#if>
</body>
</html>