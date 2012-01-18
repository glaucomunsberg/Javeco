import java.awt.GridLayout;		//implementa a Grid
import java.awt.Container;		//Implementa a container
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;

public class GridLayoutFrame extends JFrame implements ActionListener
{
	private JButton botoes[];
	private final String nomes[] = { "Um", "Dois", "Três", "Quatro", "Cinco", "Seis"};
	private boolean toggle = true;							//Controla qual será o Grid
	private Container container;
	private GridLayout gridLayout1;							//A Grid1
	private GridLayout gridLayout2;							//A Grid2
	
	public static void main( String args[])
	{
		GridLayoutFrame grid = new GridLayoutFrame();
		grid.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		grid.setVisible(true);
		grid.setSize(300,300);
	}
	public GridLayoutFrame()
	{
		super( "Grid layout");
		gridLayout1 = new GridLayout( 2,3,5,5); 			// 2 x 3 com 5 de espaçamento
		gridLayout2 = new GridLayout( 3,2);					// 3 x 2 com 1 de espaçamento
		container = getContentPane();						// Pega o conteiner
		setLayout( gridLayout1 );							// Adiciona a primeira grid
		botoes = new JButton[ nomes.length ];
		
		//Inicia os botoes, adiciona a action e add a JFrame
		for( int count = 0; count < nomes.length; count++)
		{
			botoes[ count ] = new JButton( nomes[count] );
			botoes[ count ].addActionListener( this );
			add( botoes[ count ]);
		}
	}
	//Implementa o action. Se houver qualquer evento
	// então troca-se o grid do container
	public void actionPerformed( ActionEvent event)
	{
		if(toggle)
		{
			container.setLayout(gridLayout2);
		}
		else
		{
			container.setLayout(gridLayout1);
		}
		toggle = !toggle;
		container.validate();	//valida e refresh o container
	}
}
