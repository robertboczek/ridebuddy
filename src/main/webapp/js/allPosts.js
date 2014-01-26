$(document).ready(function() {
  $(".joinPost").on("click", function() {
	  var postId = $(this).attr("data-postId");
	  $.ajax({
		  url: "joinRide?postId=" + postId
		  }).done(function() {
			  $("#postsTable").load("allPosts");
		  });
  });
});