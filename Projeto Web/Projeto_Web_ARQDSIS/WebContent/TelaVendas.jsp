<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@page import="Model.*, Banco.*"%>
<%@page import="java.util.*, java.text.*"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vendas Passagens</title>
<link rel="stylesheet" href="./css/cadastro.css" />
</head>
<body>
	<h2>Vendas Passagens</h2>

	<form method="post" action="cadastrarPassagem">
		<fieldset id="f1">
			<table>
				<tr>
				<%
		PassagemTO aeronave = (PassagemTO)request.getAttribute("listaDePassagens");
		out.println("<td><label>Codigo:</label><input type=\"text\" name=\"codigo\" value="+ aeronave.getCodigo()+"></td>");
		out.println("<td><label>Data de Partida:</label><input type=\"date\" name=\"dataPartida\" value="+ aeronave.getDataPartida()+"></td>");
		out.println("<td><label>Hora:</label><br /> <input type=\"time\" name=\"horaPartida\" value="+ aeronave.getHoraPartida()+"></td>");
		out.println("<td><label>Codigo do Cliente:</label><input type=\"text\" name=\"codigo\" value="+ aeronave.getCodigoCliente()+"></td>");
		out.println("<td><label>Nome do Cliente:</label><input type=\"text\" name=\"nomeCliente\" value="+ aeronave.getNomeCliente()+"></td>");
		out.println("<td><label>Quantidade de passageiros:</label><input type=\"text\" name=\"qtdPassagem\" value="+ aeronave.getQtdPassageiros()+"></td>");
		out.println("<td><label>Perfil:</label><input type=\"text\" name=\"perfil\" value="+ aeronave.getQtdPassageiros()+"></td>");
		out.println("</tr></table><table><tr>");
		out.println("<td><label>Qtd de malas:</label> <input type=\"text\" name=\"malas\" value="+ aeronave.getQtdMalas()+"></td>");
		out.println("<td><label>Valor Total:</label><br /> <input type=\"text\" name=\"valorTotal\" value="+ aeronave.getValor()+"></td>");
		out.println("<tr><td><label><br />Forma de Pagamento:</label><input type=\"text\" name=\"formaDePagamento\" value="+ aeronave.getFormaPagamento()+"></td>");
		out.println("</tr></table></fieldset><fieldset id=\"f2\"><table><tr>");
		out.println("<td><label>Dados do Voo</label></td></tr>");
		out.println("<tr><td><label>Codigo do voo:</label><input type=\"text\" name=\"codigo\" value="+aeronave.getCodigoVoo()+"></td>");
		out.println("<td><label>Origem:</label><input type=\"text\" name=\"origem\" value="+aeronave.getOrigem()+"></td>");
		out.println("<td><label>Destino:</label><input type=\"text\" name=\"destino\" value="+aeronave.getDestino()+"></td>");
		out.println("</td></tr></table></fieldset><fieldset id=\"f2\"><table><tr>");
		out.println("<td><label>Situacao:</label> <input type=\"text\" name=\"situacao\"  value="+aeronave.getSituacao()+"></td>");
		out.println("<td><label>Escalas:</label><input type=\"text\" name=\"escalas\" value="+aeronave.getEscalas()+"></td>");
		%>
			</tr>
			</table>
		</fieldset>
	</form>

</body>
</html>