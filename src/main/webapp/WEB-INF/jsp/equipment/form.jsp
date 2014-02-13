<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cejug"%>
<!DOCTYPE html>
<html>
    <body>
        <c:if test="${not empty equipment or equipment.id != null}">
            <c:set var="action" value="${linkTo[EquipmentController].update}" />
        </c:if>
        <c:if test="${empty equipment or equipment.id == null}">
            <c:set var="action" value="${linkTo[EquipmentController].insert}" />
        </c:if>
        
        <div class="page-header">
	      <h1><small><fmt:message key='equipment.form.insert' /></small></h1>
	    </div>	    
	
        <form action="${action}" method="post">

            <cejug:textField name="equipment.serialId" value="${equipment.serialId}" errorsMap="${errors}"/>
            <cejug:textField name="equipment.endOfWarranty" value="${equipment.endOfWarranty}" errorsMap="${errors}"/>
            <cejug:textField name="equipment.lastMaintenance" value="${equipment.lastMaintenance}" errorsMap="${errors}"/>
            <cejug:textField name="equipment.maintenanceDescription" value="${equipment.maintenanceDescription}" errorsMap="${errors}"/>
            
            <label for="equipment.equipmentModel"><fmt:message key="equipment.equipmentModel" /></label>
            <select name="equipment.equipmentModel.id" id="equipment.equipmentModel.id" >
                <option value=""><fmt:message  key="label.emptySelect"/></option>
                <c:forEach items="${models}" var="model" >
                    <option value="${model.id}" ${equipment.equipmentModel == model ? 'selected="selected"' : '' } >${model.name}</option>
                </c:forEach>
            </select>
            <cejug:errorMessage name="equipment.equipmentModel.id" errorsMap="${errors}" />
            
            <br />        
            <input name="equipment.id" value="${equipment.id}" type="hidden" />
            
        <button type="submit" class="pure-button">
            <fmt:message key="equipment.form.submit" />
        </button>
        </form>
    </body>
</html>