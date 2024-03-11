<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teorema de Pitágoras</title>
</head>
<body>
	<h1>Teorema de Pitágoras</h1>
	<p>Introduce 2 valores y calcularemos el restante.</p>
	
	<form method="get" action="PitagorasServlet">
		<label for="c1">Cateto 1</label>
		<input type="number" id="c1" name="c1" value="" />
		
		<label for="c2">Cateto 2</label>
		<input type="number" id="c2" name="c2" value="" />
		
		<label for="hypotenuse">Hipotenusa</label>
		<input type="number" id="hypotenuse" name="hypotenuse" value="" />
		
		<input type="submit" value="Calcular" />
	</form>
</body>
</html>