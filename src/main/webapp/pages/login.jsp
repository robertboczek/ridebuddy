<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript" src="<c:url value="resources/js/login.js"/>"></script>
<div class="login">
	<div class="logo">
    	<img src="resources/images/logo.png" />
	</div>
	<div class="well">
    <table class="loginLabelTable">
    <tr>
      <td>
        <h2>Log in</h2>
      </td>
      <td class="loginWithFb">
        <a href="http://www.facebook.com/dialog/oauth/?client_id=204946226368181&redirect_uri=http://ec2-50-16-158-177.compute-1.amazonaws.com:8080/ridebuddy/fbLogin&scope=email,read_friendlists&state=RANDOM_NUMBER">
	  	    <img src="resources/images/fbLogin.png"/>
	  	</a>
	  </td>
	</tr>
	</table>
	</div>
</div>
