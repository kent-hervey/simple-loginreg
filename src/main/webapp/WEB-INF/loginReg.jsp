<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="/css/styles.css"/>
	<link rel="stylesheet" href="/css/stylesheet.css"/>
<meta charset="ISO-8859-1">
<title>Login Registration</title>
</head>
<body>
	<div class="container">
		<h5><a href="/">Back to Dashboard</a></h5>
		<h3 class="bad">${preLoginIn}</h3>
		<h3 class="good">${logoutSuccess} ${preLoginMessage}</h3>
		<div class="row"> <!-- row covers both left Register and right Login -->
			<div class="col"><!-- left side Register -->
				<div class="form-group">
					<h1>Register</h1>
					<p class="bad">${registrationError}</p>
					<form:form method="POST" action="register" modelAttribute="user">
						<div class="row">
							<form:errors class="bad" path="userName"/>
							<div class="col-25">
								<label>Name:</label>
							</div>
							<div class="col-75">
								<input type="text" name="userName">
							</div>
						</div>
						<div class="row">
							<p class="bad">${registrationErrorDup}</p>
							<form:errors class="bad" pth="email"/>
							<div class="col-25">
								<label>Email:</label>
							</div>
							<div class="col-75">
								<input type="text" name="email">
							</div>
						</div>
					
						<div class="row">
							<div class="col-25">
								<label>Gold?</label>
							</div>
							<div class="col-25">
								Yes:<form:radiobutton path="goldStatus" value="true"/>
							</div>
							<div class="col-25">
								No:<form:radiobutton path="goldStatus" value="false"/>
							</div>	
						</div>

						<div class="row">
							<div class="col-25">
								<label>Location: </label>					
							</div>
							<div class="col-75">
								<input type="text" name="userLocation">
							</div>
						</div>
						<div class="row">
							<form:errors class="bad" path="password"/>
							<div class="col-25">
								<label>Password:</label>
							</div>
							<div class="col-75">
								<input type="password" name="password"/>
							</div>
						</div>
						<div class="row">
							<form:errors class="bad" path="password"/>
							<div class="col-25">
								<label>Password Conf:</label>
							</div>
							<div class="col-75">
								<input type="password" name="passwordConfirmation"/>
							</div>
						</div>						
						<div class="row">
							<input class="submit-btn" type="submit" value="Register"/>
						</div>
					</form:form>
					<p class="good">${preLoginMessage}</p>
				</div>
			</div><!-- end left side -->
			<div class="col"><!-- Begin right side Login -->
				<div class="form-group">
					<h1>Login</h1>
					<p class="bad"> ${loginError}</p>
					<form action="login" method="POST">
						<div class="row">
							<div class="col-25">
								<label>Email:</label>
							</div>
							<div class="col-75">
								<input type="text" name="email"/>
							</div>
						</div>
						<div class="row">
							<div class="col-25">
								<label>Password:</label>
							</div>
							<div class="col-75">
								<input type="password" name="password"/>
							</div>
						</div>
						<div class="row">
							<input class="submit-btn" type="submit" value="Login"/>
						</div>
					</form>
				</div><!-- end right side form group -->

			</div><!-- End right side -->
		</div> <!-- end row covering left R and right L -->

	</div><!-- end container -->

</body>
</html>