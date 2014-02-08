<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cejug"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="sector.form.insert" /></title>
    </head>
    <body>
        <c:if test="${not empty sector or sector.id != null}">
            <c:set var="action" value="${linkTo[SectorController].update}" />
        </c:if>
        <c:if test="${empty sector or sector.id == null}">
            <c:set var="action" value="${linkTo[SectorController].insert}" />
        </c:if>
		
		<div class="page-header">
	      <h1><small><fmt:message key='sector.form.insert' /></small></h1>
	    </div>
	    
	    <div style="width: 50%;">
        <form class="form-horizontal" role="form" action="${action}" method="post">

          <cejug:textField type="text" name="sector.name" value="${sector.name }" errorsMap="${errors}" />
          <cejug:textField type="email" name="sector.email" value="${sector.email}" errorsMap="${errors}" />
          <cejug:singleCheckboxField name="sector.respondsOccurrence" value="${sector.respondsOccurrence}" />
          <cejug:singleCheckboxField name="sector.active" value="${sector.active}" />
          
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-default"> <fmt:message key="form.save" /> </button>
		    </div>
		  </div>
		  
		  <input name="sector.id" value="${sector.id }" type="hidden" />
		  
		</form>
		</div>
    </body>
</html>