package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.EspecialistaLogin;
import Model.Idioma;

/**
 * Servlet implementation class loginController
 */
@WebServlet("/loginController")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String acao = request.getParameter("acao");
		switch (acao) 
		{
			case "Entrar":
				
			
			String cbTipo = (String) request.getParameter("cbTipo");
			String usuario = (String)request.getParameter("usuario");
			String senha =(String) request.getParameter("senha");
			EspecialistaLogin especialista = new EspecialistaLogin();
			
			boolean verifica = especialista.verificaLogin(usuario, senha, cbTipo);
			if(verifica){
				request.setAttribute("tipoFuncionario", cbTipo );
				RequestDispatcher view = request.getRequestDispatcher("TelaPrincipal.jsp");
				view.forward(request, response);
			} 
			else{
			response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		    out.print("<h2>Login não encontrado</h2>");  
	        RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");  
	        rd.include(request,response); 
	    	out.close();  
			}
	    	break;
			case "Sair":
				RequestDispatcher view = request.getRequestDispatcher("Login.jsp");
				view.forward(request, response);
			break;
		
	}
	}
}
		

