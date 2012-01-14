/**
 * Como utilizar janelas e notificações com elas
 */
import javax.swing.JOptionPane;
public class janelaGUI 
{
	public static void main( String args[])
	{
		//Esperimentando as mensagens e seus icones
		JOptionPane.showInputDialog(null, "normal", "simples nem nada", JOptionPane.PLAIN_MESSAGE);
		JOptionPane.showMessageDialog(null, "Com ícone de erro", "Para erro", JOptionPane.ERROR_MESSAGE);
		JOptionPane.showMessageDialog(null, "Com ícone de informatico", "Informativo", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, "Notificação!", "Notifica", JOptionPane.WARNING_MESSAGE);
	}

}
