<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teorema de Pitágoras</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<h1>Teorema de Pitágoras</h1>
	<p>Introduce 2 valores y calcularemos el restante.</p>
	

    <c:if test="${not empty c1 and c1 ne '' and not empty c2 and c2 ne '' and c1 eq c2}">
        <p>Los ángulos de este triángulo serán de 45º, 45º y 90º</p>
    </c:if>


	<form method="get" action="PitagorasServlet">
		<div>
			<label for="c1">Cateto 1</label>
			<input type="number" id="c1" name="c1" value="${c1}" step="0.01" min="0" />
		</div>
		
		<div>		
			<label for="c2">Cateto 2</label>
			<input type="number" id="c2" name="c2" value="${c2}" step="0.01" min="0" />
		</div>
		
		<div>
			<label for="hypotenuse">Hipotenusa</label>
			<input type="number" id="hypotenuse" name="hypotenuse" value="${hypo}" step="0.01" min="0" />
		</div>
		
		<input type="submit" value="Calcular" />
	</form>
</body>
</html>