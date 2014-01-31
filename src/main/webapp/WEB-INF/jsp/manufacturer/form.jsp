<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cejug" %>
<!DOCTYPE html>
<html>
<body>
	<c:if test="${not empty manufacturer}">
		<c:set var="action" value="${linkTo[ManufacturerController].update}" />
	</c:if>
	<c:if test="${empty manufacturer}">
		<c:set var="action" value="${linkTo[ManufacturerController].insert}" />
	</c:if>
	<form action="${action}" method="post">

		<cejug:textField name="manufacturer.name" value="${manufacturer.name }" /> <br/>

		<input name="manufacturer.id" value="${manufacturer.id }" type="hidden" />
		<button type="submit"> <fmt:message key="manufacturer.form.submit" /> </button>
	</form>
</body>
</html>