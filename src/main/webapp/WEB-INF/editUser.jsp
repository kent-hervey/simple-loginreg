<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ page isErrorPage="true" %> 

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="/css/styles.css"/>
	<link rel="stylesheet" href="/css/stylesheet.css"/>
<meta charset="ISO-8859-1">
<title>Allows User to edit his data</title>
</head>
<body>
	<div class="container">
		<div class="row"> <!-- row covers both left Register and right Login -->
			<div class="col-90"><!-- left side Register -->
				<div class="form-group">
					<h1>Edit data for User with Emails: ${user.email} ${user.getId()} ${user.userLocation} </h1>
					<p class="bad">${registrationError}</p>
					<form:form action="/users2/${user.getId()}/update" method="post"   modelAttribute="user">
						<input type="hidden" name="_method" value="put">
						<div class="row">
							<form:errors class="bad" path="userName"/>
							<div class="col-25">
								<form:label path="userName">Name:</form:label>
							</div>
							<div class="col-75">
								<form:input path="userName"/>
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
						<form:errors class="bad" path="userLocation"/>
							<div class="col-25">
								<form:label path="userLocation">Location: </form:label>					
							</div>
							<div class="col-75">
								<form:input path="userLocation"/>
							</div>
						</div>
						
						<div class="row">
						<form:errors class="bad" path="personalDescription"/>
							<div class="col-25">
								<form:label path="personalDescription">Personal Description: </form:label>					
							</div>
							<div class="col-75">
								<form:input path="personalDescription"/>
							</div>
						</div>
					
						<div class="row">
							<input class="submit-btn" type="submit" value="Edit"/>
						</div>
					</form:form>
				</div>
			</div><!-- end left side -->

		</div> <!-- end row covering left R and right L -->

	</div><!-- end container -->

</body>
</html>