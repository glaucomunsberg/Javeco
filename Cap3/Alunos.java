public class Alunos extends Pessoas
{
	static private int numeroDeAlunos = 0;
	private int numeroDeFaltas;
	private int notas[] = new int[4];
	private int matricula;
	protected boolean AlunoIncializado = false;
	
	public enum Status { ATIVO, DESCONHECIDO,DESVINCULADO}
	private Status situacao;
	
	public Alunos()
	{
		if( AlunoIncializado ==  false)
		{
			AlunoIncializado = true;
			numeroDeAlunos++;
		}
		System.out.printf("Objeto Alunos criado.\n");
	}
	
	/** Alunos(construtor)
	 * 		inicializa os campos do aluno e Super
	 * 
	 * @param nome
	 * @param sobreNome
	 * @param idade
	 * @param CPF
	 * @param tipo
	 * @param matricula
	 * @param alunoSitucao
	 * @param nascimento [0] dia [1] mes [2] ano
	 */
	public Alunos( String nome, String sobreNome, int idade, int CPF, int tipo, int matricula, Status alunoSitucao, String[] nascimento)
	{
		super(nome, sobreNome, idade, CPF, nascimento);
		
		if( AlunoIncializado == false)
		{
			
			AlunoIncializado = true;
			numeroDeAlunos++;
		}
		
		situacao = alunoSitucao;
		
		this.matricula = matricula;
		System.out.printf("Objeto criado com dados.\n");
	}

	/** SetNumeroDeMatricula
	 * 		modifica a matricula se a nova for diferente
	 * 		de 0
	 * 
	 * @param matricula
	 */
	public void setNumeroDeMatricula( int matricula)
	{
		if(matricula != 0)
		{
			this.matricula = matricula;
			System.out.printf("Aluno teve seu número de matricula modificado.\n");
		}
		System.out.printf("Aluno não teve seu número de matricula modificado.\n");
	}
	
	/** getNumeroDeMatricula
	 * 
	 * @return matricula
	 */
	public int getNumeroDeMatricula()
	{
		return matricula;
	}
	
	/** setNumeroDeFaltas
	 * 		insere o número de faltas do aluno
	 * 		se a mesma for positiva ou zero
	 * 
	 * @param faltas
	 */
	public void setNumeroDeFaltas(int faltas)
	{
		if( faltas >= 0)
		{
			numeroDeFaltas = faltas;
			System.out.printf("Aluno teve suas faltas modificada.\n");
		}
		else
		{
			System.out.printf("Aluno não teve suas faltas modificada.\n");
		}
	}
	
	/** getNumeroDeFaltas
	 * 		retorna as faltas em geral do Aluno
	 * @return
	 */
	public int getNumeroDeFaltas()
	{
		return this.numeroDeFaltas;
	}
	
	/** NumDeAlunos
	 * 		valor static correspondendo
	 * 		ao total de objetos alunos
	 * @return numDeAlunos
	 */
	public int NumDeAlunos()
	{
		return numeroDeAlunos;
	}
	
	/** setSituacao
	 * 		modifica a situacao do aluno
	 * @param novaSituacao
	 */
	public void setSituacao(Status novaSituacao)
	{
		situacao = novaSituacao;
		System.out.printf("Aluno teve sua situacao modificada.\n");
	}
	
	public Status getSituacao()
	{
		return situacao;
	}
	
	public String getToStringSituacao()
	{
		if( situacao == Status.ATIVO)
		{
			return "ATIVO";
		}
		if( situacao == Status.DESCONHECIDO)
		{
			return "DESCONHECIDO";
		}
		if( situacao == Status.DESVINCULADO)
		{
			return "DESVINCULADO";
		}
		return null;
	}
	
	/** getNota
	 * 		retorna a nota da posicao passada
	 * 		como parametro
	 * 
	 * @param posicao
	 * @return notas[posicao]
	 */
	public int getNota(int posicao)
	{
		if( posicao >= 0 && posicao < notas.length )
		{
			return notas[posicao];
		}
		else
		{
			System.out.printf("Atenção nota de aluno não retornado. A posição %d não exite.", posicao);
			return -999;
		}
	}
	
	/** setNota
	 * 		insere a nota no parametro posicao
	 * @param posicao
	 * @param nota
	 */
	public void setNota( int posicao, int nota )
	{
		if( posicao >= 0 && posicao < notas.length )
		{
			notas[posicao] = nota;
			System.out.printf("Nota do Aluno modificada.\n");
		}
		else
		{
			System.out.printf("Atenção nota de aluno não moficada");
		}
	}
	
	/** getMedia
	 * 		faz a média entre todas as notas
	 *
	 * @return media
	 */
	protected double getMedia()
	{
		double valor=0;
		for(int nota: notas)
			valor += nota;
		return valor/notas.length;
	}
	
	public int getMatricula()
	{
		return matricula;
	}
	
	/** setMatricula
	 * 		insere a matricula se essa for diferente
	 * 		da atual ou se a matricula nova for um
	 * 		numero abaixo de 0
	 * 
	 * @param matricula
	 */
	public void setMatricula(int matricula)
	{
		if( this.matricula != matricula || this.matricula <= 0)
		{
			this.matricula = matricula;
		}
	}
	
	/** getAlunos
	 * 		retorna o número de Objetos Alunos inicializados
	 * 
	 * @return numeroDeAlunos
	 */
	public int getAlunos()
	{
		return numeroDeAlunos;
	}
	
	public String toString()
	{
		return String.format("O aluno '%s' com CPF %d, matriculado com o número %d tem média igual a %.2f e está com a situacao %s", this.getNome(), this.getCPF(), this.getMatricula(), this.getMedia(), this.getToStringSituacao());
	}
}
