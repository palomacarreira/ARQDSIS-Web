package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.JSONArray;
import org.JSONObject;
import org.apache.jasper.tagplugins.jstl.core.Out;

import Banco.PassagemDAO;
import Model.EspecialistaPassagem;
import Model.PassagemTO;


/**
 * Servlet implementation class PesquisarPassagem
 */
@WebServlet("/PesquisarPassagemJson")
public class PesquisarPassagemJson extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//doPost(request, response);
		System.out.println("Begin");
		String origem = request.getParameter("origem");
		String destino = request.getParameter("destino");

		PassagemDAO passagemDao = new PassagemDAO();
		ArrayList<PassagemTO> list = passagemDao.recuperaPassagem(origem, destino);
		
		if(list != null){
			
			JSONArray json = new JSONArray();
			for(int i = 0; i < list.size(); i++){
				PassagemTO passagem = list.get(i);
				JSONObject object = new JSONObject();
				object.put("dataPartida", passagem.getDataPartida());
				object.put("horaPartida", passagem.getHoraPartida());
				object.put("valor", passagem.getValor());
				object.put("origem", passagem.getOrigem());
				object.put("destino", passagem.getDestino());
				json.put(object);
			}
		
		    response.getWriter().println(json.toString()); 
		} else {
			response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
			response.getWriter().write("");
		}
	}

}

