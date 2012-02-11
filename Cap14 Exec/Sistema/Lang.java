/**
 * Capacidade de internacionalizar o sistema.
 * 	Possue todas as "langs" para o sistema
 */
/**
 * Lang possui a capacidada de internacionalizar o sistema
 * 		baseado no ResourceBundle do próprio java precisa unicamente
 * 		que seja adicionado o local do arquivo e a linguagem para o
 * 		sistema
 */

package Sistema;
import java.util.Locale;
import java.util.ResourceBundle;

public  class Lang 
{
	public static Locale local;				//Contem a lingua como "pt_BR" ou "en_US"
	public static ResourceBundle palavras;	//Contém o local dos arquivos de linguagem
	
	/**
	 * inicia o sistema com o idioma setada
	 * @param idioma{ "pt_BR" || "en_US" } 
	 */
	public Lang(String idioma )
	{
		if(idioma == "en_US")
		{
			local = setLocale_en_US();
		}
		if(idioma == "pt_BR")
		{
			local = setLocale_pt_BR();
		}
		palavras = ResourceBundle.getBundle("Sistema.Configs.Linguas", local);
	}
	
	/**
	 * setará o sistema o local como en_US
	 * @return
	 */
	protected static Locale setLocale_en_US()
	{
		return new Locale("en","US");
	}

	protected static Locale setLocale_pt_BR()
	{
		return new Locale("pt","BR");
	}

}
