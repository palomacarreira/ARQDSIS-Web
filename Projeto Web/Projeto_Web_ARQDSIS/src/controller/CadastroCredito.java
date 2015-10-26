package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Banco.CreditoDAO;
import Model.CreditoTO;
import Model.EspecialistaCredito;
import Model.EspecialistaDebito;
import Model.EspecialistaPassagem;

/**
 * Servlet implementation class CadastroCredito
 */
@WebServlet("/cadastroCredito")
public class CadastroCredito extends HttpServlet {
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
					
					
					EspecialistaCredito especialista = new EspecialistaCredito();
				
					String cpf = (String)request.getParameter("cpf");
					String validadeCartao = (String)request.getParameter("validadeCartao");
					String nomeTitular = (String)request.getParameter("nomeTitular");
					String numeroCartao = (String)request.getParameter("numeroCartao");
					String tipoCartao = (String)request.getParameter("tipoCartao");
					
					especialista.adicionar( cpf, validadeCartao,  nomeTitular,  numeroCartao,
							 tipoCartao);
							
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
		
		}
	}

}
