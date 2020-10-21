<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align = "center">
	<h1>Registration Success</h1><hr>
	<h3>Name : ${userReg.name}</h3>
	<h3>User name : ${userReg.username}</h3>
	<h3>Age : ${userReg.age}</h3>
	<h3>Country : ${userReg.country}</h3>
	<h3>Hobbies : 
		<c:forEach var = "hobby" items = "${userReg.hobbies}">
			${hobby},
		</c:forEach>
	</h3>
	<h3>Gender : ${userReg.gender}</h3>
	
	<h1>Communication Details</h1><hr>
	<h3>Email : ${userReg.communicationDto.email}</h3>
	<h3>Phone : ${userReg.communicationDto.phone}</h3>
	</div>
</body>
</html>