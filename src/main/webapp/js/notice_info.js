$(function(){
	$('#passcheck').click(function(){
		var id = $('#id').val();
		$.ajax({
			type : 'POST',
			url : '/notice/checknotice',
			data : {'status' : 2,'noticeId':id},
			dataType : 'json',
			success : function(data){
				if(data.statusCode == 200){
					$('#checksuccess').css('display','block');
					$('#checksuccess').append('审核成功,审核结果:通过!');
					$('#check').remove();
				}else if(data.statusCode == 404){
					$('#checkfail').css('display','block');
					$('#checkfail').append('审核失败,请重新审核!');
				}
			}
		});
	});
	$('#notpasscheck').click(function(){
		var id = $('#id').val();
		$.ajax({
			type : 'POST',
			url : '/notice/checknotice',
			data : {'status' : 1,'noticeId':id},
			dataType : 'json',
			success : function(data){
				if(data.statusCode == 200){
					$('#checksuccess').css('display','block');
					$('#checksuccess').append('审核成功,审核结果:不通过!');
					$('#check').remove();
				}else if(data.statusCode == 404){
					$('#checkfail').css('display','block');
					$('#checkfail').append('审核失败,请重新审核!');
				}
			}
		});
	});
});