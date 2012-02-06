import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;
import java.awt.Container;

//Implementação do ActionListener extendida a JFrame
public class SistemaDoCurso extends JFrame
{

	protected static final long serialVersionUID = -4083184620633799749L;		//Identifador unico
	protected static String nomeDoPrograma = "Programa do Curso";
	protected static int alturaDaJanela = 1024;
	protected static int comprimentoDaJanela = 768;
	
	private BorderLayout layout;				//Organiza as informações no layout norte, sul...
	private static PainelCabecaD cabeca;
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
		frame.setSize(1204,872);
		
	}
	/**
	 * SistemDoCurso contém a estrutura do programa
	 * 	que será executada, nela é adicionado cada
	 * 	um dos modulos que vão constituir a janela
	 * @param nomeProPrograma
	 */
	public SistemaDoCurso(String nomeProPrograma)
	{
		super(nomeProPrograma);

		layout = new BorderLayout();							//seta borda
		container = getContentPane();						 //obter o contêiner				
		setLayout( layout );								//diz que o layout e bord
		cabeca = new PainelCabecaD("Cabeca");
		add( cabeca, BorderLayout.SOUTH );
	}
	
	public static void controleDeViews(int a)
	{
		
	}
}
class PainelCabecaD extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3937242914762404944L;
	private JTextField campoTexto1;
		
	public PainelCabecaD(String texto)
	{
		campoTexto1 = new JTextField( texto ); //10 colunas como campo
		campoTexto1.setVisible(true);
		campoTexto1.setSize(30, 30);
		campoTexto1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println(e);
                SistemaDoCurso.controleDeViews(1);
            }
		});
		add( campoTexto1 );
	}

}