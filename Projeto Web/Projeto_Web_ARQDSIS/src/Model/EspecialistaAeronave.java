package Model;

import java.util.ArrayList;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;

import dao.AeronaveDAO;
import dao.ClienteDAO;
import dao.DAOFactory;

public class EspecialistaAeronave {

	public static final int MYSQL = 1;
	public static final int POSTGREE = 2;
	
	public void adicionar(String nome, int qtdAssentos,String localAssentos, String tipoAeronave){
		
		AeronaveTO aeronaveTO = new AeronaveTO();
		aeronaveTO.setNome(nome);
		aeronaveTO.setQtdAssentos(qtdAssentos);
		aeronaveTO.setLocalAssentos(localAssentos);
		aeronaveTO.setTipoAeronave(tipoAeronave);
		
		AeronaveDAO aeronaveDAO = (AeronaveDAO) DAOFactory.getDAOFactory(MYSQL).getAeronaveDAO();	
		aeronaveDAO.cadastrarAeronave(aeronaveTO); 
	}
	
	public void alterar(int codigo, String nome, int qtdAssentos,String localAssentos, String tipoAeronave){
		
		AeronaveTO aeronaveTO = new AeronaveTO();
		aeronaveTO.setCodigo(codigo);
		aeronaveTO.setNome(nome);
		aeronaveTO.setQtdAssentos(qtdAssentos);
		aeronaveTO.setLocalAssentos(localAssentos);
		aeronaveTO.setTipoAeronave(tipoAeronave);
		
		AeronaveDAO aeronaveDAO =  (AeronaveDAO) DAOFactory.getDAOFactory(MYSQL).getAeronaveDAO();
		aeronaveDAO.alterarAeronave(aeronaveTO);
	}
	
	public void excluir(int codigo){
		
		AeronaveDAO aeronaveDAO =  (AeronaveDAO) DAOFactory.getDAOFactory(MYSQL).getAeronaveDAO();
		aeronaveDAO.excluirAeronave(codigo);
        
	}
	
	public AeronaveTO pesquisarCodigo(int codigo){
		AeronaveTO aeronaveTO = new AeronaveTO();
		AeronaveDAO aeronaveDAO =  (AeronaveDAO) DAOFactory.getDAOFactory(MYSQL).getAeronaveDAO();
		aeronaveTO = aeronaveDAO.recuperarAeronave(codigo);
		return aeronaveTO;
	}
	
	public ArrayList<AeronaveTO> pesquisar(int codigo){
		ArrayList<AeronaveTO> aeronaveTO = new ArrayList<AeronaveTO>();
		AeronaveDAO aeronaveDAO = (AeronaveDAO) DAOFactory.getDAOFactory(MYSQL).getAeronaveDAO();
		aeronaveTO  = aeronaveDAO.recuperarTodasAeronaves();
		return aeronaveTO;
	}
	
}
