package Banco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.CreditoTO;

public class CreditoDAO extends MysqlConnect
{

	private PreparedStatement st;

	public CreditoDAO()
	{
		super();
	}

	public boolean cadastrarCredito(CreditoTO creditoTO)
	{
		try
		{
			String sql = "insert into tabelaCredito(" +
			"tipoCartao, nomeTitular, cpf, numCartao, dtValidadeCartao, codSeguranca) values (?,?,?,?,?,?)";   
		
			st = conn.prepareStatement(sql);
			st.setString(1,creditoTO.getTipoCartao());
			st.setString(2,creditoTO.getNomeTitular());
			st.setString(3,creditoTO.getCpf());
			st.setString(4,creditoTO.getNumCartao());
			st.setString(5,creditoTO.getDtValidadeCartao());
			st.setInt(6,creditoTO.getCodSeguranca());
			st.executeUpdate(); 
			st.close();
		
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean alterarCredito(CreditoTO creditoTO)
	{ 
		try{
			String sql = "update tabelaCredito set tipoCartao = ?,nomeTitular = ?, codSeguranca= ?,  numCartao = ?, dtValidadeCartao = ? where cpf = ?";
			st = conn.prepareStatement(sql);
			st.setString(1,creditoTO.getTipoCartao());
			st.setString(2,creditoTO.getNomeTitular());
			st.setInt(3,creditoTO.getCodSeguranca());
			st.setString(4,creditoTO.getNumCartao());
			st.setString(5,creditoTO.getDtValidadeCartao());
			st.setString(6,creditoTO.getCpf());
			st.executeUpdate(); 
			st.close();
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}   
		return true;
	}


	public CreditoTO recuperarCredito(String cpf)
	{
		CreditoTO creditoTO = null;
		try
		{
			String sql = " SELECT * FROM tabelaDebito where cpf = ?";
			st= conn.prepareStatement(sql);
			st.setString(1,cpf);
			ResultSet resultSet = st.executeQuery();
			if(resultSet.next())
			{

				creditoTO = new CreditoTO();
				creditoTO.setTipoCartao(resultSet.getString("tipoCartao"));
				creditoTO.setNomeTitular(resultSet.getString("nomeTitular"));
				creditoTO.setCpf(resultSet.getString("cpf"));
				creditoTO.setNumCartao(resultSet.getString("numCartao"));
				creditoTO.setDtValidadeCartao(resultSet.getString("dtValidadeCartao"));
			}	
			st.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}

		return creditoTO;

	}

	public boolean excluirDebito(String cpf)
	{
		try
		{
			String sql = "DELETE FROM tabelaCredito WHERE cpf =?";
			st = conn.prepareStatement(sql);
			st.setString(1,cpf);
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
