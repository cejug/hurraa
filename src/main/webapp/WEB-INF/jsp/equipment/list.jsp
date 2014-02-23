<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<body>
	<div class="page-header">
		<a href="${linkTo[EquipmentController].form}" class="btn btn-primary active" role="button"> 
			<fmt:message key="equipment.form.insert" />
		</a>
	</div>
	<table class="table table-condensed table-hover table-striped">
		<tr>
			<td><fmt:message key="equipment.id" /></td>
			<td><fmt:message key="equipment.serialId" /></td>
			<td><fmt:message key="equipment.endOfWarranty" /></td>
			<td><fmt:message key="equipment.lastMaintenance" /></td>
			<td><fmt:message key="equipment.maintenanceDescription" /></td>
			<td><fmt:message key="equipment.equipmentModel" /></td>
			<td></td>
			<td></td>
		</tr>
		<c:forEach items="${equipments}" var="equipment">
			<tr>
				<td>${equipment.id }</td>
				<td>${equipment.serialId }</td>
				<td>${equipment.endOfWarranty }</td>
				<td>${equipment.lastMaintenance }</td>
				<td>${equipment.maintenanceDescription }</td>
				<td>${equipment.equipmentModel.name }</td>
				<td><a href="${linkTo[EquipmentController].form(equipment.id) }"> 
						<fmt:message key="label.update" />
					</a>
				</td>
				<td><a href="${linkTo[EquipmentController].delete(equipment) }"> 
						<fmt:message key="label.remove" />
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>