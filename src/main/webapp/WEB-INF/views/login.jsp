<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html><!--Bootstrap 使用到的某些 HTML 元素和 CSS 属性需要将页面设置为 HTML5 文档类型-->
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Document</title>

    <link rel="stylesheet" href="<%=basePath %>bootstrap-3.3.7-dist/css/bootstrap.css" type="text/css">
</head>
<body style="position: relative">
<div style="width: 20%;margin: 0 auto;margin-top: 17%;">
<ul class="nav nav-pills" id="myTabs" role="pilllist" style="width: 40%;margin: 0 auto;margin-bottom: 20px;">
    <li role="presentation" class="active"><a href="#login" aria-controls="login" role="pill" data-toggle="pill" id="login-pill" style="color: #000;">登录</a>
    </li>
    <li role="presentation"><a href="#register" aria-controls="register" role="pill" data-toggle="pill" id="register-pill" style="margin-left: 35px;color: #000;">注册</a>
    </li>
</ul>
    <!-- Tab panes -->
    <div class="pill-content" id="myTabContent">
        <div role="pillpanel" class="pill-pane fade in active" id="login" aria-labelledby="login-pill">
            <form method="get" action="">
                <div class="input-group input-group-lg">
                    <span class="input-group-addon" id="user-name-label">用户名:</span>
                    <input type="text" class="form-control" placeholder="Username" aria-describedby="sizing-addon1">
                </div>
                <div class="input-group input-group-lg" style="margin-top: 30px">
                    <span class="input-group-addon" id="password-label">密&nbsp;&nbsp;码:</span>
                    <input type="password" class="form-control" placeholder="Password" aria-describedby="sizing-addon1">
                </div>
                <button type="button" class="btn btn-primary" data-toggle="button" aria-pressed="false" autocomplete="off" style="width: 100%;background: #0f88eb;color: #fff;margin-top: 20px;height: 50px">
                    登录
                </button>
            </form>
        </div>
        <div role="pillpanel" class="pill-pane fade" id="register" aria-labelledby="register-pill">...</div>
    </div>
</div>
<!--bootstrap需要依赖jQuery，所以必须在他之前先引入jQuery-->
<script src="<%=basePath %>bootstrap-3.3.7-dist/js/jquery-3.1.1.js"></script>
<!-- 引入bootstrap脚本 -->
<script src="<%=basePath %>bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script>
    $('#myTabs a').click(function (e) {
        e.preventDefault()
        $(this).tab('show')
    })
</script>
</body>
</html>