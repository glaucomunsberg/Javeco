package Sistema;
/**
 * Responsável pelo gravação de logs gerados pelo sistema
 * 	do curso
 */
import com.glaucoroberto.time.*;

import java.io.FileNotFoundException; 				//Trata o arquivo não encontrado
import java.lang.SecurityException;					//Trata não poder abrir o arquivo
import java.util.Formatter;							//Formatter auxilia na gravação do arquivo
import java.util.FormatterClosedException;			//Trata eventos de fechamento de formato
import java.util.NoSuchElementException;			//Trata a exceção do dado errado

public class LogDoSistema 
{
	private Time hora;								//Vai trazer a hora atual para inserir no sistema
	private Formatter saida;						//Formatter terá o trabalho de criar o arquivo e
													//alimentá-lo com as informações que receberá
	
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
		
		addLog("Inicializando o sistema de log");
	}
	
	public void addLog(String novaLinha)
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
		}

	}
	
	public void closeFile()
	{
		addLog("Fechando o sistema de log");
		if(saida != null)
		{
			saida.close();
		}
	}

}
