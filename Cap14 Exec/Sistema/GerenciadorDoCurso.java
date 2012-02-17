/**
 * Gerencia as informações do curso sendo esta uma extenção do curso
 * com ele é possível obter as informações relativas ao curso
 * bem como recuperá-la de um arquivo .ser ou salvar em um arquivo .ser
 */
package Sistema;

public class GerenciadorDoCurso extends CursoBase
{
	protected boolean gravouComSucesso = false;
	
	public GerenciadorDoCurso()
	{
		Log.addLog("Inicilizando as configurações do curso");
		this.getDefaultCurso();
		//if(comoIniciar == HowStart.RECUPERAR)
		//{
		//	this.getDataCurso();
		//}
		//else
		//{
		//	this.getDefaultCurso();
		//}
	}
	
	/**
	 * inicia o curso com as informações do arquivo
	 * 		de recuperação
	 */
	protected void getDataCurso()
	{
		
	}
	
	/**
	 * inicia o sistema com os dados Default
	 * 		que estarão discritos aqui
	 * Obs.:posteriormente será criado um arquivo
	 * 	que conterá os dados "default"
	 */
	protected void getDefaultCurso()
	{
		int numMaxDeAluno = 100;
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
	 * responsável pela gravação de dados do curso dentro do 
	 * 		arquivo configs.dat
	 */
	protected void setDataCurso()
	{
		
	}
	
	protected boolean gravarArquivoSerializado()
	{
		return true;
	}
}
