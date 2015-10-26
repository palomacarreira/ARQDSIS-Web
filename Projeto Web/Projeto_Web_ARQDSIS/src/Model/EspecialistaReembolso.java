package Model;

import dao.ReembolsoDAO;
import dao.DAOFactory;

public class EspecialistaReembolso {
	
	public static final int MYSQL = 1;
	public static final int POSTGREE = 2;
	
	public void adicionar(String agencia, String banco, String conta, String cpf, String nomeTitular,
			double valorDevolucao, int codigo){
	
		
		ReembolsoTO reembolsoTO  = new ReembolsoTO();
		reembolsoTO.setAgencia(agencia); 
		reembolsoTO.setBanco(banco);
		reembolsoTO.setConta(conta);
		reembolsoTO.setCpf(cpf); 
		reembolsoTO.setNomeTitular(nomeTitular);
		reembolsoTO.setValorDevolucao(valorDevolucao);
		reembolsoTO.setCodigoPassagem(codigo);

		ReembolsoDAO reembolsoDAO = (ReembolsoDAO)DAOFactory.getDAOFactory(MYSQL).getReembolsoDAO();
		reembolsoDAO.cadastrarReembolso(reembolsoTO);
		
	}
}
