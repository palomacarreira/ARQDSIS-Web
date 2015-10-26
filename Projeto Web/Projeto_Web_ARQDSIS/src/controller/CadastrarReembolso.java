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
import Model.EspecialistaPassagem;
import Model.EspecialistaReembolso;

/**
 * Servlet implementation class CadastrarReembolso
 */
@WebServlet("/cadastrarReembolso")
public class CadastrarReembolso extends HttpServlet {
	
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
			EspecialistaReembolso especialista = new EspecialistaReembolso();
			EspecialistaPassagem esp = new EspecialistaPassagem();
			
			double valor = (Double.parseDouble(request.getParameter("valor")));
			String banco = (String) request.getParameter("banco");
			String agencia = (String) request.getParameter("agencia");
			String conta = (String) request.getParameter("conta");
			String nomeTitula = (String) request.getParameter("titular");
			String cpf = (String) request.getParameter("cpf");
			int codigo =Integer.parseInt(request.getParameter("codigo"));
			String formaPagamento = (String) request.getParameter("formaPagamento");	
			
			try {
				especialista.adicionar(agencia, banco, conta, cpf, nomeTitula, valor,codigo);
				esp.excluirPassagem(codigo,formaPagamento);
				request.setAttribute("msg", "Dados Excluídos");
				view = request.getRequestDispatcher("TelaPassagem.jsp");
				view.forward(request, response);
				
			} catch (NumberFormatException e) {

				request.setAttribute("msg", "Exclusão não pode ser concluida!");
				view = request.getRequestDispatcher("TelaPassagem.jsp");
				view.forward(request, response);
			}
			
		break;
		case "Cancelar":
			view = request.getRequestDispatcher("TelaPassagem.jsp");
			view.forward(request, response);
			break;
		}
	}


}
