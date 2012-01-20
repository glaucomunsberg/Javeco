import java.awt.BorderLayout;			//Faz com que seja organizado o layout por north...
import java.awt.Color;		
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Container;				//Container de onde o layout está

public class ColorShow extends JFrame
{
	private Font font;
	private JButton mudarCor;				//Botão para mudar cor
	private Color cor = Color.LIGHT_GRAY;	//Cor default e para trocar
	private JPanel painelCor;				//Painel que terá a cor modificada
	private JTextField textoDeAlerta;		//Alertará quando cancelar
	private Container container;			//Container para refresh
	
	/**
	 * Main da implementação do ColorShow
	 * @param args
	 */
	public static void main( String args[] )
	{
		ColorShow frame = new ColorShow();
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	/**
	 * Implementação do ColorShow()
	 * 
	 */
	public ColorShow()
	{
		super ( "Usando ColorChoose");
		painelCor = new JPanel();
		painelCor.setBackground(cor);
		
		//Pega o container atual
		container = getContentPane();
		
		font = new Font("Ubuntu", Font.BOLD, 14);
		
		//Será visivel quando cancela a troca de cor
		textoDeAlerta = new JTextField();
		textoDeAlerta.setText("Você a troca de cor!");
		textoDeAlerta.setVisible(false);
		textoDeAlerta.setEditable(false);
		textoDeAlerta.setFont(font);
		textoDeAlerta.setHorizontalAlignment( JTextField.CENTER);		//Alinha o texto do textField
		textoDeAlerta.setBorder(null);									//Passa nulo o que faz a borda ficar nula
		
		
		mudarCor = new JButton("Mudar cor");
		mudarCor.addActionListener(
				//Cria evento que modifica a cor quando o botão é
				//	precionado
				new ActionListener()
				{
					public void actionPerformed( ActionEvent event)
					{
						//Quando precionado o botão dispara um event, que chama o JColorChoose
						//	para trocar a cor. Este abrirá um diálogo onde será possível moficicar
						//	a cor, recebendo nele três parametros
						//					--> O frame pai da ação
						//					--> Titulo da janela que abrirá
						//					--> Color Objeto, que seta a cor inicial
						//	esse retornará a cor selecionada, caso tenha cancelado retornará
						//	null para a cor.
						cor = JColorChooser.showDialog( ColorShow.this , "Choose Color", cor);
						
						if( cor == null)
						{
							//Se o cara aperta cancela então fica visivel a mensagem
							//bem como seta a cor como branca para neutro
							textoDeAlerta.setVisible(true);
							textoDeAlerta.setBackground(Color.WHITE);
							container.validate();						//Refresh o container para tornar visivel o texto
							cor = Color.white;
						}
						else
						{
							textoDeAlerta.setVisible(false);
							container.validate();
						}
						
						painelCor.setBackground(cor);
						//textoDeAlerta.validate();
					}
				}
			);
		add( painelCor, BorderLayout.CENTER);		//Adiciona o painel no centro
		add( mudarCor, BorderLayout.SOUTH);			//Adiciona o botão na parte inferior
		add( textoDeAlerta, BorderLayout.NORTH);	//Adiciona o texto de alerta e o coloca na direita
		
		setSize(400,130);						//Já diz qual será o tamanho
		setVisible(true);						//E que estará visivel
	}
	

}
