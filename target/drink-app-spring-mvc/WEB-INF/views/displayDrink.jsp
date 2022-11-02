<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>

	<h1>Drinks Menu</h1><br>
	<div> ${msg}  </div><br>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Id</th>
			<th>Drink Name</th>
			<th>Drink Type</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="drink" items="${drinks}">
			<tr>
				<td>${drink.id}</td>
				<td>${drink.name}</td>
				<td>${drink.type}</td>
				<td><a href="editemp/${drink.id}">Edit</a></td>
				<td><a href="deleteemp/${drink.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="addDrink">Add a Drink</a>
</body>
</html>