/**
 * SistemaDoCuso executará todos os seus modulos
 * 	bem como os subsistemas de log e configuracaoes
 */
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import Sistema.Paineis;

//Implementação do ActionListener extendida a JFrame
public class SistemaDoCurso extends JFrame
{

	protected static final long serialVersionUID = -4083184620633799749L;		//Identifador unico
	protected static String nomeDoPrograma = "Programa do Curso";
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

		}
		SistemaDoCurso frame = new SistemaDoCurso(nomeDoPrograma);
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		//frame.setResizable(false);
		frame.setSize(1024,726);
		
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

		Container c = this.getContentPane();  					//Pega o container deste Frame
	    Paineis paineis = new Paineis();						//Inicia todos os paineis
        GridBagConstraints cons = new GridBagConstraints();  	//O esquema será de gride sendo o primeiro a cabeça e todos os demais abaixo
        GridBagLayout layout = new GridBagLayout();				//Layout em forma de Gride de uma coluna
        c.setLayout(layout);
        cons.fill = GridBagConstraints.BOTH;
        cons.gridy = 1;
        cons.weightx = 1;
        c.add(paineis.painelCabeca("0"), cons);
        cons.gridy = 2;
        cons.weighty = 0.8;
        c.add(paineis.painelHome(), cons);
        cons.gridy = 3;
        c.add(paineis.painelConfiguracao(), cons);
        cons.gridy = 4;
        c.add(paineis.painelCurso(),cons);
        cons.gridy = 5;
        c.add(paineis.painelAluno(), cons);
        Dimension arg0 = new Dimension(1024, 700);
		c.setMinimumSize(arg0);
		this.setMinimumSize(arg0);
        
	}
	
}