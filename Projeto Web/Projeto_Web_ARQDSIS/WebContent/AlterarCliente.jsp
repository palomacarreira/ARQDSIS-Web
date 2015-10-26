<%@page import="java.util.*, java.text.*"%>
<%@page import="Model.*, Banco.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Cliente</title>
<link rel="stylesheet" href="./css/cadastro.css" />
<link rel="stylesheet" href="./css/main.css" />
</head>
<body>
		<h2>Alterar Cliente</</h2>
	<%
	
		ClienteTO lista = (ClienteTO) request.getAttribute("listaDeClientes");
		out.println("<form method=\"post\" action=\"alterar.cliente\">");
		out.println("<fieldset id=\"f1\">");
		out.println("<table><tr>");
		out.println("<label>Código:</label><input type=\"text\" name=\"codigo\" value="+lista.getCodigo()+">");
		out.println("<td><label>Nome:</label><input type=\"text\" name=\"nome\" value="+lista.getNome()+"></td>");
		out.println("<td><label>Tratamento:</label><input type=\"text\" name=\"tratamento\" value="+lista.getTratamento()+" ></td>");
		out.println("<td><label>Data de Nasc.:</label><input type=\"date\" name=\"dataNascimeto\" value="+lista.getDtNascimento()+"></td>");
		out.println("<tr>");
		out.println("<td><label>Telefone:</label><input type=\"telefone\"  name=\"telefone\" value="+lista.getTelefone()+"></td>");
		out.println("<td><label>E-mail:</label><input type=\"email\" name=\"email\" value="+lista.getEmail()+"></td>");
		out.println("<td><label>Cpf:</label><input type=\"text\" name=\"cpf\" value="+lista.getCpf()+"></td>");
		out.println("</tr></table></fieldset>");
		out.println("<fieldset id=\"f2\"><table><tr>");
		
		String tipo = (String) lista.getTipo();
		if(tipo.equals("Bebe")){
			out.println("<td><input type=\"radio\" name=\"tipo\" value=\"Bebe\"checked> Bebe<br></td>");
			out.println("</tr><tr>");
			out.println("<td><input type=\"radio\" name=\"tipo\" value=\"Crianca\"> Crianca<br></td>");
			out.println("</tr><tr>");
			out.println("<td><input type=\"radio\" name=\"tipo\" value=\"Adulto\"> Adulto</td>");
			out.println("</tr></table>");
		}
		else if(tipo.equals("Crianca")){
			out.println("<td><input type=\"radio\" name=\"tipo\" value=\"Bebe\"> Bebe<br></td>");
			out.println("</tr><tr>");
			out.println("<td><input type=\"radio\" name=\"tipo\" value=\"Crianca\"checked> Crianca<br></td>");
			out.println("</tr><tr>");
			out.println("<td><input type=\"radio\" name=\"tipo\" value=\"Adulto\"> Adulto</td>");
			out.println("</tr></table>");
		}
		if(tipo.equals("Adulto")){
			out.println("<td><input type=\"radio\" name=\"tipo\" value=\"Bebe\"> Bebe<br></td>");
			out.println("</tr><tr>");
			out.println("<td><input type=\"radio\" name=\"tipo\" value=\"Crianca\"> Crianca<br></td>");
			out.println("</tr><tr>");
			out.println("<td><input type=\"radio\" name=\"tipo\" value=\"Adulto\"checked> Adulto</td>");
			out.println("</tr></table>");
		}
		
		out.println("</fieldset>");
		out.println("<div id=\"botoes\">");
		out.println("<input type=\"submit\" name=\"acao\" value=\"Salvar\">");
		out.println("<input type=\"submit\" name=\"acao\" value=\"Cancelar\" id=\"cancelar\">");
		out.println("</div>");
		out.println("</form>");
	%>
</body>
</html>