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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Sistema.Lang;
import Sistema.Log;
import Sistema.Paineis;

public class SistemaDoCurso extends JFrame
{
	protected static final long serialVersionUID = -4083184620633799749L;		//Identifador unico
	protected static String nomeDoPrograma;
	
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

		Sistema.Log.openFile(null);
		Sistema.Log.addLog("Sistema iniciado");
		SistemaDoCurso frame = new SistemaDoCurso(nomeDoPrograma);
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(1024,726);
		//Sistema.LogDoSistema.addLog("Sistema carregado com sucesso!");
		

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
	    final Paineis paineis = new Paineis();						//Inicia todos os paineis
        GridBagConstraints cons = new GridBagConstraints();  	//O esquema será de gride sendo o primeiro a cabeça e todos os demais abaixo
        GridBagLayout layout = new GridBagLayout();				//Layout em forma de Gride de uma coluna
        c.setLayout(layout);
        cons.fill = GridBagConstraints.BOTH;
        cons.gridy = 1;
        cons.weightx = 1;
        c.add(paineis.painelCabeca(), cons);
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
		this.addWindowListener(new WindowAdapter() 
		{  
		    public void windowClosing(WindowEvent evt)
		    {
		    	boolean continuar = true;
		    	int codigo = 0;
		    	/**
		    	 * Antes de fechar a janela vai tentar salvar as informações
		    	 * 	que estão foram modificadas no sistema, caso não
		    	 * 	ele simplesmente fecha a janela sem nenhum alerta
		    	 */
		    	do
		    	{
		    		if( Paineis.getHaDadosParaSerGravado())
		    		{
		    			JOptionPane painelDeSaida = new JOptionPane();
		    			painelDeSaida.setFont(Paineis.Config.fonte.getFontTexto());
		    			codigo = JOptionPane.showConfirmDialog(null,"Há dados para ser gravados. Deseja salvar esses dados?!");
		    			if(codigo == 0)
		    			{
		    				boolean gravouComSucesso;
		    				gravouComSucesso = Paineis.gravarDados();
		    				if( gravouComSucesso == false)
		    				{
		    					JOptionPane.showMessageDialog(null, "Atenção não pode ser gravado seus dados");
		    					continuar = false;
		    				}
		    				else
		    				{
		    					continuar = false;
		    				}
		    			}
		    			else
		    			{
		    				continuar = false;
		    			}
		    			
		    		}
		    		else
		    		{
		    			continuar = false;
		    		}
		    		
		    		/*
		    		 * se for fechar realmente então fecha o log
		    		 * 	e os paineis do coletor de lixo
		    		 */
		    		if( continuar == false)
		    		{
		    			Log.closeFile();
		    			paineis.finalize();
		    		}
		    	}while(continuar);
		    	
		    }  
		}); 
        
	}

}