/**
 * Estrutura de dados de Fila
 * @author Glauco Roberto Munsberg dos Santos
 * @author glaucoroberto@gmail.com
 *
 */

package trabalhoGerson2;
public class Fila 
{
	protected Lista fila;
	
	/**
	 * Construtor padrão com
	 * 	tamanho 10 e nome "Fila"
	 */
	public Fila()
	{
		fila = new Lista("Fila", 10);
	}
	
	/**
	 * Construtor que recebe o tamanho
	 * 	que o usuário quiser
	 * @param tamanho
	 */
	public Fila(int tamanho)
	{
		if( tamanho > 0)
		{
			fila = new Lista("Tamanho", tamanho);
		}
		else
		{
			fila = new Lista("Tamanho", 10);
		}
	}
	
	/**
	 * Insere um novo Aluno na fila
	 * @param Aluno aluno
	 * @return int{ 1 - ok | 0 - Erro}
	 */
	public int enqueue(Aluno aluno)
	{
		return fila.inserirNaFrente(aluno.getMatricula(), aluno.getNome());
	}
	
	/**
	 * Remove um aluno da Vila
	 * @return Aluno{ aluno - Ok | null - Erro}
	 */
	public Aluno dequeue()
	{
		return fila.removeNaFrente();
	}
	
	/**
	 * Verifica se a fila está vazia
	 * @return boolean { true - Vazia | false - ao menos 1 valor }
	 */
	public boolean isEmpty()
	{
		return fila.isEmpty();
	}
}
