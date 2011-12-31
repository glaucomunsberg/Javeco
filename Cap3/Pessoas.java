/** Alunos
 * 	Classe que contém todas as informações pertinentes aos alunos
 * @author glaucoroberto
 *
 */

public class Pessoas
{
	static private int numeroDePessoas = 0;
	private String nome;
	private String sobreNome;
	private int idade;
	private int CPF;
	
	protected boolean jaInicializado = false;
	
	public enum Tipo {
		ALUNO, ADMINISTADOR
	}
	
	public Alunos aluno;
	public Administrador administrador;
	Tipo classe;
	
	Pessoas()
	{
		if( jaInicializado == false)
		{
			jaInicializado = true;
			numeroDePessoas++;
			
		}
		
	}
	Pessoas(String nome, String sobreNome, int idade, int CPF, int tipo)
	{
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.idade = idade;
		this.CPF = CPF;
		if( tipo == 0)
		{
			classe = Tipo.ALUNO;
			aluno = new Alunos();
		}
		else
		{
			classe = Tipo.ADMINISTADOR;
			administrador = new Administrador();
		}
		
		if( jaInicializado == false)
		{
			jaInicializado = true;
			numeroDePessoas++;
		}
		
	}
	
	public void setInformacoesPessoas(String nome, String sobreNome, int idade, int CPF)
	{
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.idade = idade;
		this.CPF = CPF;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public String getNomeCompleto()
	{
		return nome + " " + sobreNome;
	}

	
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	public void setSobreNome( String sobreNome)
	{
		this.sobreNome = sobreNome;
	}
	
	public void setIdade(int idade)
	{
		this.idade = idade;
	}
	
	public int getIdade()
	{
		return idade;
	}
	
	public int getCPF()
	{
		return this.CPF;
	}
	
	public void setCPF(int CPF)
	{
		this.CPF = CPF;
	}
	public int getPessoas()
	{
		return numeroDePessoas;
	}
	public String getTipo()
	{
		if(classe == Tipo.ADMINISTADOR)
		{
			return "ADMINISTRADOR";
		}
		else
		{
			return "ALUNO";
		}
	}
	public void setTipo(String novoTipo)
	{
		if(novoTipo == "ADMINISTRADOR")
		{
			classe = Tipo.ADMINISTADOR;
		}
		else
		{

			classe = Tipo.ALUNO;
		}
	}
}
