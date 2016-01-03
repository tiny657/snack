function isMorePosition() {
	if ($("#more").length > 0) {
		$(window).scroll(function() {
			if ($(window).scrollTop() + $(window).height() > $(document).height() - 10) {
				$(window).unbind('scroll');
				more();
			}
		});
	}
}

function more() {
	$.ajax({
		type : "GET",
		url : "/more",
		dataType: "text",
		data: {"from": $("#oldest").text()},
		success : function(content) {
			$("#more").replaceWith(content);
			isMorePosition();
		}
	});
}
isMorePosition();
