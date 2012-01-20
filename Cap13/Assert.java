/**
 * Assert ou "assertivas" serve como tratador de exceção,
 * 	ASSERT pode ser usado para gerenciar  as pré-condições 
 * 	e pós-condições para que um método seja executado
 *OBS.: para ser executado é necessário que a máquina
 *	execute da seguinte forma
 *			$ java -EA Assert
 *	isso fará com que seja ativado e interrompa a execução
 *	se a expressão for validada como verdadeira
 *OBS.: Caso seja executado sem o -EA então não será validado
 *	e utilizado
 *
 * @author glaucoroberto
 *
 */
import java.util.Scanner;
public class Assert 
{
	private static int resultado;
	
	public static void main( String args[] )
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Insira um valor:");
		resultado = valor( scan.nextInt());
		System.out.printf("Valor final é: %d", resultado);
		
	}
	public static int valor(int valor)
	{
		//Se o valor for menor que zero encerra a execução e depura
		assert( valor < 0):valor+" é menor que zero!";	
		int resultadoparcial = valor*valor;
		
		//se o resultado for maior ou igual encerra e depura
		assert(resultadoparcial<100):resultadoparcial+" é maior que 99";
		return resultadoparcial;
	}

}
