package LoginCriando;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ValidandoLogin 
{
   public String valida(String nome, String senha, String tipo)
   {
	   ArrayList<String> vetorUsuarios = new ArrayList<String>();
	   try
	   {
		   Teste t = new Teste();
		   String decifrada = t.geraDecifra();
		   Scanner input = new Scanner(decifrada);
		   while (input.hasNext()) 
		   {  
			   vetorUsuarios.add(input.next());
		   }
		 
		   input.close();    
	   } 
	   catch (Exception e) {
		   e.printStackTrace();
	   }
	   
	   bubbleSort(vetorUsuarios);
	   String dados = nome.trim() + senha.trim() + tipo;

	   int indice = busca(vetorUsuarios,dados) ;
	   if(indice == vetorUsuarios.size())
	   {
		   return null;
	   }
	   else return vetorUsuarios.get(indice);
   }
   
   //BUBBLE
   public static void bubbleSort(ArrayList<String> list)
   {
	   String temp;
         if (list.size()>1) // check if the number of orders is larger than 1
         {
             for (int x=0; x<list.size(); x++) // bubble sort outer loop
             {
                 for (int i=0; i < list.size()-x-1; i++) {
                     if (list.get(i).compareTo(list.get(i+1)) > 0)
                     {
                         temp = list.get(i);
                         list.set(i,list.get(i+1) );
                         list.set(i+1, temp);
                     }
                 }
             }
         }
   }

   
   
   public int busca(ArrayList<String> vetor, String chave)
   {
      int saida = vetor.size();
      int baixo, alto, meio;
      baixo = 0;
      alto= vetor.size() -1;
      while(baixo <= alto)
      {
         meio= (baixo + alto)/2;
         if(chave.toUpperCase().charAt(0) > vetor.get(meio).toUpperCase().charAt(0))
         {
            baixo = meio + 1;
         }
         else if(chave.toUpperCase().charAt(0) < vetor.get(meio).toUpperCase().charAt(0))
         {
            alto = meio - 1;
         }
         else
         {
            if(chave.equalsIgnoreCase(vetor.get(meio)))
            {
               return meio;
            }
            else return saida; // Não pode haver usuários iguais
         }
      }
      return saida;
   }
}

		 

