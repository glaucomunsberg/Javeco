/** Livro
 * 		Classe que possui estrutura para um curso que está sendo
 * 			montado. Possue informações como Nome, Numero de Alunos
 * @author glaucoroberto
 *
 */
//import java.text.SimpleDateFormat; //Data de forma simples

public class Curso 
{
	private String cursoNome; // contém o nome do curso
	private int numAlunos;
	private String objetivo;
	
	
	int gradeNotas[];
	String gradeNomes[];
	
	Dialogo interacao = new Dialogo();
	Time inicioCurso = new Time();
	Time finalCurso = new Time();
	
	public Curso( String nome, int alunos,int gradeArray[], String nomes[])
	{
		cursoNome = nome; 
		numAlunos = alunos;
		gradeNotas = gradeArray; //Array com notas
		gradeNomes = nomes;
		System.out.printf("Criado o objeto Curso %s\n", inicioCurso.getHoraAtual());
	}

	public void setNomeCurso(String nome)
	{
		// Insere o nome do curso
		cursoNome = nome;
		System.out.printf("Modificado o nome do curso %s\n", inicioCurso.getHoraAtual());
	}
	
	public void setObjetivo( String novoObjetivo)
	{
		this.objetivo = novoObjetivo;
		System.out.printf("Modificado o objetivo do curso %s\n", inicioCurso.getHoraAtual());
	}
	
	public String getObjetivo()
	{
		return objetivo;
	}
	
	public String getInicioCurso()
	{
		
		return inicioCurso.getDate();
	}

	public void setInicioCurso( String novoInicio)
	{
		inicioCurso.setTimeOfString(novoInicio);
		System.out.printf("Modificado o início do curso %s\n", inicioCurso.getHoraAtual());
	}

	public String getFinalCurso()
	{
		return finalCurso.getDate();
	}

	public void setFinalCurso(String novoFim)
	{
		
		finalCurso.setTimeOfString(novoFim);
	}

	public String getNomeCurso()
	{
		// Retorna o nome do Curso
		return cursoNome;
	}

	public void setNumeroDeAlunos(int valor)
	{
		numAlunos = valor;
		System.out.printf("Modificado o Número de alunos %s\n", inicioCurso.getHoraAtual());
	}

	public int getNumeroDeAlunos()
	{
		return numAlunos;
	}

	public void setNotas( int Array[])
	{
		gradeNotas = Array;
		System.out.printf("Modificado todas as notas %s\n", inicioCurso.getHoraAtual());
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
				System.out.printf("Modificada a nota %d por %d. %s\n", gradeNotas[posicao],valor, inicioCurso.getHoraAtual());
				gradeNotas[posicao] = valor;
			}
		}
	}
	
	public void setNomes( String novosNomes[] )
	{
		gradeNomes = novosNomes;
		System.out.printf("Modificado todas os nomes %s\n", inicioCurso.getHoraAtual());
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
			System.out.printf("Atenção! Não foi foi retornado nenhum nome %s\n", inicioCurso.getHoraAtual());
			return null;
		}
	}


}