<%@page import="java.util.*, java.text.*"%>
<%@page import="Model.*, Banco.*, LoginCriando.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="./css/login.css" />
</head>
<script type="text/javascript" language="javascript">
function valida_form (){
if(document.getElementById("txtUsuario").value.length == 0){
alert('Por favor, preencha o campo Usuário');
document.getElementById("txtUsuario").focus();
return false
}
if(document.getElementById("txtSenha").value.length == 0){
	alert('Por favor, preencha o campo Senha');
	document.getElementById("txtSenha").focus();
return false
}
}
</script>

<body>

<form method="post" id="form1" action="loginController" onsubmit="return valida_form(this)">
<div id="conteudo">
	<div id="imagem">
	<img src="img/Login.jpg" width="250px"	height="250px" alt="" id="img_grande" />
	</div>
	
	<div id="dados">	
	<table>
	<tr>
	<td>
	<label>Usuário:</label>
	</td>
	<td>
	<input type="text" name="usuario" id="txtUsuario"></input>
	</td>
	</tr>
	<tr>
	<td>
	<label>Senha:</label>
	</td>
	<td>
	<input type="text" name="senha" id="txtSenha"></input>
	</td>
	</tr>
	<tr>
	<td>
		<label>Tipo:</label>
	</td>
	<td>
	
	<div>
		<select name="cbTipo" size="1">
			<option value=""></option>
			<option value="atendente">Atendente</option>
			<option value="supervisor">Supervisor</option>
		</select>
	</div>
			
	</td>
	</tr>
	</table>
	</div>
	
	<div id="botao">
		<input type="submit" name="acao" value="Entrar">
		<input type="submit" name="acao" value="Sair">  
	</div>
</div>
</form>

</body>
</html>