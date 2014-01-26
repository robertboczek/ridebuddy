<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Control for Adding New Post -->
<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#addPostModal">
  Add New Post
</button>

<div class="modal fade" id="addPostModal" tabindex="-1" role="dialog" aria-labelledby="AddPostLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="AddPostLabel">New Post</h4>
      </div>
      <div class="modal-body">
        <label for="Input_Details">Date/Time</label>
        <div>
          <input type="datetime" class="form-control" id="rideTime" placeholder="Enter a description!">
        </div>
        <label for="Input_Details">Describe your ride</label>
        <div>
          <textarea class="form-control" rows="3" id="rideDescription"></textarea>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="postRide">Post ride</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<br/>
<div id="postsTable">
</div>

<script type="text/javascript" src="<c:url value="resources/js/welcome.js"/>"></script>
