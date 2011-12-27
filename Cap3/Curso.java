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
	private String objetivo;
	
	int gradeNotas[];
	String gradeNomes[];
	
	Dialogo interacao = new Dialogo();

	public Curso( String nome, int alunos,int gradeArray[], String nomes[])
	{
		cursoNome = nome; 
		numAlunos = alunos;
		gradeNotas = gradeArray; //Array com notas
		gradeNomes = nomes;
		initCurso = "ss:mm:hh AAAA";
		endCurso = "ss:mm:hh AAAA";
		System.out.println("Objeto Curso inicializado");

	}

	public void setNomeCurso(String nome)
	{
		cursoNome = nome;
		System.out.println("Nome do Curso modificado");
	}
	
	public void setObjetivo( String novoObjetivo)
	{
		this.objetivo = novoObjetivo;
		System.out.println("Objetivo do Curso modificado");
	}
	
	public String getObjetivo()
	{
		return objetivo;
	}
	
	public String getInicioCurso()
	{
		return initCurso;
	}

	public void setInicioCurso( String novoNome)
	{
		initCurso = novoNome;
		System.out.println("Data de início do curso modificado");
	}

	public String getFinalCurso()
	{
		return endCurso;
	}

	public void setFinalCurso(String novoFim)
	{
		endCurso = novoFim;
		System.out.println("Data de fim do curso modificado");
	}

	public String getNomeCurso()
	{
		// Retorna o nome do Curso
		return cursoNome;
	}

	public void setNumeroDeAlunos(int valor)
	{
		numAlunos = valor;
		System.out.println("Numero de alunos modificados");
	}

	public int getNumeroDeAlunos()
	{
		return numAlunos;
	}

	public void setNotas( int Array[])
	{
		gradeNotas = Array;
		System.out.println("Todas as notas forma modificadas");
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
				System.out.printf("Valor %d inserido na posição %d.\n",posicao,valor);
			}
		}
	}
	
	public void setNomes( String novosNomes[] )
	{
		gradeNomes = novosNomes;
		System.out.println("Todos os nomes forma modificados");
	}
	
	public String getNomes()
	{
		String temp;
		String nomes = "";
		for( int contador = 0; contador < gradeNomes.length; contador++)
		{
			temp = String.format("\n%d - %s",contador,gradeNomes[contador] );
			nomes = nomes + temp;
		}
		return nomes;
	}
	
	public String getNome( int posicao)
	{
		if( posicao >= 0 && posicao <= gradeNotas.length)
		{
			String temp = gradeNomes[posicao];
			return temp;
		}
		else
		{
			System.out.println("Não foi foi retornado nenhum nome.");
			return null;
		}
	}
	public void mensagem()
	{
		// Imprime o nome do curso
		String oQueSeraImprimido = String.format("Bem-Vindo ao curso de \'%s\'. Ele possui %d alunos.", getNomeCurso(), getNumeroDeAlunos() );
		interacao.mensagem(oQueSeraImprimido);
	}

}