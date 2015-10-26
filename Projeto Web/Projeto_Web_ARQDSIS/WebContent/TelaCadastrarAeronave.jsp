<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Cadastrar Aeronave</title>
			<link rel="stylesheet" href="./css/cadastro.css" />
			<link rel="stylesheet" href="./css/main.css" />
</head>
<body>

		<h2>Cadastrar Aeronave</h2>
		
		<form method="post" action="cadastrarAeronave">
			<table>
				<tr>
					<td>
						<label>Nome:</label><input type="text" name="nome" size = "20"> 
 					</td>
 					
 					<td>
 						<label>Quantidade de assentos:</label><input type="text" name="qtdAssentos"> 
 					</td>
 				</tr>
 				
 				<tr>
 					<td>
 						<label>Localização dos assentos:</label><input type="text" name="localAssentos"> 
 					</td>
 					
 					<td>
 						<label>Tipo Aeronave:</label><input type="text" name="tipoAeronave">
 					</td>
				</tr>
	
			</table>
			
		<!-- Botoes -->
		
		<div id="botoes">	
			<input type="submit" name="acao" value="Salvar" style="width: 100px; height: 40px">
    		<input type="submit"  name="acao" value="Cancelar" style="width: 100px; height: 40px">
		</div>
		
	   </form>

	</body>
</html>