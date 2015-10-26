<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@page import="java.util.*, java.text.*"%>
<%@page import="Model.*, Banco.*"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="./css/TelaPassagem.css" />
<title>Passagem</title>
</head>
<body>
	<a href="TelaPrincipal.jsp">Voltar</a><h2>Passagem</h2>
	<form method="post" id="form0" action="pesquisarPassagem">
	<div>
 		<label>Filtro:</label><input type="text" name="codigo"> 
		<select name="filtrocombo" size="1">
			<option value=""></option>
			<option value="codigo">Código</option>
		</select>
  			<input type="submit" name="acao" value="Pesquisar">
	</div>
	</form>
	
	
<form method="post" action="alterarPassagem"  id="form1">
	<table>
	<tbody>
	<%
		PassagemTO lista = (PassagemTO) request.getAttribute("listaDePassagens");
		if(lista == null){
			lista = new PassagemTO();
		}
		else{
		out.println("<tr><td><label>Código</label></td>");
		out.println("<td><div class=\"nomeOrigem\"><input type=\"text\" name=\"codigo\" value="+lista.getCodigo()+" /></div></td>");
		out.println("<td><label>Data de partida:</label></td>");
		out.println("<td><div class=\"nomeOrigem\"><input type=\"text\" name=\"dataPartida\" value="+lista.getDataPartida()+" /></div></td></tr>");
		out.println("<td><label>Forma de Pagamento:</label></td>");
		out.println("<td><div class=\"nomeOrigem\"><input type=\"text\" name=\"formaPagamento\" value="+lista.getFormaPagamento()+" /></div></td></tr>");
		out.println("<td><label>Valor:</label></td>");
		out.println("<td><div class=\"nomeOrigem\"><input type=\"text\" name=\"valor\" value="+lista.getValor()+" /></div></td></tr>");
		out.println("</tr>");
		}
%>
<!-- Mostra mensagem erro ou dado não encontrado  -->
	${msg} 
	</tbody>
	</table>
		<div id="form2">
		<input type="submit"  name="acao"  value="Cadastrar" >
	    <input type="submit"  name="acao" value="Excluir"> 
	    <input type="submit"  name="acao" value="Transferir">
		<input type="submit"  name="acao" value="Check-in">
	    <input type="submit"  name="acao" value="Passagens">
		</div>
	</form>

</body>
</html>