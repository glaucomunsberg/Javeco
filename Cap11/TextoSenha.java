/** Implementa caixa de textos de texto e senha assim como
 * 		escutar ações dele.
 */

import java.awt.FlowLayout; 			//Coloca cada elemento do JFrame na ordem que é inserido
import java.awt.event.ActionEvent;		//Trata evento
import java.awt.event.ActionListener;	//Escuta eventos de ação
import javax.swing.JFrame;				//Frame para inserir os objetos e icones
import javax.swing.JTextField;			//Campo de texto
import javax.swing.JPasswordField;		//Campo de senha
import javax.swing.JOptionPane;			//Painel ou Dialogo

public class TextoSenha extends JFrame 
{
	private JTextField campoTexto1; 	//Cria campo de texto1,2 e 3
	private JTextField campoTexto2;
	private JTextField campoTexto3;
	private JPasswordField campoSenha;	//Cria campo de senha
	
	
	/**
	 * Implementação da própria classe
	 * @param args
	 */
	public static void main( String args[] )
	{
		TextoSenha janela = new TextoSenha();
		janela.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		janela.setSize(311,140);
		janela.setVisible(true);
	}
	
	/**
	 * 
	 */
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
	//Implementação da textFieldHandler para tratar o evento
	private class TextFieldHandler implements ActionListener
	{
		public void actionPerformed( ActionEvent event )
		{
			String texto = null; //String a ser exibida
			
			//IF's para verificar qual dos campos ocorreu a ação
			// e então notifica que esse campo foi acionado
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
			
			//Imprime através de mensagem qual campo foi acionado
			JOptionPane.showMessageDialog(null, texto);
		}
		
	}

}
