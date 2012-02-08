/**
 * Capacidade de internacionalizar o sistema.
 * 	Possui todas as langs dos sistema
 */
package Sistema;

public class Lang 
{
	String cabecaBemVindoEscolha;
	String cabecaEscolhaModulo;
	String cabecaCurso;
	String cabecaAluno;
	String cabecaConfi;
	
	String home;
	String homeGerenciarCurso;
	String homeGerenciarAluno;
	String homeGerenciarConfi;
	
	String sysInicializando;
	
	String erroNaCabeca;
	
	
	Lang(int linguaguem)
	{
		if( linguaguem <= 1)
		{
			cabecaBemVindoEscolha = "Bem-Vindo ao sistema. Escolha o modulo que seja começar";
			cabecaEscolhaModulo = "Escolha abaixo o modulo para visualizar e editar informações";
			cabecaCurso = "Gerenciamento de informações do Curso";
			cabecaAluno = "Gerencimaento de informações e notas de Alunos";
			cabecaConfi = "Configuração e Gerencimaneto";
			
			home = "Home";
			homeGerenciarCurso = "Gerenciar o Curso";
			homeGerenciarAluno = "Gerenciar os Alunos";
			homeGerenciarConfi = "Gerenciar as Configurações";
			
			sysInicializando = "Sistema Inicializando...";
			erroNaCabeca = "Oops! Que painel é esse?! õ.O";
		}
	}

}
