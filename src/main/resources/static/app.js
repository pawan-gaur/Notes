$(document).ready(function(){
	$('.nBtn, .table .eBtn').on('click', function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		var text = $(this).text();
		if(text == 'Edit'){
			$.get(href, function(notes, status){
				$('.myForm #id').val(notes.id);
				$('.myForm #title').val(notes.title);
				$('.myForm #description').val(notes.description);
			});
			$('.myForm #exampleModal').modal();
		} else{
			$('.myForm #id').val('');
			$('.myForm #title').val('');
			$('.myForm #description').val('');
			$('.myForm #exampleModal').modal();
		}
	});
	
	$('.table .delBtn').on('click', function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$('#myModal #delRef').attr('href', href);
		$('#myModal').modal();
	});
});