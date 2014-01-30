<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="sector.form.list" /></title>
</head>
<body>

	<div>
		<a href="${linkTo[SectorController].form}"> <fmt:message
				key="sector.form.insert" />
		</a>
	</div>
	<table border="1">
		<tr>
			<td><fmt:message key="sector.id" /></td>
			<td><fmt:message key="sector.name" /></td>
			<td><fmt:message key="sector.respondsOccurrence" /></td>
			<td><fmt:message key="sector.active" /></td>
			<td></td>
			<td></td>
		</tr>
		<c:forEach items="${sectors }" var="sector">
			<tr>
				<td>${sector.id }</td>
				<td>${sector.name }</td>
				<td>${sector.respondsOccurrence }</td>
				<td>${sector.active }</td>
				<td><a href="${linkTo[SectorController].form(sector.id) }">
						<fmt:message key="label.update" />
				</a></td>
				<td><a href="${linkTo[SectorController].delete(sector) }">
						<fmt:message key="label.remove" />
				</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>