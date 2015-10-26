package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Banco.ClienteDAO;
import Model.ClienteTO;
import Model.EspecialistaCliente;

/**
 * Servlet implementation class AlterarCliente
 */
@WebServlet("/alterar.cliente")
public class AlterarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	request.setCharacterEncoding("UTF-8");
	HttpSession session = request.getSession();
	EspecialistaCliente especialista = new EspecialistaCliente();
	RequestDispatcher view;
	String acao = request.getParameter("acao");
	switch (acao) 
	{
		case "Cadastrar":
			
			view = request.getRequestDispatcher("CadastroCliente.jsp");
			view.forward(request, response);
			break;
			
		case "Salvar":
			//alteração dado 
			
			ClienteTO clienteTO = new ClienteTO();
			String tipo = (String) request.getParameter("tipo");
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			String tratamento= (String) request.getParameter("tratamento");
			String nome =((String) request.getParameter("nome"));
			String dtNascimento = (String) request.getParameter("dataNascimeto");
			String email = (String) request.getParameter("email");
			String telefone =(String) request.getParameter("telefone");
			String cpf = (String) request.getParameter("cpf");
				

			try {
				
				especialista.alterar(codigo, tipo, tratamento, nome, dtNascimento, email, telefone, cpf);
				request.setAttribute("msg", "Dados Alterados");
				view = request.getRequestDispatcher("TelaCliente.jsp");
				view.forward(request, response);
				
			} catch (NumberFormatException e) {
				
				request.setAttribute("msg", "Error " + e.getMessage());
				view = request.getRequestDispatcher("TelaCliente.jsp");
				view.forward(request, response);
			}
			
		
		break;
		
	case "Excluir":
		if(request.getParameter("codigo") == null)
		{
			request.setAttribute("msg", "Selecione um cliente para excluir!");
			view = request.getRequestDispatcher("TelaCliente.jsp");
			view.forward(request, response);
		}
		else{
		int cod = Integer.parseInt(request.getParameter("codigo"));
		try {
			especialista.excluir(cod);
			request.setAttribute("msg", "Dados Excluídos");
			view = request.getRequestDispatcher("TelaCliente.jsp");
			view.forward(request, response);
		} catch (Exception e) {
			
			request.setAttribute("msg", "Error " + e.getMessage());
			view = request.getRequestDispatcher("TelaCliente.jsp");
			view.forward(request, response);
		}	
		}
		break;
		
	case "Alterar":
		if(request.getParameter("codigo") == null)
		{
			request.setAttribute("msg", "Selecione um cliente para alterar!");
			view = request.getRequestDispatcher("TelaCliente.jsp");
			view.forward(request, response);
		}
		else{
			try {
				int codg = Integer.parseInt(request.getParameter("codigo"));
				ClienteTO voo = especialista.pesquisarCodigo(codg);
				request.setAttribute("listaDeClientes", voo);
				view = request.getRequestDispatcher("AlterarCliente.jsp");
				view.forward(request, response);
			} catch (NumberFormatException e) {
				request.setAttribute("msg", "Error " + e.getMessage());
				view = request.getRequestDispatcher("TelaCliente.jsp");
				view.forward(request, response);
			}
		}
		
		break;
		
	case "Cancelar":
		view = request.getRequestDispatcher("TelaCliente.jsp");
		view.forward(request, response);
		break;
	}
}
}
