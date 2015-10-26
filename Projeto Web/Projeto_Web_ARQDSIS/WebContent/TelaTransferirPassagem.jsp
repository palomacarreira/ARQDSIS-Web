<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@page import="java.util.*, java.text.*"%>
<%@page import="Model.*, Banco.*"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transferir Passagem</title>
<link rel="stylesheet" href="./css/cadastro.css" />
</head>
<body>
<h2>Transferir Passagem</h2>

	<form method="post" action="alterarPassagem">
		<fieldset id="f1">
			<table>
<%
		PassagemTO lista = (PassagemTO) request.getAttribute("listaDePassagens");
		if(lista == null){
			lista = new PassagemTO();
		}
		else{
		out.println("<tr><td><label>Código Passagem:</label></td>");
		out.println("<td><input type=\"date\" name=\"codigo\" value="+lista.getCodigo()+"></td>");
		out.println("<tr><td><label>Data:</label></td>");
		out.println("<td><input type=\"date\" name=\"dataPartida\" value="+lista.getDataPartida()+"></td>");
		out.println("<td><label>Horário:</label></td>");
		out.println("<td><input type=\"time\" name=\"horaPartida\" value="+lista.getHoraPartida()+"></td></tr>");

		}
%>
			</table>
		</fieldset>
		<div id="botoes">
		<table>
			<tr>
				<td><input type="submit" name="acao" value="Salvar"></td>

			</tr>
		</table>
	</div>
	</form>
</body>
</html>