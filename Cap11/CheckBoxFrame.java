/**
 * Implementação de CheckBox. CheckBox que modifica as propriedades
 * 	de um texto.
 */

import java.awt.FlowLayout;				//Coloca cada label de forma em que é inserida
import java.awt.Font;					//Classe de fonte, que manipula e troca a fonte de um textField
import java.awt.event.ItemEvent;		//Evento de um Item
import java.awt.event.ItemListener;		//Trata um evento
import javax.swing.JFrame;				//Frame
import javax.swing.JTextField;			//Campo de texto
import javax.swing.JCheckBox;			//CheckBox

public class CheckBoxFrame  extends JFrame
{
	private JTextField textField; 				//exibe o texto
	private JCheckBox boldJCheckBox; 			//para selecionar/deselecionar o negrito
	private JCheckBox italicJCheckBox; 			//para selecionar/deselecionar o italico
	
	public CheckBoxFrame()
	{
		super( "JCheckBox Test");				//Chama super e atribui titulo ao frame
		
		setLayout( new FlowLayout() );			//Seta que o Frama vai apenas inserir e não justifica nem nada a posicao
		
		textField = new JTextField(" Modifique o estilo da fonte");
		textField.setFont( new Font( "Ubuntu", Font.PLAIN, 14));
		add( textField );
		
		boldJCheckBox = new JCheckBox("Bold");    		//cria a caixa do bold
		italicJCheckBox = new JCheckBox("Italic");		//cria a caixa do italico
		add( boldJCheckBox );
		add( italicJCheckBox );
		
		//Handler para o tratamento do evento
		CheckBoxHandler handler = new CheckBoxHandler();
		boldJCheckBox.addItemListener( handler );
		italicJCheckBox.addItemListener( handler );
	}
	
	/**
	 * Implementação do ItemListener do checkBoxGHandler
	 * 	nesse modifica o texto quando há uma ação no
	 * 	checkbox
	 * @author glaucoroberto
	 *
	 */
	private class CheckBoxHandler implements ItemListener
	{
		private int valBold = Font.PLAIN; 				//controla o estilo da fonte negrito
		private int valItalic = Font.PLAIN;				//controla o estilo da fonte italico
		
		//responde as eventos da caixa de selecao
		public void itemStateChanged( ItemEvent event )
		{
			//processa os eventos do negrito
			if( event.getSource() == boldJCheckBox )
			{
				//Se o boldJCheckBox for selecionado (verifica através do isSelected() ) então atribui font.Italic
				valBold = boldJCheckBox.isSelected() ? Font.BOLD : Font.PLAIN;
			}
			
			//processa os eventos do italico
			if( event.getSource() == italicJCheckBox )
			{
				//se o italicJCjeckBox for selecionado ( através do isSelected() ) então atribui font.Italic ou Font.Plain (default)
				valItalic = italicJCheckBox.isSelected() ? Font.ITALIC : Font.PLAIN;
			}
			
			// Modifica a font do texto textField
			textField.setFont( new Font("Serif", valBold + valItalic, 14));
			
		}
	}
	
}
