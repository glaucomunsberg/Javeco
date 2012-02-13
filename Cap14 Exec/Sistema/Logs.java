
/**
 * Responsável pelo gravação de logs gerados pelo sistema
 * 	do curso
 */

package Sistema;

import com.glaucoroberto.time.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.SecurityException;					//Trata não poder abrir o arquivo
import java.util.FormatterClosedException;			//Trata eventos de fechamento de formato
import java.util.NoSuchElementException;			//Trata a exceção do dado errado

public class Logs 
{
	protected static boolean tentouRecuperarAntes = false;
	private static String inderecoDoArquivo;
	private static Time hora = new Time();								//Vai trazer a hora atual para inserir no sistema
	private static BufferedWriter saida;					//Formatter terá o trabalho de criar o arquivo e
	protected static boolean logAtivo = true;
	
	/**
	 * abre o sistema para escrever logs. Pode
	 * 		se receber um parametro que é o caminho
	 * 		para o local onde será gravado as inf de
	 * 		log.
	 * @param String arg - URL para o local de se gravar as informações
	 * 				não é necessário o nome do arquivo pois esse é gerado pelo
	 * 				sistema
	 * @throws IOException 
	 */
	public static void openFile(String arg)
	{
		try
		{
			logAtivo = Constantes.CONST_DEFAULT_INICLOG;
			if( arg == null)
			{
				inderecoDoArquivo = String.format("Cap14 Exec/Sistema/Logs/Log_%s-%s-%s.log", hora.getDiaAtual(), hora.getMesAtual(),hora.getAnoAtual());
				saida = new BufferedWriter(new FileWriter(inderecoDoArquivo, true));  
			}
			else
			{
				inderecoDoArquivo = String.format("%sLog_%s-%s-%s_.log", hora.getDiaAtual(), hora.getMesAtual(),hora.getAnoAtual());
				saida = new BufferedWriter( new FileWriter(inderecoDoArquivo, true));
			}
		}
		catch(IOException io)
		{
			System.err.printf("Atenção! Erro ao abrir o arquivo %s!",inderecoDoArquivo);
			if(tentouRecuperarAntes == false)
			{
				tentarRecuperar();
			}
		}
		catch( SecurityException securityException)
		{
			System.err.println("Atenção! Você não tem permissão para abrir o arquivo!");
		}
		addLog("--------------------------------------------------------");
	}
	
	/**
	 * Tenta forçar a abertura de um novo arquivo
	 * agora no log do local padrão do sistema
	 * @throws IOException 
	 */
	protected static void tentarRecuperar()
	{
		tentouRecuperarAntes = true;
		closeFile();
		openFile("Cap14 Exec/Sistema/Logs/");
		addLog("Atenção! O arquivo de log anterior não ser escrito.");

	}
	
	/**
	 * Adiciona uma linha ao arquivo de log
	 * 		essa linha é constituída de:
	 * 		HH:MM:SS - "mensagem"
	 * @param String novaLinha - mensagem que será gravada no log
	 * @throws IOException 
	 */
	public static void addLog(String novaLinha)
	{
		if( logAtivo)
		{
			hora = new Time();
			try
			{
				String temp = String.format("%s - %s\n", hora.getHoraAtual(), novaLinha);
				saida.write(temp);
				saida.flush();
			}

			catch( FormatterClosedException formatterClosedException)
			{
				System.err.println("Ooops! Nossos escribas encontraram um problema ao escrever o arquivo õ.o");
			}
			catch( NoSuchElementException element)
			{
				System.err.println("Ooops! Ou não! Você mandou o tipo errado e ele não pode ser escrito. Lamentamos u.u");
				Logs.addLog("Ooops! Ou não! Você mandou o tipo errado e ele não pode ser escrito. Lamentamos u.u");
			}
			catch( IOException io)
			{
				System.err.printf("Atenção! Erro ao tentar escrever: '%s' no arquivo %s!", novaLinha, inderecoDoArquivo);
			}
		}
	}
	
	/**
	 * Fecha o sistema de log para que não se perca nenhum
	 * 		dado de log
	 * @throws IOException 
	 */
	public static void closeFile()
	{
		try
		{
			addLog("Fechando o sistema de log");
			System.out.println("Fechando o sistema de log");
			if(saida != null)
			{
				saida.close();
			}
		}
		catch( IOException io)
		{
			
		}

	}
	
	/**
	 * retorna se a gravação do log está ativa
	 * @return
	 */
	public static boolean getLogAtivo()
	{
		return logAtivo;
	}
	
	/**
	 * modifica a situacao de se o log está
	 * 	sendo gravado ou não
	 * @param novo
	 * @return 
	 * @return Boolean 
	 */
	public static void setLogAtivo(boolean novo)
	{
		if(novo == false)
		{
			addLog( Lang.palavras.getString("logDesabilitado"));
		}
		else
		{
			addLog(Lang.palavras.getString("logHabilitado"));
		}
		logAtivo = novo;
	}

}
