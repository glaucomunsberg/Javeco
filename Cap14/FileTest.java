/** FileTest
 * 	Testa:
 * 			ReadTextFile 			e CreatTextFile
 * 			CreateSerializableFile	e ReadSerializableFile
 */

import java.util.Scanner;
public class FileTest 
{
	public static void main( String args[])
	{
		
		Scanner scan = new Scanner( System.in);
		
		int tipo;
		int escolha;
		
		System.out.println("1.File\n2.Seriados\n");
		tipo = scan.nextInt();
		//ARQUIVO SEQUENCIAL
		if( tipo == 1)
		{
			
			System.out.printf("MANIPULAR ARQUIVOS SEQUENCIAIS\n1. Escrever no arquivo\n2. Ler o arquivo");
			escolha = scan.nextInt();
			if( escolha == 1 )
			{
				CreateTextFile file = new CreateTextFile();
				file.openFile(null);
				file.addRecords();
				file.closeFile();
			}
			else
			{
				ReadTextFile file = new ReadTextFile();
				file.openFile("Cap14/arquivoDeTexto.txt");
				file.readFile();
				file.close();
			}
		}
		
		//ARQUIVO SERIALIZADO
		if( tipo == 2)
		{
			System.out.printf("MANIPULAR ARQUIVO SERIALIZADO\n1. Escrever serializado\n2. Ler serializado");
			escolha = scan.nextInt();
			{
				if( escolha == 1)
				{
					CreateSerializableFile serializable = new CreateSerializableFile();
					serializable.openFileSerializable();
					serializable.addInfOnFile();
					serializable.closeFile();
					
				}
			}
		}
	}
}
