package trabalhoGerson;
import java.util.Vector;

public class Fila {
	
	protected Vector<Integer> queue;
	protected int indice =-1;
	protected int tamanho = 20;
	
	public Fila()
	{
		queue = new Vector<Integer>();
		queue.setSize(20);
	}
	
	/**
	 * Construtor para fila de tamanho personalizado
	 * @param tamanho
	 */
	public Fila(int tamanho)
	{
		queue = new Vector<Integer>();
		queue.setSize(tamanho);
		this.tamanho = tamanho;
		
	}
	
	/**
	 * Retorna o tamanho da Fila
	 * @return int tamanho
	 */
	public int getTamanho()
	{
		return queue.size();
	}
	/**
	 * Método de remoção de elemento da fila
	 * @return String{ Elemento - se sucesso. Null se houve erro}
	 */
	public String dequeue()
	{
		if( !isEmpty() )
		{
			return null;
		}
		else
		{
			indice--;
			return String.format("%d", queue.remove(0));
		}
	}
	
	/**
	 * Insere um novo elemento na Fila
	 * @param int novo
	 * @return int{ 1 inserção com sucesso 0  se erro}
	 */
	public int enqueue(int novo)
	{
		if(indice < tamanho)
		{
			indice++;
			queue.add(indice, novo);
			return 1;
		}
		else
		{
			return 0;
		}
		
	}
	/**
	 * método que retorna se a Fila está vazia
	 * @return boolean {true se vazia false se não está vazia}
	 */
	public boolean isEmpty()
	{
		return (indice == -1 ? true : false);
	}
	

}
