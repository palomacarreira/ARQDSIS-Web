package dao;

import Model.ClienteTO;

public interface ClienteDAO {
	 public boolean cadastrarCliente(ClienteTO clienteTO);
	  public boolean alterarCliente(ClienteTO clienteTO);
	  public ClienteTO recuperarCliente(int codigo);
	   public boolean excluirCliente(int codigo);
	   public String pesquisarCPF(String valor);
	   
}
