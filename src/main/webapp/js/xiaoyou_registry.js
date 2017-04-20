$(function(){
    $('#btn_submit_baseinfo').click(function(){
        console.log("dsad");
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
            success:function(data){
                var json = $.parseJSON(data);
                if(json.statusCode == 500){
                    alert(json.message);
                    return;
                }else if(json.statusCode == 200){
                    jumpToInfos();
                }
            }
        });
});
function jumpToInfos(){
    $('.account_info').css('display','none');
    $('.fill_account').css('display','block');
    $('#progress_box_2').css('display','none');
    $('#progress_box_3').css('display','block');
}
});