/**
 * Classe que gerencia os elementos do sistema
 * 		como iniciará o sistemaDoCurso, Icones,
 * 		fonte e Idioma entre outros
 */
package Sistema;

public class GerenciadorDoSistema 
{
	public enum HowStart{
		DEFAULT, RECUPERAR;
	}
	
	public Lang lang;												//Idiota do sistema
	public Icones icones;											//Icones para o sistema
	public Fonte fonte;												//Fonte para o sistema
	public HowStart iniciar;										//Como iniciará o sistema. Pode ser através de uma recuperação ou dados Default
	/**
	 * recebe como parametro qual o modo de inicialização
	 * 	cada um deles tem um perfil, o DEFAULT trás valores
	 * 	que o sistema tem como padrão, já o RECUPERAR trás
	 * 	informações de outras vezes que o mesmo foi utiliza
	 * @param iniciarComo
	 */
	public GerenciadorDoSistema(HowStart iniciarComo)
	{
		LogDoSistema.addLog("Iniciando Configurações do sistema");
		if( iniciarComo == HowStart.DEFAULT)
		{
			iniciarInfoDefault();
		}
		else
		{
			if( iniciarComo == HowStart.RECUPERAR)
			{
				iniciarInfoRestaurando();

			}
			else
			{
				LogDoSistema.addLog("Atenção! O sistema não pode identificar qual o modo de abertura. As informações 'default' será ativado.");
				iniciarInfoDefault();
			}
		}
	}
	
	/**
	 * Inicia o sistema com informações
	 * 	padroes adotados no desenvolvimento
	 * 	do sistema.
	 * Inicia o curso com valores padrões
	 * sendo sempre null ou 0 
	 */
	private void iniciarInfoDefault()
	{
		LogDoSistema.addLog("O sistema iniciará com dados 'default'.");
		lang = new Lang("pt_BR");
		icones = new Icones(1);
		fonte = new Fonte(1);
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
		LogDoSistema.addLog("O sistema iniciará com dados do arquivo 'configs.ser' .");
	}
}
