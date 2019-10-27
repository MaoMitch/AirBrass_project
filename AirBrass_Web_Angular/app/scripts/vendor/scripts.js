$(function() {
	/*$('#navbar').affix({
		offset: {
			top: 200
		}
	});*/

	$("pre.html").snippet("html", {style:'matlab'});
	$("pre.css").snippet("css", {style:'matlab'});
	$("pre.javascript").snippet("javascript", {style:'matlab'});

	$('#easyPaginate').easyPaginate({
		elementsPerPage: 3,
		effect: 'climb'
	});
});