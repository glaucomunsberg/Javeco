/** Livro
 * 		Classe que possui estrutura para um curso que está sendo
 * 			montado. Possue informações como Nome, Numero de Alunos
 * @author glaucoroberto
 *
 */

public class Curso 
{
	private String cursoNome; // contém o nome do curso
	private int numAlunos;
	private String initCurso;
	private String endCurso;
	int gradeNotas[];
	Dialogo interacao = new Dialogo();
	
	public Curso( String nome, int alunos,int gradeArray[] )
	{
		cursoNome = nome; 
		numAlunos = alunos;
		gradeNotas = gradeArray; //Array com notas
		initCurso = "ss:mm:hh AAAA";
		endCurso = "ss:mm:hh AAAA";
		
	}
	
	public void setNomeCurso(String nome)
	{
		// Insere o nome do curso
		cursoNome = nome;
	}
	
	public String getInicioCurso()
	{
		return initCurso;
	}
	
	public void setInicioCurso( String novoNome)
	{
		initCurso = novoNome;
	}
	
	public String getFinalCurso()
	{
		return endCurso;
	}
	
	public void setFinalCurso(String novoFim)
	{
		endCurso = novoFim;
	}
	
	public String getNomeCurso()
	{
		// Retorna o nome do Curso
		return cursoNome;
	}
	
	public void setNumeroDeAlunos(int valor)
	{
		numAlunos = valor;
	}
	
	public int getNumeroDeAlunos()
	{
		return numAlunos;
	}
	
	public void setNotas( int Array[])
	{
		gradeNotas = Array;
	}

	public int getMenorNota()
	{
		int menor = gradeNotas[0];
		for(int menorDaGrade : gradeNotas)
		{
			if( menorDaGrade < menor)
			{
				menor = menorDaGrade;
			}
		}
		return menor;
	}
	
	public int getMaiorNota()
	{
		int maior = gradeNotas[0];
		for( int maiorDaGrade : gradeNotas)
		{
			if( maiorDaGrade > maior)
			{
				maior = maiorDaGrade;
			}
		}
		return maior;
	}
	
	public double getMedia()
	{
		double media = 0;
		for( int nota: gradeNotas)
		{
			media += nota;
		}
		media /= gradeNotas.length;
		return media;
	}
	public int getNumeroDeNotas()
	{
		return gradeNotas.length;
	}
	public int getNota(int posicao)
	{
		int temp;
		if( posicao >= 0 && posicao <= gradeNotas.length)
		{
			temp = gradeNotas[posicao];
			return temp;
		}
		return 0;
	}
	public void setNota(int posicao, int valor)
	{
		if( posicao >= 0 )
		{
			if( posicao <= gradeNotas.length )
			{
				gradeNotas[posicao] = valor;
			}
		}
	}
	
	public void mensagem()
	{
		// Imprime o nome do curso
		String oQueSeraImprimido = String.format("Bem-Vindo ao curso de \'%s\'. Ele possui %d alunos.", getNomeCurso(), getNumeroDeAlunos() );
		interacao.mensagem(oQueSeraImprimido);
	}

}
