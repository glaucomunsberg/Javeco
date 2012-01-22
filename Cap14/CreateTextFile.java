import java.io.FileNotFoundException; 	//Trata o arquivo não encontrado
import java.lang.SecurityException;		//Trata não poder abrir o arquivo
import java.util.Formatter;				//Formatter auxilia na gravação do arquivo
import java.util.FormatterClosedException;	//
import java.util.NoSuchElementException;	//Trata a exceção do dado errado
import java.util.Scanner;
/**
 * Abre um arquivo e manipula-o inserindo informações
 * @author glaucoroberto
 *
 */
public class CreateTextFile 
{
	private Formatter saida;
	
	private int conta;
	private String nome;
	private String sobreNome;
	private double valor;
	
	/** openFile
	 * 		Método responsável pela abertura do arquivo
	 * @param arg - Nome do arquivo, caso nullo abre o nome default
	 */
	public void openFile(String arg)
	{
		try
		{
			if( arg == null)
			{
				saida = new Formatter("Cap14/arquivoDeTexto.txt");
			}
			else
			{
				saida = new Formatter(arg);
			}
		}
		catch( SecurityException securityException)
		{
			System.err.println("você não tem acesso de escrita");
			System.exit(1);
		}
		catch( FileNotFoundException fileNotFoundException)
		{
			System.err.println("erro ao criar arquivo");
			System.exit(1);
		}
	}
	
	/** addRecords
	 *  faz a leitura e a escrita no arquivo aberto
	 *  	pelo método openFile
	 */
	public void addRecords()
	{
		Scanner entrada = new Scanner( System.in );
		System.out.printf("%s\n%s\n%s\n%s\n\n", "Para terminar a entrada do tipo end-of-file",
								"você precisa utilizar a seguinte expressao:", "<ctrl> + d","mais ENTER para terminar");
		System.out.printf("%s\n%s", "Entre numero de conta > 0. Nome, sobrenome e valor", "?");
		
		while( entrada.hasNext() )
		{
			try
			{
				conta		= entrada.nextInt();
				nome 		= entrada.next();
				sobreNome	= entrada.next();
				valor		= entrada.nextDouble();
				
				if( conta > 0 )
				{
					saida.format("%d %s %s %.2f\n", conta, nome, sobreNome,valor);
					saida.flush();
				}
				else
				{
					System.out.println("Nº de conta negativa!");
				}
			}
			catch( FormatterClosedException formatterClosedException)
			{
				System.err.println("Erro ao escrever");
				entrada.nextLine();
			}
			catch( NoSuchElementException element)
			{
				System.err.println("Invalida entrada!");
				entrada.nextLine();
			}
			
			System.out.printf("%s %s\n%s", "Enter com conta > 0", "Primeiro, ultimo nome e valor", "?");
		}
	}
	
	/**
	 * closeFile
	 * 	fecha o arquivo aberto pelo
	 * 		método openFile
	 */
	public void closeFile()
	{
		if(saida != null)
		{
			saida.close();
		}
	}
}
