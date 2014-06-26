<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cejug"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="problemType.form.insert" /></title>
</head>

<body>
    <c:if test="${not empty problemType and problemType.id != null}">
        <c:set var="action"
            value="${linkTo[ProblemTypeController].update}" />
            <fmt:message key='problemType.form.update' var="formTitle" />
    </c:if>
    <c:if test="${empty problemType or problemType.id == null}">
        <c:set var="action"
            value="${linkTo[ProblemTypeController].insert}" />
        <fmt:message key='problemType.form.insert' var="formTitle" />
    </c:if>

    <div class="page-header">
        <h1>
            <small><c:out value="${formTitle}" /></small>
        </h1>
    </div>

    <div style="width: 50%;">
        <form class="form-horizontal" role="form" action="${action}" method="post">
            <fieldset>
                <input name="problemType.id" value="${problemType.id }" type="hidden" />
                
                <cejug:textFieldVertical name="problemType.name" value="${problemType.name }" errorsMap="${errors}" autoFocus="true" />

                <div class="form-group">
                    <button type="submit" class="btn btn-default btn-sm">
                        <fmt:message key="form.save" />
                    </button>
                    <a href="${linkTo[ProblemTypeController].list}" class="btn btn-danger btn-sm"> 
                        <fmt:message key="form.cancel" />
                    </a>
                </div>
            </fieldset>
        </form>
    </div>
</body>
</html>