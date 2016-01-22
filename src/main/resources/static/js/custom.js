(function ($, undefined) {
	$.fn.getCursorPosition = function () {
		var el = $(this).get(0);
		var pos = 0;
		if ('selectionStart' in el) {
			pos = el.selectionStart;
		} else if ('selection' in document) {
			el.focus();
			var Sel = document.selection.createRange();
			var SelLength = document.selection.createRange().text.length;
			Sel.moveStart('character', -el.value.length);
			pos = Sel.text.length - SelLength;
		}
		return pos;
	}
})(jQuery);

Dropzone.options.myDropzone = {
	acceptedFiles: "image/*",
	addRemoveLinks: true,
	dictRemoveFile: "Remove",

	success: function (file, response) {
		var position = $("#content").getCursorPosition()
		var content = $('#content').val();
		var newContent = content.substr(0, position) + response.toString() + content.substr(position);
		$('#content').val(newContent);

		console.log(newContent);
	},
	error: function (file, response) {
		this.removeFile(file);
		alert("Attached file isn't image file.");
	}
}

function fbShare(url) {
	var winTop = (screen.height / 2) - (350 / 2);
	var winLeft = (screen.width / 2) - (520 / 2);
	window.open('http://www.facebook.com/sharer.php?s=100&&p[url]=' + url, 'sharer', 'top=' + winTop + ',left=' + winLeft + ',toolbar=0,status=0,width=520,height=350');
}

function isMorePosition() {
	if ($("#more").length > 0) {
		$(window).scroll(function () {
			if ($(window).scrollTop() + $(window).height() > $(document).height() - 10) {
				$(window).unbind('scroll');
				more();
			}
		});
	}
}

function more() {
	$.ajax({
		type: "GET",
		url: "/more",
		dataType: "text",
		data: {"from": $("#oldest").text()},
		success: function (content) {
			$("#more").replaceWith(content);
			isMorePosition();
		}
	});
}
isMorePosition();
