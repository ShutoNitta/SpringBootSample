'use strict';
 
 jQuery(function($){
	
	$('#btn-salaryInsert').click(function(event){
		insertSalary();
	});
});

function insertSalary(){
	var formData = $('#salary-form').serializeArray();
	
			$.ajax({
				type:"POST",
				cache:false,
				url:'/addSalary/insert',
				data:formData,
				dataType:'json',
			}).done(function(data){
				alert('給与を追加しました');
				window.location.href='/addSalary';
			}).fail(function(jqXHR,textStatus,errorThrown){
				alert('給与追加に失敗しました。');
			}).always(function(){
});
}
