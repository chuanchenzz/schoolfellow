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
    <title>校友注册-cqupt</title>
    <link href="<%=basePath %>Bootstrap-Admin-Theme/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="<%=basePath %>Bootstrap-Admin-Theme/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
    <link href="<%=basePath %>Bootstrap-Admin-Theme/assets/styles.css" rel="stylesheet" media="screen">
    <link href="<%=basePath %>Bootstrap-Admin-Theme/assets/DT_bootstrap.css" rel="stylesheet" media="screen">
    <link href="<%=basePath %>css/alumnus_index.css" rel="stylesheet" type="text/css"/>
    <!--[if lte IE 8]><script language="javascript" type="text/javascript" src="<%=basePath %>Bootstrap-Admin-Theme/vendors/flot/excanvas.min.js"></script><![endif]-->
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <script src="<%=basePath %>Bootstrap-Admin-Theme/vendors/modernizr-2.6.2-respond-1.1.0.min.js"></script>

</head>
<body >
<div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container-fluid">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span class="icon-bar"></span>
                     <span class="icon-bar"></span>
                     <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href="#">后台管理系统</a>
                    <div class="nav-collapse collapse">
                        <ul class="nav pull-right">
                            <li class="dropdown">
                                <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown"> <i class="icon-user"></i> chuanchen <i class="caret"></i>

                                </a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a tabindex="-1" href="#">个人信息</a>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <a tabindex="-1" href="login.html">退出登录</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                        <ul class="nav">
                            <li >
                                                            <a href="#">校友信息管理</a>
                                                        </li>
                        </ul>
                    </div>
                    <!--/.nav-collapse -->
                </div>
            </div>
        </div>
        <div style="margin:0 auto;">
    <div class="span3" id="sidebar" style="width:200px;">
                        <ul class="nav nav-list bs-docs-sidenav nav-collapse collapse" style="margin-top:15px;">
                            <li class="active" >
                                <a href="#"><i class="icon-chevron-right"></i> 校友信息管理</a>
                            </li>
                            <li >
                                <a href="#"><i class="icon-chevron-right"></i> 校友通知管理 </a>
                            </li>
                            <li >
                                <a href="#"><i class="icon-chevron-right"></i> 捐赠发布管理 </a>
                            </li>
                            <li >
                                <a href="#"><i class="icon-chevron-right"></i> 杰出校友管理 </a>
                            </li>
                            <li >
                                <a href="#"><i class="icon-chevron-right"></i> 校友服务管理 </a>
                            </li>

                        </ul>
                    </div>
                    <div class="span12" id="content" style="margin-left:50px;">


                                       <div class="row-fluid">
                                                               <!-- block -->
                                                               <div class="block">
                                                                   <div class="navbar navbar-inner block-header">
                                                                       <div class="muted pull-left">校友信息表格</div>
                                                                   </div>
                                                                   <div class="block-content collapse in">
                                                                       <div class="span12">
                                                                            <div id="example_wrapper" class="dataTables_wrapper form-inline" role="grid">
                                                                                    <div class="span12">
                                                                                        <div id="dataTables_filter" class="example_filter" style="text-align:right">
                                                                                            <label>查找:
                                                                                            <input type="text" aria-controls="example"/>
                                                                                            </label>
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                         									<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
                                       										<thead>
                                       											<tr>
                                       												<th>姓名</th>
                                       												<th>性别</th>
                                       												<th>学号</th>
                                       												<th>专业</th>
                                       												<th>邮箱</th>
                                       												<th>所在地</th>
                                       												<th>查看操作</th>
                                       												<th>删除操作</th>
                                       											</tr>
                                       										</thead>
                                       										<tbody>
                                       											<tr class="odd gradeX">
                                       												<td>陈川</td>
                                       												<td>男</td>
                                       												<td>2013211634</td>
                                       												<td class="center">计算机科学与技术</td>
                                       												<td class="center">chuanchenwine@gmail.com</td>
                                       												<td>重庆</td>
                                       												<td>查看</td>
                                       												<td>删除</td>
                                       											</tr>
                                       										</tbody>
                                       									</table>
                                       									<div id="example_wrapper" class="dataTables_wrapper form-inline" role="grid">
                                       									    <div class="span6">
                                       									        <div class="dataTables_info" id="example_info">每页最多展示十条数据</div>
                                       									    </div>
                                       									    <div class="span6">
                                                                                <div class="dataTables_paginate paging_bootstrap pagination" ">
                                                                                    <ul>
                                                                                        <li class="prev disabled"><a href="#">上一页</a></li>
                                                                                        <li class="active"><a href="#">1</a></li>
                                                                                        <li ><a href="#">2</a></li>
                                                                                        <li ><a href="#">...</a></li>
                                                                                        <li ><a href="#">5</a></li>
                                                                                        <li ><a href="#">6</a></li>
                                                                                        <li class="next"><a href="#">下一页</a></li>
                                                                                    </ul>
                                                                                </div>
                                                                            </div>
                                       									</div>
                                                                       </div>
                                                                   </div>
                                                               </div>
                                                               <!-- /block -->
                                                           </div>

</div>
</div>
</div>
</body>
</html>