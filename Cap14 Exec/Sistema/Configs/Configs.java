/**
 * Configs serializada e contém as informações do sistema
 * 		que será gravada pelo programa GerenciadorDoSistema.
 * 		Ele serve como apoio pq serializar apenas ints torna
 * 			o processo mais rápido na leitura e na escrita.
 * 
 * @author glaucoroberto@gmail.com
 * @project SSH: git@github.com:glaucomunsberg/Javeco.git
 */
package Sistema.Configs;
import java.io.Serializable;
public class Configs implements Serializable
{
	private static final long serialVersionUID = 813871806364002985L;
	protected int temaIcone;
	protected int temaFonte;
	protected int temaLang;
	protected boolean logAtivo;
	
	/**
	 * Construtor que seta os valores para serem serializados
	 * @param icones
	 * @param fonte
	 * @param lang
	 * @param log
	 */
	public Configs(int icones, int fonte, int lang, boolean log)
	{
		temaIcone = icones;
		temaFonte = fonte;
		temaLang  = lang;
		logAtivo  = log; 
		
	}
	
	/**
	 * Retorna o temaIcoaSerializado
	 * @return temaIcone
	 */
	public int getIconeSerializado()
	{
		return temaIcone;
	}

	/**
	 * Retorna se o Log está ativo no
	 * 	serializado
	 * @return logAtivo
	 */
	public boolean getLogAtivo()
	{
		return logAtivo;
	}
	
	/**
	 * Retorna qual fonte foi serializada
	 * @return temaFonte
	 */
	public int getFonteSerializado()
	{
		return temaFonte;
	}
	
	/**
	 * Retorna qual é a linguagem
	 * 	serializada pelo sistema
	 * @return
	 */
	public int getLangSerializado()
	{
		return temaLang;
	}
	
	/**
	 * coletor de lixou ou finalizador
	 * 	da classe
	 */
	public void finalize()
	{
		//Finalizando configs temporário
	}

}
