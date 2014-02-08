<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<body>

    <div class="page-header">
      <h1><small><fmt:message key='title.users' /></small></h1>
    </div>
    
	<div>
		<a href="${linkTo[UserController].form}" class="btn btn-primary active" role="button"> <fmt:message key="link.text.add" /> </a>
	</div>
	<table class="table table-condensed table-hover table-striped">
		<tr>
			<td>#</td>
			<td><fmt:message key="user.name" /></td>
			<td><fmt:message key="user.email" /></td>
			<td></td>
			<td></td>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.email}</td>
				<td>
				  <a href="${linkTo[UserController].form(user.id)}" title="<fmt:message key='label.update' />">
				    <span class="glyphicon glyphicon-edit"></span> 
				  </a>
				</td>
				<td>
				   <a href="${linkTo[UserController].delete(user)}" title="<fmt:message key='label.remove' />"> 
				      <span class="glyphicon glyphicon-remove"></span>				
				   </a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>