<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cejug"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="occurrenceState.form.insert" /></title>
</head>

<body>
    <c:if test="${not empty occurrenceState and occurrenceState.id != null}">
        <c:set var="action"
            value="${linkTo[OccurrenceStateController].update}" />
            <fmt:message key='occurrenceState.form.update' var="formTitle" />
    </c:if>
    <c:if test="${empty occurrenceState or occurrenceState.id == null}">
        <c:set var="action"
            value="${linkTo[OccurrenceStateController].insert}" />
        <fmt:message key='occurrenceState.form.insert' var="formTitle" />
    </c:if>

    <div class="page-header">
        <h1>
            <small><c:out value="${formTitle}" /></small>
        </h1>
    </div>

    <div style="width: 50%;">
        <form class="form-horizontal" role="form" action="${action}" method="post">
            <fieldset>
                <input name="occurrenceState.id" value="${occurrenceState.id }" type="hidden" />
                
                <cejug:textFieldVertical name="occurrenceState.name" value="${occurrenceState.name }" errorsMap="${errors}" />

                <div class="form-group">
                    <button type="submit" class="btn btn-default btn-sm">
                        <fmt:message key="form.save" />
                    </button>
                    <a href="${linkTo[OccurrenceStateController].list}" class="btn btn-danger btn-sm"> 
                        <fmt:message key="form.cancel" />
                    </a>
                </div>
            </fieldset>
        </form>
    </div>
</body>
</html>