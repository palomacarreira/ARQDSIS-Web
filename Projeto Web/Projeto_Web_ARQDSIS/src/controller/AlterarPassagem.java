package controller;

import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.PassagemDAO;
import Model.EspecialistaPassagem;
import Model.PassagemTO;
import dao.DAOFactory;  
/**
 * Servlet implementation class AlterarPassagem
 */
@WebServlet("/alterarPassagem")
public class AlterarPassagem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final int MYSQL = 1;
	public static final int POSTGREE = 2;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	request.setCharacterEncoding("UTF-8");
	HttpSession session = request.getSession();
	EspecialistaPassagem especialista = new EspecialistaPassagem();
	RequestDispatcher view;
	String acao = request.getParameter("acao");
    PassagemDAO passagemDAO = (PassagemDAO) DAOFactory.getDAOFactory(MYSQL).getPassagemDAO();	
	switch (acao) 
	{
		case "Cadastrar":
			
			view = request.getRequestDispatcher("TelaCadastrarPassagem.jsp");
			view.forward(request, response);
			break;
			
		case "Salvar":
			//alteração dado
			
			String horaPartida = (String)request.getParameter("horaPartida");
	        String dataPartida =  (String)request.getParameter("dataPartida");
	        int codigo = Integer.parseInt(request.getParameter("codigo"));
	        
			try {

				especialista.alterar(codigo, horaPartida, dataPartida);
				request.setAttribute("msg", "Cadastro concluido");
				view = request.getRequestDispatcher("TelaPassagem.jsp");
				view.forward(request, response);
				}
			
				catch (NumberFormatException e) {

				request.setAttribute("msg", "Cadastro não pode ser concluido!");
				view = request.getRequestDispatcher("TelaPassagem.jsp");
				view.forward(request, response);

			}
		

		break;
		
	case "Excluir":
		if(request.getParameter("codigo") == null)
		{
			request.setAttribute("msg", "Selecione uma passagem para excluir!");
			view = request.getRequestDispatcher("TelaPassagem.jsp");
			view.forward(request, response);
		}
		else
		{
			String valorPa =(String)(request.getParameter("valor"));
			String fp = (String)(request.getParameter("formaPagamento"));
			int cod = Integer.parseInt(request.getParameter("codigo"));
			
			double valor = Double.parseDouble(valorPa);
					
	    
			PassagemTO passagemTO = passagemDAO.recuperarHora(cod);
	        String horaAtual =  String.format("%tr\n",Calendar.getInstance().getTime());
	        String dataAtual = String.format("%1$te/%1$tm/%1$tY",Calendar.getInstance().getTime());
			String dateStart = passagemTO.getDataPartida() + " " + passagemTO.getHoraPartida()+":00";
			String dateStop = dataAtual + " " + horaAtual;
	
			DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");  
	        
			Date d1 = null;
			Date d2 = null;
			long horas = 0;
			
		
			    
			try {
				
				d1 = (Date)formatter.parse(dateStart);
				d2 = (Date)formatter.parse(dateStop);
	 
				long diff = d2.getTime() - d1.getTime();
				horas = diff / (60 * 60 * 1000) % 24;
			} 
				catch (Exception e1) 
				{
				e1.printStackTrace();
				}
		    
		    if(horas <= 12)
		    {
		    	double valorPassagem = (valor * 0.2);
		    	String valorFinal = Double.toString(valorPassagem);
		    	String codigoFinal = Integer.toString(cod);
		    	request.setAttribute("valor",valorFinal);
		    	request.setAttribute("codigo",codigoFinal);
		    	request.setAttribute("formaPagamento",fp);
		    	view = request.getRequestDispatcher("TelaReembolso.jsp");
				view.forward(request, response);
		    	
		    }
		    else if(horas > 12 && horas < 24)
		    {
		    	double valorPassagem = ( valor * 0.4);
		    	String valorFinal = Double.toString(valorPassagem);
		    	String codigoFinal = Integer.toString(cod);
		    	request.setAttribute("valor",valorFinal);
		    	request.setAttribute("formaPagamento",fp);
		    	request.setAttribute("codigo",codigoFinal);
		    	view = request.getRequestDispatcher("TelaReembolso.jsp");
				view.forward(request, response);
		    
		    }
		    else if(horas > 24 && horas < 48)
		    {
		    	String valorFinal = Double.toString(valor);
		    	String codigoFinal = Integer.toString(cod);
		    	request.setAttribute("valor",valorFinal);
		    	request.setAttribute("codigo",codigoFinal);
		    	request.setAttribute("formaPagamento",fp);
		    	view = request.getRequestDispatcher("TelaReembolso.jsp");
				view.forward(request, response);
		    }
			
		}
		break;
		
		
	case "Cancelar":
		view = request.getRequestDispatcher("TelaPassagem.jsp");
		view.forward(request, response);
		break;
	
	case "Check-in":
		if(request.getParameter("codigo") == null)
		{
			request.setAttribute("msg", "Selecione uma passagem para check-in!");
			view = request.getRequestDispatcher("TelaPassagem.jsp");
			view.forward(request, response);
		}
		else{
		String codigoPesquisa = (String)request.getParameter("codigo");
		try 
		{
			PassagemTO passagemTO = especialista.passagensVendidas(codigoPesquisa);
			request.setAttribute("listaDePassagens", passagemTO);
			view = request.getRequestDispatcher("TelaCheckin.jsp");
			view.forward(request, response);
			
		} catch (NumberFormatException e) {
			request.setAttribute("msg", "Error " + e.getMessage());
			view = request.getRequestDispatcher("TelaPassagem.jsp");
			view.forward(request, response);
		}
		}
		break;

	case "Passagens":
		if(request.getParameter("codigo") == null)
		{
			request.setAttribute("msg", "Selecione uma passagem!");
			view = request.getRequestDispatcher("TelaPassagem.jsp");
			view.forward(request, response);
		}
		else{
		String codigoPesq = (String)request.getParameter("codigo");
		
		try {
			
			PassagemTO passagemTO = especialista.passagensVendidas(codigoPesq);
			request.setAttribute("msg", "Dados Excluídos");
			request.setAttribute("listaDePassagens", passagemTO);
			view = request.getRequestDispatcher("TelaVendas.jsp");
			view.forward(request, response);
		} catch (NumberFormatException e) {
			request.setAttribute("msg", "Error " + e.getMessage());
			view = request.getRequestDispatcher("TelaPassagem.jsp");
			view.forward(request, response);
		}
		}
		break;

	case "Realizar Checkin":
	
		String assentos = (String)request.getParameter("assentos");
        int malas =  Integer.parseInt(request.getParameter("malas"));
        int cd = Integer.parseInt(request.getParameter("codigo"));
        
		try {

			especialista.checkin(cd, assentos, malas);
			request.setAttribute("msg", "Cadastro concluido");
			view = request.getRequestDispatcher("TelaPassagem.jsp");
			view.forward(request, response);
		
		} catch (NumberFormatException e) {
			request.setAttribute("msg", "Error " + e.getMessage());
			view = request.getRequestDispatcher("TelaPassagem.jsp");
			view.forward(request, response);
		}
	
	
	case "Transferir":
	
			
		if(request.getParameter("codigo") == null)
		{
			request.setAttribute("msg", "Selecione uma passagem!");
			view = request.getRequestDispatcher("TelaPassagem.jsp");
			view.forward(request, response);
		}
		else{
		String codigoPesq = (String)request.getParameter("codigo");
		
		try {
			
			PassagemTO passagemTO = especialista.passagensVendidas(codigoPesq);
			request.setAttribute("listaDePassagens", passagemTO);
			view = request.getRequestDispatcher("TelaTransferirPassagem.jsp");
			view.forward(request, response);
		
		} catch (NumberFormatException e) {
			request.setAttribute("msg", "Error " + e.getMessage());
			view = request.getRequestDispatcher("TelaPassagem.jsp");
			view.forward(request, response);
		}
	
		}
	}
	}
}
