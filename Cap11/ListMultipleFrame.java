
import java.awt.FlowLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import javax.swing.JLabel;
	import javax.swing.JFrame;
	import javax.swing.JList;
	import javax.swing.JButton;
	import javax.swing.JScrollPane;					// fornece a capacidade de rolagem 	a JList
	import javax.swing.ListSelectionModel;
	
	/**
	 *  ListMultipleFrame lista multipla que pode ser
	 *  	selecionada e manda para dentro da celula as
	 *  	que foram selecionadas
	 * @author glaucoroberto
	 *
	 */
public class ListMultipleFrame extends JFrame
{
	private JList lista;				//Lista com as cores
	private JList copiaLista;			//Segunda lista que receberá as cores selecionadas
	private JButton copiaBotao;			//botão que informa quando será selecionada
	
	private final String cores[] = {
			"Preto", "Azul", "Cyan", "Cinza Escuro", "Cinza", 
			"Verde", "Cinza Claro", "Magenta", "Laranja",						//Lista com o nomes a ser exibido na JList lista
			"Rosa", "Vermelho", "Branco", "Amarelo"
			};
	
	/**
	 * main que executa a implementação da lista múltipla
	 * @param args
	 */
	public static void main( String args[] )
	{
		ListMultipleFrame lista = new ListMultipleFrame();
		lista.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		lista.setSize(400, 300);
		lista.setVisible(true);
	}
	
	/**
	 * implementação da lista MultiplaEscolha
	 */
	public ListMultipleFrame()
	{
		super( "Testando Multipla Seleção" );
		setLayout( new FlowLayout() );
		
		
		lista = new JList( cores );									//A lista principal recebe todas as cores
		lista.setVisibleRowCount(5);								//5 linhas exibidas
		lista.setSelectionMode(	
				ListSelectionModel.MULTIPLE_INTERVAL_SELECTION		//Seta que será de multipla escolha
				);
		add( new JScrollPane( lista ));								//Adiciona ao Frame
		
		copiaBotao = new JButton( "Copiar >>>");					//Cria o botão da ação
		copiaBotao.addActionListener(								//Classe anônima no botão para ação do botão
				new ActionListener()
				{
					public void actionPerformed( ActionEvent event )
					{
						copiaLista.setListData( lista.getSelectedValues());			//Qunado houver o event então a lista segundária receberá os
																					// valores da lista primária	
					}
				}
				);
		add( copiaBotao );															//Botão é adiciona ao Frame
		
		copiaLista = new JList();									//Cria a lista segundária
		copiaLista.setVisibleRowCount(5);							//seta que a mesma terá 5 linas
		copiaLista.setFixedCellHeight(20);							//diz que cada celula terá essa height
		copiaLista.setFixedCellWidth(95);							// o mesmo mas width
		copiaLista.setSelectionMode(
				ListSelectionModel.SINGLE_INTERVAL_SELECTION		// A lista secundária diferente da primeira, poderá se selecionar apenas
																	//	um item de cada vez
				);
		add( new JScrollPane( copiaLista));							//adiciona ao frame
		
	}
	
}
