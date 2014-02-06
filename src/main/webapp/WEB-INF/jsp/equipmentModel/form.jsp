<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cejug"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <body>
        <c:if test="${not empty equipmentModel or equipmentModel.id != null}">
            <c:set var="action" value="${linkTo[EquipmentModelController].update}" />
        </c:if>
        <c:if test="${empty equipmentModel or equipmentModel.id == null}">
            <c:set var="action" value="${linkTo[EquipmentModelController].insert}" />
        </c:if>

        <form action="${action}" method="post">
            <cejug:textField name="equipmentModel.name"
            value="${equipmentModel.name}" errorsMap="${errors}"/>
            
            <label for="equipmentModel.equipmentType"><fmt:message key="equipmentModel.equipmentType" /></label>
            <select name="equipmentModel.equipmentType.id" id="equipmentModel.equipmentType.id" >
                <option value=""><fmt:message  key="label.emptySelect"/></option>
                <c:forEach items="${types}" var="type" >
                    <option value="${type.id}" ${equipmentModel.equipmentType == type ? 'selected="selected"' : '' } >${type.name}</option>
                </c:forEach>
            </select>
            <cejug:errorMessage name="equipmentModel.equipmentType.id" errorsMap="${errors}" />
            
            <br />        
            <input name="equipmentModel.id" value="${equipmentModel.id}"
            type="hidden" />
        <button type="submit" class="pure-button">
            <fmt:message key="equipmentModel.form.submit" />
        </button>
        </form>
    </body>
</html>