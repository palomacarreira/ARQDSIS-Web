package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.EspecialistaAeronave;

/**
 * Servlet implementation class CadastrarAeronave
 */
@WebServlet("/cadastrarAeronave")
public class CadastrarAeronave extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		RequestDispatcher view = null;
		String acao = request.getParameter("acao");
		switch (acao) 
		{
		case "Salvar":
			EspecialistaAeronave especialista = new EspecialistaAeronave();
			String nome = (String)request.getParameter("nome");
			int qtdAssentos = Integer.parseInt(request.getParameter("qtdAssentos"));
			String localAssentos =(String)request.getParameter("localAssentos");
			String tipoAeronave =(String)request.getParameter("tipoAeronave");
		
			try {

				especialista.adicionar(nome, qtdAssentos, localAssentos, tipoAeronave);
				request.setAttribute("msg", "Cadastro concluido");
				view = request.getRequestDispatcher("TelaAeronave.jsp");
				view.forward(request, response);
			} catch (NumberFormatException e) {

				request.setAttribute("msg", "Cadastro não pode ser concluido!");
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
