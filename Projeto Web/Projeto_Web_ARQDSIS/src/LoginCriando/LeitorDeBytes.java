package LoginCriando;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class LeitorDeBytes {

    public byte[] ler(String nome) 
    {
        FileInputStream in = null;
        File arquivo = null;
        byte[] entrada = null;
        
        try {
        	arquivo = new File(nome);
        	in = new FileInputStream(nome);
            entrada = new byte[(int)arquivo.length()];
            in.read(entrada);
            
        } catch(IOException e){
            	e.printStackTrace();
        } finally {
            if (in != null) {
                try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        }
        return entrada;
    }
    
}

