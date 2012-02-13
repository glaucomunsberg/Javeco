/**
 * Classe que controla os icones utilizados pelo sistema
 * possui dois tipos de Icones
 * 			Carisma
 * 			Metalico
 */
package Sistema;
import javax.swing.ImageIcon;
public class Icone
{
	public int temaDoIcone;
	public static String[] tempString;
	
	public ImageIcon goHome;
	public ImageIcon curso;
	public ImageIcon aluno;
	public ImageIcon configuracao;
	public ImageIcon erro;
	public ImageIcon ok;
	
	/**
	 * Inicia o sistema escolhendo o tema
	 * 1 - Carisma
	 * 2 - Metalico
	 */
	public Icone(int temaEscolhido)
	{
		temaDoIcone = temaEscolhido;
		if(temaEscolhido == 0)
		{
			setTemaCarisma();
		}
		if( temaEscolhido == 1)
		{
			setTemaMetalico();
		}
	}
	
	/**
	 * Possibilita mudar o tema para os que possui
	 * @param escolhido
	 */
	public void setTemaIcone(int escolhido)
	{
		temaDoIcone = escolhido;
		if(escolhido == 0)
		{
			setTemaCarisma();
		}
		if(escolhido == 1)
		{
			setTemaMetalico();
		}
	}
	
	/**
	 * retorna qual é o tema escolhido
	 * @return
	 */
	public int getTemaIcone()
	{
		return temaDoIcone;
	}
	
	public void setTemaCarisma()
	{
		goHome 			= new ImageIcon(Constantes.CONST_ICONS_URL+"T1Home.png");
		curso 			= new ImageIcon(Constantes.CONST_ICONS_URL+"T1Curso.png");
		aluno 			= new ImageIcon(Constantes.CONST_ICONS_URL+"T1Aluno.png");
		configuracao 	= new ImageIcon(Constantes.CONST_ICONS_URL+"T1Configuracao.png");
		erro 			= new ImageIcon(Constantes.CONST_ICONS_URL+"T1Erro.png");
		ok				= new ImageIcon(Constantes.CONST_ICONS_URL+"T1Ok.png");
		Logs.addLog("Tema dos Icones: Carisma.");
	}
	
	public static String[] getComboIcones()
	{
		tempString = new String[2];
		tempString[0] = "Carisma";
		tempString[1] = "Metálico";
		return tempString;
	}
	public void setTemaMetalico()
	{
		goHome 			= new ImageIcon(Constantes.CONST_ICONS_URL+"T1Home.png");
		curso 			= new ImageIcon(Constantes.CONST_ICONS_URL+"T1Curso.png");
		aluno 			= new ImageIcon(Constantes.CONST_ICONS_URL+"T1Aluno.png");
		configuracao 	= new ImageIcon(Constantes.CONST_ICONS_URL+"T1Configuracao.png");
		erro 			= new ImageIcon(Constantes.CONST_ICONS_URL+"T1Erro.png");
		ok				= new ImageIcon(Constantes.CONST_ICONS_URL+"T1Ok.png");
		Logs.addLog("Tema dos Icones: Metalico.");
	}

}
