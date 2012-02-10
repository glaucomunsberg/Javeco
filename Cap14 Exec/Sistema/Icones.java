/**
 * Classe que controla os icones utilizados pelo sistema
 * possui dois tipos de Icones
 * 			Carisma
 * 			Metalico
 */
package Sistema;
import javax.swing.ImageIcon;
public class Icones 
{
	public int temaDoIcone;
	
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
	public Icones(int temaEscolhido)
	{
		temaDoIcone = temaEscolhido;
		if(temaEscolhido == 1)
		{
			setTemaCarisma();
		}
		if( temaEscolhido == 2)
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
		if(escolhido == 1)
		{
			setTemaCarisma();
		}
		if(escolhido == 2)
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
		goHome 			= new ImageIcon("Cap14 Exec/Sistema/icones/T1Home.png");
		curso 			= new ImageIcon("Cap14 Exec/Sistema/icones/T1Curso.png");
		aluno 			= new ImageIcon("Cap14 Exec/Sistema/icones/T1Aluno.png");
		configuracao 	= new ImageIcon("Cap14 Exec/Sistema/icones/T1Configuracao.png");
		erro 			= new ImageIcon("Cap14 Exec/Sistema/icones/T1Erro.png");
		ok				= new ImageIcon("Cap14 Exec/Sistema/icones/T1Ok.png");
		LogDoSistema.addLog("Tema dos Icones: Carisma.");
	}
	
	public void setTemaMetalico()
	{
		goHome 			= new ImageIcon("Cap14 Exec/Sistema/icones/T1Home.png");
		curso 			= new ImageIcon("Cap14 Exec/Sistema/icones/T1Curso.png");
		aluno 			= new ImageIcon("Cap14 Exec/Sistema/icones/T1Aluno.png");
		configuracao 	= new ImageIcon("Cap14 Exec/Sistema/icones/T1Configuracao.png");
		erro 			= new ImageIcon("Cap14 Exec/Sistema/icones/T1Erro.png");
		ok				= new ImageIcon("Cap14 Exec/Sistema/icones/T1Ok.png");
		LogDoSistema.addLog("Tema dos Icones: Metalico.");
	}

}
