/**
 * Classe criada para ensina a serializar
 * 	um objeto já capaz de ser serializado
 * 	para isso ele precisa ser "implements Serializable"
 */

import java.io.FileOutputStream;			//Responsável pelo arquivo serializado
import java.io.IOException;					//Trata a exceção de entra e saida
import java.io.ObjectOutputStream;			//Objeto para saida
import java.util.NoSuchElementException;	//Trata a exceção de elemento errado
import java.util.Scanner;
public class CreateSerializableFile 
{
	ObjectOutputStream saida;
	
	public void openFileSerializable()
	{
		try
		{
			saida = new ObjectOutputStream( 						//Objeto de sainda
					new FileOutputStream("Cap14/exemplo.ser"));		//Arquivo de saida
		}
		catch( IOException ioException)
		{
			System.err.println("Erro ao abrir o arquivo");
			System.exit(1);
		}
		
	}
	
	public void addInfOnFile()
	{
		ClassSerializable serializable;								//A Classe implements Serializable
		
		int conta;				//Temporários
		String nome;
		String sobreNome;
		double valor;
		
		Scanner scan = new Scanner( System.in);
		System.out.println("Insira a (int)Conta, (String)Nome, SobreNome, (double)saldo da conta");
		
		while( scan.hasNext())
		{
			try
			{
				//Leitura dos dados para o objetos
				conta = scan.nextInt();
				nome = scan.next();
				sobreNome = scan.next();
				valor = scan.nextDouble();
				
				if( conta > 0)
				{
					serializable = new ClassSerializable(conta, nome,sobreNome, valor);		//Inicializa o objeto
					saida.writeObject(serializable);										//O objeto saida recebe a classe para sair o objeto
					saida.flush();															//"flush()" garante que a gravação será imediata!
				}
				else
				{
					System.out.println("A conta precisa ser maior que zero");
				}
			}
			catch(IOException ioException)
			{
				/*
				 * trata a exceção de erro de I/O
				 */
				System.err.println("Erro ao escrever");
				return;
			}
			catch(NoSuchElementException noSuch )
			{
				/*
				 * Trata a exceção de erro de tipos
				 */
				System.err.println("Erro no tipo de dado ao gravar");
				scan.nextLine();
			}
			System.out.println("Insira a Conta, Nome, SobreNome, Valor");
		}
	}
	public void closeFile()
	{
		/*
		 * Responsável pelo fechamento do arquivo
		 */
		try
		{
			if( saida != null)
			{
				saida.close();
			}
		}
		catch(IOException ioException)
		{
			System.err.println("erro ao fechar o arquivo");
			System.exit(1);
		}
	}
	

}
