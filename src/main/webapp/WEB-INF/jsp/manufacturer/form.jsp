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
        <c:if test="${not empty manufacturer or manufacturer.id != null}">
            <c:set var="action" value="${linkTo[ManufacturerController].update}" />
        </c:if>
        <c:if test="${empty manufacturer or manufacturer.id == null}">
            <c:set var="action" value="${linkTo[ManufacturerController].insert}" />
        </c:if>
        
        <div class="page-header">
	      <h1><small><fmt:message key='user.form.insert' /></small></h1>
	    </div>
        
        <div style="width: 50%;">
        <form class="form-horizontal" role="form" action="${action}" method="post">

          <cejug:textField type="text" name="manufacturer.name" value="${manufacturer.name }" errorsMap="${errors}"/>
          
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-default"> <fmt:message key="form.save" /> </button>
		    </div>
		  </div>
		  
		  <input name="manufacturer.id" value="${manufacturer.id }" type="hidden" />
		  
		</form>
		</div>

    </body>
</html>