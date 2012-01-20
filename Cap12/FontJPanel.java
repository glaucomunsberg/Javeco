import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class FontJPanel extends JPanel
{
	public static void main( String args[])
	{
		FontJPanel font = new FontJPanel();
		JFrame frame = new JFrame("Testando...");
		frame.add(font);
		frame.setVisible(true);
		frame.setSize(500,500);
	}
	public void paintComponent( Graphics g)
	{
		super.paintComponent(g);
		
		g.setFont( new Font("serif", Font.BOLD, 11));					//Seta a fonte como serif, Bold, 11
		FontMetrics metrics = g.getFontMetrics();						//Metrics trás informações sobre a font
		g.drawString("Font Corrente: "+g.getFont(), 1, 40);
		g.drawString( "Descendente: "+metrics.getDescent(), 1, 100);
		Font font = new Font("Ubuntu", Font.BOLD, 11);					//cria uma font sendo esta com novos parametros
		metrics = g.getFontMetrics(font);								//passa essas novas informações para o metris
		font = metrics.getFont();										//o
		g.drawString("Nome da font:"+font.getFontName(), 1, 10);
	}
}
