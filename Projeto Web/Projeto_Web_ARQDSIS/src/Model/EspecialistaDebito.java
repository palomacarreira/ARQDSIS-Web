package Model;
import dao.ClienteDAO;
import dao.DebitoDAO;
import dao.DAOFactory;
public class EspecialistaDebito {

	public static final int MYSQL = 1;
	public static final int POSTGREE = 2;
	
	public void adicionar(int agencia, String banco, int contaCorr, String nomeTitular,
			String cpf, String telefone){
		
	DebitoDAO debitoDAO = (DebitoDAO) DAOFactory.getDAOFactory(MYSQL).getDebitoDAO();	
	DebitoTO debitoTO = new DebitoTO();
	debitoTO.setAgencia(agencia);
	debitoTO.setBanco(banco);
	debitoTO.setContaCorrente(contaCorr);
	debitoTO.setNomeTitular(nomeTitular);
	debitoTO.setCpf(cpf);
	debitoTO.setTelefone(telefone);
	debitoDAO.cadastrarDebito(debitoTO); 
	}
}
