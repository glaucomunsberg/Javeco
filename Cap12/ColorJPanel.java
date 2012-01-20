/**
 * Criado para implementar cores em paineis
 * 
 * @author glaucoroberto
 *
 */
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class ColorJPanel extends JPanel
{
	public static void main( String args[])
	{
		JFrame frame = new JFrame("Usando cores");
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		ColorJPanel corPainel = new ColorJPanel();
		frame.add(corPainel);
		frame.setSize(400, 180);
		frame.setVisible(true);
		
	}

	public void paintComponent( Graphics g)
	{
		super.paintComponents(g);
		this.setBackground( Color.WHITE);
		
		g.setColor( new Color(255,0,0));
		g.fillRect(15, 25, 100, 20);
		g.drawString("Corrent RGB:"+g.getColor(), 130, 40);
		
		g.setColor( new Color(0.0f, 1.0f,0.0f));
		g.fillRect(15, 50, 100, 20);
		g.drawString("Corrente RGB:"+g.getColor(), 130, 65);
		
		g.setColor( Color.BLUE);
		g.fillRect(15, 75, 100, 20);
		g.drawString("Corrente RGB:"+g.getColor(), 130, 90);
		
		Color cor = Color.MAGENTA;
		g.setColor(cor);
		g.fillRect(15, 100, 100, 20);
		g.drawString("RGB values:"+cor.getRed()+","+cor.getGreen()+","+cor.getBlue(), 130, 115);
	}
}
