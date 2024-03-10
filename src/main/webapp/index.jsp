<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>La letra de tu dni</title>
</head>
<body>
<jsp:include page="menu.jsp" />
 <%
    double num = Math.random();
    if (num > 0.5) {
  %>
      <h2>Lo que costó!!!</h2><p>(<%= num + 10 %>)</p>
  <%
    } else {
  %>
      <h2>Well, life goes on ... </h2><p>(<%= num %>)</p>
  <%
    }
  %>
  <a href="<%= request.getRequestURI() %>"><h3>Try Again</h3></a>
  
  <form>
    <label for="dni">DNI</label>
  	<input type="text" id="dni" name="dni" />
  	<input type="button" id="send" value="Calcular letra">
  </form>
  <div id="result">
  </div>
  
  <form method="get" action="DniServlet">
  	<input type="text" name="nif" />
  	<input type="submit" value="Enviar" />
  </form>
  
  <script>
  	const btn = document.getElementById("send");
  	const dni = document.getElementById("dni");
  	const letras = ['T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E', 'T'];
  	const result = document.getElementById("result");
  	
  	btn.addEventListener("click", () => {
		if (parseInt(dni.value.trim())) {
  			result.innerText = dni.value + "-" + letras[dni.value.trim()%23];
		} else {
			result.innerText = '¡Dni incorrecto!'
		}
		
		dni.value = '';
  	});
  </script>
</body>
</html>