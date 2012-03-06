public class Lista
{
	private Nodo primeiroNodo;
	private Nodo ultimoNodo;
	private String nome;
	
	public Lista()
	{
		this("lista");
	}
	
	public Lista(String nomeLista)
	{
		nome = nomeLista;
		primeiroNodo = ultimoNodo = null;
	}
	
	public void inserirNaFrente(Object inserir)
	{
		if(isEmpty())
		{
			primeiroNodo= ultimoNodo = new Nodo(inserir);
		}
		else
		{
			primeiroNodo = new Nodo(inserir, primeiroNodo);
		}
		
	}
	
	public void inserirNoFinal(Object inserir)
	{
		if(isEmpty())
		{
			primeiroNodo = ultimoNodo = new Nodo(inserir);
		}
		else
		{
			ultimoNodo = ultimoNodo.nextNodo = new Nodo(inserir);
		}
	}
	
	public Object removerDaFrente() throws Exception
	{
		if(isEmpty())
		{
			throw new Exception(nome);
		}
		
		Object itemRemovido = primeiroNodo.data;
		
		if(primeiroNodo == ultimoNodo)
		{
			primeiroNodo = ultimoNodo = null;
		}
		else
		{
			primeiroNodo = primeiroNodo.nextNodo;
		}
		return itemRemovido;
	}
	
	public Object removerDoFinal() throws Exception
	{
		if(isEmpty())
		{
			throw new Exception(nome);
		}
		Object itemRemovido = ultimoNodo.data;
		
		if( primeiroNodo == ultimoNodo)
		{
			primeiroNodo = ultimoNodo = null;
		}
		else
		{
			Nodo corrente = primeiroNodo;
			while( corrente.nextNodo != ultimoNodo)
			{
				corrente = corrente.nextNodo;
			}
			ultimoNodo = corrente;
			corrente.nextNodo = null;
		}
		return itemRemovido;
	}
	public boolean isEmpty()
	{
		return primeiroNodo == null;
	}
	public void imprimir()
	{
		if(isEmpty())
		{
			System.out.printf("Limpa %s\n", nome);
			return;
		}
		
		System.out.printf("This %s is: ", nome);
		
		Nodo corrente = primeiroNodo;
		
		while(corrente != null)
		{
			System.out.printf("%s", corrente.data);
			corrente = corrente.nextNodo;
		}
		System.out.println("\n");
	}
}




//Classe que representa um no
class Nodo 
{
	Object data;
	Nodo nextNodo;
	
	Nodo(Object objeto)
	{
		this(objeto, null);
	}
	//Construtr cria ListNodo
	Nodo(Object objeto, Nodo nodo)
	{
		data = objeto;
		nextNodo = nodo;
	}
	
	//Retorna referência aos dados no nó
	Object getObject()
	{
		return data;
	}
	
	//retorna referência ao próximo nó na lista
	Nodo getNext()
	{
		return nextNodo;
	}
}
