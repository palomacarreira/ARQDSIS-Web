package Model;

public class AeronaveTO
{
   // atributos
   private int codigo;
   private String nome;
   private int qtdAssentos;
   private String localAssentos;
   private String tipoAeronave;
	// construtores
   public AeronaveTO() {
      this(0,"",0,"","");
   }
   public AeronaveTO(int codigo, String nome, int qtdAssentos, String localAssentos, String tipoAeronave) 
   {
      setCodigo(codigo);
      setNome(nome);
      setQtdAssentos(qtdAssentos);
      setLocalAssentos(localAssentos);
      setTipoAeronave(tipoAeronave);
   }
  // metodos modificadores
   public void setCodigo(int codigo)                    
   { 
      this.codigo = codigo; 
   }
   public void setNome(String nome)                        
   { 
      this.nome = nome; 
   }
   public void setQtdAssentos(int qtdAssentos)          
   { 
      this.qtdAssentos = qtdAssentos; 
   }
   public void setLocalAssentos(String localAssentos)     
   { 
      this.localAssentos = localAssentos; 
   }
   public void setTipoAeronave(String tipoAeronave)        
   { 
      this.tipoAeronave = tipoAeronave;
   }
// metodos de acesso
   public int getCodigo()
   { 
      return this.codigo; 
   }
   public String getNome()      
   { 
      return this.nome; 
   }
   public int getQtdAssentos()          
   { 
      return this.qtdAssentos; 
   }
   public String getLocalAssentos()            
   { 
      return this.localAssentos;
   }
   public String getTipoAeronave()            
   { 
      return this.tipoAeronave; 
   }
}