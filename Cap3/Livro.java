/** Livro
 * 		Classe que possui estrutura para o livro que está sendo
 * 			montado. Trazendo e inserindo informações.
 * @author glaucoroberto
 *
 */

public class Livro 
{
	private String cursoNome; // contém o nome do curso
	private int numPaginas;
	Dialogo interacao = new Dialogo();
	public Livro()
	{
		cursoNome = ""; 
		numPaginas = 0;
		
	}
	public void setNomeCurso(String nome)
	{
		// Insere o nome do curso
		cursoNome = nome;
	}
	public void setNumPaginas(int valor)
	{
		numPaginas = valor;
	}
	
	public String getNomeCurso()
	{
		// Retorna o nome do Curso
		return cursoNome;
	}
	public int getNumeroDePaginas()
	{
		return numPaginas;
	}
	public void mensagem()
	{
		// Imprime o nome do curso
		String oQueSeraImprimido = String.format("Bem-Vindo ao curso de \'%s\'. Ele possui %d páginas.", getNomeCurso(), getNumeroDePaginas() );
		interacao.mensagem(oQueSeraImprimido);
	}

}
