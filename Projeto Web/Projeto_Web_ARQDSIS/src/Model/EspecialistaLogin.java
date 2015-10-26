package Model;

import javax.servlet.RequestDispatcher;

public class EspecialistaLogin {
	
	
public boolean verificaLogin(String usuario, String senha, String cbtipo){
		
		if((usuario.equals("Paloma")) && (senha.equals("123")) && (cbtipo.equals("atendente")))
		{
			return true;
		}
		else if((usuario.equals("Paloma")) && (senha.equals("123")) && (cbtipo.equals("supervisor"))){
			return true;
		}
		
		return false;
}
	
}
