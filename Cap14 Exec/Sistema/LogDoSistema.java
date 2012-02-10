package Sistema;
/**
 * Responsável pelo gravação de logs gerados pelo sistema
 * 	do curso
 */
import com.glaucoroberto.time.*;

import java.io.File;
import java.io.FileNotFoundException; 				//Trata o arquivo não encontrado
import java.lang.SecurityException;					//Trata não poder abrir o arquivo
import java.util.Formatter;							//Formatter auxilia na gravação do arquivo
import java.util.FormatterClosedException;			//Trata eventos de fechamento de formato
import java.util.NoSuchElementException;			//Trata a exceção do dado errado

public class LogDoSistema 
{
	protected static boolean tentouRecuperarAntes = false;
	private static String inderecoDoArquivo;
	private static Time hora = new Time();								//Vai trazer a hora atual para inserir no sistema
	private static Formatter saida;					//Formatter terá o trabalho de criar o arquivo e
													//alimentá-lo com as informações que receberá
	
	
	public static void openFile(String arg)
	{
		try
		{
			if( arg == null)
			{
				inderecoDoArquivo = String.format("Cap14 Exec/Sistema/Logs/Log_%s-%s-%s.txt", hora.getDiaAtual(), hora.getMesAtual(),hora.getAnoAtual());
				saida = new Formatter( new File(inderecoDoArquivo));	//Abre o arquivo ou
			}
			else
			{
				inderecoDoArquivo = arg;
				saida = new Formatter(arg);
			}
		}
		catch( SecurityException securityException)
		{
			System.err.println("Atenção! Você não tem permissão para abrir o arquivo. O sistema tentará se recuperar");
			if(tentouRecuperarAntes != true)
			{
				tentarRecuperar();
			}
			else
			{
				System.err.println("Atenção! Sistema de Log não pode se recuperar!");
			}
		}
		catch( FileNotFoundException fileNotFoundException)
		{
			System.err.println("Atenção! Arquivo não encontrado! O sistema tentará se recuperar");
			System.err.printf("%s\n", fileNotFoundException);
			if( tentouRecuperarAntes != true)
			{
				tentarRecuperar();
			}
			else
			{
				System.err.println("Atenção! Sistema de log não pode se recuperar!");
			}
		}
		System.out.printf("Inicializando o sistema de log");
		addLog("Inicializando o sistema de log.");
	}
	protected static void tentarRecuperar()
	{
		tentouRecuperarAntes = true;
		openFile(inderecoDoArquivo);
		addLog("Tentativa de reiniciar o sistema de log executada com sucesso!");
	}
	public static void addLog(String novaLinha)
	{
		hora = new Time();
		try
		{
			saida.format("%s - %s\n", hora.getHoraAtual(), novaLinha );
			saida.flush();
		}
		catch( FormatterClosedException formatterClosedException)
		{
			System.err.println("Ooops! Nossos escribas encontraram um problema ao escrever o arquivo õ.o");
		}
		catch( NoSuchElementException element)
		{
			System.err.println("Ooops! Ou não! Você mandou o tipo errado e ele não pode ser escrito. Lamentamos u.u");
			LogDoSistema.addLog("Ooops! Ou não! Você mandou o tipo errado e ele não pode ser escrito. Lamentamos u.u");
		}

	}
	
	public void closeFile()
	{
		addLog("Fechando o sistema de log");
		System.out.println("Fechando o sistema de log");
		if(saida != null)
		{
			saida.close();
		}
	}

}
