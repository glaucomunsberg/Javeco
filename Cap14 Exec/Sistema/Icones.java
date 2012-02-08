package Sistema;
import javax.swing.ImageIcon;
public class Icones 
{
	public int Tema;
	
	public ImageIcon goHome;
	public ImageIcon curso;
	public ImageIcon aluno;
	public ImageIcon configuracao;
	public ImageIcon erro;
	public ImageIcon ok;
	
	public Icones(int temaEscolhido)
	{
		if(temaEscolhido == 1)
		{
			goHome 			= new ImageIcon("Cap14 Exec/Sistema/icones/T1Home.png");
			curso 			= new ImageIcon("Cap14 Exec/Sistema/icones/T1Curso.png");
			aluno 			= new ImageIcon("Cap14 Exec/Sistema/icones/T1Aluno.png");
			configuracao 	= new ImageIcon("Cap14 Exec/Sistema/icones/T1Configuracao.png");
			erro 			= new ImageIcon("Cap14 Exec/Sistema/icones/T1Erro.png");
			ok				= new ImageIcon("Cap14 Exec/Sistema/icones/T1Ok.png");
		}
		else
		{
			
		}
	}

}
