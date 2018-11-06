/**
 * 
 */

$(function(){
	
	$('.chkAll').click(function(){
		$('input[type=checkbox]').prop('checked', true);
	});
	
	$('.unchkAll').click(function(){
		$('input[type=checkbox]').prop('checked', false);
	});
	
});