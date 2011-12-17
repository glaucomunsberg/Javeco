import java.util.Scanner;

public class LivroDeTeste 
{
	public static void main( String args[])
	{
		Livro meuLivro = new Livro(); //Estancia o objeto meuLivro baseado na classe Livro
		
		Scanner entrada = new Scanner(System.in);
		String cursoName;
		
		System.out.println("Insira o nome do curso do livro: ");
		cursoName = entrada.nextLine();
		meuLivro.setNomeCurso(cursoName);
		meuLivro.mensagem();
	}
}
