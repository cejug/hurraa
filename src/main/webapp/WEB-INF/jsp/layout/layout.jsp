<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="d" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title><fmt:message key="page.title" /></title>
		
		<link rel="shortcut icon" type="image/x-icon" href="<c:url value='/resources/images/logo/16x.png'/>" />
		
		<link rel="stylesheet" href="<c:url value='/resources/libs/bootstrap/css/bootstrap-theme.min.css'/>" type="text/css">
		<link rel="stylesheet" href="<c:url value='/resources/libs/bootstrap/css/bootstrap.min.css'/>" type="text/css">
		
		<!-- Custom styles for hurraa -->
	    <link href="<c:url value="/resources/css/default.css" />" rel="stylesheet">
	
	    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	    <!--[if lt IE 9]>
	      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	    <![endif]-->
		
		<d:head />
	</head>
<body>
    <header>
        
        <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        	<div class="container">
        		<div class="navbar-header">
		          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
		            <span class="sr-only">Toggle navigation</span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		          </button>
		          <a class="navbar-brand" href="<c:url value="/" />">
		          	<img alt="Home" src="<c:url value='/resources/images/logo/32x.png' />" />
		          </a>
		        </div>
		        <div class="navbar-collapse collapse">
		       		<ul class="nav navbar-nav">
						<li class="active">
							<a href="${linkTo[IndexController].index}"><fmt:message key="menu.home" /></a>
						</li>
						<li>
							<a href="#"><fmt:message key="menu.issues" /></a>
						</li>
						<li class="dropdown">
						  <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message key="menu.admin" /> <b class="caret"></b></a>
						  <ul class="dropdown-menu">
						    <li><a href="${linkTo[SectorController].index}"><fmt:message key="menu.admin.sector" /></a></li>
	                        <li><a href="${linkTo[EquipmentTypeController].index}"><fmt:message key="menu.admin.equipmentType" /></a></li>
	                        <li><a href="${linkTo[ManufacturerController].index}"><fmt:message key="menu.admin.manufacturer" /></a></li>
	                        <li><a href="${linkTo[CostCenterController].index}"><fmt:message key="menu.admin.costCenter" /></a></li>
	                        <li class="divider"></li>
	                        <li><a href="${linkTo[UserController].index}"><fmt:message key="menu.admin.user" /></a></li>
						  </ul>
						</li>
					</ul>
				</div>
			</div>
        </nav>
        
    </header>

   	<section class="container">
        <div class="page-header">
            <h1><fmt:message key="page.title" /></h1>
        </div>
        
        <d:body />
   	</section>

    <footer class="container">
    	<div class="pull-right row">
	    	<span class="glyphicon glyphicon-copyright-mark"></span>
	        <span><fmt:message key="page.copyright" /></span>
        </div>
    </footer>

	<!-- Placed at the end of the document so the pages load faster -->
	<script src="<c:url value='/resources/libs/jquery-2.1.0.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/libs/bootstrap/js/bootstrap.min.js" />"></script>
</body>
</html>