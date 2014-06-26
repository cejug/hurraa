<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cejug"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="costCenter.form.insert" /></title>
</head>
<body>
    <c:if test="${not empty costCenter and costCenter.id != null}">
        <c:set var="action"
            value="${linkTo[CostCenterController].update}" />
        <fmt:message key='costCenter.form.insert' var="formTitle" />
    </c:if>
    <c:if test="${empty costCenter or costCenter.id == null}">
        <c:set var="action"
            value="${linkTo[CostCenterController].insert}" />
        <fmt:message key='costCenter.form.update' var="formTitle" />
    </c:if>

    <div class="page-header">
        <h1>
            <small><c:out value="${formTitle}" /></small>
        </h1>
    </div>

    <div style="width: 50%;">
        <form class="form-horizontal" role="form" action="${action}"
            method="post">

            <cejug:textFieldVertical type="text" name="costCenter.code"
                value="${costCenter.code}" errorsMap="${errors}" autoFocus="true" />
            <cejug:textFieldVertical type="text" name="costCenter.name"
                value="${costCenter.name }" errorsMap="${errors}" />
            <cejug:textFieldVertical type="text"
                name="costCenter.description"
                value="${costCenter.description}" errorsMap="${errors}" />
            
            <input name="costCenter.id" value="${costCenter.id }"
                type="hidden" />
            
            <div class="form-group">
                <button id="submitBtn" type="submit" class="btn btn-default btn-sm">
                    <fmt:message key="form.save" />
                </button>
                <a href="${linkTo[CostCenterController].list}" id="cancelBtn"
                    class="btn btn-danger btn-sm"> <fmt:message
                        key="form.cancel" />
                </a>
            </div>

        </form>
    </div>

</body>
</html>