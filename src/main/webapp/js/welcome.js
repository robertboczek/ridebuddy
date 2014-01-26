$(document).ready(function(){
  $(".post").hover(function(){
    if($(this).hasClass("cursor")){
      $(this).removeClass("cursor");
    }else{
      $(this).addClass("cursor");
    } 
  });
  
//  $(".join").on('hover', function() {
//	  alert($(this));
//	  $(this).tooltip('show');
//  });

});