$(function{
    $('#btn_submit_baseinfo').click(function{
        var name = $('#name').val();
        if(name == '' || name == null){
            alertNotice("请填写姓名!");
            return;
        }
        var studentNumber = $('student_number').val();
        if(studentNumber == '' || studentNumber == null){
            alertNotice("请填写学号!");
            return;
        }
        var entryAge = $('edustart').val();
        if(entryAge == '' || entryAge == null){
            alertNotice("请填写入学年份");
            return;
        }
        $.ajax({
            type:'POST',
            data:{},
            url:'',
            success:function(data){

            }
        });
    })
});
$(function{
    $('#btn_submit_account').click(function{
        var username = $('username').val();
        if(username == '' || username == null){
            alertNotice('请填写用户名!');
            return;
        }
        var password = $('password').val();
        if(password == '' || password == null){
            alertNotice('请填写密码!');
            return;
        }
        var rePassword = $('#re_password').val();
        if(rePassword == '' || rePassword == null){
            alertNotice('请重复所填写的密码!');
            return;
        }
        if(password !== rePassword){
            alertNotice('两次密码填写不一致,请检查!');
            return;
        }
        $.ajax({
            type:'POST',
            data:{},
            url:'',
            success:function(data){

            }
        });
    });
})