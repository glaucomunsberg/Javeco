/**
 * Log é responsável pelos logs gerados pelo sistema.
 * 		ele cria um arquivo que contém a data do dia
 * 		da criação do log. Se já houver então ele
 * 		continuará a escrever nele na parte final.
 * 		Os arquivos de log são gerados na pasta
 * 		/Sistema/Logs/
 * Obs.: O log também está responsável em caso de erro
 * 		notificar alguns desses para o usuário pelo
 * 		metodo notificarUsuario.		
 * @author glaucoroberto@gmail.com
 * @project SSH: git@github.com:glaucomunsberg/Javeco.git
 */

package Sistema;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.SecurityException;					//Trata não poder abrir o arquivo por falta de permissão
import java.util.FormatterClosedException;			//Trata eventos de fechamento de formato
import java.util.NoSuchElementException;			//Trata a exceção do dado errado

import javax.swing.JOptionPane;
public class Log 
{
	protected static boolean jaInicializou = false;
	private static Time hora = new Time();								//Vai trazer a hora atual para inserir no sistema
	private static BufferedWriter saida;								//Formatter terá o trabalho de criar o arquivo e
	protected static boolean logAtivo = true;
	protected String inderecoDoArquivo;
	
	/**
	 * Construtor do log com o estado default
	 */
	public Log()
	{
		logAtivo = Constantes.CONST_DEFAULT_INICLOG;
		
	}
	
	/**
	 * Contrutor do log com o estado ativou ou não
	 * 		dependendo do que o usuário passou
	 * @param ativo
	 */
	public Log(boolean ativo)
	{
		logAtivo = ativo;
	}
	
	/**
	 * openFile abrirá o arquivou ou o criará
	 * 	para conter os logs do sistem
	 * @throws IOException 
	 */
	public void openFile()
	{
		if(jaInicializou)
		{
			Log.addLog("Atenção! O log já foi inicializado.");
		}
		else
		{
			
			try
			{
				/**
				 * inicia o log
				 * 		se JAR então vai criar apenas o log no diretório de execução
				 * 		se for class então criará o log na pasta /Sistema/Logs
				 */
				inderecoDoArquivo = String.format("%sLog_%s-%s-%s.log", ((getClass().getResource( Constantes.CONST_LOG_URL ) == null )? System.getProperty("user.dir")+ "/Cap14 Exec/Sistema/Logs/" : (getClass().getResource( Constantes.CONST_LOG_URL ) )), hora.getDiaAtual(), hora.getMesAtual(),hora.getAnoAtual());
				saida = new BufferedWriter(new FileWriter(inderecoDoArquivo, true));
				jaInicializou = true;
				
			}
			catch(IOException io)
			{
				System.err.printf("Atenção! Erro ao abrir o arquivo %s!",inderecoDoArquivo);
				System.err.printf("%s\n", io);
			}
			catch( SecurityException securityException)
			{
				System.err.println("Atenção! Você não tem permissão para abrir o arquivo de log!");
				System.err.printf("%s\n", securityException);
			}
			addLog("--------------------------------------------------------");
		}

	}
	
	/**
	 * Adiciona uma linha ao arquivo de log
	 * 		essa linha é constituída de:
	 * 		HH:MM:SS - "mensagem"
	 * @param String novaLinha - mensagem que será gravada no log sem "\n"
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
				addLog("Ooops! Ou não! Você mandou o tipo errado e ele não pode ser escrito. Lamentamos u.u");
				System.err.printf("%s\n", element);
			}
			catch( IOException io)
			{
				System.err.printf("Atenção! Erro ao tentar escrever: '%s'.", novaLinha);
				System.err.printf("%s\n", io);
			}
		}
	}
	
	/**
	 * Esse método será usado para o usuário saber
	 * 	que um erro ocorreu no programa dele.
	 * @param String notificao
	 * @param String tipo { "ERRO", "WARNING", null }
	 */
	public static void notificarUsuario(String notificao, String tipo)
	{
		if( tipo == "ERRO" )
		{
			JOptionPane.showMessageDialog(null, notificao, Lang.palavras.getString("erroEncontrado"), JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			if(tipo == "WARNING")
			{
				JOptionPane.showMessageDialog(null, notificao, Lang.palavras.getString("erroNotificao"), JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null, notificao, Lang.palavras.getString("erroSimples"), JOptionPane.PLAIN_MESSAGE);
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
			if(saida != null)
			{
				saida.close();
			}
		}
		catch( IOException io)
		{
			addLog("Atenção! Não pode ser fechado o sistema de log do sistema.");
			System.err.println("Atenção! Não pode ser fechado o sistema de log do sistema.");
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
	 * @param novoEstado
	 */
	public static void setLogAtivo(boolean novoEstado)
	{
		if(novoEstado == false)
		{
			addLog( Lang.palavras.getString("logDesabilitado"));
		}
		else
		{
			addLog(Lang.palavras.getString("logHabilitado"));
		}
		logAtivo = novoEstado;
	}

}
