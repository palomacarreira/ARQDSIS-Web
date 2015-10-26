package dao;

import Model.PassagemTO;

public interface PassagemDAO {
	  public boolean cadastrarPassagem(PassagemTO passagemTO);
	  public boolean transferirPassagem(PassagemTO passagemTO);
	  public PassagemTO recuperarPassagem(String codigo);
	   public PassagemTO recuperarHora(int codigo);
	   public PassagemTO passagensVendidas(String codigo);
	   public boolean excluirPassagem(int codigo, String tipoPag);
	      public boolean checkin(PassagemTO passagemTO);
	      public boolean recuperarCheckin(int codigo);
}
