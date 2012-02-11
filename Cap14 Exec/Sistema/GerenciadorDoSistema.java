/**
 * Classe que gerencia os elementos do sistema
 * 		como iniciará o sistemaDoCurso, Icones,
 * 		fonte e Idioma entre outros
 */
package Sistema;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.NoSuchElementException;

import Sistema.Configs.Configs;


public class GerenciadorDoSistema
{
	/**
	 * 
	 */
	ObjectOutputStream salvar;
	ObjectInputStream salvado;
	
	/*
	 * Serao os parametros para dizer ao
	 * 	Configs qual é os temas usado pelo sistema
	 */
	public int langSerializada;						
	public int iconesSerializado;
	public int fonteSerializada;
	
	public Lang lang;								//Idiota do sistema
	public Icone icones;							//Icones para o sistema
	public Fonte fonte;								//Fonte para o sistema										//Como iniciará o sistema. Pode ser através de uma recuperação ou dados Default
	/**
	 * recebe como parametro qual o modo de inicialização
	 * 	cada um deles tem um perfil, o DEFAULT trás valores
	 * 	que o sistema tem como padrão, já o RECUPERAR trás
	 * 	informações de outras vezes que o mesmo foi utiliza
	 * @param iniciarComo
	 */
	public GerenciadorDoSistema()
	{
		LogDoSistema.addLog("Inicilizando as Configurações do sistema");
		File arqConfigs = new File("Cap14 Exec/Sistema/Configs/Configs.ser");
		
		if( arqConfigs.isFile() && arqConfigs != null )
		{
			iniciarInfoRestaurando();
		}
		else
		{
			iniciarInfoDefault();
		}
		
	}
	
	/**
	 * Inicia o sistema com informações
	 * 	padroes adotados no desenvolvimento
	 * 	do sistema.
	 * Inicia o curso com valores padrões
	 * sendo sempre
	 */
	private void iniciarInfoDefault()
	{
		LogDoSistema.addLog("O Gerenciador do Sistema iniciará com dados 'default'.");
		
		lang = new Lang("pt_BR");
		icones = new Icone(1);
		fonte = new Fonte(1);
		
		iconesSerializado = icones.getTemaIcone();
		langSerializada = lang.getTemaLinguagem();
		fonteSerializada = fonte.getTemaFonte();
		gravarArquivoSerializado();
	}
	
	/**
	 * Inicia o sistema com as informações obtidas
	 * 	pela recuperação de informações do arquivo
	 * 	configs.ser
	 * Inicia o curso com informações obtidas pelo
	 *  arquivo data.dat
	 */
	private void iniciarInfoRestaurando()
	{
		LogDoSistema.addLog("O Gerenciador do Sistema iniciará com dados do 'configs.ser'.");
		lerArquivoSerializado();
		lang = new Lang(langSerializada);
		icones = new Icone(iconesSerializado);
		fonte = new Fonte(fonteSerializada);
	}
	
	protected void gravarArquivoSerializado()
	{
		LogDoSistema.addLog("O Gerenciador do Sistema está gravando os dados em 'configs.ser'.");
		/**
		 * tentará abrir o arquivo para serializar
		 */
		try
		{
			salvar = new ObjectOutputStream( 						//Objeto de sainda
					new FileOutputStream("Cap14 Exec/Sistema/Configs/Configs.ser"));		//Arquivo de saida
		}
		catch( IOException ioException)
		{
			System.err.println("Erro ao abrir o arquivo 'Configs.ser' para serializar.");
			LogDoSistema.addLog("Atenção! Erro ao abrir o arquivo 'Configs.ser' para serializar.");
			
		}
		
		/**
		 * tentará gravar o arquivo serializado
		 */
		try
		{	
			Configs salvarConfiguracaoes = new Configs(iconesSerializado, fonteSerializada, langSerializada);
			salvar.writeObject(salvarConfiguracaoes);																//O objeto saida recebe a classe para sair o objeto
			salvar.flush();																									//"flush()" garante que a gravação será imediata!
		}
		catch(IOException ioException)
		{
			/*
			 * trata a exceção de erro de I/O
			 */
			LogDoSistema.addLog("Atenção! Erro ao escrever no 'Configs.ser'. ");
			System.err.printf("Atenção! Erro ao escrever no 'Configs.ser'.\n");
			System.err.printf("%s", ioException);
		}
		catch(NoSuchElementException noSuch )
		{
			/*
			 * Trata a exceção de erro de tipos
			 */
			LogDoSistema.addLog("Atenção! Erro de tipos de dados gravados no 'Configs.ser'.");
			System.err.println("Erro no tipo de dado ao gravar");
		}
		
		/**
		 * tenta fechar o arquivo que foi serializado
		 */
		try
		{
			if( salvar != null )
			{
				salvar.close();
			}

		}
		catch(IOException exception)
		{
				System.err.println( "Atenção! Não pode fechar o arquivo que foi serializado 'Configs.ser'.");
				LogDoSistema.addLog("Atenção! Não pode fechar o arquivo que foi serializado 'Configs.ser'.");
		}
	}
	
	protected void lerArquivoSerializado()
	{
		/**
		 * abrirá o arquivo
		 */
		try
		{
			salvado = new ObjectInputStream( new FileInputStream( "Cap14 Exec/Sistema/Configs/Configs.ser"));
		}
		catch( IOException ioException)
		{
			System.err.println( "Atenção! Erro ao abrir o arquivo 'Configs.ser' serializado.");
			LogDoSistema.addLog("Atenção! Erro ao abrir o arquivo 'Configs.ser' serializado.");
		}
		
		Configs configuracaoesSalvas;
		
		/**
		 * lerá o arquivo
		 */
		try
		{
			configuracaoesSalvas = ( Configs ) salvado.readObject();
			this.fonteSerializada = configuracaoesSalvas.getFonteSerializado();
			this.iconesSerializado = configuracaoesSalvas.getIconeSerializado();
			this.langSerializada = configuracaoesSalvas.getLangSerializado();
			configuracaoesSalvas = null;
		}
		catch( EOFException endOfFileExcepetion)
		{
			/*
			 * encontrou o final do arquivo
			 */
			
			return;
		}
		catch( ClassNotFoundException classNot)
		{
			System.err.println( "Atenção! Hablilite a criação do objeto GerenciadorDoSistema");
			LogDoSistema.addLog("Atenção! Hablilite a criação do objeto GerenciadorDoSistema");
			
		}
		catch( IOException ioException)
		{
			System.err.println( "Atenção! Erro durante a leitura do arquivo 'Configs.ser'.");
			LogDoSistema.addLog("Atenção! Erro durante a leitura do arquivo 'Configs.ser'.");
			System.err.printf("\n%s", ioException);
		}
		
		
		/**
		 * Fechará o arquivo
		 */
		try
		{
			if( salvado != null )
			{
				salvado.close();
			}

		}
		catch(IOException exception)
		{
				System.err.println( "Atenção! Não pode fechar o arquivo serializado 'Configs.ser'.");
				LogDoSistema.addLog("Atenção! Não pode fechar o arquivo serializado 'Configs.ser'.");
		}
	}
}
