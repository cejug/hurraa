<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cejug" %>
<!DOCTYPE html>
<html> 
<body>
	<c:if test="${not empty user}">
		<c:set var="action" value="${linkTo[UserController].update}" />
	</c:if>
	<c:if test="${empty user}">
		<c:set var="action" value="${linkTo[UserController].insert}" />
	</c:if>
	<form action="${action}" method="post">

		<cejug:textField name="user.name" value="${user.name }" /> <br/>
		<cejug:textField name="user.email" value="${user.email }" /> <br/>
		<cejug:textField name="user.password" value="${user.password }" /> <br/>

		<input name="user.id" value="${user.id }" type="hidden" />
		<button type="submit"> <fmt:message key="user.form.submit" /> </button>
	</form>
</body>
</html>