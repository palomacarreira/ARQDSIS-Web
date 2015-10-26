package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Banco.ClienteDAO;
import Model.ClienteTO;
import Model.EspecialistaCliente;

/**
 * Servlet implementation class CadastroCliente
 */
@WebServlet("/cadastro.cliente")
public class CadastroCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		EspecialistaCliente especialista = new EspecialistaCliente();
		RequestDispatcher view;
		request.setCharacterEncoding("UTF-8");
		String acao = request.getParameter("acao");
		switch (acao) 
		{
		
		case "Cadastrar":
		ClienteTO clienteTO = new ClienteTO();
		String tipo = (String) request.getParameter("tipo");
		String tratamento= (String) request.getParameter("tratamento");
		String nome =((String) request.getParameter("nome"));
		String dtNascimento = (String) request.getParameter("dataNascimeto");
		String email = (String) request.getParameter("email");
		String telefone =(String) request.getParameter("telefone");
		String cpf = (String) request.getParameter("cpf");
			

		try {
			
			especialista.adicionar( tipo, tratamento,nome , dtNascimento, email,  telefone,  cpf);
			request.setAttribute("msg", "Dados Cadastrados!");
			view = request.getRequestDispatcher("TelaCliente.jsp");
			view.forward(request, response);
			
		} catch (NumberFormatException e) {
			
			request.setAttribute("msg", "Error " + e.getMessage());
			view = request.getRequestDispatcher("TelaCliente.jsp");
			view.forward(request, response);
		}
		break;
		
		case "Cancelar":
			view = request.getRequestDispatcher("TelaCliente.jsp");
			view.forward(request, response);
			break;
		}
	
	}
}
