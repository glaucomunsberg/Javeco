import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JTextArea;
/**
 *  KeyDemoFrame trata os eventos com o teclado
 *  	quando uma tecla é precionada ele dispara
 *  	trazendo informações sobre a tecla sendo 
 *  	ela uma função ou não
 * @author glaucoroberto
 *
 */
//A KeyDemoFrame é extensão de JFrame e implements da KeyListener
public class KeyDemoFrame extends JFrame implements KeyListener
{
	private JTextArea textoArea;	//área do texto
	private String line1 = "";		//primeira lina do texto...
	private String line2 = "";
	private String line3 = "";
	
	/**
	 * main do KeyDemoFrame
	 * @param args
	 */
	public static void main( String args[] )
	{
		KeyDemoFrame keyFrame = new KeyDemoFrame();
		keyFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		keyFrame.setSize(300, 300);
		keyFrame.setVisible(true);
	}
	
	
	/**
	 * implementação do KeyDemoFrame
	 */
	public KeyDemoFrame()
	{
		super("testando o teclado");
		textoArea = new JTextArea( 10, 15);				//configura o tamanho do JTextArea
		textoArea.setText("Pressione qualquer tecla");	//Testo default
		textoArea.setEnabled(false);
		textoArea.setDisabledTextColor(Color.black);
		add( textoArea );
		
		addKeyListener( this );							//permite que trate o seu evento
														//pois herda do implements
	}
	
	//Define os comportamentos
	@Override
	public void keyPressed(KeyEvent event) 
	{
		line1 = String.format("Tecla precionada: %s", KeyEvent.getKeyText( event.getKeyCode()));	//Quando é pressionado pega o código da tecla e passa
																									// para o getKeyText que retorna o texto correspondente
		setLines2and3(event);		//Manda tratar o resto
	}

	@Override
	public void keyReleased(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	private void setLines2and3( KeyEvent event)
	{
		line2 = String.format("This key is %san action key", event.isActionKey()? "" : "not ");	//verifica se é uma tecla de função como Delete, page Down...
		String temp = event.getKeyModifiersText( event.getModifiers());							//Vê se é um shift ou modificador
		line3 = String.format("Mofifer keys pessed: %s", (temp.equals("")?"none":temp));		//Se for mostra qual, caso não diz nome
		textoArea.setText( String.format("%s\n%s\n%s\n", line1, line2,line3));					//Modifica o atual valor do textoArea
	}
}
