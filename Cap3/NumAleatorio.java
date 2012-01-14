/** NumAleatório
 * 		gera números aletórios segundo um mundo restrito criado pelos deleneadores
 * 			passados como argumentos para a classe.
 * 		Obs.: futuros poderão gerar outros tipos como short e long
 * @args tip{ int, float,double}, vezes que deseja, intervalo
 * @author glaucoroberto
 * @version 0.0
 */

import java.util.Random;

public class NumAleatorio
{
	public static int resultadoInt;
	public static float resultadoFloat;
	public static double resultadoDouble;
	private static Random numRandom = new Random();
	private static Dialogo interacao = new Dialogo();
	
	/** Main
	 * 		classe responsável pelo teste da classe de random
	 * @param args
	 * 
	 */
	public static void main( String args[])
	{
		int opcao;
		int vezes;
		int intervalo =0;
		
		do
		{
			opcao = interacao.lerInt("1. Random Int\n2.Random Float\n3.Random Double\n0.Sair");
			if(opcao <0 || opcao > 3)
			{
				interacao.mensagem("Seu idiota! Escolha valor no intervalo!");
			}
		}while( opcao < 0 || opcao > 3);
		
		do
		{
			vezes = interacao.lerInt("Quantas vezes deseja imprimir?!");
			if( vezes < 1 || vezes >100)
			{
				interacao.mensagem("O valor está fora do intervalo de 1 - 100");
			}
		}while(vezes < 1 || vezes > 100);
		
		if( opcao == 1)
		{
			intervalo = interacao.lerInt("Qual é o intervalo?!");
			
		}
		gerar(opcao, vezes, intervalo );
		
	}
	
	/** Gerar
	 * 		método para gerar e imprimr os valores gerados segundo os
	 * 			argumentos passados. 
	 * 			Tipo (1) int (2) float (3) Double,
	 * 			Vezes é <= 100 executado a impressão e método random
	 * 			Intervalo em caso de int diz qual será o intervalo
	 * 
	 * @param tipo
	 * @param vezes
	 * @param intervalo
	 */
	public static void gerar(int tipo, int vezes, int intervalo )
	{
		/**
		 *  Asegura que o valor tipo não é inválido
		 *  			    que vezes não é negativo
		 *  			    que intervalo não é menor do 0
		 * 						e 3
		 */
		// Verificar tipo
		if(tipo <= 0)
		{
			tipo = 1;
		}
		else
		{
			if(tipo > 3)
			{
				tipo = 3;
			}
		}
		
		//Verifica vezes
		if( vezes <= 0)
		{
			vezes = 1;
		}
		else
		{
			if( vezes > 100)
			{
				interacao.mensagem("O valor de vezes que será imprimido\n é maior que 100 e será revertido para o limite.");
				vezes = 100;
			}
		}
		
		if(intervalo <= 0)
		{
			interacao.mensagem("O intervalo é menor que 1, mas será revertido para imprimir uma vez.");
			intervalo = 1;
		}
		
		switch( tipo)
		{
			case 1:
					for( int i=1; i<= vezes; i++ )
					{
						resultadoInt = numRandom.nextInt(intervalo);
						interacao.mensagem("O valor gerado é: "+ resultadoInt);
					}
					break;
			case 2:
					
					for( int i=1; i<= vezes; i++);
					{
						resultadoFloat = numRandom.nextFloat();
						interacao.mensagem("O valor gerado é: "+ resultadoFloat);
					}
					break;
			case 3:
					for(int i=1; i <= vezes; i++)
					{
						resultadoDouble = numRandom.nextDouble();
						interacao.mensagem("O valor gerado é: "+ resultadoDouble);
					}
					break;
			default:
					interacao.mensagem("Você não deveria estar aqui!");
		}
	}

}
