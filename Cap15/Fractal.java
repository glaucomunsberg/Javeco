import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class Fractal extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8557648973997844535L;
	private int nivel;
	
	private final int ALTURA  = 400;
	private final int LARGURA = 400;
	
	public Fractal(int nivelCorrente)
	{
		nivel = nivelCorrente;
		this.setBackground( Color.WHITE);
		this.setPreferredSize( new Dimension(ALTURA,LARGURA));
		
	}
	
	public void desenharFractal(int nivel, int xA, int yA, int xB, int yB, Graphics g)
	{
		if( nivel == 0)
		{
			g.drawLine(xA,yA,xB,yB);
		}
		else
		{
			int xC = (xA + xB)/2;
			int yC = (yA + yB)/2;
			
			int xD = xA + (xC - xA)/2 - (yC - yA)/2;
			int yD = yA + (yC - yA)/2 - (xC - xA)/2;
			
			desenharFractal( nivel - 1, xD, yD, xA, yA, g);
			desenharFractal( nivel - 1, xD, yD, xC, yC, g);
			desenharFractal( nivel - 1, xD, yD, xB, yB, g);
			
		}
	}
	
	public void paintComponent( Graphics g)
	{
		super.paintComponent(g);
		desenharFractal( nivel, 100, 90, 290, 200, g );
	}
	
	public void setColor( Color c)
	{
	}
	
	public void setNivel( int correnteNivel)
	{
		nivel = correnteNivel;
	}
	
	public int getNivel()
	{
		return nivel;
	}
}
