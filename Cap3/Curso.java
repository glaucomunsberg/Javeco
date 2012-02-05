/** Livro
 * 		Classe que possui estrutura para um curso que está sendo
 * 			montado. Possue informações como Nome, Numero de Alunos
 * @author glaucoroberto
 *
 */
//import java.text.SimpleDateFormat; //Data de forma simples

public class Curso 
{
	boolean chkMaximoDeAlunos = false;				//Faz com que apenas uma vez seja fixado o tamanho máximo do curso
	
	private String cursoNome;
	private int numAlunos;
	private String objetivo;
	private String[] gradeNomes;
	private int[] gradeNotas;
	private int[] gradeConceitos;
	private String nomeProfessor;
	private int numMaxDeAluno;
	
	Dialogo interacao = new Dialogo();
	Time inicioCurso = new Time();
	Time finalCurso = new Time();
	
	/**
	 * Inicia o curso como os seguintes dados:
	 * 
	 * @param String nomeDoCurso
	 * @param String objetivoCurso
	 * @param int numAlunos
	 * @param int numMaxDeAluno
	 * @param String nomePorfessor
	 * @param String gradeNomes
	 * @param int gradeNotas
	 * @param int gradeConceitos
	 */
	public Curso( String nomeDoCurso, String objetivoCurso ,int numAlunos, int numMaxDeAluno, String nomeProfessor, String[] gradeNomes, int[] gradeNotas, int[] gradeConceitos)
	{
		setNomeCurso( nomeDoCurso );
		setNumeroDeAlunos( numAlunos );
		setObjetivo( objetivoCurso );
		setNomeProfessor( nomeProfessor );
		
		if( this.chkMaximoDeAlunos == false )
		{
			setNumeroMaximoDeAluno( numMaxDeAluno );
			this.chkMaximoDeAlunos = true;
		}
		
		setGrades();
		setValoresDoAluno(gradeNomes, gradeNotas, gradeConceitos);
		
	}
	
	/**
	 * Inicia o curso com valores nulos
	 * 		e numero máximo de alunos 10
	 */
	public Curso()
	{
		setNomeCurso("curso");
		setObjetivo("indefinido");
		
		if( this.chkMaximoDeAlunos == false )
		{
			setNumeroMaximoDeAluno(10);
			this.chkMaximoDeAlunos = true;
		}
		
		setGrades();
	}
	
	/**
	 * de uso protegido para que seja criado apenas uma vez as constantes
	 */
	protected void setGrades()
	{
		gradeNomes 		= new String[ this.getNumeroMaximoDeAluno() ];
		gradeNotas 		= new int[ this.getNumeroMaximoDeAluno() ];
		gradeConceitos 	= new int[ this.getNumeroMaximoDeAluno() ];
	}
	/**
	 * Insere o nome do curso
	 * @param String nome
	 */
	public void setNomeCurso(String nome)
	{
		cursoNome = nome;
		System.out.printf("Modificado o nome do curso %s\n", inicioCurso.getHoraAtual());
	}
	
	/**
	 * Modifica o objetivo do curso
	 * @param String novoObjetivo
	 */
	public void setObjetivo( String novoObjetivo)
	{
		this.objetivo = novoObjetivo;
		System.out.printf("Modificado o objetivo do curso %s\n", inicioCurso.getHoraAtual());
	}
	
	/**
	 * Trás o nome do curso
	 * @return objetivo
	 */
	public String getObjetivo()
	{
		return objetivo;
	}
	
	/**
	 *  Retorna a data do início do curso
	 * @return String data
	 */
	public String getInicioCurso()
	{
		
		return inicioCurso.getDate();
	}

	/**
	 *  Recebe o novo início do curso
	 *  em forma de string ss/mm/hh/dd/MM/AAAA
	 * @param novoInicio
	 */
	public void setInicioCurso( String novoInicio)
	{
		inicioCurso.setTimeOfString(novoInicio);
		System.out.printf("Modificado o início do curso %s\n", inicioCurso.getHoraAtual());
	}
	
	/**
	 * Retorna a hora do final do curso
	 * em forma de dd/MM/aaaa 
	 * @return String hora
	 */
	public String getFinalCurso()
	{
		return finalCurso.getDate();
	}

	/**
	 * Seta o final do curso recebendo uma
	 * 	string com ss/mm/hh/dd/MM/AAAA
	 */
	public void setFinalCurso(String novoFim)
	{
		
		finalCurso.setTimeOfString(novoFim);
	}

	/**
	 * retorna o nome do curso
	 * @return String
	 */
	public String getNomeCurso()
	{
		// Retorna o nome do Curso
		return cursoNome;
	}
	
	/**
	 * Insere o novo numero de alunos
	 * @param valor
	 */
	public void setNumeroDeAlunos(int valor)
	{
		numAlunos = valor;
		System.out.printf("Modificado o Número de alunos %s\n", inicioCurso.getHoraAtual());
	}

	/**
	 * Retorna o número de alunos
	 * @return int
	 */
	public int getNumeroDeAlunos()
	{
		return numAlunos;
	}
	
	/**
	 * adiciona um novo nome para o aluno
	 * @param nome
	 * @param posicao
	 */
	public void setNomeAluno(String nome, int posicao)
	{
		if( (posicao > numAlunos) || posicao < 0 )
		{
			System.out.printf("Posição %d incorreta", posicao);
		}
		else
		{
			gradeNomes[posicao] = nome;
		}
	}
	
	/**
	 * Recebe por parametro um array de nomes e notas dos alunos
	 * @param nomes
	 * @param notas
	 */
	private void setValoresDoAluno(String[] nomes, int[]notas, int[]conceitos)
	{
		if( nomes.length > 0 && notas.length > 0)
		{
			for(int a=0; a < nomes.length || a < numMaxDeAluno; a++)
			{
				gradeNomes[a] = nomes[a];
				gradeNotas[a] = notas[a];
				gradeConceitos[a] = conceitos[a];
			}
		}
	}
	
	/**
	 * retorna o nome do aluno segundo a posicao
	 * @param posicao
	 * @return String
	 */
	public String getNomeAluno( int posicao)
	{
		return gradeNomes[posicao];
	}
	
	/**
	 * atribui o valor máximo de alunos que pode haver
	 * @param novoValor
	 */
	public void setNumeroMaximoDeAluno( int novoValor)
	{
		if( this.chkMaximoDeAlunos == false)
		{
			numMaxDeAluno = novoValor;
		}
		
	}
	
	/**
	 * retorna o número máximo de alunos que pode
	 * 		haver no curso.
	 * @return
	 */
	public int getNumeroMaximoDeAluno()
	{
		return numMaxDeAluno;
	}
	
	/**
	 * método responsável por inserir um novo conceito
	 * 	para uma posicao específica.
	 * 
	 * @param posicao
	 * @param novoConceito
	 */
	public void setConceito(int posicao, int novoConceito)
	{
		gradeConceitos[posicao] = novoConceito;
	}
	
	/**
	 * retorna o conceito da posicao que recebe
	 * @param posicao
	 * @return conceito
	 */
	public int getConceito(int posicao)
	{
		return gradeConceitos[posicao];
	}
	
	/**
	 * Insere o novo nome do professor
	 * @param novoNome
	 */
	private void setNomeProfessor(String novoNome)
	{
		this.nomeProfessor = novoNome;
	}

	/**
	 * Retorna o nome do professor
	 * @return nomeProfessor
	 */
	public String getNomeProfessor()
	{
		return nomeProfessor;
	}
}