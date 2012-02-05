/** Desenhar
 * 		Classe responsável por fazer o desenho
 * @author glaucoroberto
 *
 */
import javax.swing.JFrame;

public class Desenhar 
{
	private String funcao = "Classe responsável por fazer o desenho";
	private Double versao = 0.0;
	private static Dialogo interacao = new Dialogo();
	public static void main( String args[])
	{
		Desenho desenha = new Desenho();
		JFrame aplicacao = new JFrame();
		
		aplicacao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		desenha.opcaoDeDesenho = interacao.lerInt("Programa para desenhar:\n 1.Linha\n 2.Retangulo\n 3.Oval\n 4.Smile\n 5.Arco-íris");
		aplicacao.add(desenha);
		aplicacao.setSize(500,500);
		aplicacao.setVisible(true);
	}
	public void info()
	{
		String informacao = String.format( "Função: %s.\nVersão:%.2f\n", funcao,versao );
		interacao.mensagem(informacao);
		
	}
}
