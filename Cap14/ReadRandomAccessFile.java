import java.io.EOFException;			//Tratamento de End of File
import java.io.IOException;				//Tratamento de execessão de abertura de arquivo
import java.io.RandomAccessFile;		//Responsável pelo acesso Randomico

public class ReadRandomAccessFile
{
	/*
	 *	O acesso randômico é dada pela entrada 
	 */
	private RandomAccessFile doArquivo;
	
	/**
	 * main é a função disponivel para testar a
	 * 		propria classe
	 * @param args
	 */
	public static void main( String args[])
	{
		ReadRandomAccessFile aplicacao = new ReadRandomAccessFile();
		aplicacao.openFile();
		aplicacao.lerArquivo();
		aplicacao.fecharArquivo();
	}
	
	/*
	 *	Responsável pela abertura do arquivo 
	 */
	public void openFile()
	{
		try
		{
			doArquivo = new RandomAccessFile( "Cap14/random.dat", "r");
			
		}
		catch( IOException ioE)
		{
			/*
			 * tratamento de exceção em abertura
			 * 		e fechamento de arquivo
			 */
			System.err.println("File não pode ser aberto");
		}
	}
	
	/**
	 * abre o arquivo random.dat e imprime o conteúdo
	 */
	public void lerArquivo()
	{
		ClassDeAcessoRandom registros = new ClassDeAcessoRandom(); 							//Classe de registros
		System.out.printf("%-10s%-15s%15s%10s\n", "Conta", "Nome", "SobreNome", "Valor");
		
		try
		{
			while( true )
			{
				do
				{
					/*
					 * Faz a leitura do arquivo
					 * faz com que o registro recebe o
					 * o valor lido da classe inserida
					 */
					registros.read( doArquivo );
					
				}while( registros.getConta() == 0);
				
				System.out.printf("%-10d%-12s%-12s%10.2f\n", registros.getConta(), registros.getNome(), registros.getSobreNome(), registros.getValor());
				
			}
		}
		catch( EOFException EOF )
		{
			/*
			 * Quando chega-se ao final do arquivo
			 * 	então essa excessão é criado e sai
			 *  do while
			 */
			
			return;
		}
		catch( IOException ioE)
		{
			System.err.println("Erro na leitura do arquivo");
			System.exit(1);
		}
	}
	
	/*
	 *  Fecha o arquivo que foi aberto. Neste caso
	 *  	testa se não houve problema, caso isso
	 *  	tenha ocorrido então demonstra o erro.
	 */
	public void fecharArquivo()
	{
		try
		{
			if( doArquivo != null)
			{
				doArquivo.close();
			}
		}
		catch( IOException eio)
		{
			System.err.println("Erro ao fechar o arquivo");
		}
	}
}