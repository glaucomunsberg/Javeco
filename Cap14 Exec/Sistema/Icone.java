/*
 * ATENÇÂO! Para que Icones funcione ela deve
 * 		conter também os arquivos png de icones
 * 		que estão disponíveis no diretório:
 * 		/Sistema/Icones/
 */

/**
 * Icones que controla os icones utilizados pelo sistema
 * possui dois tipos de Icones:
 * 			Carisma
 * 			Metalico
 * 
 * @author glaucoroberto@gmail.com
 * @project SSH: git@github.com:glaucomunsberg/Javeco.git
 */

package Sistema;
import javax.swing.ImageIcon;
public class Icone
{
	protected int temaDoIcone;
	protected static String[] tempString;
	
	public ImageIcon goHome;
	public ImageIcon curso;
	public ImageIcon aluno;
	public ImageIcon configuracao;
	public ImageIcon erro;
	public ImageIcon editando;
	public ImageIcon salvado;
	public ImageIcon adicionar;
	public ImageIcon excluir;
	
	/**
	 * Inicia o sistema escolhendo o tema
	 * 1 - Carisma
	 * 2 - Metalico
	 */
	public Icone(int temaEscolhido)
	{
		editando 	= new ImageIcon();
		salvado		= new ImageIcon();
		adicionar	= new ImageIcon();
		excluir		= new ImageIcon();
		erro		= new ImageIcon();
		goHome 		= new ImageIcon();
		curso 		= new ImageIcon();
		aluno 		= new ImageIcon();
		configuracao = new ImageIcon();
		
		
		
		temaDoIcone = temaEscolhido;
		if(temaEscolhido == 0)
		{
			setTemaCarisma();
		}
		if( temaEscolhido == 1)
		{
			setTemaNuoveXT();
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
			setTemaNuoveXT();
		}
	}
	
	/**
	 * retorna qual é o tema escolhido
	 * @return temaDoIcone
	 */
	public int getTemaIcone()
	{
		return temaDoIcone;
	}
	
	/**
	 * seta os icones como Carisma
	 */
	public void setTemaCarisma()
	{
		try
		{
			
			goHome 			= new ImageIcon( getClass().getResource(Constantes.CONST_ICONS_URL + "T1Home.png") );
			curso 			= new ImageIcon( getClass().getResource(Constantes.CONST_ICONS_URL + "T1Curso.png") );
			aluno 			= new ImageIcon( getClass().getResource(Constantes.CONST_ICONS_URL + "T1Aluno.png") );
			configuracao 	= new ImageIcon( getClass().getResource(Constantes.CONST_ICONS_URL + "T1Configuracao.png") );
			erro 			= new ImageIcon( getClass().getResource(Constantes.CONST_ICONS_URL + "T1Erro.png") );
			editando		= new ImageIcon( getClass().getResource(Constantes.CONST_ICONS_URL + "T1Editar.png") );
			salvado			= new ImageIcon( getClass().getResource(Constantes.CONST_ICONS_URL + "T1Salvar.png") );
			adicionar		= new ImageIcon( getClass().getResource(Constantes.CONST_ICONS_URL + "T1Adicionar.png") );
			excluir			= new ImageIcon( getClass().getResource(Constantes.CONST_ICONS_URL + "T1Excluir.png") );
		
		}
		finally
		{
			Log.addLog("Tema dos Icones: Carisma.");
		}
		
	}
	
	/**
	 * seta os icones como Metálico
	 */
	public void setTemaNuoveXT()
	{
		
		try
		{
		
			goHome 			= new ImageIcon( getClass().getResource(Constantes.CONST_ICONS_URL + "T2Home.png") );
			curso 			= new ImageIcon( getClass().getResource(Constantes.CONST_ICONS_URL + "T2Curso.png") );
			aluno 			= new ImageIcon( getClass().getResource(Constantes.CONST_ICONS_URL + "T2Aluno.png") );
			configuracao 	= new ImageIcon( getClass().getResource(Constantes.CONST_ICONS_URL + "T2Configuracao.png") );
			erro 			= new ImageIcon( getClass().getResource(Constantes.CONST_ICONS_URL + "T2Erro.png") );
			editando		= new ImageIcon( getClass().getResource(Constantes.CONST_ICONS_URL + "T2Editar.png") );
			salvado			= new ImageIcon( getClass().getResource(Constantes.CONST_ICONS_URL + "T2Salvar.png") );
			adicionar		= new ImageIcon( getClass().getResource(Constantes.CONST_ICONS_URL + "T2Adicionar.png") );
			excluir			= new ImageIcon( getClass().getResource(Constantes.CONST_ICONS_URL + "T2Excluir.png") );
		
		}
		finally
		{
			Log.addLog("Tema dos Icones: NuoveXT.");
		}
		
	}
	
	/**
	 * retorna para a combo uma lista com
	 * 	os nomes dos temas de icones disponíveis
	 * @return String[]{ "Carisma", "Metálico"}
	 */
	public static String[] getComboIcones()
	{
		tempString = new String[2];
		tempString[0] = "Carisma";
		tempString[1] = "NuoveXT";
		return tempString;
	}

}
