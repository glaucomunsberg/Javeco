/**
 * Aqui estão vários algoritmos úteis para as coleções
 *  vejamos alguns deles:
 *  	SHORT - Classifica os elementos de uma lista
 *  	FILL  - Preenche toda a lista com o valor informado
 *  	SHUFFER - Desordena a lisa
 *  	BINATYSEARCH - Procura pelo valor
 *  	MAX	- Retorna o maior valor da lista
 *  	MIN - retorna o menor valor da lista
 *  	ADD - Adicona a lista uma string[]
 *  	FREQUENCY - Retorna quantas vezes aquele objeto está presente na lista
 *      DISJOIN - Retorna True se em ambas as listas não há elementos em comum
 * @author glaucoroberto
 *
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class AlgoritmosDeColecoes 
{
	protected static List<String> listaString;
	protected static List<Integer> listaInteger;
	protected static String[] arrayString;
	protected static Integer[] arrayInteger;
	protected static String[] arrayStringAux;
	protected static Integer[] arrayIntegerAux;
	
	public AlgoritmosDeColecoes()
	{
		arrayString = new String[]{"Olá","meu","nome","é","Glauco"};
		arrayStringAux = new String[]{"b","a"};
		arrayInteger = new Integer[]{10,1,0,111,3,45,57,29};
		arrayIntegerAux = new Integer[]{1,2};
		
		
		listaString = Arrays.asList(arrayString);
		listaInteger = Arrays.asList(arrayInteger);
		
		System.out.printf("\nListaString  Original:\n %s\n", listaString);
		System.out.printf("ListaInteger Original:\n %s\n", listaInteger);
	}
	
	public static void main(String args[])
	{
		AlgoritmosDeColecoes algoritmosDeColecao = new AlgoritmosDeColecoes();
		
		algoritmosDeColecao.binarySearch();
		algoritmosDeColecao.shortList();
		algoritmosDeColecao.shuffleList();
		algoritmosDeColecao.fillList();
		//algoritmosDeColecao.addAllList();
		algoritmosDeColecao.disjointList();
		algoritmosDeColecao.frequencyList();
		
	}
	
	protected void shortList()
	{
		/**
		 * Com o short pode ordenar do menor ao maior, bem como
		 * fazer o contrário na lista. Veja a baixo como é composto
		 */
		Collections.sort(listaString);
		System.out.printf("\nArrayString  -Short-:\n %s\n", listaString);
		System.out.printf("ArrayInteger -Short-:\n %s\n", listaInteger);
		
		Collections.reverse(listaString);
		Collections.reverse(listaInteger);
		System.out.printf("ArrayString  -Short Reverse-:\n %s\n", listaString);
		System.out.printf("ArrayInteger -Short Reverse-:\n %s\n", listaInteger);
	}
	
	protected void shuffleList()
	{
		/**
		 * shuffle trás a capacidade de "embaralhar" a lista
		 *  inteira de forma a não ter "ordem"
		 */
		
		Collections.shuffle(listaInteger);
		Collections.shuffle(listaString);
		System.out.printf("\nArrayString  -Shuffle-:\n %s\n", listaString);
		System.out.printf("ArrayInteger -shuffle-:\n %s\n", listaInteger);
	}
	
	protected void maxAndMinList()
	{
		/**
		 * Max como já diz procura o maior elemento e
		 * Min procura o menor termo
		 */
		
		System.out.printf("\nArrayString  -Max-:\n %s\n", Collections.max(listaString));
		System.out.printf("ArrayInteger -Max-:\n %s\n", Collections.max(listaInteger));
		
		System.out.printf("ArrayString  -Min-:\n %s\n", Collections.max(listaString));
		System.out.printf("ArrayInteger -Min-:\n %s\n", Collections.max(listaInteger));
		
	}
	
	protected void fillList()
	{
		/**
		 * Fill ideal para renderizar listas, ele sobrescreve
		 *  os elementos por um valor específico
		 */
		Collections.fill(listaString, "Zero");
		Collections.fill(listaInteger, 1);
		System.out.printf("\nArrayString  -Fill 'Zero'-:\n %s\n", Collections.max(listaString));
		System.out.printf("ArrayInteger -Fill '1'   -:\n %s\n", Collections.max(listaInteger));
	}
	
	protected void binarySearch()
	{
		/**
		 * binarySearch procura o indice que se encontra o valor
		 * 	que se procura, caso não encontre retorna nulo
		 */
		int resultado = 0;
		resultado = Collections.binarySearch(listaString, arrayString[4]);
		System.out.printf("\nArrayString -binarySearch 'Glauco':\n Posicao %d\n", resultado);
		resultado = Collections.binarySearch(listaString, arrayString[0]);
		System.out.printf("ArrayString -binarySearch 'NOME'  :\n Posicao %d\n", resultado);
		
		
		resultado = Collections.binarySearch(listaInteger, 1);
		System.out.printf("ArrayString -binarySearch '1'  :\n Posicao %d\n", resultado);
		resultado = Collections.binarySearch(listaInteger, 200);
		System.out.printf("ArrayString -binarySearch '200':\n Posicao %d\n", resultado);
		
	}
	
	protected void addAllList()
	{
		/**
		 * addAll é responsável pela concatenação
		 */
		Collections.addAll(listaString, arrayStringAux);
		Collections.addAll(listaInteger, arrayIntegerAux);
		System.out.printf("\nArrayString  -AddAll-:\n %s\n", Collections.max(listaString));
		System.out.printf("ArrayInteger -AddAll-:\n %s\n", Collections.max(listaInteger));
	}
	
	protected void frequencyList()
	{
		/**
		 * Frequenci verifica quantas vezes aparece naquela lista
		 */
		int resultado;
		resultado = Collections.frequency(listaString, "Glauco");
		System.out.printf("\nArrayString  -Frequency 'Glauco'-:\n %s\n", resultado);
		resultado = Collections.frequency(listaInteger, 1);
		System.out.printf("\nArrayInteger  -Frequency '1'-:\n %s\n", resultado);
	}
	
	protected void disjointList()
	{
		/**
		 * disjoin recebe dois colections e retorna true
		 * 	se ambos não tiverem nenhum elemento em comum
		 */
		
		boolean temAlgoEmComum;
		temAlgoEmComum = Collections.disjoint(listaString, listaInteger);
		if(temAlgoEmComum)
		{
			System.out.printf("\n'listaString' e 'listaInteger' tem algum elemento em comum\n");
		}
		else
		{
			System.out.printf("\n'listaString' e 'listaInteger' NÃO tem nenhum elemento em comum\n");
		}
	}

}