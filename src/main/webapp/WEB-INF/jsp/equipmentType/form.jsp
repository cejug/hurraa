<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cejug"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="equipmentType.form.insert" /></title>
</head>

<body>
	<c:if test="${not empty equipmentType and equipmentType.id != null}">
		<c:set var="action" value="${linkTo[EquipmentTypeController].update}" />
		<fmt:message key='equipmentType.form.update' var="formTitle" />
	</c:if>
	<c:if test="${empty equipmentType or equipmentType.id == null}">
		<c:set var="action" value="${linkTo[EquipmentTypeController].insert}" />
		<fmt:message key='equipmentType.form.insert' var="formTitle" />
	</c:if>

	<div class="page-header">
		<h1>
			<small><c:out value="${formTitle}" /></small>
		</h1>
	</div>

	<div style="width: 50%;">
		<form action="${action}" method="post">
			<fieldset>
				<cejug:textFieldVertical name="equipmentType.name"
					value="${equipmentType.name }" errorsMap="${errors}" autoFocus="true" />

				<input name="equipmentType.id" value="${equipmentType.id }"
					type="hidden" />

				<button type="submit" class="btn btn-default btn-sm">
					<fmt:message key="form.save" />
				</button>
				<a href="${linkTo[EquipmentTypeController].list}"
					class="btn btn-danger btn-sm"> <fmt:message key="form.cancel" />
				</a>
			</fieldset>
		</form>
	</div>
</body>
</html>