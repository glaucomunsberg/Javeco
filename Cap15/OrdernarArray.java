import java.util.Random;

public class OrdernarArray 
{
	private int[]data;
	private static Random gerador = new Random();
	
	public static void main( String[] args)
	{
		OrdernarArray array = new OrdernarArray(10);
		System.out.println(array);
		array.sort();
		System.out.println(array);
	}
	public OrdernarArray(int tamanho)
	{
		data = new int[tamanho];
		for(int i=0; i < tamanho; i++)
		{
			data[i] = 10+ gerador.nextInt(90);
		}
	}
	
	public void sort()
	{
		int menor;
		
		for(int i=0; i<data.length - 1; i++)
		{
			menor = i;
			for(int posicao = i + 1; posicao < data.length; posicao++)
			{
				if( data[posicao] < data[menor])
				{
					menor = posicao;
				}
			}
			swap(i, menor);
			printPass( i+1, menor);
			
		}
	}
	public void swap(int primeiro, int segundo)
	{
		int temporario = data[primeiro];
		data[primeiro] = data[segundo];
		data[segundo] = temporario;
	}
	//Imprime uma passada do algoritmo
	public void printPass(int passou, int posicao)
	{
		System.out.print( String.format("Depois que passou %2d: ", passou));
		for(int i=0; i< posicao; i++)
		{
			System.out.print( data[i]+" ");
		}
		System.out.print( data[posicao] + "*");
		
		for(int i = posicao+1; i<data.length; i++){
			System.out.print(data[i]+" ");
		}
		System.out.print("\n                  ");
		
		for(int j=0; j < passou; j++)
		{
			System.out.print("-- ");
		}
		System.out.print("\n");
	}
	
	public String toString()
	{
		StringBuffer temporaria = new StringBuffer();
		for(int element: data)
			temporaria.append(element+" ");
			
		temporaria.append("\n");
		return temporaria.toString();
	}

}
