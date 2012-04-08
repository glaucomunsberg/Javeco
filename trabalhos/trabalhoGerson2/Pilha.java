package trabalhoGerson2;
/**
 * Restrutura de dados Pilha
 * @author Glauco Roberto Munsberg dos Santos
 * @author glaucomunsberg@gmail.com
 */
public class Pilha
{
	protected Lista pilha;
	
	/**
	 * Construtor padrão com
	 * 	tamanho 10 e nome "Fila"
	 */
	public Pilha()
	{
		pilha = new Lista("Fila", 10);
	}
	
	/**
	 * Construtor que recebe o tamanho
	 * 	que o usuário quer
	 * @param tamanho
	 */
	public Pilha(int tamanho)
	{
		if( tamanho > 0)
		{
			pilha = new Lista("Tamanho", tamanho);
		}
		else
		{
			pilha = new Lista("Tamanho", 10);
		}
	}
	
	/**
	 * insere no inicío do aluno em cima da pilha
	 * @param aluno
	 * @return int { 1 - OK | 0 - Errado}
	 */
	public int push(Aluno aluno)
	{
		return pilha.inserirNaFrente(aluno.getMatricula(), aluno.getNome());
	}
	
	/**
	 * Remove da pilha 
	 * @return Aluno { aluno - OK | null - Erro }
	 */
	public Aluno pop()
	{
		return pilha.removeNaFrente();
	}
	
	/**
	 * Retorna se a fila está vazia ou não
	 * @return boolean { true - Vazia | false - Com elemento(s) }
	 */
	public boolean isEmpty()
	{
		return pilha.isEmpty();
	}

}
