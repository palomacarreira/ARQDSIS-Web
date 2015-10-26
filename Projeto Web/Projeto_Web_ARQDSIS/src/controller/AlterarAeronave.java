package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.AeronaveTO;
import Model.EspecialistaAeronave;

/**
 * Servlet implementation class AlterarAeronave
 */
@WebServlet("/alterarAeronave")
public class AlterarAeronave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	request.setCharacterEncoding("UTF-8");
	HttpSession session = request.getSession();
	EspecialistaAeronave especialista = new EspecialistaAeronave();
	RequestDispatcher view;
	String acao = request.getParameter("acao");
	switch (acao) 
	{
		case "Cadastrar":
			view = request.getRequestDispatcher("TelaCadastrarAeronave.jsp");
			view.forward(request, response);
			break;
			
		case "Salvar":
			//alteração dado 
			
			AeronaveTO aeronaveTO = new AeronaveTO();
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			String nome = (String)request.getParameter("nome");
			int qtdAssentos = Integer.parseInt(request.getParameter("qtdAssentos"));
			String localAssentos =(String)request.getParameter("localAssentos");
			String tipoAeronave =(String)request.getParameter("tipoAeronave");


			try {
				especialista.alterar(codigo, nome, qtdAssentos, localAssentos, tipoAeronave);
	
				request.setAttribute("msg", "Dados Alterados");
				view = request.getRequestDispatcher("TelaAeronave.jsp");
				view.forward(request, response);
				
			} catch (NumberFormatException e) {
				
				request.setAttribute("msg", "Error " + e.getMessage());
				view = request.getRequestDispatcher("TelaAeronave.jsp");
				view.forward(request, response);
			}
			
		
		break;
		
	case "Excluir":
		
		int cod = Integer.parseInt(request.getParameter("codigo"));
		try {
			especialista.excluir(cod);
			request.setAttribute("msg", "Dados Excluídos");
			view = request.getRequestDispatcher("TelaAeronave.jsp");
			view.forward(request, response);
		} catch (Exception e) {
			
			request.setAttribute("msg", "Error " + e.getMessage());
			view = request.getRequestDispatcher("TelaAeronave.jsp");
			view.forward(request, response);
		}		
		break;
		
	case "Alterar":
	
			try {
				int codg = Integer.parseInt(request.getParameter("codigo"));
				AeronaveTO voo = especialista.pesquisarCodigo(codg);
				request.setAttribute("listaDeAeronaves", voo);
				view = request.getRequestDispatcher("TelaAlterarAeronave.jsp");
				view.forward(request, response);
			} catch (NumberFormatException e) {
				request.setAttribute("msg", "Error " + e.getMessage());
				view = request.getRequestDispatcher("TelaAeronave.jsp");
				view.forward(request, response);
			}
		
		
		break;
		
	case "Cancelar":
		view = request.getRequestDispatcher("TelaAeronave.jsp");
		view.forward(request, response);
		break;
	}
}
}
