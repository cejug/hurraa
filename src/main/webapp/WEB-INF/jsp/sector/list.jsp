<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<body>

    <div class="page-header">
        <h1>
            <small><fmt:message key='title.sectors' /></small>
        </h1>
    </div>

    <c:if test="${message != null}">
        <div class="alert alert-success">
            <c:out value="${message}" />
        </div>
    </c:if>
    <c:if test='${errors["costCenter"] != null}'>
        <div class="alert alert-danger">
            <strong>${errors["costCenter"][0]}</strong>
        </div>
    </c:if>

    <div>
        <a href="${linkTo[SectorController].form}"
            class="btn btn-primary btn-sm" role="button"> <fmt:message
                key="link.text.add" />
        </a>
    </div>

    <table class="table table-condensed table-hover table-striped">
        <tr>
            <td><fmt:message key="sector.name" /></td>
            <td><fmt:message key="sector.respondsOccurrence" /></td>
            <td><fmt:message key="sector.active" /></td>
            <td></td>
            <td></td>
        </tr>
        <c:forEach items="${sectors }" var="sector">
            <tr>
                <td>${sector.name }</td>
                
                <c:choose>
                	<c:when test="${sector.respondsOccurrence }">
                		<td><fmt:message key="label.yes" /></td>
                	</c:when>
                	<c:otherwise>
                		<td><fmt:message key="label.no" /></td>
                	</c:otherwise>
                </c:choose>
                
                <c:choose>
                	<c:when test="${sector.active }">
                		<td><fmt:message key="label.yes" /></td>
                	</c:when>
                	<c:otherwise>
                		<td><fmt:message key="label.no" /></td>
                	</c:otherwise>
                </c:choose>                
                
                <td><a
                    href="${linkTo[SectorController].form(sector.id)}"
                    title="<fmt:message key='label.update' />"> <span
                        class="glyphicon glyphicon-edit"></span>
                </a></td>
                <td><a
                    href="${linkTo[SectorController].delete(sector)}"
                    title="<fmt:message key='label.remove' />"> <span
                        class="glyphicon glyphicon-remove"></span>
                </a></td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>