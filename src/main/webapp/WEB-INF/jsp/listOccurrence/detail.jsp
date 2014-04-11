<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cejug"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="openOccurrence.form" /></title>
</head>

<body>

	<div class="page-header">
		<h1>
			<small><fmt:message key='openOccurrence.detail' /></small>
		</h1>
	</div>

    <c:if test="${message != null}">
        <div class="alert alert-success">
            <c:out value="${message}" />
        </div>
    </c:if>

	<div style="width: 100%;" class="container-fluid">
		<form class="form-horizontal" role="form"
			action="${linkTo[OpenOccurrenceController].processForm}" method="post">

            <div class="row">
                <div class="col-md-6">
                    <div
                        class="form-group">
                        <label for="occurrence.dateOfOpening"><fmt:message
                                key="occurrence.dateOfOpening" />
                        </label>
                        
                        <input type="text" class="form-control input-sm" 
                           value="<fmt:formatDate value="${occurrence.dateOfOppening}" type="both"/>"
                           readonly="readonly" />
                    </div>
                </div>
                <div class="col-md-6">
                    <div
                        class="form-group  ${errors['occurrence.problemType'] != null ? 'has-error' : ''}">
                        <label for="occurrence.user"> <fmt:message
                                key="occurrence.user" />
                        </label>
                        <input type="text" class="form-control input-sm" 
                           value="${occurrence.user.name}"  readonly="readonly" />
                    </div>
                </div>
            </div>


			<div class="row">
				<div class="col-md-6">
					<div
						class="form-group ${errors['occurrence.sector'] != null ? 'has-error' : ''}">
						<label for="occurrence.sector"> <fmt:message
								key="occurrence.sector" /> <cejug:errorMessage
								name="occurrence.sector" errorsMap="${errors}" />
						</label>
						<input type="text" class="form-control input-sm" 
						   value="${occurrence.sector.name}"  readonly="readonly" />
					</div>
				</div>
				<div class="col-md-6">
					<div
						class="form-group  ${errors['occurrence.problemType'] != null ? 'has-error' : ''}">
						<label for="occurrence.problemType"> <fmt:message
								key="occurrence.problemType" /> <cejug:errorMessage
								name="occurrence.problemType" errorsMap="${errors}" />
						</label>
						<input type="text" class="form-control input-sm" 
                           value="${occurrence.problemType.name}"  readonly="readonly" />
					</div>
				</div>
			</div>

			<cejug:textFieldVertical name="occurrence.serialId" readonly="true"
				value="${occurrence.serialId}" errorsMap="${errors}" />

			<div class="row">
				<div class="col-md-12 ">
					<div
						class="form-group ${errors['occurrence.description'] != null ? 'has-error' : ''}">
						<label for="occurrence.description"> <fmt:message
								key="occurrence.description" /> <cejug:errorMessage
								name="occurrence.description" errorsMap="${errors}" />
						</label>
						<textarea class="form-control" rows="3"
							name="occurrence.description" id="occurrence.description" readonly="true" >${occurrence.description}</textarea>
					</div>
				</div>
			</div>

			<div class="form-group">
				<a href="${linkTo[ListOccurrenceController].list()}" class="btn btn-danger btn-sm">
				    <fmt:message key="label.back" />
				</a>
			</div>
		</form>
	</div>

</body>
</html>