package Sistema;

public class SistemConfiguracoes 
{
	public enum HowStart{
		DEFAULT, RECUPERAR;
	}
	
	public Lang lang;
	public Icones icones;
	public Fonte fonte;
	public HowStart iniciar;
	
	public SistemConfiguracoes(HowStart iniciarComo)
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
				System.exit(1);
			}
		}
	}
	
	private void iniciarInfoDefault()
	{
		LogDoSistema.addLog("O sistema iniciará com dados 'default'.");
		lang = new Lang(1);
		icones = new Icones(1);
		fonte = new Fonte(1);
	}
	
	private void iniciarInfoRestaurando()
	{
		LogDoSistema.addLog("O sistema iniciará com dados do arquivo 'configs.ser' .");
	}
}
