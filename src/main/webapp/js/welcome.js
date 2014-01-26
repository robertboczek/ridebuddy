$(document).ready(function(){
  $(".post").hover(function(){
    if($(this).hasClass("cursor")){
      $(this).removeClass("cursor");
    }else{
      $(this).addClass("cursor");
    } 
  });
  
  $("#postRide").on('click', function() {
	  var rideTime = $("#rideTime").val();
	  var rideDescription = $("#rideDescription").val();
	  
	  $.ajax({
		  url: "newPost?content=" + rideDescription + "&time=" + rideTime,
		  }).done(function() {
			  $('#addPostModal').modal('hide');
			  $("#postsTable").load("allPosts");
		  });
  });
  
  $("#postsTable").load("allPosts");
  
  $(document).ready(function(){
    $("#rideTime").datetimepicker({format: 'yyyy-mm-dd hh:ii'});
  });
});