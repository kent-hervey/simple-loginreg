<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="/css/styles.css"/>
<meta charset="ISO-8859-1">
<title>User List</title>
</head>
<body>
	<div class = "container">
	
	<h5><a href="/">Back to Dashboard</a></h5>
	<p> &nbsp;</p>
	<h5>Logged In User:  ${loggednUserName}</h5>
	
	<h4>Total User Count:  ${users.size()}</h4>
	
	<table>
		
		<thead>
			<tr>
				<th>Row</th>
				<th>User Number</th>
				<th>User Name</th>
				<th>Email</th>
				<th>Gold status</th>
				<th>Personal Description</th>
				<th>Join Date</th>
				<th>Number Logins</th>
			
		
		
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user" varStatus="loop">
				<tr>
				<td>${loop.count}</td>
				<td>${user.getId() }</td>
				<td>${user.getUserName() }
				<td>${user.getEmail()}</td> 
				<td><c:out value="${user.getGoldStatus() ? 'Yes': 'No'}"/></td>
				<td>${user.getPersonalDescription()}
				<td><fmt:formatDate  type="date" dateStyle="short" value="${user.getCreatedAt()}" />
				<td>${user.getNumLogins()}
		
		
		
				</tr>
			</c:forEach>
		</tbody>
		
		
		
		
		
	</table>
	
	

	</div> <!-- End container -->




</body>
</html>