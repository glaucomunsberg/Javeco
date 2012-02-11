package Sistema.Configs;

import java.io.Serializable;

public class Configs implements Serializable
{
	private static final long serialVersionUID = 813871806364002985L;
	protected int temaIcone;
	protected int temaFonte;
	protected int temaLang;
	
	public Configs(int icones, int fonte, int lang)
	{
		temaIcone = icones;
		temaFonte = fonte;
		temaLang  = lang;
	}
	
	public int getIconeSerializado()
	{
		return temaIcone;
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
		System.out.println("Finalizando configs temporário");
	}

}
