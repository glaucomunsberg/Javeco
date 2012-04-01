package trabalhoGerson;

public class EstruturaDeDadosLineares 
{	
	public static void main(String args[])
	{
		
		Fila fila = new Fila();
		Pilha pilha = new Pilha();
		int retornoInt;
		String retornoString = null;
		for(int a=0; a <= 22; a++)
		{
			retornoInt = fila.enqueue(a);
			if( retornoInt == 1)
			{
				System.out.printf("Fila: Valor %d inserido\n", a);
			}
			else
			{
				System.out.printf("Fila: Atençao!Valor %d não inserido\n", a);
			}
			retornoInt = pilha.push(a);
			if( retornoInt == 1)
			{
				System.out.printf("Pilha: Valor %d inserido\n", a);
			}
			else
			{
				System.out.printf("Pilha: Atençao!Valor %d não inserido\n", a);
			}
		}
		
		for(int a = 22; a >= 0; a--)
		{	
			retornoString = fila.dequeue();
			if( retornoString != null)
			{
				System.out.printf("Fila: Valor %s foi removido\n", retornoString);
			}
			else
			{
				System.out.printf("Fila: Atençao!Não foi removido\n", a);
			}
			
			retornoString = pilha.pop();
			if( retornoString != null)
			{
				System.out.printf("Pilha: Valor %s foi removido\n", retornoString);
			}
			else
			{
				System.out.printf("Pilha: Atençao!Não foi removido\n", a);
			}
		}
	}
}
