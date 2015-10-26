package mysqldao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import Banco.MysqlConnect;
import Model.PassagemTO;
import dao.PassagemDAO;

public class MysqlPassagemDAO extends MysqlConnect implements PassagemDAO{
	
	   private PreparedStatement st;
	   
	   
	   public boolean cadastrarPassagem(PassagemTO passagemTO)
	   {		 
		   int codigoFrmPag = 0, codigoPassagem = 0;
	      try
	      {
	    	  
	    	  String sql0 = "SELECT LAST_INSERT_ID()";
	    	  st = (PreparedStatement) conn.prepareStatement(sql0);
	    	  ResultSet resultSet = st.executeQuery();
	    	  if(resultSet.next())
	          {
	            codigoFrmPag = resultSet.getInt("LAST_INSERT_ID()");
	          }	
	          st.close();

	      
	      
	    	  String sql = "insert into tabelaPassagem("
	    + "horaPartida, dataPartida, qtdPassageiros, perfil, valor, tipoPagamento,"
	    + "codigoCliente, codigoVoo)"
	    + " values (?,?,?,?,?,?,?,?)";       
	    	  
	         st = (PreparedStatement) conn.prepareStatement(sql);
	         st.setString(1,passagemTO.getHoraPartida() );
	         st.setString(2,passagemTO.getDataPartida() );
	         st.setString(3,passagemTO.getQtdPassageiros() );
	         st.setString(4,passagemTO.getPerfil() );
	         st.setDouble(5,passagemTO.getValor() );
	         st.setString(6, passagemTO.getFormaPagamento());
	         st.setInt(7,passagemTO.getCodigoCliente());
	         st.setInt(8,passagemTO.getCodigoVoo());
	         st.executeUpdate(); 
	         st.close();
	         
	         
	         if(passagemTO.getFormaPagamento().equals("Crédito"))
	         {
	        	 String sql2 = "insert into tabelaPassCred(tabelaPassagem_codigo, tabelaCredito_codigo) values(?,LAST_INSERT_ID())";
	        	 st = (PreparedStatement) conn.prepareStatement(sql2);
		         st.setInt(1,codigoFrmPag);
		         st.executeUpdate(); 
		         st.close();
	         }
	         else
	         {
	        	 //String sql3 = "insert into tabelaPassDeb"
	 					
	         }
	      }
	      catch(Exception e) {
	         e.printStackTrace();
	         return false;
	      }
	      return true;
	   }
	   
	   public boolean transferirPassagem(PassagemTO passagemTO)
	   { 
		      try{
		         String sql = "update tabelaPassagem set horaPartida = ?, "
		      + "dataPartida = ? where codigo = ?";
		         
		         st = (PreparedStatement) conn.prepareStatement(sql); 
		         st.setString(1,passagemTO.getHoraPartida() );
		         st.setString(2,passagemTO.getDataPartida() );
		         st.setInt(3, passagemTO.getCodigo() );
		         st.executeUpdate(); 
		         st.close(); 
		      }
		      catch(Exception e){
		         e.printStackTrace();
		         return false;
		      }   
		      return true;
		   }

	   public PassagemTO recuperarPassagem(String codigo)
	   {
		   	 PassagemTO passagemTO = null;
	         try
	         {
	            String sql = "SELECT * FROM tabelaPassagem WHERE codigo = ?";
	    
	            st= (PreparedStatement) conn.prepareStatement(sql);
	            st.setString(1,codigo);
	            ResultSet resultSet = st.executeQuery();
	            if(resultSet.next())
	            {
	            	passagemTO = new PassagemTO();
	            	passagemTO.setCodigo(resultSet.getInt("codigo"));
	            	passagemTO.setHoraPartida(resultSet.getString("horaPartida"));
	            	passagemTO.setDataPartida(resultSet.getString("dataPartida"));
	            	passagemTO.setQtdPassageiros(resultSet.getString("qtdPassageiros"));
	            	passagemTO.setPerfil(resultSet.getString("perfil"));
	            	passagemTO.setValor(resultSet.getDouble("valor"));
	            	passagemTO.setFormaPagamento(resultSet.getString("tipoPagamento"));
	            }	
	            st.close();
	         }
	            catch(Exception e)
	            {
	               e.printStackTrace();
	               return null;
	            }
	      
	         return passagemTO;
	      
	      }

	   public PassagemTO recuperarHora(int codigo)
	   {
		   	 PassagemTO passagemTO = new PassagemTO();
	         try
	         {
	            String sql = "SELECT * FROM tabelaPassagem WHERE codigo = ?";
	            st= (PreparedStatement) conn.prepareStatement(sql);
	            st.setInt(1,codigo);
	            ResultSet resultSet = st.executeQuery();
	            if(resultSet.next())
	            {
	            	passagemTO.setHoraPartida(resultSet.getString("horaPartida"));
	            	passagemTO.setDataPartida(resultSet.getString("dataPartida"));
	            }	
	            st.close();
	         }
	            catch(Exception e)
	            {
	               e.printStackTrace();
	               return null;
	            }
	      
	         return passagemTO;
	      
	      }
	   
