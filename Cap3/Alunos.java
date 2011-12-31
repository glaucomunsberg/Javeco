public class Alunos 
{
	static private int numeroDeAlunos = 0;
	private int numeroDeFaltas;
	private int notas[] = new int[4];
	private int matricula;
	protected boolean AlunoIncializado = false;
	
	public enum Status { ATIVO, DESVINCULADO}
	private Status situacao;
	
	public Alunos()
	{
		if( AlunoIncializado ==  false)
		{
			AlunoIncializado = true;
			numeroDeAlunos++;
		}
	}
	
	public Alunos( int matricula, int AlunoSitucao)
	{

		if( AlunoIncializado == false)
		{
			AlunoIncializado = true;
			numeroDeAlunos++;
		}
		
		this.matricula = matricula;
		
		if( AlunoSitucao != 0)
		{
			situacao = Status.ATIVO;
		}
		else
		{
			situacao = Status.DESVINCULADO;
		}
		this.matricula = matricula;
	}

	
	public void setNumeroDeMatricula( int matricula)
	{
		this.matricula = matricula;
	}
	
	public int getNumeroDeMatricula()
	{
		return matricula;
	}
	
	public void setNumeroDeCPFFaltas(int faltas)
	{
		numeroDeFaltas = faltas;
	}
	
	public int getNumeroDeFaltas()
	{
		return this.numeroDeFaltas;
	}
	
	public int alunos()
	{
		return numeroDeAlunos;
	}
	
	public void mudarSituacao()
	{
		if( situacao == Status.ATIVO)
		{
			situacao = Status.DESVINCULADO;
		}
		else
		{
			situacao = Status.ATIVO;
		}
		
	}
	
	public int getNota(int posicao)
	{
		if( posicao >= 0 && posicao < notas.length )
		{
			return notas[posicao];
		}
		else
		{
			System.out.printf("Atenção nota de aluno não retornado");
			return 0;
		}
	}
	
	public void setNota( int posicao, int nota )
	{
		if( posicao >= 0 && posicao < notas.length )
		{
			notas[posicao] = nota;
		}
		else
		{
			System.out.printf("Atenção nota de aluno não retornado");
		}
	}
	
	protected int getMedia()
	{
		int valor=0;
		for(int nota: notas)
			valor += nota;
		return valor;
	}
	
	public int getMatricula()
	{
		return matricula;
	}
	
	public void setMatricula(int matricula)
	{
		if( this.matricula != matricula)
		{
			this.matricula = matricula;
		}
	}
}
