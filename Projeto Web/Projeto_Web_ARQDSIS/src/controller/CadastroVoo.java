package controller;
import java.io.IOException;
import java.util.Enumeration;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Banco.VooDAO;
import Model.EspecialistaVoo;
import Model.VooTO;

/**
 * Servlet implementation class CadastroVoo
 */
@WebServlet("/cadastro.voo")
public class CadastroVoo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroVoo() {
        super();
        // TODO Auto-generated constructor stub
    }
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

		HttpSession session = request.getSession();
		RequestDispatcher view = null;
		String acao = request.getParameter("acao");
		switch (acao) 
		{
		case "Cadastrar":
			EspecialistaVoo especialista = new EspecialistaVoo();
			String origem = (String)request.getParameter("origem");
			String destino = (String)request.getParameter("destino");
			String escala = (String)request.getParameter("escala");
			String data = (String)request.getParameter("data");
			String hora = (String)request.getParameter("hora");
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			String situacao = (String)(request.getParameter("situacao"));
			
			try {

				especialista.adicionar(origem, destino, escala, data, hora, codigo, situacao);
				request.setAttribute("msg", "Cadastro concluido");
				view = request.getRequestDispatcher("TelaVoo.jsp");
				view.forward(request, response);
			} catch (NumberFormatException e) {

				request.setAttribute("msg", "Cadastro não pode ser concluido!");
				view = request.getRequestDispatcher("TelaVoo.jsp");
				view.forward(request, response);

			}
		
		break;
		case "Cancelar":
			view = request.getRequestDispatcher("TelaVoo.jsp");
			view.forward(request, response);
			break;
		}
	}

}
