<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cejug"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="manufacturer.form.insert" /></title>
</head>
<body>
	<c:if test="${not empty sector}">
		<c:set var="action" value="${linkTo[SectorController].update}" />
	</c:if>
	<c:if test="${empty sector}">
		<c:set var="action" value="${linkTo[SectorController].insert}" />
	</c:if>

	<form action="${action}" method="post">

		<cejug:textField name="sector.name" value="${sector.name }" />
		<br /> <input name="sector.id" value="${sector.id }" type="hidden" />
		<button type="submit">
			<fmt:message key="sector.form.submit" />
		</button>
	</form>

</body>
</html>