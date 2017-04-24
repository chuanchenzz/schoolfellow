$(function(){
	function fillAlumnusInfo(data){
		$('#name').val(data.name);
		$('#sex').val(data.sex);
		$('#nation').val(data.nation);
		$('#identity').val(data.identity);
		$('#id_card').val(data.idCard);
		$('#birthday').val(data.birthday);
		$('#birth_place').val(data.birthPlace);
		$('#address').val(data.address);
		$('#phone').val(data.phone);
		$('#email').val(data.email);
		$('#education').val(data.education);
		$('#entry_age').val(data.entranceAge);
		$('#entrance_age').val(data.graduteAge);
		$('#academic').val(data.academic);
		$('#profession').val(data.profession);
		$('#classs').val(data.classs);
		$('#work_place').val(data.workAddress);
		$('#inductive').val(data.inductive);
		$('#organization_nature').val(data.organization);
		$('#department').val(data.department);
		$('#job').val(data.job);
		$('#student_number').val(data.studentNumber);
	}
	$('#info_affirm').click(function(){
		$.ajax({
			type : 'POST',
			data: {},
			url : '',
			success : function(data){
				var json = $.parseJSON(data);
				fillAlumnusInfo(json);
			}
		});
	});
});