$(function() {
	$("#titles").autocomplete({
		source : function(request, response) {
			$.ajax({
				url : '/moviediary/ajax-get-movies?term=' + request.term,
				success : function(data) {
					response($.map(data, function(item) {
						return {
							value : item.title,
							id : item.id
						};
					}));
				}
			});
		},
		minLength : 3,
		select : function(event, ui) {
			if (ui.item) {
				$("#moviesIds").append($("<option></option>").text(ui.item.value).val(ui.item.id));
				$(this).val('');
				return false;
			}
		}
	});
	$('#genreForm').submit(function() {
		$('#moviesIds').find('option').each(function() {
			$(this).attr('selected', 'selected');
		});
	});
	$('#moviesIds').change(function() {
		var value = $(this).val();
		$('#moviesIds').find('option').each(function() {
			if ($(this).val() == value) {
				$(this).remove();
			}
		});
	});
});