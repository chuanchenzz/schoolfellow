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
  <title>AdminLTE 2 | Mailbox</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="../../AdminLTE-2.3.11/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- fullCalendar 2.2.5-->
  <link rel="stylesheet" href="../../AdminLTE-2.3.11/plugins/fullcalendar/fullcalendar.min.css">
  <link rel="stylesheet" href="../../AdminLTE-2.3.11/plugins/fullcalendar/fullcalendar.print.css" media="print">
  <!-- Theme style -->
  <link rel="stylesheet" href="../../AdminLTE-2.3.11/dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
  folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="../../AdminLTE-2.3.11/dist/css/skins/_all-skins.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="../../AdminLTE-2.3.11/plugins/iCheck/flat/blue.css">
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
      <a href="../../AdminLTE-2.3.11/index2.html" class="logo">
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
            <!-- Messages: style can be found in dropdown.less-->

            <!-- Notifications: style can be found in dropdown.less -->

            <!-- Tasks: style can be found in dropdown.less -->

            <!-- User Account: style can be found in dropdown.less -->
            <li class="dropdown user user-menu">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                <img src="../../AdminLTE-2.3.11/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
                <span class="hidden-xs">chuanchen</span>
              </a>
              <ul class="dropdown-menu">
                <!-- User image -->
                <li class="user-header">
                  <img src="../../AdminLTE-2.3.11/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                  <p>
                    chuanchen
                    <!-- <small>Member since Nov. 2012</small> -->
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
            <!-- Control Sidebar Toggle Button -->

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
          <li class="treeview active">
            <a href="#">
              <i class="fa fa-dashboard"></i> <span>校友信息管理</span>
              <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
            </a>
            <ul class="treeview-menu">
              <li><a href="/user/findUsers?page=1&limit=15"><i class="fa fa-circle-o"></i> 校友信息表总览</a></li>
            </ul>
          </li>
          <li class="treeview">
            <a href="#">
              <i class="fa fa-pie-chart"></i>
              <span>校友通知管理</span>
              <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
            </a>
            <ul class="treeview-menu">
              <li><a href="/notice/findNotices/1?page=1&limit=15"><i class="fa fa-circle-o"></i> 通知公告管理</a></li>
              <li><a href="/notice/findNotices/2?page=1&limit=15"><i class="fa fa-circle-o"></i> 校友消息管理</a></li>
              <li><a href="/notice/findNotices/3?page=1&limit=15"><i class="fa fa-circle-o"></i> 母校动态管理</a></li>
            </ul>
          </li>
          <li class="treeview">
            <a href="#">
              <i class="fa fa-laptop"></i>
              <span>杰出校友管理</span>
              <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
            </a>
            <ul class="treeview-menu">
              <li><a href="/topAlumnus/findTopAlumnus?page=1&limit=16"><i class="fa fa-circle-o"></i> 杰出校友总览</a></li>
              <li><a href="/topAlumnus/addTopAlumnusPage"><i class="fa fa-circle-o"></i> 添加杰出校友</a></li>
            </ul>
          </li>
          <li class="treeview">
            <a href="#">
              <i class="fa fa-edit"></i> <span>捐赠发布管理</span>
              <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
            </a>
            <ul class="treeview-menu">
              <li><a href="#"><i class="fa fa-circle-o"></i> 捐赠表总览</a></li>
              <li><a href="#"><i class="fa fa-circle-o"></i> 发布捐赠消息</a></li>
              <li><a href="#"><i class="fa fa-circle-o"></i> 捐赠流程</a></li>
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
              <li><a href="#"><i class="fa fa-circle-o"></i> 合作项目</a></li>
              <li><a href="#"><i class="fa fa-circle-o"></i> 招聘信息</a></li>
              <li><a href="#"><i class="fa fa-circle-o"></i> 宣传展示</a></li>
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
          校友信息管理
          <small>校友详细信息</small>
        </h1>
      </section>

      <!-- Main content -->
      <section class="content">
        <div class="row" style="width: 80%;margin: 0 auto;">
          <div class="col-md-12">
            <div class="box box-primary">
              <div class="box-header with-border">
                <h3 class="box-title">校友详细信息</h3>
              </div>
              <form class="form-horizontal">
                <div class="form-group">
                  <label  class="col-sm-3 control-label" style="padding-top: 7px;text-align: right;">姓名:</label>
                  <div class="col-sm-5">
                  <input type="text" class="form-control" name="" disabled value="<c:out value='${alumnus.name}'/>">
                  </div>
                </div>
                <div class="form-group" >
                  <label  class="col-sm-3 control-label" style="padding-top: 7px;text-align: right;">性别:</label>
                  <div class="col-sm-5">
                  <input type="text" class="form-control" name="" disabled value="<c:out value='${alumnus.sex.sex}'/>">
                  </div>
                </div>
                <div class="form-group" >
                  <label  class="col-sm-3 control-label" style="padding-top: 7px;text-align: right;">学号:</label>
                  <div class="col-sm-5">
                  <input type="text" class="form-control" name="" disabled value="<c:out value='${alumnus.studentNumber}'/>">
                  </div>
                </div>
                <div class="form-group" >
                  <label  class="col-sm-3 control-label" style="padding-top: 7px;text-align: right;">民族:</label>
                  <div class="col-sm-5">
                  <input type="text" class="form-control" name="" disabled value="<c:out value='${alumnus.nation.name}'/>">
                  </div>
                </div>
                <div class="form-group" >
                  <label  class="col-sm-3 control-label" style="padding-top: 7px;text-align: right;">政治身份:</label>
                  <div class="col-sm-5">
                  <input type="text" class="form-control" name="" disabled value="<c:out value='${alumnus.identity.name}'/>">
                  </div>
                </div>
                <div class="form-group" >
                  <label  class="col-sm-3 control-label" style="padding-top: 7px;text-align: right;">身份证号:</label>
                  <div class="col-sm-5">
                  <input type="text" class="form-control" name="" disabled value="<c:out value='${alumnus.idCard}'/>">
                  </div>
                </div>
                <div class="form-group" >
                  <label  class="col-sm-3 control-label" style="padding-top: 7px;text-align: right;">出生日期:</label>
                  <div class="col-sm-5">
                  <input type="text" class="form-control" name="" disabled value="<c:out value='${alumnus.birthday}'/>">
                  </div>
                </div>
                 <div class="form-group" >
                  <label  class="col-sm-3 control-label" style="padding-top: 7px;text-align: right;">户籍地:</label>
                  <div class="col-sm-5">
                  <input type="text" class="form-control" name="" disabled value="<c:out value='${alumnus.birthPlace.name}'/>">
                  </div>
                </div>
                 <div class="form-group" >
                  <label  class="col-sm-3 control-label" style="padding-top: 7px;text-align: right;">现居住地址:</label>
                  <div class="col-sm-5">
                  <input type="text" class="form-control" name="" disabled value="<c:out value='${alumnus.address.name}'/>">
                  </div>
                </div>
                 <div class="form-group" >
                  <label  class="col-sm-3 control-label" style="padding-top: 7px;text-align: right;">电话号码:</label>
                  <div class="col-sm-5">
                  <input type="text" class="form-control" name="" disabled value="<c:out value='${alumnus.phone}'/>">
                  </div>
                </div>
                 <div class="form-group" >
                  <label  class="col-sm-3 control-label" style="padding-top: 7px;text-align: right;">邮箱:</label>
                  <div class="col-sm-5">
                  <input type="text" class="form-control" name="" disabled value="<c:out value='${alumnus.email}'/>">
                  </div>
                </div>
                 <div class="form-group" >
                  <label  class="col-sm-3 control-label" style="padding-top: 7px;text-align: right;">学历:</label>
                  <div class="col-sm-5">
                  <input type="text" class="form-control" name="" disabled value="<c:out value='${alumnus.education.name}'/>">
                  </div>
                </div>
                 <div class="form-group" >
                  <label  class="col-sm-3 control-label" style="padding-top: 7px;text-align: right;">入学时间:</label>
                  <div class="col-sm-5">
                  <input type="text" class="form-control" name="" disabled value="<c:out value='${alumnus.entranceAge}'/>">
                  </div>
                </div>
                 <div class="form-group" >
                  <label  class="col-sm-3 control-label" style="padding-top: 7px;text-align: right;">毕业时间:</label>
                  <div class="col-sm-5">
                  <input type="text" class="form-control" name="" disabled value="<c:out value='${alumnus.graduteAge}'/>">
                  </div>
                </div>
                 <div class="form-group" >
                  <label  class="col-sm-3 control-label" style="padding-top: 7px;text-align: right;">学院:</label>
                  <div class="col-sm-5">
                  <input type="text" class="form-control" name="" disabled value="<c:out value='${alumnus.academic}'/>">
                  </div>
                </div>
                 <div class="form-group" >
                  <label  class="col-sm-3 control-label" style="padding-top: 7px;text-align: right;">专业:</label>
                  <div class="col-sm-5">
                  <input type="text" class="form-control" name="" disabled value="<c:out value='${alumnus.profession}'/>">
                  </div>
                </div>
                 <div class="form-group" >
                  <label  class="col-sm-3 control-label" style="padding-top: 7px;text-align: right;">班级:</label>
                  <div class="col-sm-5">
                  <input type="text" class="form-control" name="" disabled value="<c:out value='${alumnus.classs}'/>">
                  </div>
                </div>
                 <div class="form-group" >
                  <label  class="col-sm-3 control-label" style="padding-top: 7px;text-align: right;">工作地点:</label>
                  <div class="col-sm-5">
                  <input type="text" class="form-control" name="" disabled value="<c:out value='${alumnus.workAddress.name}'/>">
                  </div>
                </div>
                 <div class="form-group" >
                  <label  class="col-sm-3 control-label" style="padding-top: 7px;text-align: right;">入职时间:</label>
                  <div class="col-sm-5">
                  <input type="text" class="form-control" name="" disabled value="<c:out value='${alumnus.inductive}'/>">
                  </div>
                </div>
                 <div class="form-group" >
                  <label  class="col-sm-3 control-label" style="padding-top: 7px;text-align: right;">公司名称:</label>
                  <div class="col-sm-5">
                  <input type="text" class="form-control" name="" disabled value="<c:out value='${alumnus.organization}'/>">
                  </div>
                </div>
                 <div class="form-group" >
                  <label  class="col-sm-3 control-label" style="padding-top: 7px;text-align: right;">单位所属行业:</label>
                  <div class="col-sm-5">
                  <input type="text" class="form-control" name="" disabled value="<c:out value='${alumnus.industry.name}'/>">
                  </div>
                </div>
                 <div class="form-group" >
                  <label  class="col-sm-3 control-label" style="padding-top: 7px;text-align: right;">单位性质:</label>
                  <div class="col-sm-5">
                  <input type="text" class="form-control" name="" disabled value="<c:out value='${alumnus.organizationNature.name}'/>">
                  </div>
                </div>
                 <div class="form-group" >
                  <label  class="col-sm-3 control-label" style="padding-top: 7px;text-align: right;">所属单位部门:</label>
                  <div class="col-sm-5">
                  <input type="text" class="form-control" name="" disabled value="<c:out value='${alumnus.department}'/>">
                  </div>
                </div>
                 <div class="form-group" >
                  <label  class="col-sm-3 control-label" style="padding-top: 7px;text-align: right;">工作职位:</label>
                  <div class="col-sm-5">
                  <input type="text" class="form-control" name="" disabled value="<c:out value='${alumnus.job}'/>">
                  </div>
                </div>
                <div class="box-footer" style="text-align: center;">
                  <button type="submit" class="btn btn-primary">确认</button>
                </div>
              </form>
            </div>
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
<script src="../../AdminLTE-2.3.11/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="../../AdminLTE-2.3.11/bootstrap/js/bootstrap.min.js"></script>
<!-- Slimscroll -->
<script src="../../AdminLTE-2.3.11/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="../../AdminLTE-2.3.11/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../../AdminLTE-2.3.11/dist/js/app.min.js"></script>
<!-- iCheck -->
<script src="../../AdminLTE-2.3.11/plugins/iCheck/icheck.min.js"></script>
<!-- Page Script -->
<!-- AdminLTE for demo purposes -->
<script src="../../AdminLTE-2.3.11/dist/js/demo.js"></script>
</body>
</html>
