/**
 *  Testa a implementação de uma CheckBoxFrame
 */
import javax.swing.JFrame;
public class CkeckBoxComAcao 
{
	public static void main( String args[])
	{
		
		CheckBoxFrame checkBox = new CheckBoxFrame();
		checkBox.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		checkBox.setSize(270, 100);
		checkBox.setVisible(true);
		
	}

}
