<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro Cliente</title>
<link rel="stylesheet" href="./css/cadastro.css" />
<link rel="stylesheet" href="./css/main.css" />
</head>
<body>
	<h2>Cadastro Cliente</</h2>

	<form method="post" action="cadastro.cliente">

		<fieldset id="f1">
			<table>
				<tr>
					<td><label>Nome:</label><input type="text" name="nome"></td>
					<td><label>Tratamento:</label><input type="text" name="tratamento"></td>
					<td><label>Data de Nasc.:</label><input type="date"	name="dataNascimeto"></td>
					<td><label>Telefone:</label><input type="telefone"	name="telefone"></td>
					</td>
					<tr>
					<td><label>E-mail:</label><input type="email" name="email"></td>
					<td><label>Cpf:</label><input type="text" name="cpf"></td>
				</tr>
			</table>
		</fieldset>
		<fieldset id="f2">
			<table>
				<tr>
					<td><input type="radio" name="tipo" value="Bebe"> Bebe<br></td>
				</tr>
				<tr>
					<td><input type="radio" name="tipo" value="Crianca"> Crianca<br></td>
				</tr>
				<tr>
					<td><input type="radio" name="tipo" value="Adulto"> Adulto</td>
				</tr>
			</table>
		</fieldset>

	<div id="botoes">
		<input type="submit" name="acao" value="Cadastrar"> 
		<input type="submit" name="acao" value="Cancelar">
	</div>
	
	</form>
</body>
</html>