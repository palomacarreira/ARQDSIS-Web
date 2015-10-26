package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Banco.ClienteDAO;
import Banco.VooDAO;
import Model.EspecialistaPassagem;
import Model.PassagemTO;
import Model.VooTO;

/**
 * Servlet implementation class PesquisarPassagem
 */
@WebServlet("/pesquisarPassagem")
public class PesquisarPassagem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PesquisarPassagem() {
        super();
        // TODO Auto-generated constructor stub
    }

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

		RequestDispatcher view= null;
		
		EspecialistaPassagem especilista = new EspecialistaPassagem();
		switch (acao) 
		{
		
		case "Pesquisar":
			try{
				
				PassagemTO passagem = especilista.pesquisarCodigo(request.getParameter("codigo"));
				if(passagem == null){
					request.setAttribute("msg", "Dados não encontrados!" );
					view = request.getRequestDispatcher("TelaPassagem.jsp");
					view.forward(request, response);
				}
				else{
					request.setAttribute("listaDePassagens", passagem);
					view = request.getRequestDispatcher("TelaPassagem.jsp");
					view.forward(request, response);
				}
			}catch(NumberFormatException e){
				
				request.setAttribute("msg", "Error " + e.getMessage());
				view = request.getRequestDispatcher("TelaVoo.jsp");
				view.forward(request, response);
			}
		break;
		
		case "Pesquisar CPF":
		
			try
			{
				
				ClienteDAO clienteDAO = new ClienteDAO();
				String usuario = (String)request.getParameter("cpf");
				
			 if(usuario != null)
			 {
				String codigoCliente =especilista.pesquisarCPF(request.getParameter("cpf"));	
				if(codigoCliente == "")
				{
					
						 request.setAttribute("valor", "Não");
							response.setContentType("text/html");  
						    PrintWriter out = response.getWriter();  
						    out.println("<script language = 'JavaScript'>");     
						    out.print(" alert(\"Cpf não cadastrado!\");");  
						    out.println(" </script>");  
					        RequestDispatcher rd=request.getRequestDispatcher("TelaCadastrarPassagem.jsp");  
					        rd.include(request,response); 
					    	out.close(); 
					 
				}
				else{
				VooDAO vooDAO = new VooDAO();
				ArrayList<VooTO> voos = vooDAO.recuperarTodosVoos();
				if(voos.size() > 0)
				{
						 view = request.getRequestDispatcher("TelaCadastrarPassagem.jsp");
						 request.setAttribute("combo", voos);
						 request.setAttribute("valor", "Sim");
						 request.setAttribute("codigoCliente", codigoCliente);
						 view.forward(request, response);
				}
					
				else{
					request.setAttribute("valor", "Não");
					response.setContentType("text/html");  
				    PrintWriter out = response.getWriter();  
				    out.println("<script language = 'JavaScript'>");     
				    out.print(" alert(\"Não há voos cadastrados!\");");  
				    out.println(" </script>");  
			        RequestDispatcher rd=request.getRequestDispatcher("TelaCadastrarPassagem.jsp");  
			        rd.include(request,response); 
			    	out.close(); 
				}
			 }
			 }
	}catch(NumberFormatException e){
			
			request.setAttribute("msg", "Error " + e.getMessage());
			view = request.getRequestDispatcher("TelaCadastrarPassagem.jsp");
			view.forward(request, response);
		}
		break;
		
	}
}

}
