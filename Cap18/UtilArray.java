/**
 * Arrays trás funções mais robustas para o tratamento
 * 	de arrays
 */
import java.util.Arrays;
public class UtilArray 
{
	private static int intArray[]= {6,2,3,4,5,1};
	private static int  filledIntArray[], intArrayCopy[];
	public static void main( String args[])
	{
		filledIntArray = new int[6];
		intArrayCopy = new int[intArray.length];
		
		Arrays.fill(filledIntArray, 7); // FILL faz com que o array seja preenchico com setes
		Arrays.sort(intArray);			// SORT ordena o array
		
		System.arraycopy(filledIntArray, 0, intArrayCopy, 0, intArray.length); //copyArray tem como argumento 1- de qual será copiado, 2- apartir de qual, 3-próximo array, 4-De onde começará e o tamanho
		
		System.out.printf("O 4 está na posição: %d", Arrays.binarySearch(intArray, 6)); //Se não for encontrado ele retorna o valor negativo correspondente a próxima inserção (posicao-1)
	
		boolean isEquals = Arrays.equals(filledIntArray, intArrayCopy);
		System.out.printf("\n %s.", (isEquals ? "Copiou corretamente" : "Não está igual"));
	}

}
