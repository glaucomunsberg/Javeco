public class Fila 
{
	private Lista queue;
	
	public Fila()
	{
		queue = new Lista("fila");
	}
	
	public void enqueue(Object object)
	{
		queue.inserirNoFinal(object);
	}
	
	public Object dequeue() throws Exception
	{
		return queue.removerDaFrente();
	}
	public boolean isEmpty()
	{
		return queue.isEmpty();
	}
	
	public void print()
	{
		queue.imprimir();
	}

}
