<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@page import="java.util.*, java.text.*"%>
<%@page import="Model.*, Banco.*"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="./css/TelaVoo.css" />
<title>Aeronave</title>
</head>
<body>
	<a href="TelaPrincipal.jsp">Voltar</a><h2>Aeronave</h2>
	<form method="post" id="form0" action="pesquisarAeronave">
		<div>
			<label>Filtro:</label><input type="text" name="codigo" size="30">
			<select name="filtrocombo" size="1">
				<option value=""></option>
				<option value="CódigoCombo">Código</option>
			</select> 
		 		<input type="submit" name="acao" value="Pesquisar">
			</div>
	</form>

<form method="post" action="alterarAeronave"  id="form1">
	<table>
	<tbody>
	<%
		AeronaveTO lista = (AeronaveTO) request.getAttribute("listaDeAeronaves");
		if(lista == null){
			lista = new AeronaveTO();
		}
		else{
		out.println("<tr><td><label>Código</label></td>");
		out.println("<td><div class=\"nomeOrigem\"><input type=\"text\" name=\"codigo\" value="+lista.getCodigo()+" /></div></td>");
		out.println("<td><label>Origem:</label></td>");
		out.println("<td><div class=\"nomeOrigem\"><input type=\"text\" name=\"origem\" value="+lista.getNome()+" /></div></td></tr>");
		out.println("</tr>");
		}
%>
<!-- Mostra mensagem erro ou dado não encontrado  -->
	${msg} 
	</tbody>
	</table>
		<div id="form2">
			<input type="submit" id="botaoCadastrar" name="acao" value="Cadastrar" >
			<input type="submit" id="botaoAlterar" name="acao" value="Alterar">
			<input type="submit" id="botaoExcluir" name="acao" value="Excluir">
		</div>
	</form>
	
</body>
</html>