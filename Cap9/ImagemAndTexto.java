/** IagemAndTexto
 * 		Classe implementada para printar imagem e
 * 		texto dentro de um frame
 * 			$ javac ImagemAndTexto.java
 * 			$ java	ImagemAndTexto.class
 * 
 * @author glaucoroberto
 *
 */

import java.awt.BorderLayout; //diz onde pode ser colocado dentro de uma a GUI na tela
import javax.swing.ImageIcon; //representa uma imagem que pode ser apresentada em JFrame e JLabel
import javax.swing.JLabel;	  //Label para representar um espaço nao frame
import javax.swing.JFrame;	  //Frame espaço para colocar as imagens

public class ImagemAndTexto
{
	public static void main( String args[])
	{
		
		JLabel emCimaLabel = new JLabel( "Por que platam alho na beira das estradas???"); //Rótulo com texto
		
		ImageIcon imagemIcone = new ImageIcon("Cap3/alert.jpg"); //Cria icone para ser colocada no JLabel
																 //POr algum motivo tive que expecificar pois
												 				 //ele é executado na raiz
		
		JLabel centroLabel = new JLabel( imagemIcone );//Rotulo com a imagem ImageIcon
		
		JLabel emBaixoLabel = new JLabel("Por que alho é bom pra circulação…\n ahuishauihsuihaiush"); //Rótulo para se colocar em baixo
		
		JFrame aplicacao = new JFrame(); 							//Cria uma aplicaco para ser imprimida
		
		aplicacao.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); //Termina a criacao da aplicacao
		
		aplicacao.add( emCimaLabel, BorderLayout.NORTH );			//Adiciona ao Frame o conteudo e sua posicao	
		
		aplicacao.add( centroLabel, BorderLayout.CENTER);			
		
		aplicacao.add( emBaixoLabel, BorderLayout.SOUTH );
		
		aplicacao.setSize( 500, 500);								// Tamanho da aplicacao
		
		aplicacao.setTitle("O Glauco vai contar mais uma piada \"boa\"!");	//Set o titulo da aplicacao
		
		aplicacao.setVisible(true);
		
		
	}
}
