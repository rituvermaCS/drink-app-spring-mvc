<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<body>
	<h1>Edit Drink</h1>
	<form:form method="post" action="editSave">
		<table>
			<tr>
				<td>Drink Id :</td>
				<td><form:input path="id" /></td>
			</tr>
			<tr>
				<td>Drink Name :</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Drink Type :</td>
				<td><form:input path="type" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Edit Drink" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>