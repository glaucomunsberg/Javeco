/**
 * Aqui está a implementação de todos os Paineis
 * 	que iram constituir o SistemaDoCurso
 */
package Sistema;								//Constitui parte do Sistema
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;						//Gera o layout em forma de grid
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;				//Trás algumas constantes usandas no alinhamento
import javax.swing.JComboBox;


import Sistema.GerenciadorDoSistema;
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
	
	protected static boolean flagHaDadosParaGravar = false;
	public static GerenciadorDoSistema Config;
	public static GerenciadorDoCurso ConfigCurso;
	
	public Paineis()
	{	
		Logs.addLog("Iniciando os paineis do sistema.");
		
	
		Config = new GerenciadorDoSistema();
		ConfigCurso = new GerenciadorDoCurso();
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
		
		
		painelCabeca = new JPanel();//Painel que será retornado
		GridBagConstraints cons = new GridBagConstraints();	//Diz o tamanho que ocupará no JPanel
		GridBagLayout layout = new GridBagLayout();			//Layout para a JPanel de grid de tamanho variado
		
		cabecaLabelImagem = new JLabel( Config.icones.goHome, JLabel.CENTER);
		cabecaLabelImagem.addMouseListener(new MouseHandler(001) );
		cabecaLabelImagem.setToolTipText( Lang.palavras.getString("cabecaDescricao"));
		cabecaLabelTexto = new JLabel(Lang.palavras.getString("cabecaBemVindoEscolha"), JLabel.CENTER);
		cabecaLabelTexto.setFont(Config.fonte.fontTitulo);
		
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
		
		
		labelCurso = new JLabel( Config.icones.curso, SwingConstants.CENTER);
		labelCurso.setText( Lang.palavras.getString("homeGerenciarCurso"));
		labelCurso.setHorizontalTextPosition( SwingConstants.CENTER);	//manipula o texto centralizando no horizonte
		labelCurso.setVerticalTextPosition( SwingConstants.BOTTOM);		//manipula o texto colocando na parte de baixo do rotulo
		labelCurso.setFont( Config.fonte.getFontTexto() );
		labelCurso.addMouseListener(new MouseHandler(0010) );
		painelHome.add(labelCurso);
		
		labelAluno = new JLabel( Config.icones.aluno, SwingConstants.CENTER);
		labelAluno.setText( Lang.palavras.getString("homeGerenciarCurso"));
		labelAluno.setHorizontalTextPosition( SwingConstants.CENTER);	//manipula o texto centralizando no horizonte
		labelAluno.setVerticalTextPosition( SwingConstants.BOTTOM);		//manipula o texto colocando na parte de baixo do rotulo
		labelAluno.setFont( Config.fonte.getFontTexto());
		labelAluno.addMouseListener(new MouseHandler(0011) );
		painelHome.add(labelAluno);
		
		labelConfiguracao = new JLabel( Config.icones.configuracao, SwingConstants.CENTER);
		labelConfiguracao.setText( Lang.palavras.getString("homeGerenciarConfi"));
		labelConfiguracao.setHorizontalTextPosition( SwingConstants.CENTER);	//manipula o texto centralizando no horizonte
		labelConfiguracao.setVerticalTextPosition( SwingConstants.BOTTOM);		//manipula o texto colocando na parte de baixo do rotulo
		labelConfiguracao.setFont( Config.fonte.getFontTexto());
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
		JLabel labelUI = new JLabel( Config.icones.curso, SwingConstants.CENTER);
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
		JLabel labelUI = new JLabel( Config.icones.aluno, SwingConstants.CENTER);
		painelAluno.add(labelUI);
		
		return painelAluno;
	}
	
	
	protected JPanel configuracaoImplementacao()
	{
		painelConfiguracao = new JPanel();
		
		 JPanel jPanel1 = new javax.swing.JPanel();
	     final JComboBox comboLinguagem = new javax.swing.JComboBox();
	     final JComboBox comboIcones = new javax.swing.JComboBox();
	     final JComboBox comboFonte = new javax.swing.JComboBox();
	     JLabel labelLinguagem = new javax.swing.JLabel();
	     JLabel labelFonte = new javax.swing.JLabel();
	     JLabel labelIcones = new javax.swing.JLabel();
	     final JLabel labelNotificacao = new javax.swing.JLabel();
	     JLabel labelGrupoConfigTema = new javax.swing.JLabel();
	     JLabel labelGrupoSistema1 = new javax.swing.JLabel();
	     JLabel labelIniciarRecuperando = new javax.swing.JLabel();
	     JLabel labelCriandoLog = new javax.swing.JLabel();
	     JCheckBox ckeckRecuperarDados = new javax.swing.JCheckBox();
	     final JCheckBox checkCriarLog = new javax.swing.JCheckBox();
	     JLabel labelIniciarRecuperando1 = new javax.swing.JLabel();

	     javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
	     jPanel1.setLayout(jPanel1Layout);
	     jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 100, Short.MAX_VALUE)
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 100, Short.MAX_VALUE)
	        );

	        painelConfiguracao.setBackground(Color.white);
	        painelConfiguracao.setBorder(null);
	        painelConfiguracao.setMinimumSize(new java.awt.Dimension(Constantes.CONST_DEFAULT_LARGURA, 5));

	     comboLinguagem.setModel(new javax.swing.DefaultComboBoxModel( Lang.getComboLinguagens()));
	     comboLinguagem.setBackground(Color.WHITE);
	     comboLinguagem.setFont( Config.fonte.getFontTexto());
	     comboLinguagem.addItemListener(																										//|
					//Classe interna e anonima do Handler				//|
     			new ItemListener()													//adiciona um escutador de evento 					//|
     				{																														//| seta o comportamento
     					public void itemStateChanged( ItemEvent event)					//IDentifica se houve mudança						//|   da combo.
     					{																													//|
     						if(event.getStateChange() == ItemEvent.SELECTED)			//Verifica o evento e selecionado 					//|
     						{																												//|
     							Config.lang.setNovoIdioma( comboLinguagem.getSelectedIndex() );
     							labelNotificacao.setText( Lang.palavras.getString("configuracaoModifLingua"));
     							labelNotificacao.setVisible(true);
     							setHaDadosParaSerGravados(true);
     						}																												//|
     					}																													//|
     				}																														//|
     		);
	     comboIcones.setModel(new javax.swing.DefaultComboBoxModel( Icone.getComboIcones()));
	     comboIcones.setBackground( Color.WHITE);
	     comboIcones.setFont( Config.fonte.getFontTexto());
	     comboIcones.addItemListener(																										//|
					//Classe interna e anonima do Handler				//|
     			new ItemListener()													//adiciona um escutador de evento 					//|
     				{																														//| seta o comportamento
     					public void itemStateChanged( ItemEvent event)					//IDentifica se houve mudança						//|   da combo.
     					{																													//|
     						if(event.getStateChange() == ItemEvent.SELECTED)			//Verifica o evento e selecionado 					//|
     						{																												//|
     							Config.icones = new Icone( comboIcones.getSelectedIndex() );
     							labelNotificacao.setText(Lang.palavras.getString("configuracaoModifIcones"));
     							labelNotificacao.setVisible(true);
     							setHaDadosParaSerGravados(true);
     						}																												//|
     					}																													//|
     				}																														//|
     		);

	     comboFonte.setModel(new javax.swing.DefaultComboBoxModel( Config.fonte.getComboFontes()));
	     comboFonte.setBackground( Color.WHITE);
	     comboFonte.setFont( Config.fonte.getFontTexto());
	     comboFonte.addItemListener(
	    		 new ItemListener()
	    		 {
	    			public void itemStateChanged(ItemEvent event)
	    			{
	    				if( event.getStateChange() == ItemEvent.SELECTED)
	    				{
	    					Config.fonte = new Fonte( comboFonte.getSelectedIndex());
	    					labelNotificacao.setText( Lang.palavras.getString("configuracaoModifFone"));
	    					labelNotificacao.setVisible(true);
	    					setHaDadosParaSerGravados(true);
	    				}
	    			}
	    		 }
	    		 
	    		 );
	     
	     labelLinguagem.setText( Lang.palavras.getString("configuracaoLinguagem"));
	     labelLinguagem.setFont( Config.fonte.getFontTexto());
	     labelLinguagem.setBackground( Color.WHITE);

	     labelFonte.setText( Lang.palavras.getString("configuracaoFonte"));
	     labelFonte.setBackground( Color.WHITE);
	     labelFonte.setFont( Config.fonte.getFontTexto());

	     labelIcones.setText( Lang.palavras.getString("configuracaoIcones"));
	     labelIcones.setBackground( Color.WHITE);
	     labelIcones.setFont( Config.fonte.getFontTexto());

	     labelNotificacao.setText("Notificações...");
	     labelNotificacao.setVisible(false);
	     labelNotificacao.setFont( Config.fonte.getFontTexto());

	     labelGrupoConfigTema.setText(Lang.palavras.getString("configuracaoGrupoTema"));
	     labelGrupoConfigTema.setFont( Config.fonte.getFontTexto());
	     labelGrupoConfigTema.setBackground( Color.white);
	     
	     labelGrupoSistema1.setText( Lang.palavras.getString("configuracaoGrupoInicializacao"));
	     labelGrupoSistema1.setFont( Config.fonte.getFontTexto());

	     labelIniciarRecuperando.setText( Lang.palavras.getString("configuracaoIniciarComDados"));
	     labelIniciarRecuperando.setFont( Config.fonte.getFontTexto());

	     labelCriandoLog.setText(Lang.palavras.getString("configuracaoIniciarComLog"));
	     labelCriandoLog.setFont( Config.fonte.getFontTexto());
	     

	     ckeckRecuperarDados.setText(Lang.palavras.getString("configuracaoSim"));
	     ckeckRecuperarDados.setFont( Config.fonte.getFontTexto());
	     ckeckRecuperarDados.setBackground(Color.white);
	     ckeckRecuperarDados.addActionListener(new java.awt.event.ActionListener() {
	          public void actionPerformed(java.awt.event.ActionEvent evt) {
	                System.out.printf("implementar o recuperar dados!\n");
	                setHaDadosParaSerGravados(true);
	            }
	        });

	     checkCriarLog.setText(Lang.palavras.getString("configuracaoSim"));
	     checkCriarLog.setSelected(Logs.getLogAtivo());
	     checkCriarLog.setBackground( Color.white);
	     checkCriarLog.setFont( Config.fonte.getFontTexto());
	     checkCriarLog.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                if( checkCriarLog.isSelected())
	                {
	                	Logs.setLogAtivo(true);
	                	setHaDadosParaSerGravados(true);
	                	System.out.print("Você ativou!\n");
	                }
	                else
	                {
	                	Logs.setLogAtivo(false);
	                	setHaDadosParaSerGravados(true);
	                	System.out.print("Você desativou!\n");
	                }
	            }
	        });

	     javax.swing.GroupLayout layout = new javax.swing.GroupLayout(painelConfiguracao);
	     painelConfiguracao.setLayout(layout);
	     layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(labelNotificacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(labelGrupoConfigTema)
	                        .addGap(0, 0, Short.MAX_VALUE))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(28, 28, 28)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(layout.createSequentialGroup()
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                                    .addGroup(layout.createSequentialGroup()
	                                        .addGap(25, 25, 25)
	                                        .addComponent(comboIcones, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
	                                    .addComponent(labelIcones)
	                                    .addComponent(labelFonte))
	                                .addContainerGap())
	                            .addGroup(layout.createSequentialGroup()
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addGroup(layout.createSequentialGroup()
	                                        .addGap(25, 25, 25)
	                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                            .addComponent(comboLinguagem, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                            .addComponent(comboFonte, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                                    .addComponent(labelLinguagem))
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addComponent(labelGrupoSistema1)
	                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                                            .addComponent(labelCriandoLog)
	                                            .addGroup(layout.createSequentialGroup()
	                                                .addGap(347, 347, 347)
	                                                .addComponent(checkCriarLog))
	                                            .addGroup(layout.createSequentialGroup()
	                                                .addComponent(labelIniciarRecuperando)
	                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                                .addComponent(ckeckRecuperarDados)))))
	                                .addGap(116, 116, 116))))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(714, 714, 714)
	                        .addComponent(labelIniciarRecuperando1)
	                        .addContainerGap())))
	        );
	     layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(23, 23, 23)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(labelGrupoConfigTema)
	                        .addGap(18, 18, 18)
	                        .addComponent(labelLinguagem)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(comboLinguagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(30, 30, 30)
	                        .addComponent(labelFonte))
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(labelGrupoSistema1)
	                        .addGap(18, 18, 18)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                            .addComponent(ckeckRecuperarDados)
	                            .addComponent(labelIniciarRecuperando))
	                        .addGap(18, 18, 18)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(labelCriandoLog)
	                            .addComponent(checkCriarLog))))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(comboFonte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(33, 33, 33)
	                .addComponent(labelIcones)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(comboIcones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(labelIniciarRecuperando1)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
	                .addComponent(labelNotificacao))
	        );
	     painelConfiguracao.setVisible(false);
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
				cabecaLabelImagem.setIcon( Config.icones.goHome );
				cabecaLabelTexto.setText(Lang.palavras.getString("cabecaEscolhaModulo"));
				painelHome.setVisible(true);
				painelCurso.setVisible(false);
				painelAluno.setVisible(false);
				painelConfiguracao.setVisible(false);
				break;
			case 0010:
				cabecaLabelImagem.setIcon( Config.icones.curso );
				cabecaLabelTexto.setText( Lang.palavras.getString("cabecaEscolhaModulo"));
				painelHome.setVisible(false);
				painelCurso.setVisible(true);
				painelAluno.setVisible(false);
				painelConfiguracao.setVisible(false);
				break;
			case 0011:
				cabecaLabelImagem.setIcon( Config.icones.aluno );
				cabecaLabelTexto.setText( Lang.palavras.getString("cabecaAluno"));
				painelHome.setVisible(false);
				painelCurso.setVisible(false);
				painelAluno.setVisible(true);
				painelConfiguracao.setVisible(false);
				break;
			case 0100:
				cabecaLabelImagem.setIcon( Config.icones.configuracao );
				cabecaLabelTexto.setText( Lang.palavras.getString("cabecaConfi"));
				painelHome.setVisible(false);
				painelCurso.setVisible(false);
				painelAluno.setVisible(false);
				painelConfiguracao.setVisible(true);
				
				break;
			default:
				cabecaLabelImagem.setIcon( Config.icones.erro);
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
	
	/**
	 * flag de que há dados para ser gravados
	 */
	public static void setHaDadosParaSerGravados(boolean novoEstado)
	{
		if(novoEstado == true)
		{
			flagHaDadosParaGravar = true;
			System.out.printf("Há dados para ser gravados");
		}
		else
		{
			flagHaDadosParaGravar = false;
			System.out.printf("Não há dados para ser gravados");
		}
		
		
	}
	
	public static boolean getHaDadosParaSerGravado()
	{
		return flagHaDadosParaGravar;
	}
	public static boolean gravarDados()
	{
		boolean temp;
		temp = (Config.gravarArquivoSerializado() && ConfigCurso.gravarArquivoSerializado());
		if( temp == true)
		{
			setHaDadosParaSerGravados(false);
			return  true;
		}
		else
		{
			setHaDadosParaSerGravados(true);
			return false;
		}
	}
	
	public void finalize()
	{
		//System.out.println("Finalizando configs temporário");
	}

}