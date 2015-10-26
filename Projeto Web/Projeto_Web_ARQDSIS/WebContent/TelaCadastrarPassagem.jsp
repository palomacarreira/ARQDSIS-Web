
<%@page import="java.util.*, java.text.*"%>
<%@page import="Model.*, Banco.*, LoginCriando.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Passagem</title>
<link rel="stylesheet" href="./css/cadastro.css" />
</head>
<script type="text/javascript" language="javascript">
function valida_form (){
if(document.getElementById("txtCpf").value.length == 0){
alert('Por favor, preencha o campo Cpf');
document.getElementById("txtCpf").focus();
return false
}
}
</script>

<body>
	<h2>Cadastro de Passagem</h2>
	
	<form method="post" id="form1" action="pesquisarPassagem" onsubmit="return valida_form(this)">
	<div>
		<table>
			<tr>
			<td><label>CPF:</label></td><td><input type="text" id="txtCpf" name="cpf"></td>
			<td><input type="submit" name="acao" value="Pesquisar CPF"></td>
				${msg} 
 			</tr>
 		</table>
	</div>
	</form>

	
	<fieldset id="cadastroDados" disabled>
	<form method="post" action="cadastrarPassagem" >
		<table >
 			<tr>
 			<%
			if(request.getAttribute("codigoCliente") != null){
				String codigoCliente = (String) request.getAttribute("codigoCliente");
				out.println("<td><label>Codigo Cliente:</label></td>");
				out.println("<td><input type=\"text\" id=\"codigoCliente\" name=\"codigoCliente\" value="+codigoCliente +"></td>");		
			}
			
			%>
			
 			<td><label>Data de Partida:</label></td>
 			<td><input type="date" id ="dataPartida" name="dataPartida" value="00/00/00"></td>
 			<td><label>Hora:</label></td>
			<td><input type="time" name="horaPartida" value="00:00"></td>
 			<td><label>Valor da passagem:</label></td>
 			<td><input type="text" name="valor"></td>
			</tr>	
   
			<tr>
			<td><label>Quantidade de passageiros:</label></td>
 			<td><input type="text" name="qtdPassagem"></td>
			<td><label>Perfil:</label></td>
			<td>Bebê<input type="radio" name="perfil" value="bebe" checked></td>
			<td>Criança <input type="radio" name="perfil" value="crianca"></td>
			<td>Adulto <input type="radio" name="perfil" value="adulto"></td>
			</tr>  
 			
 			
 			<%
		if(request.getAttribute("combo") == null){
			out.println("<tr>");
			out.println("<td><label>Voos Disponiveis:</label></td>");
			out.println("<td><select name=\"codigoVoo\"></select></td>");
			out.println("</tr>");
		}
		else{
			out.println("<tr>");
			out.println("<td><label>Voos Disponiveis:</label></td>");
			out.println("<td>");
			out.println("<select name=\"codigoVoo\">");
			out.println("<option value=\"\"></option>");
			ArrayList<VooTO> lista = (ArrayList<VooTO>) request.getAttribute("combo");
			for (VooTO item : lista) {
			out.println("<option value="+ item.getCodigo()+" style =\"width: 100px; height: 100px\">"+ item.getOrigem()+"</option>");
			}	
			
			out.println("</select>");
			out.println("</td>");	
			out.println("</tr>");
		}
			%>
		
			<td><label>Forma de Pagamento:</label></td>
			<td><select name="formaPagamento">
						<option value="Debito" style = "width: 100px; height: 100px; size = 40px;"> Débito</option>
				        <option value="Credito" style = "width: 100px; height: 100px; size = 40px;"> Crédito</option>						
					</select>
				</td>
			</tr>
		</table>
		<div id="botoes">
		<table>
			<tr>
   				<td><input type="submit" name="acao" value="Continuar"></td>
   				<td><input type="submit" name="acao" value="Cancelar"></td>
	   		</tr>
  		 </table>	     
		</div>
	</form>
	</fieldset>
	

	<%
	
	if(request.getAttribute("valor") == null){
		
	}
	else{ 
	String valor = (String) request.getAttribute("valor");
	if(valor.equals("Sim")){
		%><script>document.getElementById("cadastroDados").disabled = false;
		</script><%
	}	else{
		%><script>document.getElementById("cadastroDados").disabled = true;
		</script><%
	}
	
	}

	%>

</body>
</html>