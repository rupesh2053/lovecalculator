<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>register</title>
<style>
	a{
		text-decoration: none;
	}
	label {
		font-weight: bold;
		font-size: 18px;
	}
	#submit{
		background: black;
		color: white;
		font-weight: bold;
		border: none;
		padding: 5px 15px;
		font-size: 18px;
		border-radius: 3px;
		cursor: pointer;
	}
	.error{
		color: red;
		font-weight: bold;
		text-align: left;
		margin-left: 20px;
		position: fixed;
	}
</style>
</head>
<body>
	<div align="center">
		<h1>Registration Page</h1>
		<h3><a href = "home">Home</a></h3>
		<hr>
		<form:form method="post" action="registration-success" modelAttribute="userReg">
		
			<label for="name">Name : </label>
			<form:input path="name" id="name" />
			<form:errors path = "name" cssClass = "error"/>
			<br><br>
			
			<label for="username">User-name : </label>
			<form:input path="username" id="username" />
			<form:errors path = "username" cssClass = "error"/>
			<br><br>
			
			<label for="password">Password : </label>
			<form:password path="password" id="password" />
			<br><br>
			
			<label for="age">Age : </label>
			<form:input path="age" id="age" />
			<form:errors path = "age" cssClass = "error"/>
			<br><br>
			
			<label for="country">Country : </label>
				<form:select path="country" id = "country">
					<form:option value="Nepal" label = "Nepal"/>
					<form:option value="USA" label = "USA"/>
					<form:option value="UK" label = "UK"/>
					<form:option value="UAE" label = "UAE"/>
					<form:option value="India" label = "India"/>
				</form:select>
			<br><br>
			
			<label>Hobbies : </label>
			<form:checkbox path="hobbies" value = "Programming"/> Programming
			<form:checkbox path="hobbies" value = "Music"/> Music
			<form:checkbox path="hobbies" value = "Gaming"/> Gaming
			<form:checkbox path="hobbies" value = "Travelling"/> Travel
			<br><br>
			
			<label>Gender : </label>
			<form:radiobutton path="gender" value = "Male"/> Male
			<form:radiobutton path="gender" value = "Female"/> Female
			<br><br>
			
			<div>
				<h2>Communication Channel</h2>
				<label for = "email">Email : </label>
				<form:input path="communicationDto.email"/>
				<form:errors path = "communicationDto.email" cssClass = "error"/>
				<br><br>
				
				<label for = "phone">Phone Number : </label>
				<form:input path="communicationDto.phone"/>
				<form:errors path = "communicationDto.phone"/>
				<br><br>
			</div>
			<input type = "submit" value = "Register" id = "submit"/>
		</form:form>
	</div>
</body>
</html>