package dao;

import Model.CreditoTO;

public interface CreditoDAO {
	public boolean cadastrarCredito(CreditoTO creditoTO);
	public boolean alterarCredito(CreditoTO creditoTO);
	public CreditoTO recuperarCredito(String cpf);
	public boolean excluirDebito(String cpf);
}
