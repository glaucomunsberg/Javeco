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
	
	Time nascimento = new Time();
	
	Pessoas()
	{
		if( jaInicializado == false)
		{
			jaInicializado = true;
			numeroDePessoas++;
			
		}
		System.out.printf("Objeto pessoas inicializado.\n");
		
	}
	
	Pessoas(String nome, String sobreNome, int idade, int CPF, String[] nascimento)
	{
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.idade = idade;
		this.CPF = CPF;
		this.nascimento.setOnlyDate( Integer.parseInt(nascimento[0]), Integer.parseInt(nascimento[1]), Integer.parseInt(nascimento[2]));
		
		if( jaInicializado == false)
		{
			jaInicializado = true;
			numeroDePessoas++;
		}
		System.out.printf("Objeto Pessoa inicializado com dados.\n");
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
		System.out.printf("Nome da pessoa foi modificado.\n");
	}
	
	public void setSobreNome( String sobreNome)
	{
		this.sobreNome = sobreNome;
		System.out.printf("SobreNome da pessoa foi modificado.\n");
	}
	
	public String getSobreNome()
	{
		return sobreNome;
	}
	
	public void setIdade(int idade)
	{
		this.idade = idade;
		System.out.printf("Idade da pessoa foi modificada.\n");
	}
	
	/** getIdade
	 * 		retorna a idade da pessoa, caso a idade seja zero
	 * 		então é feito um calculo segundo da data de nascimento
	 * 		e o ano atual. se idade <= 0 retorna 0.
	 * @return idade
	 */
	public int getIdade()
	{
		if( idade == 0)
		{
			String[] nascimento = new String[3]; 								//String de 3 posicao
			nascimento = getDataNacimento(); 									//Recebe o nascimento dia,mes,ano
			int intAnoAtual = this.nascimento.getAnoAtual();					//pega o Ano atual
			int intAnoNascimento = Integer.parseInt(nascimento[2]);				//pega o Ano de nascimento e converte para int
			if( intAnoNascimento >= 0 && intAnoNascimento <= intAnoAtual)		// Se o ano de nascimento é maior que zero e nascimento é menor que o corrente, então
																				// permite fazer o calculo segundo nascimento e ano atual
			{
				
				int intMesAtual = this.nascimento.getMesAtual();
				int intMesNascimento = Integer.parseInt(nascimento[1]);
				if( intMesAtual < intMesNascimento )							//Se o mes atual é menor que do nascimento, ainda não fez aniversário e logo tem não completo
																				//a idade e será diminuido
				{
					return intAnoAtual - intAnoNascimento - 1;
				}
				else
				{
					return intAnoAtual - intAnoNascimento;						//Caso tenha feito aniversário retorna a idade que é a ano atual menos a de nascimento.
				}
			}
		}
		return idade;
	}
	
	public int getCPF()
	{
		return this.CPF;
	}
	
	public void setCPF(int CPF)
	{
		if( CPF > 0)
		{
			this.CPF = CPF;
			System.out.printf("CPF da pessoa foi modificado\n");
		}
		else
		{
			System.out.printf("CPF da pessoa não foi modificado\n");
		}
		
	}
	
	/** getPessoas
	 * 		retorna o numero de objetos Pessoas inicializadas
	 * 
	 * @return numeroDePessoas
	 */
	public int getPessoas()
	{
		return numeroDePessoas;
	}
	
	/** SetDataNacimento
	 * 		insere a data de nascimento através de uma
	 * 		string de três posições DD/MM/AAAA
	 * @param nascimento[3]
	 */
	public void setDataNacimento( String[] nascimento)
	{
		this.nascimento.setOnlyDate( Integer.parseInt(nascimento[0]), Integer.parseInt(nascimento[1]), Integer.parseInt(nascimento[2]));
	}
	
	public String[] getDataNacimento()
	{
		String[] retorno = new String[3];
		retorno = nascimento.getOnlyDate();
		return retorno;
	}
	
	public String toString()
	{
		String[] nasci = new String[3];
		nasci = getDataNacimento();
		return String.format("A pessoa '%s' nasceu %s/%s/%s tem %d anos. E seu CPF é %d" , getNomeCompleto(), nasci[0], nasci[1], nasci[2], getIdade(), CPF );
	}
}
