
public class LivroDeTeste 
{
	public static void main( String args[])
	{
		Livro meuLivro = new Livro(); //Estancia o objeto meuLivro baseado na classe Livro
		Dialogo interacao = new Dialogo(); //Cria objeto que será usado para leitura
		String cursoName;
		int numPaginas;
		
		cursoName = interacao.lerString("Insira o nome do curso");
		if( cursoName != null)
		{
			meuLivro.setNomeCurso(cursoName);
		}
		else
		{
			interacao.mensagem("O valor informado é inválido e não será registado!");
		}
		numPaginas = interacao.lerInt("Insira o número de páginas:");
		
		if( numPaginas != 0)
		{
			meuLivro.setNumPaginas(numPaginas);
		}
		meuLivro.mensagem();
	}
}
