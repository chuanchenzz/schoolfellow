$(function(){
    $('#btn_submit_baseinfo').click(function(){
        var name = $('#name').val();
        if(name == '' || name == null){
            alert("请填写姓名!");
            return;
        }
        var studentNumber = $('#student_number').val();
        if(studentNumber == '' || studentNumber == null){
            alert("请填写学号!");
            return;
        }
        var entryAge = $('#eduend').val();
        if(entryAge == '' || entryAge == null){
            alert("请填写入学年份");
            return;
        }
        $.ajax({
            type:'POST',
            data:{'name':name,'student_number':studentNumber,'start_age':entryAge},
            url:'/user/checkaccount',
            success:function(data){
                var json = $.parseJSON(data);
                if(json.statusCode == 200){
                    jumpToAccount();
                }else if(json.statusCode == 500){
                    alert(json.message);
                }
            }
        });
    });
function jumpToAccount(){
    $('.account_info').css('display','block');
    $('#useredit_form').css('display','none');
    $('.progress_box').css('display','none');
    $('#progress_box_2').css('display','block');
    $('#2_step_1').attr('src','/img/step1gray.png');
    $('#2_step_2').attr('src','/img/step2active.png');
}
$('#btn_submit_account').click(function(){

        var username = $('#username').val();
        if(username == '' || username == null){
            alert('请填写用户名!');
            return;
        }
        var password = $('#password').val();
        if(password == '' || password == null){
            alert('请填写密码!');
            return;
        }
        var rePassword = $('#re_password').val();
        if(rePassword == '' || rePassword == null){
            alert('请重复所填写的密码!');
            return;
        }
        if(password !== rePassword){
            alert('两次密码填写不一致,请检查!');
            return;
        }
        $.ajax({
            type:'POST',
            data:{'userName':username,'password':password},
            url:'/user/adduser',
            dataType:'json',
            success:function(data){
                alert(data);
                if(data.statusCode == 500){
                    alert(json.message);
                    return;
                }else if(data.statusCode == 200){
                    jumpToInfos(data);
                }
            }
        });
});
function jumpToInfos(data){
    $('.account_info').css('display','none');
    $('.fill_account').css('display','block');
    $('#progress_box_2').css('display','none');
    $('#progress_box_3').css('display','block');
    $('#3_step_1').attr('src','/img/step1gray.png');
    $('#3_step_2').attr('src','/img/step2.png');
    $('#3_step_3').attr('src','/img/step3active.png');
    var addressList = data.mapParams.addressList;
    var nationList = data.mapParams.nationList;
    var academicList = data.mapParams.academicList;
    var industryList = data.mapParams.industryList;
    var identifyList = data.mapParams.identifyList;
    var natureList = data.mapParams.natureList;
    var appendStr = '';
    for(var i = 0;i < addressList.length;i++){
        appendStr += "<option value='"+addressList[i].name+"'>"+addressList[i].name+"</option>";
    }
    $('#current_province').append(appendStr);
    $('#origin_province').append(appendStr);
    $('#work_province').append(appendStr);
    appendStr = '';
    for(var i = 0;i < nationList.length;i++){
        appendStr += "<option value='"+nationList[i].name+"'>"+nationList[i].name+"</option>";
    }
    $('#user_race').append(appendStr);
    appendStr = '';
    for(var i = 0;i < academicList.length;i++){
        appendStr += "<option value='"+academicList[i].name+"'>"+academicList[i].name+"</option>";
    }
    $('#edu_edulevelid').append(appendStr);
    appendStr = '';
    for(var i = 0;i < industryList.length;i++){
        appendStr += "<option value='"+industryList[i].name+"'>"+industryList[i].name+"</option>";
    }
    $('#workexp_industry').append(appendStr);
    appendStr = '';
    for(var i = 0;i < identifyList.length;i++){
        appendStr += "<option value='"+identifyList[i].name+"'>"+identifyList[i].name+"</option>";
    }
    $('#user_political').append(appendStr);
    appendStr = '';
    for(var i = 0;i < natureList.length;i++){
        appendStr += "<option value='"+natureList[i].name+"'>"+natureList[i].name+"</option>";
    }
    $('#workexp_property').append(appendStr);
}
// $('#submit').click(function(){
//     var name = $('#user_name').val();
//     if(name == '' || name == null){
//         alert("名字不能为空!");
//         return;
//     }
//     var sex = $('input:radio[name="user_sex"]:checked').val();
//     if(sex == '' || sex == null){
//         alert("请选择性别!");
//         return;
//     }
//     var studentNumber = $('#user_stuid').val();
//     if(studentNumber == '' || studentNumber == null){
//         alert("学号不能为空!");
//         return;
//     }
//     var nation = $("select[name=user_race] option:selected").text();
//     if(nation == '请选择' || nation == null){
//         alert("请选择民族!");
//         return;
//     }
//     var identify = $("select[name=user_political] option:selected").text();
//     if(identify == "请选择" || identify == null){
//         alert("请选择政治面貌!");
//         return;
//     }
//     var idCard = $('#user_cardid').val();
//     if(idCard == '' || idCard == null){
//         alert("请填写身份证号!");
//         return;
//     }
//     var birthday = $('#user_birth').val();
//     if(birthday == '' || birthday == null){
//         alert("请填写出生日期!");
//         return;
//     }
//     var birthPlace = $('select[name=origin_province] option:selected').text();
//     if(birthPlace == "请选择" || birthPlace == null){
//         alert("请选择籍贯!");
//         return;
//     }
//     var address = $('select[name=current_province] option:selected').text();
//     if(address == '请选择' || address == null){
//         alert("请选择所在城市!");
//         return;
//     }
//     var phone = $('#user_cellphone').val();
//     if(phone == '' || phone == null){
//         alert("请填写手机号!");
//         return;
//     }
//     var email = $('#user_mail').val();
//     if(email == '' || email == null){
//         alert("请填写邮箱!");
//         return;
//     }
//     var education = $('select[name=edu_edulevelid] option:selected').text();
//     if(education == '请选择' || education == null){
//         alert("请选择学历!");
//         return;
//     }
//     var entranceAge = $('#edu_starttime').val();
//     if(entranceAge == '' || entranceAge == null){
//         alert("请填写入学时间!");
//         return;
//     }
//     var graduteAge = $('#edu_endtime').val();
//     if(graduteAge == '' || graduteAge == null){
//         alert('请填写毕业时间!');
//         return;
//     }
//     var academic = $('#edu_department').val();
//     if(academic == '' || academic == null){
//         alert("请填写院系!");
//         return;
//     }
//     var profession = $('#edu_major').val();
//     if(profession == '' || profession == null){
//         alert('请填写专业!');
//         return;
//     }
//     var classs = $('#edu_class').val();
//     if(classs == '' || classs == null){
//         alert('请填写班级!');
//         return;
//     }
//     var workAddress = $('select[name=work_province] option:selected').text();
//     if(workAddress == "请选择" || workAddress == null){
//         alert("请选择工作城市!");
//         return;
//     }
//     var inductiveAge = $('#workexp_starttime').val();
//     if(inductiveAge == '' || inductiveAge == null){
//         alert("请填写入职时间!");
//         return;
//     }
//     var organization = $('#workexp_companyname').val();
//     if(organization == '' || organization == null){
//         alert("请填写单位名称!");
//         return;
//     }
//     var industry = $('select[name=workexp_industry] option:selected').text();
//     if(industry == "请选择" || industry == null){
//         alert("请选择所属行业!");
//         return;
//     }
//     var organizationNature = $('select[name=workexp_property] option:selected').text();
//     if(organizationNature == "请选择" || organizationNature == null){
//         alert("请选择单位性质!");
//         return;
//     }
//     var department = $('#workexp_depart').val();
//     if(department == '' || department == null){
//         alert("请填写部门!");
//         return;
//     }
//     var job = $('#workexp_title').val();
//     if(job == '' || job == null){
//         alert("请填写职位!");
//         return;
//     }
// });
});