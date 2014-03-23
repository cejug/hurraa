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
			<small><fmt:message key='openOccurrence.form' /></small>
		</h1>
	</div>

	<div style="width: 100%;" class="container-fluid">
		<form class="form-horizontal" role="form"
			action="${linkTo[OpenOccurrenceController].processForm}" method="post">

			<div class="row">
				<div class="col-md-6">
					<div
						class="form-group ${errors['occurrence.sector'] != null ? 'has-error' : ''}">
						<label for="occurrence.sector"> <fmt:message
								key="occurrence.sector" /> <cejug:errorMessage
								name="occurrence.sector" errorsMap="${errors}" />
						</label> <select name="occurrence.sector.id" id="occurrence.sector"
							class="form-control input-sm">
							<option value="">
								<fmt:message key="label.emptySelect" />
							</option>
							<c:forEach items="${sectors}" var="sector">
								<option value="${sector.id}"
									${occurrence.sector == sector ? 'selected="selected"' : '' }>${sector.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="col-md-6">
					<div
						class="form-group  ${errors['occurrence.problemType'] != null ? 'has-error' : ''}">
						<label for="occurrence.problemType"> <fmt:message
								key="occurrence.problemType" /> <cejug:errorMessage
								name="occurrence.problemType" errorsMap="${errors}" />
						</label> <select name="occurrence.problemType.id"
							id="occurrence.problemType" class="form-control input-sm">
							<option value="">
								<fmt:message key="label.emptySelect" />
							</option>
							<c:forEach items="${problemTypes}" var="type">
								<option value="${type.id}"
									${occurrence.problemType == type ? 'selected="selected"' : '' }>${type.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>

			<cejug:textFieldVertical name="occurrence.serialId"
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
							name="occurrence.description" id="occurrence.description" ></textarea>
					</div>
				</div>
			</div>

			<div class="form-group">
				<button type="submit" class="btn btn-default btn-sm">
					<fmt:message key="form.save" />
				</button>
				<a href="#youshouldchangethat" class="btn btn-danger btn-sm"> <fmt:message
						key="form.cancel" />
				</a>
			</div>
		</form>
	</div>

</body>
</html>