package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.AeronaveTO;
import Model.EspecialistaAeronave;

/**
 * Servlet implementation class PesquisarAeronave
 */
@WebServlet("/pesquisarAeronave")
public class PesquisarAeronave extends HttpServlet {
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
		EspecialistaAeronave esp = new EspecialistaAeronave();
		AeronaveTO aeronave = null;
		RequestDispatcher view= null;
		
		if(request.getParameter("codigo") == ""){
			request.setAttribute("msg", "Insira um valor no campo!" );
			view = request.getRequestDispatcher("TelaAeronave.jsp");
			view.forward(request, response);
		}
		else
		{
		int codigo =Integer.parseInt(request.getParameter("codigo"));
		switch (acao) 
		{
			case "Pesquisar":
				try{
					aeronave = esp.pesquisarCodigo(codigo);
					if(aeronave == null){
						request.setAttribute("msg", "Dados não encontrados!" );
						view = request.getRequestDispatcher("TelaAeronave.jsp");
						view.forward(request, response);
					}
					else{
						request.setAttribute("listaDeAeronaves", aeronave);
						view = request.getRequestDispatcher("TelaAeronave.jsp");
						view.forward(request, response);
					}
				}catch(NumberFormatException e){
					
					request.setAttribute("msg", "Error " + e.getMessage());
					view = request.getRequestDispatcher("TelaAeronave.jsp");
					view.forward(request, response);
				}
			break;
		}
			
		}
	}
}


