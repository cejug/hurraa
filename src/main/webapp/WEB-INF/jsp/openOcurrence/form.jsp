<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cejug"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="openOcurrence.form" /></title>
    </head>

    <body>
        
        <div class="page-header">
	      <h1><small><fmt:message key='openOcurrence.form' /></small></h1>
	    </div>
        
        <div style="width: 50%;">
        <form class="form-horizontal" role="form" action="${linkTo[OpenOcurrenceController].processForm}" method="post">

          <cejug:textFieldVertical type="text" name="manufacturer.name" value="${manufacturer.name}" errorsMap="${errors}"/>
        
                      
		  <div class="form-group">
		      <button type="submit" class="btn btn-default btn-sm"><fmt:message key="form.save" /></button>
              <a href="#youshouldchangethat" class="btn btn-danger btn-sm" > 
                <fmt:message key="form.cancel" />
            	</a>
		  </div>
		</form>
		</div>

    </body>
</html>