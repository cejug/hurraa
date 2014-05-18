<%@page import="javax.servlet.jsp.jstl.core.Config"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="d"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="page.title" /> - <fmt:message
		key="page.subtitle" /></title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">

<link rel="shortcut icon" type="image/x-icon"
	href="<c:url value='/resources/images/logo/16x.png'/>" />
<link rel="apple-touch-icon"
	href="<c:url value='/resources/images/logo/64x.png'/>">
<link rel="apple-touch-icon" sizes="76x76"
	href="<c:url value='/resources/images/logo/64x.png'/>">
<link rel="apple-touch-icon" sizes="120x120"
	href="<c:url value='/resources/images/logo/64x.png'/>">
<link rel="apple-touch-icon" sizes="152x152"
	href="<c:url value='/resources/images/logo/64x.png'/>">
<link rel="stylesheet"
	href="<c:url value='/resources/css/default.css'/>" type="text/css">
<link rel="stylesheet"
	href="<c:url value='/resources/libs/bootstrap/css/bootstrap.min.css' />">
<link rel="stylesheet"
	href="<c:url value='/resources/libs/bootstrap/css/bootstrap-theme.min.css' />">
<link rel="stylesheet"
	href="<c:url value='/resources/libs/bootstrap/css/datepicker.css' />">

<script src="<c:url value='/resources/js/lazy-jquery-init.js' />"></script>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

<d:head />
</head>
<body>

	<c:if test="${not empty param.loc}">
		<fmt:setLocale value="${param.loc}" scope="session" />
	</c:if>

	<header id="wrap">
		<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="<c:url value="/" />"> <img
						alt="Home" src="<c:url value='/resources/images/logo/32x.png' />" />
						<fmt:message key="page.title" />
					</a>
				</div>

				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"><fmt:message key="menu.incident" /> <b
								class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="${linkTo[OpenOccurrenceController].form}"><fmt:message
											key="menu.incident.open" /></a></li>
								<li><a href="${linkTo[ListOccurrenceController].list}"><fmt:message
                                            key="menu.incident.list" /></a></li>
							</ul>
						</li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"><fmt:message key="menu.admin" /> <b
								class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="${linkTo[SectorController].index}"><fmt:message
											key="menu.admin.sector" /></a></li>
								<li><a href="${linkTo[EquipmentTypeController].index}"><fmt:message
											key="menu.admin.equipmentType" /></a></li>
								<li><a href="${linkTo[EquipmentModelController].index}"><fmt:message
											key="menu.admin.equipmentModel" /></a></li>
								<li><a href="${linkTo[EquipmentController].index}"><fmt:message
											key="menu.admin.equipment" /></a></li>
								<li><a href="${linkTo[ManufacturerController].index}"><fmt:message
											key="menu.admin.manufacturer" /></a></li>
								<li><a href="${linkTo[OccurrenceStateController].index}"><fmt:message
                                            key="menu.admin.occurrenceState" /></a></li>
								<li><a href="${linkTo[CostCenterController].index}"><fmt:message
											key="menu.admin.costCenter" /></a></li>
								<li><a href="${linkTo[ProblemTypeController].index}"><fmt:message
											key="menu.admin.problemType" /></a></li>
								<li class="divider"></li>
								<li><a href="${linkTo[UserController].index}"><fmt:message
											key="menu.admin.user" /></a></li>

								<li><a
									href="${linkTo[ChangeLocaleController].changeLocale( 'en' , 'US' )}">EN</a></li>
								<li><a
									href="${linkTo[ChangeLocaleController].changeLocale( 'pt' , 'BR' )}">BR</a></li>
							</ul></li>
					</ul>
					<form class="navbar-form navbar-right" action="${linkTo[ListOccurrenceController].find}" 
					    role="search" method="get" >
				        <div class="form-group">
				          <input type="text" name="filter" id="filter"
				                 class="form-control" placeholder="<fmt:message key="occurence.findOccurrence" />">
				        </div>
				        <button type="submit" class="btn btn-default"><fmt:message key="label.find" /></button>
				      </form>
				</div>
			</div>
		</nav>

		<section class="container">
			<d:body />
		</section>
	</header>

	<footer id="footer">
		<div class="container">
			<p class="text-muted">
				<span class="glyphicon glyphicon-copyright-mark"></span>
				<fmt:message key="page.copyright" />
				- <fmt:message key="app.version" />
			</p>
		</div>
	</footer>

	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="<c:url value='/resources/libs/jquery/js/jquery-2.1.0.min.js' />"></script>
	<script
		src="<c:url value='/resources/libs/bootstrap/js/bootstrap.min.js' />"></script>
	<script
		src="<c:url value='/resources/libs/bootstrap/js/bootstrap-datepicker.js' />"></script>
	<script src="<c:url value='/resources/js/webapp-standalone.js' />"></script>
	<script
		src="<c:url value='/resources/js/finish-lazy-jquery-init.js' />"></script>
</body>
</html>