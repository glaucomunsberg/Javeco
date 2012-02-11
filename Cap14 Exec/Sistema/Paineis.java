/**
 * Aqui está a implementação de todos os Paineis
 * 	que iram constituir o SistemaDoCurso
 */
package Sistema;								//Constitui parte do Sistema
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;						//Gera o layout em forma de grid
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;				//Trás algumas constantes usandas no alinhamento
import java.io.File;

import Sistema.GerenciadorDoSistema;
import Sistema.GerenciadorDoSistema.HowStart;
import Sistema.Lang;

public class Paineis
{	
	protected JPanel painelCabeca;
	protected JPanel painelHome;
	protected JPanel painelCurso;
	protected JPanel painelAluno;
	protected JPanel painelConfiguracao;
	
	protected JLabel cabecaLabelTexto;
	protected JLabel cabecaLabelImagem;
	protected JLabel notificationTexto;
	
	public GerenciadorDoSistema ConfigSistema;
	public GerenciadorDoCurso ConfigCurso;
	public HowStart comoIniciar;
	
	public Paineis()
	{	
		LogDoSistema.addLog("Iniciando os paineis do sistema.");
		File arqConfigs = new File("Cap14 Exec/Sistema/Configs/configs.ser");
		
		if( arqConfigs.isFile() )
		{
			comoIniciar = HowStart.RECUPERAR;
		}
		else
		{
			comoIniciar = HowStart.DEFAULT;
		}
		ConfigSistema = new GerenciadorDoSistema( comoIniciar);
		ConfigCurso = new GerenciadorDoCurso( comoIniciar );
		painelCabeca = cabecaImplementacao();
		painelHome = homeImplementacao();
		painelCurso = cursoImplementacao();
		painelAluno = alunoImplementacao();
		painelConfiguracao = configuracaoImplementacao();
		
	}
	
	/**
	 * retorna o painel da cabeça do sistema
	 * 	ele está implementado em Cabeca
	 * @param texto
	 * @return
	 */
	public JPanel painelCabeca(String texto)
	{
		return painelCabeca;
	}
	
	
	public JPanel painelHome()
	{
		return painelHome;
	}
	public JPanel painelConfiguracao()
	{
		return painelConfiguracao;
	}
	
	public JPanel painelCurso()
	{
		return painelCurso;
	}
	
	public JPanel painelAluno()
	{
		return painelAluno;
	}
	
	protected JPanel cabecaImplementacao()
	{
		//		-----------------------------------------------------------------------
		//      |            |                                                        |
		//		|   ICONES   |             Testos de ilustracoes                      |
		//      |            |                                                        |
		//      -----------------------------------------------------------------------
		
		
		painelCabeca = new JPanel();						//Painel que será retornado
		GridBagConstraints cons = new GridBagConstraints();	//Diz o tamanho que ocupará no JPanel
		GridBagLayout layout = new GridBagLayout();			//Layout para a JPanel de grid de tamanho variado
		
		cabecaLabelImagem = new JLabel( ConfigSistema.icones.goHome, JLabel.CENTER);
		cabecaLabelImagem.addMouseListener(new MouseHandler(001) );
		cabecaLabelImagem.setToolTipText( Lang.palavras.getString("cabecaDescricao"));
		
		cabecaLabelTexto = new JLabel(Lang.palavras.getString("cabecaBemVindoEscolha"), JLabel.CENTER);
		cabecaLabelTexto.setFont(ConfigSistema.fonte.fontTitulo);
		
		painelCabeca.setLayout(layout);					//Diz que o JPanel vai receber uma grid com valor variável
		cons.fill = GridBagConstraints.BOTH;			
		cons.weighty = 1;								//Apenas uma linha na vertical
	
		cons.weightx = 0.10;							//a próxima grid terá a porcentagem inserida
		painelCabeca.add( cabecaLabelImagem, cons);
		cons.weightx = 0.90;							//a outra grid terá a porcentagem inserida
		painelCabeca.add(cabecaLabelTexto, cons);
		return painelCabeca;
	}
	
