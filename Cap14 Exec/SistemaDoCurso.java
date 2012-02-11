/**
 * Bem-Vindo ao codigo do executador do
 * 		OCurso
 * 
 * SistemaDoCuso executará todos os seus modulos
 * 		bem como os subsistemas de log, 
 * 		configurações do sistema e do próprio curso
 */


import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

import Sistema.Lang;
import Sistema.Paineis;

public class SistemaDoCurso extends JFrame
{
	protected static final long serialVersionUID = -4083184620633799749L;		//Identifador unico
	protected static String nomeDoPrograma = "OCurso - Versão 0.5 (beta)";
	
	/**
	 * Executará o programa, recebe parametros
	 * caso não se queira as configurações default
	 * 
	 * @param args[0] String nomeDoPrograma
	 * @param args[1] String alturaDaJanela
	 * @param args[2] String comprimeitoDaJanela
	 */
	
	public static void main( String args[])
	{


		if( args.length >= 3)
		{

			nomeDoPrograma 		= args[0];
			Sistema.LogDoSistema.openFile(args[1]);
			Sistema.LogDoSistema.addLog("OCurso - Versão 0.5 (beta)");
		}
		else
		{
			Sistema.LogDoSistema.openFile(null);
			Sistema.LogDoSistema.addLog(nomeDoPrograma);
		}
		SistemaDoCurso frame = new SistemaDoCurso(nomeDoPrograma);
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(1024,726);
		//frame.pack();
		Sistema.LogDoSistema.addLog("Sistema carregado com sucesso!");

	}

	/**
	 * SistemDoCurso contém a estrutura do programa
	 * 	que será executada, nela é adicionado cada
	 * 	um dos modulos que foram construidos como
	 * 	paineis
	 * @param nomeProPrograma
	 */
	public SistemaDoCurso(String nomeProPrograma)
	{		

		Container c = this.getContentPane();  					//Pega o container deste Frame
	    Paineis paineis = new Paineis();						//Inicia todos os paineis
        GridBagConstraints cons = new GridBagConstraints();  	//O esquema será de gride sendo o primeiro a cabeça e todos os demais abaixo
        GridBagLayout layout = new GridBagLayout();				//Layout em forma de Gride de uma coluna
        c.setLayout(layout);
        cons.fill = GridBagConstraints.BOTH;
        cons.gridy = 1;
        cons.weightx = 1;
        c.add(paineis.painelCabeca("0"), cons);
        cons.gridy = 2;
        cons.weighty = 0.8;
        c.add(paineis.painelHome(), cons);
        cons.gridy = 3;
        c.add(paineis.painelConfiguracao(), cons);
        cons.gridy = 4;
        c.add(paineis.painelCurso(),cons);
        cons.gridy = 5;
        c.add(paineis.painelAluno(), cons);
        Dimension arg0 = new Dimension(1024, 700);
		c.setMinimumSize(arg0);
		super.setTitle(Lang.palavras.getString("programaNome"));		//Insere o titulo da janela
		this.setMinimumSize(arg0);
        
	}

}