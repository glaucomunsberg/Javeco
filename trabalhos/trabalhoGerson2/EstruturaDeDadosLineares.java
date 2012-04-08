package trabalhoGerson2;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class EstruturaDeDadosLineares 
{
	protected Fila fila;
	protected Pilha pilha;
	protected Scanner ler;
	protected int escolha;
	protected int escolhaInterna;
	protected String nome;
	protected Aluno aluno;
	
	public static void main(String args[])
	{
		EstruturaDeDadosLineares EDL = new EstruturaDeDadosLineares();
	}
	
	
	public EstruturaDeDadosLineares()
	{
		aluno = new Aluno();  
		ler = new Scanner(System.in);
		fila = new Fila();
		pilha = new Pilha();
		
		for(;;)
		{
			escolha = Integer.parseInt( JOptionPane.showInputDialog(null, "Sistema de Fila e Pilha\n1.Pilha\n2.Fila\n0.Sair\n" , "Escolha", JOptionPane.PLAIN_MESSAGE));
			switch(escolha)
			{
				case 1: manipularPilha();
						break;
				case 2: manipularFila();
						break;
			}
			if(escolha == 0)
			{
				return;
			}
			
		}
	}
	
	public void manipularPilha()
	{
		for(;;)
		{
			escolhaInterna = Integer.parseInt( JOptionPane.showInputDialog(null, "Manipulação de Pilha\n1.Inserir na Pilha\n2. Remover da Pilha\n0.Voltar\n", "Escolha", JOptionPane.PLAIN_MESSAGE));
			switch(escolhaInterna)
			{
				case 1:
					aluno.setIdade(Integer.parseInt( JOptionPane.showInputDialog(null, "Insira um número de Matricula" , "Aluno", JOptionPane.PLAIN_MESSAGE)));
					aluno.setNome( JOptionPane.showInputDialog(null, "Insira o nome do aluno" , "Aluno", JOptionPane.PLAIN_MESSAGE) );
					if( pilha.push(aluno) == 1)
					{
						JOptionPane.showMessageDialog(null, "Inseriu com sucesso!", "Inserção", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Não pode ser inseriu com sucesso!", "Inserção", JOptionPane.ERROR_MESSAGE);
					};
					break;
				case 2:
					if( pilha.isEmpty() )
					{
						JOptionPane.showMessageDialog(null, "A Pilha está vazia", "Remoção", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						aluno = pilha.pop();
						if( aluno == null)
						{
							JOptionPane.showMessageDialog(null, "Encontrado erro!", "Remoção", JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							nome = String.format("Removido:\n %d - %s", aluno.getMatricula(), aluno.getNome());
							JOptionPane.showMessageDialog(null, nome, "Remoção", JOptionPane.INFORMATION_MESSAGE);
						}
					};
					break;
				default:;
			}
			if(escolhaInterna == 0)
			{
				return;
			}
		}
	}
	
	public void manipularFila()
	{
		for(;;)
		{
			escolhaInterna = Integer.parseInt( JOptionPane.showInputDialog(null, "Manipulação de Fila\n\n1.Inserir na Fila\n2.Romever da Fila\n0.Voltar\n","Escolha", JOptionPane.PLAIN_MESSAGE));
			switch(escolhaInterna)
			{
				case 1:
					aluno.setIdade(Integer.parseInt( JOptionPane.showInputDialog(null, "Insira um número de Matricula", "Aluno" , JOptionPane.PLAIN_MESSAGE)));
					aluno.setNome( JOptionPane.showInputDialog(null, "Insira o nome do aluno", "Aluno" , JOptionPane.PLAIN_MESSAGE) );
					if( fila.enqueue(aluno) == 1)
					{
						JOptionPane.showMessageDialog(null, "Inseriu com sucesso!", "Inserção", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Não pode ser inseriu com sucesso!", "Inserção", JOptionPane.ERROR_MESSAGE);
					};
					break;
				case 2:
					if( fila.isEmpty() )
					{
						JOptionPane.showMessageDialog(null, "A Pilha está vazia", "Remoção", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						aluno = fila.dequeue();
						if( aluno == null)
						{
							JOptionPane.showMessageDialog(null, "Encontrado erro!", "Remoção", JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							nome = String.format("Removido:\n %d - %s", aluno.getMatricula(), aluno.getNome());
							JOptionPane.showMessageDialog(null, nome, "Remoção", JOptionPane.INFORMATION_MESSAGE);
						}
					};
					break;
				default:;
			}
			if(escolhaInterna == 0)
			{
				return;
			}
		}
	}

}
