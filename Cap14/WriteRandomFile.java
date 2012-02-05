import java.io.IOException;						//Exceção de I/O
import java.io.RandomAccessFile;				//Arquivo de Acesso/Gravação randômica
import java.util.NoSuchElementException;		//Exceção de erro no tipo de elemento lido/gravado
import java.util.Scanner;

public class WriteRandomFile
{
	private RandomAccessFile saida;
	private static final int NUMERO_DE_REGISTROS = 100;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		WriteRandomFile aplicacao = new WriteRandomFile();
		aplicacao.openFile();
		aplicacao.lerGravar();
		aplicacao.closeFile();

	}
	
	/**
	 * Abre o arquivo em que vai ser escrito
	 * 	os valores lidos
	 */
	public void openFile()
	{
		try
		{
			saida = new RandomAccessFile("Cap14/random.dat", "rw");
		}
		catch( IOException ioException)
		{
			System.err.println("O arquivo não pode ser aberto");
		}
		
	}
	
	/**
	 * Fecha o arquivo o trata o erro e do arquivo
	 */
	public void closeFile()
	{
		try
		{
			if( saida != null )
			{
				saida.close();
			}
		}
		catch( IOException io)
		{
			System.err.println("Erro ao fechar o arquivo");
		}
	}
	
	
	/**
	 * Faz a leitura de informações que serão armazenadas 
	 * 	em classes de registros.e esta será armazenda segundo
	 * 	a sua posição dentro do arquivo criada no openFile()
	 */
	public void lerGravar()
	{
		ClassDeAcessoRandom registros = new ClassDeAcessoRandom();
		
		int numeroDaConta = 0;
		String nome = null;
		String sobreNome = null;
		double valor;
		
		Scanner scan = new Scanner( System.in );
		
		System.out.printf("%s %s\n%s", "Entre com o numero da conta (0-100),","O nome, sobre nome e valor","?");
		
		while( scan.hasNext() )
		{
			try
			{
				/*
				 * Faz leitura dos valores
				 */
				numeroDaConta = scan.nextInt();
				nome = scan.next();
				sobreNome = scan.next();
				valor = scan.nextDouble();
				
				if( numeroDaConta > 0 && numeroDaConta < NUMERO_DE_REGISTROS )
				{
					registros.setConta( numeroDaConta );
					registros.setNome( nome );
					registros.setSobreNome(sobreNome);
					registros.setValor(valor);
					
					/*
					 * "seek" recebe um inteiro que será o local para onde apontará
					 *  a próxima gravação
					 *  "write" escreve seus valores na posicao em que seek está
					 *  apontando.
					 */
					saida.seek( (numeroDaConta - 1) * ClassDeAcessoRandom.SIZE );
					registros.write( saida );
				}
				else
				{
					System.out.println("Conta fora do perimetro");
				}
			}
			catch( IOException ioE)
			{
				System.err.println("Erro ao escrever no arquivo");
				return;
			}
			catch( NoSuchElementException noSuch)
			{
				System.err.println("Invalida entrada");
			}
			
			System.out.printf("%s %s\n%s", "Entre com a conta(0-100),","nome, sobreNome e valor","?");
		}
	}

}
