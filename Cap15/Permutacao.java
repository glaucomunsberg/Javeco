import java.util.Scanner;

public class Permutacao 
{
	public static void main( String args[] )
	{
		Scanner input = new Scanner( System.in );
		Permutacao permute = new Permutacao();
		
		System.out.printf("Insira a string para permutação:\n");
		String string = input.nextLine();
		permute.permutacao("", string);
		
		
	}
	
	public void permutacao(String inicio, String finali)
	{
		if(finali.length() <= 1)
		{
			System.out.println( inicio + finali);
		}
		else
		{
			for( int i =0; i < finali.length();i++)
			{
				try
				{
					String temp = finali.substring(0,i) + finali.substring(i+1);
					// String.Substring(int, int) recebe dois interios como parametros
					//		sendo o primeiro de onde começará a copiar na string
					//		e o segundo sendo um além do último a ser copiado
					// String.Substring(int) as posições seguinte serão repassado
					//		discartando os anteriores
					//Obs.: em conjunto a utilização de ambos forma a remoção
					// de um elemento no caso do temp
					permutacao(inicio + finali.charAt(i), temp);
				}
				catch( StringIndexOutOfBoundsException exept)
				{
					exept.printStackTrace();
				}
			}
		}
	}
}
