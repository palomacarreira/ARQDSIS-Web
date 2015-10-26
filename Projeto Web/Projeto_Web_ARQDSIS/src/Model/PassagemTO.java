package Model;

public class PassagemTO 
{
	
	private int codigo;              
	private String horaPartida;         
	private String dataPartida;         
	private String qtdPassageiros;      
	private String perfil;            
	private double valor;    
    private int QtdMalas;
    private int codigoCliente;
	private int codigoVoo;
    private String nomeCliente;
    private String origem;
	private String destino;
	private String formaPagamento;
	private String assento;
	public String getEscalas() {
		return escalas;
	}
	public void setEscalas(String escalas) {
		this.escalas = escalas;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	private String escalas;
	private String situacao;
	
    public String getAssento()
    {
		return assento;
	}
	public void setAssento(String assento) 
	{
		this.assento = assento;
	}
	public String getNomeCliente() 
    {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente)
	{
		this.nomeCliente = nomeCliente;
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
	public String getFormaPagamento() 
	{
		return formaPagamento;
	}
	public void setFormaPagamento(String formaPagamento) 
	{
		this.formaPagamento = formaPagamento;
	}
	public int getQtdMalas()
    {
		return QtdMalas;
	}
	public void setQtdMalas(int qtdMalas) 
	{
		QtdMalas = qtdMalas;
	}
	public int getCodigoCliente() 
	{
		return codigoCliente;
	}
	public void setCodigoCliente(int codigoCliente)
	{
		this.codigoCliente = codigoCliente;
	}
	public int getCodigoVoo() 
	{
		return codigoVoo;
	}
	public void setCodigoVoo(int codigoVoo) 
	{
		this.codigoVoo = codigoVoo;
	}
	
	public int getCodigo() 
	{
		return codigo;
	}
	public void setCodigo(int codigoPesquisa) 
	{
		this.codigo = codigoPesquisa;
	}
	public String getHoraPartida() 
	{
		return horaPartida;
	}
	public void setHoraPartida(String horaPartida) 
	{
		this.horaPartida = horaPartida;
	}
	public String getDataPartida()
	{
		return dataPartida;
	}
	public void setDataPartida(String dataPartida) 
	{
		this.dataPartida = dataPartida;
	}
	public String getQtdPassageiros() 
	{
		return qtdPassageiros;
	}
	public void setQtdPassageiros(String qtdPassagem) 
	{
		this.qtdPassageiros = qtdPassagem;
	}
	public String getPerfil() 
	{
		return perfil;
	}
	public void setPerfil(String perfil) 
	{
		this.perfil = perfil;
	}
	public double getValor() 
	{
		return valor;
	}
	public void setValor(double valor) 
	{
		this.valor = valor;
	}

}
