<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
    <fmt:message key="already_in_use" />

	<div>
		<a href="${linkTo[EquipmentModelController].form}"> 
			<fmt:message key="equipmentModel.form.insert" />
		</a>
	</div>
	<table border="1">
		<tr>
			<td><fmt:message key="equipmentModel.id" /></td>
			<td><fmt:message key="equipmentModel.name" /></td>
			<td></td>
			<td></td>
		</tr>
		<c:forEach items="${equipmentModels }" var="equipmentModel">
			<tr>
				<td>${equipmentModel.id }</td>
				<td>${equipmentModel.name }</td>
				<td><a href="${linkTo[EquipmentModelController].form(equipmentModel.id) }"> 
						<fmt:message key="label.update" />
					</a>
				</td>
				<td><a href="${linkTo[EquipmentModelController].delete(equipmentModel) }"> 
						<fmt:message key="label.remove" />
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>