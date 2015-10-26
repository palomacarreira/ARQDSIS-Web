package controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.EspecialistaVoo;
import Model.VooTO;

/**
 * Servlet implementation class pesquisarVoo
 */
@WebServlet("/pesquisarVoo")
public class pesquisarVoo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
		EspecialistaVoo esp = new EspecialistaVoo();
		VooTO voo = null;
		RequestDispatcher view= null;
		
		if(request.getParameter("codigo") == ""){
			request.setAttribute("msg", "Insira um valor no campo!" );
			view = request.getRequestDispatcher("TelaVoo.jsp");
			view.forward(request, response);
		}
		else
		{
		int codigo =Integer.parseInt(request.getParameter("codigo"));
		switch (acao) 
		{
			case "Pesquisar":
				try{
				voo = esp.pesquisarCodigo(codigo);
					if(voo == null){
						request.setAttribute("msg", "Dados não encontrados!" );
						view = request.getRequestDispatcher("TelaVoo.jsp");
						view.forward(request, response);
					}
					else{
						request.setAttribute("listaDeVoos", voo);
						view = request.getRequestDispatcher("TelaVoo.jsp");
						view.forward(request, response);
					}
				}catch(NumberFormatException e){
					
					request.setAttribute("msg", "Error " + e.getMessage());
					view = request.getRequestDispatcher("TelaVoo.jsp");
					view.forward(request, response);
				}
			break;
		}
			
		}
	}
}
