<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Control for Adding New Post -->
<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#Modal_AddPost">
  Add New Post
</button>

<div class="modal fade" id="Modal_AddPost" tabindex="-1" role="dialog" aria-labelledby="AddPostLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="AddPostLabel">New Post</h4>
      </div>
      <div class="modal-body">
        <label for="Input_Details">Date/Time</label>
        <div>
          <input type="datetime" class="form-control" id="Input_Details" placeholder="Enter a description!">
        </div>
        <label for="Input_Details">Details</label>
        <div>
          <input type="text" class="form-control" id="Input_Details" placeholder="Enter a description!">
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<div>
<table class="table table-hover">
<c:forEach var="post" items="${posts}">
	<tr class="post">
		<td style="width: 30px;"><img src="${post.userUrl}"></img>&nbsp;${post.userName}</td>
		<td style="width: 30px;">${post.postTime}</td>
		<td>${post.postContent}</td>
		<td style="width: 50px;">
		  <b>0</b>&nbsp;<span class="glyphicon glyphicon-user"></span>
		  <div class="btn btn-primary join" title="" data-placement="top" data-toggle="tooltip" data-original-title="Join"><span class="glyphicon glyphicon-plus"></span></div>
		</td>
	</tr>
</c:forEach>
</table>
</div>

<script type="text/javascript" src="<c:url value="resources/js/welcome.js"/>"></script>
