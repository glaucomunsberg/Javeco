/** Dialogo é a classe responsável pela troca de
 * 		mensagens com o usuário, bem como a leitura de
 * 		dados para a comunicação I/O
 * @author glaucoroberto
 * 
 */
import javax.swing.JOptionPane;
//Classe para o dialgo e troca de mensagens com o usuário
public class Dialogo 
{
	
	private String funcao	= "Troca de mensagem e interação input e output com o usuário";
	private double versao	= 0.0;
	
	public static void main( String args[])
	{
		/*
		 * funciona unicamente para teste, no exemplo usado
		 * 	lê o nome do usuário e imprime pelo diálogo
		 */
		String userName = JOptionPane.showInputDialog( "Quam é o seu nome?" );
		String mensagem = String.format( "Bem vindo \'%s\' ao curso de Java", userName );
		JOptionPane.showMessageDialog(null, mensagem );
	}
	
	/**
	 * @param String da mensagem a ser imprimida
	 * @return a string lida
	 */
	public String lerString( String mensagem )
	{
		String userName = JOptionPane.showInputDialog( mensagem );
		return userName;
	}
	
	/** O método é movido a gambiarra, pois a mensagem de tela apenas aceita o valor String
	 * 		e nesse caso queremos um int. Logo precisa-se fazer a conversão de tipo. Fica
	 * 		para implementações futuras a correção para que não acha problema de tipo
	 * @link http://javafree.uol.com.br/topic-869403-RESOLVIDO-Captar-valor-int-em-JOptionPane.html
	 * @param String com a mensagem
	 * @return o int lido
	 */
	public int lerInt( String mensagem )
	{
		String valorEmString = JOptionPane.showInputDialog(null, mensagem);  
		int valorEmInt = Integer.parseInt(valorEmString);
		return valorEmInt;
	}
	
	/** O método é movido a gambiarra, pois a mensagem de tela apenas aceita o valor String
	 * 		e nesse caso queremos um Double. Logo precisa-se fazer a conversão de tipo. Fica
	 * 		para implementações futuras a correção para que não acha problema de tipo
	 * @link http://javafree.uol.com.br/topic-869403-RESOLVIDO-Captar-valor-int-em-JOptionPane.html
	 * @param String com a mensagem
	 * @return o int lido
	 */
	public double lerdoDoble( String mensagem )
	{
		String valorEmString = JOptionPane.showInputDialog(null, mensagem);  
		double valorEmDouble = Double.parseDouble(valorEmString);
		return valorEmDouble;
	}
	
	/**
	 * @param mensagens a ser imprimida
	 */
	public void mensagem(String mensagens)
	{
		JOptionPane.showMessageDialog( null, mensagens );
	}
	
	/**
	 * Método utilizado para trazer informações sobre a classe
	 */
	public void info()
	{
		String informacao = String.format( "Função: %s.\nVersão:%.2f\n", funcao,versao );
		this.mensagem(informacao);
		
	}
}
