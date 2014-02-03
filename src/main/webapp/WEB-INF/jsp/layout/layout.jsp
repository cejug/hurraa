<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="d"
    uri="http://www.opensymphony.com/sitemesh/decorator"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" type="image/x-icon"
    href="<c:url value='/resources/images/logo/16x.png'/>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="page.title" /></title>
<link rel="stylesheet"
    href="<c:url value='/resources/css/pure-min.css'/>" type="text/css">
<link rel="stylesheet"
    href="<c:url value='/resources/css/default.css'/>" type="text/css">
<d:head />
</head>
<body>
    <header>
        <img alt="Home"
            src="<c:url value='/resources/images/logo/64x.png' />"
            style="float: left;">
        <h1>
            <fmt:message key="page.title" />
        </h1>
        <!-- Menu Pure CSS -->
        <div id="demo-horizontal-menu"
            class="pure-menu pure-menu-open pure-menu-horizontal">
            <ul id="std-menu-items">
                <li class="pure-menu-selected"><a
                    href="${linkTo[IndexController].index}"><fmt:message
                            key="menu.home" /></a></li>
                <li><a href="#"><fmt:message key="menu.issues" /></a></li>
                <li><a href="#"><fmt:message
                            key="menu.admin" /></a>
                    <ul>
                        <li><a
                            href="${linkTo[SectorController].index}"><fmt:message
                                    key="menu.admin.sector" /></a></li>
                        <li><a
                            href="${linkTo[EquipmentTypeController].index}"><fmt:message
                                    key="menu.admin.equipmentType" /></a></li>
                        <li><a
                            href="${linkTo[ManufacturerController].index}"><fmt:message
                                    key="menu.admin.manufacturer" /></a></li>
                        <li><a
                            href="${linkTo[CostCenterController].index}"><fmt:message
                                    key="menu.admin.costCenter" /></a></li>
                        <li><a
                            href="${linkTo[UserController].index}"><fmt:message
                                    key="menu.admin.user" /></a></li>
                    </ul></li>
            </ul>
        </div>
    </header>

    <section id="main">
        <d:body />
    </section>

    <footer>
        <span><fmt:message key="page.copyright" /></span>
    </footer>

    <script src="http://yui.yahooapis.com/3.10.1/build/yui/yui-min.js"></script>
    <script>
					YUI({
						classNamePrefix : 'pure'
					}).use('gallery-sm-menu', function(Y) {
						var horizontalMenu = new Y.Menu({
							container : '#demo-horizontal-menu',
							sourceNode : '#std-menu-items',
							orientation : 'horizontal',
							hideOnOutsideClick : false,
							hideOnClick : false
						});

						horizontalMenu.render();
						horizontalMenu.show();

					});
				</script>
</body>
</html>