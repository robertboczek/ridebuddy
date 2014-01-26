<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="ridesTable">
  <div style="padding-top: 20px;margin-top: 20px;"><h2  style="font-size: 18px; " class="label label-success">Ride I created</h2></div>
  	<c:if test="${myposts.size() == 0}">
	  <div style="margin-top: 10px; margin-bottom: 25px; font-size: 16px; "><h2 class="label label-default">You have not posted any rides yet</h2></div>
	</c:if>
    <c:if test="${myposts.size() > 0}">
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
	</c:if>   
	
  <div style="padding-bottom: 10px;"><h2 class="label label-success " style="font-size: 18px; ">Rides I joined</h2></div>
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
