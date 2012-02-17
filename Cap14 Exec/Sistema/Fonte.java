/**
 * Classe responsável pela fonte do sistema inteiro
 * usado pelas JFrames e seus filhos
 * Possui a classe duas fontes
 * 		Ubuntu
 * 		Serif
 */
package Sistema;
import java.awt.Font;

public class Fonte 
{
	protected Font fontTitulo;
	protected Font fontTexto;
	protected Font fontTextoBold;
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
		fontTitulo = new Font("Ubuntu", Font.BOLD, 18);
		fontTexto = new Font("Ubuntu", Font.PLAIN, 14);
		fontTextoBold = new Font("Ubuntu", Font.BOLD, 14);
		Log.addLog("Tema da Fonte: Ubuntu.");
	}
	
	/**
	 * inicia o tema da fonte como
	 * serif
	 */
	public void setFontSerif()
	{
		fontTitulo = new Font("serif", Font.BOLD, 18);
		fontTexto = new Font("serif", Font.PLAIN, 14);
		fontTextoBold = new Font("serif", Font.BOLD, 14);
		Log.addLog("Tema da Fonte: Serif.");
	}
	
	/**
	 * retorna qual das duas fontes é
	 * 1 - para Ubuntu
	 * 2 - para serif
	 * @return
	 */
	public int getTemaFonte()
	{
		return temaDaFonte;
	}
	
	/**
	 * permite reiniciar a fonte
	 * do sistema
	 * @param fonte
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
		return fontTexto;
	}
	
	/**
	 * retorna fonte para o titulo em geral
	 * @return font
	 */
	public Font getFontTitulo()
	{
		return fontTitulo;
	}
	
	/**
	 * retorna a fonte para o texto, porém
	 * 	com um "resalto" possibilitado pelo bold
	 * @return
	 */
	public Font getFontTextoBold()
	{
		return fontTextoBold;
	}
	
	public String[] getComboFontes()
	{
		tempString = new String[2];
		tempString[0] = "Ubuntu";
		tempString[1] = "Serif";
		return tempString;
	}

}
