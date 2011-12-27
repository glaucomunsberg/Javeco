/** PassagemParametros
 * 		programa para demonstrar como funciona a passagem de parametros pelo terminal
 * 
 * @args	args[0] tamanho do vetor
 * 			args[1] valor inicial de cada posicao
 * 			args[2] valor adicional em casa posicao
 * @author glaucoroberto
 *
 */
public class PassagemParametros 
{
	public static void main( String args[])
	{
		if(args.length != 3)
		{
			System.out.printf("Tamanho errado de argumentos.\n É necessário três pelo menos:\n Primeiro: número de argumentos\n Segundo: Valor Inicial\n Terceiro: Valor para ser incrementado\n");
		}
		else
		{
			int tamanhoDoArray = Integer.parseInt(args[0]);			// Converte o primeiro para o tamanho do array
			int array[] = new int [ tamanhoDoArray];				// Cria o Array
			
			int valorInicial = Integer.parseInt(args[1]);			//o valor inicial
			int valorParaIncrementar = Integer.parseInt(args[2]);	// Valor para incrementar
					
			for( int conta = 0; conta < array.length; conta++)
			{
				array[conta] = valorInicial + valorParaIncrementar * conta;
			}
			
			for(int conta = 0; conta < array.length; conta++)
			{
				System.out.printf("%5d%8d\n", conta, array[conta]);
			}
		}
	}
}
