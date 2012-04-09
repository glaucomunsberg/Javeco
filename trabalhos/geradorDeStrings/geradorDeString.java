
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
public class geradorDeString
{
	Random random;						//Responsável pela aleatoriedade
	ArrayList<String> listDePalavras;	//ArrayList que conterá as palavras
	int numeroDePalavras;				//O número de palavras que gerará
	int maiorNumeroDeLetras;			//A maior palavra terá de até 
	int tipodeOperacao;
	char charPalavra[];
	
	public static void main(String args[])
	{
		geradorDeString gerador = new geradorDeString();
	}
	
	public geradorDeString()
	{
		random = new Random();
		listDePalavras = new ArrayList<String>();
		numeroDePalavras = Integer.parseInt( JOptionPane.showInputDialog(null, "Quantas Strings você quer gerar?!","Gerador Random", JOptionPane.PLAIN_MESSAGE));
		maiorNumeroDeLetras = Integer.parseInt( JOptionPane.showInputDialog(null, "O programa gerará \'palavras\' aleatórioas de 1 até quantas letras?!","Gerador Random", JOptionPane.PLAIN_MESSAGE));
		
		geradorDeTiposDeAcoes();
	}
	
	/**
	 * Gerador de tipos de ações dos tipos:
	 * 	I = Inserir
	 * 	B = Busca
	 * 	R = Remove
	 * O método gera aleatóriamente estas ações
	 * 	e chama o método geradorDePalavras para
	 * 	gerar uma a palavra e então uni-las em uma ação
	 */
	public void geradorDeTiposDeAcoes()
	{
		String palavra;
		for(int a=0; a < numeroDePalavras; a++)
		{
			palavra = null;
			tipodeOperacao = random.nextInt(3);
			switch(tipodeOperacao)
			{
				case 0:
						palavra = "I ";
						break;
				case 1:
						palavra = "B ";
						break;
				case 2:
						palavra = "R ";
						break;
				default:
						break;
			}
			gerarDePalavras(palavra);
		}
	}
	
	/**
	 * Gerador de Palavras aleatórias e tamanho
	 * 	que varia de 1 até o tamanho indicado pelo
	 * 	usuário. Recebe como parametro a primeira
	 * 	parte da string que compoem o comando
	 * @param String palavra
	 */
	public void gerarDePalavras(String palavra)
	{
		
		StringBuilder stringTemp = new StringBuilder(); 				//String temporárioa
		int valor;														//valor em int de um char que gerará
		int tamanhoDaPalavraAtual = 0;									//Tamanho de palavra
		
		/**
		 * Diz qual será o tamanho da palavra
		 */
		while(tamanhoDaPalavraAtual == 0)
		{
			tamanhoDaPalavraAtual = random.nextInt(maiorNumeroDeLetras+1);
		}
		
		/**
		 * segundo o tamanho da palavra ele gerará cada
		 * 	um dos caractéres para formá-la
		 */
		for(int a=0; a < tamanhoDaPalavraAtual; a++)
		{
			valor = 65 + random.nextInt(90 - 65);
			stringTemp.append( (char)valor);
		}
		
		System.out.printf("%s%s\n", palavra,stringTemp.toString());
		/**
		 *  Soma o comando mais a palavra gerada
		 */
		listDePalavras.add( palavra+stringTemp.toString() );
		
	}
}