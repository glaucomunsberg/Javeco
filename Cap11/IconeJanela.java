/**
 * IconeJanela implenta a criação de icones, ou seja, imagens e texto em forma
 * 	de icones em frame. A classe desmonstra também como inserir descrição.
 */


import java.awt.FlowLayout; 		//especifica como os componentes são organizados, inserido um do lado do outro
									//conforme são adicionados ao frame
import javax.swing.JFrame; 			//fornece recurso basicos da janela
import javax.swing.JLabel; 			//exibe textos e imagens anexados a ela
import javax.swing.SwingConstants;	// Constantes usados peloa Swing
import javax.swing.Icon;			// interfaces utilizas para manipular imagens
import javax.swing.ImageIcon;		//Carrega imagens


public class IconeJanela extends JFrame 
{
	private JLabel label1; //Cria label1,2 e 3 que são campos do Frame
	private JLabel label2;
	private JLabel label3;
	
	public IconeJanela()
	{

		super("Testando o JLabel");								//Por ser uma extends, chama a super e passa o título
		setLayout( new FlowLayout() );
		
		label1 = new JLabel( "Label com apenas texto"); 		//Cria uma label apenas com texto
		label1.setToolTipText("label1 sua descrição");			//Insere a descrição da label
		add( label1 );
		
		Icon imagem =  new ImageIcon( getClass().getResource("smile.jpg") );									//Cria um icone do tipo ImageIcon o "getClass.getResource("imagem") retorna a localização da imagem tipo URL
		label2 = new JLabel( "Label com texto e imagem lado a lado na direita",imagem, SwingConstants.RIGHT); 	//adiciona a imagem e o texto alinhando a direita
		label2.setToolTipText("label 2");							//texto de descrição
		add( label2 );
		
		label3 = new JLabel();
		label3.setText("Texto aqui");								//adiciona o texto ao rotulo
		label3.setIcon(imagem);										//adiciona a imagem ao rotulo
		label3.setHorizontalTextPosition( SwingConstants.CENTER);	//manipula o texto centralizando no horizonte
		label3.setVerticalTextPosition( SwingConstants.BOTTOM);		//manipula o texto colocando na parte de baixo do rotulo
		label3.setFont(getFont());
		label3.setToolTipText("descricao");							//Modo de inserir uma descrição ao Label
		add( label3 );
	}

}
