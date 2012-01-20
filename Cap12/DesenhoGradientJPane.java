import java.awt.Color;
import java.awt.TexturePaint;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DesenhoGradientJPane extends JPanel
{
	public static void main( String args[])
	{
		JFrame frame = new JFrame("Testando...");
		DesenhoGradientJPane desenho = new DesenhoGradientJPane();
		frame.add(desenho);
		frame.setVisible(true);
		frame.setSize(400, 400);
		
	}
	public void paintComponent( Graphics g )
	{
		//Um arco dentro de um quadrado
		super.paintComponent( g );
		g.setColor( Color.RED);
		g.drawRect(15, 35, 80, 80);						//Retangulo
		g.setColor( Color.BLACK );
		g.drawArc(15, 35, 80, 80, 0, 360);				//X de inicio, Y de inicio, X algura, X largura, GRAU inicio, GRAU final
		
		//Um pegaço de arco
		g.setColor( Color.RED);
		g.drawRect(100, 35, 80, 80);
		g.setColor( Color.BLACK);
		g.drawArc(100, 35, 80, 80, 0, 110);
		
		//Um arco dentro de um quadrado EM GRADIENTE
		g.setColor( Color.RED);
		g.drawRect(185, 35, 80, 80);
		g.setColor( Color.BLACK);
		g.fillArc(185, 35, 80, 80, 0, 360);				//FILL em vez de DRAW faz ele ser preenchido peloa cor
	
		//Um pedaço de arco pintado
		g.setColor( Color.BLACK );
		g.drawRect(270, 35, 80, 80);
		g.setColor( Color.RED );
		g.fillArc(270, 35, 80, 80, 40, -250);
		
		
	
	}
}
