package Model;

import java.util.ArrayList;

import dao.ClienteDAO;
import dao.PassagemDAO;
import dao.VooDAO;
import dao.DAOFactory;

public class EspecialistaPassagem {
	
	public static final int MYSQL = 1;
	public static final int POSTGREE = 2;
	
	public void adicionar(String horaPartida, String dataPartida, String qtdPassagem, String perfil,
			 double valor, String formaPagamento, int codigoVoo, int codigoCliente){
		
		PassagemTO passagemTO = new PassagemTO();
		passagemTO.setHoraPartida(horaPartida);
		passagemTO.setDataPartida(dataPartida);
		passagemTO.setQtdPassageiros(qtdPassagem);
		passagemTO.setPerfil(perfil);
		passagemTO.setValor(valor);
		passagemTO.setCodigoCliente(codigoCliente);
		passagemTO.setCodigoVoo(codigoVoo);
		passagemTO.setFormaPagamento(formaPagamento);
		
		PassagemDAO passagemDAO = (PassagemDAO) DAOFactory.getDAOFactory(MYSQL).getPassagemDAO();	
        passagemDAO.cadastrarPassagem(passagemTO); 
	}
	
	public void alterar(int codigo, String horaPartida, String dataPartida){
         
		PassagemTO passagemTO = new PassagemTO();
		passagemTO.setCodigo(codigo);
		passagemTO.setHoraPartida(horaPartida);
		passagemTO.setDataPartida(dataPartida);
		
		PassagemDAO passagemDAO = (PassagemDAO) DAOFactory.getDAOFactory(MYSQL).getPassagemDAO();	
        passagemDAO.transferirPassagem(passagemTO); 
        
}
	
	public void excluirPassagem(int codigo, String tipoPag){
		
		PassagemDAO passagemDAO =  (PassagemDAO) DAOFactory.getDAOFactory(MYSQL).getPassagemDAO();
		passagemDAO.excluirPassagem(codigo,tipoPag);
        
	}
	
	public PassagemTO pesquisarCodigo(String codigo){
		PassagemTO passagemTO = new PassagemTO();
		PassagemDAO passagemDAO =  (PassagemDAO) DAOFactory.getDAOFactory(MYSQL).getPassagemDAO();	
		passagemTO = passagemDAO.recuperarPassagem(codigo);
		return passagemTO;
	}
	
	public ArrayList<VooTO> preencheCombos()
	{
		VooDAO vooDAO =  (VooDAO) DAOFactory.getDAOFactory(MYSQL).getVooDAO();	
		ArrayList<VooTO> voos = vooDAO.recuperarTodosVoos();
		return voos;
	}
	
	public String pesquisarCPF(String cpf)
	{
		  ClienteDAO clienteDAO =  (ClienteDAO) DAOFactory.getDAOFactory(MYSQL).getClienteDAO();	
		  String codigo = clienteDAO.pesquisarCPF(cpf);
		  return codigo;
		
	 }
	
	public PassagemTO passagensVendidas(String codigo){
		
		PassagemDAO passagemDAO =  (PassagemDAO) DAOFactory.getDAOFactory(MYSQL).getPassagemDAO();	
		PassagemTO passagemTO = passagemDAO.passagensVendidas(codigo);
		return passagemTO;
	
	}
	
	public void checkin(int codigo, String assentos, int malas)
	{
		PassagemDAO passagemDAO = (PassagemDAO) DAOFactory.getDAOFactory(MYSQL).getPassagemDAO();	
		PassagemTO passagemTO = new PassagemTO();
		passagemTO.setCodigo(codigo);
		passagemTO.setAssento(assentos);
		passagemTO.setQtdMalas(malas);
		passagemDAO.checkin(passagemTO);
	}
	
	
}
