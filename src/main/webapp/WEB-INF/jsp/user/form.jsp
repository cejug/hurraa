<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cejug"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="user.form.insert" /></title>
</head>
<body>
	<c:if test="${not empty user and user.id != null}">
		<c:set var="action" value="${linkTo[UserController].update}" />
		<fmt:message key='user.form.update' var="formTitle" />
	</c:if>
	<c:if test="${empty user or user.id == null}">
		<c:set var="action" value="${linkTo[UserController].insert}" />
		<fmt:message key='user.form.insert' var="formTitle" />
	</c:if>

	<div class="page-header">
		<h1>
			<small><c:out value="${formTitle}" /></small>
		</h1>
	</div>

	<div style="width: 50%;">
		<form role="form" action="${action}" method="post">
			<fieldset>
				<cejug:textFieldVertical type="text" name="user.name"
					value="${user.name}" errorsMap="${errors}" />
				<cejug:textFieldVertical type="email" name="user.email"
					value="${user.email}" errorsMap="${errors}" />
				<cejug:textFieldVertical type="password" name="user.password"
					value="${user.password}" errorsMap="${errors}" />
				
				<c:set var="passwordConfirmation" value=""/>
				
				<c:if test="${not empty user and user.id != null and (empty errors['passwordConfirmation'])}">
					<c:set var="passwordConfirmation" value="${user.password}" />
				</c:if> 
				
			    <cejug:textFieldVertical type="password" name="passwordConfirmation"
					value="${passwordConfirmation}" errorsMap="${errors}" />

				<input name="user.id" value="${user.id }" type="hidden" />

				<button type="submit" class="btn btn-default">
					<fmt:message key="form.save" />
				</button>
				<a href="${linkTo[UserController].list}"
					class="btn btn-danger btn-sm"> <fmt:message key="form.cancel" />
				</a>
			</fieldset>
		</form>
	</div>

</body>
</html>