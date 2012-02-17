/** ClassSerializable é demostra como
 * 		uma classe pode ser serializado o que
 * 		permite que esse seja salvo e recuperado
 * 		posteriormente.
 * 	Obs.: Serailizable NÂO possui nenhum método
 * 		próprio, apenas "marca" que essa classe
 * 		pode ser serializada.
 */
import java.io.Serializable;
//Serialisable "marcar" a classe como serializável
public class ClassSerializable implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2176291712046110817L;
	private int 	conta;
	private String 	nome;
	private String 	sobreNome;
	private double 	valor;
	
	public ClassSerializable()
	{
		this( 0,"","", 0.0 );	//Inicializa com valores. quando se chama o
								//"this" vai procurar método que se encaixe
		
	}
	
	public ClassSerializable( int conta, String nome, String sobreNome, double valor)
	{
		setConta( conta );
		setNome( nome );
		setSobreNome( sobreNome);
		setValor( valor);
	}
	public void setConta( int conta)
	{
		this.conta = conta;
	}
	
	public void setNome( String nome)
	{
		this.nome = nome;
	}
	
	public void setSobreNome( String sobreNome)
	{
		this.sobreNome = sobreNome;
	}
	
	public void setValor( double valor)
	{
		this.valor = valor;
	}
	
	public int getConta()
	{
		return this.conta;
	}
	
	public String getNome()
	{
		return this.nome;
	}
	
	public String getSobreNome()
	{
		return this.sobreNome;
	}
	
	public double getValor()
	{
		return this.valor;
	}
}
