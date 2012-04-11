
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 * Classe responsável pela geração de dois arquivos
 * 	que serão usado como teste. O primeiro arquivo
 * 	"entrada.txt" é composto por uma ação e uma palavra
 * 	em cada linha que serão usados pelo programa de árvore B;
 * 	"saida.txt" contém apenas V ou F, de acordo com o que
 * 	se espera de saida do programa segundo aquela palavra
 * 	no programa da árvore B
 * @author glaucoroberto
 *
 */
public class geradorDeString
{
	Random random;						//Responsável pela aleatoriedade
	ArrayList<String> listDePalavras;	//ArrayList "array" que conterá as palavras
    int numeroDePalavras;				//O numero de palavras que será gerado em entrada.txt e resultados em saida.txt
	int maiorNumeroDeLetras;			//O maior número de letras que pode haver em cada palavra
	int tipodeOperacao;					//Tipo da operacao que está sendo realizada como Inserir, Remover e Buscar
	int numeroDeRepeticoes;				//O número de repetições de palavras que há no arrayList
	geradorDeArquivo saida, entrada;	//Classe que insere na saida.txt e entrada.txt
	
	
	
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
		saida = new geradorDeArquivo("saida.txt");
		entrada = new geradorDeArquivo("entrada.txt");
		System.out.printf("\nTecnologia: Processador Recursivo Corp.\nAguarde enquanto nossos melhores macacos sorteiam as letras...\n");
		geradorDeTiposDeAcoes();
		entrada.closeFile();
		saida.closeFile();
		JOptionPane.showMessageDialog(null, String.format("Foram gerado os arquivos entrada.txt e saida.txt\n Tendo %d palavras e %d repetições mesmo com a aleatoriedade.", numeroDePalavras,numeroDeRepeticoes),"Aleatoriedade não aleatória assim", JOptionPane.PLAIN_MESSAGE);
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
		String acao;
		for(int a=0; a < numeroDePalavras; a++)
		{
			acao = null;
			tipodeOperacao = random.nextInt(3);
			switch(tipodeOperacao)
			{
				case 0:
						acao = "I ";
						break;
				case 1:
						acao = "B ";
						break;
				case 2:
						acao = "R ";
						break;
				default:
						break;
			}
			gerarDePalavras(acao);
		}
	}

	/**
	 * Gerador de Palavras aleatórias de tamanho
	 * 	que varia de 1 até o tamanho indicado pelo
	 * 	usuário. Recebe como parametro a primeira
	 * 	parte (comando)
	 * @param String palavra
	 */
	public void gerarDePalavras(String acao)
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

		
		/**
		 *  Soma o comando mais a palavra gerada
		 */
		listDePalavras.add( acao + stringTemp.toString() );
        gravarNoArquivoDeEntradas(String.format("%s%s\n", acao,stringTemp.toString()));
        geradorDeResultado(acao, stringTemp.toString());
	}

	/**
	 * Segundo as palavras geradas e a ação que gerou para essa palavra
	 * então ele deve gerar um resultado verdadeiro ou falas segundo a
	 * simulação dessa ação na árvore tre
	 */
	public void geradorDeResultado(String acao, String palavra)
	{
		if( acao == "I ")
		{
			gravarNoArquivoDeResultado(podeIserir(palavra));
		}
		else
		{
			if(acao == "B ")
			{
				gravarNoArquivoDeResultado(podeBuscar(palavra));
			}
			else
			{
				if( acao == "R ")
				{
					gravarNoArquivoDeResultado(podeRemover(palavra));
				}
			}
		}
	}

	/**
	 *  Recebe uma string que é composta pela acao seguida por
	 *  uma palavra que será gravada no arquivo entrada.txt
	 *  @param String linha{"acao"+" "+"palavra"}
	 */
	public void gravarNoArquivoDeEntradas(String linha)
	{
		entrada.adicionar(linha);
	}

	/**
	 * Recebe um valor boolean que será gravado dentro
	 * de um arquivo saida.txt com valores
	 * boolean{ true - V | false - F}
	 * @param boolean saida
	 */
	public void gravarNoArquivoDeResultado(boolean valorSaida)
	{
		if(valorSaida)
		{
			saida.adicionar("V\n");
		}
		else
		{
			saida.adicionar("F\n");
		}
	}
	
	/**
	 * Método dedicado para verificar no ArrayList
	 * 	se o elemento pode ser inserido. Em todos os
	 * 	casos ele retornará true, se ele encontrar já inserido
	 * 	então adicionará um ao contador de repetição
	 * @param String palavra
	 * @return Boolean { true }
	 */
	public boolean podeIserir(String palavra)
	{
		if(listDePalavras.contains(palavra))
		{
			this.numeroDeRepeticoes++;
			return true;
		}
		else
		{
			return true;
		}
	}
	
	/**
	 * Método que verifica se já existe no arrayList
	 * 	a palavra, se ele retornar que existe então
	 * 	ele pode remover, caso não encontre retorna false
	 * @param String palavra
	 * @return Boolean{true - Pode remover | false - Não encontrou }
	 */
	public boolean podeRemover(String palavra)
	{
		if(listDePalavras.remove(palavra))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * análogo ao Método podeRemover, verifica se o valor
	 * 	está inserido, porém não o remove. mas retorna true
	 * 	se o encontrou ou false se não encontrou
	 * @param palavra
	 * @return
	 */
	protected boolean podeBuscar(String palavra)
	{
		if(listDePalavras.contains(palavra))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}