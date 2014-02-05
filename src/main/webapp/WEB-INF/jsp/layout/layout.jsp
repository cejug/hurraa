<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="d" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="page.title" /></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="shortcut icon" type="image/x-icon" href="<c:url value='/resources/images/logo/16x.png'/>" />
<link rel="stylesheet" href="<c:url value='/resources/css/default.css'/>" type="text/css">
<link rel="stylesheet" href="<c:url value='/resources/libs/bootstrap/css/bootstrap.min.css' />">
<link rel="stylesheet" href="<c:url value='/resources/libs/bootstrap/css/bootstrap-theme.min.css' />">

<d:head />
</head>
<body>
    <div id="wrap">
        <div class="navbar navbar-default navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">
                        <img alt="Home" src="<c:url value='/resources/images/logo/32x.png' />" style="float: left;"> 
                        <fmt:message key="page.title" />
                    </a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="${linkTo[IndexController].index}"><fmt:message key="menu.home" /></a></li>
                        <li><a href="#issues"><fmt:message key="menu.issues" /></a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message key="menu.admin" /> <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="${linkTo[SectorController].index}"><fmt:message key="menu.admin.sector" /></a></li>
                                <li><a href="${linkTo[EquipmentTypeController].index}"><fmt:message key="menu.admin.equipmentType" /></a></li>
                                <li><a href="${linkTo[ManufacturerController].index}"><fmt:message key="menu.admin.manufacturer" /></a></li>
                                <li><a href="${linkTo[CostCenterController].index}"><fmt:message key="menu.admin.costCenter" /></a></li>
                                <li><a href="${linkTo[UserController].index}"><fmt:message key="menu.admin.user" /></a></li>
                            </ul>
                        </li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </div>

        <div class="container">
            <d:body />
        </div>
    </div> 
    <div id="footer">
        <div class="container">
            <p class="text-muted"><fmt:message key="page.copyright" /></p>
        </div>
    </div>
    
    <script src="<c:url value='/resources/libs/jquery/js/jquery-2.1.0.min.js' />"></script>
    <script src="<c:url value='/resources/libs/bootstrap/js/bootstrap.min.js' />"></script>
</body>
</html>