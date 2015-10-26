package Model;

public class VooTO 
{

	private int codigo;
	private String origem;
	private String destino;
	private String escala;
	private String data;
	private String hora;
	private String tipoAeronave;
	private String situacao;
	private int CodigoAeronave;
	
	public int getCodigoAeronave()
	{
		return CodigoAeronave;
	}
	public void setCodigoAeronave(int codigoAeronave)
	{
		CodigoAeronave = codigoAeronave;
	}
	public int getCodigo() 
	{
		return codigo;
	}
	public void setCodigo(int codigo)
	{
		this.codigo = codigo;
	}
	public String getOrigem()
	{
		return origem;
	}
	public void setOrigem(String origem) 
	{
		this.origem = origem;
	}
	public String getDestino() 
	{
		return destino;
	}
	public void setDestino(String destino) 
	{
		this.destino = destino;
	}
	public String getEscala() 
	{
		return escala;
	}
	public void setEscala(String escala)
	{
		this.escala = escala;
	}
	public String getData() 
	{
		return data;
	}
	public void setData(String data)
	{
		this.data = data;
	}
	public String getHora() 
	{
		return hora;
	}
	public void setHora(String hora) 
	{
		this.hora = hora;
	}
	public String getTipoAeronave()
	{
		return tipoAeronave;
	}
	public void setTipo(String tipo) 
	{
		this.tipoAeronave = tipo;
	}
	public String getSituacao() 
	{
		return situacao;
	}
	public void setSituacao(String situacao) 
	{
		this.situacao = situacao;
	}
	
}
