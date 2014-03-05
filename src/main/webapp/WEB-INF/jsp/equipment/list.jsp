<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<body>

<div class="page-header">
      <h1><small><fmt:message key='title.equipment' /></small></h1>
    </div>
    
     <c:if test="${message != null}">
        <div class="alert alert-success">
            <c:out value="${message}" />
        </div>
    </c:if>
    <c:if test='${errors["equipment"] != null}' >
        <div class="alert alert-danger">
          <strong>${errors["equipment"][0]}</strong>
        </div>
    </c:if>   
    
    <div>
		<a href="${linkTo[EquipmentController].form}" class="btn btn-primary btn-sm" role="button"> 
			<fmt:message key="link.text.add" />
		</a>
    </div>
        
	<table class="table table-condensed table-hover table-striped">
		<tr>
			<td><fmt:message key="equipment.serialId" /></td>
			<td><fmt:message key="equipment.endOfWarranty" /></td>
			<td><fmt:message key="equipment.lastMaintenance" /></td>
			<td><fmt:message key="equipment.equipmentModel" /></td>
			<td></td>
			<td></td>
		</tr>
		<c:forEach items="${equipments}" var="equipment">
			<tr>
				<td>${equipment.serialId }</td>
				<td><fmt:formatDate value="${equipment.endOfWarranty}" type="date"  /></td>
				<td><fmt:formatDate value="${equipment.lastMaintenance}" type="date" /></td>
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