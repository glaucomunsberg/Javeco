/**
 * Diferente dos outros tratamentos de evento,
 * 	aqui demonstra como o podemos manipular
 * 	informações obtidas das exceções.
 * 
 * @author glaucoroberto
 */

public class UsandoExcessaoTratando
{
	public static void main( String args[])
	{
		try
		{
			metodo1();
		}
		catch(Exception exception)
		{
			System.err.printf("%S\n\n", exception.getMessage()); 			//trás a informação criada na exeção criada no método
			exception.printStackTrace();										
			
			StackTraceElement[] traceElements = exception.getStackTrace();	//o StrackTrace como é gerado pelo compilador
			
			System.out.println("\nStack trace from getStackTrace:");
			System.out.println("Class\t\t\t\t\tFile\t\t\t\tLine\tMetodo");
			
			for( StackTraceElement element : traceElements)
			{
				System.out.printf("%s\t", element.getClass());
				System.out.printf("%s\t", element.getFileName());
				System.out.printf("%s\t", element.getLineNumber());
				System.out.printf("%s\n", element.getMethodName());
			}
		}
	}
	public static void metodo1() throws Exception
	{
		metodo2();
	}
	
	public static void metodo2() throws Exception
	{
		metodo3();
	}
	
	public static void metodo3() throws Exception
	{
		throw new Exception("Exeção criado no  método 3");
	}
}
