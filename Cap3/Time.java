/** Time
 * 		um Data simples alternativo ao implementado em java. Permite a inserção de dat
 * 		em forma de int ou string
 * @author glaucoroberto
 *
 */

import java.util.GregorianCalendar;
public class Time 
{
	private int segundo;
	private int minuto;
	private int hora;
	private int dia;
	private int mes;
	private int ano;
	
	/** setTime
	 * 		recebe o valor individual de cada marcação de tempo e constroi a Data
	 * @param h - hora
	 * @param m - minuto
	 * @param s - segundo
	 * @param d - dia
	 * @param M - mês
	 * @param a - ano
	 */
	public void setTime(int h, int m, int s, int d, int M, int a)
	{
		hora	= 	((h >= 0 && h <= 24)? h : 0 );
		segundo =	( ( s >=0 && s <= 60)? s : 0);
		minuto 	= 	( ( m >= 0 && m <= 60)? m :0 );
		
		dia 	= 	checarDia(d);
		mes 	= 	((M >= 0 && M <= 12)? M : 0 );
		ano 	= 	((a >= 0 && a <= 3000)? a : 0 );
		System.out.printf("Time modificado %02d:%02d:%02d %02d/%02d/%02d.", segundo, minuto,hora,dia,mes,ano);
	}
	
	/** setTimeOfString
	 * 		recebe uma string composta por "ss/mm/hh/dd/MM/AAAA" e 
	 *		converte para int e manda para o método setTime
	 * @param nova
	 */
	public void setTimeOfString( String nova)
	{
		
		String temp;
		
		/**
		 * Por receber uma string é necessário
		 * 		converter a string para string[]
		 * 		obtendo assim cada uma das suas
		 * 		partes para atribuição. Isso é
		 * 		feito através do método .split()
		 * 		que dividi a cada vez que encontra
		 * 		uma barra
		 */
		String[] novaHora = nova.split("/");
		
		temp = String.format("%s", novaHora[0] );
		int hora = Integer.parseInt(temp);
		
		temp = String.format("%s", novaHora[1] );
		int minuto = Integer.parseInt( temp);
		
		temp = String.format("%s", novaHora[2] );
		int segundo = Integer.parseInt( temp);
		
		temp = String.format("%s", novaHora[3] );
		int dia	= Integer.parseInt( temp);
		
		temp = String.format("%s", novaHora[4] );
		int mes = Integer.parseInt( temp);
		
		temp = String.format("%s", novaHora[5] );
		int ano = Integer.parseInt( temp);
		
		setTime(segundo, minuto, hora, dia, mes, ano);
	}
	
	/** getTime
	 * 		retorna a hora da Data como string
	 * @return "hh/mm/ss"
	 */
	public String getTime()
	{		
		return String.format("%02d:%02d:%02", hora,minuto,segundo);
	}
	
	/** getTimeAM_PM
	 * 		retorna uma string com a hora formatada
	 * 
	 * @return "hh/mm/ss (AM || PM)"
	 */
	public String getTimeAM_PM()
	{
		return String.format("%02d:%02d:%02d %s", ((hora == 0 || hora == 12)? 12 : hora % 12),minuto,segundo, (hora < 12 ?  "AM":"PM"));
	}
	
	/** getData
	 * 		retorna uma string com a data
	 * @return "dd/MM/AAAA"
	 */
	public String getDate()
	{
		return String.format("%02d/%02d/%04d", dia,mes,ano);
	}
	
	/** checarDia
	 * 		checa se o dia está dentro do esperado para o mês e
	 * 		confere se está também de acordo com os anos bissestos
	 * @param dia
	 * @return dia || this.dia
	 */
	private int checarDia( int dia)
	{
		int diasPorMes[] = {0,31,28,30,31,30,31,30,31,30,31,30,31};
		if( dia > 0 && dia < diasPorMes[mes])
		{
			return dia;
		}
		
		if( mes == 2 && dia == 29 && (ano % 400 ==0 || ( ano % 4 == 0 && ano % 100 != 0)))
		{
			return dia;
		}
		System.out.printf("Dia %d não pode ser mudado para %d.\n", this.dia, dia);
		return this.dia;
	}
	
	/** getHoraAtual
	 * 		retorna a hora atual do sistema 
	 * @return
	 */
	public String getHoraAtual()
	{
		StringBuilder atual = new StringBuilder();
		String retorno;
		GregorianCalendar calendarioAtual = new GregorianCalendar();
	  
		atual.append( calendarioAtual.get( GregorianCalendar.HOUR_OF_DAY ) );
		atual.append( ":" );
		atual.append( calendarioAtual.get( GregorianCalendar.MINUTE ) );  
		atual.append( ":" );
		atual.append( calendarioAtual.get( GregorianCalendar.SECOND ) );
		atual.append( " " );
		atual.append( calendarioAtual.get( GregorianCalendar.DAY_OF_MONTH ) );
		atual.append( "/" );
		atual.append( calendarioAtual.get( GregorianCalendar.MONTH ) );
		atual.append( "/" );
		atual.append( calendarioAtual.get( GregorianCalendar.YEAR ) );
		retorno = atual.toString() ;
		return retorno;
	}
}
