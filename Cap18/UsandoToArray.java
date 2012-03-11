/**
 * Utilizando o linkedList de forma mais robusta
 * 		note que o linkedList possibilita uma maior
 * 		flexibilidade do que o array
 * 
 * @author glaucoroberto
 *
 */
import java.util.LinkedList;
import java.util.Arrays;
public class UsandoToArray 
{
	protected String stringDeCores[];
	protected static LinkedList <String> linkada;
	public UsandoToArray()
	{
		stringDeCores = new String[]{"Branco","Magenta","Preto"};
		
		/**
		 * o "asList" possibilita transformar um array em lista
		 */
		
	}
	public void addToLinked()
	{
		linkada = new LinkedList<String>(Arrays.asList(stringDeCores));
		
		/**
		 * Tipos de add:
		 * 		addLast - Adiciona com o final do índice
		 * 		add		- Adiciona ao final
		 * 		addFirst- Adiciona no início da lista
		 */
		linkada.addLast("Preto Fosco");	
		linkada.add("Verde");
		linkada.add(1,"Amarelo" );
		linkada.addFirst("Branco Céu");
	}
	
	public void printLinked(LinkedList<String> listaLinkada)
	{
		System.out.printf("Imprimindo Lista:\n");
		for(String Cor: listaLinkada)
		{
			System.out.printf("%s ", Cor);
		}
	}
	
	public static void main(String args[])
	{
		UsandoToArray listaLinkada = new UsandoToArray();
		listaLinkada.addToLinked();
		listaLinkada.printLinked(linkada);
	}

}
