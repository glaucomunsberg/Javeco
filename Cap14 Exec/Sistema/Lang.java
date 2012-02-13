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
	public static String[] tempString;
	public static int temaLinguagem;
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
	 * setará o sistema o local como en_US
	 * @return
	 */
	protected static Locale setLocale_en_US()
	{
		Logs.addLog("Tema do idioma: Inglês dos EUA.");
		return new Locale("en","US");
	}

	protected static Locale setLocale_pt_BR()
	{
		Logs.addLog("Tema do idioma: Português do Brasil.");
		return new Locale("pt","BR");
	}
	
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
	
	public static int getTemaLinguagem()
	{
		return temaLinguagem;
	}
	
	public static String[] getComboLinguagens()
	{
		tempString = new String[2];
		tempString[0] = "Português do Brasil (pt_BR)";
		tempString[1] = "Inglês dos EUAS (en_US)";
		return tempString;
	}
}
