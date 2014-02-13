<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>  

    <div class="page-header">
      <h1><small><fmt:message key='title.equipmentModel' /></small></h1>
    </div>

    <c:if test="${message != null}">
        <div class="alert alert-success">
            <c:out value="${message}" />
        </div>
    </c:if>
    <c:if test='${errors["equipmentModel"] != null}' >
        <div class="alert alert-danger">
          <strong>${errors["equipmentModel"][0]}</strong>
        </div>
    </c:if>
    
    <div>
        <a href="${linkTo[EquipmentModelController].form}" class="btn btn-primary btn-sm" role="button">
            <fmt:message key="link.text.add" />
        </a>
    </div>

	<table class="table table-striped table-hover table-condensed">
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
                <td>
                    <a href="${linkTo[EquipmentModelController].form(equipmentModel.id) }" title="<fmt:message key="label.update" />">
                        <span class="glyphicon glyphicon-edit"></span>
                    </a>
                </td>
                <td>
                    <a href="${linkTo[EquipmentModelController].delete(equipmentModel) }" title="<fmt:message key="label.remove" />"> 
                        <span class="glyphicon glyphicon-remove"></span>
                    </a>
                </td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>