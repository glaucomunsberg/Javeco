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
	public boolean logSerializado;
	public boolean gravouComSucesso = false;
	
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
		Logs.addLog("Inicilizando as Configurações do sistema");
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
	 * Inicia o sistema com informações
	 * 	padroes adotados no desenvolvimento
	 * 	do sistema.
	 * Inicia o curso com valores padrões
	 * sendo sempre
	 */
	private void iniciarInfoDefault()
	{
		Logs.addLog("O Gerenciador do Sistema iniciará com dados 'default'.");
		
		lang = new Lang(Constantes.CONST_DEFAULT_LINGUAGE);
		icones = new Icone(Constantes.CONST_DEFAULT_ICONES);
		fonte = new Fonte(Constantes.CONST_DEFAULT_FONTE);
		Logs.setLogAtivo(Constantes.CONST_DEFAULT_INICLOG);
		
		atualizarValores();
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
		Logs.addLog("O Gerenciador do Sistema iniciará com dados do 'configs.ser'.");
		lerArquivoSerializado();
		lang = new Lang(langSerializada);
		icones = new Icone(iconesSerializado);
		fonte = new Fonte(fonteSerializada);
		Logs.setLogAtivo(logSerializado);
	}
	/**
	 * atualiza os valores para que quando gravar
	 * 		grave com as informações atuais do sistema
	 */
	private void atualizarValores()
	{
		iconesSerializado = icones.getTemaIcone();
		langSerializada = Lang.getTemaLinguagem();
		fonteSerializada = fonte.getTemaFonte();
		logSerializado = Logs.getLogAtivo();
	}
	
	/**
	 * Método para gravar as informações do sistema
	 * 	em um arquivo serializado
	 * @return
	 */
	protected boolean gravarArquivoSerializado()
	{
		Logs.addLog("O Gerenciador do Sistema está gravando os dados em 'configs.ser'.");
		atualizarValores();
		/**
		 * tentará abrir o arquivo para serializar
		 */
		try
		{
			salvar = new ObjectOutputStream( 						//Objeto de sainda
					new FileOutputStream(Constantes.CONST_CONFIGS_URL+"Configs.ser"));		//Arquivo de saida
			gravouComSucesso = true;
		}
		catch( IOException ioException)
		{
			System.err.println("Erro ao abrir o arquivo 'Configs.ser' para serializar.");
			Logs.addLog("Atenção! Erro ao abrir o arquivo 'Configs.ser' para serializar.");
			gravouComSucesso = false;
		}
		
		/**
		 * tentará gravar o arquivo serializado
		 */
		try
		{	
			if(this.logSerializado)
			{
				System.out.printf("Salvará como LOG HABILITADO");
			}
			else
			{
				System.out.printf("Salavá como LOG DESABILITADO");
			}
			
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
			Logs.addLog("Atenção! Erro ao escrever no 'Configs.ser'. ");
			System.err.printf("Atenção! Erro ao escrever no 'Configs.ser'.\n");
			System.err.printf("%s", ioException);
			gravouComSucesso = false;
		}
		catch(NoSuchElementException noSuch )
		{
			/*
			 * Trata a exceção de erro de tipos
			 */
			Logs.addLog("Atenção! Erro de tipos de dados gravados no 'Configs.ser'.");
			System.err.println("Erro no tipo de dado ao gravar");
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
				System.err.println( "Atenção! Não pode fechar o arquivo que foi serializado 'Configs.ser'.");
				Logs.addLog("Atenção! Não pode fechar o arquivo que foi serializado 'Configs.ser'.");
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
			System.err.println( "Atenção! Erro ao abrir o arquivo 'Configs.ser' serializado.");
			Logs.addLog("Atenção! Erro ao abrir o arquivo 'Configs.ser' serializado.");
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
			/*
			 * encontrou o final do arquivo
			 */
			
			return;
		}
		catch( ClassNotFoundException classNot)
		{
			System.err.println( "Atenção! Hablilite a criação do objeto GerenciadorDoSistema");
			Logs.addLog("Atenção! Hablilite a criação do objeto GerenciadorDoSistema");
			
		}
		catch( IOException ioException)
		{
			System.err.println( "Atenção! Erro durante a leitura do arquivo 'Configs.ser'.");
			Logs.addLog("Atenção! Erro durante a leitura do arquivo 'Configs.ser'.");
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
				Logs.addLog("Atenção! Não pode fechar o arquivo serializado 'Configs.ser'.");
		}
	}
}
