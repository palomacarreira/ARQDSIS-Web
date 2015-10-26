package mysqldao;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import Banco.MysqlConnect;
import Model.VooTO;
import dao.VooDAO;

public class MysqlVooDAO extends MysqlConnect implements VooDAO
{

	private PreparedStatement st;

	public boolean cadastrarVoo(VooTO vooTO)
	{

		try{
			String sql = "insert into tabelaVoo(origem, destino, escala, dt, hora, situacao, codigoAeronave) values (?,?,?,?,?,?,?)";       
			st = (PreparedStatement) conn.prepareStatement(sql);
			st.setString(1,vooTO.getOrigem());
			st.setString(2,vooTO.getDestino());
			st.setString(3,vooTO.getEscala());
			st.setString(4,vooTO.getData());
			st.setString(5,vooTO.getHora());
			st.setString(6,vooTO.getSituacao());
			st.setInt(7,vooTO.getCodigoAeronave());
			st.executeUpdate(); 
			st.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean alterarVoo(VooTO vooTO)
	{ 
		try{
			String sql = "update tabelaVoo set origem =?,destino = ?,escala =?, dt = ?, hora = ?, codigoAeronave = ?, situacao = ? where codigo = ?";

			st = (PreparedStatement) conn.prepareStatement(sql);
			st.setString(1,vooTO.getOrigem());
			st.setString(2,vooTO.getDestino());
			st.setString(3,vooTO.getEscala());
			st.setString(4,vooTO.getData());
			st.setString(5,vooTO.getHora());
			st.setInt(6,vooTO.getCodigoAeronave());
			st.setString(7,vooTO.getSituacao());
			st.setInt(8,vooTO.getCodigo());
			st.executeUpdate(); 
			st.close(); 
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}   
		return true;
	}


	public VooTO recuperarVoo(int codigo)
	{
		VooTO vooTO = null;
		try
		{
			String sql = " SELECT * FROM tabelaVoo where codigo = ?";
			st= (PreparedStatement) conn.prepareStatement(sql);
			st.setInt(1,codigo);
			ResultSet resultSet = st.executeQuery();
			if(resultSet.next())
			{
				vooTO = new VooTO();
				vooTO.setCodigo(resultSet.getInt("codigo"));
				vooTO.setOrigem(resultSet.getString("origem"));
				vooTO.setDestino(resultSet.getString("destino"));
				vooTO.setEscala(resultSet.getString("escala"));
				vooTO.setData(resultSet.getString("dt"));
				vooTO.setHora(resultSet.getString("hora"));
				vooTO.setCodigoAeronave(resultSet.getInt("codigoAeronave"));
				vooTO.setSituacao(resultSet.getString("situacao"));
			}	
			st.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		return vooTO;
	}

	
	public ArrayList<VooTO> recuperarTodosVoos()
	{
		ArrayList<VooTO> lista= new ArrayList<VooTO>();
		VooTO vooTO = null;
		
		try
		{
			String sql = "SELECT * FROM tabelaVoo WHERE situacao = 'Espera'";
			st= (PreparedStatement) conn.prepareStatement(sql);
			ResultSet resultSet = st.executeQuery();
			while(resultSet.next())
			{
				vooTO = new VooTO();
				vooTO.setOrigem(resultSet.getString("origem"));	
				vooTO.setCodigo(resultSet.getInt("codigo"));
				lista.add(vooTO);
			}	
			st.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		return lista;
	}

	
	public boolean excluirVoo(int codigo)
	{
		try
		{
			String sql = "DELETE FROM tabelaVoo WHERE codigo = ?";
			st = (PreparedStatement) conn.prepareStatement(sql);
			st.setInt(1,codigo);
			st.executeUpdate();
			st.close(); 
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}        
		return true;  
	}


}