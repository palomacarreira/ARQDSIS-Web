<%@page import="java.util.*, java.text.*"%>
<%@page import="Model.*, Banco.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Voo</title>
<link rel="stylesheet" href="./css/cadastro.css" />
</head>
<body>
	<h2>Alterar Voo</h2>
	
<%
		VooTO lista = (VooTO) request.getAttribute("listaDeVoos");
		out.println("<form method=\"post\" action=\"alterarVoo.do\">");
		out.println("<fieldset id=\"f1\">");
		out.println("<div>");
		out.println("<label>Código:</label><input type=\"text\" name=\"codigo\" value="+lista.getCodigo()+">");
		out.println("<label>Origem:</label><input type=\"text\" name=\"origem\" value="+lista.getOrigem()+">");
		out.println("<label>Destino:</label><input type=\"text\" name=\"destino\" value="+lista.getDestino()+">");
		out.println("<label>Tipo Aeronave:</label></br>");
		out.println("<select name=\"codigoAeronave\" id=\"codigoAeronave\">");
		
		ArrayList<AeronaveTO> listas = (ArrayList<AeronaveTO>) request.getAttribute("combo");
		for (AeronaveTO item : listas) {
			if(lista.getCodigoAeronave() == item.getCodigo())
			{
				out.println("<option value="+ item.getCodigo()+" style =\"width: 100px; height: 100px\" selected>"+ item.getNome() +"</option>");	
			}
			else{
			out.println("<option value="+ item.getCodigo()+" style =\"width: 100px; height: 100px\">"+ item.getNome() +"</option>");
			}
		}	
		out.println("</select>");
		out.println("</div>");
		out.println("</fieldset>");
		out.println("<fieldset id=\"f2\">");
		out.println("<div>");
		out.println("<label>Data:</label><input type=\"date\" name=\"data\" id=\"txtData\" value="+lista.getData()+">");
		out.println("<label>Hora:</label><input type=\"time\" name=\"hora\" id=\"txtHora\" value="+lista.getHora()+">");
		out.println("<label>Escalas:</label><input type=\"text\" name=\"escala\" id=\"txtEscala\" value="+lista.getEscala()+">");
		out.println("</div>");
		out.println("</fieldset>");
		out.println("<fieldset>");	
		out.println("<legend>Situação:</legend>");

		String situacao = (String) lista.getSituacao();
		if(situacao.equals("confirmado")){
			out.println("Espera<input type=\"radio\" name=\"situacao\"  id=\"espera\" value=\"espera\" /><br>");
			out.println("Confirmado<input type=\"radio\" name=\"situacao\"  id=\"confirmado\" value=\"confirmado\" checked/><br>");
			out.println("Encerrado<input type=\"radio\" name=\"situacao\" id=\"encerrado\" value=\"encerrado\" />");
			
			}
		
		if(situacao.equals("espera")){
			out.println("Espera<input type=\"radio\" name=\"situacao\"  id=\"espera\" value=\"espera\" checked/><br>");
			out.println("Confirmado<input type=\"radio\" name=\"situacao\"  id=\"confirmado\" value=\"confirmado\"/><br>");
			out.println("Encerrado<input type=\"radio\" name=\"situacao\" id=\"encerrado\" value=\"encerrado\" />");

		}
		
		if(situacao.equals("encerrado")){
			out.println("Espera<input type=\"radio\" name=\"situacao\"  id=\"espera\" value=\"espera\"/><br>");
			out.println("Confirmado<input type=\"radio\" name=\"situacao\"  id=\"confirmado\" value=\"confirmado\" /><br>");
			out.println("Encerrado<input type=\"radio\" name=\"situacao\" id=\"encerrado\" value=\"encerrado\" checked/>");
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