/**
 * Implementação do IconeJanela e TextoSenha
 */
import javax.swing.JFrame;
public class IconeJanelaTest 
{
	public static void main( String args[])
	{
		//testa IconeJanela
		IconeJanela labelFrame = new IconeJanela();
		labelFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		labelFrame.setSize(900, 900	);
		labelFrame.setVisible(true);
		
		//texta TextoSenha
		
		TextoSenha janela = new TextoSenha();
		janela.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		janela.setSize(311,140);
		janela.setVisible(true);
	}

}
