package Model;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ReembolsoTO
{
	private String banco;
	private String agencia;
	private String conta;
	private String nomeTitular;
	private String cpf;
	private double valorDevolucao;
	private int codigoPassagem;
	
	public int getCodigoPassagem() 
	{
		return codigoPassagem;
	}
	
	public void setCodigoPassagem(int codigo)
	{
		this.codigoPassagem = codigo;
	}
	
	
	public String getBanco() 
	{
		return banco;
	}
	
	public void setBanco(String banco)
	{
		this.banco = banco;
	}
	
	public String getAgencia()
	{
		return agencia;
	}
	
	public void setAgencia(String agencia) 
	{
		this.agencia = agencia;
	}
	
	public String getConta() 
	{
		return conta;
	}
	
	public void setConta(String conta) 
	{
		this.conta = conta;
	}
	
	public String getNomeTitular() 
	{
		return nomeTitular;
	}
	
	public void setNomeTitular(String nomeTitular)
	{
		this.nomeTitular = nomeTitular;
	}
	
	public String getCpf() 
	{
		return cpf;
	}
	
	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}
	
	public double getValorDevolucao()
	{
		return valorDevolucao;
	}
	
	public void setValorDevolucao(double valorDevolucao) 
	{
		this.valorDevolucao = valorDevolucao;
	}

	
}
