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
	protected static Locale local;				//Contem a lingua como "pt_BR" ou "en_US"
	public static ResourceBundle palavras;	//Contém o local dos arquivos de linguagem
	public static String[] tempString;
	protected static int temaLinguagem;
	/**
	 * inicia o sistema com o idioma setada
	 * @param idioma{ "pt_BR" || "en_US" }
	 */
	public Lang(String idioma )
	{
		if(idioma == "pt_BR")
		{
			local = setLocale_pt_BR();
			temaLinguagem = 0;
		}
		if(idioma == "en_US")
		{
			local = setLocale_en_US();
			temaLinguagem = 1;
		}
		palavras = ResourceBundle.getBundle(Constantes.CONST_LINGUAS_URL, local);
	}
	
	/**
	 * inicia o sistema com o idioma setado
	 * 		1 - portugues
	 * 		2 - ingles
	 * @param idioma
	 */
	public Lang(int idioma )
	{
		temaLinguagem = idioma;
		if(idioma == 0 )
		{
			local = setLocale_pt_BR();
			temaLinguagem = 0;
		}
		if(idioma == 1 )
		{
			local = setLocale_en_US();
			temaLinguagem = 1;
		}
		palavras = ResourceBundle.getBundle(Constantes.CONST_LINGUAS_URL, local);
	}
	
	/**
	 * setará no sistema o local como en_US
	 * @return
	 */
	protected static Locale setLocale_en_US()
	{
		Log.addLog("Tema do idioma: Inglês dos EUA.");
		return new Locale("en","US");
	}
	/**
	 * setará no sistema o local como pt_BR
	 * @return
	 */
	protected static Locale setLocale_pt_BR()
	{
		Log.addLog("Tema do idioma: Português do Brasil.");
		return new Locale("pt","BR");
	}
	
	/**
	 * modifica o idioma do sistema
	 * @param lingua
	 */
	public void setNovoIdioma(int lingua)
	{
		temaLinguagem = lingua;
		if( lingua == 0)
		{
			local = setLocale_pt_BR();
		}
		if( lingua == 1)
		{
			local = setLocale_en_US();
		}
	}
	
	/**
	 * retorna o int que corresponde ao idioma do sistema
	 * @return int temaLinguagem do sistema
	 */
	public static int getTemaLinguagem()
	{
		return temaLinguagem;
	}
	
	/**
	 * combo com o
	 * @return
	 */
	public static String[] getComboLinguagens()
	{
		tempString = new String[2];
		tempString[0] = "Português do Brasil (pt_BR)";
		tempString[1] = "Inglês dos EUAS (en_US)";
		return tempString;
	}
}
