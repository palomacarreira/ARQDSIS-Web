package dao;

import java.util.ArrayList;

import Model.VooTO;

public interface VooDAO {

	public boolean cadastrarVoo(VooTO vooTO);
	public boolean alterarVoo(VooTO vooTO);
	public VooTO recuperarVoo(int codigo);
	public ArrayList<VooTO> recuperarTodosVoos();
	public boolean excluirVoo(int codigo);


}
