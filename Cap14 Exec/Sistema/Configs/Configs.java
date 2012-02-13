package Sistema.Configs;

import java.io.Serializable;
/**
 * classe serializada e contem as informações do sistema
 * 	que será gravada pelo programa GerenciadorDoSistema
 * @author glaucoroberto
 *
 */
public class Configs implements Serializable
{
	private static final long serialVersionUID = 813871806364002985L;
	protected int temaIcone;
	protected int temaFonte;
	protected int temaLang;
	protected boolean logAtivo;
	
	public Configs(int icones, int fonte, int lang, boolean log)
	{
		temaIcone = icones;
		temaFonte = fonte;
		temaLang  = lang;
		logAtivo  = log; 
		
	}
	
	public int getIconeSerializado()
	{
		return temaIcone;
	}
	
	public boolean getLogAtivo()
	{
		return logAtivo;
	}
	
	public int getFonteSerializado()
	{
		return temaFonte;
	}
	
	public int getLangSerializado()
	{
		return temaLang;
	}
	public void finalize()
	{
		//System.out.println("Finalizando configs temporário");
	}

}
