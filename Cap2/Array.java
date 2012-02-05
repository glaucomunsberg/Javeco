public class Array 
{
	private static int[] numeros;
	public static void main(String args[])
	{
		numeros = new int[10];
		System.out.printf("O tamanho é de %d\n", numeros.length);
		for(int a = 0; a < numeros.length; a++)
		{
			numeros[a] = a;
		}
		for(int a = 0; a < numeros.length; a++)
		{
			System.out.printf("%d\n", numeros[a]);
		}
	}

}
