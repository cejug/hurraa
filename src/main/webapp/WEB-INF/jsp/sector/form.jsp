<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cejug"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="sector.form.insert" /></title>
</head>
<body>
    <c:if test="${not empty sector or sector.id != null}">
        <c:set var="action" value="${linkTo[SectorController].update}" />
        <fmt:message key='sector.form.update' var="formTitle" />
    </c:if>
    <c:if test="${empty sector or sector.id == null}">
        <c:set var="action" value="${linkTo[SectorController].insert}" />
        <fmt:message key='sector.form.insert' var="formTitle" />
    </c:if>

    <div class="page-header">
        <h1>
            <small><c:out value="${formTitle}" /></small>
        </h1>
    </div>

    <div style="width: 50%;">
        <form class="form-horizontal" role="form" action="${action}"
            method="post">

            <cejug:textFieldVertical type="text" name="sector.name"
                value="${sector.name }" errorsMap="${errors}" autoFocus="true" />
            <cejug:textFieldVertical type="email" name="sector.email"
                value="${sector.email}" errorsMap="${errors}" />
            <cejug:singleCheckboxField name="sector.respondsOccurrence"
                value="${sector.respondsOccurrence}" />
            <cejug:singleCheckboxField name="sector.active"
                value="${sector.active}" />

            <div class="form-group">
                <button type="submit" class="btn btn-default btn-sm">
                    <fmt:message key="form.save" />
                </button>
                <a href="${linkTo[SectorController].list}"
                    id="cancelBtn" class="btn btn-danger btn-sm"><fmt:message
                        key="form.cancel" /> </a>
            </div>
            <input name="sector.id" value="${sector.id }" type="hidden" />
        </form>
    </div>
</body>
</html>