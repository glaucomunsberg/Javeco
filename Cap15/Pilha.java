public class Pilha extends Lista
{
	public Pilha()
	{
		super("Pilha");
	}
	public void push(Object object)
	{
		inserirNaFrente(object);
	}
	public Object pop() throws Exception
	{
		return removerDaFrente();
	}
}
