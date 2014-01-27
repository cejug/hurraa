<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="manufacturer.form.list" /></title>
</head>
<body>
	
	<div>
		<a href="${linkTo[ManufacturerController].form}"> <fmt:message
				key="manufacturer.form.insert" />
		</a>
	</div>
	<table border="1">
		<tr>
			<td><fmt:message key="manufacturer.id" /></td>
			<td><fmt:message key="manufacturer.name" /></td>
			<td></td>
			<td></td>
		</tr>
		<c:forEach items="${manufacturers }" var="manufacturer">
			<tr>
				<td>${manufacturer.id }</td>
				<td>${manufacturer.name }</td>
				<td><a href="${linkTo[ManufacturerController].form(manufacturer.id) }"> <fmt:message
							key="label.update" />
				</a></td>
				<td><a href="${linkTo[ManufacturerController].delete(manufacturer) }"> <fmt:message
							key="label.remove" />
				</a></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>