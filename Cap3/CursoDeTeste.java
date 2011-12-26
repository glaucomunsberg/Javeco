
public class CursoDeTeste 
{
	public static void main( String args[])
	{
		Curso meuCurso = new Curso(null,0, null); //Estancia o objeto meuLivro baseado na classe Livro
		Dialogo interacao = new Dialogo(); //Cria objeto que será usado para leitura
		String cursoName;
		int numAlunos;
		int gradeDeNotas[] = {1, 2, 4, 5, 6, 7, 8, 9, 10};
		
		meuCurso.setNotas(gradeDeNotas);
		cursoName = interacao.lerString("Insira o nome do curso");
		if( cursoName != null)
		{
			meuCurso.setNomeCurso(cursoName);
		}
		else
		{
			interacao.mensagem("O valor informado é inválido e não será registado!");
		}
		numAlunos = interacao.lerInt("Insira o número de Alunos:");
		
		if( numAlunos > 0)
		{
			meuCurso.setNumeroDeAlunos(numAlunos);
		}
		meuCurso.mensagem();
		
		String sobreNotas = String.format("A maior nota é : %d.\nA menor nota é: %d.\nA média é : %.2f", meuCurso.getMaiorNota(), meuCurso.getMenorNota(), meuCurso.getMedia());
		interacao.mensagem(sobreNotas);
	}
}
