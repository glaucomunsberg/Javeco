import Sistema.CursoBase;

/** Ocurso
 * 		objeto criado para a criacao e manupulação dentro da classe Curso.java. 
 * 			Toda manipulação é feita através de interações feitas pela classe
 * 			Diálogo. 
 * @author glaucoroberto
 *
 */


public class Ocurso
{
	static CursoBase meuCurso = new CursoBase(); 		//Estancia o objeto meuLivro baseado na classe Livro
	static Dialogo interacao = new Dialogo();					//Cria objeto que será usado para leitura
	
	
	static int opcao;											//Identificador responsável pelo controle das escolhas do menu e submenu
	static String texto;										//Receberá sempre as strings que serão impressas na tela ou retornará o valor
	
	static int gradeDeNotas[] = {1, 2, 4, 5, 6, 7, 8, 9, 10};
	static String gradeDeNomes[] = {"fulano0", "fulano1", "fulano2", "fulano3", "fulano4", "fulano5", "fulano6", "fulano7", "fulano8"};
	
	public static void main(String args[])
	{
		meuCurso.setNotas(gradeDeNotas);						//Insere as notas de modo indireta
		meuCurso.setNomes(gradeDeNomes);						//Insere os nomes de modo indireta
		interacao.mensagem("Bem-vindo!\n Esse é o programa responsável pela manipulação de informações de um curso.");
		
		do
		{
			do
			{
				opcao = interacao.lerInt(" 1. Administrar Curso\n 2. Administrar Alunos\n 0. Sair");

			}while( opcao < 0 || opcao > 3);
			
			switch(opcao)
			{
				case 0:
						opcao = interacao.lerInt("Você realmente deseja sair?!\n 0- Sim\n 1- Não");
						break;
				case 1:
						admCurso();
						break;
				case 2:
						admAlunos();
						break;
				case 3:
						informacaoesGerias();
						break;
				default:
						interacao.mensagem("Ooops! Você não deveria estar aqui õ.O");
			}
			
		}while( opcao != 0);
		System.exit(0);

	}
	
	private static void admCurso()
	{
		int subMenu;
		do
		{
			do
			{
				opcao = interacao.lerInt("1. Ver Informações do curso\n2. Modificar informações do curso\n 0. Sair");	
			}while(opcao < 0 || opcao > 2);
			
			switch(opcao)
			{
				case 0:
						//Sai do submenu
						break;
				case 1:
						texto = String.format(" Nome do Curso: %s\nObjetivo do Curso: %s\nInício do curso: %s\nFinal do Curso: %s", meuCurso.getNomeCurso(), meuCurso.getObjetivo(), meuCurso.getInicioCurso(), meuCurso.getFinalCurso());
						interacao.mensagem(texto);
						break;
				case 2:
						subMenu = interacao.lerInt(" 1. Mudar nome do curso\n2. Mudar Objetivo do curso\n3. Mudar Início do curso\n4. Mudar Fim do curso");
						switch(subMenu)
						{
							case 0:
									break;
							case 1:
									texto = String.format(" Curso %s.\n Novo nome:", meuCurso.getNomeCurso());
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
									texto = String.format(" Início do Curso: %s\nNovo valor é:", meuCurso.getInicioCurso());
									texto = interacao.lerString(texto);
									if( texto != null )
									{
										texto = "00/00/00/"+texto;
										meuCurso.setInicioCurso(texto);
									}
									else
									{
										interacao.mensagem("O valor não foi modificado");
									}
									break;
							case 4:
									texto = String.format(" O fim do curso é: %s\nNovo valor é:", meuCurso.getFinalCurso());
									texto = interacao.lerString(texto);
									texto = "00/00/00/"+texto;
									if( texto != null )
									{
										meuCurso.setFinalCurso(texto);
									}
									else
									{
										interacao.mensagem("O valor não foi modificado");
									}
									break;
							default:
								interacao.mensagem("Ooops! Você não deveria estar aqui õ.O");
						}
						break;
				default:
						interacao.mensagem("Ooops! Você não deveria estar aqui õ.O");
			}
		}while(opcao != 0);
		
		opcao = 1; //Garante que quando sair desse menu não irá sair do menu principal
		
		
	}
	
	static private void admAlunos()
	{
		int alunoEscolhido;
		do
		{
			do
			{
				opcao = interacao.lerInt(" 1. Ver informações do aluno\n 2. Editar informações dos Alunos\n 0. Sair");
			}while( opcao < 0 || opcao > 2);
			
			switch( opcao )
			{
				case 0:
						break;
				case 1:
						texto = String.format(" São %s alunos inscritos no curso %s.\n De %s até %s.", meuCurso.getNumeroDeAlunos(), meuCurso.getNomeCurso(), meuCurso.getInicioCurso(), meuCurso.getFinalCurso());
						break;
				case 2:
						texto = String.format(" Alunos:\n %s \n Escolha aluno para gerenciar:");
						do
						{
							alunoEscolhido = interacao.lerInt(texto);
						}while( alunoEscolhido < 0 && alunoEscolhido > meuCurso.getNumeroDeAlunos());
						
						
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
