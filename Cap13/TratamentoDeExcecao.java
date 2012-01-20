/**
 * TratamentoDeExcecao demostra de modo prático como
 * 	funcione o tratamento de evento com "try" e "catch"
 * @author glaucoroberto
 *
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class TratamentoDeExcecao 
{
	public static int cociente(int dividento, int divisor )
	{
		return dividento / divisor; //Aqui pode ocorrer um erro!
	}
	
	public static void main( String args[])
	{
		Scanner scanner = new Scanner( System.in );
		boolean continueLoop = true;
		
		do
		{
			/** TRY
			 * é o bloco executado imediatamente e abortado se qualquer
			 * 	uma dessas leituras forem dadas como exceção.
			 * 	Com isso será executado os CATCH, caso contrário os
			 * 	gulará e continuará a executar o programa
			 * 	OBS.: Identificadores criados dentro de TRY e CATCH
			 * 			são destruidos apos o final do bloco
			 */
			try
			{
				System.out.print("Por favor entre com o dividento: ");
				int dividento = scanner.nextInt();
				System.out.print("Por favor entre com o divisor: ");
				int divisor = scanner.nextInt();
				
				int resultado = cociente( dividento, divisor);
				System.out.printf( "\nResultado: %d / %d = %d", dividento, divisor, resultado);
				continueLoop = false;
			}
			
			/**
			 * Cada CATCH vai manipular um tipo de exceção
			 * 		esete trata o de entrada
			 */
			catch( InputMismatchException inputMismatchException )
			{
				System.err.printf("\nExceção: %s", inputMismatchException);
				scanner.nextLine();
				System.out.printf("Por favor tente novamente\n");
			}
			
			/**
			 * CATCH responsávale pela manipulação de exceções
			 * 	aritméticos
			 */
			catch( ArithmeticException aritmeticExcepetion)
			{
				System.err.printf("\nExceção: %s", aritmeticExcepetion);
				System.out.println("Zero não pode ser um divisor");
			}
		}while( continueLoop );
		
	}

}
