
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
	
	public void Usuario(String user, int senha)
	{
		this.senha = senha;
		this.user = user;
		
		if(usuarioInicializado == false )
		{
			usuarioInicializado = true;
			numUsuarios++;
		}

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
		boolean validacao = validadorSenha();
		if ( validacao )
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
			boolean validacao = validador();
			
			if( validacao )
			{
				this.senha = senha;
				this.user = user;
			}
			
		}
	}
	
	private void setInformacaos( String nome, String sobreNome, int idade, int matricula, int CPF, String setor, String funcao)
	{
		boolean validacao = validadorSenha();
		if( validacao )
		{
			usuario.setInformacoesPessoas(nome, sobreNome, idade, CPF);
			if( usuario.getTipo() == "ALUNO" )
			{
				if( usuario.aluno.getMatricula() == matricula )
				{
					usuario.aluno.setMatricula(matricula);
				}
			}
			else
			{
				if( funcao != null)
				{
					usuario.administrador.setFuncao(funcao);
				}
				if( setor != null)
				{
					usuario.administrador.setSetor(setor);
				}
				
			}

		}
		else
		{
			interacao.mensagem("Senha errada!");
		}
	}
	public boolean validador()
	{
		boolean validacao = false;
		boolean validacaoSenha = false;
		boolean validacaoUser = false;
		validacaoSenha = validadorSenha();
		validacaoUser = validadorUsuario();
		if( validacaoSenha && validacaoUser )
		{
			validacao = true;
		}
		return validacao;
	}
	public boolean validadorSenha()
	{
		boolean validacao = false;
		int senhaComparacao = interacao.lerInt(" Validação de usuário:\nDigite sua senha:" );
		if( senhaComparacao == getSenha())
		{
			validacao = true;
		}
		return validacao;
	}
	public boolean validadorUsuario()
	{
		boolean validacao = false;
		String userComparacao = interacao.lerString(" Validação de usuário:\nDigite usuário:" );
		if( userComparacao == getUserPeloSistema())
		{
			validacao = true;
		}
		return validacao;
	}
}
