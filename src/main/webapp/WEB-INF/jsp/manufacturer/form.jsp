<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cejug"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="manufacturer.form.insert" /></title>
    </head>

    <body>
        <c:if test="${not empty manufacturer and manufacturer.id != null}">
            <c:set var="action" value="${linkTo[ManufacturerController].update}" />
            <fmt:message key='manufacturer.form.update' var="formTitle" />
        </c:if>
        <c:if test="${empty manufacturer or manufacturer.id == null}">
            <c:set var="action" value="${linkTo[ManufacturerController].insert}" />
            <fmt:message key='manufacturer.form.insert' var="formTitle" />
        </c:if>
        
        <div class="page-header">
	      <h1><small><c:out value="${formTitle}" /></small></h1>
	    </div>
        
        <div style="width: 50%;">
        <form class="form-horizontal" role="form" action="${action}" method="post">

          <cejug:textFieldVertical type="text" name="manufacturer.name" value="${manufacturer.name}" errorsMap="${errors}"/>
        
          <input name="manufacturer.id" value="${manufacturer.id }" type="hidden" />
                      
		  <div class="form-group">
		      <button type="submit" class="btn btn-default btn-sm"><fmt:message key="form.save" /></button>
              <a href="${linkTo[ManufacturerController].list}" class="btn btn-danger btn-sm" > 
                <fmt:message key="form.cancel" />
            </a>
		  </div>
		</form>
		</div>

    </body>
</html>