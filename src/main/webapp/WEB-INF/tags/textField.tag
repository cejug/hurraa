<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cejug"%>
<%@ attribute name="name" required="true"%>
<%@ attribute name="value" required="false"%>
<%@ attribute name="type" required="false"%>
<%@ attribute name="placeholder" required="false"%>
<%@ attribute name="showFieldError" required="false" %>
<%@ attribute name="showAllErrors" required="false" %>
<%@ attribute name="errorsMap" required="false" type="java.util.Map" %>
<c:set var="showFieldError" value="${(empty showFieldError) ? true : showFieldError}" />
<c:set var="showAllErrors" value="${(empty showAllErrors) ? false : showAllErrors}" />
<c:if test="${showFieldError == true and not empty errorsMap}">
	<cejug:errorMessage name="${name}" errorsMap="${errorsMap}" showAllErrors="${showAllErrors}" />
</c:if>
<div class="form-group">
  <label for="${name}" class="col-sm-2 control-label"><fmt:message key="${name}" /></label>
  <div class="col-sm-10">
     <input type="${type}" class="form-control" name="${name}" id="${name}" value="${value}" placeholder="${placeholder}" 
     ${autoFocus == true ? 'autofocus' : ''}/>
  </div>
</div>