	protected JPanel homeImplementacao()
	{
		//		-----------------------------------------------------------------------
		//      |                                                                     |
		//		|																	  |
		//		|		labelCurso		  labelAluno		labelConfiguracao		  |
		//      |                                                                     |
		//		|																	  |
		//		-----------------------------------------------------------------------
		
		JLabel labelCurso;
		JLabel labelAluno;
		JLabel labelConfiguracao;
		
		painelHome = new JPanel();
		painelHome.setLayout(new GridLayout(0, 3));
		painelHome.setBackground(Color.WHITE);
		
		
		labelCurso = new JLabel( ConfigSistema.icones.curso, SwingConstants.CENTER);
		labelCurso.setText( Lang.palavras.getString("homeGerenciarCurso"));
		labelCurso.setHorizontalTextPosition( SwingConstants.CENTER);	//manipula o texto centralizando no horizonte
		labelCurso.setVerticalTextPosition( SwingConstants.BOTTOM);		//manipula o texto colocando na parte de baixo do rotulo
		labelCurso.setFont( ConfigSistema.fonte.getFontTexto() );
		labelCurso.addMouseListener(new MouseHandler(0010) );
		painelHome.add(labelCurso);
		
		labelAluno = new JLabel( ConfigSistema.icones.aluno, SwingConstants.CENTER);
		labelAluno.setText( Lang.palavras.getString("homeGerenciarCurso"));
		labelAluno.setHorizontalTextPosition( SwingConstants.CENTER);	//manipula o texto centralizando no horizonte
		labelAluno.setVerticalTextPosition( SwingConstants.BOTTOM);		//manipula o texto colocando na parte de baixo do rotulo
		labelAluno.setFont( ConfigSistema.fonte.getFontTexto());
		labelAluno.addMouseListener(new MouseHandler(0011) );
		painelHome.add(labelAluno);
		
		labelConfiguracao = new JLabel( ConfigSistema.icones.configuracao, SwingConstants.CENTER);
		labelConfiguracao.setText( Lang.palavras.getString("homeGerenciarConfi"));
		labelConfiguracao.setHorizontalTextPosition( SwingConstants.CENTER);	//manipula o texto centralizando no horizonte
		labelConfiguracao.setVerticalTextPosition( SwingConstants.BOTTOM);		//manipula o texto colocando na parte de baixo do rotulo
		labelConfiguracao.setFont( ConfigSistema.fonte.getFontTexto());
		labelConfiguracao.addMouseListener(new MouseHandler(0100));
		painelHome.add(labelConfiguracao);
		
		return painelHome;
	}
	
	private JPanel cursoImplementacao()
	{
		//		-----------------------------------------------------------------------
		//      |                                                                     |
		//		|																	  |
		//		|								labelUI								  |
		//      |                                                                     |
		//		|																	  |
		//		-----------------------------------------------------------------------
		
		
		GridBagLayout layout = new GridBagLayout();
		painelCurso = new JPanel();
		painelCurso.setLayout(layout);
		painelCurso.setBackground(Color.WHITE);
		painelCurso.setVisible(false);
		JLabel labelUI = new JLabel( ConfigSistema.icones.curso, SwingConstants.CENTER);
		painelCurso.add(labelUI);
		
		return painelCurso;
	}
	
