<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci contatto</title>
</head>
<body>
	<h1>MODIFICA CONTATTO</h1>
		<form method="post" action="/RubricaWeb/update">
		    ID: <input type="text" name="id"><br>
			Nome : <input type="text" name="nome"><br>
			Cognome : <input type="text" name="cognome"><br>
			Email:<input type="text" name="email"><br>
			<h3>Numero di Telefono</h3>
			<input type="hidden" name="operazione" value="insert">
			Numero1: <input type="text" name="numero1"><br>
			Numero2 : <input type="text" name="numero2"><br>
			
			<input type="submit" value="inserisci"><br>
			
		</form>
</body>
<