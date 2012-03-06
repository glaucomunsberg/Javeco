
public class Fatorial 
{
	public static void main( String arg[] )
	{
		Fatorial fatorial = new Fatorial();
		fatorial.displayFatorial();
	}
	public void displayFatorial()
	{
		for( int cont = 0; cont <=10; cont++)
		{
			System.out.printf("%d! = %d\n", cont, fatorial(cont));
		}
	}
	public long fatorial( long numero)
	{
		if(numero <= 1)
		{
			return 1;
		}
		else
		{
			return numero * fatorial( numero - 1);
		}
	}

}
