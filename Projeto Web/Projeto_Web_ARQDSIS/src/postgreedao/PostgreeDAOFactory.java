package postgreedao;

import dao.AeronaveDAO;
import dao.ClienteDAO;
import dao.CreditoDAO;
import dao.DAOFactory;
import dao.DebitoDAO;
import dao.PassagemDAO;
import dao.ReembolsoDAO;
import dao.VooDAO;



public class PostgreeDAOFactory extends DAOFactory {

	public static final String DRIVER = "driver do POSTGREE";
	public static final String DBURL = "string de conexão do POSTGREE";
	
	public ReembolsoDAO getReembolsoDAO() {
		return new PostgreeReembolsoDAO();
	}
	
	@Override
	public VooDAO getVooDAO() {
		return new PostgreeVooDAO();
	}

	@Override
	public PassagemDAO getPassagemDAO() {
		return new PostgreePassagemDAO();
	}

	@Override
	public ClienteDAO getClienteDAO() {
		return new PostgreeClienteDAO();
	}

	@Override
	public AeronaveDAO getAeronaveDAO() {
		return new PostgreeAeronaveDAO();
	}

	@Override
	public DebitoDAO getDebitoDAO() {
		return new PostgreeDebitoDAO();
	}

	@Override
	public CreditoDAO getCreditoDAO() {
		return new PostgreeCreditoDAO();
	}
	
	
}
