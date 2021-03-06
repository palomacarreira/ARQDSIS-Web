package mysqldao;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.mysql.jdbc.PreparedStatement;
import Banco.MysqlConnect;
import Model.DebitoTO;
import dao.DebitoDAO;

public class MysqlDebitoDAO extends MysqlConnect implements DebitoDAO
{

		private PreparedStatement st;

		public boolean cadastrarDebito(DebitoTO debitoTO)
		{
			try{
				String sql = "insert into tabelaDebito(agencia, banco, contaCorrente, nomeTitular, cpf, telefone) values (?,?,?,?,?,?)";   

				st = (PreparedStatement) conn.prepareStatement(sql);
				st.setInt(1,debitoTO.getAgencia());
				st.setString(2,debitoTO.getBanco());
				st.setInt(3,debitoTO.getContaCorrente());
				st.setString(4,debitoTO.getNomeTitular());
				st.setString(5,debitoTO.getCpf());
				st.setString(6,debitoTO.getTelefone());
				st.executeUpdate(); 
				st.close();
			}
			catch(Exception e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}

		public boolean alterarDebito(DebitoTO debitoTO)
		{ 
			try{
				String sql = "update tabelaDebito set agencia = ?,banco =?, contaCorrente=?,  nomeTitular = ?, cpf = ?, telefone = ? where codigo = ?";
				st = (PreparedStatement) conn.prepareStatement(sql);
				st.setInt(1,debitoTO.getAgencia());
				st.setString(2,debitoTO.getBanco());
				st.setInt(3,debitoTO.getContaCorrente());
				st.setString(4,debitoTO.getNomeTitular());
				st.setString(5,debitoTO.getCpf());
				st.setString(6,debitoTO.getTelefone());
				st.executeUpdate(); 
				st.close();
			}
			catch(Exception e){
				e.printStackTrace();
				return false;
			}   
			return true;
		}


		public DebitoTO recuperarDebito(String codigo)
		{
			DebitoTO debitoTO = null;
			try
			{
				String sql = " SELECT * FROM tabelaDebito where codigo = ?";
				st= (PreparedStatement) conn.prepareStatement(sql);
				st.setString(1,codigo);
				ResultSet resultSet = st.executeQuery();
				if(resultSet.next())
				{

					debitoTO = new DebitoTO();
					debitoTO.setAgencia(resultSet.getInt("agencia"));
					debitoTO.setBanco(resultSet.getString("banco"));
					debitoTO.setContaCorrente(resultSet.getInt("contaCorrente"));
					debitoTO.setNomeTitular(resultSet.getString("nomeTitular"));
					debitoTO.setCpf(resultSet.getString("cpf"));
					debitoTO.setTelefone(resultSet.getString("telefone"));
					debitoTO.setCodigoPassagem(resultSet.getInt("codigoPassagem"));
				}	
				st.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return null;
			}

			return debitoTO;

		}

		public boolean excluirDebito(String cpf)
		{
			try
			{
				String sql = "DELETE FROM tabelaDebito WHERE codigo =?";
				st = (PreparedStatement) conn.prepareStatement(sql);
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
