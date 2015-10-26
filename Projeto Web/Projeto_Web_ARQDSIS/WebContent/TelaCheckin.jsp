<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@page import="Model.*, Banco.*"%>
<%@page import="java.util.*, java.text.*"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="./css/cadastro.css" />
<title>Check-in</title>
</head>
<body>
	<h2>Check-in</h2>

	<form method="post" action="alterarPassagem">

		<fieldset id="f1">
			<div id="form1">
			<%
			
			PassagemTO aeronave = (PassagemTO)request.getAttribute("listaDePassagens");
			out.println("<label>Codigo:</label><input type=\"text\" name=\"codigo\" value="+aeronave.getCodigo()+">");
			%>
				<label>Assentos disponiveis:</label> <input type="text"	name="assentos"> 
				<label>Qtd de malas:</label><input type="text" name="malas">

			</div>
		</fieldset>
		<div id="botoes">
			<input type="submit" name="acao" value="Realizar Checkin">
		</div>
	</form>
</body>
</html>