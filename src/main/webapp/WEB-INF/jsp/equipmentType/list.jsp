<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<div>
		<a href="${linkTo[EquipmentTypeController].form}"> 
			<fmt:message key="equipmentType.form.insert" />
		</a>
	</div>
	<table border="1">
		<tr>
			<td><fmt:message key="equipmentType.id" /></td>
			<td><fmt:message key="equipmentType.name" /></td>
			<td></td>
			<td></td>
		</tr>
		<c:forEach items="${equipmentTypes }" var="equipmentType">
			<tr>
				<td>${equipmentType.id }</td>
				<td>${equipmentType.name }</td>
				<td><a href="${linkTo[EquipmentTypeController].form(equipmentType.id) }"> 
						<fmt:message key="label.update" />
					</a>
				</td>
				<td><a href="${linkTo[EquipmentTypeController].delete(equipmentType) }"> 
						<fmt:message key="label.remove" />
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>