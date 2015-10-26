package Banco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.AeronaveTO;
import Model.VooTO;

public class AeronaveDAO extends MysqlConnect{
		
	   private PreparedStatement st;
	   
	   public AeronaveDAO()
	   {
	      super();
	   }
	   
	   public boolean cadastrarAeronave(AeronaveTO aeronaveTO)
	   {
	      try{
	         String sql = "insert into tabelaAeronave(nome, qtdAssentos,localAssentos,tipoAeronave) values (?,?,?,?)";       
	         st = conn.prepareStatement(sql);
	         st.setString(1,aeronaveTO.getNome());
	         st.setInt(2,aeronaveTO.getQtdAssentos());
	         st.setString(3,aeronaveTO.getLocalAssentos());
	         st.setString(4,aeronaveTO.getTipoAeronave());
	         st.executeUpdate(); 
	         st.close();
	      }
	      catch(Exception e) {
	         e.printStackTrace();
	         return false;
	      }
	      return true;
	   }
	   
	   public boolean alterarAeronave(AeronaveTO aeronaveTO)
	   { 
		      try{
		         String sql = "update tabelaAeronave set qtdAssentos = ?,nome =?, localAssentos=?,  tipoAeronave = ? where codigo = ?";
		         st = conn.prepareStatement(sql); 
		         st.setInt(1,aeronaveTO.getQtdAssentos());
		         st.setString(2,aeronaveTO.getNome());
		         st.setString(3,aeronaveTO.getLocalAssentos());
		         st.setString(4,aeronaveTO.getTipoAeronave());
		         st.setInt(5,aeronaveTO.getCodigo());
		         st.executeUpdate(); 
		         st.close(); 
		      }
		      catch(Exception e){
		         e.printStackTrace();
		         return false;
		      }   
		      return true;
		   }

	   	
	   public AeronaveTO recuperarAeronave(int codigo)
	   {
		   	 AeronaveTO aeronaveTO = null;
	         try
	         {
	            String sql = " SELECT * FROM tabelaAeronave where codigo = ?";
	            st= conn.prepareStatement(sql);
	            st.setInt(1,codigo);
	            ResultSet resultSet = st.executeQuery();
	            if(resultSet.next())
	            {
	            	aeronaveTO = new AeronaveTO();
	            	aeronaveTO.setCodigo(resultSet.getInt("codigo"));
	            	aeronaveTO.setNome(resultSet.getString("nome"));
	            	aeronaveTO.setQtdAssentos(resultSet.getInt("qtdAssentos"));
	            	aeronaveTO.setLocalAssentos(resultSet.getString("localAssentos"));
	            	aeronaveTO.setTipoAeronave(resultSet.getString("tipoAeronave"));
	            }	
	            st.close();
	         }
	            catch(Exception e)
	            {
	               e.printStackTrace();
	               return null;
	            }
	      
	         return aeronaveTO;
	      
	      }
	   	
	   public ArrayList<AeronaveTO> recuperarTodasAeronaves()
		{
			ArrayList<AeronaveTO> lista= new ArrayList<AeronaveTO>();
			AeronaveTO aeronaveTO = null;
			
			try
			{
				String sql = "SELECT * FROM tabelaAeronave";
				st= conn.prepareStatement(sql);
				ResultSet resultSet = st.executeQuery();
				while(resultSet.next())
				{
					aeronaveTO = new AeronaveTO();
					aeronaveTO.setCodigo(resultSet.getInt("codigo"));
					aeronaveTO.setNome(resultSet.getString("nome"));
					lista.add(aeronaveTO);
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
	   
	      public boolean excluirAeronave(int codigo)
	      {
	         try
	         {
	            String sql = "DELETE FROM tabelaAeronave WHERE codigo =?";
	            st = conn.prepareStatement(sql);
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
