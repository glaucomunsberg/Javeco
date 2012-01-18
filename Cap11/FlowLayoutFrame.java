import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;

public class FlowLayoutFrame  extends JFrame
{
	private JButton botaoEsquerda;	//botão que alinha a esquerda e etc
	private JButton botaoCentro;
	private JButton botaoDireita;
	private FlowLayout layout;		//Objoto de layout
	private Container container;	//Contêiner para configurar o layout
	
	/**
	 * main para executar a implementacao
	 * @param args
	 */
	public static void main( String args[] )
	{
		FlowLayoutFrame flow = new FlowLayoutFrame();
		flow.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		flow.setSize( 300, 75);
		flow.setVisible(true);
	}
	/**
	 * implementacao do FlowLayout que alinha
	 * 	segundo cada um dos três botões
	 * 	Direita, Centro e Esquerda
	 */
	public FlowLayoutFrame()
	{
		super("O \"FlowLayout\" funcionamento");
		
		layout = new FlowLayout();
		container = getContentPane(); //obter o contêiner
		setLayout( layout );
		botaoEsquerda = new JButton( "Left" );
		add( botaoEsquerda );
		
		botaoEsquerda.addActionListener(
				new ActionListener()
				{
					public void actionPerformed( ActionEvent event)
					{
						layout.setAlignment( FlowLayout.LEFT);
						layout.layoutContainer( container );
					}
				}
			);
		
		botaoCentro = new JButton( "Center" );
		add( botaoCentro );
		
		botaoCentro.addActionListener(
				new ActionListener()
				{
					public void actionPerformed( ActionEvent event)
					{
						layout.setAlignment( FlowLayout.CENTER );
						layout.layoutContainer( container );
					}
				}
			);
		botaoDireita = new JButton( "Right" );
		add( botaoDireita );
		botaoDireita.addActionListener( 
				new ActionListener()
				{
					public void actionPerformed( ActionEvent event)
					{
						layout.setAlignment( FlowLayout.RIGHT);
						layout.layoutContainer( container );
					}
				}
				
			);
		
	}
}
