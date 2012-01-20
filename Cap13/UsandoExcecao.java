/**
 * Usando uma exceção com TRY, CACHT E FINALLY
 * 	Cria a exceção e complementa o aprendizado
 * 		do TratamentoDeExcecao.java
 * @author glaucoroberto
 */

public class UsandoExcecao 
{
	public static void main( String args[])
	{
		//Primeiro - abre o código try e esse invoca
		//	o que tem um problema
		try
		{
			throwException();
		}
		//Quinto -  Chamado depois do throwException
		//	lançar um exception
		catch( Exception exception)
		{
			System.err.println("Excecao Handler no main");
		}
		
		//Sexto - apos tratato o evento chama a próxima chamda
		doesNotThrowException();
	}
	
	//Demostração de try...catch e finally
	public static void throwException() throws Exception
	{
		//Segundo - try invocado pelo main
		try
		{
			System.out.println("metodo throwException");
			throw new Exception(); //Cria uma exceção
		}
		//Terceiro - executa por causa da exceção criado no try
		catch( Exception exception)
		{
			System.err.println(
					"Exeção no metodo throwException");
			throw exception;
			
			//Qualquer código aqui não será alcançado
			
		}
		//Quarto - Chamado pelo catch para finalizar
		finally
		{
			System.err.println("Finally exeção");
		}
		
		//Qualquer código aqui não será atingido, exceção lançada no novo catch
	
	}
	
	//demostra finally quando nenhuma exceção ocorre
	public static void doesNotThrowException()
	{
		//Sétimo - executa o try
		try
		{
			System.err.println( "Metodo doesNotThrowException");
		}
		catch( Exception exception)
		{
			System.err.println( exception); //Não é gerado pelo try, logo, não executa
		}
		//Oitavo - finaliza a instrução do try
		finally
		{
			System.err.println(
					"Finally executado no doesNotThrowException");
		}
		//Nono - finaliza o método
		System.out.println("Final do método doesNotTheowException");
	}

}
