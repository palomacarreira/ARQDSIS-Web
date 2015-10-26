package Banco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.ClienteTO;

public class ClienteDAO extends MysqlConnect
{
	   private PreparedStatement st;
	   
	   public ClienteDAO()
	   {
	      super();
	   }
	   
	   public boolean cadastrarCliente(ClienteTO clienteTO)
	   {
	      try{
	         String sql = "insert into tabelaCliente(tipo,tratamento,nome, dtNascimento,"+
	         "email,telefone, cpf) values (?,?,?,?,?,?,?)";     
	         st = conn.prepareStatement(sql);
	         st.setString(1,clienteTO.getTipo());
	         st.setString(2,clienteTO.getTratamento());
	         st.setString(3,clienteTO.getNome());
	         st.setString(4,clienteTO.getDtNascimento());
	         st.setString(5,clienteTO.getEmail());
	         st.setString(6,clienteTO.getTelefone());
	         st.setString(7,clienteTO.getCpf());
	         st.executeUpdate(); 
	         st.close();
	      }
	      catch(Exception e) {
	         e.printStackTrace();
	         return false;
	      }
	      return true;
	   }
	   
	   public boolean alterarCliente(ClienteTO clienteTO)
	   { 
		      try{
		         String sql = "update tabelaCliente set tipo = ?, tratamento = ?, "+
		         "nome = ?, dtNascimento = ?, email = ? , telefone = ? where codigo = ?";
		         
		         st = conn.prepareStatement(sql); 
		         st.setString(1,clienteTO.getTipo());
		         st.setString(2,clienteTO.getTratamento());
		         st.setString(3,clienteTO.getNome());
		         st.setString(4,clienteTO.getDtNascimento());
		         st.setString(5,clienteTO.getEmail());
		         st.setString(6,clienteTO.getTelefone());
		         st.setInt(7,clienteTO.getCodigo());
		         st.executeUpdate(); 
		         st.close(); 
		      }
		      catch(Exception e){
		         e.printStackTrace();
		         return false;
		      }   
		      return true;
		   }

	   	
	   public ClienteTO recuperarCliente(int codigo)
	   {
		   	 ClienteTO clienteTO = null;
	         try
	         {
	            String sql = " SELECT * FROM tabelaCliente where codigo = ?";
	            st= conn.prepareStatement(sql);
	            st.setInt(1,codigo);
	            ResultSet resultSet = st.executeQuery();
	            if(resultSet.next())
	            {
	            	clienteTO = new ClienteTO();
	            	clienteTO.setCodigo(resultSet.getInt("codigo"));
	            	clienteTO.setNome(resultSet.getString("nome"));
	            	clienteTO.setTratamento(resultSet.getString("tratamento"));
	            	clienteTO.setTipo(resultSet.getString("tipo"));
	            	clienteTO.setDtNascimento(resultSet.getString("dtNascimento"));
	            	clienteTO.setEmail(resultSet.getString("email"));
	            	clienteTO.setTelefone(resultSet.getString("telefone"));
	            	clienteTO.setCpf(resultSet.getString("cpf"));	
	            }	
	            st.close();
	         }
	            catch(Exception e)
	            {
	               e.printStackTrace();
	               return null;
	            }
	      
	         return clienteTO;
	      
	      }
	   	
	      public boolean excluirCliente(int codigo)
	      {
	         try
	         {
	            String sql = "DELETE FROM tabelaCliente WHERE codigo = ?";
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

	      public String pesquisarCPF(String valor)
	      {
	    	  String codigo = "";
	         	try
	         	{
	         		String sql = "SELECT codigo FROM tabelaCliente WHERE cpf = ?";
	         		st = conn.prepareStatement(sql);
	         	    st.setString(1,valor);
	         		ResultSet resultSet = st.executeQuery();
	         		if(resultSet.next())
		            {
	         			codigo = resultSet.getString("codigo");
		            }
	         		st.close(); 
	         	}
	         	catch(Exception e)
	         	{
	         		e.printStackTrace();
	         		return null;
	         	} 
	         	return codigo;
	    }
	   
}
