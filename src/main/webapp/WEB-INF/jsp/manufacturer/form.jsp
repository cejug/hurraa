<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cejug"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="manufacturer.form.insert" /></title>
    </head>

    <body>
        <c:if test="${not empty manufacturer or manufacturer.id != null}">
            <c:set var="action" value="${linkTo[ManufacturerController].update}" />
        </c:if>
        <c:if test="${empty manufacturer or manufacturer.id == null}">
            <c:set var="action" value="${linkTo[ManufacturerController].insert}" />
        </c:if>

        <form action="${action}" method="post">
            <cejug:textField name="manufacturer.name"
            value="${manufacturer.name }" errorsMap="${errors}"/>
        <br />
            <input name="manufacturer.id" value="${manufacturer.id }"
            type="hidden" />
        <button type="submit" class="pure-button">
            <fmt:message key="manufacturer.form.submit" />
        </button>
        </form>
    </body>
</html>