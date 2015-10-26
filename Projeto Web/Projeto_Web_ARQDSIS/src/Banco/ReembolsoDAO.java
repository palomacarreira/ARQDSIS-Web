package Banco;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.PassagemTO;
import Model.ReembolsoTO;

public class ReembolsoDAO extends MysqlConnect {

	private JPanel contentPane;

	private PreparedStatement st;
	   
	   public ReembolsoDAO()
	   {
	      super();
	   }
	   
	   public boolean cadastrarReembolso(ReembolsoTO reembolsoTO)
	   {
	      try
	      {
	         String sql = "insert into tabelaReembolso("
	    + "agencia, banco, conta, cpf, nomeTitula, valorDevolucao, codPassagem)"
	    + " values (?,?,?,?,?,?,?)";       
	    	  
	         st = conn.prepareStatement(sql);
	         st.setString(1,reembolsoTO.getAgencia());
	         st.setString(2,reembolsoTO.getBanco());
	         st.setString(3,reembolsoTO.getConta());
	         st.setString(4,reembolsoTO.getCpf()) ;
	         st.setString(5,reembolsoTO.getNomeTitular());
	         st.setDouble(6, reembolsoTO.getValorDevolucao());
	         st.setInt(7, reembolsoTO.getCodigoPassagem());
	         st.executeUpdate(); 
	         st.close();

	     }catch(Exception e) {
	         e.printStackTrace();
	         return false;
	      }
		return true;
	   }

}