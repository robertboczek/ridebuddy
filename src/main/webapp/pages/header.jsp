<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-default" role="navigation">
<div id="header">
    <img height="50" style="float:left; border:5px solid green;" src="resources/images/RTG logo small.png" />
    <div class="dropdown userDetails">
        <div class="btn btn-default">
            <a href="myrides">My rides</a>
        </div>
        <div class="btn btn-default">
            <a href="welcome">All posts</a>
        </div>
        <a id="userDetailsDropDown" role="button" data-toggle="dropdown" href="#">
            <c:if test="${not empty user.imgSrc}"><img src="${user.imgSrc}"/></c:if>&nbsp; ${user.firstName} ${user.lastName}<span class="caret"></span>
        </a>
        
        <ul class="dropdown-menu" role="menu" aria-labelledby="userDetailsDropDown">
  			<li role="presentation">
				<a href="account" tabindex="-1" role="menuitem"><span class="glyphicon glyphicon-pencil"></span> my account</a>
			</li>
  			<li class="divider" role="presentation"></li>
    		<li role="presentation">
				<a href="logout" tabindex="-1" role="menuitem"><span class="glyphicon glyphicon-off"></span> logout</a>
			</li>
  		</ul>
    </div>
</div>
</nav>