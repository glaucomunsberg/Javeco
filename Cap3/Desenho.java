/** O Desenho é a classe responsável por fazer desenhos geométricos
 * 	utilizando as bibliotecas java.
 * @author glaucoroberto
 *
 */

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

public class Desenho extends JPanel
{
	private String funcao	= "Responsável por fazer desenhos do tipo, Linha, Retângulo e Oval. Recebe como parametro qual das formas quer.";
	private Double versao	= 0.0;
	
	public int opcaoDeDesenho; // Responsável pela escolha de qual forma de desenho
	
	Dialogo interacao = new Dialogo();
	
	/** paintComponent
	 * 		Desenha um x a partir dos cantos do painel
	 * 
	 */
   public void paintComponent( Graphics g )
   {
      // chama paintComponent para assegurar que o painel é exibido corretamente
      super.paintComponent( g );


      switch( opcaoDeDesenho )
      {
      	case 0:
      		interacao.mensagem("Não foi escolhido nenhum objeto");
      		break;
      	case 1:
      		for( int i=0; i <= 10; i++)
      		{
      			/* g.drawLine
                 * 	Método responsável pela criação de uma linha,
                 * 		sendo os dois primeiros parâmetro responsável
                 * 		pela ponta inicial da linha e dos dois últimos
                 * 		responsáveis pela ponta final da linha.
                 */
      			g.drawLine(0,0, i, i);
      		}
      		break;
      		
      	case 2:
      		for( int i=0; i <= 10; i++)
      		{
      			/* g.drawRect
                 * 	Método responsável pela criação de um retangulo,
                 * 		sendo os dois primeiros parâmetro responsável
                 * 		pela ponta superiro do retangulo e dos dois últimos
                 * 		responsáveis pela largura e altura
                 */
      			g.drawRect(10+i*10, 10+i*10, 50+i*10, 50+i*10);
      		}
      		break;
      		
      	case 3:
      		for( int i=0; i<= 10; i++)
      		{
      			/* g.drawOval
                 * 	Método responsável pela criação de uma forma oval,
                 * 		sendo os dois primeiros parâmetro responsável
                 * 		pela ponta superiro da forma e dos dois últimos
                 * 		responsáveis pela largura e altura do mesmo.
                 */
      			g.drawOval(10+i*10, 10+i*10, 50+i*10, 50+i*10);
      		}
      		break;
      	case 4:
      		
      		/*
      		 * g.setColor() é o método que dá cor ao desenho que se se
      		 * 		vai fazer. ela recebe como parâmetro as cores RGB
      		 * 		setColor(int R, int G, int B) sendo
      		 * 			0 => ( R || G || B ) <= 255
      		 * 		para se dar to e a cada cor. Porém pode se usar cores
      		 * 		especificas como Color.WHITE, Color.GARY...
      		 */
      		
      		//Desenho do rosto
      		g.setColor( Color.YELLOW );
      		g.fillOval(10, 10, 200, 200);
      		
      		//Desenho dos olhos
      		g.setColor( Color.BLACK);
      		g.fillOval(55, 65, 30, 30);
      		g.fillOval(135, 65, 30, 30);
      		
      		//Desenho da boca
      		g.fillOval(50, 110, 120, 60);
      		
      		//retoca a boca para criar um sorriso
      		g.setColor( Color.YELLOW);
      		g.fillRect(50, 110, 120, 30);
      		g.fillOval(50, 120, 120, 40);
      }
     


   }
   
   public void info()
   {
		String informacao = String.format( "Função: %s.\nVersão:%.2f\n", funcao,versao );
		interacao.mensagem(informacao);
	}
}

