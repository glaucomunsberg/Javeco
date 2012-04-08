package trabalhoGerson;
import java.util.Vector;
public class Pilha 
{
	protected Vector<Integer> pilha;
	protected int indice = -1;
	protected int tamanho = 20;
	
	public Pilha()
	{
		pilha = new Vector<Integer>();
		pilha.setSize(20);
	}

	/**
	 * Construtor para fila de tamanho personalizado
	 * @param tamanho
	 */
	public Pilha (int tamanho)
	{
		pilha = new Vector<Integer>();
		pilha.setSize(tamanho);
		this.tamanho = tamanho;
	}
	
	/**
	 * retorna o tamanho
	 * @return int tamanho
	 */
	public int getTamanho()
	{
		return pilha.size();
	}
	
	/**
	 * insere um elemento na pilha
	 * @param inserir
	 * @return int {0 - Erro | 1 - Sucesso}
	 */
	public int push(int inserir)
	{
		if(indice < tamanho )
		{
			indice++;
			pilha.insertElementAt(inserir, 0);
			return 1;
		}
		else
		{
			return 0;
		}
		
	}
	
	/**
	 * remove um elemento da pilha
	 * @return String elemento removido
	 */
	public String pop()
	{
		if( !isEmpty() )
		{
			return null;
		}
		else
		{
			indice--;
			return String.format("%d", pilha.remove(0));
		}
	}
	
	/**
	 * Método que retorna se a Pilha está vazia
	 * @return boolean { TRUE se vazia e FALSE se tem elementos}
	 */
	public boolean isEmpty()
	{
		return (indice == -1 ? true : false);
	}
}
