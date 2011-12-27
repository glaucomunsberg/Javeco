/** Somador
 * 		programa que lê dois inteiros e faz sua soma
 * 		informando qual é o maior.
 * @author glaucoroberto
 *
 */

import java.util.Scanner; // Importa a classe responsável pela leitura na tela
public class Somar
{
	public static void main( String args[] )
	{
		Scanner entrada =  new Scanner( System.in ); //Cria um objeto tipo Scanner para ler in inteiro
		
		int primeiro;
		int segundo;
		int soma;
		
		System.out.println( "----Somador----\n Insira o primeiro número:" );
		primeiro = entrada.nextInt();
		System.out.println( " Insira o segundo número:" );
		segundo = entrada.nextInt();
		
		soma = primeiro + segundo;
		
		/*Imprime qual se o primeiro é menor ou
		 *	ou maior que o segundo.
		 */
		
		if( primeiro == segundo )
		{
			System.out.print("Ambos números são iguais e ");
		}
		else
		{
			if( primeiro < segundo )
			{
				System.out.printf( "O primeiro é menor que o segundo e " );
			}
			else
			{
				System.out.printf( "O primeiro é maior que o segundo e " );
			}
		}
		
		System.out.printf( "o valor da soma é: %d\n" , soma);
		
	}
}
