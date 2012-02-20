/**
 * Classe que gerencia os elementos do sistema como iniciará o sistemaDoCurso,
 * 		os icones, fonte e idioma entre outros atributos
 * 
 * @author glaucoroberto@gmail.com
 * @project SSH: git@github.com:glaucomunsberg/Javeco.git
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
	 * Objetos de stream recebe e manda dados para os .ser
	 */
	ObjectOutputStream salvar;
	ObjectInputStream salvado;
	
	/*
	 * Serao os parametros para dizer ao
	 * 	Configs qual são os temas usado pelo sistema
	 */
	protected int langSerializada;						
	protected int iconesSerializado;
	protected int fonteSerializada;
	protected boolean logSerializado;
	protected boolean gravouComSucesso = false;
	
	public Lang lang;								//Idiota do sistema
	public Icone icones;							//Icones para o sistema
	public Fonte fonte;								//Fonte para o sistema										//Como iniciará o sistema. Pode ser através de uma recuperação ou dados Default
	
	/**
	 * Ao iniciar o gerenciadorDoSistema
	 *	 	ele verifica se há um arquivo .ser para
	 *		tentar recuperar os dados apartir dele,
	 * 		caso não encontre iniciará em modo 'default'
	 * 		que estão em forma de constantes
	 */
	public GerenciadorDoSistema()
	{
		
		Log.addLog("Inicilizando as Configurações do sistema");
		File arqConfigs = new File(Constantes.CONST_CONFIGS_URL+"Configs.ser");
		
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
	 * Inicia o sistema com informações padrões adotados 
	 * 		no desenvolvimento do sistema. Esses valores
	 * 		podem ser modificados, mas exige cuidado para
	 * 		que não haja instabilidade.
	 */
	protected void iniciarInfoDefault()
	{
		Log.addLog("O Gerenciador do Sistema iniciará com dados 'default'.");
		
		lang = new Lang(Constantes.CONST_DEFAULT_LINGUAGE);
		icones = new Icone(Constantes.CONST_DEFAULT_ICONES);
		fonte = new Fonte(Constantes.CONST_DEFAULT_FONTE);
		Log.setLogAtivo(Constantes.CONST_DEFAULT_INICLOG);
		
		atualizarValores();
	}
	
	/**
	 * Inicia o sistema com as informações obtidas
	 * 	pela recuperação de informações do arquivo
	 * 	Configs.ser
	 */
	protected void iniciarInfoRestaurando()
	{
		Log.addLog("O Gerenciador do Sistema iniciará com dados do 'configs.ser'.");
		lerArquivoSerializado();
		lang = new Lang(langSerializada);
		icones = new Icone(iconesSerializado);
		fonte = new Fonte(fonteSerializada);
		Log.setLogAtivo(logSerializado);
	}
	
	/**
	 * Atualiza os valores para que quando gravar
	 * 		grave com as informações atuais do sistema
	 * 		sem que seja gravados os valores obtidos
	 * 		na inicialização do sistema
	 */
	protected void atualizarValores()
	{
		iconesSerializado = icones.getTemaIcone();
		langSerializada = Lang.getTemaLinguagem();
		fonteSerializada = fonte.getTemaFonte();
		logSerializado = Log.getLogAtivo();
	}
	
	/**
	 * Método para gravar as informações do sistema
	 * 		em um arquivo serializado de nome Config.ser
	 * 		retornando true se gravou com sucesso ou false
	 * 		caso falhe
	 * @return 
	 */
	protected boolean gravarArquivoSerializado()
	{
		Log.addLog("O Gerenciador do Sistema está gravando os dados em 'configs.ser'.");
		atualizarValores();	//Assegura que os dados sejam os mais atuais
		
		/**
		 * tentará abrir o arquivo para serializar
		 */
		try
		{
			salvar = new ObjectOutputStream( 												//Objeto de sainda
					new FileOutputStream(Constantes.CONST_CONFIGS_URL+"Configs.ser"));		//Arquivo de saida
			gravouComSucesso = true;
		}
		catch( IOException ioException)
		{
			System.err.printf("%s\n",ioException);
			Log.addLog("Atenção! Erro ao abrir o arquivo 'Configs.ser' para serializar.");
			Log.notificarUsuario("Oops! Não temos como recupar suas informações do arquivo 'Configs.ser' ", "WARNING");
			gravouComSucesso = false;
		}
		
		/**
		 * tentará gravar o arquivo serializado
		 */
		try
		{	
			
			Configs salvarConfiguracaoes = new Configs(iconesSerializado, fonteSerializada, langSerializada, logSerializado);
			salvar.writeObject(salvarConfiguracaoes);																//O objeto saida recebe a classe para sair o objeto
			salvar.flush();																								//"flush()" garante que a gravação será imediata!
			gravouComSucesso = true;
		
		}
		catch(IOException ioException)
		{
			/*
			 * trata a exceção de erro de I/O
			 */
			System.err.printf("%s\n", ioException);
			Log.addLog("Atenção! Erro ao escrever no 'Configs.ser'.");
			Log.notificarUsuario("Ooops! Pedidos desculpas, mas não podemos criar seu arquivo de configurações do sistema neste momento.", "WARNING");
			gravouComSucesso = false;
		}
		catch(NoSuchElementException noSuch )
		{
			/*
			 * Trata a exceção de erro de tipos
			 */
			System.err.printf("%s\n", noSuch);
			Log.addLog("Atenção! Erro de tipo de dados gravados no 'Configs.ser'.");
			Log.notificarUsuario("Ooops! Houve uma confusão com o tipo de dado ao gravar. Tente novamente.", "ERRO");
			gravouComSucesso = false;
		}
		
		/**
		 * tenta fechar o arquivo que foi serializado
		 */
		try
		{
			if( salvar != null )
			{
				salvar.close();
				gravouComSucesso = true;
			}

		}
		catch(IOException exception)
		{
				System.err.printf("%s\n", exception);
				Log.addLog("Atenção! Não pode fechar o arquivo que foi serializado 'Configs.ser'.");
				Log.notificarUsuario("Ooops! Erro a tentar fechar o arquivo de configuração do sistema.\nSe o problema persistir remova o arquivo Configs.ser", null);
				gravouComSucesso = false;
		}
		
		return gravouComSucesso;
	}
	
	protected void lerArquivoSerializado()
	{
		/**
		 * abrirá o arquivo
		 */
		try
		{
			salvado = new ObjectInputStream( new FileInputStream( Constantes.CONST_CONFIGS_URL+"Configs.ser"));
		}
		catch( IOException ioException)
		{
			System.err.printf( "%s\n", ioException);
			Log.addLog("Atenção! Erro ao abrir o arquivo 'Configs.ser' serializado.");
			Log.notificarUsuario("Ooops! Erro ao abrir o arquivo 'Configs.ser'. Tente abrir o sistema novamente. Se continuar o problema delete-o", "ERRO");
		}
		
		Configs configuracoesSalvas;
		
		/**
		 * lerá o arquivo
		 */
		try
		{
			configuracoesSalvas = ( Configs ) salvado.readObject();
			this.fonteSerializada = configuracoesSalvas.getFonteSerializado();
			this.iconesSerializado = configuracoesSalvas.getIconeSerializado();
			this.langSerializada = configuracoesSalvas.getLangSerializado();
			this.logSerializado = configuracoesSalvas.getLogAtivo();
			configuracoesSalvas = null;
		}
		catch( EOFException endOfFileExcepetion)
		{
			
			/**
			 * encontrou o final do arquivo
			 */
			return;
		}
		catch( ClassNotFoundException classNot)
		{
			System.err.printf("%s\n", classNot);
			Log.addLog("Atenção! Hablilite a criação do objeto GerenciadorDoSistema");
			Log.notificarUsuario("Ooops! O erro foi feio e vamos fechar o programa. Se persistir remova o arquivo 'Configs.ser'", "ERRO");
		}
		catch( IOException ioException)
		{
			System.err.printf("%s\n", ioException);
			Log.addLog("Atenção! Erro durante a leitura do arquivo 'Configs.ser'.");
			Log.notificarUsuario("Ooops! Erro em alguma parte do arquivo de configurações do sistema", "WARNING");
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
				System.err.printf("%s\n", exception);
				Log.addLog("Atenção! Não pode fechar o arquivo serializado 'Configs.ser'.");
		}
	}
}