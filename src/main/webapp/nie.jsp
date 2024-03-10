<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Letra NIE</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<h1>Calcula la letra de NIE</h1>
	<form method="get" action="NieServlet">
		<input type="text" name="nie" minLength="5" maxLength="8" />
	 	<input type="submit" value="Enviar" />
	</form>
</body>
</html>