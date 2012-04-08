package geradorDeStrings;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
public class geradorDeString
{
	Random random;						//Responsável pela aleatoriedade
	ArrayList<String> listDePalavras;	//ArrayList que conterá as palavras
	int numeroDePalavras;				//O número de palavras que gerará
	int maiorNumeroDeLetras;			//A maior palavra terá de até esse numero
	int tipodeOperacao;					// Inteiro que representa um tipo de operacao			
	
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
	
	public void gerarDePalavras(String palavra)
	{
		StringBuilder stringTemp = new StringBuilder();
		int valor;
		int tamanhoDaPalavraAtual = 0;
		while(tamanhoDaPalavraAtual == 0)
		{
			tamanhoDaPalavraAtual = random.nextInt(maiorNumeroDeLetras+1);
		}
		
		for(int a=0; a < tamanhoDaPalavraAtual; a++)
		{
			valor = 65 + random.nextInt(90 - 65);
			stringTemp.append( (char)valor);
		}
		System.out.printf("%s%s\n", palavra, stringTemp.toString() );
		listDePalavras.add( palavra+stringTemp.toString() );
		
	}
}