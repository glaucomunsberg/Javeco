/**
 * Vetor é como um array, porém é redimensionado dinamicamente
 * 	muito útil e pode ser analizado posteriormente em Stack
 * 
 * @author glaucoroberto
 *
 */
import java.util.Arrays;
import java.util.NoSuchElementException;
public class Vector 
{
	protected java.util.Vector<String> vetor;
	protected String cores[] = {"Preto"};
	public static void main(String args[])
	{
		new Vector();
	}
	public Vector()
	{
		vetor = new java.util.Vector<String>(Arrays.asList(cores));
		imprimir(vetor);
		vectorContais();
		vectorAddAndRemove();
		vectorContais();
		imprimir(vetor);
	}
	
	public void imprimir(java.util.Vector<String>cores)
	{
		if(cores.isEmpty())
		{
			System.out.printf("\nVetor Vazio");
		}
		System.out.printf("\nImprimir o primeiro e o último:\n");
		
		try
		{
			System.out.printf("%s e", vetor.firstElement());
			System.out.printf("%s", vetor.lastElement());
		}
		catch(NoSuchElementException element)
		{
			System.out.printf("\nOops! vetor <=1");
		}
		
		System.out.printf("\nImprimir Vetor de capacidade %d:\n", cores.capacity());
		for(String cor: cores )
		{
			System.out.printf("\n %s ", cor);
		}
		
	}
	
	public void vectorAddAndRemove()
	{
		vetor.add("Olivia");
		vetor.add("Branco");
		vetor.remove("Preto");
	}
	public void vectorContais()
	{
		if(vetor.contains("Branco"))
		{
			System.out.printf("\nBranco está na lista! Na posicao %d!", vetor.indexOf("Branco"));
		}
		else
		{
			System.out.print("\nBranco ainda não está na lista!");
		}
	}

}
