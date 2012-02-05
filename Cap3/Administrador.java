public class Administrador
{
	private String funcao;
	private String setor;
	Administrador()
	{
		
	}
	Administrador(String funcao, String setor)
	{
		this.funcao = funcao;
		this.setor = setor;
	}
	
	public void setFuncao(String novaFuncao)
	{
		funcao = novaFuncao;
	}
	
	public String getFuncao()
	{
		return funcao;
	}
	
	public String getSetor()
	{
		return setor;
	}
	
	public void setSetor(String setor)
	{
		this.setor = setor;
	}
}
