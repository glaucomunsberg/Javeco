
public class Usuarios
{
	protected int senha;
	private String user;
	protected boolean firt = true;
	
	
	protected boolean usuarioInicializado = false;
	static public int numUsuarios = 0;
	
	Pessoas usuario = new Pessoas();
	Dialogo interacao = new Dialogo();
	
	public void Usuario()
	{
		senha = 12345;
		user = "admin";
		if(usuarioInicializado == false )
		{
			usuarioInicializado = true;
			numUsuarios++;
		}
	}
	
	public void Usuario(String user, int senha, String tipo)
	{
		this.senha = senha;
		this.user = user;
		
		if(usuarioInicializado == false )
		{
			usuarioInicializado = true;
			numUsuarios++;
		}
		usuario.setTipo(tipo);

		firt = false;
	}
	
	protected int getSenha()
	{
		return senha;
	}
	
	protected String getUserPeloSistema()
	{
		return this.user;
	}
	protected String getUser()
	{
		int senhaComparacao = interacao.lerInt("Digite sua senha por segurança:");
		if ( senhaComparacao == getSenha())
		{
			return this.user;
		}
		return null;
	}
	
	protected void setUserSenha(String user, int senha)
	{
		boolean abortar = false;
		if( senha == getSenha())
		{
			interacao.mensagem("Senha não pode ser igual");
		}
		else
		{
			abortar = true;
		}
		
		if( user == null)
		{
			interacao.mensagem("O usuário não igual a null");
		}
		else
		{
			abortar = true;
		}
		
		if( abortar != true)
		{
			String nomeComparacao = interacao.lerString("Digite o nome de usuário:");
			int senhaComparacao = interacao.lerInt("Digite a senha do usuário:");
			boolean validacaoUser = false;
			boolean validacaoSenha = false;
			if( nomeComparacao == getUserPeloSistema() )
			{
				validacaoUser = true;
			}
			if( senhaComparacao == getSenha() )
			{
				validacaoSenha = true;
			}
			
			if( validacaoSenha && validacaoUser )
			{
				this.senha = senha;
				this.user = user;
			}
			
		}
	}
	
	private void setInformacaos( String nome, String sobreNome, int idade, int matricula, int CPF)
	{
		int senhaComparacao = interacao.lerInt("Para inserir as informacações é confirmar a sua senha:");
		if( senhaComparacao == getSenha())
		{
			usuario.setInformacoesPessoas(nome, sobreNome, idade, CPF);
			if( usuario.getTipo() == "ALUNO" )
			{
				if( usuario.aluno.getMatricula() == matricula )
				{
					usuario.aluno.setMatricula(matricula);
				}
			}

		}
		else
		{
			interacao.mensagem("Senha errada!");
		}
	}
}
