<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="costCenter.form.list" /></title>
</head>
<body>

	<div class="page-header">
      <h1><small><fmt:message key='title.costCenters' /></small></h1>
    </div>
    
	<div>
		<a href="${linkTo[CostCenterController].form}" class="btn btn-primary active" role="button"> <fmt:message key="link.text.add" /> </a>
	</div>
	
	<table class="table table-condensed table-hover table-striped">
		<tr>
			<td>#</td>
			<td><fmt:message key="costCenter.code" /></td>
			<td><fmt:message key="costCenter.name" /></td>
			<td><fmt:message key="costCenter.description" /></td>
			<td></td>
			<td></td>
		</tr>
		<c:forEach items="${costCenters}" var="costCenter">
			<tr>
				<td>${costCenter.id}</td>
				<td>${costCenter.code}</td>
				<td>${costCenter.name}</td>
				<td>${costCenter.description}</td>
				<td>
				  <a href="${linkTo[CostCenterController].form(costCenter.id)}" title="<fmt:message key='label.update' />">
				    <span class="glyphicon glyphicon-edit"></span> 
				  </a>
				</td>
				<td>
				  <a href="${linkTo[CostCenterController].delete(costCenter)}" title="<fmt:message key='label.remove' />"> 
				      <span class="glyphicon glyphicon-remove"></span>				
				   </a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>