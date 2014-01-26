<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table class="table table-hover">
<c:forEach var="post" items="${posts}">
	<tr class="post">
		<td style="width: 30px;"><img src="${post.userUrl}"></img>&nbsp;${post.userName}</td>
		<td style="width: 30px;">${post.postTime}</td>
		<td>${post.postContent}</td>
		<td style="width: 50px;">
		  <b>0</b>&nbsp;<span class="glyphicon glyphicon-user"></span>
		  <div id="joinPost" class="btn btn-join  join" title="" data-placement="top" data-toggle="tooltip" data-original-title="Join"><span class="glyphicon glyphicon-plus"></span></div>
		</td>
	</tr>
</c:forEach>
</table>

<script type="text/javascript" src="<c:url value="resources/js/allPosts.js"/>"></script>
