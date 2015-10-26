<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@page import="Model.*, Banco.*"%>
<%@page import="java.util.*, java.text.*"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Aeronave</title>
			<link rel="stylesheet" href="./css/cadastro.css" />
<link rel="stylesheet" href="./css/main.css" />
</head>
<body>

		<h2>Alterar Aeronave</h2>
			
<%
		AeronaveTO aeronave = (AeronaveTO)request.getAttribute("listaDeAeronaves");
		out.println("<form method=\"post\" action=\"alterarAeronave\">");
		out.println("<fieldset id=\"f1\">");
		out.println("<div>");
		out.println("<label>Codigo:</label><input type=\"text\" name=\"codigo\" value="+aeronave.getCodigo()+">");
		out.println("<label>Nome:</label><input type=\"text\" name=\"nome\" value="+aeronave.getNome()+">");
		out.println("<label>Quantidade de Assentos:</label><input type=\"text\" name=\"qtdAssentos\" value="+aeronave.getQtdAssentos()+">");
		out.println("<div>");
		out.println("<label>Localização dos Assentos:</label><input type=\"text\" name=\"localAssentos\" value="+aeronave.getLocalAssentos()+">");
		out.println("<label>Aeronave:</label><input type=\"text\" name=\"tipoAeronave\" value="+aeronave.getTipoAeronave()+">");
		out.println("</div>");
		out.println("</fieldset>");
		
		out.println("<div id=\"botoes\">");
		out.println("<input type=\"submit\" name=\"acao\" value=\"Salvar\">");
		out.println("<input type=\"submit\" name=\"acao\" value=\"Cancelar\">");
		out.println("</div>");
		out.println("</form>");
						
	%>
		
	</body>
</html>