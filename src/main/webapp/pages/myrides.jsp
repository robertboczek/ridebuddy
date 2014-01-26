<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="ridesTable">
  <header>My Posts</header>
	<table class="table table-hover">
	<c:forEach var="post" items="${myposts}">
	  <tr class="post">
	    <td style="width: 30px;"><img src="${post.userUrl}"></img>&nbsp;${post.userName}</td>
	    <td style="width: 30px;">${post.postTime}</td>
	    <td>${post.postContent}</td>
	    <td style="width: 50px;">
	      <div class="btn btn-danger leave" title="" data-placement="top" data-toggle="tooltip" data-original-title="Leave"><span class="glyphicon glyphicon-minus"></span></div>
	    </td>
	  </tr>
	</c:forEach>
	</table>
	
  <header>My Rides</header>
	<table class="table table-hover">
	<c:forEach var="post" items="${otherposts}">
	  <tr class="post">
	    <td style="width: 30px;"><img src="${post.userUrl}"></img>&nbsp;${post.userName}</td>
	    <td style="width: 30px;">${post.postTime}</td>
	    <td>${post.postContent}</td>
	    <td style="width: 50px;">
	      <div class="btn btn-danger leave" title="" data-placement="top" data-toggle="tooltip" data-original-title="Leave"><span class="glyphicon glyphicon-minus"></span></div>
	    </td>
	  </tr>
	</c:forEach>
	</table>
	
</div>
<script type="text/javascript" src="<c:url value="resources/js/myrides.js"/>"></script>