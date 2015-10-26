package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ClienteTO;
import Model.EspecialistaCliente;
import Model.EspecialistaVoo;
import Model.VooTO;

/**
 * Servlet implementation class PesquisarCliente
 */
@WebServlet("/pesquisarCliente")
public class PesquisarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		String acao = request.getParameter("acao");
		EspecialistaCliente esp = new EspecialistaCliente();
		ClienteTO cliente = null;
		RequestDispatcher view= null;
		
		if(request.getParameter("codigo") == ""){
			request.setAttribute("msg", "Insira um valor no campo!" );
			view = request.getRequestDispatcher("TelaCliente.jsp");
			view.forward(request, response);
		}
		else
		{
		int codigo =Integer.parseInt(request.getParameter("codigo"));
		switch (acao) 
		{
			case "Pesquisar":
				try{
				cliente = esp.pesquisarCodigo(codigo);
					if(cliente == null){
						request.setAttribute("msg", "Dados não encontrados!" );
						view = request.getRequestDispatcher("TelaCliente.jsp");
						view.forward(request, response);
					}
					else{
						request.setAttribute("listaDeClientes", cliente);
						view = request.getRequestDispatcher("TelaCliente.jsp");
						view.forward(request, response);
					}
				}catch(NumberFormatException e){
					
					request.setAttribute("msg", "Error " + e.getMessage());
					view = request.getRequestDispatcher("TelaCliente.jsp");
					view.forward(request, response);
				}
			break;
		}
			
		}
	}
}
