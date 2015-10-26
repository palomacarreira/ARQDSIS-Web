<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="./css/cadastro.css" />
<link rel="stylesheet" href="./css/main.css" />
<title>Reembolso</title>
</head>
<body>
	<h2>Reembolso</h2>

	<form method="post" id="form0" action="cadastrarReembolso">
	<div>
	<table>
	<tr>
<td><label>Banco:</label></td><td><input type="text" name="banco"> </td>
<td><label>Agência:</label></td><td><input type="text" name="agencia"> </td>	
<td><label>Conta:</label></td><td><input type="text" name="conta"> 	</td>
</tr>
<tr>
<td><label>Nome titular:</label></td><td><input type="text" name="titular"></td>
<td><label>CPF:</label></td><td><input type="text" name="cpf"></td>
<%
String valor = (String)request.getAttribute("valor");
String codigo = (String)request.getAttribute("codigo");
String formaPagamento = (String)request.getAttribute("formaPagamento");
out.println("<td><label>Código: </label></td><td><input type=\"text\" name=\"codigo\" value="+codigo+"></td></tr>");
out.println("<tr><td><label>Valor: </label></td><td><input type=\"text\" name=\"valor\" value="+valor+"></td>");
out.println("<td><label>Forma de Pagamento:</label></td><td><input type=\"text\" name=\"formaPagamento\" value="+formaPagamento+"></td></tr>");
%> 	  	
	</table>	
  	<div id="botoes">
  		<input type="submit" name="acao" value="Salvar">
		<input type="submit" name="acao" value="Cancelar">
	</div>
</div>

</form>
</body>
</html>