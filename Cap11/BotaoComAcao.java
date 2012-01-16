/** Classe de execuçã do bottonFrame
 */
import javax.swing.JFrame;
public class BotaoComAcao 
{
	public static void main( String args[])
	{
		BottonFrame botao = new BottonFrame(); 						//Cria o objeto bottonFrame
		botao.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		botao.setSize(300, 110);									//Configura o tamanho do layout
		botao.setVisible(true);
	}

}
