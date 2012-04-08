package trabalhoGerson2;
import java.util.Vector;
public class Lista
{
	protected String nomeLista;
	protected int tamanho;
	protected Vector<Aluno> alunos;
	
	/**
	 * Construtor automático que inicia com o nome "Lista" e tamanho "10"
	 */
	public Lista()
	{
		this("Lista", 10);
	}
	
	/**
	 * Construtor que começa com nome "Lista" e de tamanho indicado pelo aluno
	 * @param int tamanho
	 */
	public Lista(int tamanho)
	{
		this("Lista", tamanho);
	}
	
	/**
	 * Construtor que permite inserir nome e tamanho da lista
	 * 	segundo o usuário
	 * @param String nome
	 * @param int tamanho
	 */
	public Lista(String nome, int tamanho)
	{
		this.nomeLista = nome;
		this.tamanho = tamanho;
		alunos = new Vector<Aluno>(tamanho);
		System.out.printf("Creator: Criado nome \'%s\' de tamanho %d\n", this.nomeLista, this.tamanho);
	}
	
	/**
	 * Inserir elemento no início do vetor
	 * retorna 1 se inseriu ou 0 se não inseriu
	 * @param int matriculaAluno
	 * @param String nomeAluno
	 * @return int {1 - inseriu com sucesso | 0 - Se encontrou erro }
	 */
	public int inserirNaFrente(int matriculaAluno, String nomeAluno)
	{
		
		if( alunos.size() < tamanho )
		{
			alunos.add(0, new Aluno(nomeAluno,matriculaAluno));
			System.out.printf("%s: Inserido os valores: %d - %s na frente\n", this.nomeLista, matriculaAluno, nomeAluno);
			return 1;
		}
		else
		{
			System.out.printf("%s: Atenção!Não inserido o valor: %d - %s na frente\n", this.nomeLista, matriculaAluno, nomeAluno);
			return 0;
		}
		
	}
	
	
	/**
	 * Insere elemento no final do vetor
	 * 	return 1 se inseriu ou 0 se não inseriu
	 * @param int matriculaAluno
	 * @param String nomeAluno
	 * @return int {1 - inseriu com sucesso | 0 - Se encontrou erro }
	 */
	public int inserirAtras(int matriculaAluno, String nomeAluno)
	{
		if( alunos.size() < tamanho )
		{
			alunos.add(alunos.size(), new Aluno(nomeAluno, matriculaAluno));
			System.out.printf("%s: Inserido os valores: %d - %s atrás\n", this.nomeLista, matriculaAluno, nomeAluno);
			return 1;
		}
		else
		{
			System.out.printf("%s: Atenção!Não inserido o valor %d - %s atrás\n", this.nomeLista, matriculaAluno, nomeAluno);
			return 0;
		}
	}
	
	/**
	 * remove o elemento da frente do vetor
	 * @return Aluno { Aluno - se existe | null se não existe ou erro }
	 */
	public Aluno removeNaFrente()
	{
		if( this.qualTamanho() > 0)
		{
			System.out.printf("Lista: Removido da Frente\n");
			return alunos.remove(0);
		}
		else
		{
			System.out.printf("%s: Não há elementos\n", this.nomeLista);
			return null;
		}
	}
	
	/**
	 * remove o elemento de trás do vetor
	 * @return Aluno { Aluno - se existe | null se não existe ou erro }
	 */
	public Aluno removeAtras()
	{
		if( this.qualTamanho() >= 0 && !isEmpty())
		{
			System.out.printf("Lista: Removido de trás\n");
			return alunos.remove( this.qualTamanho()-1 );
		}
		else
		{
			System.out.printf("%s: Não há elementos\n", this.nomeLista);
			return null;
		}
	}
	
	/**
	 * Método que retorna o estado do vetor
	 * @return boolean{true - Com elementos | false - Se vazio}
	 */
	public boolean isEmpty()
	{
		return alunos.isEmpty();
	}
	
	public int qualTamanho()
	{
		return alunos.size();
	}
}
