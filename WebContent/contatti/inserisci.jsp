<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Contatto</title>
</head>
<body>
	<h1>INSERISCI CONTATTO</h1>
	<form method="POST" action="/RubricaWeb/insert">
	Nome :<input type="text" name="nome" ><br>
	Cognome :<input type="text" name="cognome"><br>
	E-mail :<input type="text" name="email"><br>
	Numero telefono 1:<input type="text" name="numero1"><br>
	Numero telefono 2:<input type="text" name="numero2"><br>
	<input type="submit" value="inserisci"><br>
	
	</form>

</body>
</html>