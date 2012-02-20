/*
 * ATENÇÃO! Tenha muito cuidado, pois a troca das constantes
 * 		pode causar instabilidade ou até mesmo a não
 * 		execução do sistema javeco - O Programa!
 */

/**
 * Constantes contem a base do sistema em relação ao seus
 * 		diretórios. Também contém configurações de preferência
 * 		de inicialização do sistema.
 * 
 * @author glaucoroberto@gmail.com
 * @project SSH: git@github.com:glaucomunsberg/Javeco.git
 */
package Sistema;
public class Constantes
{
	
	/**
	 * constantes de diretórios do sistema
	 */
	static final String CONST_BASE 				= System.getProperty("user.dir") + "/Cap14 Exec/";
	static final String CONST_LOG_URL 			= CONST_BASE + "Logs/";
	static final String CONST_SISTEMA			= "Sistema/";
	static final String CONST_LINGUAS_URL 		= CONST_SISTEMA + "Linguages/Linguas";
	static final String CONST_BASE_SISTEMA 		= CONST_BASE + CONST_SISTEMA;
	static final String CONST_CONFIGS_URL 		= CONST_BASE_SISTEMA + "Configs/";
	static final String CONST_CONFIG 			= "Configs/";
	static final String CONST_ICONS_URL 		= "Icones/";
		
	/**
	 * constantes de preferencia de inicialização
	 */
	static public int 	CONST_DEFAULT_LARGURA_DO_PROGRAMA = 1020;
	static final int 	CONST_DEFAULT_LARGURA_MINIMA	  = 350;
	static public int 	CONST_DEFAULT_ALTURA_DO_PROGRAMA  = 740;
	static final int 	CONST_DEFAULT_ICONES 	= 0;
	static final int 	CONST_DEFAULT_FONTE 	= 0;
	static final String CONST_DEFAULT_LINGUAGE	= "pt_BR";
	static final boolean CONST_DEFAULT_INICLOG 	= true;

}
