<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="d" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hurraa Open Source Customer Service</title>
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="<c:url value='/css/default.css'/>" type="text/css">
        <d:head/>
    </head>
    <body>
        <header>
            <h1>Hurraa Open Source Customer Service</h1>
        </header>
        
        <section id="main">
            <d:body/>
        </section>
        
        <footer>
            <span>2014 | All rights reserved</span>
        </footer>
    </body>
</html>
