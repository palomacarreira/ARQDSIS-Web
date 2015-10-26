package dao;

import mysqldao.MysqlDAOFactory;
import postgreedao.PostgreeDAOFactory;

public abstract class DAOFactory {

	
	public static final int MYSQL = 1;
	public static final int POSTGREE = 2;
	public static final int MSSQL = 3;


	public abstract VooDAO getVooDAO();
	public abstract PassagemDAO getPassagemDAO();
	public abstract ClienteDAO getClienteDAO();
	public abstract AeronaveDAO getAeronaveDAO();
	public abstract DebitoDAO getDebitoDAO();
	public abstract CreditoDAO getCreditoDAO();
	public abstract ReembolsoDAO getReembolsoDAO();
	
	public static DAOFactory getDAOFactory(int qualFactory) {
		switch (qualFactory) {
		case MYSQL:
			return new MysqlDAOFactory();
		case POSTGREE:
			return new PostgreeDAOFactory();
		default:
			return null;
		}
	}
	
	
	
}