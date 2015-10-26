package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Banco.DebitoDAO;
import Model.DebitoTO;
import Model.EspecialistaDebito;
import Model.EspecialistaPassagem;

/**
 * Servlet implementation class CadastroDebito
 */
@WebServlet("/cadastroDebito")
public class CadastroDebito extends HttpServlet {
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
		{
		
				EspecialistaPassagem esp = new EspecialistaPassagem();
				
				String horaPartida = (String)session.getAttribute("horaPartida");
		        String dataPartida =  (String)session.getAttribute("dataPartida");
		        String qtdPassagem = (String)session.getAttribute("qtdPassagem");
		        String perfil = (String)session.getAttribute("perfil");
		        double valor = (double)session.getAttribute("valor");
		        String formaPagamento = (String) session.getAttribute("formaPagamento");
		        int codigoCliente = (int)(session.getAttribute("codigoCliente"));
		        int codigoVoo = (int)(session.getAttribute("codigoVoo"));
		        
				 
				try {
					
					esp.adicionar( horaPartida, dataPartida,  qtdPassagem, perfil,
							 valor, formaPagamento,  codigoVoo,codigoCliente );
					
					
					EspecialistaDebito especialista = new EspecialistaDebito();
					int agencia = Integer.parseInt(request.getParameter("agencia"));
					String banco = (String)request.getParameter("banco");
					int contaCorr = Integer.parseInt(request.getParameter("contaCorr"));
					String nomeTitular = (String)request.getParameter("nomeTitular");
					String cpf = (String)request.getParameter("cpf");
					String telefone = (String)request.getParameter("telefone");
					
					especialista.adicionar(agencia, banco,contaCorr, nomeTitular, cpf, telefone);
					

					request.setAttribute("msg", "Cadastro concluido");
					view = request.getRequestDispatcher("TelaPassagem.jsp");
					view.forward(request, response);
				} catch (NumberFormatException e) {

					request.setAttribute("msg", "Cadastro não pode ser concluido!");
					view = request.getRequestDispatcher("TelaPassagem.jsp");
					view.forward(request, response);

				}   
		}
		break;
	
		}}

}
