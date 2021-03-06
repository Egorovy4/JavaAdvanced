$(document).ready(function() {
	$('.leftmenutrigger').on('click', function(e) {
		$('.side-nav').toggleClass("open");
		e.preventDefault();
	});
});

$("button.product-logout").click(function() {
	$.get("logout", function(data) {
		if (data !== '') {
			var urlContent = window.location.href.split('/');
			var customUrl = '';

			for (var i = 0; i < urlContent.length - 1; i++) {
				customUrl += urlContent[i] + '/';
			}
			customUrl += data;
			window.location = customUrl;
		}
	});
});

var userRole = null;

$(document).ready(function() {
	$.get("user-role", function(data) {
		if (data !== '') {
			userRole = data;
		}
	}).done(function() {
		if (userRole === 'ADMINISTRATOR') {
			$('li.user-bucket-option').hide();
		}
		if (userRole === 'USER') {
			$('li.create-product-option').hide();
		}
	});
});