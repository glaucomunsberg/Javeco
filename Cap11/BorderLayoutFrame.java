/**
 * Implementa o layout border
 * 	esse diferente do Flow que vai adicionando
 * 	segundo foi adicionado, no Border o container
 * 	é dividido em cinco regios:
 * 	North
 * 	South
 * 	East
 * 	West
 * 	Center
 * 	-> North e South ocupam a parte superior e inferior e as laterais
 * 	-> East e West expande-se verticalmente entre as regios norte e sul
 * 		preenchendo todo o espaço restante
 * 	-> Center ocupa todo o espaço restante. Caso ele seja inserido sozinho
 * 		ocupa todo o espaço 
 * @author glaucoroberto
 *
 */
	import java.awt.BorderLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import javax.swing.JFrame;
	import javax.swing.JButton;
//Implementação do ActionListener extendida a JFrame
public class BorderLayoutFrame extends JFrame implements ActionListener
{
	private JButton botoes[];		//Array de botoes
	private final String names[] = {"Esconder North", "Esconder South", "Esconder Leste", "Esconder Oeste", "Esconder Centro"}; //Nome dos botões
	private BorderLayout layout;	//border object
	
	/**
	 * main da implementação do BorderLayout
	 * @param args
	 */
	public static void main( String args[])
	{
		BorderLayoutFrame frame = new BorderLayoutFrame();
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(1204,872);
		
	}
	
	public BorderLayoutFrame()
	{
		super( "BorderLayout teste");
		layout = new BorderLayout(0,0);						//seta borda
		setLayout( layout );								//diz que o layout e bord
		botoes = new JButton[names.length];					//inicia os botes com o tamnho
		
		for( int count = 0; count < names.length; count++)
		{
			botoes[ count ] = new JButton( names[count]);		//aloca e nameia
			botoes[ count ].addActionListener(this);			//Adiciona o listener
		}
		
		//Adiciona os botoes e sua posicao
		add( botoes[0], BorderLayout.NORTH);
		add( botoes[1], BorderLayout.SOUTH);
		add( botoes[2], BorderLayout.EAST);
		add( botoes[3], BorderLayout.WEST);
		add( botoes[4], BorderLayout.CENTER);
	}
	public void actionPerformed( ActionEvent event )
	{
		//varre todos os botoes e verifica se este
		//	foi a origem do evento, se for esconde-o
		for( JButton button: botoes)
		{
			if( event.getSource() == button)
			{
				button.setVisible(false);
			}
			else
			{
				button.setVisible(true);
			}
			layout.layoutContainer( getContentPane() ); //painel de conteúdo de Layout
		}
	}
}
