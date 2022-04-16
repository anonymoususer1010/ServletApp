<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE html>
		<html lang="en">

		<head>
			<link rel="stylesheet" href="assets/style.css">
			<meta charset="ISO-8859-1">
			<title>Servlet App</title>
		</head>

		<body>
			<h1>
				Bucket List
			</h1>

			<h3>
				Add Bucket List
			</h3>

			<form action="addList">
				<input type="text" name="id" id="enterId" placeholder="Enter List ID"><br>

				<input type="text" name="type" id="enterName" placeholder="Enter List Type"><br>

				<input type="text" name="desc" id="enterDescription" placeholder="Enter List Description"><br>

				<input type="text" name="prio" id="enterPriority" placeholder="Enter List Priority"><br><br>

				<input type="submit" id="addButton" value="ADD"><br>
			</form:form>
			<br>
			<br>
			<h3>
				View Bucket List
			</h3>
			<input type="button" id="view1" value="VIEW" onclick="document.location.href='view.jsp';"><br>
			<br>
			<br>

			<h3>
				Edit Bucket List
			</h3>

			<form:form action="editList" method="post" modelAttribute="bucketList">
				<input type="text" id="enterId" placeholder="Enter List ID"><br>

				<input type="text" id="enterName" placeholder="Enter List Type"><br>

				<input type="text" id="enterDescription" placeholder="Enter List Description"><br>

				<input type="text" id="enterPriority" placeholder="Enter List Priority"><br><br>

				<input type="button" id="edit1" value="EDIT"><br>
			</form:form>
			<br>
			<br>			
			
			<h3>
				Delete Bucket List
			</h3>
			<form:form action="addList" method="post" modelAttribute="bucketList">
				<input type="text" id="enterId" placeholder="Enter List ID"><br><br>

				<input type="button" id="delete1" value="DELETE"><br>
			</form:form>
			<br>

		</body>

		</html>