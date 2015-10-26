package Model;

import javax.servlet.RequestDispatcher;


import dao.DAOFactory;
import dao.ClienteDAO;


public class EspecialistaCliente {

	public static final int MYSQL = 1;
	public static final int POSTGREE = 2;
	
	public void adicionar(String tipo, String tratamento, String nome , String dtNascimento, String email, String telefone, String cpf){
		
		ClienteTO clienteTO = new ClienteTO();
		clienteTO.setTipo(tipo); 
		clienteTO.setTratamento(tratamento);
		clienteTO.setNome(nome); 
		clienteTO.setDtNascimento(dtNascimento); 
		clienteTO.setEmail(email);
		clienteTO.setTelefone(telefone);
		clienteTO.setCpf(cpf);

    	ClienteDAO clienteDAO = (ClienteDAO) DAOFactory.getDAOFactory(MYSQL).getClienteDAO();	
    	clienteDAO.cadastrarCliente(clienteTO);

    	
    	
	}
	
	public void alterar(int codigo, String tipo, String tratamento, String nome , String dtNascimento, String email, String telefone, String cpf){
		
		ClienteTO clienteTO = new ClienteTO();
		clienteTO.setCodigo(codigo); 
		clienteTO.setTipo(tipo); 
		clienteTO.setTratamento(tratamento);
		clienteTO.setNome(nome); 
		clienteTO.setDtNascimento(dtNascimento); 
		clienteTO.setEmail(email);
		clienteTO.setTelefone(telefone);
		clienteTO.setCpf(cpf);
		
		ClienteDAO clienteDAO = (ClienteDAO) DAOFactory.getDAOFactory(MYSQL).getClienteDAO();	
    	clienteDAO.alterarCliente(clienteTO);
        
	}
	
	public void excluir(int codigo){
		
		ClienteDAO clienteDAO = (ClienteDAO) DAOFactory.getDAOFactory(MYSQL).getClienteDAO();	
    	clienteDAO.excluirCliente(codigo);

	}
	
	public ClienteTO pesquisarCodigo(int codigo){
		
		ClienteTO clienteTO = new ClienteTO();
		ClienteDAO clienteDAO = (ClienteDAO) DAOFactory.getDAOFactory(MYSQL).getClienteDAO();	
		clienteTO = clienteDAO.recuperarCliente(codigo);
		return clienteTO;
	}
	
}
