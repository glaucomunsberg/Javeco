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
	
	Pessoas()
	{
		if( jaInicializado == false)
		{
			jaInicializado = true;
			numeroDePessoas++;
			
		}
		
	}
	Pessoas(String nome, String sobreNome, int idade, int CPF)
	{
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.idade = idade;
		this.CPF = CPF;
		
		if( jaInicializado == false)
		{
			jaInicializado = true;
			numeroDePessoas++;
		}
		
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
}