	   public PassagemTO passagensVendidas(String codigo)
	   {
		   	 PassagemTO passagemTO = null;
	         try
	         {
	            String sql = "SELECT *, c.codigo, c.nome, p.codigoVoo,v.escala, v.situacao, p.codigoCliente,v.codigo, v.origem, v.destino "+
	            		"FROM tabelaPassagem p " +
	            		"INNER JOIN tabelaVoo v ON (v.codigo = p.codigoVoo) " +
	            		"INNER JOIN tabelaCliente c ON (c.codigo = p.codigoCliente) " +
	            		"WHERE p.codigo = ?";
	            st= (PreparedStatement) conn.prepareStatement(sql);
	            st.setString(1,codigo);
	            ResultSet resultSet = st.executeQuery();
	            if(resultSet.next())
	            {
	            	passagemTO = new PassagemTO();
	            	passagemTO.setCodigo(resultSet.getInt("p.codigo"));
	            	passagemTO.setHoraPartida(resultSet.getString("p.horaPartida"));
	            	passagemTO.setDataPartida(resultSet.getString("p.dataPartida"));
	            	passagemTO.setQtdPassageiros(resultSet.getString("p.qtdPassageiros"));
	            	passagemTO.setPerfil(resultSet.getString("p.perfil"));
	            	passagemTO.setValor(resultSet.getDouble("p.valor"));
	            	passagemTO.setQtdMalas(resultSet.getInt("p.qtdMalas"));
	            	passagemTO.setFormaPagamento(resultSet.getString("p.tipoPagamento"));	
	            	passagemTO.setCodigoCliente(resultSet.getInt("c.codigo"));
	            	passagemTO.setNomeCliente(resultSet.getString("c.nome"));
	            	passagemTO.setCodigoVoo(resultSet.getInt("v.codigo"));
	            	passagemTO.setOrigem(resultSet.getString("v.origem"));
	            	passagemTO.setDestino(resultSet.getString("v.destino"));
	            	passagemTO.setSituacao(resultSet.getString("v.situacao"));
	            	passagemTO.setEscalas(resultSet.getString("v.escala"));
	            }	
	            st.close();
	         }
	            catch(Exception e)
	            {
	               e.printStackTrace();
	               return null;
	            }
	      
	         return passagemTO;
	      
	      }
	   	
	      public boolean excluirPassagem(int codigo, String tipoPag)
	      {
	    	  int codigoFrmPag = 0;
	         try
	         {
	        	
	        	if(tipoPag.equals("Credito"))
	        	{
	        		String sql = "SELECT * FROM tabelaPassCred WHERE tabelaPassagem_codigo = ?";
	        		st= (PreparedStatement) conn.prepareStatement(sql);
	 	            st.setInt(1,codigo);
	 	            ResultSet resultSet = st.executeQuery();
	 	            if(resultSet.next())
	 	            {
	 	            	codigoFrmPag = resultSet.getInt("tabelaCredito_codigo");
	 	            }	
		            st.close();
		            
		            String sql1 = "DELETE FROM tabelaPassCred WHERE tabelaPassagem_codigo = ?";
		            st = (PreparedStatement) conn.prepareStatement(sql1);
		            st.setInt(1,codigo);
		            st.executeUpdate();
		            st.close(); 
		            
		            String sql2 = "DELETE FROM tabelaCredito WHERE codigo = ?";
		            st = (PreparedStatement) conn.prepareStatement(sql2);
		            st.setInt(1,codigoFrmPag);
		            st.executeUpdate();
		            st.close(); 
		            
	        	}
	        	else
	        	{
	        		String sql = "SELECT * FROM tabelaPassDeb WHERE tabelaPassagem_codigo = ?";
	        		st= (PreparedStatement) conn.prepareStatement(sql);
	 	            st.setInt(1,codigo);
	 	            ResultSet resultSet = st.executeQuery();
	 	            if(resultSet.next())
	 	            {
	 	            	codigoFrmPag = resultSet.getInt("tabelaCredito_codigo");
	 	            }	
		            st.close();
	        		 
		            String sql1 = "DELETE FROM tabelaPassDeb WHERE tabelaPassagem_codigo = ?";
		            st = (PreparedStatement) conn.prepareStatement(sql1);
		            st.setInt(1,codigo);
		            st.executeUpdate();
		            st.close(); 
		            
		            String sql2 = "DELETE FROM tabelaDebito WHERE codigo =?";
		            st = (PreparedStatement) conn.prepareStatement(sql2);
		            st.setInt(1,codigoFrmPag);
		            st.executeUpdate();
		            st.close(); 
		            
	        	}
	        	
	        	
	            String sql = "DELETE FROM tabelaPassagem WHERE codigo =?";
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
	      
	      
	      public boolean checkin(PassagemTO passagemTO)
		   { 
			      try{
			         String sql = "update tabelaPassagem set qtdMalas = ?, "
			      + "assento = ? where codigo = ?";
			         
			         st = (PreparedStatement) conn.prepareStatement(sql); 
			         st.setInt(1,passagemTO.getQtdMalas());
			         st.setString(2,passagemTO.getAssento());
			         st.setInt(3, passagemTO.getCodigo());
			         st.executeUpdate(); 
			         st.close(); 
			      }
			      catch(Exception e){
			         e.printStackTrace();
			         return false;
			      }   
			      return true;
			   }
	      
	      
	      public boolean recuperarCheckin(int codigo)
	      {
	    	  try{
	    		   String sql = "SELECT qtdMalas FROM tabelaPassagem WHERE codigo = ?";
	        		st= (PreparedStatement) conn.prepareStatement(sql);
	 	            st.setInt(1,codigo);
	 	            ResultSet resultSet = st.executeQuery();
	 	            if(resultSet.next())
	 	            {
	 	            	if(resultSet.getString("qtdMalas") == null)
	 	            	{
	 	            		return false;
	 	            	}
	 	            }	
		            st.close();
			      }
			      catch(Exception e){
			         e.printStackTrace();
			         return false;
			      }   
			      return true;
	      }
}