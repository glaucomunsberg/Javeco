/**
 * Capacidade de internacionalizar o sistema.
 * 	Possui todas as langs dos sistema
 */
package Sistema;

public class Lang 
{
	protected int linguagemEscolhida;
	
	public String cabecaBemVindoEscolha;
	public String cabecaEscolhaModulo;
	public String cabecaCurso;
	public String cabecaAluno;
	public String cabecaConfi;
	public String cabecaDescricao;
	
	public String home;
	public String homeGerenciarCurso;
	public String homeGerenciarAluno;
	public String homeGerenciarConfi;
	
	public String sysInicializando;
	
	public String erroNaCabeca;
	
	/**
	 * inicia a linguagem do sistema tendo tendo as linguagens
	 * 	1 - Portugres
	 *  2 - Ingles
	 * @param linguaguem
	 */
	Lang(int linguaguem)
	{
		linguagemEscolhida = linguaguem;
		if( linguaguem == 1)
		{
			linguagemPortugues();
		}
	}
	
	public void linguagemPortugues()
	{
		cabecaBemVindoEscolha = "Bem-Vindo ao sistema. Escolha o modulo que seja começar";
		cabecaEscolhaModulo = "Escolha abaixo o modulo para visualizar e editar informações";
		cabecaCurso = "Gerenciamento de informações do Curso";
		cabecaAluno = "Gerencimaento de informações e notas de Alunos";
		cabecaConfi = "Configuração e Gerencimaneto";
		cabecaDescricao = "Clique aqui para ir ao painel Home";
		
		home = "Home";
		homeGerenciarCurso = "Gerenciar o Curso";
		homeGerenciarAluno = "Gerenciar os Alunos";
		homeGerenciarConfi = "Gerenciar as Configurações";
		
		sysInicializando = "Sistema Inicializando...";
		erroNaCabeca = "Oops! Que painel é esse?! õ.O";
		
		LogDoSistema.addLog("Linguagem selecionada: Português.");
	}
	
	/**
	 * troca de linguagem do sistema
	 *  1 - portugues
	 *  2 - Ingles
	 * @param linguagem
	 */
	public void setTemaLinguagem(int linguagem)
	{
		linguagemEscolhida = linguagem;
		if(linguagem == 1 )
		{
			linguagemPortugues();
		}
	}
	
	/**
	 * retorna a linguagem usada no sistema
	 * @return
	 */
	public int getTemaLinguagem()
	{
		return linguagemEscolhida;
	}

}
