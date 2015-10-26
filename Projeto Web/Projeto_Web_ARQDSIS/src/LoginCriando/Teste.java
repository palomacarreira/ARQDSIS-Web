package LoginCriando;

import java.io.File;

public class Teste {
	
	byte[] bMsgClara = null;
	byte[] bMsgCifrada = null;
	byte[] bMsgDecifrada = null;
	String sMsgCifrada = null;
	String sMsgDecifrada = null;
	CryptoAES caes = new CryptoAES();
	LeitorDeBytes leitor = new LeitorDeBytes();
	
	public void geraCifra()
	{
		try
		{
			bMsgClara = leitor.ler("mensagem_original.txt");	
			caes.geraChave(new File("chave.simetrica"));
			caes.geraCifra(bMsgClara, new File("chave.simetrica")); 
			bMsgCifrada = caes.getTextoCifrado();
			sMsgCifrada = (new String(bMsgCifrada, "ISO-8859-1")); 
			GravadorDeBytes.gravar("texto_cifrado_aes.txt", bMsgCifrada);
			File file = new File("mensagem_original.txt");
			file.delete(); 
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
	}
	
	public String geraDecifra()
	{
		try
		{
			bMsgCifrada = leitor.ler("texto_cifrado_aes.txt");
			caes.geraDecifra(bMsgCifrada, new File("chave.simetrica")); 
			bMsgDecifrada = caes.getTextoDecifrado();
			sMsgDecifrada = (new String(bMsgDecifrada, "ISO-8859-1"));
		//	GravadorDeBytes.gravar("texto_decifrado_aes.txt", bMsgDecifrada);
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		return sMsgDecifrada;
	}
	
	public static void main(String args[])
	{
		Teste t = new Teste();
		t.geraCifra();
		t.geraDecifra();
	}
	
}
