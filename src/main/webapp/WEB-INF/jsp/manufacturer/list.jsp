<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	
	<div class="page-header">
      <h1><small><fmt:message key='title.manufacturers' /></small></h1>
    </div>
    
	<div>
		<a href="${linkTo[ManufacturerController].form}" class="btn btn-primary active" role="button"> <fmt:message key="link.text.add" /> </a>
	</div>
	<table class="table table-condensed table-hover table-striped">
		<tr>
			<td>$</td>
			<td><fmt:message key="manufacturer.name" /></td>
			<td></td>
			<td></td>
		</tr>
		<c:forEach items="${manufacturers }" var="manufacturer">
			<tr>
				<td>${manufacturer.id }</td>
				<td>${manufacturer.name }</td>
				<td>
				  <a href="${linkTo[ManufacturerController].form(manufacturer.id)}" title="<fmt:message key='label.update' />">
				    <span class="glyphicon glyphicon-edit"></span> 
				  </a>
				</td>
				<td>
				   <a href="${linkTo[ManufacturerController].delete(manufacturer)}" title="<fmt:message key='label.remove' />"> 
				      <span class="glyphicon glyphicon-remove"></span>				
				   </a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>