<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page import="com.chuanchen.entity.*" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>校友网后台管理</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="../../../AdminLTE-2.3.11/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="../../../AdminLTE-2.3.11/plugins/iCheck/all.css">
  <!-- bootstrap datepicker -->
  <link rel="stylesheet" href="../../../AdminLTE-2.3.11/plugins/datepicker/datepicker3.css">
  <!-- Bootstrap time Picker -->
  <link rel="stylesheet" href="../../../AdminLTE-2.3.11/plugins/timepicker/bootstrap-timepicker.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- fullCalendar 2.2.5-->
  <link rel="stylesheet" href="../../../AdminLTE-2.3.11/plugins/fullcalendar/fullcalendar.min.css">
  <link rel="stylesheet" href="../../../AdminLTE-2.3.11/plugins/fullcalendar/fullcalendar.print.css" media="print">
  <!-- Theme style -->
  <link rel="stylesheet" href="../../../AdminLTE-2.3.11/dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
  folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="../../../AdminLTE-2.3.11/dist/css/skins/_all-skins.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="../../../AdminLTE-2.3.11/plugins/iCheck/flat/blue.css">
  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">
  <div class="wrapper">

    <header class="main-header">
      <!-- Logo -->
      <a href="../../../AdminLTE-2.3.11/index2.html" class="logo">
        <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"><b>A</b>DMIN</span>
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><b>校友网后台管理</b>系统</span>
      </a>
      <!-- Header Navbar: style can be found in header.less -->
      <nav class="navbar navbar-static-top">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </a>

        <div class="navbar-custom-menu">
          <ul class="nav navbar-nav">
            <li class="dropdown user user-menu">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                <img src="../../../AdminLTE-2.3.11/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
                <span class="hidden-xs">chuanchen</span>
              </a>
              <ul class="dropdown-menu">
                <!-- User image -->
                <li class="user-header">
                  <img src="../../../AdminLTE-2.3.11/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                  <p>
                    chuanchen
                  </p>
                </li>
                <!-- Menu Footer-->
                <li class="user-footer">
                  <div class="pull-left">
                    <a href="#" class="btn btn-default btn-flat">个人信息</a>
                  </div>
                  <div class="pull-right">
                    <a href="#" class="btn btn-default btn-flat">退出登录</a>
                  </div>
                </li>
              </ul>
            </li>
          </ul>
        </div>
      </nav>
    </header>
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">
      <!-- sidebar: style can be found in sidebar.less -->
      <section class="sidebar">


        <!-- /.search form -->
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
          <li class="header">MAIN NAVIGATION</li>
          <li class="treeview">
            <a href="#">
              <i class="fa fa-dashboard"></i> <span>个人信息管理</span>
              <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
            </a>
            <ul class="treeview-menu">
              <li><a href="/user/getSelfInfo"><i class="fa fa-circle-o"></i> 个人信息一览</a></li>
              <li><a href="/user/cityAlumnus?page=1&limit=15"><i class="fa fa-circle-o"></i> 同城校友</a></li>
            </ul>
          </li>
          <li class="treeview active">
            <a href="#">
              <i class="fa fa-pie-chart"></i>
              <span>个人通知管理</span>
              <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
            </a>
            <ul class="treeview-menu">
              <li><a href="/notice/myPublishNotice?page=1&limit=15"><i class="fa fa-circle-o"></i> 已发布通知</a></li>
              <li><a href="/notice/userPulishNoticePage"><i class="fa fa-circle-o"></i> 发布通知</a></li>
            </ul>
          </li>
          <li class="treeview">
            <a href="#">
              <i class="fa fa-edit"></i> <span>个人捐赠管理</span>
              <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
            </a>
            <ul class="treeview-menu">
              <li><a href="/donation/findUserDonations?page=1&limit=15"><i class="fa fa-circle-o"></i> 捐赠历史</a></li>
            </ul>
          </li>
          <li class="treeview">
            <a href="#">
              <i class="fa fa-table"></i> <span>校友服务管理</span>
              <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
            </a>
            <ul class="treeview-menu">
              <li><a href="/project/findPublishProjects?page=1&limit=15"><i class="fa fa-circle-o"></i>已发布校友服务</a></li>
              <li><a href="/project/publishServicePage"><i class="fa fa-circle-o"></i>发布校友服务</a></li>
            </ul>
          </li>
          <li class="treeview">
            <a href="#">
              <i class="fa fa-folder"></i> <span>校友活动</span>
              <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
            </a>
            <ul class="treeview-menu">
              <li><a href="#"><i class="fa fa-circle-o"></i> 线上活动</a></li>
              <li><a href="#"><i class="fa fa-circle-o"></i> 线下活动</a></li>
            </ul>
          </li>
        </ul>
      </section>
      <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
      <!-- Content Header (Page header) -->
      <section class="content-header">
        <h1>
          发布通知历史表
          <small>总共 <c:out value="${count}"/> 条数据</small>
        </h1>
      </section>

      <!-- Main content -->
      <section class="content">
        <div class="row">
          <div class="col-xs-12">
            <div class="box">
              <div class="box-header">
                <h3 class="box-title">发布通知历史表</h3>
              </div>
              <!-- /.box-header -->
              <div class="box-body">
                <div id="example1_wrapper" class="dataTables_wrapper form-inline dt-bootstrap">
                  <div class="row">
                    <div class="col-sm-12" style="text-align: right;">
                      <div class="example1_filter" id="dataTables_filter">
                        <label>Search
                          <input type="search" class="form-control input-sm" placeholder aria-controls="example1">
                        </label>
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-sm-12">
                      <table id="example1" class="table table-bordered table-striped">
                        <thead>
                          <tr>
                            <th>标题</th>
                            <th>发布人编号</th>
                            <th>发布时间</th>
                            <th>发布类型</th>
                            <th>公告状态</th>
                            <th>查看详细信息</th>
                          </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${noticeList}" var="item">
                               <tr class="odd gradeX">
                                <td><c:out value="${item.title}"/></td>
                                <td><c:out value="${item.userId}"/></td>
                                <td><c:out value="${item.pubDate}"/></td>
                                <td><c:out value="${item.type.description}"/></td>
                                <td><c:out value="${item.status.description}"/></td>
                                <td><a href="/notice/noticeinfo/${item.id}">查看</a></td>
                               </tr>
                            </c:forEach>
                      </tbody>
                    </table>
                  </div>
                </div>
                <div class="row">
                  <div class="col-sm-5" style="padding-top: 8px;">
                    <div class="dataTables_info" id="example1_info" role="status" aria-live="polite">每页最多展示15条数据</div>
                  </div>
                  <div class="col-sm-7" style="text-align: right;">
                    <div class="dataTables_paginate paging_simple_numbers" id="example1_paginate">
                      <ul class="pagination">
                        <li class="paginate_button previous disabled" id="example1_previous">
                          <a href="#" aria-controls="example1" data-dt-idx="0" tabindex="0">Previous</a>
                        </li>
                        <li class="paginate_button active">
                          <a href="#" aria-controls="example1" data-dt-idx="1" tabindex="0">1</a>
                        </li>
                        <li class="paginate_button">
                          <a href="#" aria-controls="example1" data-dt-idx="2" tabindex="0">2</a>
                        </li>
                        <li class="paginate_button">
                          <a href="#" aria-controls="example1" data-dt-idx="3" tabindex="0">3</a>
                        </li>
                        <li class="paginate_button">
                          <a href="#" aria-controls="example1" data-dt-idx="4" tabindex="0">4</a>
                        </li>
                        <li class="paginate_button">
                          <a href="#" aria-controls="example1" data-dt-idx="5" tabindex="0">5</a>
                        </li>
                        <li class="paginate_button">
                          <a href="#" aria-controls="example1" data-dt-idx="6" tabindex="0">6</a>
                        </li>
                        <li class="paginate_button next" id="example1_next">
                          <a href="#" aria-controls="example1" data-dt-idx="7" tabindex="0">Next</a>
                        </li>
                      </ul>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.row -->
        </div>
      </div>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <footer class="main-footer">
    <div class="pull-right hidden-xs">
      <b>Version</b> 1.0.0
    </div>
    <strong>Copyright &copy; 2017-2020 chuanchen.</strong> All rights
    reserved.
  </footer>

  <!-- Control Sidebar -->

  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
  immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- jQuery 2.2.3 -->
<script src="../../../AdminLTE-2.3.11/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="../../../AdminLTE-2.3.11/bootstrap/js/bootstrap.min.js"></script>
<!-- Slimscroll -->
<script src="../../../AdminLTE-2.3.11/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="../../../AdminLTE-2.3.11/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../../../AdminLTE-2.3.11/dist/js/app.min.js"></script>
<!-- bootstrap datepicker -->
<script src="../../../AdminLTE-2.3.11/plugins/datepicker/bootstrap-datepicker.js"></script>
<!-- iCheck -->
<script src="../../../AdminLTE-2.3.11/plugins/iCheck/icheck.min.js"></script>
<script src="../../../AdminLTE-2.3.11/dist/js/app.min.js"></script>
<!-- Page Script -->
<!-- AdminLTE for demo purposes -->
<script src="../../../AdminLTE-2.3.11/dist/js/demo.js"></script>
<script src="../../../js/user_personal_info.js"></script>
</body>
</html>
