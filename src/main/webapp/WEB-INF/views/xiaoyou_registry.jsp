<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html><!--Bootstrap 使用到的某些 HTML 元素和 CSS 属性需要将页面设置为 HTML5 文档类型-->
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>校友注册-cqupt</title>
    <link rel="stylesheet" href="<%=basePath %>css/xiaoyou_registry.css" type= "text/css">
    <script type="text/javascript" src="<%=basePath %>bootstrap-3.3.7-dist/js/jquery-3.1.1.js"></script>
    <script type="text/javascript" src="<%=basePath %>js/xiaoyou_registry.js"></script>
</head>
<body>
    <div id="wapper">
        <div id="header" class="headerBox">
            <div class="content">
                <div class="logo">
                    <a href="http://www.baidu.com"><img src="<%=basePath %>img/cqupt_title.jpg" class="logoxy"></a>
                </div>
                <div class="nav">
                    <a href="#">学校官网</a>
                    <a href="#">校友网</a>
                    <a id="register" href="#" class="active">校友注册</a>
                    <a href="#" class="help">注册帮助</a>
                </div>
            </div>
        </div>
        <div id="mainBox">
            <div id="mypage">
                <div class="useredit_center">
                    <div class="right_menu">
                        <div id="centertitle"><div id="titlecontent">校友注册</div></div>
                        <div id="ulmenu">
                            <div class="progress_box" id="progress_box_1">
                                <a class="active" href="#"><img id="1_step_1" src="<%=basePath %>img/step1active.png" style="height:15px;" />填写校友信息</a>
                                <a class="inactive" href="#"><img id="1_step_2" src="<%=basePath %>img/step2.png" style="height:15px;" />填写账号密码</a>
                                <a class="inactive" href="#"><img id="1_step_3" src="<%=basePath %>img/step3.png" style="height:15px;" />完善个人资料</a>
                            </div>
                            <div class="progress_box" id="progress_box_2" style="display:none">
                                <a class="inactive" href="#"><img id="2_step_1" src="<%=basePath %>img/step1active.png" style="height:15px;" />填写校友信息</a>
                                <a class="active" href="#"><img id="2_step_2" src="<%=basePath %>img/step2.png" style="height:15px;" />填写账号密码</a>
                                <a class="inactive" href="#"><img id="2_step_3" src="<%=basePath %>img/step3.png" style="height:15px;" />完善个人资料</a>
                            </div>
                            <div class="progress_box" id="progress_box_3" style="display:none">
                                <a class="inactive" href="#"><img id="3_step_1" src="<%=basePath %>img/step1active.png" style="height:15px;" />填写校友信息</a>
                                <a class="inactive" href="#"><img id="3_step_2" src="<%=basePath %>img/step2.png" style="height:15px;" />填写账号密码</a>
                                <a class="active" href="#"><img id="3_step_3" src="<%=basePath %>img/step3.png" style="height:15px;" />完善个人资料</a>
                            </div>
                        </div>
                    </div>
                    <div class="right_bottom">
                        <div class="part_my">
                            <div id="useredit_form" style="height:500px;">
                                <div class="contlist">
                                    <p style="margin-left:70px;">
                                        <label>姓名</label>
                                        <input type="text" class="text-input input-length-30" id="name" value="陈川" />
                                    </p>
                                    <p style="margin-left:70px;">
                                        <label>学号</label>
                                        <input type="text" class="text-input input-length-30" id="student_number" value="2013211634"/>
                                    </p>
                                    <p style="margin-left:70px;">
                                        <label>入学年份</label>
                                        <input type="text" class="text-input input-length-30" id="eduend" value="2013-09-21"/>
                                    </p>
                                    <p class="btn" style="margin-left:200px;margin-top: 50px;">
                                        <input type="image" id="btn_submit_baseinfo" src="<%=basePath %>img/btn_save.jpg" alt="submit"/>
                                    </p>
                                </div>
                            </div>
                            <div class="account_info" style="display:none;height:500px">
                                <div class="contlist">
                                    <p style="margin-left:70px;">
                                        <label>用户名</label>
                                        <input type="text" class="text-input input-length-30" id="username" value="chuanchen"/>
                                    </p>
                                    <p style="margin-left:70px;">
                                        <label>密码</label>
                                        <input type="password" class="text-input input-length-30" id="password" value="cc1016"/>
                                    </p>
                                    <p style="margin-left:70px;">
                                        <label>重复密码</label>
                                        <input type="password" class="text-input input-length-30" id="re_password" value="cc1016"/>
                                    </p>
                                    <p class="btn" style="margin-left:200px;margin-top: 50px;">
                                        <input type="image" id="btn_submit_account" src="<%=basePath %>img/btn_save.jpg" />
                                    </p>
                                </div>
                            </div>
                            <div class="fill_account" style="display:none;margin-top:-20px;">
                            <form action="/user/register" method="post" enctype="multipart/form-data">
                                <!--基本信息-->
                                <div class="addr_line" style="border-bottom: 1px solid #fff;font-size:16px; color: #c72730;">
                                    基本信息
                                </div>
                                <div class="contlist" style="margin-left:200px;">
                                   <p style="margin-top:30px;">
                                       <label>姓名</label>
                                       <input type="text" class="text-input input-length-30" name="name" id="user_name" value="陈川"/>
                                       <span class="warn-inline" id="user_name_title" >* </span>
                                   </p>

                                   <p>
                                       <label>性别</label>
                                       <input class="radio-input" type="radio"  name="sex" value="1" /><span class="radio-text">男</span>
                                       <input class="radio-input" type="radio"  name="sex" value="2" /><span class="radio-text">女</span>
                                       <span class="warn-inline" id="">* </span>
                                   </p>
                                   <p>
                                       <label>头像</label>
                                       <input type="file" class="text-input input-length-30" name="avatar" id="user_avatar" />
                                       <span class="warn-inline" id="">* </span>
                                   </p>

                                   <p>
                                       <label>学号</label>
                                       <input type="text" class="text-input input-length-30" name="student_number" id="user_stuid" value="2013211634"/>
                                   </p>

                                   <p>
                                       <label>民族</label>
                                       <select class="select-option" name="nation" id="user_race">
                                           <option value="">请选择</option>									
                                        </select>
                                           <span class="warn-inline">* </span>
                                       </p>

                                       <p>
                                           <label>政治面貌</label>
                                           <select class="select-option" id="user_political" name="identity">
                                               <option value="">请选择</option>	
                                            </select>
                                               <span class="warn-inline">* </span>
                                           </p>

                                           <p>
                                               <label>身份证号</label>
                                               <input type="text" class="text-input input-length-30" name="idCard" id="user_cardid" value="500382199410167453"/>
                                               <span class="warn-inline" id="">* </span>
                                           </p>

                                           <p>
                                               <label>出生日期</label>
                                               <input type="text" class="text-input input-length-30" name="birthday" id="user_birth" value="1994-10-16"/>
                                               <span  class="warn-inline" id="user_birth_title">*    格式为：2013-01-01</span>
                                           </p>

                                           <p>
                                               <label>籍贯</label>
                                               <select class="select-option" name="birthPlace" id='origin_province'>
                                                   <option value="">请选择</option>
                                               </select>
                                               <span class="warn-inline">* </span>
                                           </p>

                                           <p>
                                               <label>所在城市</label>
                                               <select class="select-option" name="address" id='current_province'>
                                                   <option value="">请选择</option>
                                               </select>
                                               <span class="warn-inline" id="">* </span>
                                           </p>
                                       </div>

                                       <!--联系信息-->
                                       <br></br>
                                       <div class="addr_line" style="border-bottom: 1px solid #fff;font-size:16px; color: #c72730;">
                                           联系信息
                                       </div>

                                       <div class="contlist" style="margin-left:200px;">
                                           <p>
                                               <label>手机</label>
                                               <input type="text" class="text-input input-length-30" name="phone" id="user_cellphone" value="18996474255"/>
                                               <span class="warn-inline" id="">* </span>
                                           </p>

                                           <p>
                                               <label>邮箱</label>
                                               <input type="text" class="text-input input-length-30" name="email" id="user_mail" value="chuanchenzz@163.com"/>
                                               <span class="warn-inline" id="">*</span>
                                           </p>

                                       </div>

                                       <!--教育经历-->
                                       <br></br>

                                       <div class="addr_line" style="border-bottom: 1px solid #fff;font-size:16px; color: #c72730;">
                                           教育经历
                                       </div>

                                       <div class="contlist" style="margin-left:200px;">
                                           <p>
                                               <label>学历</label>
                                               <select name="education" class="select-option" id="edu_edulevelid">
                                                   <option value=-1>请选择</option>
                                                </select>
                                                   <span class="warn-inline" id="">* </span>
                                               </p>

                                               <p>
                                                   <label>入学时间</label>
                                                   <input type="text" class="text-input input-length-30" name="entranceAge" id="edu_starttime" value="2013-01-01"/>
                                                   <span class="warn-inline" id="time_form">*    格式为：2013-01-01</span>
                                               </p>

                                               <p>
                                                   <label>毕业时间</label>
                                                   <input type="text" class="text-input input-length-30" name="graduteAge" id="edu_endtime" value="2017-01-01"/>
                                                   <span class="warn-inline" id="time_form">*    格式为：2013-01-01</span>
                                               </p>
                                               <p>
                                                <label>辅导员</label>
                                                <input type="text" class="text-input input-length-30" name="instructor" id="instructor" value="田津舟"/>
                                                <span class="warn-inline" id="">* </span>
                                            </p>
                                            <p>
                                               <label>院(系)</label>
                                               <input type="text" class="text-input input-length-30" name="academic" id="edu_department" value="计算机"/>
                                           </p>

                                           <p>
                                               <label>专业</label>
                                               <input type="text" class="text-input input-length-30" name="profession" id="edu_major" value="计算机"/>
                                               <span class="warn-inline" id="">* </span>
                                           </p>

                                           <p>
                                               <label>班级</label>
                                               <input type="text" class="text-input input-length-30" name="classs" id="edu_class" value="0411302"/>
                                               <span class="warn-inline" id="">* </span>
                                           </p>
                                       </div>

                                       <!--当前工作情况-->
                                       <br></br>
                                       <div class="addr_line" style="border-bottom: 1px solid #fff;font-size:16px; color: #c72730;">
                                           当前工作情况
                                       </div>

                                       <div class="contlist" style="margin-left:200px;">
                                           <p>
                                               <label>工作城市</label>
                                               <select class="select-option" name="workAddress    " id="work_province">
                                                   <option value="">请选择</option>
                                               </select>
                                               <span class="warn-inline" id="">* </span>
                                           </p>

                                           <p>
                                               <label>入职时间</label>
                                               <input type="text" class="text-input input-length-30" name="inductive" id="workexp_starttime" value="2017-01-01"/>
                                               <span class="warn-inline" id="time_form">* 格式为：2013-01-01</span>
                                           </p>

                                           <p>
                                               <label>单位名称</label>
                                               <input type="text" class="text-input input-length-30" name="organization" id="workexp_companyname" value="sohu"/>
                                               <span class="warn-inline" id="">* </span>
                                           </p>

                                           <p>
                                               <label>所属行业</label>
                                               <select class="select-option" name="industry" id="workexp_industry">
                                                   <option value="">请选择</option>
                                                </select>
                                                   <span class="warn-inline" id="">* </span>
                                               </p>
                                               <p>
                                                   <label>单位性质</label>
                                                   <select class="select-option" name="organizationNature" id="workexp_property">
                                                       <option value="">请选择</option>
                                                    </select>
                                                       <span class="warn-inline" id="">* </span>
                                                   </p>

                                                   <p>
                                                       <label>部门</label>
                                                       <input type="text" class="text-input input-length-30" name="department" id="workexp_depart" value="mp"/>
                                                   </p>
                                                   <p>
                                                       <label>职位</label>
                                                       <input type="text" class="text-input input-length-30" name="job" id="workexp_title" value="后台"/>
                                                   </p>
                                               </div>
                                               <p class="btn" style="margin-left:350px;margin-top: 50px;margin-bottom:100px;">
                                                <input type="submit" id="submit" src="<%=basePath %>img/btn_save.jpg" />
                                            </p>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="clear"></div>
                </body>
                </html>