/**
 * ArrayList é uma estrutura dimanica funciona como um array redimensionaval
 * 	possível usar até mesmo de diferentes formas ou elementos
 * @author glaucoroberto
 *
 */
public class ArrayList {
 
    /**
     * JavaProgrammingForums.com
     */
    public static void main(String[] args) {

    	Number[] numerico = { 0, 1.0, 2, 3.4, 4, 5.0};
        java.util.ArrayList<Number> arrayListaNumerico = new java.util.ArrayList<Number>();
       
        java.util.ArrayList<Integer> arrayInteger = new java.util.ArrayList<Integer>();
        java.util.ArrayList<Double> arrayDouble = new java.util.ArrayList<Double>();
        
        for( Number elemento: numerico)
        {
        	arrayListaNumerico.add(elemento);
        }
        System.out.printf("ArrayListaNumerico contém: %s \n", arrayListaNumerico);
        System.out.printf("A soma dos elementos do arrayListaNumerico: %.1f\n", somaTotal(arrayListaNumerico));
        
        Object[] elements = arrayListaNumerico.toArray(); // Convert ArrayList to Object array
 
        for (int a = 0; a < elements.length; a++) {
            System.out.println(elements[a]);
        }
 
        arrayListaNumerico.remove(3);  // Remove o item do ArrayList segundo a posicao que se passa
        System.out.printf("\nArrayListaNumerico com remoção de 3 elementos: %s", arrayListaNumerico);
  
        arrayListaNumerico.clear(); 	// Clear limpa o ArrayList
        System.out.printf("\nArray depois de ser limpo: %s", arrayListaNumerico);
        
        somaTotalQualquerTipo(arrayInteger);
        somaTotalQualquerTipo(arrayDouble);
        somaTotalQualquerTipo(arrayListaNumerico);
    }
    public static double somaTotal(java.util.ArrayList<Number> listaArray)
    {
    	double total = 0;
    	
    	for(Number elemento: listaArray)
    	{
    		total += elemento.doubleValue();
    	}
    	
    	return total;
    }
    
    public static void somaTotalQualquerTipo( java.util.ArrayList< ? extends Number > lista)
    {
    	double total = 0;
    	for( Number elemento: lista)
    	{
    		total += elemento.doubleValue();
    	}
    	System.out.printf("\nTotal %s", total);
    }
}
