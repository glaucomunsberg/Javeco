/**
 * implementação do movimento do mouse,
 * 	quando esse se move informa a sua posição
 * 	e modifica o fundo do Frame
 */

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.MouseListener;		//Escuta os eventos do mouse
import java.awt.event.MouseMotionListener;	//Modificação da posicao do mouse
import java.awt.event.MouseEvent;			// eventos do mouse
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MouseTrackerFrame extends JFrame
{
	private JPanel mousePainel;		//Painel onde a cor será modificada segundo as ações
	private JLabel barraDeStatus;	//barra que notifica a posicao
	
	/**
	 * main de implementação do mouseTracker
	 * @param args
	 */
	public static void main( String args[] )
	{
		MouseTrackerFrame mouseTracker = new MouseTrackerFrame();
		mouseTracker.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		mouseTracker.setSize(300,300);
		mouseTracker.setVisible(true);
	}
	
	/**
	 * Implementação do mouseTracker
	 */
	public MouseTrackerFrame()
	{
		super( "testando o movimento do Mouse");
		
		mousePainel = new JPanel();					//Cria o painel
		mousePainel.setBackground( Color.WHITE);
		add( mousePainel, BorderLayout.CENTER);		//Adiciona ele e centraliza
		
		
		
		barraDeStatus = new JLabel( "Mouse outside JPanel");	//Cria a áre de notificação do mouse
		add( barraDeStatus, BorderLayout.SOUTH);				//Seta ele na parte de baixo
		
		//Tratador do evento
		MouseHandler handler = new MouseHandler();
		mousePainel.addMouseListener( handler );
		mousePainel.addMouseMotionListener( handler );

	}
	//A classe interna MouseHandler, tratador de eventos, será de MouseListener como MouseMotionListener
	//	isso fará com que ambos sejam implementadas juntamentes e suas abstracts
	private class MouseHandler implements MouseListener, MouseMotionListener
	{
		//Quando clica
		public void mouseClicked( MouseEvent event )
		{
			barraDeStatus.setText( String.format("Clicou em [%d,%d]", event.getX(), event.getY()));
		}
		
		//Quando o mouse é precionado
		public void mousePressed( MouseEvent event)
		{
			barraDeStatus.setText( String.format("Precionou em [%d,%d]", event.getX(), event.getY()));
		}
		
		//Quando o mouse é liberado
		public void mouseReleased( MouseEvent event)
		{
			barraDeStatus.setText( String.format("Mouse liberado em [%d,%d]", event.getX(), event.getY()));
		}
		
		//Quando o mouse entra na área do Frame
		public void mouseEntered( MouseEvent event)
		{
			barraDeStatus.setText( String.format("O mouse entrou pela área [%d,%d]", event.getX(), event.getY()));
			mousePainel.setBackground( Color.GRAY);
			
		}
		
		//Quando sai da área
		public void mouseExited( MouseEvent event )
		{
			barraDeStatus.setText( String.format("O mouse saiu em [%d,%d]", event.getX(), event.getY()));
			mousePainel.setBackground( Color.WHITE);
		}
		
		// Quando arrasta com ele precionado
		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		//Qunado o mouse se move
		@Override
		public void mouseMoved(MouseEvent event) {
			// TODO Auto-generated method stub
		}
	}

}
