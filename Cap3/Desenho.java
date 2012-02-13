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
	/**
	 * 
	 */
	private static final long serialVersionUID = -3884061780920725514L;

	public int opcaoDeDesenho; // Responsável pela escolha de qual forma de desenho
	
	Dialogo interacao = new Dialogo();
	
	
	final Color VIOLETA = new Color(128,0,128);
	final Color INDIGO = new Color(75,0,130);
	private Color colors[] = { Color.WHITE, Color.WHITE, VIOLETA, INDIGO, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.RED};
	
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
	      		break;
      	case 5:
      			/* g.fillArco
      			 * 		Cria um arco-íris sendo que com o laço trocamos de cores que estão
      			 * 		em um array colors, e fillArc desenha.
      			 */
      		
      			int raio = 20;
      			int centroX = getWidth()/2;
      			int centroY = getHeight()-10;
      			for( int contador = colors.length; contador > 0 ; contador--)
      			{
      				g.setColor(colors[contador-1]);
      				
      				g.fillArc(centroX-contador*raio, centroY-contador*raio, contador*raio*2, contador*raio*2, 0, 180);
      			}
      			break;
      	case 0:
      	default:
  			System.exit(1);
  			break;	
	      }

   }
}

