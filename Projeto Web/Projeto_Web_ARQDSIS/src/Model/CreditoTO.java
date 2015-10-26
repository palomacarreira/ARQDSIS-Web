package Model;

public class CreditoTO
{
	 private String tipoCartao;    
	 private String nomeTitular;
	 private String cpf;
	 private String numCartao;
	 private String dtValidadeCartao;
	 private int codSeguranca;
	 
	public String getTipoCartao() 
	{
		return tipoCartao;
	}
	public void setTipoCartao(String tipoCartao)
	{
		this.tipoCartao = tipoCartao;
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
	public String getNumCartao()
	{
		return numCartao;
	}
	public void setNumCartao(String numCartao) 
	{
		this.numCartao = numCartao;
	}
	public String getDtValidadeCartao() 
	{
		return dtValidadeCartao;
	}
	public void setDtValidadeCartao(String dtValidadeCartao) 
	{
		this.dtValidadeCartao = dtValidadeCartao;
	}
	public int getCodSeguranca() 
	{
		return codSeguranca;
	}
	public void setCodSeguranca(int codSeguranca)
	{
		this.codSeguranca = codSeguranca;
	}
	 
}
