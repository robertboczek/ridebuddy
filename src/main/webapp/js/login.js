$(function() {
	var reload = $("#reload");
	
	reload.hover(function() {
        $(this).css('cursor','pointer');
    });
	
	reload.on("click", function() {
		$.ajax({
            url: 'refreshCaptcha',
            cache: false,
            type: 'POST',  
            async: false,
            success: function(){
            	$("#captcha").attr("src","captcha.png" + '?' + Math.random());
            }
		});
	});
});