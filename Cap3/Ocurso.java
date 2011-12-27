/** Ocurso
 * 		objeto criado para a criacao e manupulação dentro da classe Curso.java. 
 * 			Toda manipulação é feita através de interações feitas pela classe
 * 			Diálogo. 
 * @author glaucoroberto
 *
 */
public class Ocurso
{
	static Curso meuCurso = new Curso(null,0, null, null); 		//Estancia o objeto meuLivro baseado na classe Livro
	static Dialogo interacao = new Dialogo(); 					//Cria objeto que será usado para leitura
	
	static int opcao;											//Identificador responsável pelo controle das escolhas do menu e submenu
	static String texto;										//Receberá sempre as strings que serão impressas na tela ou retornará o valor
	
	static int gradeDeNotas[] = {1, 2, 4, 5, 6, 7, 8, 9, 10};
	static String gradeDeNomes[] = {"fulano0", "fulano1", "fulano2", "fulano3", "fulano4", "fulano5", "fulano6", "fulano7", "fulano8"};
	
	public static void main()
	{
		meuCurso.setNotas(gradeDeNotas);						//Insere as notas de modo indireta
		meuCurso.setNomes(gradeDeNomes);						//Insere os nomes de modo indireta
		
		interacao.mensagem("Bem-vindo!\n Esse é o programa responsável pela manipulação de informações de um curso.");
		
		do
		{
			do
			{
				opcao = interacao.lerInt(" 1. Ver informações\n 2. Inserir/Modificar Informações\n 3. Informações Gerais\n 0. Sair");

			}while( opcao < 0 || opcao > 3);
			
			switch(opcao)
			{
				case 0:
						opcao = interacao.lerInt("Você realmente deseja sair?!\n 0- Sim\n 1- Não");
						break;
				case 1:
						informacoes();
						break;
				case 2:
						modificar();
						break;
				case 3:
						informacaoesGerias();
						break;
				default:
						interacao.mensagem("Ooops! Você não deveria estar aqui õ.O");
			}
			
		}while( opcao != 0);

	}
	
	static private void informacoes()
	{
		do
		{
			do
			{
				opcao = interacao.lerInt("1. Informações do curso\n2. Informações de Alunos e notas\n 0. Sair");	
			}while(opcao < 0 || opcao > 2);
			
			switch(opcao)
			{
				case 0:
						//Sai do submenu
						break;
				case 1:
						texto = String.format("Nome do Curso: %s\nObjetivo do Curso: %s", meuCurso.getNomeCurso(), meuCurso.getObjetivo());
						interacao.mensagem(texto);
						break;
				case 2:
						texto = String.format(" Linta de alunos:\n %s Número de alunos: %d\nNúmero de Notas: %d\nMédia das notas é: %.2f\nMaior nota é: %d\nMenor nota é: %d", meuCurso.getNomes(), meuCurso.getNumeroDeAlunos(), meuCurso.getNumeroDeNotas(), meuCurso.getMedia(), meuCurso.getMaiorNota(), meuCurso.getMenorNota());
						interacao.mensagem(texto);
						break;
				default:
						interacao.mensagem("Ooops! Você não deveria estar aqui õ.O");
			}
		}while(opcao != 0);
		
		opcao = 1; //Garante que quando sair desse menu não irá sair do menu principal
		
		
	}
	
	static private void modificar()
	{
		do
		{
			do
			{
				opcao = interacao.lerInt(" 1. Modificar nome do curso\n 2. Mudar Objetivo do curso\n 3. Modificar numero de alunos\n 4. Modificar Nota\n 5. Início e fim do curso\n 0. Sair");
			}while( opcao < 0 || opcao > 5);
			
			switch( opcao )
			{
				case 0:
						//Sai do programa
						break;
				case 1:
						texto = String.format(" Atenção!\nO nome do curso é: %s\n\nVocê trocará permanentemente o nome do curso.\n Novo nome:", meuCurso.getNomeCurso());
						texto = interacao.lerString(texto);
						if( texto == null)
						{
							interacao.mensagem("O nome não será alterado.");
						}
						else
						{
							meuCurso.setNomeCurso(texto);
						}
						break;
				case 2:
						texto = String.format(" Atenção!\nO objetivo do curso é: %s\n\nVocê trocará permanentemente o objetivo do curso.\n Novo objetivo:", meuCurso.getObjetivo());
						texto = interacao.lerString(texto);
						if( texto == null)
						{
							interacao.mensagem("O objetivo não será alterado.");
						}
						else
						{
							meuCurso.setObjetivo(texto);
						}
						break;
				case 3:
						int aux;
						texto = String.format(" Atenção!\nO Numero de alunos é de: %d\n\nVocê trocará permanentemente o numero de alunos.\n Quantos alunos são:", meuCurso.getNumeroDeAlunos());
						do
						{
							aux = interacao.lerInt(texto);
							if( aux < 0 )
							{
								texto = String.format("O valor %d é inválido", aux);
								interacao.mensagem(texto);
							}
						}while( aux < 0);
						
						
						if( aux != meuCurso.getNumeroDeAlunos() )
						{
							meuCurso.setNumeroDeAlunos(aux);
						}
						break;
				case 4:
						int posicao;
						int valor;
						do
						{
							texto = String.format("Qual aluno deseja alterar:\n Obs.: De 0 a %d", meuCurso.getNumeroDeNotas()-1);
							posicao = interacao.lerInt(texto);
							
						}while( posicao < 0 || posicao > meuCurso.getNumeroDeNotas()-1);
						
						do
						{
							texto = String.format(" A nota do aluno '%s' é %d. Qual o novo valor:", meuCurso.getNome(posicao), meuCurso.getNota(posicao));
							valor = interacao.lerInt(texto);
						}while( valor < 0);
						meuCurso.setNota(posicao, valor);
						break;
				case 5:
						int mudar;
						do
						{
							
							texto = String.format(" Início do Curso: %s\nFim do Curso: %s\n 1- Mudar Inicio do curso\n 2- Mudar fim do curso\n 3-Sair", meuCurso.getInicioCurso(), meuCurso.getFinalCurso());
							mudar = interacao.lerInt(texto);
							
							if( mudar == 1)
							{
								texto = String.format(" Início do Curso: %s\nNovo valor é:", meuCurso.getInicioCurso());
								texto = interacao.lerString(texto);
								if( texto != null )
								{
									meuCurso.setInicioCurso(texto);
								}
								else
								{
									interacao.mensagem("O valor não foi modificado");
								}
							}
							if( mudar == 2)
							{
								texto = String.format(" O fim do curso é: %s\nNovo valor é:", meuCurso.getFinalCurso());
								texto = interacao.lerString(texto);
								if( texto != null )
								{
									meuCurso.setFinalCurso(texto);
								}
								else
								{
									interacao.mensagem("O valor não foi modificado");
								}
							}
						
						}while( mudar != 0);
				default:
						interacao.mensagem("Ooops! Você não deveria estar aqui õ.O");
			}
			
		}while( opcao != 0);
		opcao = 1;
	}
	
	static private void informacaoesGerias()
	{
		
	}

}
