package dao;

import java.util.ArrayList;

import Model.AeronaveTO;

public interface AeronaveDAO {
	  public boolean cadastrarAeronave(AeronaveTO aeronaveTO);
	  public boolean alterarAeronave(AeronaveTO aeronaveTO);
	  public AeronaveTO recuperarAeronave(int codigo);
	  public ArrayList<AeronaveTO> recuperarTodasAeronaves();
	  public boolean excluirAeronave(int codigo);
	  
}
