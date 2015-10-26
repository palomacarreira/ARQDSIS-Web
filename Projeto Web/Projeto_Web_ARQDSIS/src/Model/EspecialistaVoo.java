package Model;

import java.util.ArrayList;
import dao.VooDAO;
import dao.DAOFactory;

public class EspecialistaVoo {

	public static final int MYSQL = 1;
	public static final int POSTGREE = 2;
	
	public void adicionar(String origem, String destino,String escala, String data, String hora, int codigo, String situacao){
		
		VooTO vooTO = new VooTO();
		vooTO.setOrigem(origem);
		vooTO.setDestino(destino);
		vooTO.setEscala(escala);
		vooTO.setData(data);
		vooTO.setHora(hora);
		vooTO.setCodigoAeronave(codigo);
		vooTO.setSituacao(situacao);
		
		VooDAO vooDAO = (VooDAO) DAOFactory.getDAOFactory(MYSQL).getVooDAO();		
        vooDAO.cadastrarVoo(vooTO); 
	}
	
	public void alterar(String origem, String destino,String escala, String data, String hora, int codigo, int codigoAeronave, String situacao){
		
		VooTO vooTO = new VooTO();
		vooTO.setOrigem(origem);
		vooTO.setDestino(destino);
		vooTO.setEscala(escala);
		vooTO.setData(data);
		vooTO.setHora(hora);
		vooTO.setCodigoAeronave(codigoAeronave);
		vooTO.setSituacao(situacao);
		vooTO.setCodigo(codigo);
		VooDAO vooDAO = (VooDAO) DAOFactory.getDAOFactory(MYSQL).getVooDAO();
		vooDAO.alterarVoo(vooTO);
        
	}
	
	public void excluir(int codigo){
		
		VooDAO vooDAO = (VooDAO) DAOFactory.getDAOFactory(MYSQL).getVooDAO();
		vooDAO.excluirVoo(codigo);
        
	}
	
	public VooTO pesquisarCodigo(int codigo){
		
		VooTO vooTO = new VooTO();
		VooDAO vooDAO = (VooDAO) DAOFactory.getDAOFactory(MYSQL).getVooDAO();	
		vooTO = vooDAO.recuperarVoo(codigo);
		return vooTO;
	}
	
	public ArrayList<VooTO> pesquisar(int codigo){
		ArrayList<VooTO> vooTO = new ArrayList<VooTO>();
		VooDAO vooDAO = (VooDAO) DAOFactory.getDAOFactory(MYSQL).getVooDAO();
		vooTO  = vooDAO.recuperarTodosVoos();
		return vooTO;
	}
	
}
