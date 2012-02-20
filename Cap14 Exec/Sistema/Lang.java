/*
 * ATENÇÂO! Para que a Lang funcione ela deve
 * 		conter também os arquivos de linguaguem
 * 		que estão disponíveis no diretório:
 * 		/Sistema/Linguages/
 */

/**
 * Lang possui a capacidada de internacionalizar o sistema
 * 		baseado no ResourceBundle do próprio java precisa unicamente
 * 		que seja adicionado o local do arquivo e a linguagem para o
 * 		sistema
 * 
 * @author glaucoroberto@gmail.com
 * @project SSH: git@github.com:glaucomunsberg/Javeco.git
 */

package Sistema;
import java.util.Locale;
import java.util.ResourceBundle;
public  class Lang 
{
	protected static Locale local;				//Contém a lingua como "pt_BR" ou "en_US"
	public static ResourceBundle palavras;		//Contém o local dos arquivos de linguagem
	public static String[] tempString;
	protected static int temaLinguagem;
	
	/**
	 * Inicia o sistema com o idioma setada
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
		palavras = ResourceBundle.getBundle( Constantes.CONST_LINGUAS_URL, local);
	}
	
	/**
	 * Inicia o sistema com o idioma setado
	 * 		0 - portugues
	 * 		1 - ingles
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
	 * Setará no sistema o local como en_US
	 * @return Locate("en", "US")
	 */
	protected static Locale setLocale_en_US()
	{
		Log.addLog("Tema do idioma: Inglês dos EUA.");
		return new Locale("en","US");
	}
	
	/**
	 * Setará no sistema o local como pt_BR
	 * @return Locate("pt","BR")
	 */
	protected static Locale setLocale_pt_BR()
	{
		Log.addLog("Tema do idioma: Português do Brasil.");
		return new Locale("pt","BR");
	}
	
	/**
	 * Modifica o idioma do sistema
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
	 * Retorna o int que corresponde ao idioma do sistema
	 * @return int temaLinguagem
	 */
	public static int getTemaLinguagem()
	{
		return temaLinguagem;
	}
	
	/**
	 * combo com o
	 * @return String[] { "Portugues","Ingles" }
	 */
	public static String[] getComboLinguagens()
	{
		tempString = new String[2];
		tempString[0] = "Português do Brasil (pt_BR)";
		tempString[1] = "Inglês dos EUAS (en_US)";
		return tempString;
	}
}
