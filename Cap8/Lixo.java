/** Lixo
 * 		classe criada para entender como funciona
 * 		coletor de lixo e as "static"
 * @author glaucoroberto
 *
 */
public class Lixo {
	private String nome;
	private String sobreNome;
	private static int contPessoas = 0;
	/*
	 * "Static" faz com que contPessoas seja o mesmo para todos os objetos criados apartir
	 * 		dessa classe. Importante também lembrar que pode ser aplicado a métodos.
	 * Obs.: Pode se "acessar" o identificador e métido static mesmo quando não há objetos
	 * 		ou através de sua classe como "Lixo.contPessoas" e "Lixo.getCont()"
	 */
	
	public Lixo(String nome, String sobreNome)
	{
		this.nome = nome;
		this.sobreNome = sobreNome;
		contPessoas++;
		System.out.printf("Pessoa nasceu!\n"
						+ "Pessoas vivas: %d\n", Lixo.getCont());
		
	}
	
	public static int getCont()
	{
		return contPessoas;
	}
	/**
	 *  printa os valores
	 */
	public void descricao()
	{
		 System.out.printf("Nome     : %s\n" +
			   "SobreNome: %s\n" +
			   "N de Pess: %d\n", nome,sobreNome,contPessoas);
	}

	/**
	 * finaliza o objeto quando esse for setado como null!
	 */
	protected void finalize()
	{
		contPessoas--;
		System.out.printf("Pessoa aniquilada!\n"
						+ "Pessoas vivas: %d\n", contPessoas);
	}

}
