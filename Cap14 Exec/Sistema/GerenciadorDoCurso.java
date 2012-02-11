/**
 * Gerencia as informações do curso sendo esta uma extenção do curso
 * com ele é possível obter as informações relativas ao curso
 * bem como recuperá-la de um arquivo .ser ou salvar em um arquivo .ser
 */
package Sistema;

import Sistema.GerenciadorDoSistema.HowStart;

public class GerenciadorDoCurso extends CursoBase
{
	
	public GerenciadorDoCurso(HowStart comoIniciar)
	{
		LogDoSistema.addLog("Iniciando as configurações do curso");
		if(comoIniciar == HowStart.RECUPERAR)
		{
			this.getDataCurso();
		}
		else
		{
			this.getDefaultCurso();
		}
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
		int numDeAluno = 10;
		int numAluno = 0;
		int[] gradeNotas = new int[numMaxDeAluno];
		int[] Conceitos = new int[numMaxDeAluno];
		
		String nome = "O curso";
		String objCurso = "O objetivo do curso";
		String Professor = "professor";
		String[] Nomes = new String[numMaxDeAluno];
	
		setCursoBase( nome, objCurso, numAluno, numDeAluno, Professor, Nomes,gradeNotas ,Conceitos );
	}
	
}
