package Model;

import dao.ClienteDAO;
import dao.CreditoDAO;
import dao.DAOFactory;

public class EspecialistaCredito {
	
	public static final int MYSQL = 1;
	public static final int POSTGREE = 2;
	
	
	public void adicionar(String cpf, String validadeCartao, String nomeTitular, String numeroCartao,
			String tipoCartao){
		
        CreditoTO creditoTO = new CreditoTO();
		creditoTO.setCpf(cpf);
		creditoTO.setDtValidadeCartao(validadeCartao);
		creditoTO.setNomeTitular(nomeTitular);
		creditoTO.setNumCartao(numeroCartao);
		creditoTO.setTipoCartao(tipoCartao);
		CreditoDAO creditoDAO = (CreditoDAO) DAOFactory.getDAOFactory(MYSQL).getCreditoDAO();	
		creditoDAO.cadastrarCredito(creditoTO); 
		
	}
	
}
