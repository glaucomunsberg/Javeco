import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ListaDeArquivos extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1568613966520881076L;
	private JTextArea areaDeSaida;
	private JScrollPane scrollArea;
	
	public static void main(String args[] )
	{
		ListaDeArquivos arquivos = new ListaDeArquivos();
		arquivos.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
	}
	
	public ListaDeArquivos()
	{
		super("Testando classe de demostrações de arquivos");
		
		areaDeSaida = new JTextArea();
		scrollArea = new JScrollPane(areaDeSaida);
		
		add(scrollArea, BorderLayout.CENTER);
		setSize(400, 400);
		setVisible(true);
		analyzePath();
		
	}
	
	public void analyzePath()
	{
		File nome = getFile();
		
		if( nome.exists() )
		{
			areaDeSaida.setText( String.format(
					"%s%s\n%s\n%s\n%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s",
					nome.getName(), "Existe",
					( nome.isFile() ? "è um arquivo" : "não é um arquivo"),
					( nome.isDirectory() ? "É um diretório" : "Não é um diretório"),
					( nome.isAbsolute() ? "È um pacote absoluto" : "Não é um pacote absoluto"),
					"Ultima modificação",
					nome.lastModified(), "Tamanho: ", nome.length(),
					"Patch: ", nome.getPath(), "Patch absoluto: ", nome.getAbsolutePath(),
					"Parente: ", nome.getParent()
					) );
			if( nome.isDirectory() )
			{
				String diretorio[] = nome.list();
				for( String diretorioNome: diretorio)
				{
					areaDeSaida.append( diretorioNome + "\n");
				}
			}
		}
		else
		{
				JOptionPane.showConfirmDialog(this, nome+"não existes","ERROR", JOptionPane.ERROR_MESSAGE );
				
		}
	}
	
	private File getFile()
	{
		JFileChooser arquivoEscolha = new JFileChooser();
		
		arquivoEscolha.setFileSelectionMode( JFileChooser.FILES_AND_DIRECTORIES );
		int resultado = arquivoEscolha.showOpenDialog(this);
		
		if( resultado == JFileChooser.CANCEL_OPTION )
		{
			System.exit(1);
		}
		
		java.io.File nomeArquivo = arquivoEscolha.getSelectedFile();
		
		if( (nomeArquivo == null) || ( nomeArquivo.getName().equals("") ) )
		{
			JOptionPane.showMessageDialog(this, "Nome inválido", "Inválido",JOptionPane.ERROR_MESSAGE);
		}
		
		return nomeArquivo;
	}
	

}
