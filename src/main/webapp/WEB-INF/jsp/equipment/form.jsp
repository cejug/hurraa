<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cejug"%>
<!DOCTYPE html>
<html>
<body>
    <c:if test="${not empty equipment and equipment.id != null}">
        <c:set var="action"
            value="${linkTo[EquipmentController].update}" />
            <fmt:message key='equipment.form.update' var="formTitle" />
    </c:if>
    <c:if test="${empty equipment or equipment.id == null}">
        <c:set var="action"
            value="${linkTo[EquipmentController].insert}" />
            <fmt:message key='equipment.form.insert' var="formTitle" />
    </c:if>

    <div class="page-header">
        <h1>
            <small><c:out value="${formTitle}" /></small>
        </h1>
    </div>

    <div style="width: 50%;">
        <form class="form-vertical" action="${action}" method="post">

            <cejug:textFieldVertical name="equipment.serialId"
                value="${equipment.serialId}" errorsMap="${errors}" />
            <cejug:textFieldVertical name="equipment.endOfWarranty"
                value="${equipment.endOfWarranty}" errorsMap="${errors}" />
            <cejug:textFieldVertical name="equipment.lastMaintenance"
                value="${equipment.lastMaintenance}"
                errorsMap="${errors}" />
            <cejug:textFieldVertical
                name="equipment.maintenanceDescription"
                value="${equipment.maintenanceDescription}"
                errorsMap="${errors}" />

            <div
                class="form-group ${errors['equipment.equipmentModel.id'] != null ? 'has-error' : ''}">
                <label for="equipment.equipmentModel"><fmt:message
                        key="equipment.equipmentModel" /> <cejug:errorMessage
                        name="equipment.equipmentModel.id"
                        errorsMap="${errors}" /></label> <select
                    name="equipment.equipmentModel.id"
                    id="equipment.equipmentModel.id"
                    class="form-control input-sm">
                    <option value=""><fmt:message
                            key="label.emptySelect" /></option>
                    <c:forEach items="${models}" var="model">
                        <option value="${model.id}"
                            ${equipment.equipmentModel == model ? 'selected="selected"' : '' }>${model.name}</option>
                    </c:forEach>
                </select>
            </div>

            <input name="equipment.id" value="${equipment.id}"
                type="hidden" />

            <button type="submit" class="btn btn-default btn-sm">
                <fmt:message key="form.save" />
            </button>
            <a href="${linkTo[EquipmentController].list}"
                class="btn btn-danger btn-sm"> <fmt:message
                    key="form.cancel" />
            </a>
        </form>
    </div>

    <script>
					$().ready(
							function() {
								$("#equipment\\.endOfWarranty").datepicker()
										.datepicker("hide");
								$("#equipment\\.lastMaintenance").datepicker()
										.datepicker("hide");
							});
				</script>
</body>
</html>