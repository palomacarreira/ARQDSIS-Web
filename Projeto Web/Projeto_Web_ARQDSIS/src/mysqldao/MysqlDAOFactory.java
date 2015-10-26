package mysqldao;

import dao.AeronaveDAO;
import dao.ClienteDAO;
import dao.CreditoDAO;
import dao.DAOFactory;
import dao.DebitoDAO;
import dao.PassagemDAO;
import dao.ReembolsoDAO;
import dao.VooDAO;



public class MysqlDAOFactory  extends DAOFactory{

	public static final String DRIVER = "driver do MySQL";
	public static final String DBURL = "string de conexão do MySQL";
	
	public ReembolsoDAO getReembolsoDAO() {
		return new MysqlReembolsoDAO();
	}
	
	@Override
	public VooDAO getVooDAO() {
		return new MysqlVooDAO();
	}

	@Override
	public PassagemDAO getPassagemDAO() {
		return new MysqlPassagemDAO();
	}

	@Override
	public ClienteDAO getClienteDAO() {
		return new MysqlClienteDAO();
	}

	@Override
	public AeronaveDAO getAeronaveDAO() {
		return new MysqlAeronaveDAO();
	}

	@Override
	public DebitoDAO getDebitoDAO() {
		return new MysqlDebitoDAO();
	}

	@Override
	public CreditoDAO getCreditoDAO() {
		return new MysqlCreditoDAO();
	}
	
	
	
}
