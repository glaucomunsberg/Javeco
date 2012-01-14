import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

public class TextoSenha extends JFrame 
{
	private JTextField campoTexto1;
	private JTextField campoTexto2;
	private JTextField campoTexto3;
	private JPasswordField campoSenha;
	
	public TextoSenha()
	{
		super("User e Password");//Ao chamada a classe Frame passa a String como parametro e gera o titulo da mesma
		setLayout( new FlowLayout() ); //Os objetos se alinham conforma são inseridos
		
		campoTexto1 = new JTextField( 10 ); //10 colunas como campo
		add( campoTexto1 );
		
		campoTexto2 = new JTextField("Entra com o texto aqui:");
		add( campoTexto2);
		
		campoTexto3 = new JTextField("Edição cortada", 21); //texto padrão e 21 colunas
		
		campoTexto3.setSize(200, 200);
		campoTexto3.setEditable(false); //Corta edição
		add( campoTexto3);
		
		
		campoSenha = new JPasswordField("texto escondido"); //constroi com texto padrão
		add( campoSenha );
		
		//handlers de eventos regustradores
		TextFieldHandler handler = new TextFieldHandler();
		campoTexto1.addActionListener(handler);
		campoTexto2.addActionListener(handler);
		campoTexto3.addActionListener(handler);
		campoSenha.addActionListener(handler);
		
		
	}
	private class TextFieldHandler implements ActionListener
	{
		public void actionPerformed( ActionEvent event )
		{
			String texto = null; //String a ser exibida
			
			if( event.getSource() == campoTexto1 )
			{
				texto = String.format("CampoTexto1: %d.", event.getModifiers());
			}
			else if( event.getSource() == campoTexto2 )
			{
				texto = String.format("CampoTexto2: %s.", event.getActionCommand());	
			}
			else if( event.getSource() == campoTexto3 )
			{
				texto = String.format("CampoTexto3: %s.", event.getActionCommand());
			}
			else if( event.getSource() == campoSenha )
			{
				texto = String.format("CampoSenha: %s.", event.getActionCommand());
			}
			
			JOptionPane.showMessageDialog(null, texto);
		}
		
	}

}
