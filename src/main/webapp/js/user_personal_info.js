$(function(){
	$('#modify_info').click(function(){
		$('#display_exist').css('display','none');
		$('#display_modify').css('display','block');
	});

    //Date picker
    $('#birthday').datepicker({
      autoclose: true
    });
    $('#entranceAge').datepicker({
    	autoclose: true
    });
    $('#graduteAge').datepicker({
    	autoclose: true
    });
    $('#inductive').datepicker({
    	autoclose: true
    });

    //iCheck for checkbox and radio inputs
    $('input[type="radio"].minimal').iCheck({
      radioClass: 'iradio_minimal-blue'
    });
    $('#re_save').click(function(event){
    	$(this).submit();
    });
    $('#check_info').click(function(){
    	$('#display_exist').css('display','block');
		$('#display_modify').css('display','none');
    });
  });