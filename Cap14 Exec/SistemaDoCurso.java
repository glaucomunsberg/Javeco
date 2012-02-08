/**
 * SistemaDoCuso executará todos os seus modulos
 * 	bem como os subsistemas de log e configuracaoes
 */
import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Container;
import Sistema.Paineis;

//Implementação do ActionListener extendida a JFrame
public class SistemaDoCurso extends JFrame
{

	protected static final long serialVersionUID = -4083184620633799749L;		//Identifador unico
	protected static String nomeDoPrograma = "Programa do Curso";
	protected static int alturaDaJanela = 1024;
	protected static int comprimentoDaJanela = 768;
	private BorderLayout layout;												//Organiza as informações no layout norte, sul...
	private static Paineis paineis;
	private Container container;
	
	
	/**
	 * Executará o programa, recebe parametros
	 * caso não se queira as configurações default
	 * 
	 * @param args[0] String nomeDoPrograma
	 * @param args[1] String alturaDaJanela
	 * @param args[2] String comprimeitoDaJanela
	 */
	public static void main( String args[])
	{
		if( args.length >= 3)
		{
			
			nomeDoPrograma 		= args[0];
			alturaDaJanela 		= Integer.parseInt(args[1]);
			comprimentoDaJanela = Integer.parseInt(args[2]);

		}
		SistemaDoCurso frame = new SistemaDoCurso(nomeDoPrograma);
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		//frame.pack();
		frame.setSize(1000,700);
		
	}
	
	/**
	 * SistemDoCurso contém a estrutura do programa
	 * 	que será executada, nela é adicionado cada
	 * 	um dos modulos que foram construidos como
	 * 	paineis
	 * @param nomeProPrograma
	 */
	public SistemaDoCurso(String nomeProPrograma)
	{
		super(nomeProPrograma);

		layout = new BorderLayout();						//seta borda
		layout = new BorderLayout(0,0);
		container = getContentPane();						 //obter o contêiner	
		//container.setBackground( Color.WHITE);				//Fundo branco para o sistema
		setLayout( layout );								//diz que o layout e bord
		paineis = new Paineis(1);
		add( paineis.painelCabeca("Cabeca"), BorderLayout.NORTH );
		add( paineis.painelHome(),BorderLayout.CENTER);
		//add( paineis.painelNotification(), BorderLayout.CENTER);
		
	}
	
}