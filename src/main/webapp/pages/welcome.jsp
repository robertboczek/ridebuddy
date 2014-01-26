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