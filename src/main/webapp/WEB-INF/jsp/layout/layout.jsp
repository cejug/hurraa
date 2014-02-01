<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="d" uri="http://www.opensymphony.com/sitemesh/decorator" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="page.title"/></title>
        <link rel="stylesheet" href="<c:url value='/css/default.css'/>" type="text/css">
        <link rel="stylesheet" href="<c:url value='/css/pure-min.css'/>" type="text/css">
        <d:head/>
    </head>
    <body>
        <header>
            <h1><fmt:message key="page.title"/></h1>
        </header>
        
        <section id="main">
            <d:body/>
        </section>
        
        <footer>
            <span><fmt:message key="page.copyright"/></span>
        </footer>
    </body>
</html>
