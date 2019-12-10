<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="/css/styles.css"/>
	<link rel="stylesheet" href="/css/stylebeyond.css"/>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h2>Welcome</h2>
		</div>
			<div class="row">
			
			<ul>
				<li><a href="/loginreg">Login Registration Page</a></li>
				<li>Logged In User:  ${loggednUserName}</li>
				<li><a href="/userList">Users List Page</a></li>
				<li><a href="/users">Edit Your Data</a></li>
				<li>				
					<form action="/logout" method="POST">
						<input class="normal-link" type="submit" value="Logout"/>
					</form></li>
			</ul>
		</div>
	
	
	
	
	</div><!-- end container -->


</body>
</html>