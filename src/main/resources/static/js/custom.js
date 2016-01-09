function fbShare(url) {
	var winTop = (screen.height / 2) - (350 / 2);
	var winLeft = (screen.width / 2) - (520 / 2);
	window.open('http://www.facebook.com/sharer.php?s=100&&p[url]=' + url, 'sharer', 'top=' + winTop + ',left=' + winLeft + ',toolbar=0,status=0,width=520,height=350');
}

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
