package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Banco.AeronaveDAO;
import Banco.VooDAO;
import Model.AeronaveTO;
import Model.EspecialistaVoo;
import Model.VooTO;


/**
 * Servlet implementation class AlterarVoo
 */
@WebServlet("/alterarVoo.do")
public class AlterarVoo extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		EspecialistaVoo especialista = new EspecialistaVoo();
		RequestDispatcher view;
		String acao = request.getParameter("acao");
		switch (acao) 
		{
			case "Cadastrar":
				try
				{
					AeronaveDAO vooDAO = new AeronaveDAO();
					ArrayList<AeronaveTO> voos = vooDAO.recuperarTodasAeronaves();
					if(voos.size() > 0)
					{
						request.setAttribute("combo", voos);
						view = request.getRequestDispatcher("CadastroVoo.jsp");
						view.forward(request, response);
					}
					else{
						response.setContentType("text/html");  
					    PrintWriter out = response.getWriter();  
					    out.println("<script language = 'JavaScript'>");     
					    out.print(" alert(\"Não há voos cadastrados!\");");  
					    out.println(" </script>");  
				        RequestDispatcher rd=request.getRequestDispatcher("TelaVoo.jsp");  
				        rd.include(request,response); 
				    	out.close(); 
					}
				} catch (NumberFormatException e) {
					
					request.setAttribute("msg", "Error " + e.getMessage());
					view = request.getRequestDispatcher("TelaVoo.jsp");
					view.forward(request, response);
				}
				
				break;
				
			case "Salvar":
				//alteração dado 
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			int codigoAeronave = Integer.parseInt(request.getParameter("codigoAeronave"));
			String origem = (String)request.getParameter("origem");
			String destino = (String)request.getParameter("destino");
			String escala = (String)request.getParameter("escala");
			String data = (String)request.getParameter("data");
			String hora = (String)request.getParameter("hora");
			String situacao = (String)(request.getParameter("situacao"));
		
		
			try {
			
				especialista.alterar(origem, destino, escala, data, hora, codigo, codigoAeronave, situacao);
				request.setAttribute("msg", "Dados Alterados");
				view = request.getRequestDispatcher("TelaVoo.jsp");
				view.forward(request, response);
				
			} catch (NumberFormatException e) {
				
				request.setAttribute("msg", "Error " + e.getMessage());
				view = request.getRequestDispatcher("TelaVoo.jsp");
				view.forward(request, response);
			}
			
			break;
			
		case "Excluir":
			
			if(request.getParameter("codigo") == null)
			{
				request.setAttribute("msg", "Selecione um voo para excluir!");
				view = request.getRequestDispatcher("TelaVoo.jsp");
				view.forward(request, response);
			}
			else{
			try {
				int cod = Integer.parseInt(request.getParameter("codigo"));
				especialista.excluir(cod);
				request.setAttribute("msg", "Dados Excluídos");
				view = request.getRequestDispatcher("TelaVoo.jsp");
				view.forward(request, response);
			} catch (Exception e) {
				
				request.setAttribute("msg", "Error " + e.getMessage());
				view = request.getRequestDispatcher("TelaVoo.jsp");
				view.forward(request, response);
			}	
			}
			break;
			
		case "Alterar":
			
			if(request.getParameter("codigo") == null)
			{
				request.setAttribute("msg", "Selecione um voo para alterar!");
				view = request.getRequestDispatcher("TelaVoo.jsp");
				view.forward(request, response);
			}
			else{
			try
			{
				AeronaveDAO vooDAO = new AeronaveDAO();
				ArrayList<AeronaveTO> voos = vooDAO.recuperarTodasAeronaves();
				if(voos.size() > 0)
				{
					int codg = Integer.parseInt(request.getParameter("codigo"));
					VooTO voo = especialista.pesquisarCodigo(codg);
					request.setAttribute("listaDeVoos", voo);
					request.setAttribute("combo", voos);
					view = request.getRequestDispatcher("AlterarVoo.jsp");
					view.forward(request, response);
					
				}
				else{
					response.setContentType("text/html");  
				    PrintWriter out = response.getWriter();  
				    out.println("<script language = 'JavaScript'>");     
				    out.print(" alert(\"Não há voos cadastrados!\");");  
				    out.println(" </script>");  
			        RequestDispatcher rd=request.getRequestDispatcher("TelaVoo.jsp");  
			        rd.include(request,response); 
			    	out.close(); 
				}
			} catch (NumberFormatException e) {
				
				request.setAttribute("msg", "Error " + e.getMessage());
				view = request.getRequestDispatcher("TelaVoo.jsp");
				view.forward(request, response);
			}
			
			}
			break;
			
		case "Cancelar":
			view = request.getRequestDispatcher("TelaVoo.jsp");
			view.forward(request, response);
			break;
		}
	}
	
}


