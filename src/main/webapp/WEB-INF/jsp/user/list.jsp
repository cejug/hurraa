<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="user.form.list" /></title>
</head>
<body>
	<div>
		<a href="${linkTo[UserController].form}"> <fmt:message
				key="user.form.insert" />
		</a>
	</div>
	<table border="1">
		<tr>
			<td><fmt:message key="user.id" /></td>
			<td><fmt:message key="user.name" /></td>
			<td><fmt:message key="user.email" /></td>
			<td></td>
			<td></td>
		</tr>
		<c:forEach items="${users }" var="user">
			<tr>
				<td>${user.id }</td>
				<td>${user.name }</td>
				<td>${user.email }</td>
				<td><a href="${linkTo[UserController].form(user.id) }"> <fmt:message
							key="label.update" />
				</a></td>
				<td><a href="${linkTo[UserController].delete(user) }"> <fmt:message
							key="label.remove" />
				</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>