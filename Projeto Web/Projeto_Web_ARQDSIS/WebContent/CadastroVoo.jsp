<%@page import="java.util.*, java.text.*"%>
<%@page import="Model.*, Banco.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Voo</title>
<link rel="stylesheet" href="./css/cadastro.css" />
</head>
<body>
	<h2>Cadastro de Voo</h2>
	
	<form method="post" action="cadastro.voo">
	
	<fieldset id="f1">
			<div>
				<label>Origem:</label> <input type="text" name="origem"> 
				<label>Destino:</label> <input type="text" name="destino"> 
 				<table>
 			<%
			if(request.getAttribute("combo") == null){
				out.println("<tr>");
				out.println("<td><label>Aeronave:</label></td>");
				out.println("<td>");
				out.println("<select name=\"aeronavesDisponiveis\"></select>");
				out.println("</td>");
				out.println("</tr>");
			}
			else{
				out.println("<tr>");
				out.println("<td><label>Aeronave:</label></td>");
				out.println("<td>");
				out.println("<select name=\"codigo\">");
			
				ArrayList<AeronaveTO> lista = (ArrayList<AeronaveTO>) request.getAttribute("combo");
				for (AeronaveTO item : lista) {
				out.println("<option value="+ item.getCodigo()+" style =\"width: 100px; height: 100px\">"+ item.getNome()+"</option>");
				}	
				
				out.println("</select>");
				out.println("</td>");	
				out.println("</tr>");
			}
			
			%>
		</table>
 			</div>
	</fieldset>
	
 	<fieldset id="f2">
 			<div>
 			<label>Data:</label><input type="date" name="data" id="txtData">
 			<label>Hora:</label><input type="time" name="hora" id="txtHora" > 
 			<label>Escalas:</label><input type="text" name="escala" id="txtEscala" > 
 			</div>
 	</fieldset>
 	
 	<fieldset >
 	<legend>Situação:</legend>
 	Espera<input type="radio" name="situacao"  id="espera" value="espera" checked><br>
 	Confirmado<input type="radio" name="situacao"  id="confirmado" value="confirmado"><br>
	Encerrado<input type="radio" name="situacao" id="encerrado" value="encerrado">
 	</fieldset>
 
		<div id="botoes">
			<input type="submit" name="acao" value="Cadastrar">
			<input type="submit" name="acao" value="Cancelar" >
		</div>
		
	</form>
</body>

</html>