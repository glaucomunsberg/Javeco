
public class CursoDeTeste 
{
	public static void main( String args[])
	{
		Pessoas glauco = new Pessoas();
		Alunos glaucoAluno = new Alunos();
		
		glauco.setCPF(11100);
		String[] nascimento = new String[3];
		nascimento[0] = "08";
		nascimento[1] = "07";
		nascimento[2] = "2013";
		
		glauco.setDataNacimento(nascimento);
		glauco.setIdade(0);
		glauco.setNome("glauco roberto");
		glauco.setSobreNome("munsberg dos santos");
		glauco.setDataNacimento(nascimento);
		System.out.printf(glauco.toString()+"\n");
		System.out.printf("Numero de pessoas inicializadas: %d\n Numero de Alunos inicializados: %d\n Moficiando...\n", glauco.getPessoas(), glaucoAluno.getAlunos());
		
		glauco.setNome("Glauco Roberto");
		glauco.setSobreNome("Munsberg dos Santos");
		glauco.setIdade(23);
		glauco.setCPF(0);
		System.out.printf(glauco.toString()+"\n");
		
		//--Faz cópia dos dados de glauco para o glaucoAluno
		glaucoAluno.setCPF(glauco.getCPF());
		glaucoAluno.setDataNacimento(glauco.getDataNacimento());
		glaucoAluno.setIdade(glauco.getIdade());
		glaucoAluno.setMatricula(10202117);
		glaucoAluno.setNome(glauco.getNome());
		glaucoAluno.setSobreNome(glauco.getSobreNome());
		
		glaucoAluno.setSituacao( Alunos.Status.DESCONHECIDO );
		
		System.out.printf(glaucoAluno.toString());
	}
}
