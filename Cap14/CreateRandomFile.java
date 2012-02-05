import java.io.IOException;
import java.io.RandomAccessFile;			//Recebe o arquivo de acesso RandomAccessFile

public class CreateRandomFile
{
	private static final int NUMERO_DE_REGISTROS = 100;
	
	/**
	 * main para testar a classe
	 * @param args
	 */
	public static void main( String args[] )
	{
		CreateRandomFile aplicacao = new CreateRandomFile();
		aplicacao.createFile();
	}
	
	/*
	 *  cria um arquivo de acesso Random
	 *  	que tem como base o ClassSerializable
	 */
	public void createFile()
	{
		RandomAccessFile file = null;
		
		try
		{	
			/*
			 * file é o arquivo. Recebe onde está o arquivo e o modo
			 * que ele será aberto.
			 */
			file = new RandomAccessFile("Cap14/random.dat", "rw");
			
			ClassDeAcessoRandom registros = new ClassDeAcessoRandom();
			
			for( int cont = 0; cont < NUMERO_DE_REGISTROS; cont++)
			{
				/*
				 * Manda como parametro onde ele será gravado 
				 */
				registros.write( file );
			}
			
			System.out.println("Criou-se o arquivo random.dat");
			System.exit(0);
		}
		catch( IOException io)
		{
			System.err.println("Erro de processamento do arquivo");
			System.exit(1);
		}
		finally
		{
			try
			{
				if( file != null)
				{
					file.close();
				}
			}
			catch( IOException io)
			{
				System.err.println("Erro ao fechar o arquivo");
				System.exit(1);
			}
		}
	}


}
