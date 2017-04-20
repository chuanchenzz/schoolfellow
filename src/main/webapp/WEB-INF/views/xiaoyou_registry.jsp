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
                        <div class="progress_box">
                            <a class="active" href="#"><img src="<%=basePath %>img/step1active.png" style="height:15px;" />填写校友信息</a>
                            <a class="inactive" href="#"><img src="<%=basePath %>img/step2.png" style="height:15px;" />填写账号密码</a>
                            <a class="inactive" href="#"><img src="<%=basePath %>img/step3.png" style="height:15px;" />完善个人资料</a>
                        </div>
                        <div class="progress_box" id="progress_box_2" style="display:none">
                            <a class="inactive" href="#"><img src="<%=basePath %>img/step1active.png" style="height:15px;" />填写校友信息</a>
                            <a class="active" href="#"><img src="<%=basePath %>img/step2.png" style="height:15px;" />填写账号密码</a>
                            <a class="inactive" href="#"><img src="<%=basePath %>img/step3.png" style="height:15px;" />完善个人资料</a>
                        </div>
                        <div class="progress_box" id="progress_box_3" style="display:none">
                            <a class="inactive" href="#"><img src="<%=basePath %>img/step1active.png" style="height:15px;" />填写校友信息</a>
                            <a class="inactive" href="#"><img src="<%=basePath %>img/step2.png" style="height:15px;" />填写账号密码</a>
                            <a class="active" href="#"><img src="<%=basePath %>img/step3.png" style="height:15px;" />完善个人资料</a>
                        </div>
                    </div>
                </div>
            <div class="right_bottom">
                <div class="part_my">
                    <div id="useredit_form" style="height:500px;">
                        <div class="contlist">
                            <p style="margin-left:70px;">
                                <label>姓名</label>
                                <input type="text" class="text-input input-length-30" id="name" />
                            </p>
                            <p style="margin-left:70px;">
                                <label>学号</label>
                                <input type="text" class="text-input input-length-30" id="student_number" />
                            </p>
                            <p style="margin-left:70px;">
                                <label>入学年份</label>
                                <input type="text" class="text-input input-length-30" id="eduend" />
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
                                <input type="text" class="text-input input-length-30" id="username" />
                            </p>
                            <p style="margin-left:70px;">
                                <label>密码</label>
                                <input type="password" class="text-input input-length-30" id="password" />
                            </p>
                            <p style="margin-left:70px;">
                                <label>重复密码</label>
                                <input type="password" class="text-input input-length-30" id="re_password" />
                            </p>
                            <p class="btn" style="margin-left:200px;margin-top: 50px;">
                                <input type="image" id="btn_submit_account" src="<%=basePath %>img/btn_save.jpg" />
                            </p>
                        </div>
                    </div>
                    <div class="fill_account" style="display:none;margin-top:-20px;">
                        <!--基本信息-->
                        <div class="addr_line" style="border-bottom: 1px solid #fff;font-size:16px; color: #c72730;">
                        基本信息
                        </div>
                        <div class="contlist" style="margin-left:200px;">
                        	<p style="margin-top:30px;">
                        	    <label>姓名</label>
                        	    <input type="text" class="text-input input-length-30" name="user_name" id="user_name" />
                        	    <span class="warn-inline" id="user_name_title" >* </span>
                        	</p>

                        	<p>
                        	    <label>性别</label>
                        	    <input class="radio-input" type="radio"  name="user_sex" value="0" /><span class="radio-text">男</span>
                        	    <input class="radio-input" type="radio"  name="user_sex" value="1" /><span class="radio-text">女</span>
                        	    <span class="warn-inline" id="">* </span>
                        	</p>

                        	<p>
                        	    <label>学号</label>
                        	    <input type="text" class="text-input input-length-30" name="user_stuid" id="user_stuid" />
                        	</p>

                        	<p>
                        	    <label>民族</label>
                        	    <select class="select-option" name="user_race" id="user_race">
                        	    <option value="">请选择</option><option value=1>汉族</option><option value=2>阿昌族</option><option value=3>白族</option><option value=4>保安族</option><option value=5>布朗族</option><option value=6>布依族</option><option value=7>朝鲜族</option><option value=8>达斡尔族</option><option value=9>傣族</option><option value=10>德昂族</option><option value=11>侗族</option><option value=12>东乡族</option><option value=13>独龙族</option><option value=14>鄂伦春族</option><option value=15>俄罗斯族</option><option value=16>鄂温克族</option><option value=17>高山族</option><option value=18>仡佬族</option><option value=19>哈尼族</option><option value=20>哈萨克族</option><option value=21>赫哲族</option><option value=22>回族</option><option value=23>基诺族</option><option value=24>京族</option><option value=25>景颇族</option><option value=26>柯尔克孜族</option><option value=27>拉祜族</option><option value=28>黎族</option><option value=29>傈僳族</option><option value=30>珞巴族</option><option value=31>满族</option><option value=32>毛南族</option><option value=33>门巴族</option><option value=34>蒙古族</option><option value=35>苗族</option><option value=36>仫佬族</option><option value=37>纳西族</option><option value=38>怒族</option><option value=39>普米族</option><option value=40>羌族</option><option value=41>撒拉族</option><option value=42>畲族</option><option value=43>水族</option><option value=44>塔吉克族</option><option value=45>塔塔尔族</option><option value=46>土族</option><option value=47>土家族</option><option value=48>佤族</option><option value=49>维吾尔族</option><option value=50>乌兹别克族</option><option value=51>锡伯族</option><option value=52>瑶族</option><option value=53>彝族</option><option value=54>裕固族</option><option value=55>藏族</option><option value=56>壮族</option>										</select>
                        	    <span class="warn-inline">* </span>
                        	</p>

                        	<p>
                        	    <label>政治面貌</label>
                        	    <select class="select-option" id="user_political" name="user_political">
                        	    <option value="">请选择</option><option value=1>中国共产党</option><option value=2>共青团员</option><option value=3>民革</option><option value=4>民盟</option><option value=5>民建</option><option value=6>民进</option><option value=7>农工党</option><option value=8>致公党</option><option value=9>九三学社</option><option value=10>台盟</option><option value=11>无党派</option><option value=12>群众</option>										</select>
                        	    <span class="warn-inline">* </span>
                        	</p>

                        	<p>
                        	    <label>身份证号</label>
                        	    <input type="text" class="text-input input-length-30" name="user_cardid" id="user_cardid" />
                        	    <span class="warn-inline" id="">* </span>
                        	</p>

                        	<p>
                        	    <label>出生日期</label>
                        	    <input type="text" class="text-input input-length-30" name="user_birth" id="user_birth" />
                        	    <span  class="warn-inline" id="user_birth_title">*    格式为：2013-01-01</span>
                        	</p>

                        	<p>
                        	    <label>籍贯</label>
                        	    <select class="select-option" name="origin_province" id='origin_province'>
                        	    <option value="">请选择</option><option value=1>北京市</option><option value=2>天津市</option><option value=3>上海市</option><option value=4>重庆市</option><option value=5>河北省</option><option value=6>山西省</option><option value=7>台湾省</option><option value=8>辽宁省</option><option value=9>吉林省</option><option value=10>黑龙江省</option><option value=11>江苏省</option><option value=12>浙江省</option><option value=13>安徽省</option><option value=14>福建省</option><option value=15>江西省</option><option value=16>山东省</option><option value=17>河南省</option><option value=18>湖北省</option><option value=19>湖南省</option><option value=20>广东省</option><option value=21>甘肃省</option><option value=22>四川省</option><option value=23>贵州省</option><option value=24>海南省</option><option value=25>云南省</option><option value=26>青海省</option><option value=27>陕西省</option><option value=28>广西壮族自治区</option><option value=29>西藏自治区</option><option value=30>宁夏回族自治区</option><option value=31>新疆维吾尔自治区</option><option value=32>内蒙古自治区</option><option value=33>澳门特别行政区</option><option value=34>香港特别行政区</option>										</select>
                        	    <select style="margin-left: 6px;" class="select-option" id="origin_city" name="origin_city">
                        	    <option selected="selected" value="">请选择</option>
                        	    </select>
                        	    <span class="warn-inline">* </span>
                        	</p>

                        	<p>
                        	    <label>所在城市</label>
                        	    <select class="select-option" name="current_province" id='current_province'>
                        	    <option value="">请选择</option><option value=1>北京市</option><option value=2>天津市</option><option value=3>上海市</option><option value=4>重庆市</option><option value=5>河北省</option><option value=6>山西省</option><option value=7>台湾省</option><option value=8>辽宁省</option><option value=9>吉林省</option><option value=10>黑龙江省</option><option value=11>江苏省</option><option value=12>浙江省</option><option value=13>安徽省</option><option value=14>福建省</option><option value=15>江西省</option><option value=16>山东省</option><option value=17>河南省</option><option value=18>湖北省</option><option value=19>湖南省</option><option value=20>广东省</option><option value=21>甘肃省</option><option value=22>四川省</option><option value=23>贵州省</option><option value=24>海南省</option><option value=25>云南省</option><option value=26>青海省</option><option value=27>陕西省</option><option value=28>广西壮族自治区</option><option value=29>西藏自治区</option><option value=30>宁夏回族自治区</option><option value=31>新疆维吾尔自治区</option><option value=32>内蒙古自治区</option><option value=33>澳门特别行政区</option><option value=34>香港特别行政区</option>										</select>
                        	    <select style="margin-left: 6px;" class="select-option" id="current_city" name="current_city">
                        	    <option selected="selected" value="">请选择</option>
                        	    </select>
                        	    <span class="warn-inline" id="">* </span>
                        	</p>

                        	<p>
                        	    <label>详细地址</label>
                        	    <input type="text" class="text-input input-length-50" name="user_address" id="user_address" />
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
                        	    <input type="text" class="text-input input-length-30" name="user_cellphone" id="user_cellphone" />
                        	    <span class="warn-inline" id="">* </span>
                        	</p>

                        	<p>
                        	    <label>邮箱</label>
                        	    <input type="text" class="text-input input-length-30" name="user_mail" id="user_mail" />
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
                        	    <select name="edu_edulevelid" class="select-option" id=edu_edulevelid>
                        	    <option value=-1>请选择</option><option value=1>大专</option><option value=2>本科</option><option value=3>硕士</option><option value=4>博士</option>										</select>
                        	    <span class="warn-inline" id="">* </span>
                        	</p>

                        	<p>
                        	    <label>入学年份</label>
                        	    <input type="text" class="text-input input-length-30" name="edu_starttime" id="edu_starttime" value=""/>
                        	    <span class="warn-inline" id="time_form">*    格式为：2013</span>
                        	</p>

                        	<p>
                        	    <label>毕业年份</label>
                        	    <input type="text" class="text-input input-length-30" name="edu_endtime" id="edu_endtime" />
                        	    <span class="warn-inline" id="time_form">*    格式为：2013</span>
                        	</p>

                        	<p>
                        	    <label>院(系)</label>
                        	    <input type="text" class="text-input input-length-30" name="edu_department" id="edu_department" />
                        	</p>

                        	<p>
                        	    <label>专业</label>
                        	    <input type="text" class="text-input input-length-30" name="edu_major" id="edu_major" />
                        	    <span class="warn-inline" id="">* </span>
                        	</p>

                        	<p>
                        	<label>班级</label>
                        	    <input type="text" class="text-input input-length-30" name="edu_class" id="edu_class" />
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
                        	    <select class="select-option" name="work_province" id="work_province">
                        	    <option value="">请选择</option><option value=1>北京市</option><option value=2>天津市</option><option value=3>上海市</option><option value=4>重庆市</option><option value=5>河北省</option><option value=6>山西省</option><option value=7>台湾省</option><option value=8>辽宁省</option><option value=9>吉林省</option><option value=10>黑龙江省</option><option value=11>江苏省</option><option value=12>浙江省</option><option value=13>安徽省</option><option value=14>福建省</option><option value=15>江西省</option><option value=16>山东省</option><option value=17>河南省</option><option value=18>湖北省</option><option value=19>湖南省</option><option value=20>广东省</option><option value=21>甘肃省</option><option value=22>四川省</option><option value=23>贵州省</option><option value=24>海南省</option><option value=25>云南省</option><option value=26>青海省</option><option value=27>陕西省</option><option value=28>广西壮族自治区</option><option value=29>西藏自治区</option><option value=30>宁夏回族自治区</option><option value=31>新疆维吾尔自治区</option><option value=32>内蒙古自治区</option><option value=33>澳门特别行政区</option><option value=34>香港特别行政区</option>									  </select>
                        	    <select style="margin-left: 6px;" class="select-option" id="work_city" name="work_city">
                        	    <option selected="selected" value="">请选择</option>
                        	    </select>
                        	    <span class="warn-inline" id="">* </span>
                        	</p>

                        	<p>
                        	    <label>入职年份</label>
                        	    <input type="text" class="text-input input-length-30" name="workexp_starttime" id="workexp_starttime" value=""/>
                        	    <span class="warn-inline" id="time_form">* 格式为：2013</span>
                        	</p>

                        	<p>
                        	    <label>单位名称</label>
                        	    <input type="text" class="text-input input-length-30" name="workexp_companyname" id="workexp_companyname" value=""/>
                        	    <span class="warn-inline" id="">* </span>
                        	</p>

                        	<p>
                        	    <label>所属行业</label>
                        	    <select class="select-option" name="workexp_industry" id="workexp_industry">
                        	    <option value="">请选择</option><option value=1>农、林、牧、渔业</option><option value=2>采矿业</option><option value=3>制造业</option><option value=4>电力、热力、燃气及水生产和供应业</option><option value=5>建筑业</option><option value=6>批发和零售业</option><option value=7>交通运输、仓储和邮政业</option><option value=8>住宿和餐饮业</option><option value=9>信息传输、软件和信息技术服务业</option><option value=10>金融业</option><option value=11>房地产业</option><option value=12>租赁和商务服务业</option><option value=13>科学研究和技术服务业</option><option value=14>水利、环境和公共设施管理业</option><option value=15>居民服务、修理和其他服务业</option><option value=16>教育</option><option value=17>卫生和社会工作</option><option value=18>文化、体育和娱乐业</option><option value=19>公共管理、社会保障和社会组织</option><option value=20>国际组织</option>									  </select>
                        	    <span class="warn-inline" id="">* </span>
                        	</p>
                        	<p>
                        	    <label>单位性质</label>
                        	    <select class="select-option" name="workexp_property" id="workexp_property">
                        	    <option value="">请选择</option><option value=1>国家行政企业事业单位</option><option value=2>公私合作企业事业单位</option><option value=3>中外合资企业事业单位</option><option value=4>社会组织机构</option><option value=5>国际组织机构</option><option value=6>外资企业事业单位</option><option value=7>私营企业事业单位</option><option value=8>集体企业事业单位</option><option value=9>国防军事企业事业单位</option>									  </select>
                        	    <span class="warn-inline" id="">* </span>
                        	</p>

                        	<p>
                        	    <label>部门</label>
                        	    <input type="text" class="text-input input-length-30" name="workexp_depart" id="workexp_depart" />
                        	</p>
                        	<p>
                        	    <label>职位</label>
                        	    <input type="text" class="text-input input-length-30" name="workexp_title" id="workexp_title" />
                        	</p>
                        	</div>
                        	<p class="btn" style="margin-left:350px;margin-top: 50px;margin-bottom:100px;">
                                <input type="image" id="submit" src="<%=basePath %>img/btn_save.jpg" />
                            </p>
                    </div>
                </div>
            </div>
            </div>
        </div>
    </div>
    <div class="clear"></div>
</body>
</html>