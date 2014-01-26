<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<link rel="shortcut icon" href="<c:url value="resources/images/mda.ico" />" />
<link href="<c:url value="resources/bootstrap/css/bootstrap.css"/>" rel="stylesheet">
<!-- <link href="<c:url value="resources/bootstrap/css/bootstrap-datetimepicker.min.css"/>" rel="stylesheet"> -->
<link href="<c:url value="resources/css/custom.css" />" rel="stylesheet">
<link href="<c:url value="resources/datetimepicker/css/bootstrap-datetimepicker.css" />" rel="stylesheet">

<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script type="text/javascript" src="<c:url value="resources/bootstrap/js/bootstrap.min.js"/>"></script>
<!-- <script type="text/javascript" src="<c:url value="resources/bootstrap/js/bootstrap-datetimepicker.js"/>"></script> -->
<script type="text/javascript">
</script>
</head>
<body>
    <div class="layout">
    	<tiles:insertAttribute name="header" ignore="true" />
    	<tiles:insertAttribute name="body" ignore="true" />
    	<tiles:insertAttribute name="footer" ignore="true" />
    </div>
</body>
</html>