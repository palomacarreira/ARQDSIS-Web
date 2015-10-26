package LoginCriando;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class GravadorDeBytes 
{
    public static void gravar(String nome, byte[] saida) {

    	FileOutputStream out = null;
    	File arquivo = null;
        try {
        	arquivo = new File(nome);
            out = new FileOutputStream(arquivo);
            out.write(saida);
        } catch(IOException e){
            	e.printStackTrace();
        } finally {
            if (out != null) {
                try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        }
    }
    
}


