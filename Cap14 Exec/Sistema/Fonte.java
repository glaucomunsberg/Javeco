/**
 * Fonte responsável pela fonte do sistema inteiro,
 * 		usado pelas nos JFrames. Possui a classe duas
 * 		fontes:
 * 			Ubuntu
 * 			Serif
 * 
 * @author glaucoroberto@gmail.com
 * @project SSH: git@github.com:glaucomunsberg/Javeco.git
 * 
 */

package Sistema;
import java.awt.Font;
public class Fonte 
{
	protected Font fonteTitulo;
	protected Font fonteTexto;
	protected Font fonteTextoBold;
	protected int temaDaFonte;
	protected String[] tempString;
	
	/**
	 * inicia a font do sistema
	 * fontEscolhida = 1 Ubuntu
	 * fontEscolhida = 2 Serif
	 * @param fonteEscolhida
	 */
	public Fonte(int fonteEscolhida)
	{
		temaDaFonte = fonteEscolhida;
		
		if(fonteEscolhida == 0)
		{
			setFontUbuntu();
		}
		if(fonteEscolhida == 1)
		{
			setFontSerif();
		}
	}
	
	/**
	 * inicia o tema da fonte como
	 *  Ubuntu
	 */
	public void setFontUbuntu()
	{
		fonteTitulo = new Font("Ubuntu", Font.BOLD, 18);
		fonteTexto = new Font("Ubuntu", Font.PLAIN, 14);
		fonteTextoBold = new Font("Ubuntu", Font.BOLD, 14);
		Log.addLog("Tema da Fonte: Ubuntu.");
	}
	
	/**
	 * inicia o tema da fonte como
	 * serif
	 */
	public void setFontSerif()
	{
		fonteTitulo = new Font("serif", Font.BOLD, 18);
		fonteTexto = new Font("serif", Font.PLAIN, 14);
		fonteTextoBold = new Font("serif", Font.BOLD, 14);
		Log.addLog("Tema da Fonte: Serif.");
	}
	
	/**
	 * retorna qual das duas fontes é
	 * 1 - para Ubuntu
	 * 2 - para serif
	 * @return int TemaDaFonte
	 */
	public int getTemaFonte()
	{
		return temaDaFonte;
	}
	
	/**
	 * permite reiniciar a fonte
	 * do sistema
	 * @param int {0 - Ubuntu || 1 - Serif }
	 */
	public void setTemaFonte(int fonte)
	{
		temaDaFonte = fonte;
		if(fonte == 0)
		{
			setFontUbuntu();
		}
		if( fonte == 1)
		{
			setFontSerif();
		}
	}
	
	/**
	 * retorna fonte para texto em geral
	 * @return font
	 */
	public Font getFontTexto()
	{
		return fonteTexto;
	}
	
	/**
	 * retorna fonte para o titulo em geral
	 * @return font
	 */
	public Font getFontTitulo()
	{
		return fonteTitulo;
	}
	
	/**
	 * retorna a fonte para o texto, porém
	 * 	com um "resalto" possibilitado pelo bold
	 * @return font
	 */
	public Font getFontTextoBold()
	{
		return fonteTextoBold;
	}
	
	/**
	 * Retorna para a combo os valores de fontes que
	 *  estao disponíveis para serem usados no sistema
	 *  @return String{ "Ubuntu","Serif" }
	 */
	public String[] getComboFontes()
	{
		tempString = new String[2];
		tempString[0] = "Ubuntu";
		tempString[1] = "Serif";
		return tempString;
	}

}
