/** Livro
 * 		Classe que possui estrutura para o livro que está sendo
 * 			montado. Trazendo e inserindo informações.
 * @author glaucoroberto
 *
 */
public class Livro 
{
	private String cursoNome; // contém o nome do curso 
	public void setNomeCurso(String nome)
	{
		// Insere o nome do curso
		cursoNome = nome;
	}
	
	public String getNomeCurso()
	{
		// Retorna o nome do Curso
		return cursoNome;
	}
	
	public void mensagem()
	{
		// Imprime o nome do curso
		System.out.printf("Bem-Vindo ao Livro de \'%s\'.", getNomeCurso() );
	}

}
