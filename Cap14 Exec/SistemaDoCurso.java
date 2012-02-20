/**
 * Bem-Vindo ao main do Javeco - O Programa
 * 
 * 	SistemaDoCuso executará todos os seus modulos
 * 		bem como os subsistemas de log, configurações 
 * 		do sistema e do próprio curso.
 * 
 * @author glaucoroberto@gmail.com
 * @project SSH: git@github.com:glaucomunsberg/Javeco.git
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
import Sistema.Constantes;

public class SistemaDoCurso extends JFrame
{
	protected static final long serialVersionUID = -4083184620633799749L;		//Identifador unico
	protected static String nomeDoPrograma;
	
	/**
	 * main do projeto Javeco - O Programa
	 */
	public static void main( String arhaiugs[])
	{
		Log log = new Log();
		log.openFile();
		Sistema.Log.addLog("Sistema iniciado");
		SistemaDoCurso frame = new SistemaDoCurso();
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(1024,726);
	}

	/**
	 * SistemDoCurso contém a estrutura do programa
	 * 	que será executada, nela é adicionado cada
	 * 	um dos modulos que foram construidos na
	 * 	classe Paineis
	 * @param nomeProPrograma
	 */
	public SistemaDoCurso()
	{		

		Container container = this.getContentPane();
	    final Paineis paineis = new Paineis();
        GridBagConstraints constraint = new GridBagConstraints();  	//O esquema será de gride sendo o primeiro a cabeça e todos os demais abaixo
        GridBagLayout layout = new GridBagLayout();				//Layout em forma de Gride de uma coluna apenas
        container.setLayout(layout);
        
        constraint.fill = GridBagConstraints.BOTH;
        constraint.gridy = 1;
        constraint.weightx = 1;
        container.add(paineis.painelCabeca(), constraint);
        constraint.gridy = 2;
        constraint.weighty = 0.8;
        container.add(paineis.painelHome(), constraint);
        constraint.gridy = 3;
        container.add(paineis.painelConfiguracao(), constraint);
        constraint.gridy = 4;
        container.add(paineis.painelCurso(),constraint);
        constraint.gridy = 5;
        container.add(paineis.painelAluno(), constraint);
        
        Dimension dimensaoMinima = new Dimension(Constantes.CONST_DEFAULT_LARGURA_DO_PROGRAMA, Constantes.CONST_DEFAULT_ALTURA_DO_PROGRAMA);
		container.setMinimumSize(dimensaoMinima);
		
		super.setTitle(Lang.palavras.getString("programaNome"));		//Insere o nome do programa apos iniciar o GerenciadorDoSistema em Paineis
		this.setMinimumSize(dimensaoMinima);
		this.addWindowListener(new WindowAdapter() 						//Escurá se for pedido para fechar a janela
		{  
		    public void windowClosing(WindowEvent evt)
		    {
		    	/**
		    	 * Antes de fechar a janela vai tentar salvar as informações
		    	 * 	que estão foram modificadas no sistema, caso não
		    	 * 	ele simplesmente fecha a janela sem nenhum alerta
		    	 */
		    	boolean continuar = true;
		    	int codigo = 0;
		    	do
		    	{
		    		if( Paineis.getHaDadosParaSerGravado())
		    		{
		    			codigo = JOptionPane.showConfirmDialog(null, Lang.palavras.getString("sysDesejaGravar"), Lang.palavras.getString("sysHaDadosParaGrava"), JOptionPane.INFORMATION_MESSAGE);
		    			if(codigo == 0)
		    			{
		    				boolean gravouComSucesso;
		    				gravouComSucesso = Paineis.gravarDados();
		    				if( gravouComSucesso == false)
		    				{
		    					JOptionPane.showMessageDialog(null, "Atenção não pode ser gravado seus dados");
		    					continuar = false;
		    				}

		    			}
		    		}
		    		
		    		/*
		    		 * se for fechar realmente então fecha o log
		    		 * 	e os paineis do coletor de lixo
		    		 */
		    		Log.closeFile();
		    		paineis.finalize();
		    		continuar = false;

		    	}while(continuar);

		    }  
		}); 
        
	}

}