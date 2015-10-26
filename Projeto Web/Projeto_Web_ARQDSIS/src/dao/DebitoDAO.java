package dao;

import Model.DebitoTO;

public interface DebitoDAO {

	public boolean cadastrarDebito(DebitoTO debitoTO);
	public boolean alterarDebito(DebitoTO debitoTO);
	public DebitoTO recuperarDebito(String codigo);
	public boolean excluirDebito(String cpf);
}
