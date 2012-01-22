/** ReadTextFile
 * 		classe implementada para a leitura
 * 		de um arquivo já estabelecido com
 * 		dados.
 * 	Para que esse dado seja lido precisa
 * 		que haja escrita da seguinte forma:
 * 		int_String_String_Double
 * 	obs.: "_" é espaço
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadTextFile
{
	
	private String abrir;						//Recebe o endereço do arquivo
	private Scanner entrada;					//Scanner para a leitura do arquivo
	
	public void openFile(String args)
	{
		/*
		 *	recebe o args que possui o caminho
		 *	então seta o caminho no abrir 
		 */
		if( args == null)
		{
			abrir = "Cap14/arquivoDeTexto.txt";
		}
		else
		{
			abrir = args;
		}
		
		try
		{
			entrada = new Scanner( new File(abrir)); //Abre o arquivo
		}
		catch( FileNotFoundException fileNotFoundException)
		{
			
			/*
			 * ocorrerá se o arquivo especificado não
			 * por encontado
			 */
			
			System.err.printf("Erro ao abrir o arquivo");
			System.exit(1);
		}
	}
	
	public void readFile()
	{
		int 	conta;
		String 	nome;
		String 	sobreNome;
		double 	valor;
		
		try
		{
			while( entrada.hasNext())
			{
				conta 	= entrada.nextInt();
				nome 	= entrada.next();
				sobreNome = entrada.next();
				valor 	= entrada.nextDouble();
				System.out.printf("%d \t%s \t%s \t%.2f\n", conta, nome, sobreNome,valor);
			}
		}
		catch( NoSuchElementException noSuch)
		{
			/*
			 * Ocorre o tipo do dado é diferente do esperado
			 * isso ocorre caso "conta" receba um valor String
			 * ou algo parecido
			 */
			System.err.printf("Arquivo no formata incorreto!");
			entrada.close();
			System.exit(1);

		}
		catch( IllegalStateException illegalState)
		{
			/*
			 * Ocorre quando o scanner (entrada) é fechado
			 * antes do tempo
			 */
			System.err.printf("Erro ao ler o arquivo");
			System.exit(1);
		}
	}
	
	public void close()
	{
		if( entrada != null )
		{
			entrada.close();
		}
	}

}
