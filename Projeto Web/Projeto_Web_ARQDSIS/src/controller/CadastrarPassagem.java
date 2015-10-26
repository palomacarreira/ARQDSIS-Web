package controller;

import java.awt.Component;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import Banco.PassagemDAO;
import Model.EspecialistaPassagem;
import Model.PassagemTO;

/**
 * Servlet implementation class CadastrarPassagem
 */
@WebServlet("/cadastrarPassagem")
public class CadastrarPassagem extends HttpServlet {
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
		case "Cancelar":
		
			view = request.getRequestDispatcher("TelaPassagem.jsp");
			view.forward(request, response);
			break;
			
		case "Continuar":
		
			String horaPartida = (String)request.getParameter("horaPartida");
	        String dataPartida =  (String)request.getParameter("dataPartida");
	        String qtdPassagem = (String)request.getParameter("qtdPassagem");
	        String perfil = (String)request.getParameter("perfil");
	        double valor = Double.parseDouble(request.getParameter("valor"));
	        String formaPagamento = request.getParameter("formaPagamento");
	        int codigoCliente = Integer.parseInt(request.getParameter("codigoCliente"));
	        int codigoVoo = Integer.parseInt(request.getParameter("codigoVoo"));
	        
	        
	        session.setAttribute("horaPartida",horaPartida);
	        session.setAttribute("dataPartida",dataPartida);
	        session.setAttribute("qtdPassagem",qtdPassagem);
	        session.setAttribute("perfil",perfil);
	        session.setAttribute("valor",valor);
	        session.setAttribute("formaPagamento",formaPagamento);
	        session.setAttribute("codigoCliente",codigoCliente);
	        session.setAttribute("codigoVoo",codigoVoo);
			

		    String frmPag = request.getParameter("formaPagamento");
			if(frmPag.equals("Credito"))
			{
				view = request.getRequestDispatcher("TelaCredito.jsp");
				view.forward(request, response);	 
			}
			else
			{
				view = request.getRequestDispatcher("TelaDebito.jsp");
				view.forward(request, response);	 
			}
		
			  break;
		}  
	
	}
	}

