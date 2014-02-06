<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cejug" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="user.form.insert" /></title>
    </head> 
    <body>
        <c:if test="${not empty user}">
            <c:set var="action" value="${linkTo[UserController].update}" />
        </c:if>
        <c:if test="${empty user}">
            <c:set var="action" value="${linkTo[UserController].insert}" />
        </c:if>
        
        <div class="page-header">
	      <h1><small><fmt:message key='user.form.insert' /></small></h1>
	    </div>
        
        <div style="width: 50%;">
        <form class="form-horizontal" role="form" action="${action}" method="post">

          <cejug:textField type="text" name="user.name" value="${user.name}" errorsMap="${errors}" />
          <cejug:textField type="email" name="user.email" value="${user.email}" errorsMap="${errors}" />
          <cejug:textField type="password" name="user.password" value="${user.password}" errorsMap="${errors}" />
          
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-default"> <fmt:message key="user.form.submit" /> </button>
		    </div>
		  </div>
		  
		  <input name="user.id" value="${user.id }" type="hidden" />
		  
		</form>
		</div>
        
    </body>
</html>