import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class BottonFrame extends JFrame
{
	private JButton plainJButton;
	private JButton fancyJButton;
	
	public BottonFrame()
	{
		super( "Testando botão");
		setLayout( new FlowLayout() );
		
		plainJButton = new JButton( "Plain Botão");
		add( plainJButton );
		
		Icon bug1 = new ImageIcon( "Cap11/ok.gif" );
		Icon bug2 = new ImageIcon( "Cap11/ok.gif" );
		fancyJButton = new JButton( "Fancy Botão", bug1);
		fancyJButton.setRolloverIcon(bug2);
		add( fancyJButton );
		
		BottonHandler handler = new BottonHandler();
		fancyJButton.addActionListener( handler );
		plainJButton.addActionListener( handler );
		
	}
	private class BottonHandler implements ActionListener
	{
		
		public void actionPerformed( ActionEvent event )
		{
			JOptionPane.showMessageDialog(BottonFrame.this, String.format("Você apertou: %s", event.getActionCommand()));
		}
	}
}
