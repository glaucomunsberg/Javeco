/**
 * Cria um método genérico que permite passar como parametro
 * 	mais de um tipo de array, sendo este NÃO de tipos primitivos
 * 	como int, char, boolean.
 * 
 * Observe que a passagem por um elemento genérico "<elem>"
 * possui o mesmo principio que a utilização da passagem
 * 	de um Object
 * @author glaucoroberto
 *
 */
public class MetodoGenerico 
{
	public static void main( String args[])
	{
		Integer[] arrayInteger = {0,1,2,3,4,5};
		Double[] arrayDouble = {1.0, 1.2, 1.3, 1.4, 1.5};
		Character[] arrayCharacter = {'O','L','Á','!'};
		
		System.out.print("Imprimir com método genérico:\n\n");
		System.out.printf("Elementos Integer:\n");
		printArray(arrayInteger);
		System.out.print("Elementos Character:\n");
		printArray(arrayCharacter);
		System.out.print("Elementos Double:\n");
		printArray(arrayDouble);
		
		System.out.print("Imprimir com método genérico Object:\n\n");
		System.out.printf("Elementos Integer:\n");
		printArrayOb(arrayInteger);
		System.out.print("Elementos Character:\n");
		printArrayOb(arrayCharacter);
		System.out.print("Elementos Double:\n");
		printArrayOb(arrayDouble);
		maior(arrayInteger[3], arrayInteger[2]);
		maior(arrayDouble[0], arrayDouble[3]);
		maior(arrayCharacter[2], arrayCharacter[3]);

	}
	public static <Elem> void printArray(Elem[] elementos)
	{
		for(Elem elemento: elementos)
		{
			System.out.printf("%s ", elemento);
		}
	}
	
	/**
	 *  Este funciona exatamentem como o <Elem> 
	 * 		porém utiliza sua forma mais simples
	 * 		Object
	 * @param objeto
	 */
	public static void printArrayOb( Object[] objeto)
	{
		for(Object obj: objeto)
		{
			System.out.printf("%s ", obj);
		}
	}
	
	/**
	 * Infelizmente a utilização das Classes genérias não
	 * 	permite que fossa fazer o comparativo ">" diretamente
	 * 	porém isso é contornado com o "Comparable" implementado
	 * 	pelo .compareTo() que retorna os seguintes valores:
	 * 		-1 - Se o object1 for menor que o object2
	 *       0 - Se ambos forem objetos iguais
	 *       1 - Se o object1 for maior que o object2
	 * @param x
	 * @param y
	 * @return 
	 * @return maior
	 */
	public static < T extends Comparable< T > > void maior(T x, T y)
	{
		T max = x;
		if( y.compareTo(x) > 0 )
		{
			max = y;
		}
		System.out.printf("\n O maior entre \"%-3s\" e \"%-3s\": \"%-3s\"", x, y, max);
	}

}
