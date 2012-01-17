import java.awt.FlowLayout;				//Como é configurado o layout
import java.awt.event.ItemListener;		//Trata o evento
import java.awt.event.ItemEvent;		//O evento
import javax.swing.JFrame;				//Frame
import javax.swing.JLabel;				//Label para receber as imagens
import javax.swing.JComboBox;			//Combo
import javax.swing.Icon;				//Icones que recebem as imagens
import javax.swing.ImageIcon;			//ImageIcon 

/**
 * Classe de funcionamento da comboBox com
 * 	interacaçã por ação
 * @author glaucoroberto
 *
 */
public class ComboBoxFrame extends JFrame
{
	private JComboBox comboBox;		//Cria a comboBox
	private JLabel label;			//Cria uma label
	
	private String enderecos[] = { "Cap11/ok.gif", "Cap11/smile.jpg"}; 	//Array de String com nome das imagens que serão também caminho das imagens
	private Icon icons[] = { new ImageIcon ( enderecos[0]),
								new ImageIcon ( enderecos[1])			//Cria array de icons com as duas imagens através de ImageIcon
	};
	
	/**
	 * Main para testar a combo
	 * @param args
	 */
	public static void main( String args[] )
	{
		ComboBoxFrame comboBox = new ComboBoxFrame();
		comboBox.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		comboBox.setSize(300, 300);
		comboBox.setVisible( true );
	}
	
	public ComboBoxFrame()
	{
		super("testando a combo");					//Insere o título a JFrame
		setLayout( new FlowLayout() );				//Frame com setado com FlowLayout
		
		comboBox = new JComboBox( enderecos );		//Combo rece seus itens 
		comboBox.setMaximumRowCount(2);				//Indica quantas linhas haverá na lista
		comboBox.addItemListener(																										//|
																					//Classe interna e anonima do Handler				//|
				 new ItemListener()													//adiciona um escutador de evento 					//|
				 {																														//| seta o comportamento
					 public void itemStateChanged( ItemEvent event)					//IDentifica se houve mudança						//|   da combo.
					 {																													//|
						 if(event.getStateChange() == ItemEvent.SELECTED)			//Verifica o evento e selecionado 					//|
						 {																												//|
							 label.setIcon(icons[comboBox.getSelectedIndex()]);		//Da combo pega o item selecionado (sua posicao)	//|
						 }																												//|
					 }																													//|
				 }																														//|
				);																														//|
		add( comboBox);																//Adiciona a combo ao frame
		label = new JLabel( icons[0]);												//Na Label selecionado está o primeiro "0"
																					// pois na combo também estará
		add( label );																//Adiciona a label
	}
}
