<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tela Credito</title>
<link rel="stylesheet" href="./css/cadastro.css" />
</head>
<body>

<form method="post" action="cadastroCredito">
<fieldset id="f1">
	<div>
		<label>Cpf:</label> <input type="text" name="cpf"> 
		<label>Data de validade do cartão:</label> <input type="date" name="validadeCartao"> 
		<label>Nome Titular:</label> <input type="text" name="nomeTitular"> 
		<label>Número Cartao:</label> <input type="text" name="numeroCartao"> 
		<label>Tipo Cartao:</label> <input type="text" name="tipoCartao"> 
	</div>
</fieldset>
	<div id="botoes">	
			<input type="submit" name="acao" value="Salvar" style="width: 100px; height: 40px">
		</div>
</form> 

</body>
</html>