/**
 * Paineis reuni todos os atributos e informações para juntos 
 * 		contituirem o programa. O Paineis contém a implementação 
 * 		dos seguintes paineis:
 * 			- painelCabeca, esse painel é a cabeça do programa
 * 				nele contém o ícone do painel ativo e a descrição 
 * 				desse painel como informativo.
 * 
 * 			- painelHome, contém icones dos três paineis principais
 * 				que levam a informação e edição de dados do sistema,
 * 				curso e aluno.
 * 
 * 			- painelAluno, contendo as informações e capacidade
 * 				de edição dos alunos do curso.
 * 
 * 			- painelConfiguracao, contém as configurações do sistema
 * 				como o icone usado, o tema de fonte, se o log está
 * 				ativo e etc.
 * 			
 * 			- painelCurso, contém as informações restritas ao curso
 * 				em si bem como a capacidade de edição destas mesmas
 * 				informações.
 * 
 * @author glaucoroberto@gmail.com
 * @project SSH: git@github.com:glaucomunsberg/Javeco.git
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
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;					//Trás algumas constantes usandas no alinhamento
import javax.swing.JComboBox;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import Sistema.GerenciadorDoSistema;
import Sistema.Lang;
import Sistema.GerenciadorDoCurso;

enum estadoDoBotao
{
	SALVO, EDITANDO, ADICIONANDO;
}

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
	protected JLabel jlabelInformaNumDeAluno;
	
	protected static boolean flagHaDadosParaGravar = false;
	protected boolean editandoAluno = false;
	protected boolean podeExcluir = false;
	protected boolean dadosConsistentes = false;
	
	protected estadoDoBotao estadoBotaoEditarCurso = estadoDoBotao.SALVO;
	protected estadoDoBotao estadoBotaoEditarAluno = estadoDoBotao.ADICIONANDO;
	
	protected static GerenciadorDoSistema Config;
	protected static GerenciadorDoCurso ConfigCurso;
	
	/**
	 * inicia todos os paineis do sistema através de
	 * 		cada uma das suas implementações
	 */
	public Paineis()
	{	
		Log.addLog("Iniciando os paineis do sistema.");
	
		Config = new GerenciadorDoSistema();
		ConfigCurso = new GerenciadorDoCurso();
		
		implementacaoCabeca();
		implementacaoHome();
		implementacaoCurso();
		implementacaoAluno();
		implementacaoConfiguracoes();
		
	}
	
	/**
	 * retorna o painel da cabeça do sistema
	 * 	ele está implementado em implementacaoCabeca
	 * @return jPanel painelCabeca
	 */
	public JPanel painelCabeca()
	{
		return painelCabeca;
	}
	
	/**
	 * retorna o painel home do sistema
	 * 	ele está implementado em implementacaoHome
	 * @return jPanel painelHome
	 */
	public JPanel painelHome()
	{
		return painelHome;
	}
	
	/**
	 * retorna o painel Configuracao do sistema
	 * 	ele está implementado em implementacaoConfiguracao
	 * @return jPanel painelConfiguracao
	 */
	public JPanel painelConfiguracao()
	{
		return painelConfiguracao;
	}
	
	/**
	 * retorna o painel Curso do sistema
	 * 	ele está implementado em implementacaoCurso
	 * @return jPanel painelCurso
	 */
	public JPanel painelCurso()
	{
		return painelCurso;
	}
	
	/**
	 * retorna o painel Aluno do sistema
	 * 	ele está implementado em implementacaoAluno
	 * @return jPanel painelAluno
	 */
	public JPanel painelAluno()
	{
		return painelAluno;
	}
	
	/**
	 * Implementação do JPanel painelCabeca
	 */
	protected void implementacaoCabeca()
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
		cabecaLabelTexto.setFont(Config.fonte.fonteTitulo);
		
		painelCabeca.setLayout(layout);					//Diz que o JPanel vai receber uma grid com valor variável
		cons.fill = GridBagConstraints.BOTH;			
		cons.weighty = 1;								//Apenas uma linha na vertical
	
		cons.weightx = 0.10;							//a próxima grid terá a porcentagem inserida
		painelCabeca.add( cabecaLabelImagem, cons);
		cons.weightx = 0.90;							//a outra grid terá a porcentagem inserida
		painelCabeca.add(cabecaLabelTexto, cons);
	}

	/**
	 * Implementação do JPanel painelHome
	 */
	protected void implementacaoHome()
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
		labelAluno.setText( Lang.palavras.getString("homeGerenciarAluno"));
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
		
	}

	/**
	 * Implementação do JPanel painelCurso
	 */
	protected void implementacaoCurso()
	{
		painelCurso = new JPanel();
			jlabelInformaNumDeAluno = new javax.swing.JLabel();
			JLabel jlabelObjetivo = new javax.swing.JLabel();
	        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
	        JScrollPane jlabelInformaNumMaximo1 = new javax.swing.JScrollPane();
	        final JTextArea jtextObjetivo = new javax.swing.JTextArea();
	        final JTextArea jlabelNomeDoProfessor = new javax.swing.JTextArea();
	        final JTextArea jlabelInformaNumMaximo = new javax.swing.JTextArea();
	        JLabel jlabelMinistradoPor = new javax.swing.JLabel();
	        JLabel jlabelInfoGerais = new javax.swing.JLabel();
	        JLabel jlabelDataInicio = new javax.swing.JLabel();
	        JLabel jlabelDataFinal = new javax.swing.JLabel();
	        JLabel jlabelInforma1 = new javax.swing.JLabel();
	        JLabel jlabelInforma2 = new javax.swing.JLabel();
	        
	        JLabel jlabelInforma3 = new javax.swing.JLabel();
	        
			final JFormattedTextField jFormattedDataInicio = new javax.swing.JFormattedTextField();
	        final JFormattedTextField jFormattedDataFinal = new javax.swing.JFormattedTextField();
	        final JProgressBar jprogressBarra = new javax.swing.JProgressBar();
	        final JLabel BotaoEditar = new JLabel(Config.icones.salvado, SwingConstants.CENTER);

	        painelCurso.setMinimumSize(new java.awt.Dimension( Constantes.CONST_DEFAULT_LARGURA_MINIMA, Constantes.CONST_DEFAULT_ALTURA_DO_PROGRAMA) );

	        jprogressBarra.setValue( ConfigCurso.getPorcentoDeAlunosNoCurso() );
	        
	        jlabelObjetivo.setText( Lang.palavras.getString("cursoInfoObjetivo") );
	        jlabelObjetivo.setFont( Config.fonte.getFontTitulo() );
	        jtextObjetivo.setText( ConfigCurso.getObjetivo() );
	        jtextObjetivo.setFont( Config.fonte.getFontTexto());
	        jtextObjetivo.setEditable( false );
	        jtextObjetivo.setLineWrap(true);		//Quebra o texto segundo o seu tamanho
	        jtextObjetivo.setWrapStyleWord(true); 	//Quebra apenas em espaço
	        jScrollPane1.setViewportView(jtextObjetivo);
	        jScrollPane1.setFont(Config.fonte.getFontTexto());
	        jScrollPane1.setBorder(null);
	        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

	        jlabelMinistradoPor.setText( Lang.palavras.getString("cursoInfoMinistrado") );
	        jlabelMinistradoPor.setFont( Config.fonte.getFontTitulo());
	        
	        jlabelNomeDoProfessor.setText( ConfigCurso.getNomeProfessor() );
	        jlabelNomeDoProfessor.setBorder(null);
	        jlabelNomeDoProfessor.setEditable(false);
	        jlabelNomeDoProfessor.setFont( Config.fonte.getFontTexto() );

	        jlabelInfoGerais.setText( Lang.palavras.getString("cursoInfoGerais") );
	        jlabelInfoGerais.setFont( Config.fonte.getFontTitulo() );

	        jlabelDataInicio.setText( Lang.palavras.getString("cursoInfoDataInicio") );
	        jlabelDataInicio.setBackground( Color.WHITE );
	        jlabelDataInicio.setFont( Config.fonte.getFontTexto());
	        
	        jlabelDataFinal.setText( Lang.palavras.getString("cursoInfoDataFinal") );
	        jlabelDataFinal.setBackground( Color.WHITE);
	        jlabelDataFinal.setFont( Config.fonte.getFontTexto() );

	        jFormattedDataInicio.setText( ConfigCurso.getInicioCurso());
	        jFormattedDataInicio.setBackground( Color.WHITE );
	        jFormattedDataInicio.setFont( Config.fonte.getFontTexto());
	        jFormattedDataInicio.setEditable(false);

	        jFormattedDataFinal.setText( ConfigCurso.getFinalCurso() );
	        jFormattedDataFinal.setFont( Config.fonte.getFontTexto() );
	        jFormattedDataFinal.setBackground( Color.WHITE );
	        jFormattedDataFinal.setEditable(false);

	        jlabelInforma1.setText(Lang.palavras.getString("cursoInfoDesc1") );
	        jlabelInforma1.setFont( Config.fonte.getFontTexto());

	        jlabelInformaNumMaximo.setText( String.format( "%s", ConfigCurso.getNumeroMaximoDeAluno() ) );
	        jlabelInformaNumMaximo.setFont( Config.fonte.getFontTextoBold() );

	        jlabelInforma2.setText( Lang.palavras.getString("cursoInfoDesc2") );
	        jlabelInforma2.setFont( Config.fonte.getFontTexto() );

	        jlabelInformaNumDeAluno.setText( String.format( "%s", ConfigCurso.getNumeroDeAlunos() ) );
	        jlabelInformaNumDeAluno.setFont( Config.fonte.getFontTextoBold() );

	        jlabelInforma3.setText(Lang.palavras.getString("cursoInfoDesc3"));
	        jlabelInforma3.setFont(Config.fonte.getFontTexto());
	        
	        jlabelInformaNumMaximo1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	        jlabelInformaNumMaximo1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
	        jlabelInformaNumMaximo1.setViewportView(jlabelNomeDoProfessor);
	        jlabelInformaNumMaximo1.setBackground( Color.WHITE );
	        jlabelInformaNumMaximo1.setBorder(null);
	        
	        BotaoEditar.setVisible(true);
	        BotaoEditar.addMouseListener(
	        			new MouseListener()
	        			{
	        				@Override
							public void mouseClicked(MouseEvent arg0) {
	        					if( estadoBotaoEditarCurso == estadoDoBotao.SALVO || estadoBotaoEditarCurso == estadoDoBotao.ADICIONANDO )
	        					{
	        						jFormattedDataFinal.setEditable(true);
	        						jFormattedDataFinal.setBackground( new Color(237, 237, 237) );
	        						jFormattedDataInicio.setEditable(true);
	        						jFormattedDataInicio.setBackground( new Color(237, 237, 237) );
	        						jtextObjetivo.setEditable(true);
	        						jtextObjetivo.setBackground( new Color(237,237,237) );
	        						jlabelNomeDoProfessor.setEditable(true);
	        						jlabelNomeDoProfessor.setBackground( new Color(237,237,237) );
	        						jlabelInformaNumMaximo.setEditable(true);
	        						jlabelInformaNumMaximo.setBackground( new Color(237,237,237) );
	        						BotaoEditar.setIcon( Config.icones.editando);
	        						
	        						estadoBotaoEditarCurso = estadoDoBotao.EDITANDO;
	        						
	        					}
	        					else
	        					{
	        						jFormattedDataFinal.setEditable(false);
	        						jFormattedDataFinal.setBackground( Color.WHITE );
	        						jFormattedDataInicio.setEditable(false);
	        						jFormattedDataInicio.setBackground( Color.WHITE );
	        						jtextObjetivo.setBackground( Color.WHITE );
	        						jtextObjetivo.setEditable(false);
	        						jlabelNomeDoProfessor.setEditable(false);
	        						jlabelNomeDoProfessor.setBackground( Color.WHITE );
	        						jlabelInformaNumMaximo.setEditable(false);
	        						jlabelInformaNumMaximo.setBackground( Color.WHITE );
	        						BotaoEditar.setIcon( Config.icones.salvado);
	        						
	        						ConfigCurso.setInicioCurso( "00/00/00/" + jFormattedDataInicio.getText() );
	        						ConfigCurso.setFinalCurso( "00/00/00/" + jFormattedDataFinal.getText() );
	        						ConfigCurso.setObjetivo( jtextObjetivo.getText());
	        						ConfigCurso.setNomeProfessor( jlabelNomeDoProfessor.getText() );
	        						ConfigCurso.setNumeroMaximoDeAluno( Integer.parseInt( jlabelInformaNumMaximo.getText() ) );
	        						jprogressBarra.setValue( ConfigCurso.getPorcentoDeAlunosNoCurso() );
	        						setHaDadosParaSerGravados(true);
	        						
	        						estadoBotaoEditarCurso = estadoDoBotao.SALVO;
	        					}
	        					
	        					painelCurso.validate();
	        					
								
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
								// TODO Auto-generated method stub
								
							}

							@Override
							public void mouseReleased(MouseEvent arg0) {
								// TODO Auto-generated method stub
								
							}
	        			}
	        		);

	        javax.swing.GroupLayout BotaoEditarLayout = new javax.swing.GroupLayout(BotaoEditar);
	        BotaoEditar.setLayout(BotaoEditarLayout);
	        BotaoEditarLayout.setHorizontalGroup(
	            BotaoEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 76, Short.MAX_VALUE)
	        );
	        BotaoEditarLayout.setVerticalGroup(
	            BotaoEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 81, Short.MAX_VALUE)
	        );

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(painelCurso);
	        painelCurso.setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addContainerGap()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jlabelMinistradoPor, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jlabelObjetivo, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                        .addGap(34, 34, 34)
	                        .addComponent(jlabelInformaNumMaximo1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                            .addGroup(layout.createSequentialGroup()
	                                .addGap(12, 12, 12)
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addComponent(jprogressBarra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                    .addGroup(layout.createSequentialGroup()
	                                        .addComponent(jlabelInformaNumDeAluno)
	                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                        .addComponent(jlabelInforma3))))
	                            .addGroup(layout.createSequentialGroup()
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addGroup(layout.createSequentialGroup()
	                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                                            .addComponent(jlabelDataFinal)
	                                            .addComponent(jlabelDataInicio))
	                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                            .addComponent(jFormattedDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                            .addComponent(jFormattedDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                                    .addGroup(layout.createSequentialGroup()
	                                        .addComponent(jlabelInforma1)
	                                        .addGap(18, 18, 18)
	                                        .addComponent(jlabelInformaNumMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                        .addComponent(jlabelInforma2)))
	                                .addGap(0, 21, Short.MAX_VALUE)))
	                        .addGap(173, 173, 173))
	                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                        .addComponent(BotaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addContainerGap())
	                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                        .addComponent(jlabelInfoGerais, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(52, 52, 52))))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                            .addGroup(layout.createSequentialGroup()
	                                .addContainerGap()
	                                .addComponent(jlabelObjetivo)
	                                .addGap(18, 18, 18)
	                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
	                            .addGroup(layout.createSequentialGroup()
	                                .addGap(78, 78, 78)
	                                .addComponent(jlabelInfoGerais)
	                                .addGap(18, 18, 18)
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                                    .addComponent(jlabelDataInicio)
	                                    .addComponent(jFormattedDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                                    .addComponent(jlabelDataFinal)
	                                    .addComponent(jFormattedDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                                    .addComponent(jlabelInforma1)
	                                    .addComponent(jlabelInformaNumMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addComponent(jlabelInforma2))))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(jlabelInformaNumDeAluno)
	                            .addComponent(jlabelInforma3))
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(layout.createSequentialGroup()
	                                .addGap(32, 32, 32)
	                                .addComponent(jprogressBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                            .addGroup(layout.createSequentialGroup()
	                                .addGap(17, 17, 17)
	                                .addComponent(jlabelMinistradoPor)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                                .addComponent(jlabelInformaNumMaximo1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                        .addGap(0, 80, Short.MAX_VALUE))
	                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                        .addGap(0, 0, Short.MAX_VALUE)
	                        .addComponent(BotaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())
	        );
		
	        painelCurso.setBackground( Color.WHITE);
	        painelCurso.setVisible(false);
	}

	/**
	 * Implementação do JPanel painelAluno
	 */	
	private void implementacaoAluno()
	{		
		
		painelAluno = new JPanel();
		painelAluno.setMinimumSize(new java.awt.Dimension(Constantes.CONST_DEFAULT_LARGURA_MINIMA, Constantes.CONST_DEFAULT_ALTURA_DO_PROGRAMA));
		
        final JTextArea jtextEditarNotaAluno = new javax.swing.JTextArea();
        final JTextArea jtextEditarNomeAluno = new javax.swing.JTextArea();
        final JSlider jSliderConceitoAluno = new javax.swing.JSlider();
        final JLabel BotaoEditar = new javax.swing.JLabel(Config.icones.adicionar, SwingConstants.CENTER);
        final JLabel BotaoExcluir = new javax.swing.JLabel(Config.icones.excluir, SwingConstants.CENTER);
        final JProgressBar jProgressBarMediaAlunos = new javax.swing.JProgressBar();
        final JList jList1 = new javax.swing.JList( new String[] {""} );
        
        JScrollPane jlabelInformaNumMaximo1 = new javax.swing.JScrollPane();
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        JScrollPane jlabelInformaNumMaximo2 = new javax.swing.JScrollPane();
        JLabel jlabelGrupoNome = new javax.swing.JLabel();
        JLabel jlabelGrupoNota = new javax.swing.JLabel();
        JLabel jlabelGrupoConceito = new javax.swing.JLabel();
        JLabel jlabelGrupoAlunos = new javax.swing.JLabel();
        JLabel jlabelGrupoMediaDosAlunos = new javax.swing.JLabel();
      
        
        estadoBotaoEditarCurso = estadoDoBotao.SALVO;
        
        jlabelGrupoAlunos.setText(Lang.palavras.getString("alunoGrupoAlunos") );
        jlabelGrupoAlunos.setFont( Config.fonte.getFontTitulo() );
        
        jList1.setFont( Config.fonte.getFontTexto() );
        jList1.setVisibleRowCount( 10 );
        jList1.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        jList1.addListSelectionListener(
				new ListSelectionListener()
				{
					public void valueChanged( ListSelectionEvent event)
					{
						if( ConfigCurso.getNumeroDeAlunos() > 0)
						{
							BotaoExcluir.setVisible( true);
							podeExcluir = true;
							editandoAluno = true;
							BotaoEditar.setIcon(Config.icones.editando);
							estadoBotaoEditarAluno = estadoDoBotao.EDITANDO;
							
							jtextEditarNomeAluno.setEditable(true);
							jtextEditarNomeAluno.setText( ConfigCurso.getNomeAluno( jList1.getSelectedIndex() ) );
							jtextEditarNotaAluno.setEditable(true);
							jtextEditarNotaAluno.setText( String.format("%s", ConfigCurso.getNotaAluno( jList1.getSelectedIndex() ) ) );
							jSliderConceitoAluno.setEnabled(true);
							jSliderConceitoAluno.setValue( ConfigCurso.getConceitoAluno( jList1.getSelectedIndex() ) );
							jProgressBarMediaAlunos.setValue( ConfigCurso.getMediaDosAlunos() );
							dadosConsistentes = true;
						}
					}
			}
				
		);
        
        jScrollPane1.setViewportView(jList1);
        jScrollPane1.setHorizontalScrollBarPolicy( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        jlabelGrupoNome.setText(Lang.palavras.getString("alunoGrupoNomeAluno"));
        jlabelGrupoNome.setFont( Config.fonte.getFontTitulo() );
        
        jlabelGrupoNota.setText(Lang.palavras.getString("alunoGrupoNotaAluno"));
        jlabelGrupoNota.setFont( Config.fonte.getFontTitulo() );
        
        jlabelGrupoConceito.setText(Lang.palavras.getString("alunoGrupoConceitoAluno"));
        jlabelGrupoConceito.setFont( Config.fonte.getFontTitulo() );
        
        jProgressBarMediaAlunos.setValue( ConfigCurso.getMediaDosAlunos() );
        
        BotaoEditar.setBackground(new java.awt.Color(254, 1, 1));
        BotaoEditar.setPreferredSize(new java.awt.Dimension(80, 80));
        BotaoEditar.addMouseListener(
    			new MouseListener()
    			{
    				@Override
					public void mouseClicked(MouseEvent arg0) {
						
    					/**
    					 * verifica se pode excluir, se pode então
    					 * 	o icone fica visivel, caso não pode pois
    					 * 	não há nada para editar então ele some
    					 */
    					if( podeExcluir)
    					{
    						BotaoExcluir.setVisible(true);
    					}
    					else
    					{
    						BotaoExcluir.setVisible(false);
    					}
    					
						/** ESTADO = ADICIONANDO
						 * abre os campos para inserir
						 */
						if( estadoBotaoEditarAluno == estadoDoBotao.ADICIONANDO )
						{
							BotaoEditar.setIcon( Config.icones.editando);
							estadoBotaoEditarAluno = estadoDoBotao.EDITANDO;
							jtextEditarNomeAluno.setEditable(true);
							jtextEditarNomeAluno.setBackground( new Color(237,237,237) );
							jtextEditarNotaAluno.setEditable(true);
							jtextEditarNotaAluno.setBackground( new Color(237,237,237) );
							jSliderConceitoAluno.setEnabled(true);
							jSliderConceitoAluno.setValue(0);
							jSliderConceitoAluno.setBackground( new Color(237, 237, 237) );
							editandoAluno = false;
							
						}
						else
						{
        					/** ESTADO = SALVO
							 * Se ele está no estado salvo
							 * 	ele automaticamente limpa os campos
							 * 	e volta para o editar;
							 */
        					if( estadoBotaoEditarAluno == estadoDoBotao.SALVO)
							{
								BotaoEditar.setIcon( Config.icones.adicionar);
								estadoBotaoEditarAluno = estadoDoBotao.ADICIONANDO;
								BotaoExcluir.setVisible( false);
								jtextEditarNomeAluno.setText("");
								jtextEditarNomeAluno.setBackground( Color.WHITE );
								jtextEditarNomeAluno.setEditable(false);
								jtextEditarNotaAluno.setText("");
								jtextEditarNotaAluno.setBackground( Color.WHITE );
								jtextEditarNotaAluno.setEditable(false);
								jSliderConceitoAluno.setValue(0);
								jSliderConceitoAluno.setBackground( Color.WHITE );
								jSliderConceitoAluno.setEnabled(false);
								editandoAluno = false;
								podeExcluir = false;
							}
        					else
        					{
    							/** ESTADO = EDITANDO
    							 * se está editando então ele salva
    							 */

    							
    							/**
    							 * essa parte do código fará a verificação do nota e nome
    							 * 	assim evitando que não se possa fazer uma conversao
    							 * indevida de String para char
    							 */
    							
    							String nomeString = jtextEditarNomeAluno.getText();
    							String notaString = jtextEditarNotaAluno.getText();
    							int posicao = jList1.getSelectedIndex();
    							int notaConvertida = 0;
    							
    							//Se o nome não está vazio
    							if(nomeString != null )
    							{
    								dadosConsistentes = true;
    								//Se a nota é vazia passa para 0 caso contrário
    								//tenta converter
    								if( notaString == null )
        							{
        								notaConvertida = 0;
        								dadosConsistentes = true;
        							}
        							else
        							{
        								try
            							{
            								notaConvertida = Integer.parseInt(notaString);
            								dadosConsistentes = true;
            							}
        	    						catch(NumberFormatException numerWrong)
        	    						{
        	    							System.err.printf("%s\n", numerWrong);
        	    							Log.notificarUsuario(Lang.palavras.getString("erroStringNaoConvertidaParaInt"), "WARNING");
        	    							Log.addLog("Atenção! Uma nota precisa ser do tipo Int, erro na atribuição. Novo aluno não atribuido");
        	    							dadosConsistentes = false;
        	    						}
        							}
    								
    							}
    							else
    							{
    								Log.notificarUsuario(Lang.palavras.getString("erroNomeNull"), "WARNING");
    								dadosConsistentes = false;
    							}
    							
    							//Se não tem problemas com os dados então estes são inseridos
    							if( dadosConsistentes )
    							{
    								
    								//Se está editando
    								if(editandoAluno)
    								{
    									editandoAluno = false;
    									podeExcluir = false;
    									dadosConsistentes = false;
    									ConfigCurso.setTodosDadosDeUmAluno(posicao, nomeString, notaConvertida, jSliderConceitoAluno.getValue());
    									jList1.setListData( ConfigCurso.getTodosNomesDeAlunos());
    								}
    								//Se é novo aluno
    								else
    								{
    									editandoAluno = false;
    									podeExcluir = false;
    									dadosConsistentes = false;
    									ConfigCurso.setNovoAluno(nomeString, notaConvertida, jSliderConceitoAluno.getValue());
    									jList1.setListData( ConfigCurso.getTodosNomesDeAlunos());
    	    						}
    							}
    							else
    							{
    								Log.notificarUsuario(Lang.palavras.getString("erroDadosInconsistentes"), "WARNING");
    							}
    							
								jtextEditarNomeAluno.setText("");
								jtextEditarNotaAluno.setText("");
								jSliderConceitoAluno.setValue(0);
								jProgressBarMediaAlunos.setValue( ConfigCurso.getMediaDosAlunos() );
    							BotaoEditar.setIcon( Config.icones.salvado);
    							estadoBotaoEditarAluno = estadoDoBotao.SALVO;
    							jtextEditarNomeAluno.setBackground( Color.WHITE );
    							jtextEditarNotaAluno.setBackground( Color.WHITE );
    							jSliderConceitoAluno.setEnabled(false);
    							
        					}//ELSE_FIM
						}//IF_FIM	
						BotaoEditar.validate();
						painelAluno.validate();
					}//MOUSECLICKED_FIM

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
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
    			}
    		);

        javax.swing.GroupLayout BotaoEditarLayout = new javax.swing.GroupLayout(BotaoEditar);
        BotaoEditar.setLayout(BotaoEditarLayout);
        BotaoEditarLayout.setHorizontalGroup(
            BotaoEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );
        BotaoEditarLayout.setVerticalGroup(
            BotaoEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );
        

        jtextEditarNotaAluno.setColumns(20);
        jtextEditarNotaAluno.setRows(1);
        jtextEditarNotaAluno.setText("");
        jtextEditarNotaAluno.setEditable(false);
        jtextEditarNotaAluno.setBackground( Color.WHITE );
        jlabelInformaNumMaximo1.setBorder(null);
        jlabelInformaNumMaximo1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jlabelInformaNumMaximo1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jlabelInformaNumMaximo1.setViewportView(jtextEditarNotaAluno);

        jtextEditarNomeAluno.setColumns(20);
        jtextEditarNomeAluno.setBackground( Color.WHITE );
        jtextEditarNomeAluno.setRows(1);
        jtextEditarNomeAluno.setBorder(null);
        jtextEditarNomeAluno.setText("");
        jtextEditarNomeAluno.setEditable(false);
        jlabelInformaNumMaximo2.setViewportView(jtextEditarNomeAluno);
        jlabelInformaNumMaximo2.setBorder(null);
        jlabelInformaNumMaximo2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jlabelInformaNumMaximo2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);


        jSliderConceitoAluno.setValue(0);
        jSliderConceitoAluno.setEnabled(false);
        jSliderConceitoAluno.setMaximum(3);
        jSliderConceitoAluno.addChangeListener(new ChangeListener() {
        	@Override
            public void stateChanged(ChangeEvent ce) {
                JSlider slider = (JSlider)ce.getSource();
                if (!slider.getValueIsAdjusting()) {
                    slider.setToolTipText( String.format("%s", jSliderConceitoAluno.getValue()));
                }
            }

			
        });

        jlabelGrupoMediaDosAlunos.setText("Media dos Alunos");
        jlabelGrupoMediaDosAlunos.setFont( Config.fonte.getFontTitulo() );

        BotaoExcluir.setVisible(false);
        BotaoExcluir.setBackground(new java.awt.Color(254, 1, 1));
        BotaoExcluir.setPreferredSize(new java.awt.Dimension(80, 80));
        BotaoExcluir.addMouseListener(
    			new MouseListener()
    			{
    				@Override
					public void mouseClicked(MouseEvent arg0) {
						if(podeExcluir)
						{
							editandoAluno = false;
							podeExcluir = false;
							BotaoEditar.setIcon( Config.icones.salvado );
							estadoBotaoEditarAluno = estadoDoBotao.SALVO;
							ConfigCurso.removeAluno( jList1.getSelectedIndex() );
							jList1.setListData( ConfigCurso.getTodosNomesDeAlunos() );
							
							BotaoExcluir.setVisible(false);
							jtextEditarNomeAluno.setText("");
							jtextEditarNomeAluno.setEditable(false);
							jtextEditarNotaAluno.setText("");
							jtextEditarNotaAluno.setEditable(false);
							jSliderConceitoAluno.setValue(0);
							jSliderConceitoAluno.setEnabled(false);
							
							jList1.validate();
						}
						painelAluno.validate();
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
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
    			}
    		);

        javax.swing.GroupLayout BotaoExcluirLayout = new javax.swing.GroupLayout(BotaoExcluir);
        BotaoExcluir.setLayout(BotaoExcluirLayout);
        BotaoExcluirLayout.setHorizontalGroup(
            BotaoExcluirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );
        BotaoExcluirLayout.setVerticalGroup(
            BotaoExcluirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(painelAluno);
        painelAluno.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlabelGrupoConceito, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(jlabelGrupoNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(258, 258, 258))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlabelInformaNumMaximo2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSliderConceitoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlabelInformaNumMaximo1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlabelGrupoNota, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jlabelGrupoAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 512, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlabelGrupoMediaDosAlunos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jProgressBarMediaAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BotaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlabelGrupoAlunos)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlabelGrupoNome)
                        .addGap(18, 18, 18)
                        .addComponent(jlabelInformaNumMaximo2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jlabelGrupoNota)
                        .addGap(18, 18, 18)
                        .addComponent(jlabelInformaNumMaximo1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jlabelGrupoConceito)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSliderConceitoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(42, 42, 42)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlabelGrupoMediaDosAlunos)
                        .addGap(18, 18, 18)
                        .addComponent(jProgressBarMediaAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BotaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        
	     painelAluno.setVisible(false);
	     painelAluno.setBackground( Color.WHITE );
	}
	
	/**
	 * Implementação do JPanel painelConfigurao
	 */	
	protected void implementacaoConfiguracoes()
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
	        painelConfiguracao.setMinimumSize(new java.awt.Dimension(Constantes.CONST_DEFAULT_LARGURA_MINIMA, Constantes.CONST_DEFAULT_ALTURA_DO_PROGRAMA));

	     comboLinguagem.setModel(new javax.swing.DefaultComboBoxModel( Lang.getComboLinguagens()));
	     comboLinguagem.setBackground(Color.WHITE);
	     comboLinguagem.setEditable(false);
	     comboLinguagem.setSelectedIndex( Lang.getTemaLinguagem());
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
	     comboIcones.setSelectedIndex( Config.icones.getTemaIcone());
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
	     comboFonte.setSelectedIndex( Config.fonte.getTemaFonte());
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
	     labelGrupoConfigTema.setFont( Config.fonte.getFontTitulo());
	     labelGrupoConfigTema.setBackground( Color.white);
	     
	     labelGrupoSistema1.setText( Lang.palavras.getString("configuracaoGrupoInicializacao"));
	     labelGrupoSistema1.setFont( Config.fonte.getFontTitulo());

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
	     checkCriarLog.setSelected(Log.getLogAtivo());
	     checkCriarLog.setBackground( Color.white);
	     checkCriarLog.setFont( Config.fonte.getFontTexto());
	     checkCriarLog.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                if( checkCriarLog.isSelected())
	                {
	                	Log.setLogAtivo(true);
	                	setHaDadosParaSerGravados(true);
	                }
	                else
	                {
	                	Log.setLogAtivo(false);
	                	setHaDadosParaSerGravados(true);
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
	}
	
	/** 
	 * 	No controleDePaineis tem se então o controle
	 * 		de qual dos paineis que serão demonstrados
	 * 		para o usuário segundo o código a cima.
	 * 
	 * 	@param int COD_ID 
	 * 
	 * 	COD_ID = 0001, habilita o jPanel HOME
	 * 	COD_ID = 0010, habilita o jPanel CURSO
	 *  COD_ID = 0011, habilita o jPanel ALUNO
	 *  COD_ID = 0100, habilita o jPanel CONFIGURACAO
	 *  	e desabilita todos os demais menos o
	 *  	jPanel Cabeca
	 */
	private void controleDePaineis(int COD_ID)
	{
		switch(COD_ID)
		{
		
			case 0001:	//Habilita painelHome
				cabecaLabelImagem.setIcon( Config.icones.goHome );
				cabecaLabelTexto.setText(Lang.palavras.getString("cabecaEscolhaModulo"));
				painelHome.setVisible(true);
				painelCurso.setVisible(false);
				painelAluno.setVisible(false);
				painelConfiguracao.setVisible(false);
				break;
			case 0010:	//Habilita painelCurso
				
				jlabelInformaNumDeAluno.setText( String.format("%s", ConfigCurso.getNumeroDeAlunos() ));
				cabecaLabelImagem.setIcon( Config.icones.curso );
				cabecaLabelTexto.setText( Lang.palavras.getString("cabecaCurso"));
				painelHome.setVisible(false);
				painelCurso.setVisible(true);
				painelAluno.setVisible(false);
				painelConfiguracao.setVisible(false);
				break;
			case 0011:	//Habilita painelAluno
				cabecaLabelImagem.setIcon( Config.icones.aluno );
				cabecaLabelTexto.setText( Lang.palavras.getString("cabecaAluno"));
				painelHome.setVisible(false);
				painelCurso.setVisible(false);
				painelAluno.setVisible(true);
				painelConfiguracao.setVisible(false);
				break;
			case 0100: //Habilita painelConfiguracao
				cabecaLabelImagem.setIcon( Config.icones.configuracao );
				cabecaLabelTexto.setText( Lang.palavras.getString("cabecaConfi"));
				painelHome.setVisible(false);
				painelCurso.setVisible(false);
				painelAluno.setVisible(false);
				painelConfiguracao.setVisible(true);
				
				break;
			default:	//Apenas troca o icone e a label da cabeça para o estado desconhecido
				cabecaLabelImagem.setIcon( Config.icones.erro);
				cabecaLabelTexto.setText( Lang.palavras.getString("erroNaCabeca"));
		}
	}

	 /**
	  * Quando um evendo de click acontece, passa-se
	  * 	para o controle de paineis o cod para o
	  * 	evento ser entendido e gerar as ações do
	  * 	comando de click.
	  * @param COD_ID - do evento
	  */
	protected class MouseHandler implements MouseListener
	 {
		 public int COD_ID;	//armazena o codigo de qual frame será ativado
		 
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
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		} 
	 }
	
	/**
	 * Seta se há dados para serem gravados pelo sistema
	 * 		nesse caso não dados da Configuração e do curso
	 */
	public static void setHaDadosParaSerGravados(boolean novoEstado)
	{
		if(novoEstado == true)
		{
			flagHaDadosParaGravar = true;
			Log.addLog("O sistema notifica que há dados para serem gravados");
		}
		else
		{
			flagHaDadosParaGravar = false;
			Log.addLog("O sistema notifica que não há dados para serem gravados");
		}

	}
	
	/**
	 * Retorna se há ou não dados para serem gravados
	 * 	esse método é utilizado pelo sistemaDoCurso para
	 * 	fazer essa verificação quando o usuário tenta
	 * 	fechar a janela
	 * @return boolean
	 */
	public static boolean getHaDadosParaSerGravado()
	{
		return flagHaDadosParaGravar;
	}
	
	/**
	 * Responsável por gravar os dados do sistema e do curso
	 * 		retornando true se travou corretamente ambos os tipos
	 * 		de informação corretamente ou false se algo aconteceu
	 * 		de errado em ambos ou algum dos dois tipos de dados	
	 * @return boolean
	 */
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
	
	/**
	 * Metodo de coleta de lixo ou finalização
	 * 		dos paineis
	 */
	public void finalize()
	{
		//
	}
	

}