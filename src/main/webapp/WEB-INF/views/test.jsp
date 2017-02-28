<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html><!--Bootstrap 使用到的某些 HTML 元素和 CSS 属性需要将页面设置为 HTML5 文档类型-->
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Document</title>

    <link rel="stylesheet" href="<%=basePath %>resources/css/bootstrap/bootstrap.css">
</head>
<body>

<!--bootstrap需要依赖jQuery，所以必须在他之前先引入jQuery-->
<script src="<%=basePath %>resources/js/bootstrap/jquery-1.11.3.min.js"></script>
<script src="<%=basePath %>resources/js/bootstrap/bootstrap.js"></script>
</body>
</html>