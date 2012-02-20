/**
 * Gerencia as informações do curso sendo esta uma extenção do BaseCurso
 * 		com ele é possível obter as informações relativas ao curso bem 
 * 		como recuperá-la do banco de dados ou salvar em um arquivo.
 * 
 * @author glaucoroberto@gmail.com
 * @project SSH: git@github.com:glaucomunsberg/Javeco.git
 */

package Sistema;
public class GerenciadorDoCurso extends CursoBase
{
	protected boolean gravouComSucesso = false;
	
	public GerenciadorDoCurso()
	{
		Log.addLog("Inicilizando as configurações do curso");
		this.getDefaultCurso();
	}
	
	/**
	 * inicia o curso com as informações do arquivo
	 * 		de recuperação
	 */
	protected void getDataCurso()
	{
		//Pega os dados do banco de Dados
	}
	
	/**
	 * inicia o sistema com os dados Default
	 * 		que estarão discritos aqui
	 * Obs.:posteriormente será criado um arquivo
	 * 	que conterá os dados "default"
	 */
	protected void getDefaultCurso()
	{
		Log.addLog("O Gerenciador do Curso iniciará com dados 'default'.");
		int numMaxDeAluno = 50;
		int numAluno = 0;
		int[] gradeNotas = new int[numMaxDeAluno];
		int[] Conceitos = new int[numMaxDeAluno];
		
		String nome = "O curso";
		String objCurso = "Curso javeco tem como objetivo ensinar a todos os estudantes como "
						+"se trabalhar com a plataforma java. Indepentende da plataforma, java "
						+"possibilita trabalhar com uma rica interface. Usando por exemplo 'awt' e "
						+"'swing' pode se criar ótimos programas. Modestia parte como este que você "
						+" está usando agora.";
		String Professor = "Glauco Munsberg dos Santos";
		String[] Nomes = new String[numMaxDeAluno];
	
		setCursoBase( nome, objCurso, numAluno, numMaxDeAluno, Professor, Nomes,gradeNotas ,Conceitos  );
	}
	
	
	/**
	 * Responsável pela gravação de dados do curso dentro do 
	 * 	arquivo configs.dat
	 */
	protected void setDataCurso()
	{
		Log.addLog("O Gerenciador do Curso iniciará com dados salvos.");
	}
	
	/**
	 * Responsável pela gravação das informações
	 * 	se conseguir gravar retornará true
	 * @return{ true || false }
	 */
	public boolean gravarArquivoSerializado()
	{
		return true;
	}
}
