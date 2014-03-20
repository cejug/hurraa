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
<div class="form-group ${errors[name] != null ? 'has-error' : ''}"  >
  <label for="${name}"><fmt:message key="${name}" />
      <c:if test="${showFieldError == true and not empty errorsMap}">
        <cejug:errorMessage name="${name}" errorsMap="${errorsMap}" showAllErrors="${showAllErrors}" />
      </c:if>
  </label>
  <input type="${type}" class="form-control input-sm" name="${name}" id="${name}" value="${value}" placeholder="${placeholder}"/>
</div>