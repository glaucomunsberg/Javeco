public class Administrador
{
	private String funcao;
	Administrador()
	{
		
	}
	Administrador(String funcao)
	{
		this.funcao = funcao;
	}
	
	public void setFuncao(String novaFuncao)
	{
		funcao = novaFuncao;
	}
	
	public String getFuncao()
	{
		return funcao;
	}

}
