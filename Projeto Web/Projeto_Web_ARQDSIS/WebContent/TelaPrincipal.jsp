<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tela Principal</title>
<link rel="stylesheet" href="./css/telaPrincipal.css" />
</head>
<body>
<%
	 	String cbTipo =(String) request.getAttribute("tipoFuncionario");
		session.setAttribute("tipoFuncionario", cbTipo);
%>

<nav>
  <ul class="menu">
        <li><a href="Login.jsp">Sair</a></li>
        <li><a href="TelaAeronave.jsp">Aeronave</a></li>
        <li><a href="TelaCliente.jsp">Cliente</a></li>
        <li><a href="TelaPassagem.jsp">Passagem</a></li>
        <li><a href="TelaVoo.jsp">Voo</a></ul>
</nav> 

<img src="img/painelPrincipal.jpg" width="100%"/>
</body>
</html>