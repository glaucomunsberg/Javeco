import java.io.EOFException;			//EOF ou End of File
import java.io.FileInputStream;			//Abre um arquivo
import java.io.IOException;				//Trata os erros de abertura dos arquivos
import java.io.ObjectInputStream;		//Recebe um objeto de um arquivo aberto

public class ReadSerializableFile 
{
	private ObjectInputStream entrada;
	
	public void openFile()
	{
		try
		{
			entrada = new ObjectInputStream( new FileInputStream( "Cap14/exemplo.ser"));
		}
		catch( IOException ioException)
		{
			/*
			 * trata erros referentes ao erro de abertura
			 * de arquivos.
			 */
			System.err.println("Erro ao abrir o arquivo");
		}
		
	}
	
	public void readValores()
	{
		ClassSerializable recuperado;
		System.out.printf("%-10s%-12s%-12s%10s\n", "Conta","Primeiro nome", "Sobrenome", "Balanço");
		
		try
		{
			while( true )
			{
				recuperado = ( ClassSerializable ) entrada.readObject();
				System.out.printf("%-10d%-12s%-12s%10.2f\n", recuperado.getConta(), recuperado.getNome(), recuperado.getSobreNome(), recuperado.getValor());
				
			}
		}
		catch( EOFException endOfFileExcepetion)
		{
			/*
			 * encontrou o final do arquivo
			 */
			
			return;
		}
		catch( ClassNotFoundException classNot)
		{
			/*
			 * o objeto referido a cima no try não foi encontrado
			 * dentro do arquivo serializado. 
			 */
			System.err.println("Hablilite a criação do objeto");
			
		}
		catch( IOException ioException)
		{
			/*
			 * erro na leitura do arquivo
			 */
			System.err.println("Erro durante a leitura do arquivo...");
		}
	}
	
	public void closeFile()
	{
			try
			{
				if( entrada != null )
				{
					entrada.close();
				}

			}
			catch(IOException exception)
			{
					System.err.println("Não pode fechar o arquivo. abortando");
					System.exit(1);
			}
	}
}
