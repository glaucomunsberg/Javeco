/**
 * Implementação do BottonFrame nesse cria-se tres campos
 * 	sendo um de imagem outro de imagem e texto e outro de 
 * 	imagem e texto com texto justificado
 */
import java.awt.FlowLayout;					//layout flutuante
import java.awt.event.ActionListener;		//Trata evento de ações
import java.awt.event.ActionEvent;			//Event de ação
import javax.swing.JFrame;					//Frame
import javax.swing.JButton;					//Implementação de botão
import javax.swing.Icon;					//Icon, não é icone de click apenas
import javax.swing.ImageIcon;				//ImagemIcon insere imagem em um icon
import javax.swing.JOptionPane;				//Painel de mensagem ou diálogo

public class BottonFrame extends JFrame	
{
	private JButton plainJButton;					//Cria dois botões plain e fancy
	private JButton fancyJButton;
	
	public BottonFrame()
	{
		super( "Testando botão");					//Dá titulo ao frame
		setLayout( new FlowLayout() );				//deixa o campo flutuante
		
		plainJButton = new JButton( "Plain Botão");	//Cria botão e String como nome
		add( plainJButton );

		Icon bug1 = new ImageIcon( "Cap11/ok.gif" ); 			//Cria dois Icon com ImagemIcon que recebe duas imagens para os icones
		Icon bug2 = new ImageIcon( "Cap11/ok.gif" );
		fancyJButton = new JButton( "Fancy Botão", bug1); 		//O botão é criado com o texto e uma imagem
		fancyJButton.setRolloverIcon(bug2);						//Insere a magem 2 quando o botão está em foco
		add( fancyJButton );
		
		//Tratador de evento do botão
		BottonHandler handler = new BottonHandler();			
		fancyJButton.addActionListener( handler );
		plainJButton.addActionListener( handler );
		
	}
	
	/**
	 * Implementação do handler do botão
	 * qunado esse é precionado ele diz qu esse foi pressionado
	 * @author glaucoroberto
	 *
	 */
	private class BottonHandler implements ActionListener
	{
		
		public void actionPerformed( ActionEvent event )
		{
			JOptionPane.showMessageDialog(BottonFrame.this, String.format("Você apertou: %s", event.getActionCommand()));
		}
	}
}
