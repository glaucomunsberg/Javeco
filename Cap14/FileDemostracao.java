/**
 * demostração de como funciona
 * 	a identificação de arquivos e diretórios
 * @author glaucoroberto
 *
 */
import java.io.File;
import java.util.Scanner;
public class FileDemostracao {

	/** main implementação do {@link FileDemostracao}
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner( System.in);
		System.out.println("Insira o nome do diretório ou arquivo" +
				" que te informarei sobre ele:\n");
		sobreFile( scan.next());

	}
	
	/**
	 * sobre
	 * @param arqFile
	 */
	public static void sobreFile(String arqFile)
	{
		File arquivo = new File(arqFile);										//Cria o que receberá o arquivo
		
		if( arquivo.exists() ) 													//Verifica se o arquivo existe
		{
			if( arquivo.isDirectory() )											//Verifica se é diretório
			{
				System.out.println("O arquivo é um diretório\n");
				String diretorios[] = arquivo.list();							//Trás a lista de subDiretórios
				for(String diretorio : diretorios)					
				{
					System.out.printf("%s\n", diretorio);
				}
			}
			else
			{
				if(arquivo.isFile() )											//Verifica se é arquivo		
				{
					System.out.println("O arquivo é um arquivo file");
				}
				else
				{
					System.out.println("O arquivo não é Diretório e nem File, mas existe");
				}
			}
			System.out.printf("Nome:%s\n",arquivo.getName());					//Recupera o getName
			System.out.printf("Path: %s\n",arquivo.getPath());					//Trás seu diretório
			System.out.printf("Parente: %s\n", arquivo.getAbsolutePath());		//Trás o Diretório raiz até o arquivo

		}
		else
		{
			System.out.printf("O arquivo não existe...");
		}
	}

}
