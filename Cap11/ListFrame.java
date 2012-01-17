	/**
	 * Implementacao de lista
	 * 	onde a lista conterá cores e quando essa
	 * 	for selecionada mudará o backgroud do frame
	 * @author glaucoroberto
	 */
	import java.awt.FlowLayout;
	import java.awt.Color;
	import javax.swing.JFrame;
	import javax.swing.JList;
	import javax.swing.JScrollPane; 				// fornece a capacidade de rolagem 	a JList
	import javax.swing.event.ListSelectionEvent;
	import javax.swing.event.ListSelectionListener;
	import javax.swing.ListSelectionModel;
	
	public class ListFrame extends JFrame 
	{
		private JList lista;
		private final String coresNomes[] = {
										"Preto", "Azul", "Cyan", "Cinza Escuro", "Cinza", 
										"Verde", "Cinza Claro", "Magenta", "Laranja",						//Lista com o nomes a ser exibido na JList
										"Rosa", "Vermelho", "Branco", "Amarelo"
										};
		
		private final Color cores[] = { Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY,
										Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE,			//Lista correspondende dos nomes da cores
										Color.PINK, Color.RED, Color.WHITE, Color.YELLOW
										};
		
		/**
		 *  Main para testar a implementação
		 *  	do JList
		 * @param args
		 */
		public static void main( String args[] )
		{
			ListFrame lista = new ListFrame();
			lista.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			lista.setSize(350, 200 );
			lista.setVisible(true);
		}
		
		public ListFrame()
		{
			super( "Teste de Lista");
			setLayout( new FlowLayout() );
			
			lista = new JList( coresNomes );													//Cria e insere as cores na lista
			lista.setVisibleRowCount( 5 );														//Seta como 5 o número de itens a amostra
			lista.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );						//Diz que apenas um item será possível de selecionar
			add( new JScrollPane( lista ) );													//Cria JSCroolPane que diz que a lista terá rolagem
			
			lista.addListSelectionListener(
					//Classe interna Anônima
					new ListSelectionListener()
					{
						//Se houver um evento ele setará o background 
						//	com o index da cor selecionado no lista.getSelectedIndex
						public void valueChanged( ListSelectionEvent event)
						{
							getContentPane().setBackground( cores[ lista.getSelectedIndex()]);
						}
				}
					
			);
		}
	}
	
