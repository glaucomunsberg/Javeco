import java.io.IOException;			//Trata eventos ligados a Entrada e saída do programa
import java.io.RandomAccessFile;	//Importa a capacidade de acesso Rondomico

public class ClassDeAcessoRandom extends ClassSerializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -294535674580762227L;
	/**
	 * a soma de um int(4byte) e dois char[15] (total 60 byte) e um double(8byte)
	 */
	public static final int SIZE = 72;
	
	/**
	 * Construtor nulo
	 */
	public ClassDeAcessoRandom()
	{
		this(0,"","",0.0);			//Se não for passados valores inicia o super zerado
	}
	
	/**
	 * Construtor
	 * @param conta - int
	 * @param nome	- String
	 * @param sobreNome - String
	 * @param balanco	- Double
	 */
	public ClassDeAcessoRandom(int conta, String nome, String sobreNome, double balanco)
	{
		super(conta, nome, sobreNome, balanco);
	}
	
	/**
	 * Read lê um registro no RondomFile neste 
	 * caso invoca o readInt e readDouble
	 * e seu método de readNome que será chamado
	 * 2 vezes
	 * @param file
	 * @throws IOException
	 */
	public void read(RandomAccessFile file ) throws IOException
	{
		setConta( file.readInt() );
		setNome( readNome( file ) );
		setSobreNome( readNome( file ) );
		setValor( file.readDouble() );
	}
	
	/**
	 *  lê do RandomFile 15char's
	 * @param file
	 * @return
	 * @throws IOException
	 */
	private String readNome( RandomAccessFile file ) throws IOException
	{
		char nome[] = new char[15];		//Cria-se um array de 15 char
		char temp;
		
		/*
		 * enquanto menor que 15 vai puxar o próximos char
		 */
		for( int cont = 0; cont < nome.length; cont++ )
		{
			temp = file.readChar();	//readChar vai ler o próximo char
			nome[cont] = temp;
		}
		return new String( nome ).replace('\0', ' '); //Caso acha um valor "null" como resposta ele será substituido por espaço
		
	}
	
	/**
	 * O método write escreve em um arquivo os valores passado para ele
	 * 
	 * @param file
	 * @throws IOException
	 */
	public void write( RandomAccessFile file ) throws IOException
	{
		file.writeInt( getConta() );
		writeNome( file, getNome() );
		writeNome( file, getSobreNome() );
		file.writeDouble( getValor() );
	}
	
	/**
	 *  Metodo responsável pela gravação de informações do
	 *  tipo char
	 * @param RandoAccessFile file
	 * @param String nome
	 * @throws IOException
	 */
	private void writeNome( RandomAccessFile file, String nome) throws IOException
	{
		/**
		 * importante lembrar que STRINGBUFFER é um modo de se manipular
		 * 	uma string. nela se pode por acaso controlar o seu tamanho
		 * 	nesse caso o seu tamanho é de 15.
		 */
		StringBuffer buffer = null;	
		if( nome != null )
		{
			buffer = new StringBuffer( nome );
		}
		else
		{
			buffer = new StringBuffer(15);
		}
		
		buffer.setLength(15);					//fixa o tamanho em 15chars de comprimento
		file.writeChars( buffer.toString() );	//é feito a gravação de chars
	}
}

