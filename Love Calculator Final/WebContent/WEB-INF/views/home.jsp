<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculate</title>
<style>
	a{
		text-decoration: none;
		color: green;
	}
	a:hover{
		color: blue;
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

<div align = "center">
	<h1>Love Calculator</h1>
	<h3><a href = "register">Register</a></h3>
	<hr>

	<form:form action="calculate" method="get" modelAttribute="userInfo">
		<label for="yourName">Your Name : </label>
		<form:input path="yourName" id="yourName" />
		<form:errors path = "yourName" cssClass = "error"/>
		<br>
		<br>

		<label for="crushName">Crush Name : </label>
		<form:input path="crushName" id="crushName" />
		<form:errors path = "crushName" cssClass = "error"/>
		<br>
		<br>
		
		<form:checkbox path="term" id = "termandcon"/>
		<label for = "termandcon">This is just for fun purpose.</label>
		<form:errors path = "term" cssClass = "error"/>
		<br><br>

		<input type="submit" value="Calculate" />
	</form:form>
</div>
</body>
</html>