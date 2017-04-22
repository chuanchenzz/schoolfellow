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
                    <div class="span9" id="content">


                                       <div class="row-fluid">
                                                               <!-- block -->
                                                               <div class="block">
                                                                   <div class="navbar navbar-inner block-header">
                                                                       <div class="muted pull-left">Bootstrap dataTables</div>
                                                                   </div>
                                                                   <div class="block-content collapse in">
                                                                       <div class="span12">
                                                                            <div id="example_wrapper" class="dataTables_wrapper form-inline" role="grid">
                                                                                <div class="row" >
                                                                                    <div class="span6" style="margin-right:0px;display:none;">
                                                                                        <div id="dataTables_filter" class="example_filter">
                                                                                            <label>查找:
                                                                                                <input type="text" aria-controls="example"/>
                                                                                            </label>
                                                                                    </div>
                                                                                    </div>
                                                                                    <div class="span6" style="margin-right:0px;>
                                                                                                                                                                            <div id="dataTables_filter" class="example_filter">
                                                                                                                                                                                <label>查找:
                                                                                                                                                                                    <input type="text" aria-controls="example"/>
                                                                                                                                                                                </label>
                                                                                                                                                                        </div>
                                                                                                                                                                        </div>
                                                                                    </div>
                                         									<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
                                       										<thead>
                                       											<tr>
                                       												<th>Rendering engine</th>
                                       												<th>Browser</th>
                                       												<th>Platform(s)</th>
                                       												<th>Engine version</th>
                                       												<th>CSS grade</th>
                                       											</tr>
                                       										</thead>
                                       										<tbody>
                                       											<tr class="odd gradeX">
                                       												<td>Trident</td>
                                       												<td>Internet
                                       													 Explorer 4.0</td>
                                       												<td>Win 95+</td>
                                       												<td class="center"> 4</td>
                                       												<td class="center">X</td>
                                       											</tr>
                                       											<tr class="even gradeC">
                                       												<td>Trident</td>
                                       												<td>Internet
                                       													 Explorer 5.0</td>
                                       												<td>Win 95+</td>
                                       												<td class="center">5</td>
                                       												<td class="center">C</td>
                                       											</tr>
                                       											<tr class="odd gradeA">
                                       												<td>Trident</td>
                                       												<td>Internet
                                       													 Explorer 5.5</td>
                                       												<td>Win 95+</td>
                                       												<td class="center">5.5</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="even gradeA">
                                       												<td>Trident</td>
                                       												<td>Internet
                                       													 Explorer 6</td>
                                       												<td>Win 98+</td>
                                       												<td class="center">6</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="odd gradeA">
                                       												<td>Trident</td>
                                       												<td>Internet Explorer 7</td>
                                       												<td>Win XP SP2+</td>
                                       												<td class="center">7</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="even gradeA">
                                       												<td>Trident</td>
                                       												<td>AOL browser (AOL desktop)</td>
                                       												<td>Win XP</td>
                                       												<td class="center">6</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Gecko</td>
                                       												<td>Firefox 1.0</td>
                                       												<td>Win 98+ / OSX.2+</td>
                                       												<td class="center">1.7</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Gecko</td>
                                       												<td>Firefox 1.5</td>
                                       												<td>Win 98+ / OSX.2+</td>
                                       												<td class="center">1.8</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Gecko</td>
                                       												<td>Firefox 2.0</td>
                                       												<td>Win 98+ / OSX.2+</td>
                                       												<td class="center">1.8</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Gecko</td>
                                       												<td>Firefox 3.0</td>
                                       												<td>Win 2k+ / OSX.3+</td>
                                       												<td class="center">1.9</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Gecko</td>
                                       												<td>Camino 1.0</td>
                                       												<td>OSX.2+</td>
                                       												<td class="center">1.8</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Gecko</td>
                                       												<td>Camino 1.5</td>
                                       												<td>OSX.3+</td>
                                       												<td class="center">1.8</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Gecko</td>
                                       												<td>Netscape 7.2</td>
                                       												<td>Win 95+ / Mac OS 8.6-9.2</td>
                                       												<td class="center">1.7</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Gecko</td>
                                       												<td>Netscape Browser 8</td>
                                       												<td>Win 98SE+</td>
                                       												<td class="center">1.7</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Gecko</td>
                                       												<td>Netscape Navigator 9</td>
                                       												<td>Win 98+ / OSX.2+</td>
                                       												<td class="center">1.8</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Gecko</td>
                                       												<td>Mozilla 1.0</td>
                                       												<td>Win 95+ / OSX.1+</td>
                                       												<td class="center">1</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Gecko</td>
                                       												<td>Mozilla 1.1</td>
                                       												<td>Win 95+ / OSX.1+</td>
                                       												<td class="center">1.1</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Gecko</td>
                                       												<td>Mozilla 1.2</td>
                                       												<td>Win 95+ / OSX.1+</td>
                                       												<td class="center">1.2</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Gecko</td>
                                       												<td>Mozilla 1.3</td>
                                       												<td>Win 95+ / OSX.1+</td>
                                       												<td class="center">1.3</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Gecko</td>
                                       												<td>Mozilla 1.4</td>
                                       												<td>Win 95+ / OSX.1+</td>
                                       												<td class="center">1.4</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Gecko</td>
                                       												<td>Mozilla 1.5</td>
                                       												<td>Win 95+ / OSX.1+</td>
                                       												<td class="center">1.5</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Gecko</td>
                                       												<td>Mozilla 1.6</td>
                                       												<td>Win 95+ / OSX.1+</td>
                                       												<td class="center">1.6</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Gecko</td>
                                       												<td>Mozilla 1.7</td>
                                       												<td>Win 98+ / OSX.1+</td>
                                       												<td class="center">1.7</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Gecko</td>
                                       												<td>Mozilla 1.8</td>
                                       												<td>Win 98+ / OSX.1+</td>
                                       												<td class="center">1.8</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Gecko</td>
                                       												<td>Seamonkey 1.1</td>
                                       												<td>Win 98+ / OSX.2+</td>
                                       												<td class="center">1.8</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Gecko</td>
                                       												<td>Epiphany 2.20</td>
                                       												<td>Gnome</td>
                                       												<td class="center">1.8</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Webkit</td>
                                       												<td>Safari 1.2</td>
                                       												<td>OSX.3</td>
                                       												<td class="center">125.5</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Webkit</td>
                                       												<td>Safari 1.3</td>
                                       												<td>OSX.3</td>
                                       												<td class="center">312.8</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Webkit</td>
                                       												<td>Safari 2.0</td>
                                       												<td>OSX.4+</td>
                                       												<td class="center">419.3</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Webkit</td>
                                       												<td>Safari 3.0</td>
                                       												<td>OSX.4+</td>
                                       												<td class="center">522.1</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Webkit</td>
                                       												<td>OmniWeb 5.5</td>
                                       												<td>OSX.4+</td>
                                       												<td class="center">420</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Webkit</td>
                                       												<td>iPod Touch / iPhone</td>
                                       												<td>iPod</td>
                                       												<td class="center">420.1</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Webkit</td>
                                       												<td>S60</td>
                                       												<td>S60</td>
                                       												<td class="center">413</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Presto</td>
                                       												<td>Opera 7.0</td>
                                       												<td>Win 95+ / OSX.1+</td>
                                       												<td class="center">-</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Presto</td>
                                       												<td>Opera 7.5</td>
                                       												<td>Win 95+ / OSX.2+</td>
                                       												<td class="center">-</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Presto</td>
                                       												<td>Opera 8.0</td>
                                       												<td>Win 95+ / OSX.2+</td>
                                       												<td class="center">-</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Presto</td>
                                       												<td>Opera 8.5</td>
                                       												<td>Win 95+ / OSX.2+</td>
                                       												<td class="center">-</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Presto</td>
                                       												<td>Opera 9.0</td>
                                       												<td>Win 95+ / OSX.3+</td>
                                       												<td class="center">-</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Presto</td>
                                       												<td>Opera 9.2</td>
                                       												<td>Win 88+ / OSX.3+</td>
                                       												<td class="center">-</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Presto</td>
                                       												<td>Opera 9.5</td>
                                       												<td>Win 88+ / OSX.3+</td>
                                       												<td class="center">-</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Presto</td>
                                       												<td>Opera for Wii</td>
                                       												<td>Wii</td>
                                       												<td class="center">-</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Presto</td>
                                       												<td>Nokia N800</td>
                                       												<td>N800</td>
                                       												<td class="center">-</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Presto</td>
                                       												<td>Nintendo DS browser</td>
                                       												<td>Nintendo DS</td>
                                       												<td class="center">8.5</td>
                                       												<td class="center">C/A<sup>1</sup></td>
                                       											</tr>
                                       											<tr class="gradeC">
                                       												<td>KHTML</td>
                                       												<td>Konqureror 3.1</td>
                                       												<td>KDE 3.1</td>
                                       												<td class="center">3.1</td>
                                       												<td class="center">C</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>KHTML</td>
                                       												<td>Konqureror 3.3</td>
                                       												<td>KDE 3.3</td>
                                       												<td class="center">3.3</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>KHTML</td>
                                       												<td>Konqureror 3.5</td>
                                       												<td>KDE 3.5</td>
                                       												<td class="center">3.5</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeX">
                                       												<td>Tasman</td>
                                       												<td>Internet Explorer 4.5</td>
                                       												<td>Mac OS 8-9</td>
                                       												<td class="center">-</td>
                                       												<td class="center">X</td>
                                       											</tr>
                                       											<tr class="gradeC">
                                       												<td>Tasman</td>
                                       												<td>Internet Explorer 5.1</td>
                                       												<td>Mac OS 7.6-9</td>
                                       												<td class="center">1</td>
                                       												<td class="center">C</td>
                                       											</tr>
                                       											<tr class="gradeC">
                                       												<td>Tasman</td>
                                       												<td>Internet Explorer 5.2</td>
                                       												<td>Mac OS 8-X</td>
                                       												<td class="center">1</td>
                                       												<td class="center">C</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Misc</td>
                                       												<td>NetFront 3.1</td>
                                       												<td>Embedded devices</td>
                                       												<td class="center">-</td>
                                       												<td class="center">C</td>
                                       											</tr>
                                       											<tr class="gradeA">
                                       												<td>Misc</td>
                                       												<td>NetFront 3.4</td>
                                       												<td>Embedded devices</td>
                                       												<td class="center">-</td>
                                       												<td class="center">A</td>
                                       											</tr>
                                       											<tr class="gradeX">
                                       												<td>Misc</td>
                                       												<td>Dillo 0.8</td>
                                       												<td>Embedded devices</td>
                                       												<td class="center">-</td>
                                       												<td class="center">X</td>
                                       											</tr>
                                       											<tr class="gradeX">
                                       												<td>Misc</td>
                                       												<td>Links</td>
                                       												<td>Text only</td>
                                       												<td class="center">-</td>
                                       												<td class="center">X</td>
                                       											</tr>
                                       											<tr class="gradeX">
                                       												<td>Misc</td>
                                       												<td>Lynx</td>
                                       												<td>Text only</td>
                                       												<td class="center">-</td>
                                       												<td class="center">X</td>
                                       											</tr>
                                       											<tr class="gradeC">
                                       												<td>Misc</td>
                                       												<td>IE Mobile</td>
                                       												<td>Windows Mobile 6</td>
                                       												<td class="center">-</td>
                                       												<td class="center">C</td>
                                       											</tr>
                                       											<tr class="gradeC">
                                       												<td>Misc</td>
                                       												<td>PSP browser</td>
                                       												<td>PSP</td>
                                       												<td class="center">-</td>
                                       												<td class="center">C</td>
                                       											</tr>
                                       											<tr class="gradeU">
                                       												<td>Other browsers</td>
                                       												<td>All others</td>
                                       												<td>-</td>
                                       												<td class="center">-</td>
                                       												<td class="center">U</td>
                                       											</tr>
                                       										</tbody>
                                       									</table>
                                                                       </div>
                                                                   </div>
                                                               </div>
                                                               <!-- /block -->
                                                           </div>

</div>
</div>

</body>
</html>