	private JPanel alunoImplementacao()
	{
		//		-----------------------------------------------------------------------
		//      |                                                                     |
		//		|																	  |
		//		|								labelUI								  |
		//      |                                                                     |
		//		|																	  |
		//		-----------------------------------------------------------------------
		
		
		GridBagLayout layout = new GridBagLayout();
		painelAluno = new JPanel();
		painelAluno.setLayout(layout);
		painelAluno.setBackground(Color.WHITE);
		painelAluno.setVisible(false);
		JLabel labelUI = new JLabel( ConfigSistema.icones.aluno, SwingConstants.CENTER);
		painelAluno.add(labelUI);
		
		return painelAluno;
	}
	
	
	protected JPanel configuracaoImplementacao()
	{
		//		-----------------------------------------------------------------------
		//      |                                                                     |
		//		|																	  |
		//		|								labelUI								  |
		//      |                                                                     |
		//		|																	  |
		//		-----------------------------------------------------------------------
		
		GridBagLayout layout = new GridBagLayout();
		
		painelConfiguracao = new JPanel();
		painelConfiguracao.setLayout(layout);
		painelConfiguracao.setBackground(Color.WHITE);
		painelConfiguracao.setVisible(false);
		
		JLabel labelUI = new JLabel( ConfigSistema.icones.configuracao, SwingConstants.CENTER);
		painelConfiguracao.add(labelUI);
		
		return painelConfiguracao;
	}
	
	/** COD_ID = 0001, habilita o frame HOME
	 * 	COD_ID = 0010, habilita o frame CURSO
	 *  COD_ID = 0011, habilita o frame ALUNO
	 *  COD_ID = 0100, habilita o frame CONFIGURACAO
	 *  COD_ID = 0101, habilita o frame CURSO - EDITAR
	 *  COD_ID = 0110, habilita o frame ALUNO - EDITAR
	 *  
	 * 	
	 * 	No controleDePaineis tem se então o controle
	 * 		de qual dos paineis que serão demonstrados
	 * 		para o usuário segundo o código a cima.
	 * 	@return imageIcon icone do frame habilitado
	 * 	
	 */
	private void controleDePaineis(int COD_ID)
	{
		switch(COD_ID)
		{
		
			case 0001:
				cabecaLabelImagem.setIcon( ConfigSistema.icones.goHome );
				cabecaLabelTexto.setText(Lang.palavras.getString("cabecaEscolhaModulo"));
				painelHome.setVisible(true);
				painelCurso.setVisible(false);
				painelAluno.setVisible(false);
				painelConfiguracao.setVisible(false);
				break;
			case 0010:
				cabecaLabelImagem.setIcon( ConfigSistema.icones.curso );
				cabecaLabelTexto.setText( Lang.palavras.getString("cabecaEscolhaModulo"));
				painelHome.setVisible(false);
				painelCurso.setVisible(true);
				painelAluno.setVisible(false);
				painelConfiguracao.setVisible(false);
				break;
			case 0011:
				cabecaLabelImagem.setIcon( ConfigSistema.icones.aluno );
				cabecaLabelTexto.setText( Lang.palavras.getString("cabecaAluno"));
				painelHome.setVisible(false);
				painelCurso.setVisible(false);
				painelAluno.setVisible(true);
				painelConfiguracao.setVisible(false);
				break;
			case 0100:
				cabecaLabelImagem.setIcon( ConfigSistema.icones.configuracao );
				cabecaLabelTexto.setText( Lang.palavras.getString("cabecaConfi"));
				painelHome.setVisible(false);
				painelCurso.setVisible(false);
				painelAluno.setVisible(false);
				painelConfiguracao.setVisible(true);
				
				break;
			default:
				cabecaLabelImagem.setIcon( ConfigSistema.icones.erro);
				cabecaLabelTexto.setText( Lang.palavras.getString("erroNaCabeca"));
		}
	}
	
	protected class MouseHandler implements MouseListener
	 {
		 public int COD_ID;	//armazena o codigo de qual frame será ativado
		 
		 /**
		  * Quando um evendo de click acontece, passa-se
		  * 	para o controle de paineis o cod para o
		  * 	evento ser entendido e gerar as ações do
		  * 	comando de click.
		  * @param cod - do evento
		  */
		 public MouseHandler(int cod)
		 {
			 COD_ID = cod;
		 }

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub 
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			controleDePaineis(COD_ID);
			System.out.printf("Próximo painel: %d\n", COD_ID);
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		 
	 }

}