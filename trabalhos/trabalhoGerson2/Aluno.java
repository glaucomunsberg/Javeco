package trabalhoGerson2;

public class Aluno implements Nodo
{
	protected String nomeAluno;
	protected int numMatricula;
	
	public Aluno()
	{
		this(" ", 0);
	}
	
	public Aluno(String nomeAluno, int numMatricula)
	{
		this.setIdade(numMatricula);
		this.setNome(nomeAluno);
	}
	
	public String getNome()
	{
		return this.nomeAluno;
	}
	
	public int getMatricula()
	{
		return this.numMatricula;
	}
	
	public void setNome(String nome)
	{
		this.nomeAluno = nome;
	}
	
	public void setIdade(int idade)
	{
		this.numMatricula = idade;
	}
	
	@Override
	public String printNodo() {
		// TODO Auto-generated method stub
		
		return String.format("%d - %s", numMatricula, nomeAluno);
	}

}
