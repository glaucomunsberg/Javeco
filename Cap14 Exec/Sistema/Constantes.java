
/*
 * ATENÇÃO! Tenha muito cuidado, pois a troca das constantes
 * 		pode causar instabilidade ou até mesmo a não
 * 		execução do sistema inteiro!
 */
package Sistema;

/**
 * Constantes contem a base do sistema em relação ao seus
 * 		diretórios. Tambpem contem configurações default
 * 		do sistema.
 */
public class Constantes
{
	/**
	 * constantes de diretório dos do sistema
	 */
	static final String CONST_BASE 			= "Cap14 Exec/";
	static final String CONST_BASE_SISTEMA 	= CONST_BASE + "Sistema/";
	static final String CONST_LOG_URL 			= CONST_BASE_SISTEMA + "Logs/";
	static final String CONST_ICONS_URL 		= CONST_BASE_SISTEMA + "Icones/";
	static final String CONST_CONFIGS_URL 		= CONST_BASE_SISTEMA + "Configs/";
	static final String CONST_LINGUAS_URL 		= "Sistema/Linguages/Linguas";
	
	/**
	 * constantes de preferencia de inicialização
	 */
	static final int 	CONST_DEFAULT_ALTURA = 1024;
	static final int 	CONST_DEFAULT_LARGURA = 350;
	static final int 	 CONST_DEFAULT_ICONES 	= 0;
	static final int 	 CONST_DEFAULT_FONTE 	= 0;
	static final String CONST_DEFAULT_LINGUAGE	= "pt_BR";
	static final boolean CONST_DEFAULT_INICLOG = true;

}
