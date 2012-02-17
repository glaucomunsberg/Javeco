package Sistema;
import com.glaucoroberto.time.Time;
/** Livro
 * 		Classe que possui estrutura para um curso que está sendo
 * 			montado. Possui todas as informações necessárias do 
 * 			curso, do instrutor, alunos e ainda permite que seja gravado
 * 			em um documento o histórico de ações da classe...
 * @author glaucoroberto
 *
 */

public class CursoBase 
{
	protected boolean chkMaximoDeAlunos = false;				//Faz com que apenas uma vez seja fixado o tamanho máximo do curso
	protected boolean chkInicializacaoLog = false;				//Verifica se já inicializou o sistema de log
	
	protected int numMaxDeAluno;								//Protegido pois se esse modificador for modifcado, pode causar uma inconsistência 
	private int numAlunos;
	private String objetivo;
	private String nomeProfessor;
	private String nomeCurso;
	private String[] gradeNomes;
	private int[] gradeNotas;
	private int[] gradeConceitos;

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
	 * @param String locaDolog
	 */
	public void setCursoBase( String nomeDoCurso, String objetivoCurso ,int numAlunos, int numMaxDeAluno, String nomeProfessor, String[] gradeNomes, int[] gradeNotas, int[] gradeConceitos)
	{
		Log.addLog("Todos os dados estão sendo carregados do default");
		if( this.chkInicializacaoLog == false )
		{	
			this.chkInicializacaoLog = true;
		}
		
		setNomeCurso( nomeDoCurso );
		setNumeroDeAlunos( numAlunos );
		setObjetivo( objetivoCurso );
		setNomeProfessor( nomeProfessor );
		this.setInicioCurso("00/00/00/11/12/2010");
		this.setFinalCurso("00/00/00/12/12/2010");
		
		if( this.chkMaximoDeAlunos == false )
		{
			setNumeroMaximoDeAluno( numMaxDeAluno );
			this.chkMaximoDeAlunos = true;
		}
		
		setGrades();
		setValoresDoAluno(gradeNomes, gradeNotas, gradeConceitos);
		
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
	 * Retorna a hora do final do curso
	 * em forma de dd/MM/aaaa 
	 * @return String hora
	 */
	public String getFinalCurso()
	{
		return finalCurso.getDate();
	}

	/**
	 * retorna o nome do curso
	 * @return String
	 */
	public String getNomeCurso()
	{
		return nomeCurso;
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
	 * retorna a nota do aluno segundo a posicao
	 * @param nota
	 * @param posicao
	 */
	public int getNotaAluno(int posicao) 
	{
		if( posicao <= numAlunos && posicao >= 0)
		{
			return gradeNotas[posicao];
		}
		else
		{
			Log.addLog("Atenção! Posição da nota está fora da faixa.");
			return -999;
		}
		
	}

	/**
	 * retorna o nome do aluno segundo a posicao
	 * @param posicao
	 * @return String
	 */
	public String getNomeAluno( int posicao)
	{
		if( posicao <= numAlunos && posicao >= 0  )
		{
			return gradeNomes[posicao];
		}
		else
		{
			Log.addLog("Atenção! Posição do nome está fora da faixa.");
			return null;
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
	 * retorna o conceito da posicao que recebe
	 * @param posicao
	 * @return conceito
	 */
	public int getConceitoAluno(int posicao)
	{
		if( posicao <= numAlunos && posicao >= 0)
		{
			return gradeConceitos[posicao];
		}
		else
		{
			Log.addLog("Atenção! A posição do conceito está fora da faixa.");
			return -1;
		}
		
	}

	/**
	 * Retorna o nome do professor
	 * @return nomeProfessor
	 */
	public String getNomeProfessor()
	{
		return nomeProfessor;
	}

	
	/**
	 * Retorna uma String[] de nomes
	 * @return String[] gradeNomes
	 */
	public String[] getTodosNomeDeAlunos()
	{
		return gradeNomes;
	}
	
	/**
	 * Retorna uma int[] de notas
	 * @return int[] gradenotas
	 */
	public int[] getTodasNotasDeAlunos()
	{
		return gradeNotas;
	}
	
	/**
	 * Retorna uma int[] de conceitos
	 * @return int[] gradeconceitos
	 */
	public int[] getTodosConceitosDeAlunos()
	{
		return gradeConceitos;
	}
	
	
	public int getPorcentoDeAlunosNoCurso()
	{
		double valor = 0;
		try
		{
			valor = ( this.numAlunos * 100)/ this.numMaxDeAluno;
		}
		catch(ArithmeticException aritmeticExcepetion)
		{
			Log.addLog("Atenção! Erro aritmético encontrado. Porcentagem de alunos será 0.");
			valor = 0;
		}
		
		return (int) Math.round(valor);
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
		nomeCurso = nome;
		Log.addLog("Modificado o nome do curso.");
	}
	
	/**
	 * Modifica o objetivo do curso
	 * @param String novoObjetivo
	 */
	public void setObjetivo( String novoObjetivo)
	{
		this.objetivo = novoObjetivo;
		Log.addLog("Modificado o objetivo do curso.");
	}
	
	/**
	 *  Recebe o novo início do curso
	 *  em forma de string ss/mm/hh/dd/MM/AAAA
	 * @param novoInicio
	 */
	public void setInicioCurso( String novoInicio)
	{
		inicioCurso.setTimeOfString(novoInicio);
		Log.addLog("Modificado o data do início do curso.");
	}
	
	/**
	 * Seta o final do curso recebendo uma
	 * 	string com ss/mm/hh/dd/MM/AAAA
	 */
	public void setFinalCurso(String novoFim)
	{
		
		finalCurso.setTimeOfString(novoFim);
		Log.addLog("Modificado o data do fim do curso.");
	}

	/**
	 * Insere o novo numero de alunos
	 * @param valor
	 */
	public void setNumeroDeAlunos(int valor)
	{
		numAlunos = valor;
		Log.addLog("Modificado o número máximo de alunos");
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
			Log.addLog("Atençã! A posição do nome do aluno não foi encontrada.");
		}
		else
		{
			gradeNomes[posicao] = nome;
			Log.addLog("Modificado o nome do aluno");
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
				setNomeAluno(nomes[a], a);
				setNotaAluno(notas[0], a);
				setConceitoAluno(conceitos[a], a);
			}
		}
		Log.addLog("Foram inseridos todos os alunos da lista na grade");
	}
	
	/**
	 * Insere o conceito do aluno segundo a posicao
	 * dele 
	 * @param conceito
	 * @param posicao
	 */
	public void setConceitoAluno(int conceito, int posicao) 
	{
		if( posicao <= numAlunos && posicao >= 0)
		{
			if( conceito < 0)
			{
				conceito = 0;
			}
			if( conceito > 3)
			{
				conceito = 3;
			}
			gradeConceitos[posicao] = conceito;
			Log.addLog("Modificado a nota de um aluno");
		}
		else
		{
			Log.addLog("Atenção! Posição do conceito está fora da faixa.");
		}
		
	}

	/**
	 * Insere a informação do aluno
	 * @param nota
	 * @param posicao
	 */
	public void setNotaAluno(int nota, int posicao) 
	{
		if( posicao <= numAlunos && posicao >= 0)
		{
			gradeNotas[posicao] = nota;
			Log.addLog("Modificado a nota de um aluno");
		}
		else
		{
			Log.addLog("Atenção! Posição da nota está fora da faixa.");
		}
		
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
			Log.addLog("Modificado o máximo do alunos do curso.");
		}
		else
		{
			Log.addLog("Atenção! Não se pode modificar o máximo de alunos, pois este já foi inserido antes.");
		}
		
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
		if( posicao <= numAlunos && posicao >= 0 )
		{
			gradeConceitos[posicao] = novoConceito;
			Log.addLog("Modificado o conceito do aluno.");
		}
		else
		{
			Log.addLog("Atenção! O conceito do aluno não pode ser modificado, pois está fora da faixa.");
		}
	}
	
	/**
	 * Insere o novo nome do professor
	 * @param novoNome
	 */
	public void setNomeProfessor(String novoNome)
	{
		this.nomeProfessor = novoNome;
		Log.addLog("Modificado o nome do Instrutor.");
	}
	
	/**
	 *  Insere um novo aluno no curso desde que não estoure
	 *  	o tamanho máximo de alunos
	 * @param nome
	 * @param nota
	 * @param conceito
	 */
	public void setNovoAluno(String nome, int nota, int conceito)
	{
		if( numAlunos + 1 <= numMaxDeAluno)
		{
			setNumeroDeAlunos( numAlunos + 1);
			
			setNomeAluno(nome, numAlunos);
			setNotaAluno(nota, numAlunos);
			setConceitoAluno(conceito, numAlunos);
			
			Log.addLog("Inserido novo aluno.");
		}
		else
		{
			Log.addLog("Atenção! Não pode ser inserir novo aluno por ter atingido o máximo permitido.");
		}
	}
	
	/**
	 * Remove um aluno desde que esse tenha uma posicao
	 * 	valida
	 * @param posicao
	 */
	public void removeAluno(int posicao)
	{
		if( posicao >= 0 && posicao <= numAlunos )
		{
			if( posicao > 0)	//Caso seja unico aluno, então não se copia
								//apenas ignora
			{
				for( int a = posicao; a < numAlunos; a++)
				{
					gradeNomes[ posicao ] = gradeNomes[ posicao+1 ];
					gradeNotas[ posicao ] = gradeNotas[ posicao+1 ];
					gradeConceitos[ posicao ] = gradeConceitos[ posicao+1 ];
				}

			}
			setNumeroDeAlunos( numAlunos-1);
			Log.addLog("Aluno foi removido.");
		}
		else
		{
			Log.addLog("Atenção! Não pode se remover o aluno, pois ele está fora da faixa");
		}
	}
	
}