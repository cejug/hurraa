<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="name" required="true"%>
<%@ attribute name="errorsMap" required="true" type="java.util.Map" %>
<%@ attribute name="showAllErrors" required="false" %>

<c:set var="showFieldError" value="${(empty showFieldError) ? true : showFieldError}" />
<c:set var="showAllErrors" value="${(empty showAllErrors) ? false : showAllErrors}" />

<c:if test="${showAllErrors == true}" >
	<span class="error">${errorsMap[name]}</span>
</c:if>
<c:if test="${showAllErrors == false}" >
	<span class="error">${errorsMap[name][0]}</span>
</c:if>

