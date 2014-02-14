<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cejug"%>
<!DOCTYPE html>
<html>
    <body>
        <c:if test="${not empty equipmentModel and equipmentModel.id != null}">
            <c:set var="action" value="${linkTo[EquipmentModelController].update}" />
            <div class="page-header">
                <h1>
                    <small><fmt:message key='equipmentModel.form.update' /></small>
                </h1>
            </div>
        </c:if>
        <c:if test="${empty equipmentModel or equipmentModel.id == null}">
            <c:set var="action" value="${linkTo[EquipmentModelController].insert}" />
            <div class="page-header">
                <h1>
                    <small><fmt:message key='equipmentModel.form.insert' /></small>
                </h1>
            </div>
        </c:if>
    
    
        <div style="width: 50%;"> 
        <form action="${action}" method="post">
            <cejug:textFieldVertical name="equipmentModel.name"
                    value="${equipmentModel.name }" errorsMap="${errors}" />
            
            <div class="form-group ${errors['equipmentModel.equipmentType'] != null ? 'has-error' : ''}"  >
                <label for="equipmentModel.equipmentType">
                    <fmt:message key="equipmentModel.equipmentType" />
                    <cejug:errorMessage name="equipmentModel.equipmentType.id" errorsMap="${errors}" />                
                </label>
                <select name="equipmentModel.equipmentType.id" id="equipmentModel.equipmentType.id" class="form-control input-sm" >
                    <option value=""><fmt:message  key="label.emptySelect"/></option>
                    <c:forEach items="${types}" var="type" >
                        <option value="${type.id}" ${equipmentModel.equipmentType == type ? 'selected="selected"' : '' } >${type.name}</option>
                    </c:forEach>
                </select>
            </div>
            
            <input name="equipmentModel.id" value="${equipmentModel.id}" type="hidden" />
            <button type="submit" class="btn btn-default btn-sm">
                <fmt:message key="form.save" />
            </button>
            <a href="${linkTo[EquipmentModelController].list}" class="btn btn-danger btn-sm" > 
                <fmt:message key="form.cancel" />
            </a>
        </form>
        </div>
    </body>
</html>